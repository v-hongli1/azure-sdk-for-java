// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.synapse.fluent.models.ReplicationLinkInner;
import java.io.IOException;
import java.util.List;

/**
 * Represents the response to a List Sql pool replication link request.
 */
@Fluent
public final class ReplicationLinkListResult implements JsonSerializable<ReplicationLinkListResult> {
    /*
     * The list of Sql pool replication links housed in the Sql pool.
     */
    private List<ReplicationLinkInner> value;

    /*
     * Link to retrieve next page of results.
     */
    private String nextLink;

    /**
     * Creates an instance of ReplicationLinkListResult class.
     */
    public ReplicationLinkListResult() {
    }

    /**
     * Get the value property: The list of Sql pool replication links housed in the Sql pool.
     * 
     * @return the value value.
     */
    public List<ReplicationLinkInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of Sql pool replication links housed in the Sql pool.
     * 
     * @param value the value value to set.
     * @return the ReplicationLinkListResult object itself.
     */
    public ReplicationLinkListResult withValue(List<ReplicationLinkInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link to retrieve next page of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ReplicationLinkListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ReplicationLinkListResult if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ReplicationLinkListResult.
     */
    public static ReplicationLinkListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ReplicationLinkListResult deserializedReplicationLinkListResult = new ReplicationLinkListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ReplicationLinkInner> value
                        = reader.readArray(reader1 -> ReplicationLinkInner.fromJson(reader1));
                    deserializedReplicationLinkListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedReplicationLinkListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedReplicationLinkListResult;
        });
    }
}
