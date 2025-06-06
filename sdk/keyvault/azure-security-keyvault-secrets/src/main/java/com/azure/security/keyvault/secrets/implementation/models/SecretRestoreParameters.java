// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.security.keyvault.secrets.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.core.util.Base64Url;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.Objects;

/**
 * The secret restore parameters.
 */
@Immutable
public final class SecretRestoreParameters implements JsonSerializable<SecretRestoreParameters> {
    /*
     * The backup blob associated with a secret bundle.
     */
    @Generated
    private final Base64Url secretBundleBackup;

    /**
     * Creates an instance of SecretRestoreParameters class.
     * 
     * @param secretBundleBackup the secretBundleBackup value to set.
     */
    @Generated
    public SecretRestoreParameters(byte[] secretBundleBackup) {
        if (secretBundleBackup == null) {
            this.secretBundleBackup = null;
        } else {
            this.secretBundleBackup = Base64Url.encode(secretBundleBackup);
        }
    }

    /**
     * Get the secretBundleBackup property: The backup blob associated with a secret bundle.
     * 
     * @return the secretBundleBackup value.
     */
    @Generated
    public byte[] getSecretBundleBackup() {
        if (this.secretBundleBackup == null) {
            return null;
        }
        return this.secretBundleBackup.decodedBytes();
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("value", Objects.toString(this.secretBundleBackup, null));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SecretRestoreParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SecretRestoreParameters if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SecretRestoreParameters.
     */
    @Generated
    public static SecretRestoreParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            byte[] secretBundleBackup = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    Base64Url secretBundleBackupHolder
                        = reader.getNullable(nonNullReader -> new Base64Url(nonNullReader.getString()));
                    if (secretBundleBackupHolder != null) {
                        secretBundleBackup = secretBundleBackupHolder.decodedBytes();
                    }
                } else {
                    reader.skipChildren();
                }
            }
            return new SecretRestoreParameters(secretBundleBackup);
        });
    }
}
