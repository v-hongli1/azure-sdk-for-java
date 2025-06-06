// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The high availability type (AvailabilitySet or AvailabilityZone).
 */
public final class SapHighAvailabilityType extends ExpandableStringEnum<SapHighAvailabilityType> {
    /**
     * HA deployment with availability sets.
     */
    public static final SapHighAvailabilityType AVAILABILITY_SET = fromString("AvailabilitySet");

    /**
     * HA deployment with availability zones.
     */
    public static final SapHighAvailabilityType AVAILABILITY_ZONE = fromString("AvailabilityZone");

    /**
     * Creates a new instance of SapHighAvailabilityType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public SapHighAvailabilityType() {
    }

    /**
     * Creates or finds a SapHighAvailabilityType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SapHighAvailabilityType.
     */
    public static SapHighAvailabilityType fromString(String name) {
        return fromString(name, SapHighAvailabilityType.class);
    }

    /**
     * Gets known SapHighAvailabilityType values.
     * 
     * @return known SapHighAvailabilityType values.
     */
    public static Collection<SapHighAvailabilityType> values() {
        return values(SapHighAvailabilityType.class);
    }
}
