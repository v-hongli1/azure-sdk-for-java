// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billing.generated;

/** Samples for AvailableBalances Get. */
public final class AvailableBalancesGetSamples {
    /*
     * x-ms-original-file: specification/billing/resource-manager/Microsoft.Billing/stable/2020-05-01/examples/AvailableBalanceByBillingProfile.json
     */
    /**
     * Sample code: AvailableBalanceByBillingProfile.
     *
     * @param manager Entry point to BillingManager.
     */
    public static void availableBalanceByBillingProfile(com.azure.resourcemanager.billing.BillingManager manager) {
        manager
            .availableBalances()
            .getWithResponse("{billingAccountName}", "{billingProfileName}", com.azure.core.util.Context.NONE);
    }
}
