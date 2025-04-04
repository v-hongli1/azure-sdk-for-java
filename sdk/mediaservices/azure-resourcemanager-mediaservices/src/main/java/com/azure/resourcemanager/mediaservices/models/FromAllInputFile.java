// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * An InputDefinition that looks across all of the files provided to select tracks specified by the IncludedTracks
 * property. Generally used with the AudioTrackByAttribute and VideoTrackByAttribute to allow selection of a single
 * track across a set of input files.
 */
@Fluent
public final class FromAllInputFile extends InputDefinition {
    /*
     * The discriminator for derived types.
     */
    private String odataType = "#Microsoft.Media.FromAllInputFile";

    /**
     * Creates an instance of FromAllInputFile class.
     */
    public FromAllInputFile() {
    }

    /**
     * Get the odataType property: The discriminator for derived types.
     * 
     * @return the odataType value.
     */
    @Override
    public String odataType() {
        return this.odataType;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public FromAllInputFile withIncludedTracks(List<TrackDescriptor> includedTracks) {
        super.withIncludedTracks(includedTracks);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (includedTracks() != null) {
            includedTracks().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("includedTracks", includedTracks(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("@odata.type", this.odataType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of FromAllInputFile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of FromAllInputFile if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the FromAllInputFile.
     */
    public static FromAllInputFile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            FromAllInputFile deserializedFromAllInputFile = new FromAllInputFile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("includedTracks".equals(fieldName)) {
                    List<TrackDescriptor> includedTracks
                        = reader.readArray(reader1 -> TrackDescriptor.fromJson(reader1));
                    deserializedFromAllInputFile.withIncludedTracks(includedTracks);
                } else if ("@odata.type".equals(fieldName)) {
                    deserializedFromAllInputFile.odataType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFromAllInputFile;
        });
    }
}
