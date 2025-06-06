// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.resources.models.ParameterDefinitionsValue;
import com.azure.resourcemanager.resources.models.PolicyDefinitionGroup;
import com.azure.resourcemanager.resources.models.PolicyDefinitionReference;
import com.azure.resourcemanager.resources.models.PolicyType;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The policy set definition properties.
 */
@Fluent
public final class PolicySetDefinitionVersionProperties
    implements JsonSerializable<PolicySetDefinitionVersionProperties> {
    /*
     * The type of policy definition. Possible values are NotSpecified, BuiltIn, Custom, and Static.
     */
    private PolicyType policyType;

    /*
     * The display name of the policy set definition.
     */
    private String displayName;

    /*
     * The policy set definition description.
     */
    private String description;

    /*
     * The policy set definition metadata. Metadata is an open ended object and is typically a collection of key value
     * pairs.
     */
    private Object metadata;

    /*
     * The policy set definition parameters that can be used in policy definition references.
     */
    private Map<String, ParameterDefinitionsValue> parameters;

    /*
     * An array of policy definition references.
     */
    private List<PolicyDefinitionReference> policyDefinitions;

    /*
     * The metadata describing groups of policy definition references within the policy set definition.
     */
    private List<PolicyDefinitionGroup> policyDefinitionGroups;

    /*
     * The policy set definition version in #.#.# format.
     */
    private String version;

    /**
     * Creates an instance of PolicySetDefinitionVersionProperties class.
     */
    public PolicySetDefinitionVersionProperties() {
    }

    /**
     * Get the policyType property: The type of policy definition. Possible values are NotSpecified, BuiltIn, Custom,
     * and Static.
     * 
     * @return the policyType value.
     */
    public PolicyType policyType() {
        return this.policyType;
    }

    /**
     * Set the policyType property: The type of policy definition. Possible values are NotSpecified, BuiltIn, Custom,
     * and Static.
     * 
     * @param policyType the policyType value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withPolicyType(PolicyType policyType) {
        this.policyType = policyType;
        return this;
    }

    /**
     * Get the displayName property: The display name of the policy set definition.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The display name of the policy set definition.
     * 
     * @param displayName the displayName value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the description property: The policy set definition description.
     * 
     * @return the description value.
     */
    public String description() {
        return this.description;
    }

    /**
     * Set the description property: The policy set definition description.
     * 
     * @param description the description value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     * Get the metadata property: The policy set definition metadata. Metadata is an open ended object and is typically
     * a collection of key value pairs.
     * 
     * @return the metadata value.
     */
    public Object metadata() {
        return this.metadata;
    }

    /**
     * Set the metadata property: The policy set definition metadata. Metadata is an open ended object and is typically
     * a collection of key value pairs.
     * 
     * @param metadata the metadata value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withMetadata(Object metadata) {
        this.metadata = metadata;
        return this;
    }

    /**
     * Get the parameters property: The policy set definition parameters that can be used in policy definition
     * references.
     * 
     * @return the parameters value.
     */
    public Map<String, ParameterDefinitionsValue> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: The policy set definition parameters that can be used in policy definition
     * references.
     * 
     * @param parameters the parameters value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withParameters(Map<String, ParameterDefinitionsValue> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the policyDefinitions property: An array of policy definition references.
     * 
     * @return the policyDefinitions value.
     */
    public List<PolicyDefinitionReference> policyDefinitions() {
        return this.policyDefinitions;
    }

    /**
     * Set the policyDefinitions property: An array of policy definition references.
     * 
     * @param policyDefinitions the policyDefinitions value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties
        withPolicyDefinitions(List<PolicyDefinitionReference> policyDefinitions) {
        this.policyDefinitions = policyDefinitions;
        return this;
    }

    /**
     * Get the policyDefinitionGroups property: The metadata describing groups of policy definition references within
     * the policy set definition.
     * 
     * @return the policyDefinitionGroups value.
     */
    public List<PolicyDefinitionGroup> policyDefinitionGroups() {
        return this.policyDefinitionGroups;
    }

    /**
     * Set the policyDefinitionGroups property: The metadata describing groups of policy definition references within
     * the policy set definition.
     * 
     * @param policyDefinitionGroups the policyDefinitionGroups value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties
        withPolicyDefinitionGroups(List<PolicyDefinitionGroup> policyDefinitionGroups) {
        this.policyDefinitionGroups = policyDefinitionGroups;
        return this;
    }

    /**
     * Get the version property: The policy set definition version in #.#.# format.
     * 
     * @return the version value.
     */
    public String version() {
        return this.version;
    }

    /**
     * Set the version property: The policy set definition version in #.#.# format.
     * 
     * @param version the version value to set.
     * @return the PolicySetDefinitionVersionProperties object itself.
     */
    public PolicySetDefinitionVersionProperties withVersion(String version) {
        this.version = version;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
        if (policyDefinitions() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property policyDefinitions in model PolicySetDefinitionVersionProperties"));
        } else {
            policyDefinitions().forEach(e -> e.validate());
        }
        if (policyDefinitionGroups() != null) {
            policyDefinitionGroups().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PolicySetDefinitionVersionProperties.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("policyDefinitions", this.policyDefinitions,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("policyType", this.policyType == null ? null : this.policyType.toString());
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("description", this.description);
        if (this.metadata != null) {
            jsonWriter.writeUntypedField("metadata", this.metadata);
        }
        jsonWriter.writeMapField("parameters", this.parameters, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("policyDefinitionGroups", this.policyDefinitionGroups,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("version", this.version);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PolicySetDefinitionVersionProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PolicySetDefinitionVersionProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PolicySetDefinitionVersionProperties.
     */
    public static PolicySetDefinitionVersionProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PolicySetDefinitionVersionProperties deserializedPolicySetDefinitionVersionProperties
                = new PolicySetDefinitionVersionProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("policyDefinitions".equals(fieldName)) {
                    List<PolicyDefinitionReference> policyDefinitions
                        = reader.readArray(reader1 -> PolicyDefinitionReference.fromJson(reader1));
                    deserializedPolicySetDefinitionVersionProperties.policyDefinitions = policyDefinitions;
                } else if ("policyType".equals(fieldName)) {
                    deserializedPolicySetDefinitionVersionProperties.policyType
                        = PolicyType.fromString(reader.getString());
                } else if ("displayName".equals(fieldName)) {
                    deserializedPolicySetDefinitionVersionProperties.displayName = reader.getString();
                } else if ("description".equals(fieldName)) {
                    deserializedPolicySetDefinitionVersionProperties.description = reader.getString();
                } else if ("metadata".equals(fieldName)) {
                    deserializedPolicySetDefinitionVersionProperties.metadata = reader.readUntyped();
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterDefinitionsValue> parameters
                        = reader.readMap(reader1 -> ParameterDefinitionsValue.fromJson(reader1));
                    deserializedPolicySetDefinitionVersionProperties.parameters = parameters;
                } else if ("policyDefinitionGroups".equals(fieldName)) {
                    List<PolicyDefinitionGroup> policyDefinitionGroups
                        = reader.readArray(reader1 -> PolicyDefinitionGroup.fromJson(reader1));
                    deserializedPolicySetDefinitionVersionProperties.policyDefinitionGroups = policyDefinitionGroups;
                } else if ("version".equals(fieldName)) {
                    deserializedPolicySetDefinitionVersionProperties.version = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPolicySetDefinitionVersionProperties;
        });
    }
}
