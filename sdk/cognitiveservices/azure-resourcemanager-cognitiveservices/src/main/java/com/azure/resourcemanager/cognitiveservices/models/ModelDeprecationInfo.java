// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Cognitive Services account ModelDeprecationInfo.
 */
@Fluent
public final class ModelDeprecationInfo implements JsonSerializable<ModelDeprecationInfo> {
    /*
     * The datetime of deprecation of the fineTune Model.
     */
    private String fineTune;

    /*
     * The datetime of deprecation of the inference Model.
     */
    private String inference;

    /**
     * Creates an instance of ModelDeprecationInfo class.
     */
    public ModelDeprecationInfo() {
    }

    /**
     * Get the fineTune property: The datetime of deprecation of the fineTune Model.
     * 
     * @return the fineTune value.
     */
    public String fineTune() {
        return this.fineTune;
    }

    /**
     * Set the fineTune property: The datetime of deprecation of the fineTune Model.
     * 
     * @param fineTune the fineTune value to set.
     * @return the ModelDeprecationInfo object itself.
     */
    public ModelDeprecationInfo withFineTune(String fineTune) {
        this.fineTune = fineTune;
        return this;
    }

    /**
     * Get the inference property: The datetime of deprecation of the inference Model.
     * 
     * @return the inference value.
     */
    public String inference() {
        return this.inference;
    }

    /**
     * Set the inference property: The datetime of deprecation of the inference Model.
     * 
     * @param inference the inference value to set.
     * @return the ModelDeprecationInfo object itself.
     */
    public ModelDeprecationInfo withInference(String inference) {
        this.inference = inference;
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
        jsonWriter.writeStringField("fineTune", this.fineTune);
        jsonWriter.writeStringField("inference", this.inference);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ModelDeprecationInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ModelDeprecationInfo if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ModelDeprecationInfo.
     */
    public static ModelDeprecationInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ModelDeprecationInfo deserializedModelDeprecationInfo = new ModelDeprecationInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("fineTune".equals(fieldName)) {
                    deserializedModelDeprecationInfo.fineTune = reader.getString();
                } else if ("inference".equals(fieldName)) {
                    deserializedModelDeprecationInfo.inference = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedModelDeprecationInfo;
        });
    }
}
