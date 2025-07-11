/*
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License.
 *
 */

package com.azure.cosmos;

import com.azure.cosmos.implementation.DocumentCollection;
import com.azure.cosmos.implementation.ImplementationBridgeHelpers;
import com.azure.cosmos.implementation.RetryAnalyzer;
import com.azure.cosmos.implementation.Utils;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedMode;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedState;
import com.azure.cosmos.implementation.changefeed.common.ChangeFeedStateV1;
import com.azure.cosmos.implementation.feedranges.FeedRangeEpkImpl;
import com.azure.cosmos.implementation.feedranges.FeedRangeInternal;
import com.azure.cosmos.implementation.guava25.collect.ArrayListMultimap;
import com.azure.cosmos.implementation.guava25.collect.Multimap;
import com.azure.cosmos.implementation.query.CompositeContinuationToken;
import com.azure.cosmos.implementation.routing.Range;
import com.azure.cosmos.models.ChangeFeedPolicy;
import com.azure.cosmos.models.CosmosChangeFeedRequestOptions;
import com.azure.cosmos.models.CosmosContainerProperties;
import com.azure.cosmos.models.CosmosContainerRequestOptions;
import com.azure.cosmos.models.CosmosContainerResponse;
import com.azure.cosmos.models.CosmosItemResponse;
import com.azure.cosmos.models.FeedRange;
import com.azure.cosmos.models.ModelBridgeInternal;
import com.azure.cosmos.models.PartitionKey;
import com.azure.cosmos.models.PartitionKeyDefinition;
import com.azure.cosmos.models.PartitionKeyDefinitionVersion;
import com.azure.cosmos.rx.TestSuiteBase;
import com.azure.cosmos.test.faultinjection.CosmosFaultInjectionHelper;
import com.azure.cosmos.test.faultinjection.FaultInjectionConditionBuilder;
import com.azure.cosmos.test.faultinjection.FaultInjectionConnectionType;
import com.azure.cosmos.test.faultinjection.FaultInjectionOperationType;
import com.azure.cosmos.test.faultinjection.FaultInjectionResultBuilders;
import com.azure.cosmos.test.faultinjection.FaultInjectionRule;
import com.azure.cosmos.test.faultinjection.FaultInjectionRuleBuilder;
import com.azure.cosmos.test.faultinjection.FaultInjectionServerErrorType;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertThrows;
import static org.testng.Assert.fail;

public class CosmosContainerChangeFeedTest extends TestSuiteBase {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();
    private static final String PARTITION_KEY_FIELD_NAME = "mypk";
    private CosmosClient client;
    private CosmosAsyncContainer createdAsyncContainer;
    private CosmosAsyncDatabase createdAsyncDatabase;
    private CosmosContainer createdContainer;
    private CosmosDatabase createdDatabase;
    private final Multimap<String, ObjectNode> partitionKeyToDocuments = ArrayListMultimap.create();
    private final String preExistingDatabaseId = CosmosDatabaseForTest.generateId();

    @DataProvider(name = "changeFeedQueryCompleteAfterAvailableNowDataProvider")
    public static Object[][] changeFeedQueryCompleteAfterAvailableNowDataProvider() {
        return new Object[][]{
            // container RU, continuous ingest items
            { 400, true },
            { 400, false },
            { 11000, true },
            { 11000, false },
        };
    }

    @DataProvider(name = "changeFeedQueryEndLSNDataProvider")
    public static Object[][] changeFeedQueryEndLSNDataProvider() {
        return new Object[][]{
                // container RU, continuous ingest items
                // number of docs from cf, documents to write

                // endLSN is less than number of documents
                { 400, true, 3, 6},
                { 400, false, 3, 6},
                // endLSN is equal to number of documents
                { 400, false, 3, 3},
                // both partitions have more than the endLSN
                { 11000, true, 6, 30},
                { 11000, false, 6, 30},
        };
    }

    @DataProvider(name = "changeFeedQueryPrefetchingDataProvider")
    public static Object[][] changeFeedQueryPrefetchingDataProvider() {
        return new Object[][]{
            {ChangeFeedMode.FULL_FIDELITY},
            { ChangeFeedMode.INCREMENTAL},
        };
    }

    @DataProvider(name = "changeFeedQueryEndLSNHangDataProvider")
    public static Object[][] changeFeedQueryEndLSNHangDataProvider() {
        return new Object[][]{
                // container RU, partition count
                // number of docs from cf, documents to write

                // endLSN is greater than number of documents
                { 400, 1, 3, 2},
                // 2 partitions but only write to one, so
                // that the other partition stops on 304
                { 11000, 1, 6, 6},
                { 11000, 1, 6, 6},
        };
    }

    @DataProvider(name = "changeFeedSplitHandlingDataProvider")
    public static Object[][] changeFeedSplitHandlingDataProvider() {
        return new Object[][]{
            // Injected error type, disableSplitHandling, requestSucceeded
            { FaultInjectionServerErrorType.NAME_CACHE_IS_STALE, false, true },
            { FaultInjectionServerErrorType.NAME_CACHE_IS_STALE, true, true },
            { FaultInjectionServerErrorType.TOO_MANY_REQUEST, false, true },
            { FaultInjectionServerErrorType.TOO_MANY_REQUEST, true, true },
            { FaultInjectionServerErrorType.PARTITION_IS_GONE, false, true },
            { FaultInjectionServerErrorType.PARTITION_IS_GONE, true, false }
        };
    }

    @Factory(dataProvider = "simpleClientBuildersWithDirect")
    public CosmosContainerChangeFeedTest(CosmosClientBuilder clientBuilder) {
        super(clientBuilder);
    }

    @AfterClass(groups = { "emulator", "fast" }, timeOut = 3 * SHUTDOWN_TIMEOUT, alwaysRun = true)
    public void afterClass() {
        logger.info("starting ....");
        safeDeleteSyncDatabase(createdDatabase);
        safeCloseSyncClient(client);
    }

    @AfterMethod(groups = { "emulator", "fast" })
    public void afterTest() throws Exception {
        if (this.createdContainer != null) {
            try {
                this.createdContainer.delete();
            } catch (CosmosException error) {
                if (error.getStatusCode() != 404) {
                    throw error;
                }
            }
        }
    }

    @BeforeMethod(groups = { "emulator", "fast" })
    public void beforeTest() throws Exception {
        this.createdContainer = null;
        this.createdAsyncContainer = null;
        this.partitionKeyToDocuments.clear();
    }

    @BeforeClass(groups = { "emulator", "fast" }, timeOut = SETUP_TIMEOUT)
    public void before_CosmosContainerTest() {
        client = getClientBuilder().buildClient();
        createdDatabase = createSyncDatabase(client, preExistingDatabaseId);
        createdAsyncDatabase = client.asyncClient().getDatabase(createdDatabase.getId());
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT * 5)
    public void asyncChangeFeed_fromBeginning_incremental_forFullRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(200, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);

        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final int expectedInitialEventCount =
            200 * 7   //inserted
                + 0       // updates won't show up as extra events in incremental mode
                - 2 * 3;  // updated then deleted documents won't show up at all in incremental mode

        final int expectedEventCountAfterUpdates =
            5 * 2     // event count for initial updates
                - 1 * Math.min(2,3);   // reducing events for 2 of the 3 deleted documents
        // (because they have also had been updated)

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromBeginning(FeedRange.forFullRange());

        String continuation = drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount);

        // applying updates
        updateAction.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation);

        drainAndValidateChangeFeedResults(options, null, expectedEventCountAfterUpdates);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT )
    public void asyncChangeFeed_fromBeginning_incremental_forFullRange_withSmallPageSize() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(200, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);

        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final int expectedInitialEventCount =
            200 * 7   //inserted
            + 0       // updates won't show up as extra events in incremental mode
            - 2 * 3;  // updated then deleted documents won't show up at all in incremental mode

        final int expectedEventCountAfterUpdates =
            5 * 2     // event count for initial updates
            - 1 * Math.min(2,3);   // reducing events for 2 of the 3 deleted documents
                                   // (because they have also had been updated)

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromBeginning(FeedRange.forFullRange())
            .setMaxItemCount(10);

        String continuation = drainAndValidateChangeFeedResults(
            options,
            (o) -> o.setMaxItemCount(10),
            expectedInitialEventCount);

        // applying updates
        updateAction.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation)
            .setMaxItemCount(10);

        drainAndValidateChangeFeedResults(
            options,
            (o) -> o.setMaxItemCount(10),
            expectedEventCountAfterUpdates);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT, retryAnalyzer = RetryAnalyzer.class)
    public void asyncChangeFeed_fromBeginning_incremental_forLogicalPartition() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(20, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);
        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final Map<String, String> continuations = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            String pkValue = partitionKeyToDocuments.keySet().stream().skip(i).findFirst().get();
            logger.info(String.format("Initial validation - PK value: '%s'", pkValue));

            final int initiallyDeletedDocuments = i < 2 ? 3 : 0;
            final int expectedInitialEventCount = 7 - initiallyDeletedDocuments;

            CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
                .createForProcessingFromBeginning(
                    FeedRange.forLogicalPartition(
                        new PartitionKey(pkValue)
                    ));

            continuations.put(
                pkValue,
                drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount));
        }

        // applying updates
        updateAction.run();

        Thread.sleep(3000);

        for (int i = 0; i < 20; i++) {
            String pkValue = partitionKeyToDocuments.keySet().stream().skip(i).findFirst().get();
            logger.info(String.format("Validation after updates - PK value: '%s'", pkValue));

            final int expectedEventCountAfterUpdates = i < 5 ?
                i < 1 ? 0 : 2  // on the first logical partitions all updated documents were deleted
                : 0; // no updates

            CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
                .createForProcessingFromContinuation(continuations.get(pkValue));

            drainAndValidateChangeFeedResults(options, null, expectedEventCountAfterUpdates);
        }
    }

    @Test(groups = { "emulator" }, dataProvider = "changeFeedQueryPrefetchingDataProvider", timeOut = TIMEOUT)
    public void asyncChangeFeedPrefetching(ChangeFeedMode changeFeedMode) throws Exception {
        this.createContainer(
            (cp) -> {
                if (changeFeedMode.equals(ChangeFeedMode.INCREMENTAL)) {
                    return cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy());
                }
                return cp.setChangeFeedPolicy(ChangeFeedPolicy.createAllVersionsAndDeletesPolicy(Duration.ofMinutes(10)));
            }
        );
        CosmosChangeFeedRequestOptions options;
        if (changeFeedMode.equals(ChangeFeedMode.FULL_FIDELITY)) {
            options = CosmosChangeFeedRequestOptions
                .createForProcessingFromNow(FeedRange.forFullRange())
                .setMaxItemCount(10).allVersionsAndDeletes();
        } else {
            options = CosmosChangeFeedRequestOptions
                .createForProcessingFromBeginning(FeedRange.forFullRange()).setMaxItemCount(10);
        }
        AtomicInteger count = new AtomicInteger(0);
        insertDocuments(5, 20);
        AtomicReference<String> continuation = new AtomicReference<>("");
        createdContainer.asyncContainer.queryChangeFeed(options, ObjectNode.class).handle((r) -> {
                count.incrementAndGet();
                continuation.set(r.getContinuationToken());
            }
        ).byPage().subscribe();

        CosmosChangeFeedRequestOptions optionsFF = null;
        if (changeFeedMode.equals(ChangeFeedMode.FULL_FIDELITY)) {
            insertDocuments(5, 20);
            count.set(0);
            optionsFF = CosmosChangeFeedRequestOptions
                .createForProcessingFromContinuation(continuation.get())
                .setMaxItemCount(10).allVersionsAndDeletes();
            createdContainer.asyncContainer.queryChangeFeed(optionsFF, ObjectNode.class).handle((r) -> {
                count.incrementAndGet();
                continuation.set(r.getContinuationToken());
            }
        ).byPage().subscribe();
        }
        Thread.sleep(3000);
        assertThat(count.get()).isGreaterThan(2);

        if (changeFeedMode.equals(ChangeFeedMode.FULL_FIDELITY)) {
            // full fidelity is only from now so need to insert more documents
            insertDocuments(5, 20);
        }
        count.set(0);
        // should only get two pages
        createdContainer.asyncContainer.queryChangeFeed(changeFeedMode.equals(ChangeFeedMode.FULL_FIDELITY)? optionsFF
            : options, ObjectNode.class).handle((r) -> count.incrementAndGet())
            .byPage().take(2, true).subscribe();
        Thread.sleep(3000);
        assertThat(count.get()).isEqualTo(2);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromBeginning_incremental_forEPK() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(20, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);
        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final Map<String, String> continuations = new HashMap<>();

        for (int i = 0; i < 20; i++) {
            String pkValue = partitionKeyToDocuments.keySet().stream().skip(i).findFirst().get();
            logger.info(String.format("Initial validation - PK value: '%s'", pkValue));

            final int initiallyDeletedDocuments = i < 2 ? 3 : 0;
            final int expectedInitialEventCount = 7 - initiallyDeletedDocuments;

            FeedRangeInternal feedRangeForLogicalPartition =
                (FeedRangeInternal)FeedRange.forLogicalPartition(new PartitionKey(pkValue));
            Utils.ValueHolder<DocumentCollection> documentCollection = client
                .asyncClient()
                .getContextClient()
                .getCollectionCache()
                .resolveByRidAsync(
                    null,
                    createdContainer.read().getProperties().getResourceId(),
                    null)
                .block();

            Range<String> effectiveRange = feedRangeForLogicalPartition
                .getNormalizedEffectiveRange(
                    client.asyncClient().getContextClient().getPartitionKeyRangeCache(),
                    null,
                    Mono.just(documentCollection))
                .block();

            assertThat(effectiveRange).isNotNull();

            FeedRange feedRange = new FeedRangeEpkImpl(effectiveRange);

            CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
                .createForProcessingFromBeginning(feedRange);

            continuations.put(
                pkValue,
                drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount));
        }

        // applying updates
        updateAction.run();

        for (int i = 0; i < 20; i++) {
            String pkValue = partitionKeyToDocuments.keySet().stream().skip(i).findFirst().get();
            logger.info(String.format("Validation after updates - PK value: '%s'", pkValue));

            final int expectedEventCountAfterUpdates = i < 5 ?
                i < 1 ? 0 : 2  // on the first logical partitions all updated documents were deleted
                : 0; // no updates

            CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
                .createForProcessingFromContinuation(continuations.get(pkValue));

            drainAndValidateChangeFeedResults(options, null, expectedEventCountAfterUpdates);
        }
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromBeginning_incremental_forFeedRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(200, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);
        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final int expectedTotalInitialEventCount =
            200 * 7   //inserted
                + 0       // updates won't show up as extra events in incremental mode
                - 2 * 3;  // updated then deleted documents won't show up at all in incremental mode

        final int expectedTotalEventCountAfterUpdates =
            5 * 2     // event count for initial updates
                - 1 * Math.min(2,3);   // reducing events for 2 of the 3 deleted documents
        // (because they have also had been updated)

        List<FeedRange> feedRanges = createdContainer.getFeedRanges();
        List<CosmosChangeFeedRequestOptions> options = new ArrayList<>();

        for (int i = 0; i < feedRanges.size(); i++) {
            options.add(CosmosChangeFeedRequestOptions
                .createForProcessingFromBeginning(feedRanges.get(i)));
        }

        final Map<Integer, String> continuations = drainAndValidateChangeFeedResults(
            options,
            null,
            expectedTotalInitialEventCount);

        // applying updates
        updateAction.run();

        options.clear();
        for (int i = 0; i < feedRanges.size(); i++) {
            options.add(CosmosChangeFeedRequestOptions
                .createForProcessingFromContinuation(continuations.get(i)));
        }

        drainAndValidateChangeFeedResults(options, null, expectedTotalEventCountAfterUpdates);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromBeginning_fullFidelity_forFullRange() throws Exception {
        assertThrows(
            IllegalStateException.class,
            () -> CosmosChangeFeedRequestOptions
                .createForProcessingFromBeginning(FeedRange.forFullRange())
                .allVersionsAndDeletes());
    }


    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromNow_incremental_forFullRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(20, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);

        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(2, 3);
            insertDocuments(100, 5);
        };

        final int expectedInitialEventCount = 0;

        final int expectedEventCountAfterUpdates =
                5 * 2               // event count for updates
            -   (2 * Math.min(2,3)) // reducing events for 2 of the 3 deleted documents
                                    // (because they have also had been updated) on each of the two
                                    // partitions documents are deleted from
            + 100 * 5;              // event count for inserts

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromNow(FeedRange.forFullRange());


        String continuation = drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount);

        // applying updates
        updateAction.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation);

        drainAndValidateChangeFeedResults(options, null, expectedEventCountAfterUpdates);
    }

    //TODO Temporarily disabling
    @Test(groups = { "emulator" }, timeOut = TIMEOUT, enabled = false)
    public void asyncChangeFeed_fromNow_fullFidelity_forFullRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createAllVersionsAndDeletesPolicy(Duration.ofMinutes(10)))
        );
        insertDocuments(8, 15);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);

        Runnable updateAction1 = () -> {
            insertDocuments(5, 9);
            updateDocuments(3, 5);
            deleteDocuments(2, 3);
        };

        Runnable updateAction2 = () -> {
            updateDocuments(5, 2);
            deleteDocuments(2, 3);
            insertDocuments(10, 5);
        };

        final int expectedInitialEventCount = 0;

        final int expectedEventCountAfterFirstSetOfUpdates =
              5 * 9       // events for inserts
            + 3 * 5       // event count for updates
            + 2 * 3;      // plus deletes (which are all included in FF CF)

        final int expectedEventCountAfterSecondSetOfUpdates =
           10 * 5         // events for inserts
          + 5 * 2         // event count for updates
          + 2 * 3;        // plus deletes (which are all included in FF CF)

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromNow(FeedRange.forFullRange());


        String continuation = drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount);

        // applying first set of  updates
        updateAction1.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation);

        continuation = drainAndValidateChangeFeedResults(
            options,
            null,
            expectedEventCountAfterFirstSetOfUpdates);

        // applying first set of  updates
        updateAction2.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation);

        drainAndValidateChangeFeedResults(
            options,
            null,
            expectedEventCountAfterSecondSetOfUpdates);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromPointInTime_incremental_forFullRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(20, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);

        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final int expectedInitialEventCount =
             20 * 7   //inserted
                + 0       // updates won't show up as extra events in incremental mode
                - 2 * 3;  // updated then deleted documents won't show up at all in incremental mode

        final int expectedEventCountAfterUpdates =
              5 * 2              // event count for initial updates
            - 1 * Math.min(2,3); // reducing events for 2 of the 3 deleted documents
                                 // (because they have also had been updated)

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromPointInTime(
                Instant.now().minus(10, ChronoUnit.SECONDS),
                FeedRange.forFullRange());

        Thread.sleep(1000);

        String continuation = drainAndValidateChangeFeedResults(options, null, expectedInitialEventCount);

        // applying updates
        updateAction.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation);

        drainAndValidateChangeFeedResults(options, null, expectedEventCountAfterUpdates);
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void asyncChangeFeed_fromPointInTime_fullFidelity_forFullRange() throws Exception {
        assertThrows(
            IllegalStateException.class,
            () -> CosmosChangeFeedRequestOptions
                .createForProcessingFromPointInTime(
                    Instant.now().minus(10, ChronoUnit.SECONDS),
                    FeedRange.forFullRange())
                .allVersionsAndDeletes());
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void syncChangeFeed_fromBeginning_incremental_forFullRange() throws Exception {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        insertDocuments(200, 7);
        updateDocuments(3, 5);
        deleteDocuments(2, 3);
        Runnable updateAction = () -> {
            updateDocuments(5, 2);
            deleteDocuments(1, 3);
        };

        final int expectedInitialEventCount =
            200 * 7   //inserted
                + 0       // updates won't show up as extra events in incremental mode
                - 2 * 3;  // updated then deleted documents won't show up at all in incremental mode

        final int expectedEventCountAfterUpdates =
            5 * 2     // event count for initial updates
                - 1 * Math.min(2,3);   // reducing events for 2 of the 3 deleted documents
        // (because they have also had been updated)

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromBeginning(FeedRange.forFullRange());

        AtomicReference<String> continuation = new AtomicReference<>();
        List<ObjectNode> results = createdContainer
                    .queryChangeFeed(options, ObjectNode.class)
                    // NOTE - in real app you would need delaying persisting the
                    // continuation until you retrieve the next one
                    .handle((r) -> continuation.set(r.getContinuationToken()))
                    .stream()
                    .collect(Collectors.toList());

        assertThat(results)
            .isNotNull()
            .size()
            .isEqualTo(expectedInitialEventCount);

        // applying updates
        updateAction.run();

        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(continuation.get());
        results = createdContainer
            .queryChangeFeed(options, ObjectNode.class)
            // NOTE - in real app you would need delaying persisting the
            // continuation until you retrieve the next one
            .handle((r) -> continuation.set(r.getContinuationToken()))
            .stream()
            .collect(Collectors.toList());

        assertThat(results)
            .isNotNull()
            .size()
            .isEqualTo(expectedEventCountAfterUpdates);
    }

    @Test(groups = { "emulator" }, dataProvider = "changeFeedSplitHandlingDataProvider", timeOut = 2 * TIMEOUT)
    public void asyncChangeFeed_retryPolicy_tests(
        FaultInjectionServerErrorType faultInjectionServerErrorType,
        boolean disableSplitHandling,
        boolean requestSucceeded) {
        this.createContainer(
            (cp) -> cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy())
        );
        int documentCount = 10;
        insertDocuments(1, documentCount);

        FaultInjectionConditionBuilder faultInjectionCondition = new FaultInjectionConditionBuilder()
            .operationType(FaultInjectionOperationType.READ_FEED_ITEM);
        if (this.getClientBuilder().getConnectionPolicy().getConnectionMode() == ConnectionMode.GATEWAY) {
            faultInjectionCondition.connectionType(FaultInjectionConnectionType.GATEWAY);
        }

        FaultInjectionRule faultInjectionRule =
            new FaultInjectionRuleBuilder("changeFeed_retry_" + UUID.randomUUID() + "_" + faultInjectionServerErrorType.toString())
                .condition(faultInjectionCondition.build())
                .result(
                    FaultInjectionResultBuilders
                        .getResultBuilder(faultInjectionServerErrorType)
                        .times(1)
                        .build()
                )
                .build();

        CosmosFaultInjectionHelper.configureFaultInjectionRules(this.createdAsyncContainer, Arrays.asList(faultInjectionRule)).block();

        List<FeedRange> feedRanges = this.createdAsyncContainer.getFeedRanges().block();
        // make sure to only use 1 feed range here, else when disableSplitHandling being true, 410/1002 will be returned
        CosmosChangeFeedRequestOptions changeFeedRequestOptions =
            CosmosChangeFeedRequestOptions.createForProcessingFromBeginning(feedRanges.get(0));
        if (disableSplitHandling) {
            ModelBridgeInternal.disableSplitHandling(changeFeedRequestOptions);
        }

        try {
            createdContainer
                .queryChangeFeed(changeFeedRequestOptions, ObjectNode.class)
                .stream()
                .collect(Collectors.toList());

            if (!requestSucceeded) {
                fail("ChangeFeed request should fail due to " + faultInjectionServerErrorType + " injected");
            }

        } catch (Exception e) {
            if (requestSucceeded) {
                fail("ChangeFeed request should have succeeded even " + faultInjectionServerErrorType + " injected");
            }
        } finally {
            faultInjectionRule.disable();
        }
    }

    @Test(groups = { "emulator" }, timeOut = TIMEOUT)
    public void split_only_notModified() throws Exception {
        // This test is used to reproduce and regression test a bug identified in the split handling
        // Background
        // Container.queryChangeFeed can result in hang when a continuation token consists of multiple sub-ranges,
        // there are no more change for any of the sub-ranges, but a split is happening on the first sub-range after
        // the sub-range where we saw a 304 the first time.
        // This effectively results in an endless-loop because we identify whether all sub-ranges are drained by
        // capturing teh first subrange we see a 304 on and then loop through sub-ranges until we hit the same
        // subrange without seeing anything but 304. When there is an even number of sub-ranges and a to-be-split
        // sub-range is the last one - we never exit the loop after the split.
        // This test is reproducing this edge case - and used both to validate the hotfix and to protect against
        // regressing the scenario again.
        //
        // SAMPLE CONTINUATION TOKEN
        // {
        //    "V": 1,
        //    "Rid": "0xljAKk+nBE=",
        //    "Mode": "INCREMENTAL",
        //    "StartFrom": {
        //        "Type": "NOW"
        //    },
        //    "Continuation": {
        //        "V": 1,
        //        "Rid": "0xljAKk+nBE=",
        //        "Continuation": [
        //            {
        //                "token": "\"46037\"",
        //                "range": {
        //                    "min": "",
        //                    "max": "15555555555555555555555555555555"
        //                }
        //            },
        //            {
        //                "token": "\"9223372036854775797\"",
        //                "range": {
        //                    "min": "15555555555555555555555555555555",
        //                    "max": "FF"
        //                }
        //            }
        //        ],
        //        "Range": {
        //            "min": "",
        //            "max": "FF"
        //        }
        //    }
        // }
        //
        // SEQUENCE OF EVENTS
        // - CF request for first sub-range returns 304 - now we have a bug where we capture the next sub-ranges MIN
        //   range as the first one (doesn't really matter - we eventually just want to ensure we visited any subrange
        //   and all return 304)
        // - So, FeedRangeCompositeContinuationImpl.initialNoResultsRange is set to the MinRange of the second
        //   sub-range, which is to-be-split
        // - Split is processed and instead of the parent range two new child ranges are added at the end
        // - Another bug currently is that we don't go to the next sub-range but the next-thereafter. So, the child
        //   sub-range starting with the MinRange of the parent range (in position 1) is skipped
        // - Since we always move to the second-next (and peek to the third token), we now have three sub-ranges
        //   and only ever send CF requests for one sub-range in an endless loop.

        this.createContainer(
            (cp) -> {

                // Ensuring we always use Hash V2 here
                PartitionKeyDefinition partitionKeyDef = new PartitionKeyDefinition();
                ArrayList<String> paths = new ArrayList<>();
                paths.add("/mypk");
                partitionKeyDef.setPaths(paths);
                partitionKeyDef.setVersion(PartitionKeyDefinitionVersion.V2);
                cp.setPartitionKeyDefinition(partitionKeyDef);

                // To reproduce easily we need at least 3 physical partitions
                return cp.setChangeFeedPolicy(ChangeFeedPolicy.createLatestVersionPolicy());
            },
            18_000
        );
        insertDocuments(20, 7);

        CosmosChangeFeedRequestOptions options = CosmosChangeFeedRequestOptions
            .createForProcessingFromNow(FeedRange.forFullRange());

        String continuation = drainAndValidateChangeFeedResults(options, null, 0);
        ChangeFeedState stateRaw = ChangeFeedState.fromString(continuation);
        assertThat(stateRaw).isNotNull();
        assertThat(stateRaw).isInstanceOf(ChangeFeedStateV1.class);
        ChangeFeedStateV1 state = (ChangeFeedStateV1)stateRaw;
        assertThat(state.getContinuation()).isNotNull();
        assertThat(state.getContinuation().getCompositeContinuationTokens()).isNotNull();

        logger.info("Continuation token after first iteration {}", state.toJson());

        Queue<CompositeContinuationToken> tokens = state.getContinuation().getCompositeContinuationTokens();
        assertThat(tokens).isNotNull();

        // Validate that we don't clone the tokens in the property getter - otherwise the test code below wouldn't work.
        assertThat(tokens).isSameAs(state.getContinuation().getCompositeContinuationTokens());

        assertThat(tokens).hasSize(3);

        List<CompositeContinuationToken> tokenList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tokenList.add(tokens.poll());
        }

        tokenList.sort(Comparator.comparing(o -> o.getRange().getMin()));

        CompositeContinuationToken firstToken = tokenList.get(0);
        assertThat(firstToken).isNotNull();

        CompositeContinuationToken secondToken = tokenList.get(1);
        assertThat(secondToken).isNotNull();

        CompositeContinuationToken thirdToken = tokenList.get(2);
        assertThat(thirdToken).isNotNull();

        assertThat(secondToken.getRange().getMax()).isEqualTo(thirdToken.getRange().getMin());

        assertThat(tokens).hasSize(0);

        // Add the first two tokens as is
        tokens.add(firstToken);

        // generate a merged token for 3rd and 4th partition
        String newToken = "\"" + (Long.MAX_VALUE - 10L) + "\"";
        CompositeContinuationToken newMergedToken = new CompositeContinuationToken(
            newToken,
            new Range<>(
                secondToken.getRange().getMin(),
                thirdToken.getRange().getMax(),
                true,
                false)
        );

        tokens.add(newMergedToken);

        // Add the second and third token after the merged one - this is necessary to make sure the
        // next token after hitting 304 on the merged token is not the first child sub-range
        // then the hang would not be reproducible
        //tokens.add(secondToken);

        logger.info("New modified continuation to provoke the hang {}", state.toJson());

        assertThat(state.getContinuation().getCompositeContinuationTokens()).hasSize(2);
        options = CosmosChangeFeedRequestOptions
            .createForProcessingFromContinuation(state.toString());

        String continuationAfterLastDrainAttempt =
            drainAndValidateChangeFeedResults(options, null, 0);
        ChangeFeedState stateAfterLastDrainAttemptRaw = ChangeFeedState.fromString(continuationAfterLastDrainAttempt);
        assertThat(stateAfterLastDrainAttemptRaw).isNotNull();
        assertThat(stateAfterLastDrainAttemptRaw).isInstanceOf(ChangeFeedStateV1.class);
        ChangeFeedStateV1 stateAfterLastDrainAttempt = (ChangeFeedStateV1)stateAfterLastDrainAttemptRaw;
        assertThat(stateAfterLastDrainAttempt.getContinuation()).isNotNull();
        assertThat(stateAfterLastDrainAttempt.getContinuation().getCompositeContinuationTokens()).isNotNull();
        assertThat(stateAfterLastDrainAttempt.getContinuation().getCompositeContinuationTokens()).hasSize(3);
    }

    @Test(groups = { "fast" }, dataProvider = "changeFeedQueryEndLSNDataProvider", timeOut = 100 * TIMEOUT)
    public void changeFeedQueryCompleteAfterEndLSN(
        int throughput,
        boolean shouldContinuouslyIngestItems,
        int expectedDocs,
        int docsToWrite) {
        String testContainerId = UUID.randomUUID().toString();

        try {
            CosmosContainerProperties containerProperties = new CosmosContainerProperties(testContainerId, "/mypk");
            CosmosAsyncContainer testContainer =
                createCollection(
                    this.createdAsyncDatabase,
                    containerProperties,
                    new CosmosContainerRequestOptions(),
                    throughput);

            List<FeedRange> feedRanges = testContainer.getFeedRanges().block();
            AtomicInteger currentPageCount = new AtomicInteger(0);

            List<String> partitionKeys = insertDocumentsIntoTwoPartitions(docsToWrite, testContainer);
            CosmosChangeFeedRequestOptions cosmosChangeFeedRequestOptions =
                CosmosChangeFeedRequestOptions.createForProcessingFromBeginning(FeedRange.forFullRange());
            ImplementationBridgeHelpers.CosmosChangeFeedRequestOptionsHelper.getCosmosChangeFeedRequestOptionsAccessor()
                .setEndLSN(cosmosChangeFeedRequestOptions, 4L);
            cosmosChangeFeedRequestOptions.setMaxPrefetchPageCount(8);

            AtomicInteger totalQueryCount = new AtomicInteger(0);
            testContainer.queryChangeFeed(cosmosChangeFeedRequestOptions, JsonNode.class)
                .byPage(1)
                .flatMap(response -> {
                    int currentPage = currentPageCount.incrementAndGet();
                    totalQueryCount.set(totalQueryCount.get() + response.getResults().size());

                    // Only start creating new items once we have looped through all feedRanges once to make the test behavior more deterministic
                    if (shouldContinuouslyIngestItems && currentPage >= feedRanges.size()) {
                        // Only keep adding to partitions that already have items in them
                        // again to make the test behavior more deterministic
                        return testContainer
                            .createItem(getDocumentDefinition(partitionKeys.get(currentPage % 1))).then();
                    } else {
                        return Mono.empty();
                    }
                })
                .blockLast();
            assertThat(totalQueryCount.get()).isEqualTo(expectedDocs);
        } finally {
            safeDeleteCollection(this.createdAsyncDatabase.getContainer(testContainerId));
        }
    }

    @Test(groups = { "fast" }, dataProvider = "changeFeedQueryEndLSNHangDataProvider", timeOut = 100 * TIMEOUT, retryAnalyzer = FlakyTestRetryAnalyzer.class)
    public void changeFeedQueryCompleteAfterEndLSNHang(
            int throughput,
            int partitionCount,
            int expectedDocs,
            int docsToWrite) throws InterruptedException {
        String testContainerId = UUID.randomUUID().toString();

        try {
            CosmosContainerProperties containerProperties = new CosmosContainerProperties(testContainerId, "/mypk");
            CosmosAsyncContainer testContainer =
                    createCollection(
                            this.createdAsyncDatabase,
                            containerProperties,
                            new CosmosContainerRequestOptions(),
                            throughput);


            insertDocuments(partitionCount, docsToWrite, testContainer);
            CosmosChangeFeedRequestOptions cosmosChangeFeedRequestOptions =
                    CosmosChangeFeedRequestOptions.createForProcessingFromBeginning(FeedRange.forFullRange());
            ImplementationBridgeHelpers.CosmosChangeFeedRequestOptionsHelper.getCosmosChangeFeedRequestOptionsAccessor()
                    .setEndLSN(cosmosChangeFeedRequestOptions, 4L);
            cosmosChangeFeedRequestOptions.setMaxPrefetchPageCount(8);

            AtomicInteger totalQueryCount = new AtomicInteger(0);
            ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

            Future<Void> future = CompletableFuture.runAsync(() -> {
                testContainer.queryChangeFeed(cosmosChangeFeedRequestOptions, JsonNode.class)
                        .byPage(1)
                        .flatMap(response -> {
                            totalQueryCount.set(totalQueryCount.get() + response.getResults().size());

                           return Mono.empty();
                        }).blockLast();
            }, scheduler);

            Thread.sleep(2000);
            assertThat(future.isDone()).isFalse();

           insertDocuments(10, 25, testContainer);
           assertThat(future.isDone()).isTrue();


            assertThat(totalQueryCount.get()).isEqualTo(expectedDocs);
        } finally {
            safeDeleteCollection(this.createdAsyncDatabase.getContainer(testContainerId));
        }
    }

    @Test(groups = { "emulator" }, dataProvider = "changeFeedQueryCompleteAfterAvailableNowDataProvider", timeOut = 100 * TIMEOUT)
    public void changeFeedQueryCompleteAfterAvailableNow(
        int throughput,
        boolean shouldContinuouslyIngestItems) {
        String testContainerId = UUID.randomUUID().toString();

        try {
            CosmosContainerProperties containerProperties = new CosmosContainerProperties(testContainerId, "/mypk");
            CosmosAsyncContainer testContainer =
                createCollection(
                    this.createdAsyncDatabase,
                    containerProperties,
                    new CosmosContainerRequestOptions(),
                    throughput);

            List<FeedRange> feedRanges = testContainer.getFeedRanges().block();
            AtomicInteger currentPageCount = new AtomicInteger(0);

            insertDocuments(1, 5, testContainer);
            CosmosChangeFeedRequestOptions cosmosChangeFeedRequestOptions =
                CosmosChangeFeedRequestOptions.createForProcessingFromBeginning(FeedRange.forFullRange());

            cosmosChangeFeedRequestOptions.setCompleteAfterAllCurrentChangesRetrieved(true);
            AtomicInteger totalQueryCount = new AtomicInteger(0);
            testContainer.queryChangeFeed(cosmosChangeFeedRequestOptions, JsonNode.class)
                .byPage(1)
                .flatMap(response -> {
                    int currentPage = currentPageCount.incrementAndGet();
                    totalQueryCount.set(totalQueryCount.get() + response.getResults().size());

                    // Only start creating new items once we have looped through all feedRanges once to make the test behavior more deterministic
                    if (shouldContinuouslyIngestItems && currentPage >= feedRanges.size()) {
                        return testContainer
                            .createItem(getDocumentDefinition(UUID.randomUUID().toString())).then();
                    } else {
                        return Mono.empty();
                    }
                })
                .blockLast();

            assertThat(totalQueryCount.get()).isEqualTo(5);
        } finally {
            safeDeleteCollection(this.createdAsyncDatabase.getContainer(testContainerId));
        }
    }

    void insertDocuments(
        int partitionCount,
        int documentCount) {

        insertDocuments(partitionCount, documentCount, this.createdAsyncContainer);
    }

    void insertDocuments(
        int partitionCount,
        int documentCount,
        CosmosAsyncContainer container) {
       insertDocumentsCore(partitionCount, documentCount, container);
    }

    List<String> insertDocumentsCore(
            int partitionCount,
            int documentCount,
            CosmosAsyncContainer container) {

        List<ObjectNode> docs = new ArrayList<>();
        List<String> partitionKeys = new ArrayList<>();

        for (int i = 0; i < partitionCount; i++) {
            String partitionKey = UUID.randomUUID().toString();
            for (int j = 0; j < documentCount; j++) {
                docs.add(getDocumentDefinition(partitionKey));
            }
            partitionKeys.add(partitionKey);
        }

        ArrayList<Mono<CosmosItemResponse<ObjectNode>>> result = new ArrayList<>();
        for (int i = 0; i < docs.size(); i++) {
            result.add(container.createItem(docs.get(i)));
        }

        List<ObjectNode> insertedDocs = Flux.merge(
                        Flux.fromIterable(result),
                        2)
                .map(CosmosItemResponse::getItem).collectList().block();

        for (ObjectNode doc : insertedDocs) {
            partitionKeyToDocuments.put(
                    doc.get(PARTITION_KEY_FIELD_NAME).textValue(),
                    doc);
        }
        logger.info("FINISHED INSERT");
        return partitionKeys;
    }

    List<String> insertDocumentsIntoTwoPartitions(
            int documentCount,
            CosmosAsyncContainer container) {

        List<ObjectNode> docs = new ArrayList<>();
        List<String> partitionKeys = new ArrayList<>();

        // these partition keys will land on two different partitions for hash v2
        String partitionKey1 = "pk-1";
        String partitionKey2 = "pk-8fbakldbas";
        for (int j = 0; j < documentCount; j++) {
            docs.add(getDocumentDefinition(partitionKey1));
            docs.add(getDocumentDefinition(partitionKey2));
        }
        partitionKeys.add(partitionKey1);
        partitionKeys.add(partitionKey2);

        ArrayList<Mono<CosmosItemResponse<ObjectNode>>> result = new ArrayList<>();
        for (ObjectNode jsonNodes : docs) {
            result.add(container.createItem(jsonNodes));
        }

        List<ObjectNode> insertedDocs = Flux.merge(
                        Flux.fromIterable(result),
                        2)
                .map(CosmosItemResponse::getItem).collectList().block();

        for (ObjectNode doc : insertedDocs) {
            partitionKeyToDocuments.put(
                    doc.get(PARTITION_KEY_FIELD_NAME).textValue(),
                    doc);
        }
        logger.info("FINISHED INSERT");
        return partitionKeys;
    }

    void deleteDocuments(
        int partitionCount,
        int documentCount) {

        assertThat(partitionCount)
            .isLessThanOrEqualTo(this.partitionKeyToDocuments.keySet().size());

        Collection<ObjectNode> docs;
        for (int i = 0; i < partitionCount; i++) {
            String partitionKey = this.partitionKeyToDocuments
                .keySet()
                .stream()
                .skip(i)
                .findFirst()
                .get();

            docs = this.partitionKeyToDocuments.get(partitionKey);
            assertThat(docs)
                .isNotNull()
                .size()
                .isGreaterThanOrEqualTo(documentCount);

            for (int j = 0; j < documentCount; j++) {
                ObjectNode docToBeDeleted = docs.stream().findFirst().get();
                createdContainer.deleteItem(docToBeDeleted, null);
                docs.remove(docToBeDeleted);
            }
        }
    }

    void updateDocuments(
        int partitionCount,
        int documentCount) {

        assertThat(partitionCount)
            .isLessThanOrEqualTo(this.partitionKeyToDocuments.keySet().size());

        Collection<ObjectNode> docs;
        for (int i = 0; i < partitionCount; i++) {
            String partitionKey = this.partitionKeyToDocuments
                .keySet()
                .stream()
                .skip(i)
                .findFirst()
                .get();

            docs = this.partitionKeyToDocuments.get(partitionKey);
            assertThat(docs)
                .isNotNull()
                .size()
                .isGreaterThanOrEqualTo(documentCount);

            for (int j = 0; j < documentCount; j++) {
                ObjectNode docToBeUpdated = docs.stream().skip(j).findFirst().get();
                docToBeUpdated.put("someProperty", UUID.randomUUID().toString());
                createdContainer.replaceItem(
                    docToBeUpdated,
                    docToBeUpdated.get("id").textValue(),
                    new PartitionKey(docToBeUpdated.get("mypk").textValue()),
                    null);
            }
        }
    }

    private String drainAndValidateChangeFeedResults(
        CosmosChangeFeedRequestOptions changeFeedRequestOptions,
        Function<CosmosChangeFeedRequestOptions, CosmosChangeFeedRequestOptions> onNewRequestOptions,
        int expectedEventCount) {

        return drainAndValidateChangeFeedResults(
            Arrays.asList(changeFeedRequestOptions),
            onNewRequestOptions,
            expectedEventCount).get(0);
    }

    private Map<Integer, String> drainAndValidateChangeFeedResults(
        List<CosmosChangeFeedRequestOptions> changeFeedRequestOptions,
        Function<CosmosChangeFeedRequestOptions, CosmosChangeFeedRequestOptions> onNewRequestOptions,
        int expectedTotalEventCount) {

        Map<Integer, String> continuations = new HashMap<>();

        int totalRetrievedEventCount = 0;

        boolean isFinished = false;
        int emptyResultCount = 0;

        while (!isFinished) {
            for (Integer i = 0; i < changeFeedRequestOptions.size(); i++) {
                List<ObjectNode> results;

                CosmosChangeFeedRequestOptions effectiveOptions;
                if (continuations.containsKey(i)) {
                    logger.info(String.format(
                        "Continuation BEFORE: %s",
                        new String(
                            Base64.getUrlDecoder().decode(continuations.get(i)),
                            StandardCharsets.UTF_8)));
                    effectiveOptions = CosmosChangeFeedRequestOptions
                        .createForProcessingFromContinuation(continuations.get(i));
                    if (onNewRequestOptions != null) {
                        effectiveOptions = onNewRequestOptions.apply(effectiveOptions);
                    }
                } else {
                    effectiveOptions = changeFeedRequestOptions.get(i);
                }

                final Integer index = i;
                results = createdAsyncContainer
                    .queryChangeFeed(effectiveOptions, ObjectNode.class)
                    // NOTE - in real app you would need delaying persisting the
                    // continuation until you retrieve the next one
                    .handle((r) -> continuations.put(index, r.getContinuationToken()))
                    .collectList()
                    .block();

                logger.info(
                    String.format(
                        "Continuation AFTER: %s, records retrieved: %d",
                        new String(
                            Base64.getUrlDecoder().decode(continuations.get(i)),
                            StandardCharsets.UTF_8),
                        results.size()));

                totalRetrievedEventCount += results.size();
                if (totalRetrievedEventCount >= expectedTotalEventCount) {
                    isFinished = true;
                    break;
                }

                if (results.size() == 0) {
                    emptyResultCount += 1;

                    assertThat(emptyResultCount).isLessThan(6 * changeFeedRequestOptions.size());
                    logger.info(
                        String.format("Not all expected events retrieved yet. Retrieved %d out of " +
                            "expected %d events. Retrying... Retry count: %d",
                            totalRetrievedEventCount,
                            expectedTotalEventCount,
                            emptyResultCount));

                    try {
                        Thread.sleep(1000 / changeFeedRequestOptions.size());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    emptyResultCount = 0;
                }

            }
        }

        assertThat(totalRetrievedEventCount)
            .isEqualTo(expectedTotalEventCount);

        return continuations;
    }

    private Range<String> convertToMaxExclusive(Range<String> maxInclusiveRange) {
        assertThat(maxInclusiveRange)
            .isNotNull()
            .matches(r -> r.isMaxInclusive(), "Ensure isMaxInclusive is set");

        String max = maxInclusiveRange.getMax();
        int i = max.length() - 1;

        while (i >= 0) {
            if (max.charAt(i) == 'F') {
                i--;
                continue;
            }

            char newChar = (char)(((int)max.charAt(i))+1);

            if (i < max.length() - 1) {
                max = max.substring(0, i) + newChar + max.substring(i + 1);
            } else {
                max = max.substring(0, i) + newChar;
            }

            break;
        }

        return new Range<>(maxInclusiveRange.getMin(), max, true, false);
    }

    private void createContainer(
        Function<CosmosContainerProperties, CosmosContainerProperties> onInitialization) {

        createContainer(onInitialization, 10100);
    }

    private void createContainer(
        Function<CosmosContainerProperties, CosmosContainerProperties> onInitialization,
        int throughput) {

        String collectionName = UUID.randomUUID().toString();
        CosmosContainerProperties containerProperties = getCollectionDefinition(collectionName);

        if (onInitialization != null) {
            containerProperties = onInitialization.apply(containerProperties);
        }

        CosmosContainerResponse containerResponse =
            createdDatabase.createContainer(containerProperties, throughput, null);
        assertThat(containerResponse.getRequestCharge()).isGreaterThan(0);
        validateContainerResponse(containerProperties, containerResponse);

        this.createdContainer = createdDatabase.getContainer(collectionName);
        this.createdAsyncContainer = createdAsyncDatabase.getContainer(collectionName);
    }

    private static ObjectNode getDocumentDefinition(String partitionKey) {
        String uuid = UUID.randomUUID().toString();
        String json = String.format("{ "
                + "\"id\": \"%s\", "
                + "\"mypk\": \"%s\", "
                + "\"prop\": \"%s\""
                + "}"
            , uuid, partitionKey, uuid);

        try {
            return
                OBJECT_MAPPER.readValue(json, ObjectNode.class);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            throw new IllegalArgumentException("Invalid partition key value provided.");
        }
    }

    private void validateContainerResponse(CosmosContainerProperties containerProperties,
                                           CosmosContainerResponse createResponse) {
        // Basic validation
        assertThat(createResponse.getProperties().getId()).isNotNull();
        assertThat(createResponse.getProperties().getId())
            .as("check Resource Id")
            .isEqualTo(containerProperties.getId());

    }
}
