// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.management.exception.ManagementError;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Contains read-only information about the Agent Pool.
 */
@Immutable
public final class AgentPoolStatus implements JsonSerializable<AgentPoolStatus> {
    /*
     * The error detail information of the agent pool. Preserves the detailed info of failure. If there was no error,
     * this field is omitted.
     */
    private ManagementError provisioningError;

    /**
     * Creates an instance of AgentPoolStatus class.
     */
    public AgentPoolStatus() {
    }

    /**
     * Get the provisioningError property: The error detail information of the agent pool. Preserves the detailed info
     * of failure. If there was no error, this field is omitted.
     * 
     * @return the provisioningError value.
     */
    public ManagementError provisioningError() {
        return this.provisioningError;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AgentPoolStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AgentPoolStatus if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AgentPoolStatus.
     */
    public static AgentPoolStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AgentPoolStatus deserializedAgentPoolStatus = new AgentPoolStatus();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningError".equals(fieldName)) {
                    deserializedAgentPoolStatus.provisioningError = ManagementError.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAgentPoolStatus;
        });
    }
}
