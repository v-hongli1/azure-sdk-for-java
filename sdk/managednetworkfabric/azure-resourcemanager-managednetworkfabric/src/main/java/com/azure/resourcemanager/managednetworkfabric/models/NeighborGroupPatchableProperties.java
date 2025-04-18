// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Neighbor Group Patchable Properties defines the patchable properties of the resource.
 */
@Fluent
public class NeighborGroupPatchableProperties implements JsonSerializable<NeighborGroupPatchableProperties> {
    /*
     * An array of destination IPv4 Addresses or IPv6 Addresses.
     */
    private NeighborGroupDestination destination;

    /**
     * Creates an instance of NeighborGroupPatchableProperties class.
     */
    public NeighborGroupPatchableProperties() {
    }

    /**
     * Get the destination property: An array of destination IPv4 Addresses or IPv6 Addresses.
     * 
     * @return the destination value.
     */
    public NeighborGroupDestination destination() {
        return this.destination;
    }

    /**
     * Set the destination property: An array of destination IPv4 Addresses or IPv6 Addresses.
     * 
     * @param destination the destination value to set.
     * @return the NeighborGroupPatchableProperties object itself.
     */
    public NeighborGroupPatchableProperties withDestination(NeighborGroupDestination destination) {
        this.destination = destination;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (destination() != null) {
            destination().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("destination", this.destination);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NeighborGroupPatchableProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NeighborGroupPatchableProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NeighborGroupPatchableProperties.
     */
    public static NeighborGroupPatchableProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NeighborGroupPatchableProperties deserializedNeighborGroupPatchableProperties
                = new NeighborGroupPatchableProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("destination".equals(fieldName)) {
                    deserializedNeighborGroupPatchableProperties.destination
                        = NeighborGroupDestination.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNeighborGroupPatchableProperties;
        });
    }
}
