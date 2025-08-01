// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

/**
 * Samples for Remediations ListForResource.
 */
public final class RemediationsListForResourceSamples {
    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * Remediations_ListResourceScope.json
     */
    /**
     * Sample code: List remediations at individual resource scope.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void listRemediationsAtIndividualResourceScope(
        com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.remediations()
            .listForResource(
                "subscriptions/35ee058e-5fa0-414c-8145-3ebb8d09b6e2/resourcegroups/myResourceGroup/providers/microsoft.storage/storageaccounts/storAc1",
                null, null, com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file:
     * specification/policyinsights/resource-manager/Microsoft.PolicyInsights/stable/2024-10-01/examples/
     * Remediations_ListResourceScope_WithQuery.json
     */
    /**
     * Sample code: List remediations at individual resource scope with query parameters.
     * 
     * @param manager Entry point to PolicyInsightsManager.
     */
    public static void listRemediationsAtIndividualResourceScopeWithQueryParameters(
        com.azure.resourcemanager.policyinsights.PolicyInsightsManager manager) {
        manager.remediations()
            .listForResource(
                "subscriptions/35ee058e-5fa0-414c-8145-3ebb8d09b6e2/resourcegroups/myResourceGroup/providers/microsoft.storage/storageaccounts/storAc1",
                1,
                "PolicyAssignmentId eq '/subscriptions/35ee058e-5fa0-414c-8145-3ebb8d09b6e2/providers/microsoft.authorization/policyassignments/b101830944f246d8a14088c5'",
                com.azure.core.util.Context.NONE);
    }
}
