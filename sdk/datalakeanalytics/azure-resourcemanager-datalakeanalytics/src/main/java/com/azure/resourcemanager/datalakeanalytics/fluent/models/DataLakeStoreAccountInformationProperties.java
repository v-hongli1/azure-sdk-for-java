// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datalakeanalytics.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The Data Lake Store account properties.
 */
@Immutable
public final class DataLakeStoreAccountInformationProperties
    implements JsonSerializable<DataLakeStoreAccountInformationProperties> {
    /*
     * The optional suffix for the Data Lake Store account.
     */
    private String suffix;

    /**
     * Creates an instance of DataLakeStoreAccountInformationProperties class.
     */
    public DataLakeStoreAccountInformationProperties() {
    }

    /**
     * Get the suffix property: The optional suffix for the Data Lake Store account.
     * 
     * @return the suffix value.
     */
    public String suffix() {
        return this.suffix;
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
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DataLakeStoreAccountInformationProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DataLakeStoreAccountInformationProperties if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DataLakeStoreAccountInformationProperties.
     */
    public static DataLakeStoreAccountInformationProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DataLakeStoreAccountInformationProperties deserializedDataLakeStoreAccountInformationProperties
                = new DataLakeStoreAccountInformationProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("suffix".equals(fieldName)) {
                    deserializedDataLakeStoreAccountInformationProperties.suffix = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDataLakeStoreAccountInformationProperties;
        });
    }
}
