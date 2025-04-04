// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appservice.models.ComputeModeOptions;
import com.azure.resourcemanager.appservice.models.ProxyOnlyResource;
import com.azure.resourcemanager.appservice.models.SkuDescription;
import java.io.IOException;
import java.util.List;

/**
 * Worker pool of an App Service Environment ARM resource.
 */
@Fluent
public final class WorkerPoolResourceInner extends ProxyOnlyResource {
    /*
     * Core resource properties
     */
    private WorkerPool innerProperties;

    /*
     * Description of a SKU for a scalable resource.
     */
    private SkuDescription sku;

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
     * Creates an instance of WorkerPoolResourceInner class.
     */
    public WorkerPoolResourceInner() {
    }

    /**
     * Get the innerProperties property: Core resource properties.
     * 
     * @return the innerProperties value.
     */
    private WorkerPool innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the sku property: Description of a SKU for a scalable resource.
     * 
     * @return the sku value.
     */
    public SkuDescription sku() {
        return this.sku;
    }

    /**
     * Set the sku property: Description of a SKU for a scalable resource.
     * 
     * @param sku the sku value to set.
     * @return the WorkerPoolResourceInner object itself.
     */
    public WorkerPoolResourceInner withSku(SkuDescription sku) {
        this.sku = sku;
        return this;
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
    public WorkerPoolResourceInner withKind(String kind) {
        super.withKind(kind);
        return this;
    }

    /**
     * Get the workerSizeId property: Worker size ID for referencing this worker pool.
     * 
     * @return the workerSizeId value.
     */
    public Integer workerSizeId() {
        return this.innerProperties() == null ? null : this.innerProperties().workerSizeId();
    }

    /**
     * Set the workerSizeId property: Worker size ID for referencing this worker pool.
     * 
     * @param workerSizeId the workerSizeId value to set.
     * @return the WorkerPoolResourceInner object itself.
     */
    public WorkerPoolResourceInner withWorkerSizeId(Integer workerSizeId) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkerPool();
        }
        this.innerProperties().withWorkerSizeId(workerSizeId);
        return this;
    }

    /**
     * Get the computeMode property: Shared or dedicated app hosting.
     * 
     * @return the computeMode value.
     */
    public ComputeModeOptions computeMode() {
        return this.innerProperties() == null ? null : this.innerProperties().computeMode();
    }

    /**
     * Set the computeMode property: Shared or dedicated app hosting.
     * 
     * @param computeMode the computeMode value to set.
     * @return the WorkerPoolResourceInner object itself.
     */
    public WorkerPoolResourceInner withComputeMode(ComputeModeOptions computeMode) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkerPool();
        }
        this.innerProperties().withComputeMode(computeMode);
        return this;
    }

    /**
     * Get the workerSize property: VM size of the worker pool instances.
     * 
     * @return the workerSize value.
     */
    public String workerSize() {
        return this.innerProperties() == null ? null : this.innerProperties().workerSize();
    }

    /**
     * Set the workerSize property: VM size of the worker pool instances.
     * 
     * @param workerSize the workerSize value to set.
     * @return the WorkerPoolResourceInner object itself.
     */
    public WorkerPoolResourceInner withWorkerSize(String workerSize) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkerPool();
        }
        this.innerProperties().withWorkerSize(workerSize);
        return this;
    }

    /**
     * Get the workerCount property: Number of instances in the worker pool.
     * 
     * @return the workerCount value.
     */
    public Integer workerCount() {
        return this.innerProperties() == null ? null : this.innerProperties().workerCount();
    }

    /**
     * Set the workerCount property: Number of instances in the worker pool.
     * 
     * @param workerCount the workerCount value to set.
     * @return the WorkerPoolResourceInner object itself.
     */
    public WorkerPoolResourceInner withWorkerCount(Integer workerCount) {
        if (this.innerProperties() == null) {
            this.innerProperties = new WorkerPool();
        }
        this.innerProperties().withWorkerCount(workerCount);
        return this;
    }

    /**
     * Get the instanceNames property: Names of all instances in the worker pool (read only).
     * 
     * @return the instanceNames value.
     */
    public List<String> instanceNames() {
        return this.innerProperties() == null ? null : this.innerProperties().instanceNames();
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
        if (sku() != null) {
            sku().validate();
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
        jsonWriter.writeJsonField("sku", this.sku);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WorkerPoolResourceInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WorkerPoolResourceInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the WorkerPoolResourceInner.
     */
    public static WorkerPoolResourceInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WorkerPoolResourceInner deserializedWorkerPoolResourceInner = new WorkerPoolResourceInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.id = reader.getString();
                } else if ("name".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.type = reader.getString();
                } else if ("kind".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.withKind(reader.getString());
                } else if ("properties".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.innerProperties = WorkerPool.fromJson(reader);
                } else if ("sku".equals(fieldName)) {
                    deserializedWorkerPoolResourceInner.sku = SkuDescription.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedWorkerPoolResourceInner;
        });
    }
}
