// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computefleet.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.computefleet.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.computefleet.models.ManagedServiceIdentityUpdate;
import com.azure.resourcemanager.computefleet.models.UserAssignedIdentity;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class ManagedServiceIdentityUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ManagedServiceIdentityUpdate model = BinaryData.fromString(
            "{\"type\":\"None\",\"userAssignedIdentities\":{\"ntnev\":{\"principalId\":\"dzu\",\"clientId\":\"rsc\"},\"weriofzpyqsem\":{\"principalId\":\"wjmy\",\"clientId\":\"dsslswt\"},\"d\":{\"principalId\":\"bnetshh\",\"clientId\":\"h\"},\"lcxog\":{\"principalId\":\"vwiwubmwmbesld\",\"clientId\":\"wwtppj\"}}}")
            .toObject(ManagedServiceIdentityUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ManagedServiceIdentityUpdate model
            = new ManagedServiceIdentityUpdate().withType(ManagedServiceIdentityType.NONE)
                .withUserAssignedIdentities(mapOf("ntnev", new UserAssignedIdentity(), "weriofzpyqsem",
                    new UserAssignedIdentity(), "d", new UserAssignedIdentity(), "lcxog", new UserAssignedIdentity()));
        model = BinaryData.fromObject(model).toObject(ManagedServiceIdentityUpdate.class);
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, model.type());
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
