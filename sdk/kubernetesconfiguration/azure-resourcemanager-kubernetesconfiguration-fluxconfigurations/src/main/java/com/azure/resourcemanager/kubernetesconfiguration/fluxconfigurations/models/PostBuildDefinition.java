// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The postBuild definitions defining variable substitutions for this Kustomization after kustomize build.
 */
@Fluent
public final class PostBuildDefinition implements JsonSerializable<PostBuildDefinition> {
    /*
     * Key/value pairs holding the variables to be substituted in this Kustomization.
     */
    private Map<String, String> substitute;

    /*
     * Array of ConfigMaps/Secrets from which the variables are substituted for this Kustomization.
     */
    private List<SubstituteFromDefinition> substituteFrom;

    /**
     * Creates an instance of PostBuildDefinition class.
     */
    public PostBuildDefinition() {
    }

    /**
     * Get the substitute property: Key/value pairs holding the variables to be substituted in this Kustomization.
     * 
     * @return the substitute value.
     */
    public Map<String, String> substitute() {
        return this.substitute;
    }

    /**
     * Set the substitute property: Key/value pairs holding the variables to be substituted in this Kustomization.
     * 
     * @param substitute the substitute value to set.
     * @return the PostBuildDefinition object itself.
     */
    public PostBuildDefinition withSubstitute(Map<String, String> substitute) {
        this.substitute = substitute;
        return this;
    }

    /**
     * Get the substituteFrom property: Array of ConfigMaps/Secrets from which the variables are substituted for this
     * Kustomization.
     * 
     * @return the substituteFrom value.
     */
    public List<SubstituteFromDefinition> substituteFrom() {
        return this.substituteFrom;
    }

    /**
     * Set the substituteFrom property: Array of ConfigMaps/Secrets from which the variables are substituted for this
     * Kustomization.
     * 
     * @param substituteFrom the substituteFrom value to set.
     * @return the PostBuildDefinition object itself.
     */
    public PostBuildDefinition withSubstituteFrom(List<SubstituteFromDefinition> substituteFrom) {
        this.substituteFrom = substituteFrom;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (substituteFrom() != null) {
            substituteFrom().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("substitute", this.substitute, (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("substituteFrom", this.substituteFrom,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PostBuildDefinition from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PostBuildDefinition if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PostBuildDefinition.
     */
    public static PostBuildDefinition fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PostBuildDefinition deserializedPostBuildDefinition = new PostBuildDefinition();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("substitute".equals(fieldName)) {
                    Map<String, String> substitute = reader.readMap(reader1 -> reader1.getString());
                    deserializedPostBuildDefinition.substitute = substitute;
                } else if ("substituteFrom".equals(fieldName)) {
                    List<SubstituteFromDefinition> substituteFrom
                        = reader.readArray(reader1 -> SubstituteFromDefinition.fromJson(reader1));
                    deserializedPostBuildDefinition.substituteFrom = substituteFrom;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPostBuildDefinition;
        });
    }
}
