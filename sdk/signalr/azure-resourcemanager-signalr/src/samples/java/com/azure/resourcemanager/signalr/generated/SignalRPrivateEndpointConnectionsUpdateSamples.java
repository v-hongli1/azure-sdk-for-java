// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.signalr.generated;

import com.azure.resourcemanager.signalr.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.signalr.models.PrivateEndpoint;
import com.azure.resourcemanager.signalr.models.PrivateLinkServiceConnectionState;
import com.azure.resourcemanager.signalr.models.PrivateLinkServiceConnectionStatus;

/**
 * Samples for SignalRPrivateEndpointConnections Update.
 */
public final class SignalRPrivateEndpointConnectionsUpdateSamples {
    /*
     * x-ms-original-file: specification/signalr/resource-manager/Microsoft.SignalRService/stable/2023-02-01/examples/
     * SignalRPrivateEndpointConnections_Update.json
     */
    /**
     * Sample code: SignalRPrivateEndpointConnections_Update.
     * 
     * @param manager Entry point to SignalRManager.
     */
    public static void
        signalRPrivateEndpointConnectionsUpdate(com.azure.resourcemanager.signalr.SignalRManager manager) {
        manager.signalRPrivateEndpointConnections()
            .updateWithResponse("mysignalrservice.1fa229cd-bf3f-47f0-8c49-afb36723997e", "myResourceGroup",
                "mySignalRService",
                new PrivateEndpointConnectionInner().withPrivateEndpoint(new PrivateEndpoint().withId(
                    "/subscriptions/00000000-0000-0000-0000-000000000000/resourcegroups/myResourceGroup/providers/Microsoft.Network/privateEndpoints/myPrivateEndpoint"))
                    .withPrivateLinkServiceConnectionState(
                        new PrivateLinkServiceConnectionState().withStatus(PrivateLinkServiceConnectionStatus.APPROVED)
                            .withActionsRequired("None")),
                com.azure.core.util.Context.NONE);
    }
}
