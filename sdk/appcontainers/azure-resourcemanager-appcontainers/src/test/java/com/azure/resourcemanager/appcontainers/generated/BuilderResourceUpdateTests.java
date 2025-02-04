// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.appcontainers.models.BuilderResourceUpdate;
import com.azure.resourcemanager.appcontainers.models.ManagedServiceIdentity;
import com.azure.resourcemanager.appcontainers.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.appcontainers.models.UserAssignedIdentity;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class BuilderResourceUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BuilderResourceUpdate model = BinaryData.fromString(
            "{\"identity\":{\"principalId\":\"b4104829-5349-4778-88a0-75a1d17d0f27\",\"tenantId\":\"c7c8ed8f-6676-43e1-946b-eba852da6263\",\"type\":\"SystemAssigned\",\"userAssignedIdentities\":{\"hoxus\":{\"principalId\":\"5c89f141-3aad-45b9-b682-eda412c10ec9\",\"clientId\":\"9b79cffa-f8c2-41d0-af24-09054047b57c\"},\"abgy\":{\"principalId\":\"eca30c6f-90e0-4c72-ab6b-abf0d0b9e132\",\"clientId\":\"91424844-23c7-479e-a878-f29a05571ed5\"}}},\"tags\":{\"ef\":\"bjtazqugxywpmu\"},\"properties\":{\"environmentId\":\"fqkquj\"}}")
            .toObject(BuilderResourceUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED, model.identity().type());
        Assertions.assertEquals("bjtazqugxywpmu", model.tags().get("ef"));
        Assertions.assertEquals("fqkquj", model.environmentId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BuilderResourceUpdate model = new BuilderResourceUpdate()
            .withIdentity(new ManagedServiceIdentity().withType(ManagedServiceIdentityType.SYSTEM_ASSIGNED)
                .withUserAssignedIdentities(
                    mapOf("hoxus", new UserAssignedIdentity(), "abgy", new UserAssignedIdentity())))
            .withTags(mapOf("ef", "bjtazqugxywpmu"))
            .withEnvironmentId("fqkquj");
        model = BinaryData.fromObject(model).toObject(BuilderResourceUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.SYSTEM_ASSIGNED, model.identity().type());
        Assertions.assertEquals("bjtazqugxywpmu", model.tags().get("ef"));
        Assertions.assertEquals("fqkquj", model.environmentId());
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
