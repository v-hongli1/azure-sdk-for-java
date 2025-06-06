// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

/**
 * Samples for StorageAppliances ListByResourceGroup.
 */
public final class StorageAppliancesListByResourceGroupSamples {
    /*
     * x-ms-original-file:
     * specification/networkcloud/resource-manager/Microsoft.NetworkCloud/preview/2024-10-01-preview/examples/
     * StorageAppliances_ListByResourceGroup.json
     */
    /**
     * Sample code: List storage appliances for resource group.
     * 
     * @param manager Entry point to NetworkCloudManager.
     */
    public static void
        listStorageAppliancesForResourceGroup(com.azure.resourcemanager.networkcloud.NetworkCloudManager manager) {
        manager.storageAppliances().listByResourceGroup("resourceGroupName", com.azure.core.util.Context.NONE);
    }
}
