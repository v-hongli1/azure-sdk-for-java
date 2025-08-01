// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.ProtectedItemModelCustomPropertiesUpdate;
import com.azure.resourcemanager.recoveryservicesdatareplication.models.ProtectedItemModelPropertiesUpdate;

public final class ProtectedItemModelPropertiesUpdateTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ProtectedItemModelPropertiesUpdate model = BinaryData
            .fromString("{\"customProperties\":{\"instanceType\":\"ProtectedItemModelCustomPropertiesUpdate\"}}")
            .toObject(ProtectedItemModelPropertiesUpdate.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ProtectedItemModelPropertiesUpdate model = new ProtectedItemModelPropertiesUpdate()
            .withCustomProperties(new ProtectedItemModelCustomPropertiesUpdate());
        model = BinaryData.fromObject(model).toObject(ProtectedItemModelPropertiesUpdate.class);
    }
}
