// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.fluent.models.RaiBlocklistInner;
import com.azure.resourcemanager.cognitiveservices.models.RaiBlocklistProperties;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class RaiBlocklistInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RaiBlocklistInner model = BinaryData.fromString(
            "{\"etag\":\"kxtrq\",\"tags\":{\"coezbrhubskh\":\"mlmbtxhwgfwsrta\",\"ookk\":\"dyg\",\"fmluiqtqzfavyvn\":\"fqjbvleo\",\"jkqa\":\"qybaryeua\"},\"properties\":{\"description\":\"zslesjcbher\"},\"id\":\"ntiew\",\"name\":\"jcvb\",\"type\":\"uwrbehwagoh\"}")
            .toObject(RaiBlocklistInner.class);
        Assertions.assertEquals("mlmbtxhwgfwsrta", model.tags().get("coezbrhubskh"));
        Assertions.assertEquals("zslesjcbher", model.properties().description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RaiBlocklistInner model = new RaiBlocklistInner()
            .withTags(mapOf("coezbrhubskh", "mlmbtxhwgfwsrta", "ookk", "dyg", "fmluiqtqzfavyvn", "fqjbvleo", "jkqa",
                "qybaryeua"))
            .withProperties(new RaiBlocklistProperties().withDescription("zslesjcbher"));
        model = BinaryData.fromObject(model).toObject(RaiBlocklistInner.class);
        Assertions.assertEquals("mlmbtxhwgfwsrta", model.tags().get("coezbrhubskh"));
        Assertions.assertEquals("zslesjcbher", model.properties().description());
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
