// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.resourcemanager.avs.models.AvailabilityProperties;
import com.azure.resourcemanager.avs.models.AvailabilityStrategy;
import com.azure.resourcemanager.avs.models.DnsZoneType;
import com.azure.resourcemanager.avs.models.ManagementCluster;
import com.azure.resourcemanager.avs.models.PrivateCloudIdentity;
import com.azure.resourcemanager.avs.models.ResourceIdentityType;
import com.azure.resourcemanager.avs.models.Sku;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for PrivateClouds CreateOrUpdate.
 */
public final class PrivateCloudsCreateOrUpdateSamples {
    /*
     * x-ms-original-file: 2024-09-01/PrivateClouds_CreateOrUpdate.json
     */
    /**
     * Sample code: PrivateClouds_CreateOrUpdate.
     * 
     * @param manager Entry point to AvsManager.
     */
    public static void privateCloudsCreateOrUpdate(com.azure.resourcemanager.avs.AvsManager manager) {
        manager.privateClouds()
            .define("cloud1")
            .withRegion("eastus2")
            .withExistingResourceGroup("group1")
            .withSku(new Sku().withName("AV36"))
            .withTags(mapOf())
            .withIdentity(new PrivateCloudIdentity().withType(ResourceIdentityType.SYSTEM_ASSIGNED))
            .withManagementCluster(new ManagementCluster().withClusterSize(4))
            .withNetworkBlock("192.168.48.0/22")
            .create();
    }

    /*
     * x-ms-original-file: 2024-09-01/PrivateClouds_CreateOrUpdate_StretchedZones.json
     */
    /**
     * Sample code: PrivateClouds_CreateOrUpdate_StretchedZones.
     * 
     * @param manager Entry point to AvsManager.
     */
    public static void privateCloudsCreateOrUpdateStretchedZones(com.azure.resourcemanager.avs.AvsManager manager) {
        manager.privateClouds()
            .define("cloud1")
            .withRegion("eastus2")
            .withExistingResourceGroup("group1")
            .withSku(new Sku().withName("AV36"))
            .withTags(mapOf())
            .withZones(Arrays.asList("1", "2"))
            .withManagementCluster(new ManagementCluster().withClusterSize(4))
            .withNetworkBlock("192.168.48.0/22")
            .create();
    }

    /*
     * x-ms-original-file: 2024-09-01/PrivateClouds_CreateOrUpdate_FleetNative.json
     */
    /**
     * Sample code: PrivateClouds_CreateOrUpdate_FleetNative.
     * 
     * @param manager Entry point to AvsManager.
     */
    public static void privateCloudsCreateOrUpdateFleetNative(com.azure.resourcemanager.avs.AvsManager manager) {
        manager.privateClouds()
            .define("cloud1")
            .withRegion("eastus2")
            .withExistingResourceGroup("group1")
            .withSku(new Sku().withName("AV64"))
            .withTags(mapOf())
            .withManagementCluster(new ManagementCluster().withClusterSize(4))
            .withNetworkBlock("192.168.48.0/22")
            .withVirtualNetworkId(
                "/subscriptions/00000000-0000-0000-0000-000000000000/resourceGroups/group1/providers/Microsoft.Network/virtualNetworks/vnet")
            .withDnsZoneType(DnsZoneType.PRIVATE)
            .create();
    }

    /*
     * x-ms-original-file: 2024-09-01/PrivateClouds_CreateOrUpdate_Stretched.json
     */
    /**
     * Sample code: PrivateClouds_CreateOrUpdate_Stretched.
     * 
     * @param manager Entry point to AvsManager.
     */
    public static void privateCloudsCreateOrUpdateStretched(com.azure.resourcemanager.avs.AvsManager manager) {
        manager.privateClouds()
            .define("cloud1")
            .withRegion("eastus2")
            .withExistingResourceGroup("group1")
            .withSku(new Sku().withName("AV36"))
            .withTags(mapOf())
            .withManagementCluster(new ManagementCluster().withClusterSize(4))
            .withAvailability(new AvailabilityProperties().withStrategy(AvailabilityStrategy.DUAL_ZONE)
                .withZone(1)
                .withSecondaryZone(2))
            .withNetworkBlock("192.168.48.0/22")
            .create();
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
