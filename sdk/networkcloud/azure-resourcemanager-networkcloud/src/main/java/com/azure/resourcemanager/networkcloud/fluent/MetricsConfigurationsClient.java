// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.networkcloud.fluent.models.ClusterMetricsConfigurationInner;
import com.azure.resourcemanager.networkcloud.fluent.models.OperationStatusResultInner;
import com.azure.resourcemanager.networkcloud.models.ClusterMetricsConfigurationPatchParameters;

/**
 * An instance of this class provides access to all the operations defined in MetricsConfigurationsClient.
 */
public interface MetricsConfigurationsClient {
    /**
     * List metrics configurations of the cluster.
     * 
     * Get a list of metrics configurations for the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of metrics configurations for the provided cluster as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ClusterMetricsConfigurationInner> listByCluster(String resourceGroupName, String clusterName);

    /**
     * List metrics configurations of the cluster.
     * 
     * Get a list of metrics configurations for the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of metrics configurations for the provided cluster as paginated response with
     * {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<ClusterMetricsConfigurationInner> listByCluster(String resourceGroupName, String clusterName,
        Context context);

    /**
     * Retrieve the metrics configuration of the cluster.
     * 
     * Get metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics configuration of the provided cluster along with {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<ClusterMetricsConfigurationInner> getWithResponse(String resourceGroupName, String clusterName,
        String metricsConfigurationName, Context context);

    /**
     * Retrieve the metrics configuration of the cluster.
     * 
     * Get metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return metrics configuration of the provided cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ClusterMetricsConfigurationInner get(String resourceGroupName, String clusterName, String metricsConfigurationName);

    /**
     * Create or update metrics configuration of the cluster.
     * 
     * Create new or update the existing metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param metricsConfigurationParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of clusterMetricsConfiguration represents the metrics configuration of
     * an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ClusterMetricsConfigurationInner>, ClusterMetricsConfigurationInner> beginCreateOrUpdate(
        String resourceGroupName, String clusterName, String metricsConfigurationName,
        ClusterMetricsConfigurationInner metricsConfigurationParameters);

    /**
     * Create or update metrics configuration of the cluster.
     * 
     * Create new or update the existing metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param metricsConfigurationParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of clusterMetricsConfiguration represents the metrics configuration of
     * an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ClusterMetricsConfigurationInner>, ClusterMetricsConfigurationInner> beginCreateOrUpdate(
        String resourceGroupName, String clusterName, String metricsConfigurationName,
        ClusterMetricsConfigurationInner metricsConfigurationParameters, String ifMatch, String ifNoneMatch,
        Context context);

    /**
     * Create or update metrics configuration of the cluster.
     * 
     * Create new or update the existing metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param metricsConfigurationParameters The request body.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return clusterMetricsConfiguration represents the metrics configuration of an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ClusterMetricsConfigurationInner createOrUpdate(String resourceGroupName, String clusterName,
        String metricsConfigurationName, ClusterMetricsConfigurationInner metricsConfigurationParameters);

    /**
     * Create or update metrics configuration of the cluster.
     * 
     * Create new or update the existing metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param metricsConfigurationParameters The request body.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return clusterMetricsConfiguration represents the metrics configuration of an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ClusterMetricsConfigurationInner createOrUpdate(String resourceGroupName, String clusterName,
        String metricsConfigurationName, ClusterMetricsConfigurationInner metricsConfigurationParameters,
        String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the metrics configuration of the cluster.
     * 
     * Delete the metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String clusterName, String metricsConfigurationName);

    /**
     * Delete the metrics configuration of the cluster.
     * 
     * Delete the metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<OperationStatusResultInner>, OperationStatusResultInner> beginDelete(String resourceGroupName,
        String clusterName, String metricsConfigurationName, String ifMatch, String ifNoneMatch, Context context);

    /**
     * Delete the metrics configuration of the cluster.
     * 
     * Delete the metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String clusterName, String metricsConfigurationName);

    /**
     * Delete the metrics configuration of the cluster.
     * 
     * Delete the metrics configuration of the provided cluster.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the current status of an async operation.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    OperationStatusResultInner delete(String resourceGroupName, String clusterName, String metricsConfigurationName,
        String ifMatch, String ifNoneMatch, Context context);

    /**
     * Patch metrics configuration of the cluster.
     * 
     * Patch properties of metrics configuration for the provided cluster, or update the tags associated with it.
     * Properties and tag updates can be done independently.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of clusterMetricsConfiguration represents the metrics configuration of
     * an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ClusterMetricsConfigurationInner>, ClusterMetricsConfigurationInner>
        beginUpdate(String resourceGroupName, String clusterName, String metricsConfigurationName);

    /**
     * Patch metrics configuration of the cluster.
     * 
     * Patch properties of metrics configuration for the provided cluster, or update the tags associated with it.
     * Properties and tag updates can be done independently.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param metricsConfigurationUpdateParameters The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of clusterMetricsConfiguration represents the metrics configuration of
     * an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<ClusterMetricsConfigurationInner>, ClusterMetricsConfigurationInner> beginUpdate(
        String resourceGroupName, String clusterName, String metricsConfigurationName, String ifMatch,
        String ifNoneMatch, ClusterMetricsConfigurationPatchParameters metricsConfigurationUpdateParameters,
        Context context);

    /**
     * Patch metrics configuration of the cluster.
     * 
     * Patch properties of metrics configuration for the provided cluster, or update the tags associated with it.
     * Properties and tag updates can be done independently.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return clusterMetricsConfiguration represents the metrics configuration of an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ClusterMetricsConfigurationInner update(String resourceGroupName, String clusterName,
        String metricsConfigurationName);

    /**
     * Patch metrics configuration of the cluster.
     * 
     * Patch properties of metrics configuration for the provided cluster, or update the tags associated with it.
     * Properties and tag updates can be done independently.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param clusterName The name of the cluster.
     * @param metricsConfigurationName The name of the metrics configuration for the cluster.
     * @param ifMatch The ETag of the transformation. Omit this value to always overwrite the current resource. Specify
     * the last-seen ETag value to prevent accidentally overwriting concurrent changes.
     * @param ifNoneMatch Set to '*' to allow a new record set to be created, but to prevent updating an existing
     * resource. Other values will result in error from server as they are not supported.
     * @param metricsConfigurationUpdateParameters The request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return clusterMetricsConfiguration represents the metrics configuration of an on-premises Network Cloud cluster.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    ClusterMetricsConfigurationInner update(String resourceGroupName, String clusterName,
        String metricsConfigurationName, String ifMatch, String ifNoneMatch,
        ClusterMetricsConfigurationPatchParameters metricsConfigurationUpdateParameters, Context context);
}
