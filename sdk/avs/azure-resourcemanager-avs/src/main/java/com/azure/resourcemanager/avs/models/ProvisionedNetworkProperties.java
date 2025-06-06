// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The properties of a provisioned network.
 */
@Immutable
public final class ProvisionedNetworkProperties implements JsonSerializable<ProvisionedNetworkProperties> {
    /*
     * The provisioning state of the resource.
     */
    private ProvisionedNetworkProvisioningState provisioningState;

    /*
     * The address prefixes of the provisioned network in CIDR notation.
     */
    private String addressPrefix;

    /*
     * The type of network provisioned.
     */
    private ProvisionedNetworkTypes networkType;

    /**
     * Creates an instance of ProvisionedNetworkProperties class.
     */
    private ProvisionedNetworkProperties() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisionedNetworkProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the addressPrefix property: The address prefixes of the provisioned network in CIDR notation.
     * 
     * @return the addressPrefix value.
     */
    public String addressPrefix() {
        return this.addressPrefix;
    }

    /**
     * Get the networkType property: The type of network provisioned.
     * 
     * @return the networkType value.
     */
    public ProvisionedNetworkTypes networkType() {
        return this.networkType;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ProvisionedNetworkProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ProvisionedNetworkProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ProvisionedNetworkProperties.
     */
    public static ProvisionedNetworkProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ProvisionedNetworkProperties deserializedProvisionedNetworkProperties = new ProvisionedNetworkProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedProvisionedNetworkProperties.provisioningState
                        = ProvisionedNetworkProvisioningState.fromString(reader.getString());
                } else if ("addressPrefix".equals(fieldName)) {
                    deserializedProvisionedNetworkProperties.addressPrefix = reader.getString();
                } else if ("networkType".equals(fieldName)) {
                    deserializedProvisionedNetworkProperties.networkType
                        = ProvisionedNetworkTypes.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedProvisionedNetworkProperties;
        });
    }
}
