// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

/**
 * Samples for VirtualHubBgpConnections Get.
 */
public final class VirtualHubBgpConnectionsGetSamples {
    /*
     * x-ms-original-file:
     * specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/VirtualHubBgpConnectionGet.
     * json
     */
    /**
     * Sample code: VirtualHubVirtualHubRouteTableV2Get.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void virtualHubVirtualHubRouteTableV2Get(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getVirtualHubBgpConnections()
            .getWithResponse("rg1", "hub1", "conn1", com.azure.core.util.Context.NONE);
    }
}
