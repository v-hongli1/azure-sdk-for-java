// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.migration.assessment.fluent.models.PrivateEndpointConnectionInner;

/**
 * Resource collection API of PrivateEndpointConnectionOperations.
 */
public interface PrivateEndpointConnectionOperations {
    /**
     * List PrivateEndpointConnection resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a PrivateEndpointConnection list operation as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<PrivateEndpointConnection> listByAssessmentProject(String resourceGroupName, String projectName);

    /**
     * List PrivateEndpointConnection resources by AssessmentProject.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response of a PrivateEndpointConnection list operation as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<PrivateEndpointConnection> listByAssessmentProject(String resourceGroupName, String projectName,
        Context context);

    /**
     * Get a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a PrivateEndpointConnection along with {@link Response}.
     */
    Response<PrivateEndpointConnection> getWithResponse(String resourceGroupName, String projectName,
        String privateEndpointConnectionName, Context context);

    /**
     * Get a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a PrivateEndpointConnection.
     */
    PrivateEndpointConnection get(String resourceGroupName, String projectName, String privateEndpointConnectionName);

    /**
     * Create a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @param resource Resource create parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return private endpoint connection resource.
     */
    PrivateEndpointConnection update(String resourceGroupName, String projectName, String privateEndpointConnectionName,
        PrivateEndpointConnectionInner resource);

    /**
     * Create a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @param resource Resource create parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return private endpoint connection resource.
     */
    PrivateEndpointConnection update(String resourceGroupName, String projectName, String privateEndpointConnectionName,
        PrivateEndpointConnectionInner resource, Context context);

    /**
     * Delete a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> deleteWithResponse(String resourceGroupName, String projectName,
        String privateEndpointConnectionName, Context context);

    /**
     * Delete a PrivateEndpointConnection.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param projectName Assessment Project Name.
     * @param privateEndpointConnectionName Private endpoint connection ARM name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String projectName, String privateEndpointConnectionName);
}
