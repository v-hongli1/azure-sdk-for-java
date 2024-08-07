// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The ZoneMapping model.
 */
@Fluent
public final class ZoneMapping implements JsonSerializable<ZoneMapping> {
    /*
     * The location of the zone mapping.
     */
    private String location;

    /*
     * The zones property.
     */
    private List<String> zones;

    /**
     * Creates an instance of ZoneMapping class.
     */
    public ZoneMapping() {
    }

    /**
     * Get the location property: The location of the zone mapping.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: The location of the zone mapping.
     * 
     * @param location the location value to set.
     * @return the ZoneMapping object itself.
     */
    public ZoneMapping withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the zones property: The zones property.
     * 
     * @return the zones value.
     */
    public List<String> zones() {
        return this.zones;
    }

    /**
     * Set the zones property: The zones property.
     * 
     * @param zones the zones value to set.
     * @return the ZoneMapping object itself.
     */
    public ZoneMapping withZones(List<String> zones) {
        this.zones = zones;
        return this;
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
        jsonWriter.writeStringField("location", this.location);
        jsonWriter.writeArrayField("zones", this.zones, (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ZoneMapping from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ZoneMapping if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the ZoneMapping.
     */
    public static ZoneMapping fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ZoneMapping deserializedZoneMapping = new ZoneMapping();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("location".equals(fieldName)) {
                    deserializedZoneMapping.location = reader.getString();
                } else if ("zones".equals(fieldName)) {
                    List<String> zones = reader.readArray(reader1 -> reader1.getString());
                    deserializedZoneMapping.zones = zones;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedZoneMapping;
        });
    }
}
