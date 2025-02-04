// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerorchestratorruntime.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The properties of storage class of the StorageClass.
 */
@Immutable
public class StorageClassTypeProperties implements JsonSerializable<StorageClassTypeProperties> {
    /*
     * Type of the storage class.
     */
    private SCType type = SCType.fromString("StorageClassTypeProperties");

    /**
     * Creates an instance of StorageClassTypeProperties class.
     */
    public StorageClassTypeProperties() {
    }

    /**
     * Get the type property: Type of the storage class.
     * 
     * @return the type value.
     */
    public SCType type() {
        return this.type;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of StorageClassTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of StorageClassTypeProperties if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the StorageClassTypeProperties.
     */
    public static StorageClassTypeProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("Native".equals(discriminatorValue)) {
                    return NativeStorageClassTypeProperties.fromJson(readerToUse.reset());
                } else if ("RWX".equals(discriminatorValue)) {
                    return RwxStorageClassTypeProperties.fromJson(readerToUse.reset());
                } else if ("Blob".equals(discriminatorValue)) {
                    return BlobStorageClassTypeProperties.fromJson(readerToUse.reset());
                } else if ("NFS".equals(discriminatorValue)) {
                    return NfsStorageClassTypeProperties.fromJson(readerToUse.reset());
                } else if ("SMB".equals(discriminatorValue)) {
                    return SmbStorageClassTypeProperties.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static StorageClassTypeProperties fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            StorageClassTypeProperties deserializedStorageClassTypeProperties = new StorageClassTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedStorageClassTypeProperties.type = SCType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedStorageClassTypeProperties;
        });
    }
}
