// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.oep.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/** The EnergyServiceProperties model. */
@Fluent
public final class EnergyServiceProperties {
    @JsonIgnore private final ClientLogger logger = new ClientLogger(EnergyServiceProperties.class);

    /*
     * The dnsName property.
     */
    @JsonProperty(value = "dnsName", access = JsonProperty.Access.WRITE_ONLY)
    private String dnsName;

    /*
     * The provisioningState property.
     */
    @JsonProperty(value = "provisioningState", access = JsonProperty.Access.WRITE_ONLY)
    private ProvisioningState provisioningState;

    /*
     * The authAppId property.
     */
    @JsonProperty(value = "authAppId")
    private String authAppId;

    /*
     * The dataPartitionNames property.
     */
    @JsonProperty(value = "dataPartitionNames")
    private List<DataPartitionNames> dataPartitionNames;

    /**
     * Get the dnsName property: The dnsName property.
     *
     * @return the dnsName value.
     */
    public String dnsName() {
        return this.dnsName;
    }

    /**
     * Get the provisioningState property: The provisioningState property.
     *
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the authAppId property: The authAppId property.
     *
     * @return the authAppId value.
     */
    public String authAppId() {
        return this.authAppId;
    }

    /**
     * Set the authAppId property: The authAppId property.
     *
     * @param authAppId the authAppId value to set.
     * @return the EnergyServiceProperties object itself.
     */
    public EnergyServiceProperties withAuthAppId(String authAppId) {
        this.authAppId = authAppId;
        return this;
    }

    /**
     * Get the dataPartitionNames property: The dataPartitionNames property.
     *
     * @return the dataPartitionNames value.
     */
    public List<DataPartitionNames> dataPartitionNames() {
        return this.dataPartitionNames;
    }

    /**
     * Set the dataPartitionNames property: The dataPartitionNames property.
     *
     * @param dataPartitionNames the dataPartitionNames value to set.
     * @return the EnergyServiceProperties object itself.
     */
    public EnergyServiceProperties withDataPartitionNames(List<DataPartitionNames> dataPartitionNames) {
        this.dataPartitionNames = dataPartitionNames;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dataPartitionNames() != null) {
            dataPartitionNames().forEach(e -> e.validate());
        }
    }
}
