// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.security.keyvault.keys.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.security.keyvault.keys.models.KeyOperation;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The key update parameters.
 */
@Fluent
public final class KeyUpdateParameters implements JsonSerializable<KeyUpdateParameters> {
    /*
     * Json web key operations. For more information on possible key operations, see JsonWebKeyOperation.
     */
    @Generated
    private List<KeyOperation> keyOps;

    /*
     * The attributes of a key managed by the key vault service.
     */
    @Generated
    private KeyAttributes keyAttributes;

    /*
     * Application specific metadata in the form of key-value pairs.
     */
    @Generated
    private Map<String, String> tags;

    /*
     * The policy rules under which the key can be exported.
     */
    @Generated
    private KeyReleasePolicy releasePolicy;

    /**
     * Creates an instance of KeyUpdateParameters class.
     */
    @Generated
    public KeyUpdateParameters() {
    }

    /**
     * Get the keyOps property: Json web key operations. For more information on possible key operations, see
     * JsonWebKeyOperation.
     * 
     * @return the keyOps value.
     */
    @Generated
    public List<KeyOperation> getKeyOps() {
        return this.keyOps;
    }

    /**
     * Set the keyOps property: Json web key operations. For more information on possible key operations, see
     * JsonWebKeyOperation.
     * 
     * @param keyOps the keyOps value to set.
     * @return the KeyUpdateParameters object itself.
     */
    @Generated
    public KeyUpdateParameters setKeyOps(List<KeyOperation> keyOps) {
        this.keyOps = keyOps;
        return this;
    }

    /**
     * Get the keyAttributes property: The attributes of a key managed by the key vault service.
     * 
     * @return the keyAttributes value.
     */
    @Generated
    public KeyAttributes getKeyAttributes() {
        return this.keyAttributes;
    }

    /**
     * Set the keyAttributes property: The attributes of a key managed by the key vault service.
     * 
     * @param keyAttributes the keyAttributes value to set.
     * @return the KeyUpdateParameters object itself.
     */
    @Generated
    public KeyUpdateParameters setKeyAttributes(KeyAttributes keyAttributes) {
        this.keyAttributes = keyAttributes;
        return this;
    }

    /**
     * Get the tags property: Application specific metadata in the form of key-value pairs.
     * 
     * @return the tags value.
     */
    @Generated
    public Map<String, String> getTags() {
        return this.tags;
    }

    /**
     * Set the tags property: Application specific metadata in the form of key-value pairs.
     * 
     * @param tags the tags value to set.
     * @return the KeyUpdateParameters object itself.
     */
    @Generated
    public KeyUpdateParameters setTags(Map<String, String> tags) {
        this.tags = tags;
        return this;
    }

    /**
     * Get the releasePolicy property: The policy rules under which the key can be exported.
     * 
     * @return the releasePolicy value.
     */
    @Generated
    public KeyReleasePolicy getReleasePolicy() {
        return this.releasePolicy;
    }

    /**
     * Set the releasePolicy property: The policy rules under which the key can be exported.
     * 
     * @param releasePolicy the releasePolicy value to set.
     * @return the KeyUpdateParameters object itself.
     */
    @Generated
    public KeyUpdateParameters setReleasePolicy(KeyReleasePolicy releasePolicy) {
        this.releasePolicy = releasePolicy;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("key_ops", this.keyOps,
            (writer, element) -> writer.writeString(element == null ? null : element.toString()));
        jsonWriter.writeJsonField("attributes", this.keyAttributes);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("release_policy", this.releasePolicy);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of KeyUpdateParameters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeyUpdateParameters if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the KeyUpdateParameters.
     */
    @Generated
    public static KeyUpdateParameters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            KeyUpdateParameters deserializedKeyUpdateParameters = new KeyUpdateParameters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("key_ops".equals(fieldName)) {
                    List<KeyOperation> keyOps
                        = reader.readArray(reader1 -> KeyOperation.fromString(reader1.getString()));
                    deserializedKeyUpdateParameters.keyOps = keyOps;
                } else if ("attributes".equals(fieldName)) {
                    deserializedKeyUpdateParameters.keyAttributes = KeyAttributes.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedKeyUpdateParameters.tags = tags;
                } else if ("release_policy".equals(fieldName)) {
                    deserializedKeyUpdateParameters.releasePolicy = KeyReleasePolicy.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedKeyUpdateParameters;
        });
    }
}
