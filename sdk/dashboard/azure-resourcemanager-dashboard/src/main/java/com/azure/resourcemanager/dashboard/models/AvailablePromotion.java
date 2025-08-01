// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dashboard.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for AvailablePromotion.
 */
public final class AvailablePromotion extends ExpandableStringEnum<AvailablePromotion> {
    /**
     * Static value None for AvailablePromotion.
     */
    public static final AvailablePromotion NONE = fromString("None");

    /**
     * Static value FreeTrial for AvailablePromotion.
     */
    public static final AvailablePromotion FREE_TRIAL = fromString("FreeTrial");

    /**
     * Creates a new instance of AvailablePromotion value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AvailablePromotion() {
    }

    /**
     * Creates or finds a AvailablePromotion from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AvailablePromotion.
     */
    public static AvailablePromotion fromString(String name) {
        return fromString(name, AvailablePromotion.class);
    }

    /**
     * Gets known AvailablePromotion values.
     * 
     * @return known AvailablePromotion values.
     */
    public static Collection<AvailablePromotion> values() {
        return values(AvailablePromotion.class);
    }
}
