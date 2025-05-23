// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dependencymap.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The properties of Discovery Source resource.
 */
@Fluent
public class DiscoverySourceResourceProperties implements JsonSerializable<DiscoverySourceResourceProperties> {
    /*
     * Source type of Discovery Source resource.
     */
    private SourceType sourceType = SourceType.fromString("DiscoverySourceResourceProperties");

    /*
     * Provisioning state of Discovery Source resource.
     */
    private ProvisioningState provisioningState;

    /*
     * Source ArmId of Discovery Source resource
     */
    private String sourceId;

    /**
     * Creates an instance of DiscoverySourceResourceProperties class.
     */
    public DiscoverySourceResourceProperties() {
    }

    /**
     * Get the sourceType property: Source type of Discovery Source resource.
     * 
     * @return the sourceType value.
     */
    public SourceType sourceType() {
        return this.sourceType;
    }

    /**
     * Get the provisioningState property: Provisioning state of Discovery Source resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Set the provisioningState property: Provisioning state of Discovery Source resource.
     * 
     * @param provisioningState the provisioningState value to set.
     * @return the DiscoverySourceResourceProperties object itself.
     */
    DiscoverySourceResourceProperties withProvisioningState(ProvisioningState provisioningState) {
        this.provisioningState = provisioningState;
        return this;
    }

    /**
     * Get the sourceId property: Source ArmId of Discovery Source resource.
     * 
     * @return the sourceId value.
     */
    public String sourceId() {
        return this.sourceId;
    }

    /**
     * Set the sourceId property: Source ArmId of Discovery Source resource.
     * 
     * @param sourceId the sourceId value to set.
     * @return the DiscoverySourceResourceProperties object itself.
     */
    public DiscoverySourceResourceProperties withSourceId(String sourceId) {
        this.sourceId = sourceId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (sourceId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property sourceId in model DiscoverySourceResourceProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(DiscoverySourceResourceProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("sourceId", this.sourceId);
        jsonWriter.writeStringField("sourceType", this.sourceType == null ? null : this.sourceType.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DiscoverySourceResourceProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DiscoverySourceResourceProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the DiscoverySourceResourceProperties.
     */
    public static DiscoverySourceResourceProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("sourceType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("OffAzure".equals(discriminatorValue)) {
                    return OffAzureDiscoverySourceResourceProperties.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static DiscoverySourceResourceProperties fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DiscoverySourceResourceProperties deserializedDiscoverySourceResourceProperties
                = new DiscoverySourceResourceProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("sourceId".equals(fieldName)) {
                    deserializedDiscoverySourceResourceProperties.sourceId = reader.getString();
                } else if ("sourceType".equals(fieldName)) {
                    deserializedDiscoverySourceResourceProperties.sourceType
                        = SourceType.fromString(reader.getString());
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedDiscoverySourceResourceProperties.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDiscoverySourceResourceProperties;
        });
    }
}
