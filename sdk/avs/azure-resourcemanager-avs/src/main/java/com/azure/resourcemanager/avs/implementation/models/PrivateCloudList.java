// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.implementation.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.avs.fluent.models.PrivateCloudInner;
import java.io.IOException;
import java.util.List;

/**
 * The response of a PrivateCloud list operation.
 */
@Immutable
public final class PrivateCloudList implements JsonSerializable<PrivateCloudList> {
    /*
     * The PrivateCloud items on this page
     */
    private List<PrivateCloudInner> value;

    /*
     * The link to the next page of items
     */
    private String nextLink;

    /**
     * Creates an instance of PrivateCloudList class.
     */
    private PrivateCloudList() {
    }

    /**
     * Get the value property: The PrivateCloud items on this page.
     * 
     * @return the value value.
     */
    public List<PrivateCloudInner> value() {
        return this.value;
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
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property value in model PrivateCloudList"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PrivateCloudList.class);

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
     * Reads an instance of PrivateCloudList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrivateCloudList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PrivateCloudList.
     */
    public static PrivateCloudList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrivateCloudList deserializedPrivateCloudList = new PrivateCloudList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<PrivateCloudInner> value = reader.readArray(reader1 -> PrivateCloudInner.fromJson(reader1));
                    deserializedPrivateCloudList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedPrivateCloudList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrivateCloudList;
        });
    }
}
