// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.radiologyinsights.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Critical results refer to findings of utmost importance that may require timely attention due to their potential
 * impact on patient care.
 */
@Immutable
public final class CriticalResultInference extends RadiologyInsightsInference {

    /*
     * Discriminator property for RadiologyInsightsInference.
     */
    @Generated
    private RadiologyInsightsInferenceType kind = RadiologyInsightsInferenceType.CRITICAL_RESULT;

    /*
     * The complete Critical Result, as outlined below, will be reused for the recommendation.
     */
    @Generated
    private final CriticalResult result;

    /**
     * Creates an instance of CriticalResultInference class.
     *
     * @param result the result value to set.
     */
    @Generated
    private CriticalResultInference(CriticalResult result) {
        this.result = result;
    }

    /**
     * Get the kind property: Discriminator property for RadiologyInsightsInference.
     *
     * @return the kind value.
     */
    @Generated
    @Override
    public RadiologyInsightsInferenceType getKind() {
        return this.kind;
    }

    /**
     * Get the result property: The complete Critical Result, as outlined below, will be reused for the recommendation.
     *
     * @return the result value.
     */
    @Generated
    public CriticalResult getResult() {
        return this.result;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("extension", getExtension(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("result", this.result);
        jsonWriter.writeStringField("kind", this.kind == null ? null : this.kind.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CriticalResultInference from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of CriticalResultInference if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CriticalResultInference.
     */
    @Generated
    public static CriticalResultInference fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            List<FhirR4Extension> extension = null;
            CriticalResult result = null;
            RadiologyInsightsInferenceType kind = RadiologyInsightsInferenceType.CRITICAL_RESULT;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("extension".equals(fieldName)) {
                    extension = reader.readArray(reader1 -> FhirR4Extension.fromJson(reader1));
                } else if ("result".equals(fieldName)) {
                    result = CriticalResult.fromJson(reader);
                } else if ("kind".equals(fieldName)) {
                    kind = RadiologyInsightsInferenceType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }
            CriticalResultInference deserializedCriticalResultInference = new CriticalResultInference(result);
            deserializedCriticalResultInference.setExtension(extension);
            deserializedCriticalResultInference.kind = kind;
            return deserializedCriticalResultInference;
        });
    }
}
