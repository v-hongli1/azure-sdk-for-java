// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.fluent.models.DocumentationContractProperties;
import java.io.IOException;

/**
 * Documentation update contract details.
 */
@Fluent
public final class DocumentationUpdateContract implements JsonSerializable<DocumentationUpdateContract> {
    /*
     * Markdown Documentation details.
     */
    private DocumentationContractProperties innerProperties;

    /**
     * Creates an instance of DocumentationUpdateContract class.
     */
    public DocumentationUpdateContract() {
    }

    /**
     * Get the innerProperties property: Markdown Documentation details.
     * 
     * @return the innerProperties value.
     */
    private DocumentationContractProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the title property: documentation title.
     * 
     * @return the title value.
     */
    public String title() {
        return this.innerProperties() == null ? null : this.innerProperties().title();
    }

    /**
     * Set the title property: documentation title.
     * 
     * @param title the title value to set.
     * @return the DocumentationUpdateContract object itself.
     */
    public DocumentationUpdateContract withTitle(String title) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DocumentationContractProperties();
        }
        this.innerProperties().withTitle(title);
        return this;
    }

    /**
     * Get the content property: Markdown documentation content.
     * 
     * @return the content value.
     */
    public String content() {
        return this.innerProperties() == null ? null : this.innerProperties().content();
    }

    /**
     * Set the content property: Markdown documentation content.
     * 
     * @param content the content value to set.
     * @return the DocumentationUpdateContract object itself.
     */
    public DocumentationUpdateContract withContent(String content) {
        if (this.innerProperties() == null) {
            this.innerProperties = new DocumentationContractProperties();
        }
        this.innerProperties().withContent(content);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DocumentationUpdateContract from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DocumentationUpdateContract if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DocumentationUpdateContract.
     */
    public static DocumentationUpdateContract fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DocumentationUpdateContract deserializedDocumentationUpdateContract = new DocumentationUpdateContract();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("properties".equals(fieldName)) {
                    deserializedDocumentationUpdateContract.innerProperties
                        = DocumentationContractProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDocumentationUpdateContract;
        });
    }
}
