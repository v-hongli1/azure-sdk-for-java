// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventhubs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * SKU parameters particular to a cluster instance.
 */
@Fluent
public final class ClusterSku implements JsonSerializable<ClusterSku> {
    /*
     * Name of this SKU.
     */
    private ClusterSkuName name;

    /*
     * The quantity of Event Hubs Cluster Capacity Units contained in this cluster.
     */
    private Integer capacity;

    /**
     * Creates an instance of ClusterSku class.
     */
    public ClusterSku() {
    }

    /**
     * Get the name property: Name of this SKU.
     * 
     * @return the name value.
     */
    public ClusterSkuName name() {
        return this.name;
    }

    /**
     * Set the name property: Name of this SKU.
     * 
     * @param name the name value to set.
     * @return the ClusterSku object itself.
     */
    public ClusterSku withName(ClusterSkuName name) {
        this.name = name;
        return this;
    }

    /**
     * Get the capacity property: The quantity of Event Hubs Cluster Capacity Units contained in this cluster.
     * 
     * @return the capacity value.
     */
    public Integer capacity() {
        return this.capacity;
    }

    /**
     * Set the capacity property: The quantity of Event Hubs Cluster Capacity Units contained in this cluster.
     * 
     * @param capacity the capacity value to set.
     * @return the ClusterSku object itself.
     */
    public ClusterSku withCapacity(Integer capacity) {
        this.capacity = capacity;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model ClusterSku"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ClusterSku.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name == null ? null : this.name.toString());
        jsonWriter.writeNumberField("capacity", this.capacity);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClusterSku from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClusterSku if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ClusterSku.
     */
    public static ClusterSku fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ClusterSku deserializedClusterSku = new ClusterSku();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedClusterSku.name = ClusterSkuName.fromString(reader.getString());
                } else if ("capacity".equals(fieldName)) {
                    deserializedClusterSku.capacity = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedClusterSku;
        });
    }
}
