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
import com.azure.resourcemanager.avs.fluent.models.ProvisionedNetworkInner;
import java.io.IOException;
import java.util.List;

/**
 * The response of a ProvisionedNetwork list operation.
 */
@Immutable
public final class ProvisionedNetworkListResult implements JsonSerializable<ProvisionedNetworkListResult> {
    /*
     * The ProvisionedNetwork items on this page
     */
    private List<ProvisionedNetworkInner> value;

    /*
     * The link to the next page of items
     */
    private String nextLink;

    /**
     * Creates an instance of ProvisionedNetworkListResult class.
     */
    private ProvisionedNetworkListResult() {
    }

    /**
     * Get the value property: The ProvisionedNetwork items on this page.
     * 
     * @return the value value.
     */
    public List<ProvisionedNetworkInner> value() {
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
                .log(new IllegalArgumentException(
                    "Missing required property value in model ProvisionedNetworkListResult"));
        } else {
            value().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ProvisionedNetworkListResult.class);

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
     * Reads an instance of ProvisionedNetworkListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProvisionedNetworkListResult if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ProvisionedNetworkListResult.
     */
    public static ProvisionedNetworkListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProvisionedNetworkListResult deserializedProvisionedNetworkListResult = new ProvisionedNetworkListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<ProvisionedNetworkInner> value
                        = reader.readArray(reader1 -> ProvisionedNetworkInner.fromJson(reader1));
                    deserializedProvisionedNetworkListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedProvisionedNetworkListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProvisionedNetworkListResult;
        });
    }
}
