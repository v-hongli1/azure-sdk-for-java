// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The location of Google Cloud Storage dataset.
 */
@Fluent
public final class GoogleCloudStorageLocation extends DatasetLocation {
    /*
     * Type of dataset storage location.
     */
    private String type = "GoogleCloudStorageLocation";

    /*
     * Specify the bucketName of Google Cloud Storage. Type: string (or Expression with resultType string)
     */
    private Object bucketName;

    /*
     * Specify the version of Google Cloud Storage. Type: string (or Expression with resultType string).
     */
    private Object version;

    /**
     * Creates an instance of GoogleCloudStorageLocation class.
     */
    public GoogleCloudStorageLocation() {
    }

    /**
     * Get the type property: Type of dataset storage location.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the bucketName property: Specify the bucketName of Google Cloud Storage. Type: string (or Expression with
     * resultType string).
     * 
     * @return the bucketName value.
     */
    public Object bucketName() {
        return this.bucketName;
    }

    /**
     * Set the bucketName property: Specify the bucketName of Google Cloud Storage. Type: string (or Expression with
     * resultType string).
     * 
     * @param bucketName the bucketName value to set.
     * @return the GoogleCloudStorageLocation object itself.
     */
    public GoogleCloudStorageLocation withBucketName(Object bucketName) {
        this.bucketName = bucketName;
        return this;
    }

    /**
     * Get the version property: Specify the version of Google Cloud Storage. Type: string (or Expression with
     * resultType string).
     * 
     * @return the version value.
     */
    public Object version() {
        return this.version;
    }

    /**
     * Set the version property: Specify the version of Google Cloud Storage. Type: string (or Expression with
     * resultType string).
     * 
     * @param version the version value to set.
     * @return the GoogleCloudStorageLocation object itself.
     */
    public GoogleCloudStorageLocation withVersion(Object version) {
        this.version = version;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLocation withFolderPath(Object folderPath) {
        super.withFolderPath(folderPath);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public GoogleCloudStorageLocation withFileName(Object fileName) {
        super.withFileName(fileName);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (folderPath() != null) {
            jsonWriter.writeUntypedField("folderPath", folderPath());
        }
        if (fileName() != null) {
            jsonWriter.writeUntypedField("fileName", fileName());
        }
        jsonWriter.writeStringField("type", this.type);
        if (this.bucketName != null) {
            jsonWriter.writeUntypedField("bucketName", this.bucketName);
        }
        if (this.version != null) {
            jsonWriter.writeUntypedField("version", this.version);
        }
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GoogleCloudStorageLocation from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GoogleCloudStorageLocation if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GoogleCloudStorageLocation.
     */
    public static GoogleCloudStorageLocation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GoogleCloudStorageLocation deserializedGoogleCloudStorageLocation = new GoogleCloudStorageLocation();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("folderPath".equals(fieldName)) {
                    deserializedGoogleCloudStorageLocation.withFolderPath(reader.readUntyped());
                } else if ("fileName".equals(fieldName)) {
                    deserializedGoogleCloudStorageLocation.withFileName(reader.readUntyped());
                } else if ("type".equals(fieldName)) {
                    deserializedGoogleCloudStorageLocation.type = reader.getString();
                } else if ("bucketName".equals(fieldName)) {
                    deserializedGoogleCloudStorageLocation.bucketName = reader.readUntyped();
                } else if ("version".equals(fieldName)) {
                    deserializedGoogleCloudStorageLocation.version = reader.readUntyped();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedGoogleCloudStorageLocation.withAdditionalProperties(additionalProperties);

            return deserializedGoogleCloudStorageLocation;
        });
    }
}
