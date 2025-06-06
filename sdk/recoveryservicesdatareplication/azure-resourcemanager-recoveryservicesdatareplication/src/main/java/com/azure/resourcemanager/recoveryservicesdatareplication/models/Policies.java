// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of Policies.
 */
public interface Policies {
    /**
     * Gets the details of the policy.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @param policyName The policy name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the policy along with {@link Response}.
     */
    Response<PolicyModel> getWithResponse(String resourceGroupName, String vaultName, String policyName,
        Context context);

    /**
     * Gets the details of the policy.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @param policyName The policy name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the policy.
     */
    PolicyModel get(String resourceGroupName, String vaultName, String policyName);

    /**
     * Removes the policy.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @param policyName The policy name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String vaultName, String policyName);

    /**
     * Removes the policy.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @param policyName The policy name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String vaultName, String policyName, Context context);

    /**
     * Gets the list of policies in the given vault.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of policies in the given vault as paginated response with {@link PagedIterable}.
     */
    PagedIterable<PolicyModel> list(String resourceGroupName, String vaultName);

    /**
     * Gets the list of policies in the given vault.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param vaultName The vault name.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the list of policies in the given vault as paginated response with {@link PagedIterable}.
     */
    PagedIterable<PolicyModel> list(String resourceGroupName, String vaultName, Context context);

    /**
     * Gets the details of the policy.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the policy along with {@link Response}.
     */
    PolicyModel getById(String id);

    /**
     * Gets the details of the policy.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the policy along with {@link Response}.
     */
    Response<PolicyModel> getByIdWithResponse(String id, Context context);

    /**
     * Removes the policy.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Removes the policy.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new PolicyModel resource.
     * 
     * @param name resource name.
     * @return the first stage of the new PolicyModel definition.
     */
    PolicyModel.DefinitionStages.Blank define(String name);
}
