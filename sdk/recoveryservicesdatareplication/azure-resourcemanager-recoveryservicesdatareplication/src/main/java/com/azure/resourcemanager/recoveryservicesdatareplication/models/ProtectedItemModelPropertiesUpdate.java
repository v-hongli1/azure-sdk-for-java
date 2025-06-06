// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Protected item model properties update.
 */
@Fluent
public final class ProtectedItemModelPropertiesUpdate implements JsonSerializable<ProtectedItemModelPropertiesUpdate> {
    /*
     * Protected item model custom properties update.
     */
    private ProtectedItemModelCustomPropertiesUpdate customProperties;

    /**
     * Creates an instance of ProtectedItemModelPropertiesUpdate class.
     */
    public ProtectedItemModelPropertiesUpdate() {
    }

    /**
     * Get the customProperties property: Protected item model custom properties update.
     * 
     * @return the customProperties value.
     */
    public ProtectedItemModelCustomPropertiesUpdate customProperties() {
        return this.customProperties;
    }

    /**
     * Set the customProperties property: Protected item model custom properties update.
     * 
     * @param customProperties the customProperties value to set.
     * @return the ProtectedItemModelPropertiesUpdate object itself.
     */
    public ProtectedItemModelPropertiesUpdate
        withCustomProperties(ProtectedItemModelCustomPropertiesUpdate customProperties) {
        this.customProperties = customProperties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (customProperties() != null) {
            customProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("customProperties", this.customProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProtectedItemModelPropertiesUpdate from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProtectedItemModelPropertiesUpdate if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ProtectedItemModelPropertiesUpdate.
     */
    public static ProtectedItemModelPropertiesUpdate fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProtectedItemModelPropertiesUpdate deserializedProtectedItemModelPropertiesUpdate
                = new ProtectedItemModelPropertiesUpdate();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("customProperties".equals(fieldName)) {
                    deserializedProtectedItemModelPropertiesUpdate.customProperties
                        = ProtectedItemModelCustomPropertiesUpdate.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProtectedItemModelPropertiesUpdate;
        });
    }
}
