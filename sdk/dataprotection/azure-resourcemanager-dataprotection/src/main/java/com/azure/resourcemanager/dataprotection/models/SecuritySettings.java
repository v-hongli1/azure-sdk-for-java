// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.dataprotection.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Class containing security settings of vault.
 */
@Fluent
public final class SecuritySettings implements JsonSerializable<SecuritySettings> {
    /*
     * Soft delete related settings
     */
    private SoftDeleteSettings softDeleteSettings;

    /*
     * Immutability Settings at vault level
     */
    private ImmutabilitySettings immutabilitySettings;

    /*
     * Customer Managed Key details of the resource.
     */
    private EncryptionSettings encryptionSettings;

    /**
     * Creates an instance of SecuritySettings class.
     */
    public SecuritySettings() {
    }

    /**
     * Get the softDeleteSettings property: Soft delete related settings.
     * 
     * @return the softDeleteSettings value.
     */
    public SoftDeleteSettings softDeleteSettings() {
        return this.softDeleteSettings;
    }

    /**
     * Set the softDeleteSettings property: Soft delete related settings.
     * 
     * @param softDeleteSettings the softDeleteSettings value to set.
     * @return the SecuritySettings object itself.
     */
    public SecuritySettings withSoftDeleteSettings(SoftDeleteSettings softDeleteSettings) {
        this.softDeleteSettings = softDeleteSettings;
        return this;
    }

    /**
     * Get the immutabilitySettings property: Immutability Settings at vault level.
     * 
     * @return the immutabilitySettings value.
     */
    public ImmutabilitySettings immutabilitySettings() {
        return this.immutabilitySettings;
    }

    /**
     * Set the immutabilitySettings property: Immutability Settings at vault level.
     * 
     * @param immutabilitySettings the immutabilitySettings value to set.
     * @return the SecuritySettings object itself.
     */
    public SecuritySettings withImmutabilitySettings(ImmutabilitySettings immutabilitySettings) {
        this.immutabilitySettings = immutabilitySettings;
        return this;
    }

    /**
     * Get the encryptionSettings property: Customer Managed Key details of the resource.
     * 
     * @return the encryptionSettings value.
     */
    public EncryptionSettings encryptionSettings() {
        return this.encryptionSettings;
    }

    /**
     * Set the encryptionSettings property: Customer Managed Key details of the resource.
     * 
     * @param encryptionSettings the encryptionSettings value to set.
     * @return the SecuritySettings object itself.
     */
    public SecuritySettings withEncryptionSettings(EncryptionSettings encryptionSettings) {
        this.encryptionSettings = encryptionSettings;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (softDeleteSettings() != null) {
            softDeleteSettings().validate();
        }
        if (immutabilitySettings() != null) {
            immutabilitySettings().validate();
        }
        if (encryptionSettings() != null) {
            encryptionSettings().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("softDeleteSettings", this.softDeleteSettings);
        jsonWriter.writeJsonField("immutabilitySettings", this.immutabilitySettings);
        jsonWriter.writeJsonField("encryptionSettings", this.encryptionSettings);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecuritySettings from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecuritySettings if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the SecuritySettings.
     */
    public static SecuritySettings fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SecuritySettings deserializedSecuritySettings = new SecuritySettings();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("softDeleteSettings".equals(fieldName)) {
                    deserializedSecuritySettings.softDeleteSettings = SoftDeleteSettings.fromJson(reader);
                } else if ("immutabilitySettings".equals(fieldName)) {
                    deserializedSecuritySettings.immutabilitySettings = ImmutabilitySettings.fromJson(reader);
                } else if ("encryptionSettings".equals(fieldName)) {
                    deserializedSecuritySettings.encryptionSettings = EncryptionSettings.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSecuritySettings;
        });
    }
}
