// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

/**
 * Samples for ReachabilityAnalysisIntents List.
 */
public final class ReachabilityAnalysisIntentsListSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/
     * ReachabilityAnalysisIntentList.json
     */
    /**
     * Sample code: ReachabilityAnalysisIntentList.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void reachabilityAnalysisIntentList(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getReachabilityAnalysisIntents()
            .list("rg1", "testNetworkManager", "testVerifierWorkspace1", null, null, null, null, null,
                com.azure.core.util.Context.NONE);
    }
}
