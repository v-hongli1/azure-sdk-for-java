// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Clone type enum.
 */
public final class CloneType extends ExpandableStringEnum<CloneType> {
    /**
     * Full clone.
     */
    public static final CloneType FULL = fromString("Full");

    /**
     * Metadata only.
     */
    public static final CloneType METADATA = fromString("Metadata");

    /**
     * Creates a new instance of CloneType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public CloneType() {
    }

    /**
     * Creates or finds a CloneType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding CloneType.
     */
    public static CloneType fromString(String name) {
        return fromString(name, CloneType.class);
    }

    /**
     * Gets known CloneType values.
     * 
     * @return known CloneType values.
     */
    public static Collection<CloneType> values() {
        return values(CloneType.class);
    }
}
