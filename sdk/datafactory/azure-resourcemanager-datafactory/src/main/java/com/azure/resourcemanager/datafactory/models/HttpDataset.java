// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.HttpDatasetTypeProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * A file in an HTTP web server.
 */
@Fluent
public final class HttpDataset extends Dataset {
    /*
     * Type of dataset.
     */
    private String type = "HttpFile";

    /*
     * Properties specific to this dataset type.
     */
    private HttpDatasetTypeProperties innerTypeProperties;

    /**
     * Creates an instance of HttpDataset class.
     */
    public HttpDataset() {
    }

    /**
     * Get the type property: Type of dataset.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Properties specific to this dataset type.
     * 
     * @return the innerTypeProperties value.
     */
    HttpDatasetTypeProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withStructure(Object structure) {
        super.withStructure(structure);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withSchema(Object schema) {
        super.withSchema(schema);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.withLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public HttpDataset withFolder(DatasetFolder folder) {
        super.withFolder(folder);
        return this;
    }

    /**
     * Get the relativeUrl property: The relative URL based on the URL in the HttpLinkedService refers to an HTTP file
     * Type: string (or Expression with resultType string).
     * 
     * @return the relativeUrl value.
     */
    public Object relativeUrl() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().relativeUrl();
    }

    /**
     * Set the relativeUrl property: The relative URL based on the URL in the HttpLinkedService refers to an HTTP file
     * Type: string (or Expression with resultType string).
     * 
     * @param relativeUrl the relativeUrl value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withRelativeUrl(Object relativeUrl) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withRelativeUrl(relativeUrl);
        return this;
    }

    /**
     * Get the requestMethod property: The HTTP method for the HTTP request. Type: string (or Expression with resultType
     * string).
     * 
     * @return the requestMethod value.
     */
    public Object requestMethod() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().requestMethod();
    }

    /**
     * Set the requestMethod property: The HTTP method for the HTTP request. Type: string (or Expression with resultType
     * string).
     * 
     * @param requestMethod the requestMethod value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withRequestMethod(Object requestMethod) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withRequestMethod(requestMethod);
        return this;
    }

    /**
     * Get the requestBody property: The body for the HTTP request. Type: string (or Expression with resultType string).
     * 
     * @return the requestBody value.
     */
    public Object requestBody() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().requestBody();
    }

    /**
     * Set the requestBody property: The body for the HTTP request. Type: string (or Expression with resultType string).
     * 
     * @param requestBody the requestBody value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withRequestBody(Object requestBody) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withRequestBody(requestBody);
        return this;
    }

    /**
     * Get the additionalHeaders property: The headers for the HTTP Request. e.g.
     * request-header-name-1:request-header-value-1
     * ...
     * request-header-name-n:request-header-value-n Type: string (or Expression with resultType string).
     * 
     * @return the additionalHeaders value.
     */
    public Object additionalHeaders() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().additionalHeaders();
    }

    /**
     * Set the additionalHeaders property: The headers for the HTTP Request. e.g.
     * request-header-name-1:request-header-value-1
     * ...
     * request-header-name-n:request-header-value-n Type: string (or Expression with resultType string).
     * 
     * @param additionalHeaders the additionalHeaders value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withAdditionalHeaders(Object additionalHeaders) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withAdditionalHeaders(additionalHeaders);
        return this;
    }

    /**
     * Get the format property: The format of files.
     * 
     * @return the format value.
     */
    public DatasetStorageFormat format() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().format();
    }

    /**
     * Set the format property: The format of files.
     * 
     * @param format the format value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withFormat(DatasetStorageFormat format) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withFormat(format);
        return this;
    }

    /**
     * Get the compression property: The data compression method used on files.
     * 
     * @return the compression value.
     */
    public DatasetCompression compression() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().compression();
    }

    /**
     * Set the compression property: The data compression method used on files.
     * 
     * @param compression the compression value to set.
     * @return the HttpDataset object itself.
     */
    public HttpDataset withCompression(DatasetCompression compression) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new HttpDatasetTypeProperties();
        }
        this.innerTypeProperties().withCompression(compression);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() != null) {
            innerTypeProperties().validate();
        }
        if (linkedServiceName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property linkedServiceName in model HttpDataset"));
        } else {
            linkedServiceName().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (folder() != null) {
            folder().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(HttpDataset.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("linkedServiceName", linkedServiceName());
        jsonWriter.writeStringField("description", description());
        if (structure() != null) {
            jsonWriter.writeUntypedField("structure", structure());
        }
        if (schema() != null) {
            jsonWriter.writeUntypedField("schema", schema());
        }
        jsonWriter.writeMapField("parameters", parameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", annotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("folder", folder());
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HttpDataset from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HttpDataset if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the HttpDataset.
     */
    public static HttpDataset fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HttpDataset deserializedHttpDataset = new HttpDataset();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("linkedServiceName".equals(fieldName)) {
                    deserializedHttpDataset.withLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedHttpDataset.withDescription(reader.getString());
                } else if ("structure".equals(fieldName)) {
                    deserializedHttpDataset.withStructure(reader.readUntyped());
                } else if ("schema".equals(fieldName)) {
                    deserializedHttpDataset.withSchema(reader.readUntyped());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedHttpDataset.withParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedHttpDataset.withAnnotations(annotations);
                } else if ("folder".equals(fieldName)) {
                    deserializedHttpDataset.withFolder(DatasetFolder.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedHttpDataset.type = reader.getString();
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedHttpDataset.innerTypeProperties = HttpDatasetTypeProperties.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedHttpDataset.withAdditionalProperties(additionalProperties);

            return deserializedHttpDataset;
        });
    }
}
