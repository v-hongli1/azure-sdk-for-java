// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databox.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.resourcemanager.databox.models.AddressValidationProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/** Output of the address validation api. */
@Immutable
public final class AddressValidationOutputInner {
    /*
     * The address validation properties.
     */
    @JsonProperty(value = "properties", access = JsonProperty.Access.WRITE_ONLY)
    private AddressValidationProperties properties;

    /** Creates an instance of AddressValidationOutputInner class. */
    public AddressValidationOutputInner() {
    }

    /**
     * Get the properties property: The address validation properties.
     *
     * @return the properties value.
     */
    public AddressValidationProperties properties() {
        return this.properties;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (properties() != null) {
            properties().validate();
        }
    }
}
