// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resources.models;

import com.azure.core.annotation.Fluent;
import com.azure.resourcemanager.resources.fluent.models.PolicyAssignmentUpdateProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;

/**
 * The policy assignment for Patch request.
 */
@Fluent
public final class PolicyAssignmentUpdate {
    /*
     * The policy assignment properties for Patch request.
     */
    @JsonProperty(value = "properties")
    private PolicyAssignmentUpdateProperties innerProperties;

    /*
     * The location of the policy assignment. Only required when utilizing managed identity.
     */
    @JsonProperty(value = "location")
    private String location;

    /*
     * The managed identity associated with the policy assignment.
     */
    @JsonProperty(value = "identity")
    private Identity identity;

    /**
     * Creates an instance of PolicyAssignmentUpdate class.
     */
    public PolicyAssignmentUpdate() {
    }

    /**
     * Get the innerProperties property: The policy assignment properties for Patch request.
     * 
     * @return the innerProperties value.
     */
    private PolicyAssignmentUpdateProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the location property: The location of the policy assignment. Only required when utilizing managed identity.
     * 
     * @return the location value.
     */
    public String location() {
        return this.location;
    }

    /**
     * Set the location property: The location of the policy assignment. Only required when utilizing managed identity.
     * 
     * @param location the location value to set.
     * @return the PolicyAssignmentUpdate object itself.
     */
    public PolicyAssignmentUpdate withLocation(String location) {
        this.location = location;
        return this;
    }

    /**
     * Get the identity property: The managed identity associated with the policy assignment.
     * 
     * @return the identity value.
     */
    public Identity identity() {
        return this.identity;
    }

    /**
     * Set the identity property: The managed identity associated with the policy assignment.
     * 
     * @param identity the identity value to set.
     * @return the PolicyAssignmentUpdate object itself.
     */
    public PolicyAssignmentUpdate withIdentity(Identity identity) {
        this.identity = identity;
        return this;
    }

    /**
     * Get the resourceSelectors property: The resource selector list to filter policies by resource properties.
     * 
     * @return the resourceSelectors value.
     */
    public List<ResourceSelector> resourceSelectors() {
        return this.innerProperties() == null ? null : this.innerProperties().resourceSelectors();
    }

    /**
     * Set the resourceSelectors property: The resource selector list to filter policies by resource properties.
     * 
     * @param resourceSelectors the resourceSelectors value to set.
     * @return the PolicyAssignmentUpdate object itself.
     */
    public PolicyAssignmentUpdate withResourceSelectors(List<ResourceSelector> resourceSelectors) {
        if (this.innerProperties() == null) {
            this.innerProperties = new PolicyAssignmentUpdateProperties();
        }
        this.innerProperties().withResourceSelectors(resourceSelectors);
        return this;
    }

    /**
     * Get the overrides property: The policy property value override.
     * 
     * @return the overrides value.
     */
    public List<OverrideModel> overrides() {
        return this.innerProperties() == null ? null : this.innerProperties().overrides();
    }

    /**
     * Set the overrides property: The policy property value override.
     * 
     * @param overrides the overrides value to set.
     * @return the PolicyAssignmentUpdate object itself.
     */
    public PolicyAssignmentUpdate withOverrides(List<OverrideModel> overrides) {
        if (this.innerProperties() == null) {
            this.innerProperties = new PolicyAssignmentUpdateProperties();
        }
        this.innerProperties().withOverrides(overrides);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
        if (identity() != null) {
            identity().validate();
        }
    }
}
