// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.networkcloud.generated;

import com.azure.resourcemanager.networkcloud.models.SkipShutdown;
import com.azure.resourcemanager.networkcloud.models.VirtualMachinePowerOffParameters;

/**
 * Samples for VirtualMachines PowerOff.
 */
public final class VirtualMachinesPowerOffSamples {
    /*
     * x-ms-original-file:
     * specification/networkcloud/resource-manager/Microsoft.NetworkCloud/stable/2025-02-01/examples/
     * VirtualMachines_PowerOff.json
     */
    /**
     * Sample code: Power off virtual machine.
     * 
     * @param manager Entry point to NetworkCloudManager.
     */
    public static void powerOffVirtualMachine(com.azure.resourcemanager.networkcloud.NetworkCloudManager manager) {
        manager.virtualMachines()
            .powerOff("resourceGroupName", "virtualMachineName",
                new VirtualMachinePowerOffParameters().withSkipShutdown(SkipShutdown.TRUE),
                com.azure.core.util.Context.NONE);
    }
}
