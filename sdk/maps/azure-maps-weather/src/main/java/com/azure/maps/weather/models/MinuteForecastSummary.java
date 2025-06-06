// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.maps.weather.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Phrase summaries for the entire forecast period.
 */
@Fluent
public final class MinuteForecastSummary implements JsonSerializable<MinuteForecastSummary> {

    /*
     * Summary phrase for the next 60 minutes. Phrase length is approximately 60 characters.
     */
    @Generated
    private String briefPhrase60;

    /*
     * Short summary phrase for the next 120 minutes. Phrase length is approximately 25 characters.
     */
    @Generated
    private String shortDescription;

    /*
     * Summary phrase for the next 120 minutes. Phrase length is approximately 60 characters.
     */
    @Generated
    private String briefDescription;

    /*
     * Long summary phrase for the next 120 minutes. Phrase length is 60+ characters.
     */
    @Generated
    private String longPhrase;

    /*
     * Numeric value representing an image that displays the `iconPhrase`. Please refer to [Weather services in Azure
     * Maps](/azure/azure-maps/weather-services-concepts#weather-icons) for details.
     */
    @Generated
    private IconCode iconCode;

    /**
     * Set default MinuteForecastSummary constructor to private
     */
    @Generated
    private MinuteForecastSummary() {
    }

    /**
     * Get the briefPhrase60 property: Summary phrase for the next 60 minutes. Phrase length is approximately 60
     * characters.
     *
     * @return the briefPhrase60 value.
     */
    @Generated
    public String getBriefPhrase60() {
        return this.briefPhrase60;
    }

    /**
     * Get the shortDescription property: Short summary phrase for the next 120 minutes. Phrase length is approximately
     * 25 characters.
     *
     * @return the shortDescription value.
     */
    @Generated
    public String getShortDescription() {
        return this.shortDescription;
    }

    /**
     * Get the briefDescription property: Summary phrase for the next 120 minutes. Phrase length is approximately 60
     * characters.
     *
     * @return the briefDescription value.
     */
    @Generated
    public String getBriefDescription() {
        return this.briefDescription;
    }

    /**
     * Get the longPhrase property: Long summary phrase for the next 120 minutes. Phrase length is 60+ characters.
     *
     * @return the longPhrase value.
     */
    @Generated
    public String getLongPhrase() {
        return this.longPhrase;
    }

    /**
     * Get the iconCode property: Numeric value representing an image that displays the `iconPhrase`. Please refer to
     * [Weather services in Azure Maps](/azure/azure-maps/weather-services-concepts#weather-icons) for details.
     *
     * @return the iconCode value.
     */
    @Generated
    public IconCode getIconCode() {
        return this.iconCode;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("briefPhrase60", this.briefPhrase60);
        jsonWriter.writeStringField("shortPhrase", this.shortDescription);
        jsonWriter.writeStringField("briefPhrase", this.briefDescription);
        jsonWriter.writeStringField("longPhrase", this.longPhrase);
        jsonWriter.writeNumberField("iconCode", this.iconCode == null ? null : this.iconCode.getValue());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MinuteForecastSummary from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of MinuteForecastSummary if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MinuteForecastSummary.
     */
    @Generated
    public static MinuteForecastSummary fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MinuteForecastSummary deserializedMinuteForecastSummary = new MinuteForecastSummary();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("briefPhrase60".equals(fieldName)) {
                    deserializedMinuteForecastSummary.briefPhrase60 = reader.getString();
                } else if ("shortPhrase".equals(fieldName)) {
                    deserializedMinuteForecastSummary.shortDescription = reader.getString();
                } else if ("briefPhrase".equals(fieldName)) {
                    deserializedMinuteForecastSummary.briefDescription = reader.getString();
                } else if ("longPhrase".equals(fieldName)) {
                    deserializedMinuteForecastSummary.longPhrase = reader.getString();
                } else if ("iconCode".equals(fieldName)) {
                    deserializedMinuteForecastSummary.iconCode = IconCode.fromValue(reader.getInt());
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedMinuteForecastSummary;
        });
    }
}
