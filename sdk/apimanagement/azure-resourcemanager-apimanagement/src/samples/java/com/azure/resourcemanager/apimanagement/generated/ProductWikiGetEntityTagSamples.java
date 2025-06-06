// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

/**
 * Samples for ProductWiki GetEntityTag.
 */
public final class ProductWikiGetEntityTagSamples {
    /*
     * x-ms-original-file:
     * specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2024-05-01/examples/
     * ApiManagementHeadProductWiki.json
     */
    /**
     * Sample code: ApiManagementHeadProductWiki.
     * 
     * @param manager Entry point to ApiManagementManager.
     */
    public static void
        apiManagementHeadProductWiki(com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.productWikis()
            .getEntityTagWithResponse("rg1", "apimService1", "57d1f7558aa04f15146d9d8a",
                com.azure.core.util.Context.NONE);
    }
}
