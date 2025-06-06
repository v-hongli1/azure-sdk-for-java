// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.resourcemanager.network.models.SecurityGroupViewParameters;

/**
 * Samples for NetworkWatchers GetVMSecurityRules.
 */
public final class NetworkWatchersGetVMSecurityRulesSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/
     * NetworkWatcherSecurityGroupViewGet.json
     */
    /**
     * Sample code: Get security group view.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getSecurityGroupView(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getNetworkWatchers()
            .getVMSecurityRules("rg1", "nw1",
                new SecurityGroupViewParameters().withTargetResourceId(
                    "/subscriptions/subid/resourceGroups/rg2/providers/Microsoft.Compute/virtualMachines/vm1"),
                com.azure.core.util.Context.NONE);
    }
}
