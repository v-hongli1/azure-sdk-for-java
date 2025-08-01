// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.generated;

import java.util.Arrays;

/**
 * Samples for ManagedPrivateEndpoints Create.
 */
public final class ManagedPrivateEndpointsCreateSamples {
    /*
     * x-ms-original-file: 2024-11-01-preview/ManagedPrivateEndpoints_Create.json
     */
    /**
     * Sample code: ManagedPrivateEndpoint_Create.
     * 
     * @param manager Entry point to DashboardManager.
     */
    public static void managedPrivateEndpointCreate(com.azure.resourcemanager.dashboard.DashboardManager manager) {
        manager.managedPrivateEndpoints()
            .define("myMPEName")
            .withRegion("West US")
            .withExistingGrafana("myResourceGroup", "myWorkspace")
            .withPrivateLinkResourceId(
                "/subscriptions/xxxxxxxx-xxxx-xxxx-xxxx-000000000000/resourceGroups/xx-rg/providers/Microsoft.Kusto/Clusters/sampleKustoResource")
            .withPrivateLinkResourceRegion("West US")
            .withGroupIds(Arrays.asList("grafana"))
            .withRequestMessage("Example Request Message")
            .withPrivateLinkServiceUrl("my-self-hosted-influxdb.westus.mydomain.com")
            .create();
    }
}
