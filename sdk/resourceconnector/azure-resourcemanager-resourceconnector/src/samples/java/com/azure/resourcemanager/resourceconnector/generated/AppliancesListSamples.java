// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourceconnector.generated;

/**
 * Samples for Appliances List.
 */
public final class AppliancesListSamples {
    /*
     * x-ms-original-file:
     * specification/resourceconnector/resource-manager/Microsoft.ResourceConnector/stable/2022-10-27/examples/
     * AppliancesListBySubscription.json
     */
    /**
     * Sample code: List Appliances by subscription.
     * 
     * @param manager Entry point to ResourceConnectorManager.
     */
    public static void
        listAppliancesBySubscription(com.azure.resourcemanager.resourceconnector.ResourceConnectorManager manager) {
        manager.appliances().list(com.azure.core.util.Context.NONE);
    }
}
