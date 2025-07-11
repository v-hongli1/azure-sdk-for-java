// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The Salesforce Service Cloud object dataset.
 */
@Fluent
public class SalesforceServiceCloudObjectDataset extends Dataset {
    /*
     * Type of dataset.
     */
    @Generated
    private String type = "SalesforceServiceCloudObject";

    /*
     * The Salesforce Service Cloud object API name. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object objectApiName;

    /**
     * Creates an instance of SalesforceServiceCloudObjectDataset class.
     */
    @Generated
    public SalesforceServiceCloudObjectDataset() {
    }

    /**
     * Get the type property: Type of dataset.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the objectApiName property: The Salesforce Service Cloud object API name. Type: string (or Expression with
     * resultType string).
     * 
     * @return the objectApiName value.
     */
    @Generated
    public Object getObjectApiName() {
        return this.objectApiName;
    }

    /**
     * Set the objectApiName property: The Salesforce Service Cloud object API name. Type: string (or Expression with
     * resultType string).
     * 
     * @param objectApiName the objectApiName value to set.
     * @return the SalesforceServiceCloudObjectDataset object itself.
     */
    @Generated
    public SalesforceServiceCloudObjectDataset setObjectApiName(Object objectApiName) {
        this.objectApiName = objectApiName;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setStructure(Object structure) {
        super.setStructure(structure);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setSchema(Object schema) {
        super.setSchema(schema);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.setLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public SalesforceServiceCloudObjectDataset setFolder(DatasetFolder folder) {
        super.setFolder(folder);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("linkedServiceName", getLinkedServiceName());
        jsonWriter.writeStringField("description", getDescription());
        if (getStructure() != null) {
            jsonWriter.writeUntypedField("structure", getStructure());
        }
        if (getSchema() != null) {
            jsonWriter.writeUntypedField("schema", getSchema());
        }
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("folder", getFolder());
        jsonWriter.writeStringField("type", this.type);
        if (objectApiName != null) {
            jsonWriter.writeStartObject("typeProperties");
            if (this.objectApiName != null) {
                jsonWriter.writeUntypedField("objectApiName", this.objectApiName);
            }
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SalesforceServiceCloudObjectDataset from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SalesforceServiceCloudObjectDataset if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SalesforceServiceCloudObjectDataset.
     */
    @Generated
    public static SalesforceServiceCloudObjectDataset fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SalesforceServiceCloudObjectDataset deserializedSalesforceServiceCloudObjectDataset
                = new SalesforceServiceCloudObjectDataset();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("linkedServiceName".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset
                        .setLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset.setDescription(reader.getString());
                } else if ("structure".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset.setStructure(reader.readUntyped());
                } else if ("schema".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset.setSchema(reader.readUntyped());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedSalesforceServiceCloudObjectDataset.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedSalesforceServiceCloudObjectDataset.setAnnotations(annotations);
                } else if ("folder".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset.setFolder(DatasetFolder.fromJson(reader));
                } else if ("type".equals(fieldName)) {
                    deserializedSalesforceServiceCloudObjectDataset.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("objectApiName".equals(fieldName)) {
                            deserializedSalesforceServiceCloudObjectDataset.objectApiName = reader.readUntyped();
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedSalesforceServiceCloudObjectDataset.setAdditionalProperties(additionalProperties);

            return deserializedSalesforceServiceCloudObjectDataset;
        });
    }
}
