// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Describes all the filtering operations, such as de-interlacing, rotation etc. that are to be applied to the input
 * media before encoding.
 */
@Fluent
public final class Filters implements JsonSerializable<Filters> {
    /*
     * The de-interlacing settings.
     */
    private Deinterlace deinterlace;

    /*
     * The rotation, if any, to be applied to the input video, before it is encoded. Default is Auto
     */
    private Rotation rotation;

    /*
     * The parameters for the rectangular window with which to crop the input video.
     */
    private Rectangle crop;

    /*
     * Describes the properties of a Fade effect applied to the input media.
     */
    private Fade fadeIn;

    /*
     * Describes the properties of a Fade effect applied to the input media.
     */
    private Fade fadeOut;

    /*
     * The properties of overlays to be applied to the input video. These could be audio, image or video overlays.
     */
    private List<Overlay> overlays;

    /**
     * Creates an instance of Filters class.
     */
    public Filters() {
    }

    /**
     * Get the deinterlace property: The de-interlacing settings.
     * 
     * @return the deinterlace value.
     */
    public Deinterlace deinterlace() {
        return this.deinterlace;
    }

    /**
     * Set the deinterlace property: The de-interlacing settings.
     * 
     * @param deinterlace the deinterlace value to set.
     * @return the Filters object itself.
     */
    public Filters withDeinterlace(Deinterlace deinterlace) {
        this.deinterlace = deinterlace;
        return this;
    }

    /**
     * Get the rotation property: The rotation, if any, to be applied to the input video, before it is encoded. Default
     * is Auto.
     * 
     * @return the rotation value.
     */
    public Rotation rotation() {
        return this.rotation;
    }

    /**
     * Set the rotation property: The rotation, if any, to be applied to the input video, before it is encoded. Default
     * is Auto.
     * 
     * @param rotation the rotation value to set.
     * @return the Filters object itself.
     */
    public Filters withRotation(Rotation rotation) {
        this.rotation = rotation;
        return this;
    }

    /**
     * Get the crop property: The parameters for the rectangular window with which to crop the input video.
     * 
     * @return the crop value.
     */
    public Rectangle crop() {
        return this.crop;
    }

    /**
     * Set the crop property: The parameters for the rectangular window with which to crop the input video.
     * 
     * @param crop the crop value to set.
     * @return the Filters object itself.
     */
    public Filters withCrop(Rectangle crop) {
        this.crop = crop;
        return this;
    }

    /**
     * Get the fadeIn property: Describes the properties of a Fade effect applied to the input media.
     * 
     * @return the fadeIn value.
     */
    public Fade fadeIn() {
        return this.fadeIn;
    }

    /**
     * Set the fadeIn property: Describes the properties of a Fade effect applied to the input media.
     * 
     * @param fadeIn the fadeIn value to set.
     * @return the Filters object itself.
     */
    public Filters withFadeIn(Fade fadeIn) {
        this.fadeIn = fadeIn;
        return this;
    }

    /**
     * Get the fadeOut property: Describes the properties of a Fade effect applied to the input media.
     * 
     * @return the fadeOut value.
     */
    public Fade fadeOut() {
        return this.fadeOut;
    }

    /**
     * Set the fadeOut property: Describes the properties of a Fade effect applied to the input media.
     * 
     * @param fadeOut the fadeOut value to set.
     * @return the Filters object itself.
     */
    public Filters withFadeOut(Fade fadeOut) {
        this.fadeOut = fadeOut;
        return this;
    }

    /**
     * Get the overlays property: The properties of overlays to be applied to the input video. These could be audio,
     * image or video overlays.
     * 
     * @return the overlays value.
     */
    public List<Overlay> overlays() {
        return this.overlays;
    }

    /**
     * Set the overlays property: The properties of overlays to be applied to the input video. These could be audio,
     * image or video overlays.
     * 
     * @param overlays the overlays value to set.
     * @return the Filters object itself.
     */
    public Filters withOverlays(List<Overlay> overlays) {
        this.overlays = overlays;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (deinterlace() != null) {
            deinterlace().validate();
        }
        if (crop() != null) {
            crop().validate();
        }
        if (fadeIn() != null) {
            fadeIn().validate();
        }
        if (fadeOut() != null) {
            fadeOut().validate();
        }
        if (overlays() != null) {
            overlays().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("deinterlace", this.deinterlace);
        jsonWriter.writeStringField("rotation", this.rotation == null ? null : this.rotation.toString());
        jsonWriter.writeJsonField("crop", this.crop);
        jsonWriter.writeJsonField("fadeIn", this.fadeIn);
        jsonWriter.writeJsonField("fadeOut", this.fadeOut);
        jsonWriter.writeArrayField("overlays", this.overlays, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Filters from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Filters if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Filters.
     */
    public static Filters fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Filters deserializedFilters = new Filters();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("deinterlace".equals(fieldName)) {
                    deserializedFilters.deinterlace = Deinterlace.fromJson(reader);
                } else if ("rotation".equals(fieldName)) {
                    deserializedFilters.rotation = Rotation.fromString(reader.getString());
                } else if ("crop".equals(fieldName)) {
                    deserializedFilters.crop = Rectangle.fromJson(reader);
                } else if ("fadeIn".equals(fieldName)) {
                    deserializedFilters.fadeIn = Fade.fromJson(reader);
                } else if ("fadeOut".equals(fieldName)) {
                    deserializedFilters.fadeOut = Fade.fromJson(reader);
                } else if ("overlays".equals(fieldName)) {
                    List<Overlay> overlays = reader.readArray(reader1 -> Overlay.fromJson(reader1));
                    deserializedFilters.overlays = overlays;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedFilters;
        });
    }
}
