// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.generated;

/**
 * Samples for VirtualMachines Delete.
 */
public final class VirtualMachinesDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/devtestlabs/resource-manager/Microsoft.DevTestLab/stable/2018-09-15/examples/VirtualMachines_Delete
     * .json
     */
    /**
     * Sample code: VirtualMachines_Delete.
     * 
     * @param manager Entry point to DevTestLabsManager.
     */
    public static void virtualMachinesDelete(com.azure.resourcemanager.devtestlabs.DevTestLabsManager manager) {
        manager.virtualMachines()
            .delete("resourceGroupName", "{labName}", "{vmName}", com.azure.core.util.Context.NONE);
    }
}
