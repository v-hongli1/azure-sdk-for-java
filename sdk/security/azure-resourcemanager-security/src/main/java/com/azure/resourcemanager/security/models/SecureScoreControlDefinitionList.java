// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.security.fluent.models.SecureScoreControlDefinitionItemInner;
import java.io.IOException;
import java.util.List;

/**
 * List of security controls definition.
 */
@Immutable
public final class SecureScoreControlDefinitionList implements JsonSerializable<SecureScoreControlDefinitionList> {
    /*
     * Collection of security controls definition in this page
     */
    private List<SecureScoreControlDefinitionItemInner> value;

    /*
     * The URI to fetch the next page.
     */
    private String nextLink;

    /**
     * Creates an instance of SecureScoreControlDefinitionList class.
     */
    public SecureScoreControlDefinitionList() {
    }

    /**
     * Get the value property: Collection of security controls definition in this page.
     * 
     * @return the value value.
     */
    public List<SecureScoreControlDefinitionItemInner> value() {
        return this.value;
    }

    /**
     * Get the nextLink property: The URI to fetch the next page.
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecureScoreControlDefinitionList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecureScoreControlDefinitionList if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SecureScoreControlDefinitionList.
     */
    public static SecureScoreControlDefinitionList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecureScoreControlDefinitionList deserializedSecureScoreControlDefinitionList
                = new SecureScoreControlDefinitionList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<SecureScoreControlDefinitionItemInner> value
                        = reader.readArray(reader1 -> SecureScoreControlDefinitionItemInner.fromJson(reader1));
                    deserializedSecureScoreControlDefinitionList.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedSecureScoreControlDefinitionList.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecureScoreControlDefinitionList;
        });
    }
}
