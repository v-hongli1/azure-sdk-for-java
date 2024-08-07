// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The ID of the ExpressRouteConnection.
 */
@Immutable
public final class ExpressRouteConnectionId implements JsonSerializable<ExpressRouteConnectionId> {
    /*
     * The ID of the ExpressRouteConnection.
     */
    private String id;

    /**
     * Creates an instance of ExpressRouteConnectionId class.
     */
    public ExpressRouteConnectionId() {
    }

    /**
     * Get the id property: The ID of the ExpressRouteConnection.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExpressRouteConnectionId from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExpressRouteConnectionId if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExpressRouteConnectionId.
     */
    public static ExpressRouteConnectionId fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExpressRouteConnectionId deserializedExpressRouteConnectionId = new ExpressRouteConnectionId();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedExpressRouteConnectionId.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExpressRouteConnectionId;
        });
    }
}
