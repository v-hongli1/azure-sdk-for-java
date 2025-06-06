// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of NetAppResourceQuotaLimitsAccounts.
 */
public interface NetAppResourceQuotaLimitsAccounts {
    /**
     * Gets a list of quota limits for all quotas that are under account.
     * 
     * Gets a list of quota limits for all quotas that are under account. Currently PoolsPerAccount is the only one.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName The name of the NetApp account.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of quota limits for all quotas that are under account as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<QuotaItem> list(String resourceGroupName, String accountName);

    /**
     * Gets a list of quota limits for all quotas that are under account.
     * 
     * Gets a list of quota limits for all quotas that are under account. Currently PoolsPerAccount is the only one.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName The name of the NetApp account.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return a list of quota limits for all quotas that are under account as paginated response with
     * {@link PagedIterable}.
     */
    PagedIterable<QuotaItem> list(String resourceGroupName, String accountName, Context context);

    /**
     * Gets the quota limits for the specific quota that is provided under the account.
     * 
     * Get the default, current and usages account quota limit.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName The name of the NetApp account.
     * @param quotaLimitName The name of the Quota Limit.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the default, current and usages account quota limit along with {@link Response}.
     */
    Response<QuotaItem> getWithResponse(String resourceGroupName, String accountName, String quotaLimitName,
        Context context);

    /**
     * Gets the quota limits for the specific quota that is provided under the account.
     * 
     * Get the default, current and usages account quota limit.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param accountName The name of the NetApp account.
     * @param quotaLimitName The name of the Quota Limit.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the default, current and usages account quota limit.
     */
    QuotaItem get(String resourceGroupName, String accountName, String quotaLimitName);
}
