// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appservice.models.ProxyOnlyResource;
import com.azure.resourcemanager.appservice.models.ResourceMetricAvailability;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Metadata for the metrics.
 */
@Fluent
public final class ResourceMetricDefinitionInner extends ProxyOnlyResource {
    /*
     * ResourceMetricDefinition resource specific properties
     */
    private ResourceMetricDefinitionProperties innerProperties;

    /*
     * The type of the resource.
     */
    private String type;

    /*
     * The name of the resource.
     */
    private String name;

    /*
     * Fully qualified resource Id for the resource.
     */
    private String id;

    /**
     * Creates an instance of ResourceMetricDefinitionInner class.
     */
    public ResourceMetricDefinitionInner() {
    }

    /**
     * Get the innerProperties property: ResourceMetricDefinition resource specific properties.
     * 
     * @return the innerProperties value.
     */
    private ResourceMetricDefinitionProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the type property: The type of the resource.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the name property: The name of the resource.
     * 
     * @return the name value.
     */
    @Override
    public String name() {
        return this.name;
    }

    /**
     * Get the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    @Override
    public String id() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ResourceMetricDefinitionInner withKind(String kind) {
        super.withKind(kind);
        return this;
    }

    /**
     * Get the unit property: Unit of the metric.
     * 
     * @return the unit value.
     */
    public String unit() {
        return this.innerProperties() == null ? null : this.innerProperties().unit();
    }

    /**
     * Get the primaryAggregationType property: Primary aggregation type.
     * 
     * @return the primaryAggregationType value.
     */
    public String primaryAggregationType() {
        return this.innerProperties() == null ? null : this.innerProperties().primaryAggregationType();
    }

    /**
     * Get the metricAvailabilities property: List of time grains supported for the metric together with retention
     * period.
     * 
     * @return the metricAvailabilities value.
     */
    public List<ResourceMetricAvailability> metricAvailabilities() {
        return this.innerProperties() == null ? null : this.innerProperties().metricAvailabilities();
    }

    /**
     * Get the resourceUri property: Resource URI.
     * 
     * @return the resourceUri value.
     */
    public String resourceUri() {
        return this.innerProperties() == null ? null : this.innerProperties().resourceUri();
    }

    /**
     * Get the properties property: Resource metric definition properties.
     * 
     * @return the properties value.
     */
    public Map<String, String> properties() {
        return this.innerProperties() == null ? null : this.innerProperties().properties();
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
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
        jsonWriter.writeStringField("kind", kind());
        jsonWriter.writeJsonField("properties", this.innerProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceMetricDefinitionInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceMetricDefinitionInner if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ResourceMetricDefinitionInner.
     */
    public static ResourceMetricDefinitionInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceMetricDefinitionInner deserializedResourceMetricDefinitionInner
                = new ResourceMetricDefinitionInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedResourceMetricDefinitionInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedResourceMetricDefinitionInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedResourceMetricDefinitionInner.type = reader.getString();
                } else if ("kind".equals(fieldName)) {
                    deserializedResourceMetricDefinitionInner.withKind(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedResourceMetricDefinitionInner.innerProperties
                        = ResourceMetricDefinitionProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedResourceMetricDefinitionInner;
        });
    }
}
