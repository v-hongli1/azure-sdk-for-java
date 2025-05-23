// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.search.documents.indexes;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.search.documents.SearchServiceVersion;
import com.azure.search.documents.implementation.util.MappingUtils;
import com.azure.search.documents.indexes.implementation.SearchServiceClientImpl;
import com.azure.search.documents.indexes.implementation.models.ErrorResponseException;
import com.azure.search.documents.indexes.implementation.models.ListDataSourcesResult;
import com.azure.search.documents.indexes.implementation.models.ListIndexersResult;
import com.azure.search.documents.indexes.implementation.models.ListSkillsetsResult;
import com.azure.search.documents.indexes.models.IndexerResyncBody;
import com.azure.search.documents.indexes.models.SearchIndexer;
import com.azure.search.documents.indexes.models.SearchIndexerDataSourceConnection;
import com.azure.search.documents.indexes.models.SearchIndexerSkillset;
import com.azure.search.documents.indexes.models.SearchIndexerStatus;
import reactor.core.publisher.Mono;

import java.util.function.Function;

import static com.azure.core.util.FluxUtil.monoError;
import static com.azure.core.util.FluxUtil.pagedFluxError;
import static com.azure.core.util.FluxUtil.withContext;

/**
 * This class provides a client that contains the operations for creating, getting, listing, updating, or deleting data
 * source connections, indexers, or skillsets and running or resetting indexers in an Azure AI Search service.
 *
 * <h2>
 *     Overview
 * </h2>
 *
 * <p>
 *     Indexers provide indexing automation. An indexer connects to a data source, reads in the data, and passes it to a
 *     skillset pipeline for indexing into a target search index. Indexers read from an external source using connection
 *     information in a data source, and serialize the incoming data into JSON search documents. In addition to a data
 *     source, an indexer also requires an index. The index specifies the fields and attributes of the search documents.
 * </p>
 *
 * <p>
 *     A skillset adds external processing steps to indexer execution, and is usually used to add AI or deep learning
 *     models to analyze or transform content to make it searchable in an index. The contents of a skillset are one or
 *     more skills, which can be <a href="https://learn.microsoft.com/azure/search/cognitive-search-predefined-skills">built-in skills</a>
 *     created by Microsoft, custom skills, or a combination of both. Built-in skills exist for image analysis,
 *     including OCR, and natural language processing. Other examples of built-in skills include entity recognition,
 *     key phrase extraction, chunking text into logical pages, among others. A skillset is high-level standalone object
 *     that exists on a level equivalent to indexes, indexers, and data sources, but it's operational only within indexer
 *     processing. As a high-level object, you can design a skillset once, and then reference it in multiple indexers.
 * </p>
 *
 * <p>
 *     This client provides an asynchronous API for accessing indexers and skillsets. This client allows you to create,
 *     update, list, or delete indexers and skillsets. It can also be used to run or reset indexers.
 * </p>
 *
 * <h2>
 *     Getting Started
 * </h2>
 *
 * <p>
 *     Authenticating and building instances of this client are handled by {@link SearchIndexerClientBuilder}. This
 *     sample shows you how to authenticate and build this client:
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.instantiation -->
 * <pre>
 * SearchIndexerAsyncClient searchIndexerAsyncClient = new SearchIndexerClientBuilder&#40;&#41;
 *     .endpoint&#40;&quot;&#123;endpoint&#125;&quot;&#41;
 *     .credential&#40;new AzureKeyCredential&#40;&quot;&#123;admin-key&#125;&quot;&#41;&#41;
 *     .buildAsyncClient&#40;&#41;;
 * </pre>
 * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.instantiation -->
 *
 * <p>
 *     For more information on authentication and building, see the {@link SearchIndexerClientBuilder} documentation.
 * </p>
 *
 * <h2>
 *     Examples
 * </h2>
 *
 * <p>
 *     The following examples all use <a href="https://github.com/Azure-Samples/azure-search-sample-data">a simple Hotel
 *     data set</a> that you can <a href="https://learn.microsoft.com/azure/search/search-get-started-portal#step-1---start-the-import-data-wizard-and-create-a-data-source">
 *         import into your own index from the Azure portal.</a>
 *     These are just a few of the basics - please check out <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/search/azure-search-documents/src/samples/README.md">our Samples </a>for much more.
 * </p>
 *
 * <h3>
 *     Create an Indexer
 * </h3>
 *
 * <p>
 *     The following sample creates an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.createIndexer#SearchIndexer -->
 * <pre>
 * SearchIndexer indexer = new SearchIndexer&#40;&quot;example-indexer&quot;, &quot;example-datasource&quot;, &quot;example-index&quot;&#41;;
 * SearchIndexer createdIndexer = searchIndexerAsyncClient.createIndexer&#40;indexer&#41;.block&#40;&#41;;
 * if &#40;createdIndexer != null&#41; &#123;
 *     System.out.printf&#40;&quot;Created indexer name: %s%n&quot;, createdIndexer.getName&#40;&#41;&#41;;
 * &#125;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.createIndexer#SearchIndexer -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#createIndexer(SearchIndexer)}.
 * </em>
 *
 * <h3>
 *     List all Indexers
 * </h3>
 *
 * <p>
 *     The following sample lists all indexers.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.listIndexers -->
 * <pre>
 * searchIndexerAsyncClient.listIndexers&#40;&#41;.subscribe&#40;indexer -&gt;
 *     System.out.printf&#40;&quot;Retrieved indexer name: %s%n&quot;, indexer.getName&#40;&#41;&#41;
 * &#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.listIndexers -->
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#listIndexers()}.
 * </em>
 *
 * <h3>
 *     Get an Indexer
 * </h3>
 *
 * <p>
 *     The following sample gets an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.getIndexer#String -->
 * <pre>
 * SearchIndexer indexer = searchIndexerAsyncClient.getIndexer&#40;&quot;example-indexer&quot;&#41;.block&#40;&#41;;
 * if &#40;indexer != null&#41; &#123;
 *     System.out.printf&#40;&quot;Retrieved indexer name: %s%n&quot;, indexer.getName&#40;&#41;&#41;;
 * &#125;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.getIndexer#String -->
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#getIndexer(String)}.
 * </em>
 *
 * <h3>
 *     Update an Indexer
 * </h3>
 *
 * <p>
 *     The following sample updates an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.updateIndexer#SearchIndexer -->
 * <pre>
 * SearchIndexer indexer = searchIndexerAsyncClient.getIndexer&#40;&quot;example-indexer&quot;&#41;.block&#40;&#41;;
 * if &#40;indexer != null&#41; &#123;
 *     System.out.printf&#40;&quot;Retrieved indexer name: %s%n&quot;, indexer.getName&#40;&#41;&#41;;
 *     indexer.setDescription&#40;&quot;This is a new description for this indexer&quot;&#41;;
 *     SearchIndexer updatedIndexer = searchIndexerAsyncClient.createOrUpdateIndexer&#40;indexer&#41;.block&#40;&#41;;
 *
 *     if &#40;updatedIndexer != null&#41; &#123;
 *         System.out.printf&#40;&quot;Updated indexer name: %s, description: %s%n&quot;, updatedIndexer.getName&#40;&#41;,
 *             updatedIndexer.getDescription&#40;&#41;&#41;;
 *     &#125;
 * &#125;
 *
 * </pre>
 * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.updateIndexer#SearchIndexer -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#createOrUpdateIndexer(SearchIndexer)}.
 * </em>
 *
 * <h3>
 *     Delete an Indexer
 * </h3>
 *
 * <p>
 *     The following sample deletes an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.deleteIndexer#String -->
 * <pre>
 * searchIndexerAsyncClient.deleteIndexer&#40;&quot;example-indexer&quot;&#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.deleteIndexer#String -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#deleteIndexer(String)}.
 * </em>
 *
 * <h3>
 *     Run an Indexer
 * </h3>
 *
 * <p>
 *     The following sample runs an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.runIndexer#String -->
 * <pre>
 * searchIndexerAsyncClient.runIndexer&#40;&quot;example-indexer&quot;&#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.runIndexer#String -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#runIndexer(String)}.
 * </em>
 *
 * <h3>
 *     Reset an Indexer
 * </h3>
 *
 * <p>
 *     The following sample resets an indexer.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.resetIndexer#String -->
 * <pre>
 * searchIndexerAsyncClient.resetIndexer&#40;&quot;example-indexer&quot;&#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.resetIndexer#String -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#resetIndexer(String)}.
 * </em>
 *
 * <h3>
 *     Create a Skillset
 * </h3>
 *
 * <p>
 *     The following sample creates a skillset.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.createSkillset#SearchIndexerSkillset -->
 * <pre>
 * List&lt;InputFieldMappingEntry&gt; inputs = Collections.singletonList&#40;
 *     new InputFieldMappingEntry&#40;&quot;image&quot;&#41;
 *         .setSource&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;
 * &#41;;
 *
 * List&lt;OutputFieldMappingEntry&gt; outputs = Arrays.asList&#40;
 *     new OutputFieldMappingEntry&#40;&quot;text&quot;&#41;
 *         .setTargetName&#40;&quot;mytext&quot;&#41;,
 *     new OutputFieldMappingEntry&#40;&quot;layoutText&quot;&#41;
 *         .setTargetName&#40;&quot;myLayoutText&quot;&#41;
 * &#41;;
 *
 * List&lt;SearchIndexerSkill&gt; skills = Collections.singletonList&#40;
 *     new OcrSkill&#40;inputs, outputs&#41;
 *         .setShouldDetectOrientation&#40;true&#41;
 *         .setDefaultLanguageCode&#40;null&#41;
 *         .setName&#40;&quot;myocr&quot;&#41;
 *         .setDescription&#40;&quot;Extracts text &#40;plain and structured&#41; from image.&quot;&#41;
 *         .setContext&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;
 * &#41;;
 *
 * SearchIndexerSkillset skillset = new SearchIndexerSkillset&#40;&quot;skillsetName&quot;, skills&#41;
 *     .setDescription&#40;&quot;Extracts text &#40;plain and structured&#41; from image.&quot;&#41;;
 *
 * System.out.println&#40;String.format&#40;&quot;Creating OCR skillset '%s'&quot;, skillset.getName&#40;&#41;&#41;&#41;;
 *
 * SearchIndexerSkillset createdSkillset = searchIndexerAsyncClient.createSkillset&#40;skillset&#41;.block&#40;&#41;;
 *
 * if &#40;createdSkillset != null&#41; &#123;
 *     System.out.println&#40;&quot;Created OCR skillset&quot;&#41;;
 *     System.out.println&#40;String.format&#40;&quot;Name: %s&quot;, createdSkillset.getName&#40;&#41;&#41;&#41;;
 *     System.out.println&#40;String.format&#40;&quot;ETag: %s&quot;, createdSkillset.getETag&#40;&#41;&#41;&#41;;
 * &#125;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.createSkillset#SearchIndexerSkillset -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#createSkillset(SearchIndexerSkillset)}.
 * </em>
 *
 * <h3>
 *     List all Skillsets
 * </h3>
 *
 * <p>
 *     The following sample lists all skillsets.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.listSkillsets -->
 * <pre>
 * searchIndexerAsyncClient.listSkillsets&#40;&#41;.subscribe&#40;skillset -&gt;
 *     System.out.printf&#40;&quot;Retrieved skillset name: %s%n&quot;, skillset.getName&#40;&#41;&#41;
 * &#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.listSkillsets -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#listSkillsets()}.
 * </em>
 *
 * <h3>
 *     Get a Skillset
 * </h3>
 *
 * <p>
 *     The following sample gets a skillset.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.getSkillset#String -->
 * <pre>
 * SearchIndexerSkillset skillset = searchIndexerAsyncClient.getSkillset&#40;&quot;example-skillset&quot;&#41;.block&#40;&#41;;
 * if &#40;skillset != null&#41; &#123;
 *     System.out.printf&#40;&quot;Retrieved skillset name: %s%n&quot;, skillset.getName&#40;&#41;&#41;;
 * &#125;
 * </pre>
 * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.getSkillset#String -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#getSkillset(String)}.
 * </em>
 *
 * <h3>
 *     Update a Skillset
 * </h3>
 *
 * <p>
 *     The following sample updates a skillset.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.updateSkillset#SearchIndexerSkillset -->
 * <pre>
 * SearchIndexerSkillset skillset = searchIndexerAsyncClient.getSkillset&#40;&quot;example-skillset&quot;&#41;.block&#40;&#41;;
 * if &#40;skillset != null&#41; &#123;
 *     System.out.printf&#40;&quot;Retrieved skillset name: %s%n&quot;, skillset.getName&#40;&#41;&#41;;
 *     SearchIndexerSkillset updatedSkillset = searchIndexerAsyncClient.createOrUpdateSkillset&#40;skillset&#41;.block&#40;&#41;;
 *
 *     if &#40;updatedSkillset != null&#41; &#123;
 *         System.out.printf&#40;&quot;Updated skillset name: %s, description: %s%n&quot;, updatedSkillset.getName&#40;&#41;,
 *             updatedSkillset.getDescription&#40;&#41;&#41;;
 *     &#125;
 * &#125;
 * </pre>
 * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient-classLevelJavaDoc.updateSkillset#SearchIndexerSkillset -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#createOrUpdateSkillset(SearchIndexerSkillset)}.
 * </em>
 *
 * <h3>
 *     Delete a Skillset
 * </h3>
 *
 * <p>
 *     The following sample deletes a skillset.
 * </p>
 *
 * <!-- src_embed com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.deleteSkillset#String -->
 * <pre>
 * searchIndexerAsyncClient.deleteSkillset&#40;&quot;example-skillset&quot;&#41;;
 * </pre>
 * <!-- end com.azure.search.documents.SearchIndexerAsyncClient-classLevelJavaDoc.deleteSkillset#String -->
 *
 * <em>
 *     For a synchronous sample, see {@link SearchIndexerClient#deleteSkillset(String)}.
 * </em>
 *
 * @see SearchIndexerClient
 * @see SearchIndexerClientBuilder
 * @see com.azure.search.documents.indexes
 */
@ServiceClient(builder = SearchIndexerClientBuilder.class, isAsync = true)
public class SearchIndexerAsyncClient {
    private static final ClientLogger LOGGER = new ClientLogger(SearchIndexerAsyncClient.class);

    /**
     * Search REST API Version
     */
    private final SearchServiceVersion serviceVersion;

    /**
     * The endpoint for the Azure AI Search service.
     */
    private final String endpoint;

    /**
     * The underlying AutoRest client used to interact with the Search service
     */
    private final SearchServiceClientImpl restClient;

    /**
     * The pipeline that powers this client.
     */
    private final HttpPipeline httpPipeline;

    SearchIndexerAsyncClient(String endpoint, SearchServiceVersion serviceVersion, HttpPipeline httpPipeline) {
        this.endpoint = endpoint;
        this.serviceVersion = serviceVersion;
        this.httpPipeline = httpPipeline;

        this.restClient = new SearchServiceClientImpl(httpPipeline, endpoint, serviceVersion.getVersion());
    }

    /**
     * Gets the {@link HttpPipeline} powering this client.
     *
     * @return the pipeline.
     */
    HttpPipeline getHttpPipeline() {
        return this.httpPipeline;
    }

    /**
     * Gets the endpoint for the Azure AI Search service.
     *
     * @return the endpoint value.
     */
    public String getEndpoint() {
        return this.endpoint;
    }

    /**
     * Creates a new Azure AI Search data source or updates a data source if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer data source connection named "dataSource".  </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateDataSourceConnection#SearchIndexerDataSourceConnection
     * -->
     * <pre>
     * SearchIndexerDataSourceConnection dataSource = SEARCH_INDEXER_CLIENT.getDataSourceConnection&#40;&quot;dataSource&quot;&#41;;
     * dataSource.setContainer&#40;new SearchIndexerDataContainer&#40;&quot;updatecontainer&quot;&#41;&#41;;
     *
     * SearchIndexerDataSourceConnection updateDataSource = SEARCH_INDEXER_CLIENT
     *     .createOrUpdateDataSourceConnection&#40;dataSource&#41;;
     * System.out.printf&#40;&quot;The dataSource name is %s. The container name of dataSource is %s.%n&quot;,
     *     updateDataSource.getName&#40;&#41;, updateDataSource.getContainer&#40;&#41;.getName&#40;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateDataSourceConnection#SearchIndexerDataSourceConnection
     * -->
     *
     * @param dataSource The definition of the {@link SearchIndexerDataSourceConnection} to create or update.
     * @return the data source that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerDataSourceConnection>
        createOrUpdateDataSourceConnection(SearchIndexerDataSourceConnection dataSource) {
        return createOrUpdateDataSourceConnectionWithResponse(dataSource, false).map(Response::getValue);
    }

    /**
     * Creates a new Azure AI Search data source or updates a data source if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection-boolean
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getDataSourceConnection&#40;&quot;dataSource&quot;&#41;
     *     .flatMap&#40;dataSource -&gt; &#123;
     *         dataSource.setContainer&#40;new SearchIndexerDataContainer&#40;&quot;updatecontainer&quot;&#41;&#41;;
     *         return SEARCH_INDEXER_ASYNC_CLIENT.createOrUpdateDataSourceConnectionWithResponse&#40;dataSource, true&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;updateDataSource -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s.%nThe dataSource name is %s. &quot;
     *             + &quot;The container name of dataSource is %s.%n&quot;, updateDataSource.getStatusCode&#40;&#41;,
     *         updateDataSource.getValue&#40;&#41;.getName&#40;&#41;, updateDataSource.getValue&#40;&#41;.getContainer&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection-boolean
     * -->
     *
     * @param dataSource The definition of the {@link SearchIndexerDataSourceConnection} to create or update.
     * @param onlyIfUnchanged {@code true} to update if the {@code dataSource} is the same as the current service value.
     * {@code false} to always update existing value.
     * @return a data source response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerDataSourceConnection>> createOrUpdateDataSourceConnectionWithResponse(
        SearchIndexerDataSourceConnection dataSource, boolean onlyIfUnchanged) {
        return withContext(
            context -> createOrUpdateDataSourceConnectionWithResponse(dataSource, onlyIfUnchanged, null, context));
    }

    Mono<Response<SearchIndexerDataSourceConnection>> createOrUpdateDataSourceConnectionWithResponse(
        SearchIndexerDataSourceConnection dataSource, boolean onlyIfUnchanged, Boolean ignoreResetRequirements,
        Context context) {
        if (dataSource == null) {
            return monoError(LOGGER, new NullPointerException("'dataSource' cannot be null."));
        }
        String ifMatch = onlyIfUnchanged ? dataSource.getETag() : null;
        if (dataSource.getConnectionString() == null) {
            dataSource.setConnectionString("<unchanged>");
        }
        try {
            return restClient.getDataSources()
                .createOrUpdateWithResponseAsync(dataSource.getName(), dataSource, ifMatch, null,
                    ignoreResetRequirements, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Creates a new Azure AI Search data source
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer data source connection named "dataSource".  </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createDataSourceConnection#SearchIndexerDataSourceConnection
     * -->
     * <pre>
     * SearchIndexerDataSourceConnection dataSource = new SearchIndexerDataSourceConnection&#40;&quot;dataSource&quot;,
     *     com.azure.search.documents.indexes.models.SearchIndexerDataSourceType.AZURE_BLOB, &quot;&#123;connectionString&#125;&quot;,
     *     new com.azure.search.documents.indexes.models.SearchIndexerDataContainer&#40;&quot;container&quot;&#41;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createDataSourceConnection&#40;dataSource&#41;
     *     .subscribe&#40;dataSourceFromService -&gt;
     *         System.out.printf&#40;&quot;The data source name is %s. The ETag of data source is %s.%n&quot;,
     *             dataSourceFromService.getName&#40;&#41;, dataSourceFromService.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createDataSourceConnection#SearchIndexerDataSourceConnection
     * -->
     *
     * @param dataSource The definition of the dataSource to create.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerDataSourceConnection>
        createDataSourceConnection(SearchIndexerDataSourceConnection dataSource) {
        return createDataSourceConnectionWithResponse(dataSource).map(Response::getValue);
    }

    /**
     * Creates a new Azure AI Search data source
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection
     * -->
     * <pre>
     * SearchIndexerDataSourceConnection dataSource = new SearchIndexerDataSourceConnection&#40;&quot;dataSource&quot;,
     *     SearchIndexerDataSourceType.AZURE_BLOB, &quot;&#123;connectionString&#125;&quot;,
     *     new SearchIndexerDataContainer&#40;&quot;container&quot;&#41;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createDataSourceConnectionWithResponse&#40;dataSource&#41;
     *     .subscribe&#40;dataSourceFromService -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The data source name is %s.%n&quot;,
     *         dataSourceFromService.getStatusCode&#40;&#41;, dataSourceFromService.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection
     * -->
     *
     * @param dataSource The definition of the {@link SearchIndexerDataSourceConnection} to create.
     * @return a Mono which performs the network request upon subscription.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerDataSourceConnection>>
        createDataSourceConnectionWithResponse(SearchIndexerDataSourceConnection dataSource) {
        return withContext(context -> this.createDataSourceConnectionWithResponse(dataSource, context));
    }

    Mono<Response<SearchIndexerDataSourceConnection>>
        createDataSourceConnectionWithResponse(SearchIndexerDataSourceConnection dataSource, Context context) {
        try {
            return restClient.getDataSources()
                .createWithResponseAsync(dataSource, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Retrieves a DataSource from an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getDataSourceConnection#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getDataSourceConnection&#40;&quot;dataSource&quot;&#41;
     *     .subscribe&#40;dataSource -&gt;
     *         System.out.printf&#40;&quot;The dataSource name is %s. The ETag of dataSource is %s.%n&quot;, dataSource.getName&#40;&#41;,
     *         dataSource.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getDataSourceConnection#String -->
     *
     * @param dataSourceName the name of the {@link SearchIndexerDataSourceConnection} to retrieve.
     * @return the DataSource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerDataSourceConnection> getDataSourceConnection(String dataSourceName) {
        return getDataSourceConnectionWithResponse(dataSourceName).map(Response::getValue);
    }

    /**
     * Retrieves a DataSource from an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.getDataSourceConnectionWithResponse#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getDataSourceConnectionWithResponse&#40;&quot;dataSource&quot;&#41;
     *     .subscribe&#40;dataSource -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The data source name is %s.%n&quot;,
     *         dataSource.getStatusCode&#40;&#41;, dataSource.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getDataSourceConnectionWithResponse#String
     * -->
     *
     * @param dataSourceName the name of the {@link SearchIndexerDataSourceConnection} to retrieve.
     * @return a response containing the DataSource.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerDataSourceConnection>>
        getDataSourceConnectionWithResponse(String dataSourceName) {
        return withContext(context -> getDataSourceConnectionWithResponse(dataSourceName, context));
    }

    Mono<Response<SearchIndexerDataSourceConnection>> getDataSourceConnectionWithResponse(String dataSourceName,
        Context context) {
        try {
            return restClient.getDataSources()
                .getWithResponseAsync(dataSourceName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * List all DataSources from an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexer data source connections. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listDataSourceConnections -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listDataSourceConnections&#40;&#41;
     *     .subscribe&#40;dataSource -&gt;
     *         System.out.printf&#40;&quot;The dataSource name is %s. The ETag of dataSource is %s.%n&quot;,
     *             dataSource.getName&#40;&#41;, dataSource.getETag&#40;&#41;&#41;
     *     &#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listDataSourceConnections -->
     *
     * @return a list of DataSources
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SearchIndexerDataSourceConnection> listDataSourceConnections() {
        try {
            return new PagedFlux<>(
                () -> withContext(context -> this.listDataSourceConnectionsWithResponse(null, context))
                    .map(MappingUtils::mappingPagingDataSource));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    /**
     * List all DataSource names from an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexer data source connection names. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listDataSourceConnectionNames -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listDataSourceConnectionNames&#40;&#41;
     *     .subscribe&#40;dataSourceName -&gt; System.out.printf&#40;&quot;The dataSource name is %s.%n&quot;, dataSourceName&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listDataSourceConnectionNames -->
     *
     * @return a list of DataSource names
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listDataSourceConnectionNames() {
        try {
            return new PagedFlux<>(
                () -> withContext(context -> this.listDataSourceConnectionsWithResponse("name", context))
                    .map(MappingUtils::mappingPagingDataSourceNames));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    private Mono<Response<ListDataSourcesResult>> listDataSourceConnectionsWithResponse(String select,
        Context context) {
        return restClient.getDataSources()
            .listWithResponseAsync(select, null, context)
            .onErrorMap(MappingUtils::exceptionMapper);
    }

    /**
     * Delete a DataSource
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete the search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteDataSourceConnection#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.deleteDataSourceConnection&#40;&quot;dataSource&quot;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteDataSourceConnection#String -->
     *
     * @param dataSourceName the name of the {@link SearchIndexerDataSourceConnection} for deletion
     * @return a void Mono
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteDataSourceConnection(String dataSourceName) {
        return withContext(
            context -> deleteDataSourceConnectionWithResponse(dataSourceName, null, context).flatMap(FluxUtil::toMono));
    }

    /**
     * Deletes an Azure AI Search data source.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete the search indexer data source connection named "dataSource". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection-boolean
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getDataSourceConnection&#40;&quot;dataSource&quot;&#41;
     *     .flatMap&#40;dataSource -&gt; SEARCH_INDEXER_ASYNC_CLIENT.deleteDataSourceConnectionWithResponse&#40;dataSource, true&#41;&#41;
     *     .subscribe&#40;deleteResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %d.%n&quot;, deleteResponse.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteDataSourceConnectionWithResponse#SearchIndexerDataSourceConnection-boolean
     * -->
     *
     * @param dataSource The {@link SearchIndexerDataSourceConnection} to delete.
     * @param onlyIfUnchanged {@code true} to delete if the {@code dataSource} is the same as the current service value.
     * {@code false} to always delete existing value.
     * @return a mono response
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteDataSourceConnectionWithResponse(SearchIndexerDataSourceConnection dataSource,
        boolean onlyIfUnchanged) {
        if (dataSource == null) {
            return monoError(LOGGER, new NullPointerException("'dataSource' cannot be null."));
        }
        String eTag = onlyIfUnchanged ? dataSource.getETag() : null;
        return withContext(context -> deleteDataSourceConnectionWithResponse(dataSource.getName(), eTag, context));
    }

    Mono<Response<Void>> deleteDataSourceConnectionWithResponse(String dataSourceName, String eTag, Context context) {
        try {
            return restClient.getDataSources()
                .deleteWithResponseAsync(dataSourceName, eTag, null, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Creates a new Azure AI Search indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer named "searchIndexer". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.createIndexer#SearchIndexer -->
     * <pre>
     * SearchIndexer searchIndexer = new SearchIndexer&#40;&quot;searchIndexer&quot;, &quot;dataSource&quot;,
     *     &quot;searchIndex&quot;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createIndexer&#40;searchIndexer&#41;
     *     .subscribe&#40;indexerFromService -&gt;
     *         System.out.printf&#40;&quot;The indexer name is %s. The ETag of indexer is %s.%n&quot;, indexerFromService.getName&#40;&#41;,
     *         indexerFromService.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.createIndexer#SearchIndexer -->
     *
     * @param indexer definition of the indexer to create.
     * @return the created Indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexer> createIndexer(SearchIndexer indexer) {
        return createIndexerWithResponse(indexer).map(Response::getValue);
    }

    /**
     * Creates a new Azure AI Search indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer named "searchIndexer". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createIndexerWithResponse#SearchIndexer -->
     * <pre>
     * SearchIndexer searchIndexer = new SearchIndexer&#40;&quot;searchIndexer&quot;, &quot;dataSource&quot;,
     *     &quot;searchIndex&quot;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createIndexerWithResponse&#40;searchIndexer&#41;
     *     .subscribe&#40;indexerFromServiceResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The indexer name is %s.%n&quot;,
     *             indexerFromServiceResponse.getStatusCode&#40;&#41;, indexerFromServiceResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.createIndexerWithResponse#SearchIndexer -->
     *
     * @param indexer definition of the indexer to create
     * @return a response containing the created Indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexer>> createIndexerWithResponse(SearchIndexer indexer) {
        return withContext(context -> createIndexerWithResponse(indexer, context));
    }

    Mono<Response<SearchIndexer>> createIndexerWithResponse(SearchIndexer indexer, Context context) {
        try {
            return restClient.getIndexers()
                .createWithResponseAsync(indexer, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Creates a new Azure AI Search indexer or updates an indexer if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer named "searchIndexer". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexer#SearchIndexer
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .flatMap&#40;searchIndexerFromService -&gt; &#123;
     *         searchIndexerFromService.setFieldMappings&#40;Collections.singletonList&#40;
     *             new FieldMapping&#40;&quot;hotelName&quot;&#41;.setTargetFieldName&#40;&quot;HotelName&quot;&#41;&#41;&#41;;
     *         return SEARCH_INDEXER_ASYNC_CLIENT.createOrUpdateIndexer&#40;searchIndexerFromService&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;updatedIndexer -&gt;
     *         System.out.printf&#40;&quot;The indexer name is %s. The target field name of indexer is %s.%n&quot;,
     *         updatedIndexer.getName&#40;&#41;, updatedIndexer.getFieldMappings&#40;&#41;.get&#40;0&#41;.getTargetFieldName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexer#SearchIndexer -->
     *
     * @param indexer The definition of the indexer to create or update.
     * @return a response containing the created Indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexer> createOrUpdateIndexer(SearchIndexer indexer) {
        return createOrUpdateIndexerWithResponse(indexer, false).map(Response::getValue);
    }

    /**
     * Creates a new Azure AI Search indexer or updates an indexer if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer named "searchIndexer". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexerWithResponse#SearchIndexer-boolean
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .flatMap&#40;searchIndexerFromService -&gt; &#123;
     *         searchIndexerFromService.setFieldMappings&#40;Collections.singletonList&#40;
     *             new FieldMapping&#40;&quot;hotelName&quot;&#41;.setTargetFieldName&#40;&quot;HotelName&quot;&#41;&#41;&#41;;
     *         return SEARCH_INDEXER_ASYNC_CLIENT.createOrUpdateIndexerWithResponse&#40;searchIndexerFromService, true&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;indexerFromService -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s.%nThe indexer name is %s. &quot;
     *             + &quot;The target field name of indexer is %s.%n&quot;, indexerFromService.getStatusCode&#40;&#41;,
     *         indexerFromService.getValue&#40;&#41;.getName&#40;&#41;,
     *         indexerFromService.getValue&#40;&#41;.getFieldMappings&#40;&#41;.get&#40;0&#41;.getTargetFieldName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexerWithResponse#SearchIndexer-boolean
     * -->
     *
     * @param indexer the definition of the {@link SearchIndexer} to create or update
     * @param onlyIfUnchanged {@code true} to update if the {@code indexer} is the same as the current service value.
     * {@code false} to always update existing value.
     * @return a response containing the created Indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexer>> createOrUpdateIndexerWithResponse(SearchIndexer indexer,
        boolean onlyIfUnchanged) {
        return withContext(context -> createOrUpdateIndexerWithResponse(indexer, onlyIfUnchanged, null, null, context));
    }

    Mono<Response<SearchIndexer>> createOrUpdateIndexerWithResponse(SearchIndexer indexer, boolean onlyIfUnchanged,
        Boolean disableCacheReprocessingChangeDetection, Boolean ignoreResetRequirements, Context context) {
        if (indexer == null) {
            return monoError(LOGGER, new NullPointerException("'indexer' cannot be null."));
        }
        String ifMatch = onlyIfUnchanged ? indexer.getETag() : null;
        try {
            return restClient.getIndexers()
                .createOrUpdateWithResponseAsync(indexer.getName(), indexer, ifMatch, null, ignoreResetRequirements,
                    disableCacheReprocessingChangeDetection, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Retrieves an indexer definition.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer with name "searchIndexer". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexer#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;indexerFromService -&gt;
     *         System.out.printf&#40;&quot;The indexer name is %s. The ETag of indexer is %s.%n&quot;, indexerFromService.getName&#40;&#41;,
     *             indexerFromService.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexer#String -->
     *
     * @param indexerName the name of the indexer to retrieve
     * @return the indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexer> getIndexer(String indexerName) {
        return getIndexerWithResponse(indexerName).map(Response::getValue);
    }

    /**
     * Retrieves an indexer definition.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer with name "searchIndexer". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerWithResponse#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexerWithResponse&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;indexerFromServiceResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The indexer name is %s.%n&quot;,
     *         indexerFromServiceResponse.getStatusCode&#40;&#41;, indexerFromServiceResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerWithResponse#String -->
     *
     * @param indexerName the name of the indexer to retrieve
     * @return a response containing the indexer.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexer>> getIndexerWithResponse(String indexerName) {
        return withContext(context -> getIndexerWithResponse(indexerName, context));
    }

    Mono<Response<SearchIndexer>> getIndexerWithResponse(String indexerName, Context context) {
        try {
            return restClient.getIndexers()
                .getWithResponseAsync(indexerName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Lists all indexers available for an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexers. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listIndexers -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listIndexers&#40;&#41;
     *     .subscribe&#40;indexer -&gt;
     *         System.out.printf&#40;&quot;The indexer name is %s. The ETag of indexer is %s.%n&quot;, indexer.getName&#40;&#41;,
     *         indexer.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listIndexers -->
     *
     * @return a response containing all Indexers from the Search service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SearchIndexer> listIndexers() {
        try {
            return new PagedFlux<>(() -> withContext(context -> this.listIndexersWithResponse(null, context))
                .map(MappingUtils::mappingPagingSearchIndexer));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    /**
     * Lists all indexers available for an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexer names. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listIndexerNames -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listIndexerNames&#40;&#41;
     *     .subscribe&#40;indexerName -&gt; System.out.printf&#40;&quot;The indexer name is %s.%n&quot;, indexerName&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listIndexerNames -->
     *
     * @return a response containing all Indexers from the Search service.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listIndexerNames() {
        try {
            return new PagedFlux<>(() -> withContext(context -> this.listIndexersWithResponse("name", context))
                .map(MappingUtils::mappingPagingSearchIndexerNames));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    private Mono<Response<ListIndexersResult>> listIndexersWithResponse(String select, Context context) {
        return restClient.getIndexers()
            .listWithResponseAsync(select, null, context)
            .onErrorMap(MappingUtils::exceptionMapper);
    }

    /**
     * Deletes an Azure AI Search indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete search indexer named "searchIndexer". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteIndexer#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.deleteIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteIndexer#String -->
     *
     * @param indexerName the name of the indexer to delete
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteIndexer(String indexerName) {
        return withContext(context -> deleteIndexerWithResponse(indexerName, null, context).flatMap(FluxUtil::toMono));
    }

    /**
     * Deletes an Azure AI Search indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete search indexer named "searchIndexer".  </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteIndexerWithResponse#SearchIndexer-boolean -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .flatMap&#40;searchIndexer -&gt;
     *         SEARCH_INDEXER_ASYNC_CLIENT.deleteIndexerWithResponse&#40;searchIndexer, true&#41;&#41;
     *     .subscribe&#40;deleteResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %d.%n&quot;, deleteResponse.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteIndexerWithResponse#SearchIndexer-boolean -->
     *
     * @param indexer the {@link SearchIndexer} to delete
     * @param onlyIfUnchanged {@code true} to delete if the {@code indexer} is the same as the current service value.
     * {@code false} to always delete existing value.
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteIndexerWithResponse(SearchIndexer indexer, boolean onlyIfUnchanged) {
        if (indexer == null) {
            return monoError(LOGGER, new NullPointerException("'indexer' cannot be null."));
        }
        String eTag = onlyIfUnchanged ? indexer.getETag() : null;
        return withContext(context -> deleteIndexerWithResponse(indexer.getName(), eTag, context));
    }

    /**
     * Deletes an Azure AI Search indexer.
     *
     * @param indexerName the name of the indexer to delete
     * @param eTag Optional. The eTag to match.
     * @param context the context
     * @return a response signalling completion.
     */
    Mono<Response<Void>> deleteIndexerWithResponse(String indexerName, String eTag, Context context) {
        try {
            return restClient.getIndexers()
                .deleteWithResponseAsync(indexerName, eTag, null, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Resets the change tracking state associated with an indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Reset search indexer named "searchIndexer".  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.resetIndexer#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.resetIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.resetIndexer#String -->
     *
     * @param indexerName the name of the indexer to reset
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> resetIndexer(String indexerName) {
        return resetIndexerWithResponse(indexerName).flatMap(FluxUtil::toMono);
    }

    /**
     * Resets the change tracking state associated with an indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Reset search indexer named "searchIndexer".  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.resetIndexerWithResponse#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.resetIndexerWithResponse&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;response -&gt;
     *         System.out.println&#40;&quot;The status code of the response is &quot; + response.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.resetIndexerWithResponse#String -->
     *
     * @param indexerName the name of the indexer to reset
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> resetIndexerWithResponse(String indexerName) {
        return withContext(context -> resetIndexerWithResponse(indexerName, context));
    }

    Mono<Response<Void>> resetIndexerWithResponse(String indexerName, Context context) {
        try {
            return restClient.getIndexers()
                .resetWithResponseAsync(indexerName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Runs an indexer on-demand.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Run search indexer named "searchIndexer".  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.runIndexer#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.runIndexer&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.runIndexer#String -->
     *
     * @param indexerName the name of the indexer to run
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> runIndexer(String indexerName) {
        return runIndexerWithResponse(indexerName).flatMap(FluxUtil::toMono);
    }

    /**
     * Runs an indexer on-demand.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Run search indexer named "searchIndexer".  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.runIndexerWithResponse#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.runIndexerWithResponse&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;response -&gt;
     *         System.out.println&#40;&quot;The status code of the response is &quot; + response.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.runIndexerWithResponse#String -->
     *
     * @param indexerName the name of the indexer to run
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> runIndexerWithResponse(String indexerName) {
        return withContext(context -> runIndexerWithResponse(indexerName, context));
    }

    Mono<Response<Void>> runIndexerWithResponse(String indexerName, Context context) {
        try {
            return restClient.getIndexers()
                .runWithResponseAsync(indexerName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Returns the current status and execution history of an indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get status for search indexer "searchIndexer".  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerStatus#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexerStatus&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;indexerStatus -&gt;
     *         System.out.printf&#40;&quot;The indexer status is %s.%n&quot;, indexerStatus.getStatus&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerStatus#String -->
     *
     * @param indexerName the name of the indexer for which to retrieve status
     * @return the indexer execution info.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerStatus> getIndexerStatus(String indexerName) {
        return getIndexerStatusWithResponse(indexerName).map(Response::getValue);
    }

    /**
     * Returns the current status and execution history of an indexer.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer status.  </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerStatusWithResponse#String
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getIndexerStatusWithResponse&#40;&quot;searchIndexer&quot;&#41;
     *     .subscribe&#40;response -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s.%nThe indexer status is %s.%n&quot;,
     *         response.getStatusCode&#40;&#41;, response.getValue&#40;&#41;.getStatus&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getIndexerStatusWithResponse#String -->
     *
     * @param indexerName the name of the indexer for which to retrieve status
     * @return a response with the indexer execution info.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerStatus>> getIndexerStatusWithResponse(String indexerName) {
        return withContext(context -> getIndexerStatusWithResponse(indexerName, context));
    }

    Mono<Response<SearchIndexerStatus>> getIndexerStatusWithResponse(String indexerName, Context context) {
        try {
            return restClient.getIndexers()
                .getStatusWithResponseAsync(indexerName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Creates a new skillset in an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.createSkillset#SearchIndexerSkillset
     * -->
     * <pre>
     * List&lt;InputFieldMappingEntry&gt; inputs = Collections.singletonList&#40;
     *     new InputFieldMappingEntry&#40;&quot;image&quot;&#41;
     *         .setSource&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;
     * &#41;;
     *
     * List&lt;OutputFieldMappingEntry&gt; outputs = Arrays.asList&#40;
     *     new OutputFieldMappingEntry&#40;&quot;text&quot;&#41;
     *         .setTargetName&#40;&quot;mytext&quot;&#41;,
     *     new OutputFieldMappingEntry&#40;&quot;layoutText&quot;&#41;
     *         .setTargetName&#40;&quot;myLayoutText&quot;&#41;
     * &#41;;
     * SearchIndexerSkillset searchIndexerSkillset = new SearchIndexerSkillset&#40;&quot;searchIndexerSkillset&quot;,
     *     Collections.singletonList&#40;new OcrSkill&#40;inputs, outputs&#41;
     *         .setShouldDetectOrientation&#40;true&#41;
     *         .setDefaultLanguageCode&#40;null&#41;
     *         .setName&#40;&quot;myocr&quot;&#41;
     *         .setDescription&#40;&quot;Extracts text &#40;plain and structured&#41; from image.&quot;&#41;
     *         .setContext&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;&#41;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createSkillset&#40;searchIndexerSkillset&#41;
     *     .subscribe&#40;skillset -&gt;
     *         System.out.printf&#40;&quot;The indexer skillset name is %s. The ETag of indexer skillset is %s.%n&quot;,
     *         skillset.getName&#40;&#41;, skillset.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.createSkillset#SearchIndexerSkillset -->
     *
     * @param skillset definition of the skillset containing one or more cognitive skills
     * @return the created Skillset.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerSkillset> createSkillset(SearchIndexerSkillset skillset) {
        return createSkillsetWithResponse(skillset).map(Response::getValue);
    }

    /**
     * Creates a new skillset in an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createSkillsetWithResponse#SearchIndexerSkillset -->
     * <pre>
     * List&lt;InputFieldMappingEntry&gt; inputs = Collections.singletonList&#40;
     *     new InputFieldMappingEntry&#40;&quot;image&quot;&#41;
     *         .setSource&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;
     * &#41;;
     *
     * List&lt;OutputFieldMappingEntry&gt; outputs = Arrays.asList&#40;
     *     new OutputFieldMappingEntry&#40;&quot;text&quot;&#41;
     *         .setTargetName&#40;&quot;mytext&quot;&#41;,
     *     new OutputFieldMappingEntry&#40;&quot;layoutText&quot;&#41;
     *         .setTargetName&#40;&quot;myLayoutText&quot;&#41;
     * &#41;;
     * SearchIndexerSkillset searchIndexerSkillset = new SearchIndexerSkillset&#40;&quot;searchIndexerSkillset&quot;,
     *     Collections.singletonList&#40;new OcrSkill&#40;inputs, outputs&#41;
     *         .setShouldDetectOrientation&#40;true&#41;
     *         .setDefaultLanguageCode&#40;null&#41;
     *         .setName&#40;&quot;myocr&quot;&#41;
     *         .setDescription&#40;&quot;Extracts text &#40;plain and structured&#41; from image.&quot;&#41;
     *         .setContext&#40;&quot;&#47;document&#47;normalized_images&#47;*&quot;&#41;&#41;&#41;;
     * SEARCH_INDEXER_ASYNC_CLIENT.createSkillsetWithResponse&#40;searchIndexerSkillset&#41;
     *     .subscribe&#40;skillsetWithResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The indexer skillset name is %s.%n&quot;,
     *         skillsetWithResponse.getStatusCode&#40;&#41;, skillsetWithResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createSkillsetWithResponse#SearchIndexerSkillset -->
     *
     * @param skillset definition of the skillset containing one or more cognitive skills
     * @return a response containing the created Skillset.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerSkillset>> createSkillsetWithResponse(SearchIndexerSkillset skillset) {
        return withContext(context -> createSkillsetWithResponse(skillset, context));
    }

    Mono<Response<SearchIndexerSkillset>> createSkillsetWithResponse(SearchIndexerSkillset skillset, Context context) {
        if (skillset == null) {
            return monoError(LOGGER, new NullPointerException("'skillset' cannot be null."));
        }
        try {
            return restClient.getSkillsets()
                .createWithResponseAsync(skillset, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Retrieves a skillset definition.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getSearchIndexerSkillset#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getSkillset&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .subscribe&#40;indexerSkillset -&gt;
     *         System.out.printf&#40;&quot;The indexer skillset name is %s. The ETag of indexer skillset is %s.%n&quot;,
     *         indexerSkillset.getName&#40;&#41;, indexerSkillset.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getSearchIndexerSkillset#String -->
     *
     * @param skillsetName the name of the skillset to retrieve
     * @return the Skillset.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerSkillset> getSkillset(String skillsetName) {
        return getSkillsetWithResponse(skillsetName).map(Response::getValue);
    }

    /**
     * Retrieves a skillset definition.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Get search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.getSkillsetWithResponse#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getSkillsetWithResponse&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .subscribe&#40;skillsetWithResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s. The indexer skillset name is %s.%n&quot;,
     *         skillsetWithResponse.getStatusCode&#40;&#41;, skillsetWithResponse.getValue&#40;&#41;.getName&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.getSkillsetWithResponse#String -->
     *
     * @param skillsetName the name of the skillset to retrieve
     * @return a response containing the Skillset.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerSkillset>> getSkillsetWithResponse(String skillsetName) {
        return withContext(context -> getSkillsetWithResponse(skillsetName, context));
    }

    Mono<Response<SearchIndexerSkillset>> getSkillsetWithResponse(String skillsetName, Context context) {
        try {
            return this.restClient.getSkillsets()
                .getWithResponseAsync(skillsetName, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Lists all skillsets available for an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexer skillsets. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listSkillsets -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listSkillsets&#40;&#41;
     *     .subscribe&#40;skillset -&gt;
     *         System.out.printf&#40;&quot;The skillset name is %s. The ETag of skillset is %s.%n&quot;, skillset.getName&#40;&#41;,
     *         skillset.getETag&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listSkillsets -->
     *
     * @return a reactive response emitting the list of skillsets.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<SearchIndexerSkillset> listSkillsets() {
        try {
            return new PagedFlux<>(() -> withContext(context -> listSkillsetsWithResponse(null, context))
                .map(MappingUtils::mappingPagingSkillset));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    /**
     * Lists all skillset names for an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> List all search indexer skillset names. </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.listSkillsetNames -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.listSkillsetNames&#40;&#41;
     *     .subscribe&#40;skillsetName -&gt; System.out.printf&#40;&quot;The indexer skillset name is %s.%n&quot;, skillsetName&#41;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.listSkillsetNames -->
     *
     * @return a reactive response emitting the list of skillset names.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<String> listSkillsetNames() {
        try {
            return new PagedFlux<>(() -> withContext(context -> listSkillsetsWithResponse("name", context))
                .map(MappingUtils::mappingPagingSkillsetNames));
        } catch (RuntimeException ex) {
            return pagedFluxError(LOGGER, ex);
        }
    }

    private Mono<Response<ListSkillsetsResult>> listSkillsetsWithResponse(String select, Context context) {
        return this.restClient.getSkillsets()
            .listWithResponseAsync(select, null, context)
            .onErrorMap(MappingUtils::exceptionMapper);
    }

    /**
     * Creates a new Azure AI Search skillset or updates a skillset if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexerSkillset#SearchIndexerSkillset
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getSkillset&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .flatMap&#40;indexerSkillset -&gt; &#123;
     *         indexerSkillset.setDescription&#40;&quot;This is new description!&quot;&#41;;
     *         return SEARCH_INDEXER_ASYNC_CLIENT.createOrUpdateSkillset&#40;indexerSkillset&#41;;
     *     &#125;&#41;.subscribe&#40;updateSkillset -&gt;
     *         System.out.printf&#40;&quot;The indexer skillset name is %s. The description of indexer skillset is %s.%n&quot;,
     *         updateSkillset.getName&#40;&#41;, updateSkillset.getDescription&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateIndexerSkillset#SearchIndexerSkillset
     * -->
     *
     * @param skillset the definition of the skillset to create or update
     * @return the skillset that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<SearchIndexerSkillset> createOrUpdateSkillset(SearchIndexerSkillset skillset) {
        return createOrUpdateSkillsetWithResponse(skillset, false).map(Response::getValue);
    }

    /**
     * Creates a new Azure AI Search skillset or updates a skillset if it already exists.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Create or update search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateSkillsetWithResponse#SearchIndexerSkillset-boolean
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getSkillset&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .flatMap&#40;indexerSkillset -&gt; &#123;
     *         indexerSkillset.setDescription&#40;&quot;This is new description!&quot;&#41;;
     *         return SEARCH_INDEXER_ASYNC_CLIENT.createOrUpdateSkillsetWithResponse&#40;indexerSkillset, true&#41;;
     *     &#125;&#41;
     *     .subscribe&#40;updateSkillsetResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %s.%nThe indexer skillset name is %s. &quot;
     *             + &quot;The description of indexer skillset is %s.%n&quot;, updateSkillsetResponse.getStatusCode&#40;&#41;,
     *         updateSkillsetResponse.getValue&#40;&#41;.getName&#40;&#41;,
     *         updateSkillsetResponse.getValue&#40;&#41;.getDescription&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.createOrUpdateSkillsetWithResponse#SearchIndexerSkillset-boolean
     * -->
     *
     * @param skillset the definition of the skillset to create or update
     * @param onlyIfUnchanged {@code true} to update if the {@code skillset} is the same as the current service value.
     * {@code false} to always update existing value.
     * @return a response containing the skillset that was created or updated.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<SearchIndexerSkillset>> createOrUpdateSkillsetWithResponse(SearchIndexerSkillset skillset,
        boolean onlyIfUnchanged) {
        return withContext(
            context -> createOrUpdateSkillsetWithResponse(skillset, onlyIfUnchanged, null, null, context));
    }

    Mono<Response<SearchIndexerSkillset>> createOrUpdateSkillsetWithResponse(SearchIndexerSkillset skillset,
        boolean onlyIfUnchanged, Boolean disableCacheReprocessingChangeDetection, Boolean ignoreResetRequirements,
        Context context) {
        if (skillset == null) {
            return monoError(LOGGER, new NullPointerException("'skillset' cannot be null."));
        }
        String ifMatch = onlyIfUnchanged ? skillset.getETag() : null;
        try {
            return restClient.getSkillsets()
                .createOrUpdateWithResponseAsync(skillset.getName(), skillset, ifMatch, null, ignoreResetRequirements,
                    disableCacheReprocessingChangeDetection, null, context)
                .onErrorMap(MappingUtils::exceptionMapper);
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Deletes a cognitive skillset in an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteSkillset#String -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.deleteSkillset&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .subscribe&#40;&#41;;
     * </pre>
     * <!-- end com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteSkillset#String -->
     *
     * @param skillsetName the name of the skillset to delete
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteSkillset(String skillsetName) {
        return withContext(
            context -> deleteSkillsetWithResponse(skillsetName, null, context).flatMap(FluxUtil::toMono));
    }

    /**
     * Deletes a cognitive skillset in an Azure AI Search service.
     *
     * <p><strong>Code Sample</strong></p>
     *
     * <p> Delete search indexer skillset "searchIndexerSkillset". </p>
     *
     * <!-- src_embed
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteSkillsetWithResponse#SearchIndexerSkillset-boolean
     * -->
     * <pre>
     * SEARCH_INDEXER_ASYNC_CLIENT.getSkillset&#40;&quot;searchIndexerSkillset&quot;&#41;
     *     .flatMap&#40;searchIndexerSkillset -&gt;
     *         SEARCH_INDEXER_ASYNC_CLIENT.deleteSkillsetWithResponse&#40;searchIndexerSkillset, true&#41;&#41;
     *     .subscribe&#40;deleteResponse -&gt;
     *         System.out.printf&#40;&quot;The status code of the response is %d.%n&quot;, deleteResponse.getStatusCode&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end
     * com.azure.search.documents.indexes.SearchIndexerAsyncClient.deleteSkillsetWithResponse#SearchIndexerSkillset-boolean
     * -->
     *
     * @param skillset the {@link SearchIndexerSkillset} to delete.
     * @param onlyIfUnchanged {@code true} to delete if the {@code skillset} is the same as the current service value.
     * {@code false} to always delete existing value.
     * @return a response signalling completion.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteSkillsetWithResponse(SearchIndexerSkillset skillset, boolean onlyIfUnchanged) {
        if (skillset == null) {
            return monoError(LOGGER, new NullPointerException("'skillset' cannot be null."));
        }
        String eTag = onlyIfUnchanged ? skillset.getETag() : null;
        return withContext(context -> deleteSkillsetWithResponse(skillset.getName(), eTag, context));
    }

    Mono<Response<Void>> deleteSkillsetWithResponse(String skillsetName, String eTag, Context context) {
        try {
            return restClient.getSkillsets()
                .deleteWithResponseAsync(skillsetName, eTag, null, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }

    /**
     * Resync selective options from the datasource to be re-ingested by the indexer.
     *
     * @param indexerName The name of the indexer to resync for.
     * @param indexerResync The indexerResync parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return A {@link Mono} that completes when a successful response is received.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> resync(String indexerName, IndexerResyncBody indexerResync) {
        return resyncWithResponse(indexerName, indexerResync).flatMap(FluxUtil::toMono);
    }

    /**
     * Resync selective options from the datasource to be re-ingested by the indexer.
     *
     * @param indexerName The name of the indexer to resync for.
     * @param indexerResync The indexerResync parameter.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws ErrorResponseException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response} on successful completion of {@link Mono}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> resyncWithResponse(String indexerName, IndexerResyncBody indexerResync) {
        return withContext(context -> resyncWithResponseAsync(indexerName, indexerResync, context));
    }

    Mono<Response<Void>> resyncWithResponseAsync(String indexerName, IndexerResyncBody indexerResync, Context context) {
        try {
            return restClient.getIndexers()
                .resyncWithResponseAsync(indexerName, indexerResync, null, context)
                .onErrorMap(MappingUtils::exceptionMapper)
                .map(Function.identity());
        } catch (RuntimeException ex) {
            return monoError(LOGGER, ex);
        }
    }
}
