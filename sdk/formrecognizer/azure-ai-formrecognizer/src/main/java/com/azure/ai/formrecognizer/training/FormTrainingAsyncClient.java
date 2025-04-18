// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.ai.formrecognizer.training;

import com.azure.ai.formrecognizer.FormRecognizerAsyncClient;
import com.azure.ai.formrecognizer.FormRecognizerClientBuilder;
import com.azure.ai.formrecognizer.FormRecognizerServiceVersion;
import com.azure.ai.formrecognizer.documentanalysis.administration.DocumentModelAdministrationAsyncClient;
import com.azure.ai.formrecognizer.documentanalysis.administration.DocumentModelAdministrationClient;
import com.azure.ai.formrecognizer.implementation.CustomModelsImpl;
import com.azure.ai.formrecognizer.implementation.FormRecognizerClientImpl;
import com.azure.ai.formrecognizer.implementation.Utility;
import com.azure.ai.formrecognizer.implementation.models.ComposeRequest;
import com.azure.ai.formrecognizer.implementation.models.CopyAuthorizationResult;
import com.azure.ai.formrecognizer.implementation.models.CopyOperationResult;
import com.azure.ai.formrecognizer.implementation.models.CopyRequest;
import com.azure.ai.formrecognizer.implementation.models.Model;
import com.azure.ai.formrecognizer.implementation.models.ModelStatus;
import com.azure.ai.formrecognizer.implementation.models.OperationStatus;
import com.azure.ai.formrecognizer.implementation.models.TrainRequest;
import com.azure.ai.formrecognizer.implementation.models.TrainSourceFilter;
import com.azure.ai.formrecognizer.models.CreateComposedModelOptions;
import com.azure.ai.formrecognizer.models.FormRecognizerErrorInformation;
import com.azure.ai.formrecognizer.models.FormRecognizerException;
import com.azure.ai.formrecognizer.models.FormRecognizerOperationResult;
import com.azure.ai.formrecognizer.training.models.AccountProperties;
import com.azure.ai.formrecognizer.training.models.CopyAuthorization;
import com.azure.ai.formrecognizer.training.models.CustomFormModel;
import com.azure.ai.formrecognizer.training.models.CustomFormModelInfo;
import com.azure.ai.formrecognizer.training.models.CustomFormModelStatus;
import com.azure.ai.formrecognizer.training.models.TrainingOptions;
import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceClient;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.exception.HttpResponseException;
import com.azure.core.http.HttpPipeline;
import com.azure.core.http.rest.PagedFlux;
import com.azure.core.http.rest.PagedResponse;
import com.azure.core.http.rest.PagedResponseBase;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.CoreUtils;
import com.azure.core.util.FluxUtil;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.PollerFlux;
import com.azure.core.util.polling.PollingContext;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.azure.ai.formrecognizer.implementation.Utility.DEFAULT_POLL_INTERVAL;
import static com.azure.ai.formrecognizer.implementation.Utility.getCreateComposeModelOptions;
import static com.azure.ai.formrecognizer.implementation.Utility.parseModelId;
import static com.azure.ai.formrecognizer.implementation.Utility.urlActivationOperation;
import static com.azure.ai.formrecognizer.training.CustomModelTransforms.toCustomFormModel;
import static com.azure.ai.formrecognizer.training.CustomModelTransforms.toCustomFormModelInfo;
import static com.azure.core.util.FluxUtil.monoError;
import static com.azure.core.util.FluxUtil.withContext;

/**
 * <p>This class provides an asynchronous client to connect to the Form Recognizer Azure Cognitive Service.</p>
 * <p>This client provides asynchronous methods to:</p>
 *
 * <ol>
 *     <li>Train a custom model: Train a custom model to analyze and extract data from forms and documents specific to
 *     your business using the {@link #beginTraining(String, boolean) beginTraining} method.</li>
 *     <li>Copy custom model: Copy a custom Form Recognizer model to a target Form Recognizer resource using the
 *     {@link #beginCopyModel(String, CopyAuthorization) beginCopyModel} method.</li>
 *     <li>List custom models: Get information about all custom models using the
 *     {@link #getCustomModel(String) getCustomModel} and {@link #listCustomModels() listCustomModels} methods
 *     respectively.</li>
 *     <li>Polling and Callbacks: It includes mechanisms for polling the service to check the status of an analysis
 *     operation or registering callbacks to receive notifications when the analysis is complete.</li>
 * </ol>
 *
 * <p><strong>Note: </strong>This client only supports {@link FormRecognizerServiceVersion#V2_1} and lower.
 * Recommended to use a newer service version, {@link DocumentModelAdministrationClient} and
 * {@link DocumentModelAdministrationAsyncClient}.</p>
 *
 * <p><strong>Refer to the
 * <a href="https://github.com/Azure/azure-sdk-for-java/blob/main/sdk/formrecognizer/azure-ai-formrecognizer/migration-guide.md">Migration guide</a> to use API versions 2022-08-31 and up.</strong></p>
 *
 * <p>Service clients are the point of interaction for developers to use Azure Form Recognizer.
 * {@link FormTrainingClient} is the synchronous service client and {@link FormTrainingAsyncClient} is the asynchronous
 * service client. The examples shown in this document use a credential object named DefaultAzureCredential for
 * authentication, which is appropriate for most scenarios, including local development and production environments.
 * Additionally, we recommend using
 * <a href="https://learn.microsoft.com/azure/active-directory/managed-identities-azure-resources/">managed identity</a>
 * for authentication in production environments.
 * You can find more information on different ways of authenticating and their corresponding credential types in the
 * <a href="https://learn.microsoft.com/java/api/overview/azure/identity-readme">Azure Identity documentation"</a>.
 * </p>
 *
 * <p><strong>Sample: Construct a FormTrainingAsyncClient with DefaultAzureCredential</strong></p>
 *
 * <p>The following code sample demonstrates the creation of a
 * {@link com.azure.ai.formrecognizer.training.FormTrainingAsyncClient}, using
 * the `DefaultAzureCredentialBuilder` to configure it.</p>
 *
 * <!-- src_embed readme-sample-createFormTrainingAsyncClientWithAAD -->
 * <pre>
 * FormTrainingAsyncClient client = new FormTrainingClientBuilder&#40;&#41;
 *     .endpoint&#40;&quot;&#123;endpoint&#125;&quot;&#41;
 *     .credential&#40;new DefaultAzureCredentialBuilder&#40;&#41;.build&#40;&#41;&#41;
 *     .buildAsyncClient&#40;&#41;;
 * </pre>
 * <!-- end readme-sample-createFormTrainingAsyncClientWithAAD  -->
 *
 * <p>Further, see the code sample below to use
 * {@link com.azure.core.credential.AzureKeyCredential AzureKeyCredential} for client creation.</p>
 *
 * <!-- src_embed readme-sample-createFormTrainingAsyncClient -->
 * <pre>
 * FormTrainingAsyncClient formTrainingAsyncClient = new FormTrainingClientBuilder&#40;&#41;
 *     .credential&#40;new AzureKeyCredential&#40;&quot;&#123;key&#125;&quot;&#41;&#41;
 *     .endpoint&#40;&quot;&#123;endpoint&#125;&quot;&#41;
 *     .buildAsyncClient&#40;&#41;;
 * </pre>
 * <!-- end readme-sample-createFormTrainingAsyncClient  -->
 *
 * @see com.azure.ai.formrecognizer.training
 * @see FormTrainingClientBuilder
 * @see FormTrainingClient
 */
@ServiceClient(builder = FormTrainingClientBuilder.class, isAsync = true)
public final class FormTrainingAsyncClient {

    private final ClientLogger logger = new ClientLogger(FormTrainingAsyncClient.class);
    private final FormRecognizerClientImpl service;
    private final FormRecognizerServiceVersion serviceVersion;
    private final CustomModelsImpl customModelsImpl;

    /**
     * Create a {@link FormTrainingClient} that sends requests to the Form Recognizer service's endpoint.
     * Each service call goes through the {@link FormTrainingClientBuilder#pipeline http pipeline}.
     *
     * @param service The proxy service used to perform REST calls.
     * @param serviceVersion The versions of Azure Form Recognizer supported by this client library.
     */
    FormTrainingAsyncClient(FormRecognizerClientImpl service, FormRecognizerServiceVersion serviceVersion) {
        this.service = service;
        this.serviceVersion = serviceVersion;
        this.customModelsImpl = service.getCustomModels();
    }

    /**
     * Creates a new {@link FormRecognizerAsyncClient} object. The new {@code FormTrainingAsyncClient}
     * uses the same request policy pipeline as the {@code FormTrainingAsyncClient}.
     *
     * @return A new {@link FormRecognizerAsyncClient} object.
     */
    public FormRecognizerAsyncClient getFormRecognizerAsyncClient() {
        return new FormRecognizerClientBuilder().endpoint(getEndpoint()).pipeline(getHttpPipeline()).buildAsyncClient();
    }

    /**
     * Gets the pipeline the client is using.
     *
     * @return the pipeline the client is using.
     */
    HttpPipeline getHttpPipeline() {
        return service.getHttpPipeline();
    }

    /**
     * Gets the endpoint the client is using.
     *
     * @return the endpoint the client is using.
     */
    String getEndpoint() {
        return service.getEndpoint();
    }

    /**
     * Create and train a custom model.
     * Models are trained using documents that are of the following content type -
     * 'application/pdf', 'image/jpeg', 'image/png', 'image/tiff'.
     * Other type of content is ignored.
     * <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     * See <a href="https://docs.microsoft.com/azure/cognitive-services/form-recognizer/build-training-data-set#upload-your-training-data">here</a>
     * for information on building your own training data set.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginTraining#string-boolean -->
     * <pre>
     * String trainingFilesUrl = &quot;&#123;SAS-URL-of-your-container-in-blob-storage&#125;&quot;;
     * boolean useTrainingLabels = true;
     * formTrainingAsyncClient.beginTraining&#40;trainingFilesUrl, useTrainingLabels&#41;
     *     &#47;&#47; if training polling operation completed, retrieve the final result.
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *     .subscribe&#40;customFormModel -&gt; &#123;
     *         System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *         customFormModel.getSubmodels&#40;&#41;
     *             .forEach&#40;customFormSubmodel -&gt; customFormSubmodel.getFields&#40;&#41;
     *                 .forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                     System.out.printf&#40;&quot;Form type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                         key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginTraining#string-boolean -->
     *
     * @param trainingFilesUrl source URL parameter that is an externally accessible Azure
     * storage blob container Uri (preferably a Shared Access Signature Uri).
     * @param useTrainingLabels boolean to specify the use of labeled files for training the model.
     *
     * @return A {@link PollerFlux} that polls the training model operation until it has completed, has failed, or has
     * been cancelled. The completed operation returns the trained {@link CustomFormModel custom form model}.
     * @throws FormRecognizerException If training fails and a model with {@link ModelStatus#INVALID} is created.
     * @throws NullPointerException If {@code trainingFilesUrl} is null.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginTraining(String trainingFilesUrl,
        boolean useTrainingLabels) {
        return beginTraining(trainingFilesUrl, useTrainingLabels, null);
    }

    /**
     * Create and train a custom model.
     * <p>Models are trained using documents that are of the following content type -
     * 'application/pdf', 'image/jpeg', 'image/png', 'image/tiff'.Other type of content is ignored.
     * </p>
     * See <a href="https://docs.microsoft.com/azure/cognitive-services/form-recognizer/build-training-data-set#upload-your-training-data">here</a>
     * for information on building your own training data set.
     * <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginTraining#string-boolean-Options -->
     * <pre>
     * String trainingFilesUrl = &quot;&#123;SAS-URL-of-your-container-in-blob-storage&#125;&quot;;
     * TrainingFileFilter trainingFileFilter = new TrainingFileFilter&#40;&#41;.setSubfoldersIncluded&#40;true&#41;.setPrefix&#40;&quot;Invoice&quot;&#41;;
     *
     * formTrainingAsyncClient.beginTraining&#40;trainingFilesUrl, true,
     *     new TrainingOptions&#40;&#41;
     *         .setTrainingFileFilter&#40;trainingFileFilter&#41;
     *         .setPollInterval&#40;Duration.ofSeconds&#40;5&#41;&#41;&#41;
     *     &#47;&#47; if training polling operation completed, retrieve the final result.
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *     .subscribe&#40;customFormModel -&gt; &#123;
     *         System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *         customFormModel.getSubmodels&#40;&#41;.forEach&#40;customFormSubmodel -&gt;
     *             customFormSubmodel.getFields&#40;&#41;.forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                 System.out.printf&#40;&quot;Form Type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                     key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginTraining#string-boolean-Options -->
     *
     * @param trainingFilesUrl an externally accessible Azure storage blob container Uri (preferably a
     * Shared Access Signature Uri).
     * @param useTrainingLabels boolean to specify the use of labeled files for training the model.
     * @param trainingOptions The additional configurable {@link TrainingOptions options}
     * that may be passed when training a model.
     *
     * @return A {@link PollerFlux} that polls the training model operation until it has completed, has failed, or has
     * been cancelled. The completed operation returns the trained {@link CustomFormModel custom form model}.
     * @throws FormRecognizerException If training fails and model with {@link ModelStatus#INVALID} is created.
     * @throws NullPointerException If {@code trainingFilesUrl} is null.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginTraining(String trainingFilesUrl,
        boolean useTrainingLabels, TrainingOptions trainingOptions) {
        return beginTraining(trainingFilesUrl, useTrainingLabels, trainingOptions, Context.NONE);
    }

    PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginTraining(String trainingFilesUrl,
        boolean useTrainingLabels, TrainingOptions trainingOptions, Context context) {
        trainingOptions = trainingOptions == null ? new TrainingOptions() : trainingOptions;
        return new PollerFlux<>(trainingOptions.getPollInterval(),
            getTrainingActivationOperation(trainingFilesUrl, useTrainingLabels,
                trainingOptions.getTrainingFileFilter() != null
                    ? trainingOptions.getTrainingFileFilter().isSubfoldersIncluded()
                    : false,
                trainingOptions.getTrainingFileFilter() != null
                    ? trainingOptions.getTrainingFileFilter().getPrefix()
                    : null,
                trainingOptions.getModelName(), context),
            createModelPollOperation(context),
            (activationResponse, pollingContext) -> Mono.error(new RuntimeException("Cancellation is not supported")),
            fetchModelResultOperation(context));
    }

    /**
     * Get detailed information for a specified custom model id.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCustomModel#string -->
     * <pre>
     * String modelId = &quot;&#123;model_id&#125;&quot;;
     * formTrainingAsyncClient.getCustomModel&#40;modelId&#41;.subscribe&#40;customFormModel -&gt; &#123;
     *     System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *     customFormModel.getSubmodels&#40;&#41;
     *         .forEach&#40;customFormSubmodel -&gt; customFormSubmodel.getFields&#40;&#41;
     *             .forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                 System.out.printf&#40;&quot;Form Type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                     key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     *
     * &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCustomModel#string -->
     *
     * @param modelId The UUID string format model identifier.
     *
     * @return The detailed information for the specified model.
     * @throws IllegalArgumentException If {@code modelId} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CustomFormModel> getCustomModel(String modelId) {
        return getCustomModelWithResponse(modelId).flatMap(FluxUtil::toMono);
    }

    /**
     * Get detailed information for a specified custom model id with Http response.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCustomModelWithResponse#string -->
     * <pre>
     * String modelId = &quot;&#123;model_id&#125;&quot;;
     * formTrainingAsyncClient.getCustomModelWithResponse&#40;modelId&#41;.subscribe&#40;response -&gt; &#123;
     *     System.out.printf&#40;&quot;Response Status Code: %d.&quot;, response.getStatusCode&#40;&#41;&#41;;
     *     CustomFormModel customFormModel = response.getValue&#40;&#41;;
     *     System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *     System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *     customFormModel.getSubmodels&#40;&#41;
     *         .forEach&#40;customFormSubmodel -&gt; customFormSubmodel.getFields&#40;&#41;
     *             .forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                 System.out.printf&#40;&quot;Form Type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                     key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     * &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCustomModelWithResponse#string -->
     *
     * @param modelId The UUID string format model identifier.
     *
     * @return A {@link Response} containing the requested {@link CustomFormModel model}.
     * @throws IllegalArgumentException If {@code modelId} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<CustomFormModel>> getCustomModelWithResponse(String modelId) {
        try {
            return withContext(context -> getCustomModelWithResponse(modelId, context));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    Mono<Response<CustomFormModel>> getCustomModelWithResponse(String modelId, Context context) {
        if (CoreUtils.isNullOrEmpty(modelId)) {
            return monoError(logger, new IllegalArgumentException("'modelId' is required and cannot be null or empty"));
        }
        return customModelsImpl.getWithResponseAsync(UUID.fromString(modelId), true, context)
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(response -> new SimpleResponse<>(response, toCustomFormModel(response.getValue())));
    }

    /**
     * Get account information of the form recognizer account.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getAccountProperties -->
     * <pre>
     * formTrainingAsyncClient.getAccountProperties&#40;&#41;
     *     .subscribe&#40;accountProperties -&gt; &#123;
     *         System.out.printf&#40;&quot;Max number of models that can be trained for this account: %d%n&quot;,
     *             accountProperties.getCustomModelLimit&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Current count of trained custom models: %d%n&quot;,
     *             accountProperties.getCustomModelCount&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getAccountProperties -->
     *
     * @return The requested account information details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<AccountProperties> getAccountProperties() {
        return getAccountPropertiesWithResponse().flatMap(FluxUtil::toMono);
    }

    /**
     * Get account information of the form recognizer account with an Http response.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getAccountPropertiesWithResponse -->
     * <pre>
     * formTrainingAsyncClient.getAccountPropertiesWithResponse&#40;&#41;
     *     .subscribe&#40;response -&gt; &#123;
     *         System.out.printf&#40;&quot;Response Status Code: %d.&quot;, response.getStatusCode&#40;&#41;&#41;;
     *         AccountProperties accountProperties = response.getValue&#40;&#41;;
     *         System.out.printf&#40;&quot;Max number of models that can be trained for this account: %d%n&quot;,
     *             accountProperties.getCustomModelLimit&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Current count of trained custom models: %d%n&quot;,
     *             accountProperties.getCustomModelCount&#40;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getAccountPropertiesWithResponse -->
     *
     * @return A {@link Response} containing the requested account information details.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<AccountProperties>> getAccountPropertiesWithResponse() {
        try {
            return withContext(this::getAccountPropertiesWithResponse);
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    Mono<Response<AccountProperties>> getAccountPropertiesWithResponse(Context context) {
        return customModelsImpl.getSummaryWithResponseAsync(context)
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(response -> new SimpleResponse<>(response, new AccountProperties(
                response.getValue().getSummary().getCount(), response.getValue().getSummary().getLimit())));
    }

    /**
     * Deletes the specified custom model.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.deleteModel#string -->
     * <pre>
     * String modelId = &quot;&#123;model_id&#125;&quot;;
     * formTrainingAsyncClient.deleteModel&#40;modelId&#41;
     *     .subscribe&#40;ignored -&gt; System.out.printf&#40;&quot;Model Id: %s is deleted%n&quot;, modelId&#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.deleteModel#string -->
     *
     * @param modelId The UUID string format model identifier.
     *
     * @return An empty Mono.
     * @throws IllegalArgumentException If {@code modelId} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Void> deleteModel(String modelId) {
        return deleteModelWithResponse(modelId).flatMap(FluxUtil::toMono);
    }

    /**
     * Deletes the specified custom model.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.deleteModelWithResponse#string -->
     * <pre>
     * String modelId = &quot;&#123;model_id&#125;&quot;;
     * formTrainingAsyncClient.deleteModelWithResponse&#40;modelId&#41;
     *     .subscribe&#40;response -&gt; &#123;
     *         System.out.printf&#40;&quot;Response Status Code: %d.&quot;, response.getStatusCode&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model Id: %s is deleted.%n&quot;, modelId&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.deleteModelWithResponse#string -->
     *
     * @param modelId The UUID string format model identifier.
     *
     * @return A {@link Response} containing the status code and HTTP headers.
     * @throws IllegalArgumentException If {@code modelId} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<Void>> deleteModelWithResponse(String modelId) {
        try {
            return withContext(context -> deleteModelWithResponse(modelId, context));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    Mono<Response<Void>> deleteModelWithResponse(String modelId, Context context) {
        if (CoreUtils.isNullOrEmpty(modelId)) {
            return monoError(logger, new IllegalArgumentException("'modelId' is required and cannot be null or empty"));
        }
        return customModelsImpl.deleteWithResponseAsync(UUID.fromString(modelId), context)
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(response -> new SimpleResponse<>(response, null));
    }

    /**
     * List information for each model on the form recognizer account.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.listCustomModels -->
     * <pre>
     * formTrainingAsyncClient.listCustomModels&#40;&#41;
     *     .subscribe&#40;customModel -&gt;
     *         System.out.printf&#40;&quot;Model Id: %s, Model status: %s, Created on: %s, Last updated on: %s.%n&quot;,
     *             customModel.getModelId&#40;&#41;,
     *             customModel.getStatus&#40;&#41;,
     *             customModel.getTrainingStartedOn&#40;&#41;,
     *             customModel.getTrainingCompletedOn&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.listCustomModels -->
     *
     * @return {@link PagedFlux} of {@link CustomFormModelInfo}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    public PagedFlux<CustomFormModelInfo> listCustomModels() {
        try {
            return new PagedFlux<>(() -> withContext(this::listFirstPageModelInfo),
                continuationToken -> withContext(context -> listNextPageModelInfo(continuationToken, context)));
        } catch (RuntimeException ex) {
            return new PagedFlux<>(() -> monoError(logger, ex));
        }
    }

    /**
     * List information for each model on the form recognizer account with an Http response and a specified
     * {@link Context}.
     *
     * @param context Additional context that is passed through the Http pipeline during the service call.
     *
     * @return {@link PagedFlux} of {@link CustomFormModelInfo}.
     */
    PagedFlux<CustomFormModelInfo> listCustomModels(Context context) {
        return new PagedFlux<>(() -> listFirstPageModelInfo(context),
            continuationToken -> listNextPageModelInfo(continuationToken, context));
    }

    /**
     * Copy a custom model stored in this resource (the source) to the user specified target Form Recognizer resource.
     *
     * <p>This should be called with the source Form Recognizer resource (with the model that is intended to be copied).
     * The target parameter should be supplied from the target resource's output from
     * {@link FormTrainingAsyncClient#getCopyAuthorization(String, String)} method.
     * </p>
     *
     * <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCopyModel#string-copyAuthorization -->
     * <pre>
     * String resourceId = &quot;target-resource-Id&quot;;
     * String resourceRegion = &quot;target-resource-region&quot;;
     * String copyModelId = &quot;copy-model-Id&quot;;
     * formTrainingAsyncClient.getCopyAuthorization&#40;resourceId, resourceRegion&#41;
     *     .flatMapMany&#40;copyAuthorization -&gt; formTrainingAsyncClient.beginCopyModel&#40;copyModelId, copyAuthorization&#41;&#41;
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *     .subscribe&#40;customFormModelInfo -&gt;
     *         System.out.printf&#40;&quot;Copied model has model Id: %s, model status: %s, training started on: %s,&quot;
     *             + &quot; training completed on: %s.%n&quot;,
     *         customFormModelInfo.getModelId&#40;&#41;,
     *         customFormModelInfo.getStatus&#40;&#41;,
     *         customFormModelInfo.getTrainingStartedOn&#40;&#41;,
     *         customFormModelInfo.getTrainingCompletedOn&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCopyModel#string-copyAuthorization -->
     *
     * @param modelId Model identifier of the model to copy to the target Form Recognizer resource
     * @param target the copy authorization to the target Form Recognizer resource. The copy authorization can be
     * generated from the target resource's call to {@link FormTrainingAsyncClient#getCopyAuthorization(String, String)}
     *
     * @return A {@link PollerFlux} that polls the copy model operation until it has completed, has failed,
     * or has been cancelled. The completed operation returns the copied model {@link CustomFormModelInfo}.
     * @throws FormRecognizerException If copy operation fails and model with {@link OperationStatus#FAILED} is created.
     * @throws NullPointerException If {@code modelId}, {@code target} is null.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModelInfo> beginCopyModel(String modelId,
        CopyAuthorization target) {
        return beginCopyModel(modelId, target, null);
    }

    /**
     * Copy a custom model stored in this resource (the source) to the user specified target Form Recognizer resource.
     *
     * <p>This should be called with the source Form Recognizer resource (with the model that is intended to be copied).
     * The target parameter should be supplied from the target resource's output from
     * {@link FormTrainingAsyncClient#getCopyAuthorization(String, String)} method.
     * </p>
     *
     * <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCopyModel#string-copyAuthorization-Duration -->
     * <pre>
     * String resourceId = &quot;target-resource-Id&quot;;
     * String resourceRegion = &quot;target-resource-region&quot;;
     * String copyModelId = &quot;copy-model-Id&quot;;
     * formTrainingAsyncClient.getCopyAuthorization&#40;resourceId, resourceRegion&#41;
     *     .flatMapMany&#40;copyAuthorization -&gt; formTrainingAsyncClient.beginCopyModel&#40;copyModelId, copyAuthorization,
     *         Duration.ofSeconds&#40;5&#41;&#41;&#41;
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *         .subscribe&#40;customFormModelInfo -&gt;
     *             System.out.printf&#40;&quot;Copied model has model Id: %s, model status: %s, training started on: %s,&quot;
     *                 + &quot;training completed on: %s.%n&quot;,
     *             customFormModelInfo.getModelId&#40;&#41;,
     *             customFormModelInfo.getStatus&#40;&#41;,
     *             customFormModelInfo.getTrainingStartedOn&#40;&#41;,
     *             customFormModelInfo.getTrainingCompletedOn&#40;&#41;&#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCopyModel#string-copyAuthorization-Duration -->
     *
     * @param modelId Model identifier of the model to copy to the target Form Recognizer resource
     * @param target the copy authorization to the target Form Recognizer resource. The copy authorization can be
     * generated from the target resource's call to {@link FormTrainingAsyncClient#getCopyAuthorization(String, String)}
     * @param pollInterval Duration between each poll for the operation status. If none is specified, a default of
     * 5 seconds is used.
     *
     * @return A {@link PollerFlux} that polls the copy model operation until it has completed, has failed,
     * or has been cancelled. The completed operation returns the copied model {@link CustomFormModelInfo}.
     * @throws FormRecognizerException If copy operation fails and model with {@link OperationStatus#FAILED}
     * is created.
     * @throws NullPointerException If {@code modelId}, {@code target} is null.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModelInfo> beginCopyModel(String modelId,
        CopyAuthorization target, Duration pollInterval) {
        return beginCopyModel(modelId, target, pollInterval, Context.NONE);
    }

    PollerFlux<FormRecognizerOperationResult, CustomFormModelInfo> beginCopyModel(String modelId,
        CopyAuthorization target, Duration pollInterval, Context context) {
        final Duration interval = pollInterval != null ? pollInterval : DEFAULT_POLL_INTERVAL;
        return new PollerFlux<>(interval, getCopyActivationOperation(modelId, target, context),
            createCopyPollOperation(modelId, context),
            (activationResponse, pollingContext) -> Mono.error(new RuntimeException("Cancellation is not supported")),
            fetchCopyModelResultOperation(modelId, target.getModelId(), context));
    }

    /**
     * Generate authorization for copying a custom model into the target Form Recognizer resource.
     *
     * @param resourceId Azure Resource Id of the target Form Recognizer resource where the model will be copied to.
     * @param resourceRegion Location of the target Form Recognizer resource. A valid Azure region name supported
     * by Cognitive Services.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCopyAuthorization#string-string -->
     * <pre>
     * String resourceId = &quot;target-resource-Id&quot;;
     * String resourceRegion = &quot;target-resource-region&quot;;
     * formTrainingAsyncClient.getCopyAuthorization&#40;resourceId, resourceRegion&#41;
     *     .subscribe&#40;copyAuthorization -&gt;
     *         System.out.printf&#40;&quot;Copy Authorization for model id: %s, access token: %s, expiration time: %s, &quot;
     *                 + &quot;target resource Id; %s, target resource region: %s%n&quot;,
     *             copyAuthorization.getModelId&#40;&#41;,
     *             copyAuthorization.getAccessToken&#40;&#41;,
     *             copyAuthorization.getExpiresOn&#40;&#41;,
     *             copyAuthorization.getResourceId&#40;&#41;,
     *             copyAuthorization.getResourceRegion&#40;&#41;
     *         &#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCopyAuthorization#string-string -->
     *
     * @return The {@link CopyAuthorization} that could be used to authorize copying model between resources.
     * @throws NullPointerException If {@code resourceId}, {@code resourceRegion} is null.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<CopyAuthorization> getCopyAuthorization(String resourceId, String resourceRegion) {
        return getCopyAuthorizationWithResponse(resourceId, resourceRegion).flatMap(FluxUtil::toMono);
    }

    /**
     * Generate authorization for copying a custom model into the target Form Recognizer resource.
     * This should be called by the target resource (where the model will be copied to) and the output can be passed as
     * the target parameter into {@link FormTrainingAsyncClient#beginCopyModel(String, CopyAuthorization)}.
     *
     * @param resourceId Azure Resource Id of the target Form Recognizer resource where the model will be copied to.
     * @param resourceRegion Location of the target Form Recognizer resource. A valid Azure region name supported by
     * Cognitive Services.
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCopyAuthorizationWithResponse#string-string -->
     * <pre>
     * String resourceId = &quot;target-resource-Id&quot;;
     * String resourceRegion = &quot;target-resource-region&quot;;
     * formTrainingAsyncClient.getCopyAuthorizationWithResponse&#40;resourceId, resourceRegion&#41;
     *     .subscribe&#40;copyAuthorization -&gt;
     *         System.out.printf&#40;&quot;Copy Authorization response status: %s, for model id: %s, access token: %s, &quot;
     *                 + &quot;expiration time: %s, target resource Id; %s, target resource region: %s%n&quot;,
     *         copyAuthorization.getStatusCode&#40;&#41;,
     *         copyAuthorization.getValue&#40;&#41;.getModelId&#40;&#41;,
     *         copyAuthorization.getValue&#40;&#41;.getAccessToken&#40;&#41;,
     *         copyAuthorization.getValue&#40;&#41;.getExpiresOn&#40;&#41;,
     *         copyAuthorization.getValue&#40;&#41;.getResourceId&#40;&#41;,
     *         copyAuthorization.getValue&#40;&#41;.getResourceRegion&#40;&#41;
     *     &#41;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.getCopyAuthorizationWithResponse#string-string -->
     *
     * @return A {@link Response} containing the {@link CopyAuthorization} that could be used to authorize copying
     * model between resources.
     * @throws NullPointerException If {@code resourceId}, {@code resourceRegion} is null.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    public Mono<Response<CopyAuthorization>> getCopyAuthorizationWithResponse(String resourceId,
        String resourceRegion) {
        try {
            return withContext(context -> getCopyAuthorizationWithResponse(resourceId, resourceRegion, context));
        } catch (RuntimeException ex) {
            return monoError(logger, ex);
        }
    }

    /**
     * Create a composed model from the provided list of existing models in the account.
     *
     * <p>This operations fails if the list consists of an invalid, non-existing model Id or duplicate Ids.
     * This operation is currently only supported for custom models trained using labels.
     * </p>
     *
     * <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCreateComposedModel#list -->
     * <pre>
     * String labeledModelId1 = &quot;5f21ab8d-71a6-42d8-9856-ef5985c486a8&quot;;
     * String labeledModelId2 = &quot;d7b0904c-841f-46f9-a9f4-3f2273eef7c9&quot;;
     * formTrainingAsyncClient.beginCreateComposedModel&#40;Arrays.asList&#40;labeledModelId1, labeledModelId2&#41;&#41;
     *     &#47;&#47; if training polling operation completed, retrieve the final result.
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *     .subscribe&#40;customFormModel -&gt; &#123;
     *         System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Is this a composed model: %s%n&quot;,
     *             customFormModel.getCustomModelProperties&#40;&#41;.isComposed&#40;&#41;&#41;;
     *         customFormModel.getSubmodels&#40;&#41;
     *             .forEach&#40;customFormSubmodel -&gt; customFormSubmodel.getFields&#40;&#41;
     *                 .forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                     System.out.printf&#40;&quot;Form type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                         key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCreateComposedModel#list -->
     *
     * @param modelIds The list of models Ids to form the composed model.
     *
     * @return A {@link PollerFlux} that polls the create composed model operation until it has completed, has failed,
     * or has been cancelled. The completed operation returns the created {@link CustomFormModel composed model}.
     * @throws FormRecognizerException If create composed model operation fails and model with
     * {@link OperationStatus#FAILED} is created.
     * @throws NullPointerException If the list of {@code modelIds} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginCreateComposedModel(List<String> modelIds) {
        return beginCreateComposedModel(modelIds, null, null);
    }

    /**
     * Create a composed model from the provided list of existing models in the account.
     *
     * <p>This operations fails if the list consists of an invalid, non-existing model Id or duplicate Ids.
     * This operation is currently only supported for custom models trained using labels.
     * </p>
     *
     *  <p>The service does not support cancellation of the long running operation and returns with an
     * error message indicating absence of cancellation support.</p>
     *
     * <p><strong>Code sample</strong></p>
     * <!-- src_embed com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCreateComposedModel#list-Options -->
     * <pre>
     * String labeledModelId1 = &quot;5f21ab8d-71a6-42d8-9856-ef5985c486a8&quot;;
     * String labeledModelId2 = &quot;d7b0904c-841f-46f9-a9f4-3f2273eef7c9&quot;;
     * formTrainingAsyncClient.beginCreateComposedModel&#40;Arrays.asList&#40;labeledModelId1, labeledModelId2&#41;,
     *     new CreateComposedModelOptions&#40;&#41;
     *         .setModelName&#40;&quot;my composed model name&quot;&#41;&#41;
     *     .setPollInterval&#40;Duration.ofSeconds&#40;5&#41;&#41;
     *     &#47;&#47; if training polling operation completed, retrieve the final result.
     *     .flatMap&#40;AsyncPollResponse::getFinalResult&#41;
     *     .subscribe&#40;customFormModel -&gt; &#123;
     *         System.out.printf&#40;&quot;Model Id: %s%n&quot;, customFormModel.getModelId&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model Status: %s%n&quot;, customFormModel.getModelStatus&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Model display name: %s%n&quot;, customFormModel.getModelName&#40;&#41;&#41;;
     *         System.out.printf&#40;&quot;Is this a composed model: %s%n&quot;,
     *             customFormModel.getCustomModelProperties&#40;&#41;.isComposed&#40;&#41;&#41;;
     *
     *         customFormModel.getSubmodels&#40;&#41;
     *             .forEach&#40;customFormSubmodel -&gt; customFormSubmodel.getFields&#40;&#41;
     *                 .forEach&#40;&#40;key, customFormModelField&#41; -&gt;
     *                     System.out.printf&#40;&quot;Form type: %s Field Text: %s Field Accuracy: %f%n&quot;,
     *                         key, customFormModelField.getName&#40;&#41;, customFormModelField.getAccuracy&#40;&#41;&#41;&#41;&#41;;
     *     &#125;&#41;;
     * </pre>
     * <!-- end com.azure.ai.formrecognizer.v3.training.FormTrainingAsyncClient.beginCreateComposedModel#list-Options -->
     *
     * @param modelIds The list of models Ids to form the composed model.
     * @param createComposedModelOptions The configurable {@link CreateComposedModelOptions options} to pass when
     * creating a composed model.
     *
     * @return A {@link PollerFlux} that polls the create composed model operation until it has completed, has failed,
     * or has been cancelled. The completed operation returns the copied model {@link CustomFormModel}.
     * @throws FormRecognizerException If create composed model operation fails and model with
     * {@link OperationStatus#FAILED} is created.
     * @throws NullPointerException If the list of {@code modelIds} is null or empty.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    public PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginCreateComposedModel(List<String> modelIds,
        CreateComposedModelOptions createComposedModelOptions) {
        return beginCreateComposedModel(modelIds, createComposedModelOptions, Context.NONE);
    }

    PollerFlux<FormRecognizerOperationResult, CustomFormModel> beginCreateComposedModel(List<String> modelIds,
        CreateComposedModelOptions creatComposeModelOptions, Context context) {
        try {
            if (CoreUtils.isNullOrEmpty(modelIds)) {
                return PollerFlux
                    .error(logger.logExceptionAsError(new NullPointerException("'modelIds' cannot be null or empty")));
            }
            creatComposeModelOptions = getCreateComposeModelOptions(creatComposeModelOptions);

            final ComposeRequest composeRequest
                = new ComposeRequest().setModelIds(modelIds.stream().map(UUID::fromString).collect(Collectors.toList()))
                    .setModelName(creatComposeModelOptions.getModelName());

            return new PollerFlux<>(DEFAULT_POLL_INTERVAL,
                urlActivationOperation(() -> customModelsImpl.composeWithResponseAsync(composeRequest, context)
                    .map(response -> new FormRecognizerOperationResult(
                        parseModelId(response.getDeserializedHeaders().getLocation()))),
                    logger),
                createModelPollOperation(context), (activationResponse, pollingContext) -> Mono
                    .error(new RuntimeException("Cancellation is not supported")),
                fetchModelResultOperation(context));
        } catch (RuntimeException ex) {
            return PollerFlux.error(ex);
        }
    }

    Mono<Response<CopyAuthorization>> getCopyAuthorizationWithResponse(String resourceId, String resourceRegion,
        Context context) {
        if (resourceId == null) {
            return monoError(logger, new NullPointerException("'resourceId' cannot be null."));
        }
        if (resourceRegion == null) {
            return monoError(logger, new NullPointerException("'resourceRegion' cannot be null."));
        }
        return customModelsImpl.authorizeModelCopyWithResponseAsync(context)
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(response -> {
                CopyAuthorizationResult copyAuthorizationResult = response.getValue();
                return new SimpleResponse<>(response,
                    new CopyAuthorization(copyAuthorizationResult.getModelId(),
                        copyAuthorizationResult.getAccessToken(), resourceId, resourceRegion,
                        copyAuthorizationResult.getExpirationDateTimeTicks()));
            });
    }

    private Mono<PagedResponse<CustomFormModelInfo>> listFirstPageModelInfo(Context context) {
        return customModelsImpl.listSinglePageAsync(context)
            .doOnRequest(ignoredValue -> logger.info("Listing information for all models"))
            .doOnSuccess(response -> logger.info("Listed all models"))
            .doOnError(error -> logger.warning("Failed to list all models information", error))
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                toCustomFormModelInfo(res.getValue()), res.getContinuationToken(), null));
    }

    private Mono<PagedResponse<CustomFormModelInfo>> listNextPageModelInfo(String nextPageLink, Context context) {
        if (CoreUtils.isNullOrEmpty(nextPageLink)) {
            return Mono.empty();
        }
        return customModelsImpl.listNextSinglePageAsync(nextPageLink, context)
            .doOnSubscribe(ignoredValue -> logger.info("Retrieving the next listing page - Page {}", nextPageLink))
            .doOnSuccess(response -> logger.info("Retrieved the next listing page - Page {}", nextPageLink))
            .doOnError(
                error -> logger.warning("Failed to retrieve the next listing page - Page {}", nextPageLink, error))
            .onErrorMap(Utility::mapToHttpResponseExceptionIfExists)
            .map(res -> new PagedResponseBase<>(res.getRequest(), res.getStatusCode(), res.getHeaders(),
                toCustomFormModelInfo(res.getValue()), res.getContinuationToken(), null));
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<CustomFormModelInfo>>
        fetchCopyModelResultOperation(String modelId, String copyModelId, Context context) {
        return (pollingContext) -> {
            try {
                final UUID resultUid = UUID.fromString(pollingContext.getLatestResponse().getValue().getResultId());
                if (modelId == null) {
                    return Mono.error(new NullPointerException("'modelId' cannot be null."));
                }
                return customModelsImpl.getCopyResultAsync(UUID.fromString(modelId), resultUid, context)
                    .map(copyOperationResult -> {
                        return new CustomFormModelInfo(copyModelId,
                            copyOperationResult.getStatus() == OperationStatus.SUCCEEDED
                                ? CustomFormModelStatus.READY
                                : CustomFormModelStatus.fromString(copyOperationResult.getStatus().toString()),
                            copyOperationResult.getCreatedDateTime(), copyOperationResult.getLastUpdatedDateTime());
                    })
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (RuntimeException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<PollResponse<FormRecognizerOperationResult>>>
        createCopyPollOperation(String modelId, Context context) {
        return (pollingContext) -> {
            try {
                PollResponse<FormRecognizerOperationResult> operationResultPollResponse
                    = pollingContext.getLatestResponse();
                UUID targetId = UUID.fromString(operationResultPollResponse.getValue().getResultId());
                return customModelsImpl.getCopyResultWithResponseAsync(UUID.fromString(modelId), targetId, context)
                    .flatMap(modelSimpleResponse -> processCopyModelResponse(modelSimpleResponse,
                        operationResultPollResponse))
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (HttpResponseException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<FormRecognizerOperationResult>>
        getCopyActivationOperation(String modelId, CopyAuthorization target, Context context) {
        return (pollingContext) -> {
            try {
                if (modelId == null) {
                    return Mono.error(new NullPointerException("'modelId' cannot be null."));
                }
                if (target == null) {
                    return Mono.error(new NullPointerException("'target' cannot be null."));
                }
                CopyRequest copyRequest = new CopyRequest().setTargetResourceId(target.getResourceId())
                    .setTargetResourceRegion(target.getResourceRegion())
                    .setCopyAuthorization(new CopyAuthorizationResult().setModelId(target.getModelId())
                        .setAccessToken(target.getAccessToken())
                        .setExpirationDateTimeTicks(target.getExpiresOn().toEpochSecond()));
                return customModelsImpl.copyWithResponseAsync(UUID.fromString(modelId), copyRequest, context)
                    .map(response -> new FormRecognizerOperationResult(
                        parseModelId(response.getDeserializedHeaders().getOperationLocation())))
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (RuntimeException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Mono<PollResponse<FormRecognizerOperationResult>> processCopyModelResponse(
        Response<CopyOperationResult> copyModel,
        PollResponse<FormRecognizerOperationResult> copyModelOperationResponse) {
        LongRunningOperationStatus status;
        switch (copyModel.getValue().getStatus()) {
            case NOT_STARTED:
            case RUNNING:
                status = LongRunningOperationStatus.IN_PROGRESS;
                break;

            case SUCCEEDED:
                status = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
                break;

            case FAILED:
                return monoError(logger,
                    new FormRecognizerException("Copy operation failed",
                        copyModel.getValue()
                            .getCopyResult()
                            .getErrors()
                            .stream()
                            .map(errorInformation -> new FormRecognizerErrorInformation(errorInformation.getCode(),
                                errorInformation.getMessage()))
                            .collect(Collectors.toList())));

            default:
                status = LongRunningOperationStatus.fromString(copyModel.getValue().getStatus().toString(), true);
                break;
        }
        return Mono.just(new PollResponse<>(status, copyModelOperationResponse.getValue()));
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<CustomFormModel>>
        fetchModelResultOperation(Context context) {
        return (pollingContext) -> {
            try {
                final UUID modelUid = UUID.fromString(pollingContext.getLatestResponse().getValue().getResultId());
                return customModelsImpl.getWithResponseAsync(modelUid, true, context)
                    .map(modelSimpleResponse -> toCustomFormModel(modelSimpleResponse.getValue()))
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (RuntimeException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<PollResponse<FormRecognizerOperationResult>>>
        createModelPollOperation(Context context) {
        return (pollingContext) -> {
            try {
                PollResponse<FormRecognizerOperationResult> operationResultPollResponse
                    = pollingContext.getLatestResponse();
                UUID modelUid = UUID.fromString(operationResultPollResponse.getValue().getResultId());
                return customModelsImpl.getWithResponseAsync(modelUid, true, context)
                    .flatMap(modelSimpleResponse -> processTrainingModelResponse(modelSimpleResponse,
                        operationResultPollResponse))
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (HttpResponseException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Function<PollingContext<FormRecognizerOperationResult>, Mono<FormRecognizerOperationResult>>
        getTrainingActivationOperation(String trainingFilesUrl, boolean useTrainingLabels, boolean includeSubfolders,
            String filePrefix, String modelName, Context context) {
        return (pollingContext) -> {
            try {
                if (trainingFilesUrl == null) {
                    return Mono.error(new NullPointerException("'trainingFilesUrl' cannot be null."));
                }
                TrainSourceFilter trainSourceFilter
                    = new TrainSourceFilter().setIncludeSubFolders(includeSubfolders).setPrefix(filePrefix);
                TrainRequest serviceTrainRequest = new TrainRequest().setSource(trainingFilesUrl)
                    .setSourceFilter(trainSourceFilter)
                    .setUseLabelFile(useTrainingLabels)
                    .setModelName(modelName);
                return customModelsImpl.trainWithResponseAsync(serviceTrainRequest, context)
                    .map(response -> new FormRecognizerOperationResult(
                        parseModelId(response.getDeserializedHeaders().getLocation())))
                    .onErrorMap(Utility::mapToHttpResponseExceptionIfExists);
            } catch (RuntimeException ex) {
                return monoError(logger, ex);
            }
        };
    }

    private Mono<PollResponse<FormRecognizerOperationResult>> processTrainingModelResponse(
        Response<Model> trainingModel, PollResponse<FormRecognizerOperationResult> trainingModelOperationResponse) {
        LongRunningOperationStatus status;
        switch (trainingModel.getValue().getModelInfo().getStatus()) {
            case CREATING:
                status = LongRunningOperationStatus.IN_PROGRESS;
                break;

            case READY:
                status = LongRunningOperationStatus.SUCCESSFULLY_COMPLETED;
                break;

            case INVALID:
                return monoError(logger,
                    new FormRecognizerException(
                        String.format("Invalid model created" + " with model Id %s",
                            trainingModel.getValue().getModelInfo().getModelId()),
                        trainingModel.getValue()
                            .getTrainResult()
                            .getErrors()
                            .stream()
                            .map(errorInformation -> new FormRecognizerErrorInformation(errorInformation.getCode(),
                                errorInformation.getMessage()))
                            .collect(Collectors.toList())));

            default:
                status = LongRunningOperationStatus
                    .fromString(trainingModel.getValue().getModelInfo().getStatus().toString(), true);
                break;
        }
        return Mono.just(new PollResponse<>(status, trainingModelOperationResponse.getValue()));
    }
}
