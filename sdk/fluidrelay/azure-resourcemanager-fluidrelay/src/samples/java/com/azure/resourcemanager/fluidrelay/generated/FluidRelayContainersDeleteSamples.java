// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.fluidrelay.generated;

/**
 * Samples for FluidRelayContainers Delete.
 */
public final class FluidRelayContainersDeleteSamples {
    /*
     * x-ms-original-file: specification/fluidrelay/resource-manager/Microsoft.FluidRelay/stable/2022-06-01/examples/
     * FluidRelayContainers_Delete.json
     */
    /**
     * Sample code: Delete a Fluid Relay container.
     * 
     * @param manager Entry point to FluidRelayManager.
     */
    public static void deleteAFluidRelayContainer(com.azure.resourcemanager.fluidrelay.FluidRelayManager manager) {
        manager.fluidRelayContainers()
            .deleteWithResponse("myResourceGroup", "myFluidRelayServer", "myFluidRelayContainer",
                com.azure.core.util.Context.NONE);
    }
}
