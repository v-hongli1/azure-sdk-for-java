// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.security.keyvault.keys.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Instant;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Map;

/**
 * The deleted key item containing the deleted key metadata and information about deletion.
 */
@Immutable
public final class DeletedKeyItem implements JsonSerializable<DeletedKeyItem> {
    /*
     * Key identifier.
     */
    @Generated
    private String kid;

    /*
     * The key management attributes.
     */
    @Generated
    private KeyAttributes attributes;

    /*
     * Application specific metadata in the form of key-value pairs.
     */
    @Generated
    private Map<String, String> tags;

    /*
     * True if the key's lifetime is managed by key vault. If this is a key backing a certificate, then managed will be
     * true.
     */
    @Generated
    private Boolean managed;

    /*
     * The url of the recovery object, used to identify and recover the deleted key.
     */
    @Generated
    private String recoveryId;

    /*
     * The time when the key is scheduled to be purged, in UTC
     */
    @Generated
    private Long scheduledPurgeDate;

    /*
     * The time when the key was deleted, in UTC
     */
    @Generated
    private Long deletedDate;

    /**
     * Creates an instance of DeletedKeyItem class.
     */
    @Generated
    private DeletedKeyItem() {
    }

    /**
     * Get the kid property: Key identifier.
     * 
     * @return the kid value.
     */
    @Generated
    public String getKid() {
        return this.kid;
    }

    /**
     * Get the attributes property: The key management attributes.
     * 
     * @return the attributes value.
     */
    @Generated
    public KeyAttributes getAttributes() {
        return this.attributes;
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
     * Get the managed property: True if the key's lifetime is managed by key vault. If this is a key backing a
     * certificate, then managed will be true.
     * 
     * @return the managed value.
     */
    @Generated
    public Boolean isManaged() {
        return this.managed;
    }

    /**
     * Get the recoveryId property: The url of the recovery object, used to identify and recover the deleted key.
     * 
     * @return the recoveryId value.
     */
    @Generated
    public String getRecoveryId() {
        return this.recoveryId;
    }

    /**
     * Get the scheduledPurgeDate property: The time when the key is scheduled to be purged, in UTC.
     * 
     * @return the scheduledPurgeDate value.
     */
    @Generated
    public OffsetDateTime getScheduledPurgeDate() {
        if (this.scheduledPurgeDate == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.scheduledPurgeDate), ZoneOffset.UTC);
    }

    /**
     * Get the deletedDate property: The time when the key was deleted, in UTC.
     * 
     * @return the deletedDate value.
     */
    @Generated
    public OffsetDateTime getDeletedDate() {
        if (this.deletedDate == null) {
            return null;
        }
        return OffsetDateTime.ofInstant(Instant.ofEpochSecond(this.deletedDate), ZoneOffset.UTC);
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("kid", this.kid);
        jsonWriter.writeJsonField("attributes", this.attributes);
        jsonWriter.writeMapField("tags", this.tags, (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("recoveryId", this.recoveryId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DeletedKeyItem from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DeletedKeyItem if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the DeletedKeyItem.
     */
    @Generated
    public static DeletedKeyItem fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DeletedKeyItem deserializedDeletedKeyItem = new DeletedKeyItem();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("kid".equals(fieldName)) {
                    deserializedDeletedKeyItem.kid = reader.getString();
                } else if ("attributes".equals(fieldName)) {
                    deserializedDeletedKeyItem.attributes = KeyAttributes.fromJson(reader);
                } else if ("tags".equals(fieldName)) {
                    Map<String, String> tags = reader.readMap(reader1 -> reader1.getString());
                    deserializedDeletedKeyItem.tags = tags;
                } else if ("managed".equals(fieldName)) {
                    deserializedDeletedKeyItem.managed = reader.getNullable(JsonReader::getBoolean);
                } else if ("recoveryId".equals(fieldName)) {
                    deserializedDeletedKeyItem.recoveryId = reader.getString();
                } else if ("scheduledPurgeDate".equals(fieldName)) {
                    deserializedDeletedKeyItem.scheduledPurgeDate = reader.getNullable(JsonReader::getLong);
                } else if ("deletedDate".equals(fieldName)) {
                    deserializedDeletedKeyItem.deletedDate = reader.getNullable(JsonReader::getLong);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDeletedKeyItem;
        });
    }
}
