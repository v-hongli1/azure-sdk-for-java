// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.vmwarecloudsimple.models;

/**
 * Azure Resource type.
 */
public enum PrivateCloudResourceType {
    /**
     * Enum value Microsoft.VMwareCloudSimple/privateClouds.
     */
    MICROSOFT_VMWARE_CLOUD_SIMPLE_PRIVATE_CLOUDS("Microsoft.VMwareCloudSimple/privateClouds");

    /**
     * The actual serialized value for a PrivateCloudResourceType instance.
     */
    private final String value;

    PrivateCloudResourceType(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a PrivateCloudResourceType instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed PrivateCloudResourceType object, or null if unable to parse.
     */
    public static PrivateCloudResourceType fromString(String value) {
        if (value == null) {
            return null;
        }
        PrivateCloudResourceType[] items = PrivateCloudResourceType.values();
        for (PrivateCloudResourceType item : items) {
            if (item.toString().equalsIgnoreCase(value)) {
                return item;
            }
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return this.value;
    }
}
