// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.generated;

/**
 * Samples for EligibleChildResources Get.
 */
public final class EligibleChildResourcesGetSamples {
    /*
     * x-ms-original-file:
     * specification/authorization/resource-manager/Microsoft.Authorization/stable/2020-10-01/examples/
     * GetEligibleChildResourcesByScope.json
     */
    /**
     * Sample code: GetEligibleChildResourcesByScope.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getEligibleChildResourcesByScope(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.accessManagement()
            .roleAssignments()
            .manager()
            .roleServiceClient()
            .getEligibleChildResources()
            .get("providers/Microsoft.Subscription/subscriptions/dfa2a084-766f-4003-8ae1-c4aeb893a99f",
                "resourceType eq 'resourcegroup'", com.azure.core.util.Context.NONE);
    }
}
