// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcompute.fluent.models.SettingsGatewayProperties;
import org.junit.jupiter.api.Assertions;

public final class SettingsGatewayPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SettingsGatewayProperties model = BinaryData.fromString("{\"gatewayResourceId\":\"yowqkdwytisibir\"}")
            .toObject(SettingsGatewayProperties.class);
        Assertions.assertEquals("yowqkdwytisibir", model.gatewayResourceId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SettingsGatewayProperties model = new SettingsGatewayProperties().withGatewayResourceId("yowqkdwytisibir");
        model = BinaryData.fromObject(model).toObject(SettingsGatewayProperties.class);
        Assertions.assertEquals("yowqkdwytisibir", model.gatewayResourceId());
    }
}
