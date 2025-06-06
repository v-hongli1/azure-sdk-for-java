// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.monitor.query.implementation.metricsnamespaces.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Metric namespace class specifies the metadata for a metric namespace.
 */
@Fluent
public final class MetricNamespace implements JsonSerializable<MetricNamespace> {
    /*
     * The ID of the metric namespace.
     */
    @Generated
    private String id;

    /*
     * The type of the namespace.
     */
    @Generated
    private String type;

    /*
     * The escaped name of the namespace.
     */
    @Generated
    private String name;

    /*
     * Kind of namespace
     */
    @Generated
    private NamespaceClassification classification;

    /*
     * Properties which include the fully qualified namespace name.
     */
    @Generated
    private MetricNamespaceName properties;

    /**
     * Creates an instance of MetricNamespace class.
     */
    @Generated
    public MetricNamespace() {
    }

    /**
     * Get the id property: The ID of the metric namespace.
     * 
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: The ID of the metric namespace.
     * 
     * @param id the id value to set.
     * @return the MetricNamespace object itself.
     */
    @Generated
    public MetricNamespace setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the type property: The type of the namespace.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * Set the type property: The type of the namespace.
     * 
     * @param type the type value to set.
     * @return the MetricNamespace object itself.
     */
    @Generated
    public MetricNamespace setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the name property: The escaped name of the namespace.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: The escaped name of the namespace.
     * 
     * @param name the name value to set.
     * @return the MetricNamespace object itself.
     */
    @Generated
    public MetricNamespace setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the classification property: Kind of namespace.
     * 
     * @return the classification value.
     */
    @Generated
    public NamespaceClassification getClassification() {
        return this.classification;
    }

    /**
     * Set the classification property: Kind of namespace.
     * 
     * @param classification the classification value to set.
     * @return the MetricNamespace object itself.
     */
    @Generated
    public MetricNamespace setClassification(NamespaceClassification classification) {
        this.classification = classification;
        return this;
    }

    /**
     * Get the properties property: Properties which include the fully qualified namespace name.
     * 
     * @return the properties value.
     */
    @Generated
    public MetricNamespaceName getProperties() {
        return this.properties;
    }

    /**
     * Set the properties property: Properties which include the fully qualified namespace name.
     * 
     * @param properties the properties value to set.
     * @return the MetricNamespace object itself.
     */
    @Generated
    public MetricNamespace setProperties(MetricNamespaceName properties) {
        this.properties = properties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("classification",
            this.classification == null ? null : this.classification.toString());
        jsonWriter.writeJsonField("properties", this.properties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MetricNamespace from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MetricNamespace if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the MetricNamespace.
     */
    @Generated
    public static MetricNamespace fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MetricNamespace deserializedMetricNamespace = new MetricNamespace();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMetricNamespace.id = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedMetricNamespace.type = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedMetricNamespace.name = reader.getString();
                } else if ("classification".equals(fieldName)) {
                    deserializedMetricNamespace.classification = NamespaceClassification.fromString(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedMetricNamespace.properties = MetricNamespaceName.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMetricNamespace;
        });
    }
}
