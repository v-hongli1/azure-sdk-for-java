// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.metricsadvisor;

import com.azure.ai.metricsadvisor.models.DimensionKey;
import com.azure.ai.metricsadvisor.models.FeedbackQueryTimeMode;
import com.azure.ai.metricsadvisor.models.FeedbackType;
import com.azure.ai.metricsadvisor.models.ListMetricFeedbackFilter;
import com.azure.ai.metricsadvisor.models.ListMetricFeedbackOptions;
import com.azure.ai.metricsadvisor.models.MetricFeedback;
import com.azure.core.http.HttpClient;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import reactor.test.StepVerifier;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import static com.azure.ai.metricsadvisor.MetricsSeriesTestBase.METRIC_ID;
import static com.azure.ai.metricsadvisor.TestUtils.DISPLAY_NAME_WITH_ARGUMENTS;
import static com.azure.ai.metricsadvisor.TestUtils.INCORRECT_UUID;
import static com.azure.ai.metricsadvisor.TestUtils.INCORRECT_UUID_ERROR;
import static com.azure.ai.metricsadvisor.models.FeedbackType.ANOMALY;
import static com.azure.ai.metricsadvisor.models.FeedbackType.CHANGE_POINT;
import static com.azure.ai.metricsadvisor.models.FeedbackType.COMMENT;
import static com.azure.ai.metricsadvisor.models.FeedbackType.PERIOD;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FeedbackAsyncTest extends FeedbackTestBase {
    private MetricsAdvisorAsyncClient client;

    /**
     * Verifies the result of the list metric feedback  method when no options specified.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    void testListMetricFeedback(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();

        listMetricFeedbackRunner(inputMetricFeedbackList -> {
            List<MetricFeedback> actualMetricFeedbackList = new ArrayList<>();
            List<MetricFeedback> expectedMetricFeedbackList = inputMetricFeedbackList.stream()
                .map(metricFeedback -> client.addFeedback(METRIC_ID, metricFeedback).block())
                .collect(Collectors.toList());

            final MetricFeedback firstFeedback = expectedMetricFeedbackList.get(0);
            final OffsetDateTime firstFeedbackCreatedTime = firstFeedback.getCreatedTime();

            // Act
            StepVerifier
                .create(
                    client
                        .listFeedback(METRIC_ID,
                            new ListMetricFeedbackOptions().setFilter(
                                new ListMetricFeedbackFilter().setTimeMode(FeedbackQueryTimeMode.FEEDBACK_CREATED_TIME)
                                    .setStartTime(firstFeedbackCreatedTime.minusDays(1))
                                    .setEndTime(firstFeedbackCreatedTime.plusDays(1))))
                        .byPage()
                        .take(4))
                .thenConsumeWhile(metricFeedbackPagedResponse -> {
                    metricFeedbackPagedResponse.getValue().forEach(actualMetricFeedbackList::add);
                    return true;
                })
                .expectComplete()
                .verify(DEFAULT_TIMEOUT);

            final List<String> expectedMetricFeedbackIdList
                = expectedMetricFeedbackList.stream().map(MetricFeedback::getId).collect(Collectors.toList());

            final List<MetricFeedback> actualList = actualMetricFeedbackList.stream()
                .filter(metricFeedback -> expectedMetricFeedbackIdList.contains(metricFeedback.getId()))
                .collect(Collectors.toList());

            // Assert
            assertEquals(inputMetricFeedbackList.size(), actualList.size());
            expectedMetricFeedbackList
                .sort(Comparator.comparing(metricFeedback -> metricFeedback.getFeedbackType().toString()));
            actualList.sort(Comparator.comparing(metricFeedback -> metricFeedback.getFeedbackType().toString()));
            final AtomicInteger i = new AtomicInteger(-1);
            final List<FeedbackType> metricFeedbackTypes = Arrays.asList(COMMENT, COMMENT);
            expectedMetricFeedbackList
                .forEach(expectedMetricFeedback -> validateMetricFeedbackResult(expectedMetricFeedback,
                    actualList.get(i.incrementAndGet()), metricFeedbackTypes.get(i.get())));
        });
    }

    /**
     * Verifies the result of the list metric feedback  method to filter results using
     * {@link ListMetricFeedbackFilter#setDimensionFilter(DimensionKey)}.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    void testListMetricFeedbackFilterByDimensionFilter(HttpClient httpClient,
        MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        creatMetricFeedbackRunner(inputMetricFeedback -> {
            final MetricFeedback feedbackAdded = client
                .addFeedback(METRIC_ID, inputMetricFeedback.setDimensionFilter(new DimensionKey(DIMENSION_FILTER)))
                .block();
            final OffsetDateTime feedbackCreatedTime = feedbackAdded.getCreatedTime();

            // Act & Assert
            StepVerifier
                .create(client.listFeedback(METRIC_ID,
                    new ListMetricFeedbackOptions()
                        .setFilter(
                            new ListMetricFeedbackFilter().setTimeMode(FeedbackQueryTimeMode.FEEDBACK_CREATED_TIME)
                                .setStartTime(feedbackCreatedTime.minusDays(1))
                                .setEndTime(feedbackCreatedTime.plusDays(1))
                                .setDimensionFilter(new DimensionKey(DIMENSION_FILTER)))
                        .setMaxPageSize(10)))
                .thenConsumeWhile(metricFeedback -> metricFeedback.getDimensionFilter()
                    .asMap()
                    .keySet()
                    .stream()
                    .anyMatch(DIMENSION_FILTER::containsKey))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT);
        }, ANOMALY);

    }

    /**
     * Verifies the result of the list metric feedback  method to filter results using
     * {@link ListMetricFeedbackFilter#setFeedbackType(FeedbackType)}.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    void testListMetricFeedbackFilterByFeedbackType(HttpClient httpClient,
        MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        int[] count = new int[1];

        // Act & Assert
        StepVerifier
            .create(
                client
                    .listFeedback(METRIC_ID,
                        new ListMetricFeedbackOptions()
                            .setFilter(new ListMetricFeedbackFilter().setFeedbackType(ANOMALY)))
                    .take(LISTING_FILTER_BY_FEEDBACK_TYPE_LIMIT))
            .thenConsumeWhile(metricFeedback -> {
                boolean matched = ANOMALY.equals(metricFeedback.getFeedbackType());
                if (matched) {
                    count[0]++;
                }
                return matched;
            })
            .expectComplete()
            .verify(DEFAULT_TIMEOUT);

        Assertions.assertTrue(count[0] > 0);
    }

    /**
     * Verifies the result of the list metric feedback  method to filter results using
     * {@link ListMetricFeedbackFilter#setStartTime(OffsetDateTime)}.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    void testListMetricFeedbackFilterStartTime(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        creatMetricFeedbackRunner(inputMetricFeedback -> {
            final MetricFeedback createdMetricFeedback = client.addFeedback(METRIC_ID, inputMetricFeedback).block();

            // Act & Assert
            StepVerifier
                .create(client.listFeedback(METRIC_ID,
                    new ListMetricFeedbackOptions()
                        .setFilter(new ListMetricFeedbackFilter().setStartTime(createdMetricFeedback.getCreatedTime())
                            .setTimeMode(FeedbackQueryTimeMode.FEEDBACK_CREATED_TIME))))
                .thenConsumeWhile(
                    metricFeedback -> metricFeedback.getCreatedTime().isAfter(createdMetricFeedback.getCreatedTime())
                        || metricFeedback.getCreatedTime().isEqual(createdMetricFeedback.getCreatedTime()))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT);

        }, ANOMALY);
    }

    // Get Feedback

    /**
     * Verifies that an exception is thrown for null metric feedback Id parameter.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    public void getMetricFeedbackNullId(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();

        // Act & Assert
        StepVerifier.create(client.getFeedback(null))
            .expectErrorMatches(throwable -> throwable instanceof NullPointerException
                && throwable.getMessage().equals("'feedbackId' is required."))
            .verify(DEFAULT_TIMEOUT);
    }

    /**
     * Verifies that an exception is thrown for invalid metric feedback  Id.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    public void getMetricFeedbackInvalidId(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();

        // Act & Assert
        StepVerifier.create(client.getFeedback(INCORRECT_UUID))
            .expectErrorMatches(throwable -> throwable instanceof IllegalArgumentException
                && throwable.getMessage().equals(INCORRECT_UUID_ERROR))
            .verify(DEFAULT_TIMEOUT);
    }

    /**
     * Verifies metric feedback  info returned with response for a valid metric feedback  Id.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    public void getMetricFeedbackValidId(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        creatMetricFeedbackRunner(expectedMetricFeedback -> {
            // Act & Assert
            MetricFeedback createdMetricFeedback = client.addFeedback(METRIC_ID, expectedMetricFeedback).block();
            // Act & Assert
            StepVerifier.create(client.getFeedbackWithResponse(createdMetricFeedback.getId()))
                .assertNext(metricFeedbackResponse -> {
                    assertEquals(metricFeedbackResponse.getStatusCode(), HttpResponseStatus.OK.code());
                    validateMetricFeedbackResult(getCommentFeedback(), metricFeedbackResponse.getValue(), COMMENT);
                })
                .expectComplete()
                .verify(DEFAULT_TIMEOUT);
        }, COMMENT);
    }

    // Create metric feedback

    /**
     * Verifies valid comment metric feedback created for required metric feedback details.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    public void createCommentMetricFeedback(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        // Act & Assert
        creatMetricFeedbackRunner(
            expectedMetricFeedback -> StepVerifier.create(client.addFeedback(METRIC_ID, expectedMetricFeedback))
                .assertNext(createdMetricFeedback -> validateMetricFeedbackResult(expectedMetricFeedback,
                    createdMetricFeedback, COMMENT))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT),
            COMMENT);
    }

    /**
     * Verifies valid anomaly metric feedback created for required metric feedback details.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    public void createAnomalyFeedback(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        // Act & Assert
        creatMetricFeedbackRunner(
            expectedMetricFeedback -> StepVerifier.create(client.addFeedback(METRIC_ID, expectedMetricFeedback))
                .assertNext(createdMetricFeedback -> validateMetricFeedbackResult(expectedMetricFeedback,
                    createdMetricFeedback, ANOMALY))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT),
            ANOMALY);
    }

    /**
     * Verifies valid period metric feedback created for required metric feedback details.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    public void createPeriodMetricFeedback(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        // Act & Assert
        creatMetricFeedbackRunner(
            expectedMetricFeedback -> StepVerifier.create(client.addFeedback(METRIC_ID, expectedMetricFeedback))
                .assertNext(createdMetricFeedback -> validateMetricFeedbackResult(expectedMetricFeedback,
                    createdMetricFeedback, PERIOD))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT),
            PERIOD);
    }

    /**
     * Verifies valid change point metric feedback created for required metric feedback details.
     */
    @ParameterizedTest(name = DISPLAY_NAME_WITH_ARGUMENTS)
    @MethodSource("com.azure.ai.metricsadvisor.TestUtils#getTestParameters")
    @Disabled
    public void createChangePointMetricFeedback(HttpClient httpClient, MetricsAdvisorServiceVersion serviceVersion) {
        // Arrange
        client = getMetricsAdvisorBuilder(httpClient, serviceVersion, false).buildAsyncClient();
        // Act & Assert
        creatMetricFeedbackRunner(
            expectedMetricFeedback -> StepVerifier.create(client.addFeedback(METRIC_ID, expectedMetricFeedback))
                .assertNext(createdMetricFeedback -> validateMetricFeedbackResult(expectedMetricFeedback,
                    createdMetricFeedback, CHANGE_POINT))
                .expectComplete()
                .verify(DEFAULT_TIMEOUT),
            CHANGE_POINT);
    }
}
