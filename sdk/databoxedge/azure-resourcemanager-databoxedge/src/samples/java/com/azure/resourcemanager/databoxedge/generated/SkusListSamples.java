// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databoxedge.generated;

/**
 * Samples for Skus List.
 */
public final class SkusListSamples {
    /*
     * x-ms-original-file:
     * specification/databoxedge/resource-manager/Microsoft.DataBoxEdge/stable/2019-08-01/examples/ListSkus.json
     */
    /**
     * Sample code: ListSkus.
     * 
     * @param manager Entry point to DataBoxEdgeManager.
     */
    public static void listSkus(com.azure.resourcemanager.databoxedge.DataBoxEdgeManager manager) {
        manager.skus().list(null, com.azure.core.util.Context.NONE);
    }
}
