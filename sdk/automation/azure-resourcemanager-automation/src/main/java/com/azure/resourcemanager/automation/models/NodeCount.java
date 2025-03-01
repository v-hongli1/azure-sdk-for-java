// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.automation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Number of nodes based on the Filter.
 */
@Fluent
public final class NodeCount implements JsonSerializable<NodeCount> {
    /*
     * Gets the name of a count type
     */
    private String name;

    /*
     * The properties property.
     */
    private NodeCountProperties properties;

    /**
     * Creates an instance of NodeCount class.
     */
    public NodeCount() {
    }

    /**
     * Get the name property: Gets the name of a count type.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: Gets the name of a count type.
     * 
     * @param name the name value to set.
     * @return the NodeCount object itself.
     */
    public NodeCount withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the properties property: The properties property.
     * 
     * @return the properties value.
     */
    public NodeCountProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The properties property.
     * 
     * @param properties the properties value to set.
     * @return the NodeCount object itself.
     */
    public NodeCount withProperties(NodeCountProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NodeCount from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NodeCount if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the NodeCount.
     */
    public static NodeCount fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NodeCount deserializedNodeCount = new NodeCount();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedNodeCount.name = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedNodeCount.properties = NodeCountProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNodeCount;
        });
    }
}
