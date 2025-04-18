// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hybridconnectivity.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * ConnectorId and SolutionTypes and their properties to Generate AWS CFT Template.
 */
@Fluent
public final class GenerateAwsTemplateRequest implements JsonSerializable<GenerateAwsTemplateRequest> {
    /*
     * The name of public cloud connector
     */
    private String connectorId;

    /*
     * The list of solution types and their settings
     */
    private List<SolutionTypeSettings> solutionTypes;

    /**
     * Creates an instance of GenerateAwsTemplateRequest class.
     */
    public GenerateAwsTemplateRequest() {
    }

    /**
     * Get the connectorId property: The name of public cloud connector.
     * 
     * @return the connectorId value.
     */
    public String connectorId() {
        return this.connectorId;
    }

    /**
     * Set the connectorId property: The name of public cloud connector.
     * 
     * @param connectorId the connectorId value to set.
     * @return the GenerateAwsTemplateRequest object itself.
     */
    public GenerateAwsTemplateRequest withConnectorId(String connectorId) {
        this.connectorId = connectorId;
        return this;
    }

    /**
     * Get the solutionTypes property: The list of solution types and their settings.
     * 
     * @return the solutionTypes value.
     */
    public List<SolutionTypeSettings> solutionTypes() {
        return this.solutionTypes;
    }

    /**
     * Set the solutionTypes property: The list of solution types and their settings.
     * 
     * @param solutionTypes the solutionTypes value to set.
     * @return the GenerateAwsTemplateRequest object itself.
     */
    public GenerateAwsTemplateRequest withSolutionTypes(List<SolutionTypeSettings> solutionTypes) {
        this.solutionTypes = solutionTypes;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (connectorId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property connectorId in model GenerateAwsTemplateRequest"));
        }
        if (solutionTypes() != null) {
            solutionTypes().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(GenerateAwsTemplateRequest.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("connectorId", this.connectorId);
        jsonWriter.writeArrayField("solutionTypes", this.solutionTypes, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GenerateAwsTemplateRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GenerateAwsTemplateRequest if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GenerateAwsTemplateRequest.
     */
    public static GenerateAwsTemplateRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GenerateAwsTemplateRequest deserializedGenerateAwsTemplateRequest = new GenerateAwsTemplateRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("connectorId".equals(fieldName)) {
                    deserializedGenerateAwsTemplateRequest.connectorId = reader.getString();
                } else if ("solutionTypes".equals(fieldName)) {
                    List<SolutionTypeSettings> solutionTypes
                        = reader.readArray(reader1 -> SolutionTypeSettings.fromJson(reader1));
                    deserializedGenerateAwsTemplateRequest.solutionTypes = solutionTypes;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGenerateAwsTemplateRequest;
        });
    }
}
