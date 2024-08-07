// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * teamsAppInstallation.
 */
@Fluent
public class MicrosoftGraphTeamsAppInstallation extends MicrosoftGraphEntity {
    /*
     * teamsApp
     */
    private MicrosoftGraphTeamsApp teamsApp;

    /*
     * teamsAppDefinition
     */
    private MicrosoftGraphTeamsAppDefinition teamsAppDefinition;

    /*
     * teamsAppInstallation
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of MicrosoftGraphTeamsAppInstallation class.
     */
    public MicrosoftGraphTeamsAppInstallation() {
    }

    /**
     * Get the teamsApp property: teamsApp.
     * 
     * @return the teamsApp value.
     */
    public MicrosoftGraphTeamsApp teamsApp() {
        return this.teamsApp;
    }

    /**
     * Set the teamsApp property: teamsApp.
     * 
     * @param teamsApp the teamsApp value to set.
     * @return the MicrosoftGraphTeamsAppInstallation object itself.
     */
    public MicrosoftGraphTeamsAppInstallation withTeamsApp(MicrosoftGraphTeamsApp teamsApp) {
        this.teamsApp = teamsApp;
        return this;
    }

    /**
     * Get the teamsAppDefinition property: teamsAppDefinition.
     * 
     * @return the teamsAppDefinition value.
     */
    public MicrosoftGraphTeamsAppDefinition teamsAppDefinition() {
        return this.teamsAppDefinition;
    }

    /**
     * Set the teamsAppDefinition property: teamsAppDefinition.
     * 
     * @param teamsAppDefinition the teamsAppDefinition value to set.
     * @return the MicrosoftGraphTeamsAppInstallation object itself.
     */
    public MicrosoftGraphTeamsAppInstallation
        withTeamsAppDefinition(MicrosoftGraphTeamsAppDefinition teamsAppDefinition) {
        this.teamsAppDefinition = teamsAppDefinition;
        return this;
    }

    /**
     * Get the additionalProperties property: teamsAppInstallation.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: teamsAppInstallation.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphTeamsAppInstallation object itself.
     */
    public MicrosoftGraphTeamsAppInstallation withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MicrosoftGraphTeamsAppInstallation withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (teamsApp() != null) {
            teamsApp().validate();
        }
        if (teamsAppDefinition() != null) {
            teamsAppDefinition().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", id());
        jsonWriter.writeJsonField("teamsApp", this.teamsApp);
        jsonWriter.writeJsonField("teamsAppDefinition", this.teamsAppDefinition);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MicrosoftGraphTeamsAppInstallation from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MicrosoftGraphTeamsAppInstallation if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MicrosoftGraphTeamsAppInstallation.
     */
    public static MicrosoftGraphTeamsAppInstallation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MicrosoftGraphTeamsAppInstallation deserializedMicrosoftGraphTeamsAppInstallation
                = new MicrosoftGraphTeamsAppInstallation();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMicrosoftGraphTeamsAppInstallation.withId(reader.getString());
                } else if ("teamsApp".equals(fieldName)) {
                    deserializedMicrosoftGraphTeamsAppInstallation.teamsApp = MicrosoftGraphTeamsApp.fromJson(reader);
                } else if ("teamsAppDefinition".equals(fieldName)) {
                    deserializedMicrosoftGraphTeamsAppInstallation.teamsAppDefinition
                        = MicrosoftGraphTeamsAppDefinition.fromJson(reader);
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedMicrosoftGraphTeamsAppInstallation.additionalProperties = additionalProperties;

            return deserializedMicrosoftGraphTeamsAppInstallation;
        });
    }
}
