// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.search.documents.indexes.models.LexicalTokenizer;
import java.io.IOException;

/**
 * Emits the entire input as a single token. This tokenizer is implemented using Apache Lucene.
 */
@Fluent
public final class KeywordTokenizerV1 extends LexicalTokenizer {
    /*
     * A URI fragment specifying the type of tokenizer.
     */
    @Generated
    private String odataType = "#Microsoft.Azure.Search.KeywordTokenizer";

    /*
     * The read buffer size in bytes. Default is 256.
     */
    @Generated
    private Integer bufferSize;

    /**
     * Creates an instance of KeywordTokenizerV1 class.
     * 
     * @param name the name value to set.
     */
    @Generated
    public KeywordTokenizerV1(String name) {
        super(name);
    }

    /**
     * Get the odataType property: A URI fragment specifying the type of tokenizer.
     * 
     * @return the odataType value.
     */
    @Generated
    @Override
    public String getOdataType() {
        return this.odataType;
    }

    /**
     * Get the bufferSize property: The read buffer size in bytes. Default is 256.
     * 
     * @return the bufferSize value.
     */
    @Generated
    public Integer getBufferSize() {
        return this.bufferSize;
    }

    /**
     * Set the bufferSize property: The read buffer size in bytes. Default is 256.
     * 
     * @param bufferSize the bufferSize value to set.
     * @return the KeywordTokenizerV1 object itself.
     */
    @Generated
    public KeywordTokenizerV1 setBufferSize(Integer bufferSize) {
        this.bufferSize = bufferSize;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", getName());
        jsonWriter.writeStringField("@odata.type", this.odataType);
        jsonWriter.writeNumberField("bufferSize", this.bufferSize);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of KeywordTokenizerV1 from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeywordTokenizerV1 if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the KeywordTokenizerV1.
     */
    @Generated
    public static KeywordTokenizerV1 fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            boolean nameFound = false;
            String name = null;
            String odataType = "#Microsoft.Azure.Search.KeywordTokenizer";
            Integer bufferSize = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    name = reader.getString();
                    nameFound = true;
                } else if ("@odata.type".equals(fieldName)) {
                    odataType = reader.getString();
                } else if ("bufferSize".equals(fieldName)) {
                    bufferSize = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }
            if (nameFound) {
                KeywordTokenizerV1 deserializedKeywordTokenizerV1 = new KeywordTokenizerV1(name);
                deserializedKeywordTokenizerV1.odataType = odataType;
                deserializedKeywordTokenizerV1.bufferSize = bufferSize;

                return deserializedKeywordTokenizerV1;
            }
            throw new IllegalStateException("Missing required property: name");
        });
    }
}
