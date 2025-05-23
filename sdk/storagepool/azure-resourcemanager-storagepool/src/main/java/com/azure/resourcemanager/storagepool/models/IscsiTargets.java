// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagepool.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;

/**
 * Resource collection API of IscsiTargets.
 */
public interface IscsiTargets {
    /**
     * Get iSCSI Targets in a Disk pool.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return iSCSI Targets in a Disk pool as paginated response with {@link PagedIterable}.
     */
    PagedIterable<IscsiTarget> listByDiskPool(String resourceGroupName, String diskPoolName);

    /**
     * Get iSCSI Targets in a Disk pool.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return iSCSI Targets in a Disk pool as paginated response with {@link PagedIterable}.
     */
    PagedIterable<IscsiTarget> listByDiskPool(String resourceGroupName, String diskPoolName, Context context);

    /**
     * Delete an iSCSI Target.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @param iscsiTargetName The name of the iSCSI Target.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String diskPoolName, String iscsiTargetName);

    /**
     * Delete an iSCSI Target.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @param iscsiTargetName The name of the iSCSI Target.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void delete(String resourceGroupName, String diskPoolName, String iscsiTargetName, Context context);

    /**
     * Get an iSCSI Target.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @param iscsiTargetName The name of the iSCSI Target.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an iSCSI Target along with {@link Response}.
     */
    Response<IscsiTarget> getWithResponse(String resourceGroupName, String diskPoolName, String iscsiTargetName,
        Context context);

    /**
     * Get an iSCSI Target.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param diskPoolName The name of the Disk Pool.
     * @param iscsiTargetName The name of the iSCSI Target.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an iSCSI Target.
     */
    IscsiTarget get(String resourceGroupName, String diskPoolName, String iscsiTargetName);

    /**
     * Get an iSCSI Target.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an iSCSI Target along with {@link Response}.
     */
    IscsiTarget getById(String id);

    /**
     * Get an iSCSI Target.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an iSCSI Target along with {@link Response}.
     */
    Response<IscsiTarget> getByIdWithResponse(String id, Context context);

    /**
     * Delete an iSCSI Target.
     * 
     * @param id the resource ID.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteById(String id);

    /**
     * Delete an iSCSI Target.
     * 
     * @param id the resource ID.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void deleteByIdWithResponse(String id, Context context);

    /**
     * Begins definition for a new IscsiTarget resource.
     * 
     * @param name resource name.
     * @return the first stage of the new IscsiTarget definition.
     */
    IscsiTarget.DefinitionStages.Blank define(String name);
}
