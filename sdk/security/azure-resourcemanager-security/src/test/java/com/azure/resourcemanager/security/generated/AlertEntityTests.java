// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.AlertEntity;
import java.util.HashMap;
import java.util.Map;

public final class AlertEntityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AlertEntity model = BinaryData
            .fromString("{\"type\":\"syrq\",\"\":{\"nxaulk\":\"dataqhd\",\"xuckpggqoweyir\":\"dataakdkifmjnnawtqab\"}}")
            .toObject(AlertEntity.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AlertEntity model = new AlertEntity().withAdditionalProperties(mapOf("type", "syrq"));
        model = BinaryData.fromObject(model).toObject(AlertEntity.class);
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
