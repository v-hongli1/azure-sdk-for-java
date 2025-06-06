// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.indexes.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Specifies the Azure OpenAI resource used to vectorize a query string.
 */
@Fluent
public final class AzureOpenAIVectorizer extends VectorSearchVectorizer {
    /*
     * The name of the kind of vectorization method being configured for use with vector search.
     */
    @Generated
    private VectorSearchVectorizerKind kind = VectorSearchVectorizerKind.AZURE_OPEN_AI;

    /*
     * Contains the parameters specific to Azure OpenAI embedding vectorization.
     */
    @Generated
    private AzureOpenAIVectorizerParameters parameters;

    /**
     * Creates an instance of AzureOpenAIVectorizer class.
     * 
     * @param vectorizerName the vectorizerName value to set.
     */
    @Generated
    public AzureOpenAIVectorizer(String vectorizerName) {
        super(vectorizerName);
    }

    /**
     * Get the kind property: The name of the kind of vectorization method being configured for use with vector search.
     * 
     * @return the kind value.
     */
    @Generated
    @Override
    public VectorSearchVectorizerKind getKind() {
        return this.kind;
    }

    /**
     * Get the parameters property: Contains the parameters specific to Azure OpenAI embedding vectorization.
     * 
     * @return the parameters value.
     */
    @Generated
    public AzureOpenAIVectorizerParameters getParameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Contains the parameters specific to Azure OpenAI embedding vectorization.
     * 
     * @param parameters the parameters value to set.
     * @return the AzureOpenAIVectorizer object itself.
     */
    @Generated
    public AzureOpenAIVectorizer setParameters(AzureOpenAIVectorizerParameters parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", getVectorizerName());
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        jsonWriter.writeJsonField("azureOpenAIParameters", this.parameters);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureOpenAIVectorizer from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureOpenAIVectorizer if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AzureOpenAIVectorizer.
     */
    @Generated
    public static AzureOpenAIVectorizer fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            boolean vectorizerNameFound = false;
            String vectorizerName = null;
            VectorSearchVectorizerKind kind = VectorSearchVectorizerKind.AZURE_OPEN_AI;
            AzureOpenAIVectorizerParameters parameters = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    vectorizerName = reader.getString();
                    vectorizerNameFound = true;
                } else if ("kind".equals(fieldName)) {
                    kind = VectorSearchVectorizerKind.fromString(reader.getString());
                } else if ("azureOpenAIParameters".equals(fieldName)) {
                    parameters = AzureOpenAIVectorizerParameters.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            if (vectorizerNameFound) {
                AzureOpenAIVectorizer deserializedAzureOpenAIVectorizer = new AzureOpenAIVectorizer(vectorizerName);
                deserializedAzureOpenAIVectorizer.kind = kind;
                deserializedAzureOpenAIVectorizer.parameters = parameters;

                return deserializedAzureOpenAIVectorizer;
            }
            throw new IllegalStateException("Missing required property: name");
        });
    }
}
