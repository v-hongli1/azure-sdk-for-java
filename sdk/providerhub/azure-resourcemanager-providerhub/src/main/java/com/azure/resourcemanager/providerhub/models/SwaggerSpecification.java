// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The SwaggerSpecification model.
 */
@Fluent
public final class SwaggerSpecification implements JsonSerializable<SwaggerSpecification> {
    /*
     * The api versions.
     */
    private List<String> apiVersions;

    /*
     * The swagger spec folder uri.
     */
    private String swaggerSpecFolderUri;

    /**
     * Creates an instance of SwaggerSpecification class.
     */
    public SwaggerSpecification() {
    }

    /**
     * Get the apiVersions property: The api versions.
     * 
     * @return the apiVersions value.
     */
    public List<String> apiVersions() {
        return this.apiVersions;
    }

    /**
     * Set the apiVersions property: The api versions.
     * 
     * @param apiVersions the apiVersions value to set.
     * @return the SwaggerSpecification object itself.
     */
    public SwaggerSpecification withApiVersions(List<String> apiVersions) {
        this.apiVersions = apiVersions;
        return this;
    }

    /**
     * Get the swaggerSpecFolderUri property: The swagger spec folder uri.
     * 
     * @return the swaggerSpecFolderUri value.
     */
    public String swaggerSpecFolderUri() {
        return this.swaggerSpecFolderUri;
    }

    /**
     * Set the swaggerSpecFolderUri property: The swagger spec folder uri.
     * 
     * @param swaggerSpecFolderUri the swaggerSpecFolderUri value to set.
     * @return the SwaggerSpecification object itself.
     */
    public SwaggerSpecification withSwaggerSpecFolderUri(String swaggerSpecFolderUri) {
        this.swaggerSpecFolderUri = swaggerSpecFolderUri;
        return this;
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
        jsonWriter.writeArrayField("apiVersions", this.apiVersions, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("swaggerSpecFolderUri", this.swaggerSpecFolderUri);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SwaggerSpecification from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SwaggerSpecification if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SwaggerSpecification.
     */
    public static SwaggerSpecification fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SwaggerSpecification deserializedSwaggerSpecification = new SwaggerSpecification();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("apiVersions".equals(fieldName)) {
                    List<String> apiVersions = reader.readArray(reader1 -> reader1.getString());
                    deserializedSwaggerSpecification.apiVersions = apiVersions;
                } else if ("swaggerSpecFolderUri".equals(fieldName)) {
                    deserializedSwaggerSpecification.swaggerSpecFolderUri = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSwaggerSpecification;
        });
    }
}
