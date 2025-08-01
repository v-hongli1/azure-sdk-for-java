// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.healthbot.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * HealthBotProperties
 * 
 * The properties of a Azure Health Bot. The Health Bot Service is a cloud platform that empowers developers in
 * Healthcare organizations to build and deploy their compliant, AI-powered virtual health assistants and health bots,
 * that help them improve processes and reduce costs.
 */
@Fluent
public final class HealthBotProperties implements JsonSerializable<HealthBotProperties> {
    /*
     * The provisioning state of the Azure Health Bot resource.
     */
    private String provisioningState;

    /*
     * The link.
     */
    private String botManagementPortalLink;

    /*
     * KeyVault properties for the resource encryption.
     */
    private KeyVaultProperties keyVaultProperties;

    /*
     * The access control method for the Azure Health Bot resource.
     */
    private String accessControlMethod;

    /**
     * Creates an instance of HealthBotProperties class.
     */
    public HealthBotProperties() {
    }

    /**
     * Get the provisioningState property: The provisioning state of the Azure Health Bot resource.
     * 
     * @return the provisioningState value.
     */
    public String provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the botManagementPortalLink property: The link.
     * 
     * @return the botManagementPortalLink value.
     */
    public String botManagementPortalLink() {
        return this.botManagementPortalLink;
    }

    /**
     * Get the keyVaultProperties property: KeyVault properties for the resource encryption.
     * 
     * @return the keyVaultProperties value.
     */
    public KeyVaultProperties keyVaultProperties() {
        return this.keyVaultProperties;
    }

    /**
     * Set the keyVaultProperties property: KeyVault properties for the resource encryption.
     * 
     * @param keyVaultProperties the keyVaultProperties value to set.
     * @return the HealthBotProperties object itself.
     */
    public HealthBotProperties withKeyVaultProperties(KeyVaultProperties keyVaultProperties) {
        this.keyVaultProperties = keyVaultProperties;
        return this;
    }

    /**
     * Get the accessControlMethod property: The access control method for the Azure Health Bot resource.
     * 
     * @return the accessControlMethod value.
     */
    public String accessControlMethod() {
        return this.accessControlMethod;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (keyVaultProperties() != null) {
            keyVaultProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("keyVaultProperties", this.keyVaultProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of HealthBotProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of HealthBotProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the HealthBotProperties.
     */
    public static HealthBotProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            HealthBotProperties deserializedHealthBotProperties = new HealthBotProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("provisioningState".equals(fieldName)) {
                    deserializedHealthBotProperties.provisioningState = reader.getString();
                } else if ("botManagementPortalLink".equals(fieldName)) {
                    deserializedHealthBotProperties.botManagementPortalLink = reader.getString();
                } else if ("keyVaultProperties".equals(fieldName)) {
                    deserializedHealthBotProperties.keyVaultProperties = KeyVaultProperties.fromJson(reader);
                } else if ("accessControlMethod".equals(fieldName)) {
                    deserializedHealthBotProperties.accessControlMethod = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedHealthBotProperties;
        });
    }
}
