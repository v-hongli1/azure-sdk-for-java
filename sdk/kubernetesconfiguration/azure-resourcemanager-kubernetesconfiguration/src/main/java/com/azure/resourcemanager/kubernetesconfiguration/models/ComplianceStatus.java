// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kubernetesconfiguration.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Compliance Status details.
 */
@Fluent
public final class ComplianceStatus implements JsonSerializable<ComplianceStatus> {
    /*
     * The compliance state of the configuration.
     */
    private ComplianceStateType complianceState;

    /*
     * Datetime the configuration was last applied.
     */
    private OffsetDateTime lastConfigApplied;

    /*
     * Message from when the configuration was applied.
     */
    private String message;

    /*
     * Level of the message.
     */
    private MessageLevelType messageLevel;

    /**
     * Creates an instance of ComplianceStatus class.
     */
    public ComplianceStatus() {
    }

    /**
     * Get the complianceState property: The compliance state of the configuration.
     * 
     * @return the complianceState value.
     */
    public ComplianceStateType complianceState() {
        return this.complianceState;
    }

    /**
     * Get the lastConfigApplied property: Datetime the configuration was last applied.
     * 
     * @return the lastConfigApplied value.
     */
    public OffsetDateTime lastConfigApplied() {
        return this.lastConfigApplied;
    }

    /**
     * Set the lastConfigApplied property: Datetime the configuration was last applied.
     * 
     * @param lastConfigApplied the lastConfigApplied value to set.
     * @return the ComplianceStatus object itself.
     */
    public ComplianceStatus withLastConfigApplied(OffsetDateTime lastConfigApplied) {
        this.lastConfigApplied = lastConfigApplied;
        return this;
    }

    /**
     * Get the message property: Message from when the configuration was applied.
     * 
     * @return the message value.
     */
    public String message() {
        return this.message;
    }

    /**
     * Set the message property: Message from when the configuration was applied.
     * 
     * @param message the message value to set.
     * @return the ComplianceStatus object itself.
     */
    public ComplianceStatus withMessage(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get the messageLevel property: Level of the message.
     * 
     * @return the messageLevel value.
     */
    public MessageLevelType messageLevel() {
        return this.messageLevel;
    }

    /**
     * Set the messageLevel property: Level of the message.
     * 
     * @param messageLevel the messageLevel value to set.
     * @return the ComplianceStatus object itself.
     */
    public ComplianceStatus withMessageLevel(MessageLevelType messageLevel) {
        this.messageLevel = messageLevel;
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
        jsonWriter.writeStringField("lastConfigApplied",
            this.lastConfigApplied == null
                ? null
                : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.lastConfigApplied));
        jsonWriter.writeStringField("message", this.message);
        jsonWriter.writeStringField("messageLevel", this.messageLevel == null ? null : this.messageLevel.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ComplianceStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ComplianceStatus if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ComplianceStatus.
     */
    public static ComplianceStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ComplianceStatus deserializedComplianceStatus = new ComplianceStatus();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("complianceState".equals(fieldName)) {
                    deserializedComplianceStatus.complianceState = ComplianceStateType.fromString(reader.getString());
                } else if ("lastConfigApplied".equals(fieldName)) {
                    deserializedComplianceStatus.lastConfigApplied = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("message".equals(fieldName)) {
                    deserializedComplianceStatus.message = reader.getString();
                } else if ("messageLevel".equals(fieldName)) {
                    deserializedComplianceStatus.messageLevel = MessageLevelType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedComplianceStatus;
        });
    }
}
