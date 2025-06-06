// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.StorageClassificationMappingInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.StorageMappingInputProperties;
import org.junit.jupiter.api.Assertions;

public final class StorageClassificationMappingInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StorageClassificationMappingInput model
            = BinaryData.fromString("{\"properties\":{\"targetStorageClassificationId\":\"urvzmlovuanashc\"}}")
                .toObject(StorageClassificationMappingInput.class);
        Assertions.assertEquals("urvzmlovuanashc", model.properties().targetStorageClassificationId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        StorageClassificationMappingInput model = new StorageClassificationMappingInput()
            .withProperties(new StorageMappingInputProperties().withTargetStorageClassificationId("urvzmlovuanashc"));
        model = BinaryData.fromObject(model).toObject(StorageClassificationMappingInput.class);
        Assertions.assertEquals("urvzmlovuanashc", model.properties().targetStorageClassificationId());
    }
}
