// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.security.keyvault.administration.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The FullBackupOperationError model.
 */
@Immutable
public final class FullBackupOperationError implements JsonSerializable<FullBackupOperationError> {
    /*
     * The error code.
     */
    @Generated
    private String code;

    /*
     * The error message.
     */
    @Generated
    private String message;

    /*
     * The key vault server error.
     */
    @Generated
    private FullBackupOperationError innerError;

    /**
     * Creates an instance of FullBackupOperationError class.
     */
    @Generated
    private FullBackupOperationError() {
    }

    /**
     * Get the code property: The error code.
     * 
     * @return the code value.
     */
    @Generated
    public String getCode() {
        return this.code;
    }

    /**
     * Get the message property: The error message.
     * 
     * @return the message value.
     */
    @Generated
    public String getMessage() {
        return this.message;
    }

    /**
     * Get the innerError property: The key vault server error.
     * 
     * @return the innerError value.
     */
    @Generated
    public FullBackupOperationError getInnerError() {
        return this.innerError;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FullBackupOperationError from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FullBackupOperationError if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the FullBackupOperationError.
     */
    @Generated
    public static FullBackupOperationError fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FullBackupOperationError deserializedFullBackupOperationError = new FullBackupOperationError();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("code".equals(fieldName)) {
                    deserializedFullBackupOperationError.code = reader.getString();
                } else if ("message".equals(fieldName)) {
                    deserializedFullBackupOperationError.message = reader.getString();
                } else if ("innererror".equals(fieldName)) {
                    deserializedFullBackupOperationError.innerError = FullBackupOperationError.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFullBackupOperationError;
        });
    }
}
