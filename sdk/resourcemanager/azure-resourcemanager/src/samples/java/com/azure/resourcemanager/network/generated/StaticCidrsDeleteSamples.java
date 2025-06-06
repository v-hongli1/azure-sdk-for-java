// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

/**
 * Samples for StaticCidrs Delete.
 */
public final class StaticCidrsDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/StaticCidrs_Delete.json
     */
    /**
     * Sample code: StaticCidrs_Delete.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void staticCidrsDelete(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getStaticCidrs()
            .delete("rg1", "TestNetworkManager", "TestPool", "TestStaticCidr", com.azure.core.util.Context.NONE);
    }
}
