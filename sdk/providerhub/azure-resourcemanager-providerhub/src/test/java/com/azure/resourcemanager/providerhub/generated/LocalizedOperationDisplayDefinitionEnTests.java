// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.LocalizedOperationDisplayDefinitionEn;
import org.junit.jupiter.api.Assertions;

public final class LocalizedOperationDisplayDefinitionEnTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        LocalizedOperationDisplayDefinitionEn model = BinaryData.fromString(
            "{\"provider\":\"pzhz\",\"resource\":\"tk\",\"operation\":\"jcitdigsxcdglj\",\"description\":\"lkeuac\"}")
            .toObject(LocalizedOperationDisplayDefinitionEn.class);
        Assertions.assertEquals("pzhz", model.provider());
        Assertions.assertEquals("tk", model.resource());
        Assertions.assertEquals("jcitdigsxcdglj", model.operation());
        Assertions.assertEquals("lkeuac", model.description());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        LocalizedOperationDisplayDefinitionEn model = new LocalizedOperationDisplayDefinitionEn().withProvider("pzhz")
            .withResource("tk")
            .withOperation("jcitdigsxcdglj")
            .withDescription("lkeuac");
        model = BinaryData.fromObject(model).toObject(LocalizedOperationDisplayDefinitionEn.class);
        Assertions.assertEquals("pzhz", model.provider());
        Assertions.assertEquals("tk", model.resource());
        Assertions.assertEquals("jcitdigsxcdglj", model.operation());
        Assertions.assertEquals("lkeuac", model.description());
    }
}
