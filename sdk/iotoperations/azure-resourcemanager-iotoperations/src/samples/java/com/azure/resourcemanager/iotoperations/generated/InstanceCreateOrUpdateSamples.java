// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.generated;

import com.azure.resourcemanager.iotoperations.models.ExtendedLocation;
import com.azure.resourcemanager.iotoperations.models.ExtendedLocationType;
import com.azure.resourcemanager.iotoperations.models.InstanceProperties;
import com.azure.resourcemanager.iotoperations.models.ManagedServiceIdentity;
import com.azure.resourcemanager.iotoperations.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.iotoperations.models.SchemaRegistryRef;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for Instance CreateOrUpdate.
 */
public final class InstanceCreateOrUpdateSamples {
    /*
     * x-ms-original-file: 2025-04-01/Instance_CreateOrUpdate_MaximumSet_Gen.json
     */
    /**
     * Sample code: Instance_CreateOrUpdate.
     * 
     * @param manager Entry point to IoTOperationsManager.
     */
    public static void instanceCreateOrUpdate(com.azure.resourcemanager.iotoperations.IoTOperationsManager manager) {
        manager.instances()
            .define("aio-instance")
            .withRegion("xvewadyhycrjpu")
            .withExistingResourceGroup("rgiotoperations")
            .withExtendedLocation(
                new ExtendedLocation().withName("qmbrfwcpwwhggszhrdjv").withType(ExtendedLocationType.CUSTOM_LOCATION))
            .withTags(mapOf())
            .withProperties(new InstanceProperties().withDescription("kpqtgocs")
                .withSchemaRegistryRef(new SchemaRegistryRef().withResourceId(
                    "/subscriptions/0000000-0000-0000-0000-000000000000/resourceGroups/resourceGroup123/providers/Microsoft.DeviceRegistry/schemaRegistries/resource-name123")))
            .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.NONE)
                .withUserAssignedIdentities(mapOf()))
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
