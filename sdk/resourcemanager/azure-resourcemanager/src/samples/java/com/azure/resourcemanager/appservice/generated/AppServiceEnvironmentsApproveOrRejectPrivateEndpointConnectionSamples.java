// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.generated;

import com.azure.resourcemanager.appservice.fluent.models.RemotePrivateEndpointConnectionArmResourceInner;
import com.azure.resourcemanager.appservice.models.PrivateLinkConnectionState;

/**
 * Samples for AppServiceEnvironments ApproveOrRejectPrivateEndpointConnection.
 */
public final class AppServiceEnvironmentsApproveOrRejectPrivateEndpointConnectionSamples {
    /*
     * x-ms-original-file: specification/web/resource-manager/Microsoft.Web/stable/2024-11-01/examples/
     * AppServiceEnvironments_ApproveOrRejectPrivateEndpointConnection.json
     */
    /**
     * Sample code: Approves or rejects a private endpoint connection.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void
        approvesOrRejectsAPrivateEndpointConnection(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.webApps()
            .manager()
            .serviceClient()
            .getAppServiceEnvironments()
            .approveOrRejectPrivateEndpointConnection("test-rg", "test-ase", "fa38656c-034e-43d8-adce-fe06ce039c98",
                new RemotePrivateEndpointConnectionArmResourceInner()
                    .withPrivateLinkServiceConnectionState(new PrivateLinkConnectionState().withStatus("Approved")
                        .withDescription("Approved by johndoe@company.com")),
                com.azure.core.util.Context.NONE);
    }
}
