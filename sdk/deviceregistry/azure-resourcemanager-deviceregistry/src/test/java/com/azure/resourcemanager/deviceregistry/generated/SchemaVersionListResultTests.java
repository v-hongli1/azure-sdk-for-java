// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.deviceregistry.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.deviceregistry.implementation.models.SchemaVersionListResult;
import org.junit.jupiter.api.Assertions;

public final class SchemaVersionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SchemaVersionListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"uuid\":\"otftpvjzbexilz\",\"description\":\"fqqnvwpmqtaruo\",\"schemaContent\":\"jmkcjhwqytj\",\"hash\":\"bnw\",\"provisioningState\":\"Deleting\"},\"id\":\"drjervnaenqpehin\",\"name\":\"oygmift\",\"type\":\"nzdndslgna\"}],\"nextLink\":\"igynduhavhqlk\"}")
            .toObject(SchemaVersionListResult.class);
        Assertions.assertEquals("fqqnvwpmqtaruo", model.value().get(0).properties().description());
        Assertions.assertEquals("jmkcjhwqytj", model.value().get(0).properties().schemaContent());
        Assertions.assertEquals("igynduhavhqlk", model.nextLink());
    }
}
