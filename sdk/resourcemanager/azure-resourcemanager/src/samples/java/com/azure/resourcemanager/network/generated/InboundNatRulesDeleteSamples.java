// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

/**
 * Samples for InboundNatRules Delete.
 */
public final class InboundNatRulesDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/InboundNatRuleDelete.json
     */
    /**
     * Sample code: InboundNatRuleDelete.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void inboundNatRuleDelete(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getInboundNatRules()
            .delete("testrg", "lb1", "natRule1.1", com.azure.core.util.Context.NONE);
    }
}
