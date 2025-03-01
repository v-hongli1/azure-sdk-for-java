// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabric.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.servicefabric.models.ApplicationMetricDescription;
import com.azure.resourcemanager.servicefabric.models.ApplicationUpgradePolicy;
import com.azure.resourcemanager.servicefabric.models.ApplicationUserAssignedIdentity;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * The application resource properties for patch operations.
 */
@Fluent
public class ApplicationResourceUpdateProperties implements JsonSerializable<ApplicationResourceUpdateProperties> {
    /*
     * The version of the application type as defined in the application manifest.
     */
    private String typeVersion;

    /*
     * List of application parameters with overridden values from their default values specified in the application
     * manifest.
     */
    private Map<String, String> parameters;

    /*
     * Describes the policy for a monitored application upgrade.
     */
    private ApplicationUpgradePolicy upgradePolicy;

    /*
     * The minimum number of nodes where Service Fabric will reserve capacity for this application. Note that this does
     * not mean that the services of this application will be placed on all of those nodes. If this property is set to
     * zero, no capacity will be reserved. The value of this property cannot be more than the value of the MaximumNodes
     * property.
     */
    private Long minimumNodes;

    /*
     * The maximum number of nodes where Service Fabric will reserve capacity for this application. Note that this does
     * not mean that the services of this application will be placed on all of those nodes. By default, the value of
     * this property is zero and it means that the services can be placed on any node.
     */
    private Long maximumNodes;

    /*
     * Remove the current application capacity settings.
     */
    private Boolean removeApplicationCapacity;

    /*
     * List of application capacity metric description.
     */
    private List<ApplicationMetricDescription> metrics;

    /*
     * List of user assigned identities for the application, each mapped to a friendly name.
     */
    private List<ApplicationUserAssignedIdentity> managedIdentities;

    /**
     * Creates an instance of ApplicationResourceUpdateProperties class.
     */
    public ApplicationResourceUpdateProperties() {
    }

    /**
     * Get the typeVersion property: The version of the application type as defined in the application manifest.
     * 
     * @return the typeVersion value.
     */
    public String typeVersion() {
        return this.typeVersion;
    }

    /**
     * Set the typeVersion property: The version of the application type as defined in the application manifest.
     * 
     * @param typeVersion the typeVersion value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withTypeVersion(String typeVersion) {
        this.typeVersion = typeVersion;
        return this;
    }

    /**
     * Get the parameters property: List of application parameters with overridden values from their default values
     * specified in the application manifest.
     * 
     * @return the parameters value.
     */
    public Map<String, String> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: List of application parameters with overridden values from their default values
     * specified in the application manifest.
     * 
     * @param parameters the parameters value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the upgradePolicy property: Describes the policy for a monitored application upgrade.
     * 
     * @return the upgradePolicy value.
     */
    public ApplicationUpgradePolicy upgradePolicy() {
        return this.upgradePolicy;
    }

    /**
     * Set the upgradePolicy property: Describes the policy for a monitored application upgrade.
     * 
     * @param upgradePolicy the upgradePolicy value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withUpgradePolicy(ApplicationUpgradePolicy upgradePolicy) {
        this.upgradePolicy = upgradePolicy;
        return this;
    }

    /**
     * Get the minimumNodes property: The minimum number of nodes where Service Fabric will reserve capacity for this
     * application. Note that this does not mean that the services of this application will be placed on all of those
     * nodes. If this property is set to zero, no capacity will be reserved. The value of this property cannot be more
     * than the value of the MaximumNodes property.
     * 
     * @return the minimumNodes value.
     */
    public Long minimumNodes() {
        return this.minimumNodes;
    }

    /**
     * Set the minimumNodes property: The minimum number of nodes where Service Fabric will reserve capacity for this
     * application. Note that this does not mean that the services of this application will be placed on all of those
     * nodes. If this property is set to zero, no capacity will be reserved. The value of this property cannot be more
     * than the value of the MaximumNodes property.
     * 
     * @param minimumNodes the minimumNodes value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withMinimumNodes(Long minimumNodes) {
        this.minimumNodes = minimumNodes;
        return this;
    }

    /**
     * Get the maximumNodes property: The maximum number of nodes where Service Fabric will reserve capacity for this
     * application. Note that this does not mean that the services of this application will be placed on all of those
     * nodes. By default, the value of this property is zero and it means that the services can be placed on any node.
     * 
     * @return the maximumNodes value.
     */
    public Long maximumNodes() {
        return this.maximumNodes;
    }

    /**
     * Set the maximumNodes property: The maximum number of nodes where Service Fabric will reserve capacity for this
     * application. Note that this does not mean that the services of this application will be placed on all of those
     * nodes. By default, the value of this property is zero and it means that the services can be placed on any node.
     * 
     * @param maximumNodes the maximumNodes value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withMaximumNodes(Long maximumNodes) {
        this.maximumNodes = maximumNodes;
        return this;
    }

    /**
     * Get the removeApplicationCapacity property: Remove the current application capacity settings.
     * 
     * @return the removeApplicationCapacity value.
     */
    public Boolean removeApplicationCapacity() {
        return this.removeApplicationCapacity;
    }

    /**
     * Set the removeApplicationCapacity property: Remove the current application capacity settings.
     * 
     * @param removeApplicationCapacity the removeApplicationCapacity value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withRemoveApplicationCapacity(Boolean removeApplicationCapacity) {
        this.removeApplicationCapacity = removeApplicationCapacity;
        return this;
    }

    /**
     * Get the metrics property: List of application capacity metric description.
     * 
     * @return the metrics value.
     */
    public List<ApplicationMetricDescription> metrics() {
        return this.metrics;
    }

    /**
     * Set the metrics property: List of application capacity metric description.
     * 
     * @param metrics the metrics value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties withMetrics(List<ApplicationMetricDescription> metrics) {
        this.metrics = metrics;
        return this;
    }

    /**
     * Get the managedIdentities property: List of user assigned identities for the application, each mapped to a
     * friendly name.
     * 
     * @return the managedIdentities value.
     */
    public List<ApplicationUserAssignedIdentity> managedIdentities() {
        return this.managedIdentities;
    }

    /**
     * Set the managedIdentities property: List of user assigned identities for the application, each mapped to a
     * friendly name.
     * 
     * @param managedIdentities the managedIdentities value to set.
     * @return the ApplicationResourceUpdateProperties object itself.
     */
    public ApplicationResourceUpdateProperties
        withManagedIdentities(List<ApplicationUserAssignedIdentity> managedIdentities) {
        this.managedIdentities = managedIdentities;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (upgradePolicy() != null) {
            upgradePolicy().validate();
        }
        if (metrics() != null) {
            metrics().forEach(e -> e.validate());
        }
        if (managedIdentities() != null) {
            managedIdentities().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("typeVersion", this.typeVersion);
        jsonWriter.writeMapField("parameters", this.parameters, (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("upgradePolicy", this.upgradePolicy);
        jsonWriter.writeNumberField("minimumNodes", this.minimumNodes);
        jsonWriter.writeNumberField("maximumNodes", this.maximumNodes);
        jsonWriter.writeBooleanField("removeApplicationCapacity", this.removeApplicationCapacity);
        jsonWriter.writeArrayField("metrics", this.metrics, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("managedIdentities", this.managedIdentities,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ApplicationResourceUpdateProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ApplicationResourceUpdateProperties if the JsonReader was pointing to an instance of it,
     * or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ApplicationResourceUpdateProperties.
     */
    public static ApplicationResourceUpdateProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ApplicationResourceUpdateProperties deserializedApplicationResourceUpdateProperties
                = new ApplicationResourceUpdateProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("typeVersion".equals(fieldName)) {
                    deserializedApplicationResourceUpdateProperties.typeVersion = reader.getString();
                } else if ("parameters".equals(fieldName)) {
                    Map<String, String> parameters = reader.readMap(reader1 -> reader1.getString());
                    deserializedApplicationResourceUpdateProperties.parameters = parameters;
                } else if ("upgradePolicy".equals(fieldName)) {
                    deserializedApplicationResourceUpdateProperties.upgradePolicy
                        = ApplicationUpgradePolicy.fromJson(reader);
                } else if ("minimumNodes".equals(fieldName)) {
                    deserializedApplicationResourceUpdateProperties.minimumNodes
                        = reader.getNullable(JsonReader::getLong);
                } else if ("maximumNodes".equals(fieldName)) {
                    deserializedApplicationResourceUpdateProperties.maximumNodes
                        = reader.getNullable(JsonReader::getLong);
                } else if ("removeApplicationCapacity".equals(fieldName)) {
                    deserializedApplicationResourceUpdateProperties.removeApplicationCapacity
                        = reader.getNullable(JsonReader::getBoolean);
                } else if ("metrics".equals(fieldName)) {
                    List<ApplicationMetricDescription> metrics
                        = reader.readArray(reader1 -> ApplicationMetricDescription.fromJson(reader1));
                    deserializedApplicationResourceUpdateProperties.metrics = metrics;
                } else if ("managedIdentities".equals(fieldName)) {
                    List<ApplicationUserAssignedIdentity> managedIdentities
                        = reader.readArray(reader1 -> ApplicationUserAssignedIdentity.fromJson(reader1));
                    deserializedApplicationResourceUpdateProperties.managedIdentities = managedIdentities;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedApplicationResourceUpdateProperties;
        });
    }
}
