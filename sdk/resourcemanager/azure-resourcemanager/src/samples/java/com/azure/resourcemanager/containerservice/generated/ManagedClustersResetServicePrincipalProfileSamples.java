// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.generated;

import com.azure.resourcemanager.containerservice.models.ManagedClusterServicePrincipalProfile;

/**
 * Samples for ManagedClusters ResetServicePrincipalProfile.
 */
public final class ManagedClustersResetServicePrincipalProfileSamples {
    /*
     * x-ms-original-file:
     * specification/containerservice/resource-manager/Microsoft.ContainerService/aks/stable/2025-05-01/examples/
     * ManagedClustersResetServicePrincipalProfile.json
     */
    /**
     * Sample code: Reset Service Principal Profile.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void resetServicePrincipalProfile(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.kubernetesClusters()
            .manager()
            .serviceClient()
            .getManagedClusters()
            .resetServicePrincipalProfile("rg1", "clustername1",
                new ManagedClusterServicePrincipalProfile().withClientId("clientid").withSecret("fakeTokenPlaceholder"),
                com.azure.core.util.Context.NONE);
    }
}
