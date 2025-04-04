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
import java.util.List;

/**
 * Target details for file / folder restore.
 */
@Fluent
public final class InstantItemRecoveryTarget implements JsonSerializable<InstantItemRecoveryTarget> {
    /*
     * List of client scripts.
     */
    private List<ClientScriptForConnect> clientScripts;

    /**
     * Creates an instance of InstantItemRecoveryTarget class.
     */
    public InstantItemRecoveryTarget() {
    }

    /**
     * Get the clientScripts property: List of client scripts.
     * 
     * @return the clientScripts value.
     */
    public List<ClientScriptForConnect> clientScripts() {
        return this.clientScripts;
    }

    /**
     * Set the clientScripts property: List of client scripts.
     * 
     * @param clientScripts the clientScripts value to set.
     * @return the InstantItemRecoveryTarget object itself.
     */
    public InstantItemRecoveryTarget withClientScripts(List<ClientScriptForConnect> clientScripts) {
        this.clientScripts = clientScripts;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (clientScripts() != null) {
            clientScripts().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("clientScripts", this.clientScripts, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of InstantItemRecoveryTarget from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of InstantItemRecoveryTarget if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the InstantItemRecoveryTarget.
     */
    public static InstantItemRecoveryTarget fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            InstantItemRecoveryTarget deserializedInstantItemRecoveryTarget = new InstantItemRecoveryTarget();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("clientScripts".equals(fieldName)) {
                    List<ClientScriptForConnect> clientScripts
                        = reader.readArray(reader1 -> ClientScriptForConnect.fromJson(reader1));
                    deserializedInstantItemRecoveryTarget.clientScripts = clientScripts;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedInstantItemRecoveryTarget;
        });
    }
}
