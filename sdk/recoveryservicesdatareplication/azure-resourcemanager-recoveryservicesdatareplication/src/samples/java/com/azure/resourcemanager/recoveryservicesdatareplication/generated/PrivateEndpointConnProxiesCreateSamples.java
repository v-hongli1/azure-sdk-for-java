// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.generated;

/**
 * Samples for PrivateEndpointConnProxies Create.
 */
public final class PrivateEndpointConnProxiesCreateSamples {
    /*
     * x-ms-original-file: 2024-09-01/PrivateEndpointConnectionProxy_Create.json
     */
    /**
     * Sample code: Creates the Private Endpoint Connection Proxy.
     * 
     * @param manager Entry point to RecoveryServicesDataReplicationManager.
     */
    public static void createsThePrivateEndpointConnectionProxy(
        com.azure.resourcemanager.recoveryservicesdatareplication.RecoveryServicesDataReplicationManager manager) {
        manager.privateEndpointConnProxies()
            .define("d")
            .withExistingReplicationVault("rgswagger_2024-09-01", "4")
            .create();
    }
}
