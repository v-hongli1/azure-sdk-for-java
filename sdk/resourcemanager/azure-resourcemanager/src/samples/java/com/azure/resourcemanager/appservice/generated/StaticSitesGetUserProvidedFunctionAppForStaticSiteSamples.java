// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

/**
 * Samples for StaticSites GetUserProvidedFunctionAppForStaticSite.
 */
public final class StaticSitesGetUserProvidedFunctionAppForStaticSiteSamples {
    /*
     * x-ms-original-file: specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/
     * GetUserProvidedFunctionAppForStaticSite.json
     */
    /**
     * Sample code: Get details of the user provided function app registered with a static site.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getDetailsOfTheUserProvidedFunctionAppRegisteredWithAStaticSite(
        com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getStaticSites()
            .getUserProvidedFunctionAppForStaticSiteWithResponse("rg", "testStaticSite0", "testFunctionApp",
                com.azure.core.util.Context.NONE);
    }
}
