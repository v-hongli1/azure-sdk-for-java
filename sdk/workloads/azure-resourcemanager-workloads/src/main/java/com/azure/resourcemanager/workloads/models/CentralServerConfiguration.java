// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.workloads.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Gets or sets the central server configuration.
 */
@Fluent
public final class CentralServerConfiguration implements JsonSerializable<CentralServerConfiguration> {
    /*
     * The subnet id.
     */
    private String subnetId;

    /*
     * Gets or sets the virtual machine configuration.
     */
    private VirtualMachineConfiguration virtualMachineConfiguration;

    /*
     * The number of central server VMs.
     */
    private long instanceCount;

    /**
     * Creates an instance of CentralServerConfiguration class.
     */
    public CentralServerConfiguration() {
    }

    /**
     * Get the subnetId property: The subnet id.
     * 
     * @return the subnetId value.
     */
    public String subnetId() {
        return this.subnetId;
    }

    /**
     * Set the subnetId property: The subnet id.
     * 
     * @param subnetId the subnetId value to set.
     * @return the CentralServerConfiguration object itself.
     */
    public CentralServerConfiguration withSubnetId(String subnetId) {
        this.subnetId = subnetId;
        return this;
    }

    /**
     * Get the virtualMachineConfiguration property: Gets or sets the virtual machine configuration.
     * 
     * @return the virtualMachineConfiguration value.
     */
    public VirtualMachineConfiguration virtualMachineConfiguration() {
        return this.virtualMachineConfiguration;
    }

    /**
     * Set the virtualMachineConfiguration property: Gets or sets the virtual machine configuration.
     * 
     * @param virtualMachineConfiguration the virtualMachineConfiguration value to set.
     * @return the CentralServerConfiguration object itself.
     */
    public CentralServerConfiguration
        withVirtualMachineConfiguration(VirtualMachineConfiguration virtualMachineConfiguration) {
        this.virtualMachineConfiguration = virtualMachineConfiguration;
        return this;
    }

    /**
     * Get the instanceCount property: The number of central server VMs.
     * 
     * @return the instanceCount value.
     */
    public long instanceCount() {
        return this.instanceCount;
    }

    /**
     * Set the instanceCount property: The number of central server VMs.
     * 
     * @param instanceCount the instanceCount value to set.
     * @return the CentralServerConfiguration object itself.
     */
    public CentralServerConfiguration withInstanceCount(long instanceCount) {
        this.instanceCount = instanceCount;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (subnetId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property subnetId in model CentralServerConfiguration"));
        }
        if (virtualMachineConfiguration() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property virtualMachineConfiguration in model CentralServerConfiguration"));
        } else {
            virtualMachineConfiguration().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(CentralServerConfiguration.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("subnetId", this.subnetId);
        jsonWriter.writeJsonField("virtualMachineConfiguration", this.virtualMachineConfiguration);
        jsonWriter.writeLongField("instanceCount", this.instanceCount);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CentralServerConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CentralServerConfiguration if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CentralServerConfiguration.
     */
    public static CentralServerConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CentralServerConfiguration deserializedCentralServerConfiguration = new CentralServerConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("subnetId".equals(fieldName)) {
                    deserializedCentralServerConfiguration.subnetId = reader.getString();
                } else if ("virtualMachineConfiguration".equals(fieldName)) {
                    deserializedCentralServerConfiguration.virtualMachineConfiguration
                        = VirtualMachineConfiguration.fromJson(reader);
                } else if ("instanceCount".equals(fieldName)) {
                    deserializedCentralServerConfiguration.instanceCount = reader.getLong();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedCentralServerConfiguration;
        });
    }
}
