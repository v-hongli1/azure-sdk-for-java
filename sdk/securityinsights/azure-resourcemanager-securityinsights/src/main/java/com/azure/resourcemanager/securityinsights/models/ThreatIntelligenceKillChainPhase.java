// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.securityinsights.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes threat kill chain phase entity.
 */
@Fluent
public final class ThreatIntelligenceKillChainPhase implements JsonSerializable<ThreatIntelligenceKillChainPhase> {
    /*
     * Kill chainName name
     */
    private String killChainName;

    /*
     * Phase name
     */
    private String phaseName;

    /**
     * Creates an instance of ThreatIntelligenceKillChainPhase class.
     */
    public ThreatIntelligenceKillChainPhase() {
    }

    /**
     * Get the killChainName property: Kill chainName name.
     * 
     * @return the killChainName value.
     */
    public String killChainName() {
        return this.killChainName;
    }

    /**
     * Set the killChainName property: Kill chainName name.
     * 
     * @param killChainName the killChainName value to set.
     * @return the ThreatIntelligenceKillChainPhase object itself.
     */
    public ThreatIntelligenceKillChainPhase withKillChainName(String killChainName) {
        this.killChainName = killChainName;
        return this;
    }

    /**
     * Get the phaseName property: Phase name.
     * 
     * @return the phaseName value.
     */
    public String phaseName() {
        return this.phaseName;
    }

    /**
     * Set the phaseName property: Phase name.
     * 
     * @param phaseName the phaseName value to set.
     * @return the ThreatIntelligenceKillChainPhase object itself.
     */
    public ThreatIntelligenceKillChainPhase withPhaseName(String phaseName) {
        this.phaseName = phaseName;
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
        jsonWriter.writeStringField("killChainName", this.killChainName);
        jsonWriter.writeStringField("phaseName", this.phaseName);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ThreatIntelligenceKillChainPhase from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ThreatIntelligenceKillChainPhase if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ThreatIntelligenceKillChainPhase.
     */
    public static ThreatIntelligenceKillChainPhase fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ThreatIntelligenceKillChainPhase deserializedThreatIntelligenceKillChainPhase
                = new ThreatIntelligenceKillChainPhase();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("killChainName".equals(fieldName)) {
                    deserializedThreatIntelligenceKillChainPhase.killChainName = reader.getString();
                } else if ("phaseName".equals(fieldName)) {
                    deserializedThreatIntelligenceKillChainPhase.phaseName = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedThreatIntelligenceKillChainPhase;
        });
    }
}
