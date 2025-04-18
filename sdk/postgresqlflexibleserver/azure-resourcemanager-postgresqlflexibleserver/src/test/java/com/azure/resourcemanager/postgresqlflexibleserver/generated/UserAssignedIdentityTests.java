// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresqlflexibleserver.models.IdentityType;
import com.azure.resourcemanager.postgresqlflexibleserver.models.UserAssignedIdentity;
import com.azure.resourcemanager.postgresqlflexibleserver.models.UserIdentity;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class UserAssignedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        UserAssignedIdentity model = BinaryData.fromString(
            "{\"userAssignedIdentities\":{\"hahvljuahaq\":{\"principalId\":\"kv\",\"clientId\":\"elmqk\"}},\"type\":\"SystemAssigned\",\"tenantId\":\"dhmdua\"}")
            .toObject(UserAssignedIdentity.class);
        Assertions.assertEquals("kv", model.userAssignedIdentities().get("hahvljuahaq").principalId());
        Assertions.assertEquals("elmqk", model.userAssignedIdentities().get("hahvljuahaq").clientId());
        Assertions.assertEquals(IdentityType.SYSTEM_ASSIGNED, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        UserAssignedIdentity model = new UserAssignedIdentity()
            .withUserAssignedIdentities(
                mapOf("hahvljuahaq", new UserIdentity().withPrincipalId("kv").withClientId("elmqk")))
            .withType(IdentityType.SYSTEM_ASSIGNED);
        model = BinaryData.fromObject(model).toObject(UserAssignedIdentity.class);
        Assertions.assertEquals("kv", model.userAssignedIdentities().get("hahvljuahaq").principalId());
        Assertions.assertEquals("elmqk", model.userAssignedIdentities().get("hahvljuahaq").clientId());
        Assertions.assertEquals(IdentityType.SYSTEM_ASSIGNED, model.type());
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
