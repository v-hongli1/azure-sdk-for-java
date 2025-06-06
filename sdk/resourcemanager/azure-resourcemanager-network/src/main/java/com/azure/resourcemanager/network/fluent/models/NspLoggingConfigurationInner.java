// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.SecurityPerimeterProxyResource;
import com.azure.resourcemanager.network.models.SecurityPerimeterSystemData;
import java.io.IOException;
import java.util.List;

/**
 * The NSP logging configuration.
 */
@Fluent
public final class NspLoggingConfigurationInner extends SecurityPerimeterProxyResource {
    /*
     * Properties of the NSP logging configuration.
     */
    private NspLoggingConfigurationProperties innerProperties;

    /*
     * Azure Resource Manager metadata containing createdBy and modifiedBy information.
     */
    private SecurityPerimeterSystemData systemData;

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
     * Creates an instance of NspLoggingConfigurationInner class.
     */
    public NspLoggingConfigurationInner() {
    }

    /**
     * Get the innerProperties property: Properties of the NSP logging configuration.
     * 
     * @return the innerProperties value.
     */
    private NspLoggingConfigurationProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    @Override
    public SecurityPerimeterSystemData systemData() {
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
     * Get the enabledLogCategories property: The log categories to enable in the NSP logging configuration.
     * 
     * @return the enabledLogCategories value.
     */
    public List<String> enabledLogCategories() {
        return this.innerProperties() == null ? null : this.innerProperties().enabledLogCategories();
    }

    /**
     * Set the enabledLogCategories property: The log categories to enable in the NSP logging configuration.
     * 
     * @param enabledLogCategories the enabledLogCategories value to set.
     * @return the NspLoggingConfigurationInner object itself.
     */
    public NspLoggingConfigurationInner withEnabledLogCategories(List<String> enabledLogCategories) {
        if (this.innerProperties() == null) {
            this.innerProperties = new NspLoggingConfigurationProperties();
        }
        this.innerProperties().withEnabledLogCategories(enabledLogCategories);
        return this;
    }

    /**
     * Get the version property: The version of the NSP logging configuration.
     * 
     * @return the version value.
     */
    public String version() {
        return this.innerProperties() == null ? null : this.innerProperties().version();
    }

    /**
     * Set the version property: The version of the NSP logging configuration.
     * 
     * @param version the version value to set.
     * @return the NspLoggingConfigurationInner object itself.
     */
    public NspLoggingConfigurationInner withVersion(String version) {
        if (this.innerProperties() == null) {
            this.innerProperties = new NspLoggingConfigurationProperties();
        }
        this.innerProperties().withVersion(version);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
        if (systemData() != null) {
            systemData().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NspLoggingConfigurationInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NspLoggingConfigurationInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the NspLoggingConfigurationInner.
     */
    public static NspLoggingConfigurationInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NspLoggingConfigurationInner deserializedNspLoggingConfigurationInner = new NspLoggingConfigurationInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedNspLoggingConfigurationInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedNspLoggingConfigurationInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedNspLoggingConfigurationInner.type = reader.getString();
                } else if ("systemData".equals(fieldName)) {
                    deserializedNspLoggingConfigurationInner.systemData = SecurityPerimeterSystemData.fromJson(reader);
                } else if ("properties".equals(fieldName)) {
                    deserializedNspLoggingConfigurationInner.innerProperties
                        = NspLoggingConfigurationProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNspLoggingConfigurationInner;
        });
    }
}
