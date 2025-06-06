// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * GiVersion resource model.
 */
@Immutable
public final class GiVersionProperties implements JsonSerializable<GiVersionProperties> {
    /*
     * A valid Oracle Grid Infrastructure (GI) software version.
     */
    private String version;

    /**
     * Creates an instance of GiVersionProperties class.
     */
    private GiVersionProperties() {
    }

    /**
     * Get the version property: A valid Oracle Grid Infrastructure (GI) software version.
     * 
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (version() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property version in model GiVersionProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GiVersionProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", this.version);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GiVersionProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GiVersionProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GiVersionProperties.
     */
    public static GiVersionProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GiVersionProperties deserializedGiVersionProperties = new GiVersionProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedGiVersionProperties.version = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGiVersionProperties;
        });
    }
}
