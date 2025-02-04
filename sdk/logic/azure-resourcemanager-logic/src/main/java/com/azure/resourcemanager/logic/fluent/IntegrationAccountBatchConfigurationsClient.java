// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.logic.fluent.models.BatchConfigurationInner;

/**
 * An instance of this class provides access to all the operations defined in
 * IntegrationAccountBatchConfigurationsClient.
 */
public interface IntegrationAccountBatchConfigurationsClient {
    /**
     * List the batch configurations for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of batch configurations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BatchConfigurationInner> list(String resourceGroupName, String integrationAccountName);

    /**
     * List the batch configurations for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a collection of batch configurations as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<BatchConfigurationInner> list(String resourceGroupName, String integrationAccountName,
        Context context);

    /**
     * Get a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a batch configuration for an integration account along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BatchConfigurationInner> getWithResponse(String resourceGroupName, String integrationAccountName,
        String batchConfigurationName, Context context);

    /**
     * Get a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a batch configuration for an integration account.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BatchConfigurationInner get(String resourceGroupName, String integrationAccountName, String batchConfigurationName);

    /**
     * Create or update a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @param batchConfiguration The batch configuration.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the batch configuration resource definition along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<BatchConfigurationInner> createOrUpdateWithResponse(String resourceGroupName,
        String integrationAccountName, String batchConfigurationName, BatchConfigurationInner batchConfiguration,
        Context context);

    /**
     * Create or update a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @param batchConfiguration The batch configuration.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the batch configuration resource definition.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    BatchConfigurationInner createOrUpdate(String resourceGroupName, String integrationAccountName,
        String batchConfigurationName, BatchConfigurationInner batchConfiguration);

    /**
     * Delete a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String integrationAccountName,
        String batchConfigurationName, Context context);

    /**
     * Delete a batch configuration for an integration account.
     * 
     * @param resourceGroupName The resource group name.
     * @param integrationAccountName The integration account name.
     * @param batchConfigurationName The batch configuration name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String integrationAccountName, String batchConfigurationName);
}
