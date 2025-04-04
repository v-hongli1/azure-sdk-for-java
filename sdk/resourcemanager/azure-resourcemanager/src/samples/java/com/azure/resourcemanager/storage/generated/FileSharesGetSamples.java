// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.generated;

/**
 * Samples for FileShares Get.
 */
public final class FileSharesGetSamples {
    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/FileSharesGet_Stats.json
     */
    /**
     * Sample code: GetShareStats.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getShareStats(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getFileShares()
            .getWithResponse("res9871", "sto6217", "share1634", "stats", null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/FileSharesGet_PaidBursting.
     * json
     */
    /**
     * Sample code: GetSharePaidBursting.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getSharePaidBursting(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getFileShares()
            .getWithResponse("res9871", "sto6217", "share1634", null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/FileSharesGet_ProvisionedV2.
     * json
     */
    /**
     * Sample code: GetShareProvisionedV2.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getShareProvisionedV2(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getFileShares()
            .getWithResponse("res9871", "sto6217", "share1634", null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/storage/resource-manager/Microsoft.Storage/stable/2024-01-01/examples/FileSharesGet.json
     */
    /**
     * Sample code: GetShares.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getShares(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.storageAccounts()
            .manager()
            .serviceClient()
            .getFileShares()
            .getWithResponse("res9871", "sto6217", "share1634", null, null, com.azure.core.util.Context.NONE);
    }
}
