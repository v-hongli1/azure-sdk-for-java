// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.management.ProxyResource;
import com.azure.core.management.SystemData;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.oracledatabase.models.AutonomousDbVersionProperties;
import java.io.IOException;

/**
 * AutonomousDbVersion resource definition.
 */
@Immutable
public final class AutonomousDbVersionInner extends ProxyResource {
    /*
     * The resource-specific properties for this resource.
     */
    private AutonomousDbVersionProperties properties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SystemData systemData;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of AutonomousDbVersionInner class.
     */
    private AutonomousDbVersionInner() {
    }

    /**
     * Get the properties property: The resource-specific properties for this resource.
     * 
     * @return the properties value.
     */
    public AutonomousDbVersionProperties properties() {
        return this.properties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    public SystemData systemData() {
        return this.systemData;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
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
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AutonomousDbVersionInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AutonomousDbVersionInner if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AutonomousDbVersionInner.
     */
    public static AutonomousDbVersionInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AutonomousDbVersionInner deserializedAutonomousDbVersionInner = new AutonomousDbVersionInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedAutonomousDbVersionInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedAutonomousDbVersionInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedAutonomousDbVersionInner.type = reader.getString();
                } else if ("properties".equals(fieldName)) {
                    deserializedAutonomousDbVersionInner.properties = AutonomousDbVersionProperties.fromJson(reader);
                } else if ("systemData".equals(fieldName)) {
                    deserializedAutonomousDbVersionInner.systemData = SystemData.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAutonomousDbVersionInner;
        });
    }
}
