// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.maps.weather.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * This object is returned from a successful Get Severe Weather Alerts call.
 */
@Immutable
public final class SevereWeatherAlertsResult implements JsonSerializable<SevereWeatherAlertsResult> {

    /*
     * A list of all severe weather alerts for the queried location.
     */
    @Generated
    private List<SevereWeatherAlert> results;

    /**
     * Set default SevereWeatherAlertsResult constructor to private
     */
    @Generated
    private SevereWeatherAlertsResult() {
    }

    /**
     * Get the results property: A list of all severe weather alerts for the queried location.
     *
     * @return the results value.
     */
    @Generated
    public List<SevereWeatherAlert> getResults() {
        return this.results;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SevereWeatherAlertsResult from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of SevereWeatherAlertsResult if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SevereWeatherAlertsResult.
     */
    @Generated
    public static SevereWeatherAlertsResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SevereWeatherAlertsResult deserializedSevereWeatherAlertsResult = new SevereWeatherAlertsResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("results".equals(fieldName)) {
                    List<SevereWeatherAlert> results
                        = reader.readArray(reader1 -> SevereWeatherAlert.fromJson(reader1));
                    deserializedSevereWeatherAlertsResult.results = results;
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedSevereWeatherAlertsResult;
        });
    }
}
