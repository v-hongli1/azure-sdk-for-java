// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.customerinsights.fluent.models.HubInner;
import java.io.IOException;
import java.util.List;

/**
 * Response of list hub operation.
 */
@Fluent
public final class HubListResult implements JsonSerializable<HubListResult> {
    /*
     * Results of the list operation.
     */
    private List<HubInner> value;

    /*
     * Link for next set of results.
     */
    private String nextLink;

    /**
     * Creates an instance of HubListResult class.
     */
    public HubListResult() {
    }

    /**
     * Get the value property: Results of the list operation.
     * 
     * @return the value value.
     */
    public List<HubInner> value() {
        return this.value;
    }

    /**
     * Set the value property: Results of the list operation.
     * 
     * @param value the value value to set.
     * @return the HubListResult object itself.
     */
    public HubListResult withValue(List<HubInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: Link for next set of results.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: Link for next set of results.
     * 
     * @param nextLink the nextLink value to set.
     * @return the HubListResult object itself.
     */
    public HubListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
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
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HubListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HubListResult if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the HubListResult.
     */
    public static HubListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HubListResult deserializedHubListResult = new HubListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<HubInner> value = reader.readArray(reader1 -> HubInner.fromJson(reader1));
                    deserializedHubListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedHubListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedHubListResult;
        });
    }
}
