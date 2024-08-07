// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Raw failure information if DNS verification fails.
 */
@Fluent
public final class CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo
    implements JsonSerializable<CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo> {
    /*
     * Standardized string to programmatically identify the error.
     */
    private String code;

    /*
     * Detailed error description and debugging information.
     */
    private String message;

    /*
     * Detailed error description and debugging information.
     */
    private String target;

    /*
     * Details or the error
     */
    private List<CustomHostnameAnalysisResultCustomDomainVerificationFailureInfoDetailsItem> details;

    /**
     * Creates an instance of CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo class.
     */
    public CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo() {
    }

    /**
     * Get the code property: Standardized string to programmatically identify the error.
     * 
     * @return the code value.
     */
    public String code() {
        return this.code;
    }

    /**
     * Get the message property: Detailed error description and debugging information.
     * 
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Get the target property: Detailed error description and debugging information.
     * 
     * @return the target value.
     */
    public String target() {
        return this.target;
    }

    /**
     * Get the details property: Details or the error.
     * 
     * @return the details value.
     */
    public List<CustomHostnameAnalysisResultCustomDomainVerificationFailureInfoDetailsItem> details() {
        return this.details;
    }

    /**
     * Set the details property: Details or the error.
     * 
     * @param details the details value to set.
     * @return the CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo object itself.
     */
    public CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo
        withDetails(List<CustomHostnameAnalysisResultCustomDomainVerificationFailureInfoDetailsItem> details) {
        this.details = details;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (details() != null) {
            details().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("details", this.details, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo if the JsonReader was
     * pointing to an instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the
     * CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo.
     */
    public static CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo
                = new CustomHostnameAnalysisResultCustomDomainVerificationFailureInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo.code
                        = reader.getString();
                } else if ("message".equals(fieldName)) {
                    deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo.message
                        = reader.getString();
                } else if ("target".equals(fieldName)) {
                    deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo.target
                        = reader.getString();
                } else if ("details".equals(fieldName)) {
                    List<CustomHostnameAnalysisResultCustomDomainVerificationFailureInfoDetailsItem> details = reader
                        .readArray(reader1 -> CustomHostnameAnalysisResultCustomDomainVerificationFailureInfoDetailsItem
                            .fromJson(reader1));
                    deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo.details = details;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCustomHostnameAnalysisResultCustomDomainVerificationFailureInfo;
        });
    }
}
