// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

/**
 * Samples for SiteCertificates DeleteSlot.
 */
public final class SiteCertificatesDeleteSlotSamples {
    /*
     * x-ms-original-file:
     * specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/DeleteSiteCertificateSlot.json
     */
    /**
     * Sample code: Delete Certificate for slot.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void deleteCertificateForSlot(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getSiteCertificates()
            .deleteSlotWithResponse("testrg123", "testSiteName", "staging", "testc6282",
                com.azure.core.util.Context.NONE);
    }
}
