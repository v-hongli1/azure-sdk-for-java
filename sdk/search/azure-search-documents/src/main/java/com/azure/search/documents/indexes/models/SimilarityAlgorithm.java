// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Base type for similarity algorithms. Similarity algorithms are used to calculate scores that tie queries to
 * documents. The higher the score, the more relevant the document is to that specific query. Those scores are used to
 * rank the search results.
 */
@Immutable
public class SimilarityAlgorithm implements JsonSerializable<SimilarityAlgorithm> {
    /*
     * The @odata.type property.
     */
    @Generated
    private String odataType = "SimilarityAlgorithm";

    /**
     * Creates an instance of SimilarityAlgorithm class.
     */
    @Generated
    public SimilarityAlgorithm() {
    }

    /**
     * Get the odataType property: The &#064;odata.type property.
     * 
     * @return the odataType value.
     */
    @Generated
    public String getOdataType() {
        return this.odataType;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("@odata.type", this.odataType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SimilarityAlgorithm from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SimilarityAlgorithm if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SimilarityAlgorithm.
     */
    @Generated
    public static SimilarityAlgorithm fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("@odata.type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("#Microsoft.Azure.Search.ClassicSimilarity".equals(discriminatorValue)) {
                    return ClassicSimilarityAlgorithm.fromJson(readerToUse.reset());
                } else if ("#Microsoft.Azure.Search.BM25Similarity".equals(discriminatorValue)) {
                    return BM25SimilarityAlgorithm.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    @Generated
    static SimilarityAlgorithm fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SimilarityAlgorithm deserializedSimilarityAlgorithm = new SimilarityAlgorithm();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("@odata.type".equals(fieldName)) {
                    deserializedSimilarityAlgorithm.odataType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSimilarityAlgorithm;
        });
    }
}
