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

/**
 * Container App Runtime configuration.
 */
@Fluent
public final class Runtime implements JsonSerializable<Runtime> {
    /*
     * Java app configuration
     */
    private RuntimeJava java;

    /**
     * Creates an instance of Runtime class.
     */
    public Runtime() {
    }

    /**
     * Get the java property: Java app configuration.
     * 
     * @return the java value.
     */
    public RuntimeJava java() {
        return this.java;
    }

    /**
     * Set the java property: Java app configuration.
     * 
     * @param java the java value to set.
     * @return the Runtime object itself.
     */
    public Runtime withJava(RuntimeJava java) {
        this.java = java;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (java() != null) {
            java().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("java", this.java);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Runtime from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Runtime if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Runtime.
     */
    public static Runtime fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Runtime deserializedRuntime = new Runtime();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("java".equals(fieldName)) {
                    deserializedRuntime.java = RuntimeJava.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRuntime;
        });
    }
}
