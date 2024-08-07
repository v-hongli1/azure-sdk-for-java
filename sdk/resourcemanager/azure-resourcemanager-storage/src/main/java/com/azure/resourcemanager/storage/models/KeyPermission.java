// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storage.models;

/**
 * Permissions for the key -- read-only or full permissions.
 */
public enum KeyPermission {
    /**
     * Enum value Read.
     */
    READ("Read"),

    /**
     * Enum value Full.
     */
    FULL("Full");

    /**
     * The actual serialized value for a KeyPermission instance.
     */
    private final String value;

    KeyPermission(String value) {
        this.value = value;
    }

    /**
     * Parses a serialized value to a KeyPermission instance.
     * 
     * @param value the serialized value to parse.
     * @return the parsed KeyPermission object, or null if unable to parse.
     */
    public static KeyPermission fromString(String value) {
        if (value == null) {
            return null;
        }
        KeyPermission[] items = KeyPermission.values();
        for (KeyPermission item : items) {
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
