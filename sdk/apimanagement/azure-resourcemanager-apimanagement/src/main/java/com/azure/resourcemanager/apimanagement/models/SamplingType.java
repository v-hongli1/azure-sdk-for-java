// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Sampling type.
 */
public final class SamplingType extends ExpandableStringEnum<SamplingType> {
    /**
     * Static value fixed for SamplingType.
     */
    public static final SamplingType FIXED = fromString("fixed");

    /**
     * Creates a new instance of SamplingType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SamplingType() {
    }

    /**
     * Creates or finds a SamplingType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SamplingType.
     */
    public static SamplingType fromString(String name) {
        return fromString(name, SamplingType.class);
    }

    /**
     * Gets known SamplingType values.
     * 
     * @return known SamplingType values.
     */
    public static Collection<SamplingType> values() {
        return values(SamplingType.class);
    }
}
