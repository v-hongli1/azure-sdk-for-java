// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Azure storage specific error information.
 */
@Fluent
public final class AzureStorageErrorInfo implements JsonSerializable<AzureStorageErrorInfo> {
    /*
     * Error code.
     */
    private Integer errorCode;

    /*
     * Localized error string.
     */
    private String errorString;

    /*
     * List of localized recommendations for above error code.
     */
    private List<String> recommendations;

    /**
     * Creates an instance of AzureStorageErrorInfo class.
     */
    public AzureStorageErrorInfo() {
    }

    /**
     * Get the errorCode property: Error code.
     * 
     * @return the errorCode value.
     */
    public Integer errorCode() {
        return this.errorCode;
    }

    /**
     * Set the errorCode property: Error code.
     * 
     * @param errorCode the errorCode value to set.
     * @return the AzureStorageErrorInfo object itself.
     */
    public AzureStorageErrorInfo withErrorCode(Integer errorCode) {
        this.errorCode = errorCode;
        return this;
    }

    /**
     * Get the errorString property: Localized error string.
     * 
     * @return the errorString value.
     */
    public String errorString() {
        return this.errorString;
    }

    /**
     * Set the errorString property: Localized error string.
     * 
     * @param errorString the errorString value to set.
     * @return the AzureStorageErrorInfo object itself.
     */
    public AzureStorageErrorInfo withErrorString(String errorString) {
        this.errorString = errorString;
        return this;
    }

    /**
     * Get the recommendations property: List of localized recommendations for above error code.
     * 
     * @return the recommendations value.
     */
    public List<String> recommendations() {
        return this.recommendations;
    }

    /**
     * Set the recommendations property: List of localized recommendations for above error code.
     * 
     * @param recommendations the recommendations value to set.
     * @return the AzureStorageErrorInfo object itself.
     */
    public AzureStorageErrorInfo withRecommendations(List<String> recommendations) {
        this.recommendations = recommendations;
        return this;
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
        jsonWriter.writeNumberField("errorCode", this.errorCode);
        jsonWriter.writeStringField("errorString", this.errorString);
        jsonWriter.writeArrayField("recommendations", this.recommendations,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureStorageErrorInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureStorageErrorInfo if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AzureStorageErrorInfo.
     */
    public static AzureStorageErrorInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AzureStorageErrorInfo deserializedAzureStorageErrorInfo = new AzureStorageErrorInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("errorCode".equals(fieldName)) {
                    deserializedAzureStorageErrorInfo.errorCode = reader.getNullable(JsonReader::getInt);
                } else if ("errorString".equals(fieldName)) {
                    deserializedAzureStorageErrorInfo.errorString = reader.getString();
                } else if ("recommendations".equals(fieldName)) {
                    List<String> recommendations = reader.readArray(reader1 -> reader1.getString());
                    deserializedAzureStorageErrorInfo.recommendations = recommendations;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAzureStorageErrorInfo;
        });
    }
}
