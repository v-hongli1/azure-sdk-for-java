// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SystemData;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.CommonTrackedResource;
import com.azure.resourcemanager.network.models.VerifierWorkspaceProperties;
import java.io.IOException;
import java.util.Map;

/**
 * Instance of Verifier Workspace.
 */
@Fluent
public final class VerifierWorkspaceInner extends CommonTrackedResource {
    /*
     * Properties of Verifier Workspace resource.
     */
    private VerifierWorkspaceProperties properties;

    /*
     * String representing unique etag for the resource document.
     */
    private String etag;

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
     * Creates an instance of VerifierWorkspaceInner class.
     */
    public VerifierWorkspaceInner() {
    }

    /**
     * Get the properties property: Properties of Verifier Workspace resource.
     * 
     * @return the properties value.
     */
    public VerifierWorkspaceProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: Properties of Verifier Workspace resource.
     * 
     * @param properties the properties value to set.
     * @return the VerifierWorkspaceInner object itself.
     */
    public VerifierWorkspaceInner withProperties(VerifierWorkspaceProperties properties) {
        this.properties = properties;
        return this;
    }

    /**
     * Get the etag property: String representing unique etag for the resource document.
     * 
     * @return the etag value.
     */
    public String etag() {
        return this.etag;
    }

    /**
     * Get the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    @Override
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
     * {@inheritDoc}
     */
    @Override
    public VerifierWorkspaceInner withTags(Map<String, String> tags) {
        super.withTags(tags);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public VerifierWorkspaceInner withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
        if (location() == null) {
            throw LOGGER.atError()
                .log(
                    new IllegalArgumentException("Missing required property location in model VerifierWorkspaceInner"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(VerifierWorkspaceInner.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("location", location());
        jsonWriter.writeMapField("tags", tags(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of VerifierWorkspaceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of VerifierWorkspaceInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the VerifierWorkspaceInner.
     */
    public static VerifierWorkspaceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            VerifierWorkspaceInner deserializedVerifierWorkspaceInner = new VerifierWorkspaceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.type = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.withLocation(reader.getString());
                } else if ("systemData".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.systemData = SystemData.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedVerifierWorkspaceInner.withTags(tags);
                } else if ("properties".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.properties = VerifierWorkspaceProperties.fromJson(reader);
                } else if ("etag".equals(fieldName)) {
                    deserializedVerifierWorkspaceInner.etag = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedVerifierWorkspaceInner;
        });
    }
}
