// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.migration.assessment.fluent.models.AssessmentOptionsInner;
import java.io.IOException;
import java.util.List;

/**
 * The response of a AssessmentOptions list operation.
 */
@Fluent
public final class AssessmentOptionsListResult implements JsonSerializable<AssessmentOptionsListResult> {
    /*
     * The AssessmentOptions items on this page
     */
    private List<AssessmentOptionsInner> value;

    /*
     * The link to the next page of items
     */
    private String nextLink;

    /**
     * Creates an instance of AssessmentOptionsListResult class.
     */
    public AssessmentOptionsListResult() {
    }

    /**
     * Get the value property: The AssessmentOptions items on this page.
     * 
     * @return the value value.
     */
    public List<AssessmentOptionsInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The AssessmentOptions items on this page.
     * 
     * @param value the value value to set.
     * @return the AssessmentOptionsListResult object itself.
     */
    public AssessmentOptionsListResult withValue(List<AssessmentOptionsInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The link to the next page of items.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The link to the next page of items.
     * 
     * @param nextLink the nextLink value to set.
     * @return the AssessmentOptionsListResult object itself.
     */
    public AssessmentOptionsListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property value in model AssessmentOptionsListResult"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(AssessmentOptionsListResult.class);

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
     * Reads an instance of AssessmentOptionsListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AssessmentOptionsListResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AssessmentOptionsListResult.
     */
    public static AssessmentOptionsListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AssessmentOptionsListResult deserializedAssessmentOptionsListResult = new AssessmentOptionsListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<AssessmentOptionsInner> value
                        = reader.readArray(reader1 -> AssessmentOptionsInner.fromJson(reader1));
                    deserializedAssessmentOptionsListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedAssessmentOptionsListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAssessmentOptionsListResult;
        });
    }
}
