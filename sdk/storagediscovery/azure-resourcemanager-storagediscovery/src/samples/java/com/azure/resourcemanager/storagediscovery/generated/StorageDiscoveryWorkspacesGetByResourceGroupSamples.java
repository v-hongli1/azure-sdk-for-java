// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.storagediscovery.generated;

/**
 * Samples for StorageDiscoveryWorkspaces GetByResourceGroup.
 */
public final class StorageDiscoveryWorkspacesGetByResourceGroupSamples {
    /*
     * x-ms-original-file: 2025-06-01-preview/StorageDiscoveryWorkspaces_Get.json
     */
    /**
     * Sample code: Get a StorageDiscoveryWorkspace.
     * 
     * @param manager Entry point to StorageDiscoveryManager.
     */
    public static void
        getAStorageDiscoveryWorkspace(com.azure.resourcemanager.storagediscovery.StorageDiscoveryManager manager) {
        manager.storageDiscoveryWorkspaces()
            .getByResourceGroupWithResponse("sample-rg", "Sample-Storage-Workspace", com.azure.core.util.Context.NONE);
    }
}
