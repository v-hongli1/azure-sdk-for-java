// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Class to represent shoebox properties in json client discovery.
 */
@Fluent
public final class ClientDiscoveryForProperties implements JsonSerializable<ClientDiscoveryForProperties> {
    /*
     * Operation properties.
     */
    private ClientDiscoveryForServiceSpecification serviceSpecification;

    /**
     * Creates an instance of ClientDiscoveryForProperties class.
     */
    public ClientDiscoveryForProperties() {
    }

    /**
     * Get the serviceSpecification property: Operation properties.
     * 
     * @return the serviceSpecification value.
     */
    public ClientDiscoveryForServiceSpecification serviceSpecification() {
        return this.serviceSpecification;
    }

    /**
     * Set the serviceSpecification property: Operation properties.
     * 
     * @param serviceSpecification the serviceSpecification value to set.
     * @return the ClientDiscoveryForProperties object itself.
     */
    public ClientDiscoveryForProperties
        withServiceSpecification(ClientDiscoveryForServiceSpecification serviceSpecification) {
        this.serviceSpecification = serviceSpecification;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (serviceSpecification() != null) {
            serviceSpecification().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("serviceSpecification", this.serviceSpecification);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ClientDiscoveryForProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ClientDiscoveryForProperties if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ClientDiscoveryForProperties.
     */
    public static ClientDiscoveryForProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ClientDiscoveryForProperties deserializedClientDiscoveryForProperties = new ClientDiscoveryForProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("serviceSpecification".equals(fieldName)) {
                    deserializedClientDiscoveryForProperties.serviceSpecification
                        = ClientDiscoveryForServiceSpecification.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedClientDiscoveryForProperties;
        });
    }
}
