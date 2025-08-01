// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

/**
 * The rest of the world group two region configuration.
 */
@Fluent
public final class DefaultRolloutSpecificationRestOfTheWorldGroupTwo extends TrafficRegionRolloutConfiguration {
    /**
     * Creates an instance of DefaultRolloutSpecificationRestOfTheWorldGroupTwo class.
     */
    public DefaultRolloutSpecificationRestOfTheWorldGroupTwo() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutSpecificationRestOfTheWorldGroupTwo withWaitDuration(Duration waitDuration) {
        super.withWaitDuration(waitDuration);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public DefaultRolloutSpecificationRestOfTheWorldGroupTwo withRegions(List<String> regions) {
        super.withRegions(regions);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("regions", regions(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("waitDuration", CoreUtils.durationToStringWithDays(waitDuration()));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DefaultRolloutSpecificationRestOfTheWorldGroupTwo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DefaultRolloutSpecificationRestOfTheWorldGroupTwo if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DefaultRolloutSpecificationRestOfTheWorldGroupTwo.
     */
    public static DefaultRolloutSpecificationRestOfTheWorldGroupTwo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DefaultRolloutSpecificationRestOfTheWorldGroupTwo deserializedDefaultRolloutSpecificationRestOfTheWorldGroupTwo
                = new DefaultRolloutSpecificationRestOfTheWorldGroupTwo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("regions".equals(fieldName)) {
                    List<String> regions = reader.readArray(reader1 -> reader1.getString());
                    deserializedDefaultRolloutSpecificationRestOfTheWorldGroupTwo.withRegions(regions);
                } else if ("waitDuration".equals(fieldName)) {
                    deserializedDefaultRolloutSpecificationRestOfTheWorldGroupTwo.withWaitDuration(
                        reader.getNullable(nonNullReader -> Duration.parse(nonNullReader.getString())));
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDefaultRolloutSpecificationRestOfTheWorldGroupTwo;
        });
    }
}
