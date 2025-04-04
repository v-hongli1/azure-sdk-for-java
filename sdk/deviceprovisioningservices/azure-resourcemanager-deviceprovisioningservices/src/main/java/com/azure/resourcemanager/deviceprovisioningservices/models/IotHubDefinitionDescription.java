// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceprovisioningservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Description of the IoT hub.
 */
@Fluent
public final class IotHubDefinitionDescription implements JsonSerializable<IotHubDefinitionDescription> {
    /*
     * flag for applying allocationPolicy or not for a given iot hub.
     */
    private Boolean applyAllocationPolicy;

    /*
     * weight to apply for a given iot h.
     */
    private Integer allocationWeight;

    /*
     * Host name of the IoT hub.
     */
    private String name;

    /*
     * Connection string of the IoT hub.
     */
    private String connectionString;

    /*
     * ARM region of the IoT hub.
     */
    private String location;

    /**
     * Creates an instance of IotHubDefinitionDescription class.
     */
    public IotHubDefinitionDescription() {
    }

    /**
     * Get the applyAllocationPolicy property: flag for applying allocationPolicy or not for a given iot hub.
     * 
     * @return the applyAllocationPolicy value.
     */
    public Boolean applyAllocationPolicy() {
        return this.applyAllocationPolicy;
    }

    /**
     * Set the applyAllocationPolicy property: flag for applying allocationPolicy or not for a given iot hub.
     * 
     * @param applyAllocationPolicy the applyAllocationPolicy value to set.
     * @return the IotHubDefinitionDescription object itself.
     */
    public IotHubDefinitionDescription withApplyAllocationPolicy(Boolean applyAllocationPolicy) {
        this.applyAllocationPolicy = applyAllocationPolicy;
        return this;
    }

    /**
     * Get the allocationWeight property: weight to apply for a given iot h.
     * 
     * @return the allocationWeight value.
     */
    public Integer allocationWeight() {
        return this.allocationWeight;
    }

    /**
     * Set the allocationWeight property: weight to apply for a given iot h.
     * 
     * @param allocationWeight the allocationWeight value to set.
     * @return the IotHubDefinitionDescription object itself.
     */
    public IotHubDefinitionDescription withAllocationWeight(Integer allocationWeight) {
        this.allocationWeight = allocationWeight;
        return this;
    }

    /**
     * Get the name property: Host name of the IoT hub.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Get the connectionString property: Connection string of the IoT hub.
     * 
     * @return the connectionString value.
     */
    public String connectionString() {
        return this.connectionString;
    }

    /**
     * Set the connectionString property: Connection string of the IoT hub.
     * 
     * @param connectionString the connectionString value to set.
     * @return the IotHubDefinitionDescription object itself.
     */
    public IotHubDefinitionDescription withConnectionString(String connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get the location property: ARM region of the IoT hub.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: ARM region of the IoT hub.
     * 
     * @param location the location value to set.
     * @return the IotHubDefinitionDescription object itself.
     */
    public IotHubDefinitionDescription withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (connectionString() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property connectionString in model IotHubDefinitionDescription"));
        }
        if (location() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property location in model IotHubDefinitionDescription"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(IotHubDefinitionDescription.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("connectionString", this.connectionString);
        jsonWriter.writeStringField("location", this.location);
        jsonWriter.writeBooleanField("applyAllocationPolicy", this.applyAllocationPolicy);
        jsonWriter.writeNumberField("allocationWeight", this.allocationWeight);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IotHubDefinitionDescription from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IotHubDefinitionDescription if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the IotHubDefinitionDescription.
     */
    public static IotHubDefinitionDescription fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IotHubDefinitionDescription deserializedIotHubDefinitionDescription = new IotHubDefinitionDescription();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("connectionString".equals(fieldName)) {
                    deserializedIotHubDefinitionDescription.connectionString = reader.getString();
                } else if ("location".equals(fieldName)) {
                    deserializedIotHubDefinitionDescription.location = reader.getString();
                } else if ("applyAllocationPolicy".equals(fieldName)) {
                    deserializedIotHubDefinitionDescription.applyAllocationPolicy
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("allocationWeight".equals(fieldName)) {
                    deserializedIotHubDefinitionDescription.allocationWeight = reader.getNullable(JsonReader::getInt);
                } else if ("name".equals(fieldName)) {
                    deserializedIotHubDefinitionDescription.name = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIotHubDefinitionDescription;
        });
    }
}
