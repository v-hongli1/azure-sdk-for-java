// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.LocalizedOperationDisplayDefinitionEs;
import org.junit.jupiter.api.Assertions;

public final class LocalizedOperationDisplayDefinitionEsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LocalizedOperationDisplayDefinitionEs model = BinaryData.fromString(
            "{\"provider\":\"hcecybmrqbr\",\"resource\":\"bbmpxdlvykfre\",\"operation\":\"crse\",\"description\":\"wjksghudgzhxo\"}")
            .toObject(LocalizedOperationDisplayDefinitionEs.class);
        Assertions.assertEquals("hcecybmrqbr", model.provider());
        Assertions.assertEquals("bbmpxdlvykfre", model.resource());
        Assertions.assertEquals("crse", model.operation());
        Assertions.assertEquals("wjksghudgzhxo", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LocalizedOperationDisplayDefinitionEs model
            = new LocalizedOperationDisplayDefinitionEs().withProvider("hcecybmrqbr")
                .withResource("bbmpxdlvykfre")
                .withOperation("crse")
                .withDescription("wjksghudgzhxo");
        model = BinaryData.fromObject(model).toObject(LocalizedOperationDisplayDefinitionEs.class);
        Assertions.assertEquals("hcecybmrqbr", model.provider());
        Assertions.assertEquals("bbmpxdlvykfre", model.resource());
        Assertions.assertEquals("crse", model.operation());
        Assertions.assertEquals("wjksghudgzhxo", model.description());
    }
}
