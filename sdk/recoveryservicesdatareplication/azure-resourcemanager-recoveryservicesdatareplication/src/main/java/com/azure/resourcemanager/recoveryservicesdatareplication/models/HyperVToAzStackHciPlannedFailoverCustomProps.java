// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * HyperV to AzStackHCI planned failover model custom properties.
 */
@Fluent
public final class HyperVToAzStackHciPlannedFailoverCustomProps extends PlannedFailoverModelCustomProperties {
    /*
     * Discriminator property for PlannedFailoverModelCustomProperties.
     */
    private String instanceType = "HyperVToAzStackHCI";

    /*
     * Gets or sets a value indicating whether VM needs to be shut down.
     */
    private boolean shutdownSourceVM;

    /**
     * Creates an instance of HyperVToAzStackHciPlannedFailoverCustomProps class.
     */
    public HyperVToAzStackHciPlannedFailoverCustomProps() {
    }

    /**
     * Get the instanceType property: Discriminator property for PlannedFailoverModelCustomProperties.
     * 
     * @return the instanceType value.
     */
    @Override
    public String instanceType() {
        return this.instanceType;
    }

    /**
     * Get the shutdownSourceVM property: Gets or sets a value indicating whether VM needs to be shut down.
     * 
     * @return the shutdownSourceVM value.
     */
    public boolean shutdownSourceVM() {
        return this.shutdownSourceVM;
    }

    /**
     * Set the shutdownSourceVM property: Gets or sets a value indicating whether VM needs to be shut down.
     * 
     * @param shutdownSourceVM the shutdownSourceVM value to set.
     * @return the HyperVToAzStackHciPlannedFailoverCustomProps object itself.
     */
    public HyperVToAzStackHciPlannedFailoverCustomProps withShutdownSourceVM(boolean shutdownSourceVM) {
        this.shutdownSourceVM = shutdownSourceVM;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBooleanField("shutdownSourceVM", this.shutdownSourceVM);
        jsonWriter.writeStringField("instanceType", this.instanceType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HyperVToAzStackHciPlannedFailoverCustomProps from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HyperVToAzStackHciPlannedFailoverCustomProps if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the HyperVToAzStackHciPlannedFailoverCustomProps.
     */
    public static HyperVToAzStackHciPlannedFailoverCustomProps fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HyperVToAzStackHciPlannedFailoverCustomProps deserializedHyperVToAzStackHciPlannedFailoverCustomProps
                = new HyperVToAzStackHciPlannedFailoverCustomProps();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("shutdownSourceVM".equals(fieldName)) {
                    deserializedHyperVToAzStackHciPlannedFailoverCustomProps.shutdownSourceVM = reader.getBoolean();
                } else if ("instanceType".equals(fieldName)) {
                    deserializedHyperVToAzStackHciPlannedFailoverCustomProps.instanceType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedHyperVToAzStackHciPlannedFailoverCustomProps;
        });
    }
}
