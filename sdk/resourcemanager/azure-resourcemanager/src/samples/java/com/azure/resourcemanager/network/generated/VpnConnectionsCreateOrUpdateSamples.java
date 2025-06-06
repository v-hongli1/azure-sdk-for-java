// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.core.management.SubResource;
import com.azure.resourcemanager.network.fluent.models.VpnConnectionInner;
import com.azure.resourcemanager.network.fluent.models.VpnSiteLinkConnectionInner;
import com.azure.resourcemanager.network.models.PropagatedRouteTable;
import com.azure.resourcemanager.network.models.RoutingConfiguration;
import com.azure.resourcemanager.network.models.VirtualNetworkGatewayConnectionProtocol;
import com.azure.resourcemanager.network.models.VpnLinkConnectionMode;
import java.util.Arrays;

/**
 * Samples for VpnConnections CreateOrUpdate.
 */
public final class VpnConnectionsCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/VpnConnectionPut.json
     */
    /**
     * Sample code: VpnConnectionPut.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void vpnConnectionPut(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getVpnConnections()
            .createOrUpdate("rg1", "gateway1", "vpnConnection1", new VpnConnectionInner()
                .withRemoteVpnSite(new SubResource()
                    .withId("/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/vpnSites/vpnSite1"))
                .withTrafficSelectorPolicies(Arrays.asList())
                .withVpnLinkConnections(Arrays.asList(new VpnSiteLinkConnectionInner().withName("Connection-Link1")
                    .withVpnSiteLink(new SubResource().withId(
                        "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/vpnSites/vpnSite1/vpnSiteLinks/siteLink1"))
                    .withVpnLinkConnectionMode(VpnLinkConnectionMode.DEFAULT)
                    .withVpnConnectionProtocolType(VirtualNetworkGatewayConnectionProtocol.IKEV2)
                    .withConnectionBandwidth(200)
                    .withSharedKey("fakeTokenPlaceholder")
                    .withUsePolicyBasedTrafficSelectors(false)))
                .withRoutingConfiguration(new RoutingConfiguration().withAssociatedRouteTable(new SubResource().withId(
                    "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/hub1/hubRouteTables/hubRouteTable1"))
                    .withPropagatedRouteTables(new PropagatedRouteTable().withLabels(Arrays.asList("label1", "label2"))
                        .withIds(Arrays.asList(new SubResource().withId(
                            "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/hub1/hubRouteTables/hubRouteTable1"),
                            new SubResource().withId(
                                "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/hub1/hubRouteTables/hubRouteTable2"),
                            new SubResource().withId(
                                "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/hub1/hubRouteTables/hubRouteTable3"))))
                    .withInboundRouteMap(new SubResource().withId(
                        "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/virtualHub1/routeMaps/routeMap1"))
                    .withOutboundRouteMap(new SubResource().withId(
                        "/subscriptions/subid/resourceGroups/rg1/providers/Microsoft.Network/virtualHubs/virtualHub1/routeMaps/routeMap2"))),
                com.azure.core.util.Context.NONE);
    }
}
