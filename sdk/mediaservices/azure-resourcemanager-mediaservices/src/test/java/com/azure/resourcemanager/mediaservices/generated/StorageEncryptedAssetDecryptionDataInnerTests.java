// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mediaservices.fluent.models.StorageEncryptedAssetDecryptionDataInner;
import com.azure.resourcemanager.mediaservices.models.AssetFileEncryptionMetadata;
import java.util.Arrays;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;

public final class StorageEncryptedAssetDecryptionDataInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StorageEncryptedAssetDecryptionDataInner model = BinaryData.fromString(
            "{\"assetFileEncryptionMetadata\":[{\"initializationVector\":\"tfolhbnx\",\"assetFileName\":\"alaulppggdtpnapn\",\"assetFileId\":\"f554c135-41af-4974-90ac-bb795150157a\"}]}")
            .toObject(StorageEncryptedAssetDecryptionDataInner.class);
        Assertions.assertEquals("tfolhbnx", model.assetFileEncryptionMetadata().get(0).initializationVector());
        Assertions.assertEquals("alaulppggdtpnapn", model.assetFileEncryptionMetadata().get(0).assetFileName());
        Assertions.assertEquals(UUID.fromString("f554c135-41af-4974-90ac-bb795150157a"),
            model.assetFileEncryptionMetadata().get(0).assetFileId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        StorageEncryptedAssetDecryptionDataInner model
            = new StorageEncryptedAssetDecryptionDataInner().withAssetFileEncryptionMetadata(
                Arrays.asList(new AssetFileEncryptionMetadata().withInitializationVector("tfolhbnx")
                    .withAssetFileName("alaulppggdtpnapn")
                    .withAssetFileId(UUID.fromString("f554c135-41af-4974-90ac-bb795150157a"))));
        model = BinaryData.fromObject(model).toObject(StorageEncryptedAssetDecryptionDataInner.class);
        Assertions.assertEquals("tfolhbnx", model.assetFileEncryptionMetadata().get(0).initializationVector());
        Assertions.assertEquals("alaulppggdtpnapn", model.assetFileEncryptionMetadata().get(0).assetFileName());
        Assertions.assertEquals(UUID.fromString("f554c135-41af-4974-90ac-bb795150157a"),
            model.assetFileEncryptionMetadata().get(0).assetFileId());
    }
}
