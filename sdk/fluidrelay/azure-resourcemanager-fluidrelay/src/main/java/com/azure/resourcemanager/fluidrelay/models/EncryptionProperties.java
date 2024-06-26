// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.fluidrelay.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;

/** All encryption configuration for a resource. */
@Fluent
public final class EncryptionProperties {
    /*
     * All Customer-managed key encryption properties for the resource.
     */
    @JsonProperty(value = "customerManagedKeyEncryption")
    private CustomerManagedKeyEncryptionProperties customerManagedKeyEncryption;

    /**
     * Get the customerManagedKeyEncryption property: All Customer-managed key encryption properties for the resource.
     *
     * @return the customerManagedKeyEncryption value.
     */
    public CustomerManagedKeyEncryptionProperties customerManagedKeyEncryption() {
        return this.customerManagedKeyEncryption;
    }

    /**
     * Set the customerManagedKeyEncryption property: All Customer-managed key encryption properties for the resource.
     *
     * @param customerManagedKeyEncryption the customerManagedKeyEncryption value to set.
     * @return the EncryptionProperties object itself.
     */
    public EncryptionProperties withCustomerManagedKeyEncryption(
        CustomerManagedKeyEncryptionProperties customerManagedKeyEncryption) {
        this.customerManagedKeyEncryption = customerManagedKeyEncryption;
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (customerManagedKeyEncryption() != null) {
            customerManagedKeyEncryption().validate();
        }
    }
}
