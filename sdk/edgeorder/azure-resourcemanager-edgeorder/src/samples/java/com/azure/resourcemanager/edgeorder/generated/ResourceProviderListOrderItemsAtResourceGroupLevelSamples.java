// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.edgeorder.generated;

/**
 * Samples for ResourceProvider ListOrderItemsAtResourceGroupLevel.
 */
public final class ResourceProviderListOrderItemsAtResourceGroupLevelSamples {
    /*
     * x-ms-original-file: specification/edgeorder/resource-manager/Microsoft.EdgeOrder/stable/2021-12-01/examples/
     * ListOrderItemsAtResourceGroupLevel.json
     */
    /**
     * Sample code: ListOrderItemsAtResourceGroupLevel.
     * 
     * @param manager Entry point to EdgeOrderManager.
     */
    public static void
        listOrderItemsAtResourceGroupLevel(com.azure.resourcemanager.edgeorder.EdgeOrderManager manager) {
        manager.resourceProviders()
            .listOrderItemsAtResourceGroupLevel("YourResourceGroupName", null, null, null,
                com.azure.core.util.Context.NONE);
    }
}
