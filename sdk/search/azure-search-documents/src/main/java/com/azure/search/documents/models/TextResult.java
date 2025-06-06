// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The BM25 or Classic score for the text portion of the query.
 */
@Immutable
public final class TextResult implements JsonSerializable<TextResult> {
    /*
     * The BM25 or Classic score for the text portion of the query.
     */
    @Generated
    private Double searchScore;

    /**
     * Creates an instance of TextResult class.
     */
    @Generated
    public TextResult() {
    }

    /**
     * Get the searchScore property: The BM25 or Classic score for the text portion of the query.
     * 
     * @return the searchScore value.
     */
    @Generated
    public Double getSearchScore() {
        return this.searchScore;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of TextResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of TextResult if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the TextResult.
     */
    @Generated
    public static TextResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            TextResult deserializedTextResult = new TextResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("searchScore".equals(fieldName)) {
                    deserializedTextResult.searchScore = reader.getNullable(JsonReader::getDouble);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedTextResult;
        });
    }
}
