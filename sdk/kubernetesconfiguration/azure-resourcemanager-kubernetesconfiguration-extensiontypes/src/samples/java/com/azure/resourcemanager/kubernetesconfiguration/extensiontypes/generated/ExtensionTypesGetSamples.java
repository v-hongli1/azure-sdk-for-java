// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kubernetesconfiguration.extensiontypes.generated;

/**
 * Samples for ExtensionTypes Get.
 */
public final class ExtensionTypesGetSamples {
    /*
     * x-ms-original-file:
     * specification/kubernetesconfiguration/resource-manager/Microsoft.KubernetesConfiguration/extensionTypes/preview/
     * 2024-11-01-preview/examples/GetExtensionType.json
     */
    /**
     * Sample code: Get Extension Types.
     * 
     * @param manager Entry point to ExtensionTypesManager.
     */
    public static void getExtensionTypes(
        com.azure.resourcemanager.kubernetesconfiguration.extensiontypes.ExtensionTypesManager manager) {
        manager.extensionTypes()
            .getWithResponse("rg1", "Microsoft.Kubernetes", "connectedClusters", "my-cluster", "my-extension-type",
                com.azure.core.util.Context.NONE);
    }
}
