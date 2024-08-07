// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The name of the extended location.
 */
@Fluent
public final class GalleryExtendedLocation implements JsonSerializable<GalleryExtendedLocation> {
    /*
     * The name property.
     */
    private String name;

    /*
     * It is type of the extended location.
     */
    private GalleryExtendedLocationType type;

    /**
     * Creates an instance of GalleryExtendedLocation class.
     */
    public GalleryExtendedLocation() {
    }

    /**
     * Get the name property: The name property.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name property.
     * 
     * @param name the name value to set.
     * @return the GalleryExtendedLocation object itself.
     */
    public GalleryExtendedLocation withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type property: It is type of the extended location.
     * 
     * @return the type value.
     */
    public GalleryExtendedLocationType type() {
        return this.type;
    }

    /**
     * Set the type property: It is type of the extended location.
     * 
     * @param type the type value to set.
     * @return the GalleryExtendedLocation object itself.
     */
    public GalleryExtendedLocation withType(GalleryExtendedLocationType type) {
        this.type = type;
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
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GalleryExtendedLocation from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GalleryExtendedLocation if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GalleryExtendedLocation.
     */
    public static GalleryExtendedLocation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GalleryExtendedLocation deserializedGalleryExtendedLocation = new GalleryExtendedLocation();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedGalleryExtendedLocation.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedGalleryExtendedLocation.type
                        = GalleryExtendedLocationType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGalleryExtendedLocation;
        });
    }
}
