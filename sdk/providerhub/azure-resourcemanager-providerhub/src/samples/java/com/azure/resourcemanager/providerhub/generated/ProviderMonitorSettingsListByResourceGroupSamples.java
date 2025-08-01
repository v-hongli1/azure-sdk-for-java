// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

/**
 * Samples for ProviderMonitorSettings ListByResourceGroup.
 */
public final class ProviderMonitorSettingsListByResourceGroupSamples {
    /*
     * x-ms-original-file: specification/providerhub/resource-manager/Microsoft.ProviderHub/stable/2024-09-01/examples/
     * ProviderMonitorSettings_ListByResourceGroup.json
     */
    /**
     * Sample code: ProviderMonitorSettings_ListByResourceGroup.
     * 
     * @param manager Entry point to ProviderHubManager.
     */
    public static void
        providerMonitorSettingsListByResourceGroup(com.azure.resourcemanager.providerhub.ProviderHubManager manager) {
        manager.providerMonitorSettings().listByResourceGroup("default", com.azure.core.util.Context.NONE);
    }
}
