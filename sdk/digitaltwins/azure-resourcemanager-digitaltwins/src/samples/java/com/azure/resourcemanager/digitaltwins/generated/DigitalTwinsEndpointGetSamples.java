// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.digitaltwins.generated;

/**
 * Samples for DigitalTwinsEndpoint Get.
 */
public final class DigitalTwinsEndpointGetSamples {
    /*
     * x-ms-original-file:
     * specification/digitaltwins/resource-manager/Microsoft.DigitalTwins/stable/2023-01-31/examples/
     * DigitalTwinsEndpointGet_example.json
     */
    /**
     * Sample code: Get a DigitalTwinsInstance endpoint.
     * 
     * @param manager Entry point to AzureDigitalTwinsManager.
     */
    public static void
        getADigitalTwinsInstanceEndpoint(com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager manager) {
        manager.digitalTwinsEndpoints()
            .getWithResponse("resRg", "myDigitalTwinsService", "myServiceBus", com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/digitaltwins/resource-manager/Microsoft.DigitalTwins/stable/2023-01-31/examples/
     * DigitalTwinsEndpointGet_WithIdentity_example.json
     */
    /**
     * Sample code: Get a DigitalTwinsInstance endpoint with identity.
     * 
     * @param manager Entry point to AzureDigitalTwinsManager.
     */
    public static void getADigitalTwinsInstanceEndpointWithIdentity(
        com.azure.resourcemanager.digitaltwins.AzureDigitalTwinsManager manager) {
        manager.digitalTwinsEndpoints()
            .getWithResponse("resRg", "myDigitalTwinsService", "myServiceBus", com.azure.core.util.Context.NONE);
    }
}
