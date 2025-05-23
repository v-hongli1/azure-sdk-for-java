// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.generated;

import com.azure.resourcemanager.connectedvmware.fluent.models.GuestAgentInner;
import com.azure.resourcemanager.connectedvmware.models.GuestCredential;
import com.azure.resourcemanager.connectedvmware.models.HttpProxyConfiguration;
import com.azure.resourcemanager.connectedvmware.models.ProvisioningAction;

/**
 * Samples for VMInstanceGuestAgents Create.
 */
public final class VMInstanceGuestAgentsCreateSamples {
    /*
     * x-ms-original-file:
     * specification/connectedvmware/resource-manager/Microsoft.ConnectedVMwarevSphere/stable/2023-10-01/examples/
     * CreateVMInstanceGuestAgent.json
     */
    /**
     * Sample code: CreateGuestAgent.
     * 
     * @param manager Entry point to ConnectedVMwareManager.
     */
    public static void createGuestAgent(com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager manager) {
        manager.vMInstanceGuestAgents()
            .create(
                "subscriptions/fd3c3665-1729-4b7b-9a38-238e83b0f98b/resourceGroups/testrg/providers/Microsoft.HybridCompute/machines/DemoVM",
                new GuestAgentInner()
                    .withCredentials(
                        new GuestCredential().withUsername("tempuser").withPassword("fakeTokenPlaceholder"))
                    .withPrivateLinkScopeResourceId(
                        "/subscriptions/{subscriptionId}/resourceGroups/myResourceGroup/providers/Microsoft.HybridCompute/privateLinkScopes/privateLinkScopeName")
                    .withHttpProxyConfig(new HttpProxyConfiguration().withHttpsProxy("http://192.1.2.3:8080"))
                    .withProvisioningAction(ProvisioningAction.INSTALL),
                com.azure.core.util.Context.NONE);
    }
}
