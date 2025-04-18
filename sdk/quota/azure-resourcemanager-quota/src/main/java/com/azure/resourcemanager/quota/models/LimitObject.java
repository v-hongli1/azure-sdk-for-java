// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.quota.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The resource quota limit value.
 */
@Fluent
public final class LimitObject extends LimitJsonObject {
    /*
     * The limit object type.
     */
    private LimitType limitObjectType = LimitType.LIMIT_VALUE;

    /*
     * The quota/limit value
     */
    private int value;

    /*
     * The quota or usages limit types.
     */
    private QuotaLimitTypes limitType;

    /**
     * Creates an instance of LimitObject class.
     */
    public LimitObject() {
    }

    /**
     * Get the limitObjectType property: The limit object type.
     * 
     * @return the limitObjectType value.
     */
    @Override
    public LimitType limitObjectType() {
        return this.limitObjectType;
    }

    /**
     * Get the value property: The quota/limit value.
     * 
     * @return the value value.
     */
    public int value() {
        return this.value;
    }

    /**
     * Set the value property: The quota/limit value.
     * 
     * @param value the value value to set.
     * @return the LimitObject object itself.
     */
    public LimitObject withValue(int value) {
        this.value = value;
        return this;
    }

    /**
     * Get the limitType property: The quota or usages limit types.
     * 
     * @return the limitType value.
     */
    public QuotaLimitTypes limitType() {
        return this.limitType;
    }

    /**
     * Set the limitType property: The quota or usages limit types.
     * 
     * @param limitType the limitType value to set.
     * @return the LimitObject object itself.
     */
    public LimitObject withLimitType(QuotaLimitTypes limitType) {
        this.limitType = limitType;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("value", this.value);
        jsonWriter.writeStringField("limitObjectType",
            this.limitObjectType == null ? null : this.limitObjectType.toString());
        jsonWriter.writeStringField("limitType", this.limitType == null ? null : this.limitType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of LimitObject from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of LimitObject if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the LimitObject.
     */
    public static LimitObject fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            LimitObject deserializedLimitObject = new LimitObject();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    deserializedLimitObject.value = reader.getInt();
                } else if ("limitObjectType".equals(fieldName)) {
                    deserializedLimitObject.limitObjectType = LimitType.fromString(reader.getString());
                } else if ("limitType".equals(fieldName)) {
                    deserializedLimitObject.limitType = QuotaLimitTypes.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedLimitObject;
        });
    }
}
