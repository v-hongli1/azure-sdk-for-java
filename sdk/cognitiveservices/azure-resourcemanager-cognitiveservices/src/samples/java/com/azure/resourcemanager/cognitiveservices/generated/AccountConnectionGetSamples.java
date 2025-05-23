// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

/**
 * Samples for AccountConnection Get.
 */
public final class AccountConnectionGetSamples {
    /*
     * x-ms-original-file:
     * specification/cognitiveservices/resource-manager/Microsoft.CognitiveServices/preview/2025-04-01-preview/examples/
     * AccountConnection/get.json
     */
    /**
     * Sample code: GetAccountConnection.
     * 
     * @param manager Entry point to CognitiveServicesManager.
     */
    public static void
        getAccountConnection(com.azure.resourcemanager.cognitiveservices.CognitiveServicesManager manager) {
        manager.accountConnections()
            .getWithResponse("resourceGroup-1", "account-1", "connection-1", com.azure.core.util.Context.NONE);
    }
}
