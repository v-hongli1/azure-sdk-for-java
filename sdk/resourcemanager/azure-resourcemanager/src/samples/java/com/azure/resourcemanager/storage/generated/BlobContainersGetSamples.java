// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.generated;

/**
 * Samples for BlobContainers Get.
 */
public final class BlobContainersGetSamples {
    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/BlobContainersGet.json
     */
    /**
     * Sample code: GetContainers.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getContainers(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getBlobContainers()
            .getWithResponse("res9871", "sto6217", "container1634", com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/
     * BlobContainersGetWithAllowProtectedAppendWritesAll.json
     */
    /**
     * Sample code: GetBlobContainersGetWithAllowProtectedAppendWritesAll.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        getBlobContainersGetWithAllowProtectedAppendWritesAll(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getBlobContainers()
            .getWithResponse("res9871", "sto6217", "container1634", com.azure.core.util.Context.NONE);
    }
}
