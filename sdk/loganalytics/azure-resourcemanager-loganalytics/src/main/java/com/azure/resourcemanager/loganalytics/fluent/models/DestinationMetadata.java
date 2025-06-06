// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Destination meta data.
 */
@Fluent
public final class DestinationMetadata implements JsonSerializable<DestinationMetadata> {
    /*
     * Optional. Allows to define an Event Hub name. Not applicable when destination is Storage Account.
     */
    private String eventHubName;

    /**
     * Creates an instance of DestinationMetadata class.
     */
    public DestinationMetadata() {
    }

    /**
     * Get the eventHubName property: Optional. Allows to define an Event Hub name. Not applicable when destination is
     * Storage Account.
     * 
     * @return the eventHubName value.
     */
    public String eventHubName() {
        return this.eventHubName;
    }

    /**
     * Set the eventHubName property: Optional. Allows to define an Event Hub name. Not applicable when destination is
     * Storage Account.
     * 
     * @param eventHubName the eventHubName value to set.
     * @return the DestinationMetadata object itself.
     */
    public DestinationMetadata withEventHubName(String eventHubName) {
        this.eventHubName = eventHubName;
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
        jsonWriter.writeStringField("eventHubName", this.eventHubName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DestinationMetadata from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DestinationMetadata if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DestinationMetadata.
     */
    public static DestinationMetadata fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DestinationMetadata deserializedDestinationMetadata = new DestinationMetadata();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("eventHubName".equals(fieldName)) {
                    deserializedDestinationMetadata.eventHubName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDestinationMetadata;
        });
    }
}
