// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dependencymap.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * GetConnectionsWithConnectedMachineForFocusedMachine request model.
 */
@Fluent
public final class GetConnectionsWithConnectedMachineForFocusedMachineRequest
    implements JsonSerializable<GetConnectionsWithConnectedMachineForFocusedMachineRequest> {
    /*
     * Source machine arm id
     */
    private String focusedMachineId;

    /*
     * Destination machine arm id
     */
    private String connectedMachineId;

    /*
     * Filters for GetNetworkConnectionsBetweenMachines
     */
    private DependencyMapVisualizationFilter filters;

    /**
     * Creates an instance of GetConnectionsWithConnectedMachineForFocusedMachineRequest class.
     */
    public GetConnectionsWithConnectedMachineForFocusedMachineRequest() {
    }

    /**
     * Get the focusedMachineId property: Source machine arm id.
     * 
     * @return the focusedMachineId value.
     */
    public String focusedMachineId() {
        return this.focusedMachineId;
    }

    /**
     * Set the focusedMachineId property: Source machine arm id.
     * 
     * @param focusedMachineId the focusedMachineId value to set.
     * @return the GetConnectionsWithConnectedMachineForFocusedMachineRequest object itself.
     */
    public GetConnectionsWithConnectedMachineForFocusedMachineRequest withFocusedMachineId(String focusedMachineId) {
        this.focusedMachineId = focusedMachineId;
        return this;
    }

    /**
     * Get the connectedMachineId property: Destination machine arm id.
     * 
     * @return the connectedMachineId value.
     */
    public String connectedMachineId() {
        return this.connectedMachineId;
    }

    /**
     * Set the connectedMachineId property: Destination machine arm id.
     * 
     * @param connectedMachineId the connectedMachineId value to set.
     * @return the GetConnectionsWithConnectedMachineForFocusedMachineRequest object itself.
     */
    public GetConnectionsWithConnectedMachineForFocusedMachineRequest
        withConnectedMachineId(String connectedMachineId) {
        this.connectedMachineId = connectedMachineId;
        return this;
    }

    /**
     * Get the filters property: Filters for GetNetworkConnectionsBetweenMachines.
     * 
     * @return the filters value.
     */
    public DependencyMapVisualizationFilter filters() {
        return this.filters;
    }

    /**
     * Set the filters property: Filters for GetNetworkConnectionsBetweenMachines.
     * 
     * @param filters the filters value to set.
     * @return the GetConnectionsWithConnectedMachineForFocusedMachineRequest object itself.
     */
    public GetConnectionsWithConnectedMachineForFocusedMachineRequest
        withFilters(DependencyMapVisualizationFilter filters) {
        this.filters = filters;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (focusedMachineId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property focusedMachineId in model GetConnectionsWithConnectedMachineForFocusedMachineRequest"));
        }
        if (connectedMachineId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property connectedMachineId in model GetConnectionsWithConnectedMachineForFocusedMachineRequest"));
        }
        if (filters() != null) {
            filters().validate();
        }
    }

    private static final ClientLogger LOGGER
        = new ClientLogger(GetConnectionsWithConnectedMachineForFocusedMachineRequest.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("focusedMachineId", this.focusedMachineId);
        jsonWriter.writeStringField("connectedMachineId", this.connectedMachineId);
        jsonWriter.writeJsonField("filters", this.filters);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GetConnectionsWithConnectedMachineForFocusedMachineRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GetConnectionsWithConnectedMachineForFocusedMachineRequest if the JsonReader was pointing
     * to an instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the
     * GetConnectionsWithConnectedMachineForFocusedMachineRequest.
     */
    public static GetConnectionsWithConnectedMachineForFocusedMachineRequest fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            GetConnectionsWithConnectedMachineForFocusedMachineRequest deserializedGetConnectionsWithConnectedMachineForFocusedMachineRequest
                = new GetConnectionsWithConnectedMachineForFocusedMachineRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("focusedMachineId".equals(fieldName)) {
                    deserializedGetConnectionsWithConnectedMachineForFocusedMachineRequest.focusedMachineId
                        = reader.getString();
                } else if ("connectedMachineId".equals(fieldName)) {
                    deserializedGetConnectionsWithConnectedMachineForFocusedMachineRequest.connectedMachineId
                        = reader.getString();
                } else if ("filters".equals(fieldName)) {
                    deserializedGetConnectionsWithConnectedMachineForFocusedMachineRequest.filters
                        = DependencyMapVisualizationFilter.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGetConnectionsWithConnectedMachineForFocusedMachineRequest;
        });
    }
}
