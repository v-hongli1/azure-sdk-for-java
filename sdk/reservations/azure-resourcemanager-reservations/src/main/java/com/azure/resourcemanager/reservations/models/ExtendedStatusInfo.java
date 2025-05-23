// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.reservations.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The ExtendedStatusInfo model.
 */
@Fluent
public final class ExtendedStatusInfo implements JsonSerializable<ExtendedStatusInfo> {
    /*
     * The statusCode property.
     */
    private ReservationStatusCode statusCode;

    /*
     * The message giving detailed information about the status code.
     */
    private String message;

    /**
     * Creates an instance of ExtendedStatusInfo class.
     */
    public ExtendedStatusInfo() {
    }

    /**
     * Get the statusCode property: The statusCode property.
     * 
     * @return the statusCode value.
     */
    public ReservationStatusCode statusCode() {
        return this.statusCode;
    }

    /**
     * Set the statusCode property: The statusCode property.
     * 
     * @param statusCode the statusCode value to set.
     * @return the ExtendedStatusInfo object itself.
     */
    public ExtendedStatusInfo withStatusCode(ReservationStatusCode statusCode) {
        this.statusCode = statusCode;
        return this;
    }

    /**
     * Get the message property: The message giving detailed information about the status code.
     * 
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message property: The message giving detailed information about the status code.
     * 
     * @param message the message value to set.
     * @return the ExtendedStatusInfo object itself.
     */
    public ExtendedStatusInfo withMessage(String message) {
        this.message = message;
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
        jsonWriter.writeStringField("statusCode", this.statusCode == null ? null : this.statusCode.toString());
        jsonWriter.writeStringField("message", this.message);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExtendedStatusInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExtendedStatusInfo if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExtendedStatusInfo.
     */
    public static ExtendedStatusInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExtendedStatusInfo deserializedExtendedStatusInfo = new ExtendedStatusInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("statusCode".equals(fieldName)) {
                    deserializedExtendedStatusInfo.statusCode = ReservationStatusCode.fromString(reader.getString());
                } else if ("message".equals(fieldName)) {
                    deserializedExtendedStatusInfo.message = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExtendedStatusInfo;
        });
    }
}
