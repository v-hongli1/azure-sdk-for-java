// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.fluent.models.CacheContractProperties;
import org.junit.jupiter.api.Assertions;

public final class CacheContractPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        CacheContractProperties model = BinaryData.fromString(
            "{\"description\":\"enmvcebxeetq\",\"connectionString\":\"jxcxxq\",\"useFromLocation\":\"dcqjkedwqurc\",\"resourceId\":\"jmrvvxwjongz\"}")
            .toObject(CacheContractProperties.class);
        Assertions.assertEquals("enmvcebxeetq", model.description());
        Assertions.assertEquals("jxcxxq", model.connectionString());
        Assertions.assertEquals("dcqjkedwqurc", model.useFromLocation());
        Assertions.assertEquals("jmrvvxwjongz", model.resourceId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        CacheContractProperties model = new CacheContractProperties().withDescription("enmvcebxeetq")
            .withConnectionString("jxcxxq")
            .withUseFromLocation("dcqjkedwqurc")
            .withResourceId("jmrvvxwjongz");
        model = BinaryData.fromObject(model).toObject(CacheContractProperties.class);
        Assertions.assertEquals("enmvcebxeetq", model.description());
        Assertions.assertEquals("jxcxxq", model.connectionString());
        Assertions.assertEquals("dcqjkedwqurc", model.useFromLocation());
        Assertions.assertEquals("jmrvvxwjongz", model.resourceId());
    }
}
