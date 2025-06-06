// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Properties of a Pure Storage Policy Based Management policy.
 */
@Fluent
public final class PureStoragePolicyProperties implements JsonSerializable<PureStoragePolicyProperties> {
    /*
     * Definition of a Pure Storage Policy Based Management policy
     */
    private String storagePolicyDefinition;

    /*
     * Azure resource ID of the Pure Storage Pool associated with the storage policy
     */
    private String storagePoolId;

    /*
     * The state of the Pure Storage Policy Based Management policy provisioning
     */
    private PureStoragePolicyProvisioningState provisioningState;

    /**
     * Creates an instance of PureStoragePolicyProperties class.
     */
    public PureStoragePolicyProperties() {
    }

    /**
     * Get the storagePolicyDefinition property: Definition of a Pure Storage Policy Based Management policy.
     * 
     * @return the storagePolicyDefinition value.
     */
    public String storagePolicyDefinition() {
        return this.storagePolicyDefinition;
    }

    /**
     * Set the storagePolicyDefinition property: Definition of a Pure Storage Policy Based Management policy.
     * 
     * @param storagePolicyDefinition the storagePolicyDefinition value to set.
     * @return the PureStoragePolicyProperties object itself.
     */
    public PureStoragePolicyProperties withStoragePolicyDefinition(String storagePolicyDefinition) {
        this.storagePolicyDefinition = storagePolicyDefinition;
        return this;
    }

    /**
     * Get the storagePoolId property: Azure resource ID of the Pure Storage Pool associated with the storage policy.
     * 
     * @return the storagePoolId value.
     */
    public String storagePoolId() {
        return this.storagePoolId;
    }

    /**
     * Set the storagePoolId property: Azure resource ID of the Pure Storage Pool associated with the storage policy.
     * 
     * @param storagePoolId the storagePoolId value to set.
     * @return the PureStoragePolicyProperties object itself.
     */
    public PureStoragePolicyProperties withStoragePoolId(String storagePoolId) {
        this.storagePoolId = storagePoolId;
        return this;
    }

    /**
     * Get the provisioningState property: The state of the Pure Storage Policy Based Management policy provisioning.
     * 
     * @return the provisioningState value.
     */
    public PureStoragePolicyProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (storagePolicyDefinition() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property storagePolicyDefinition in model PureStoragePolicyProperties"));
        }
        if (storagePoolId() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property storagePoolId in model PureStoragePolicyProperties"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PureStoragePolicyProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("storagePolicyDefinition", this.storagePolicyDefinition);
        jsonWriter.writeStringField("storagePoolId", this.storagePoolId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PureStoragePolicyProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PureStoragePolicyProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PureStoragePolicyProperties.
     */
    public static PureStoragePolicyProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PureStoragePolicyProperties deserializedPureStoragePolicyProperties = new PureStoragePolicyProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("storagePolicyDefinition".equals(fieldName)) {
                    deserializedPureStoragePolicyProperties.storagePolicyDefinition = reader.getString();
                } else if ("storagePoolId".equals(fieldName)) {
                    deserializedPureStoragePolicyProperties.storagePoolId = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedPureStoragePolicyProperties.provisioningState
                        = PureStoragePolicyProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPureStoragePolicyProperties;
        });
    }
}
