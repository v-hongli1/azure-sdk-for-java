// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

/**
 * Samples for GatewayHostnameConfiguration Get.
 */
public final class GatewayHostnameConfigurationGetSamples {
    /*
     * x-ms-original-file:
     * specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2024-05-01/examples/
     * ApiManagementGetGatewayHostnameConfiguration.json
     */
    /**
     * Sample code: ApiManagementGetGatewayHostnameConfiguration.
     * 
     * @param manager Entry point to ApiManagementManager.
     */
    public static void apiManagementGetGatewayHostnameConfiguration(
        com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.gatewayHostnameConfigurations()
            .getWithResponse("rg1", "apimService1", "gw1", "default", com.azure.core.util.Context.NONE);
    }
}
