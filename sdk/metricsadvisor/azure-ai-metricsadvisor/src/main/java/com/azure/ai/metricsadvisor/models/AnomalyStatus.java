// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * anomaly status
 * 
 * only return for alerting anomaly result.
 */
public final class AnomalyStatus extends ExpandableStringEnum<AnomalyStatus> {
    /**
     * Static value Active for AnomalyStatus.
     */
    @Generated
    public static final AnomalyStatus ACTIVE = fromString("Active");

    /**
     * Static value Resolved for AnomalyStatus.
     */
    @Generated
    public static final AnomalyStatus RESOLVED = fromString("Resolved");

    /**
     * Creates a new instance of AnomalyStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public AnomalyStatus() {
    }

    /**
     * Creates or finds a AnomalyStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AnomalyStatus.
     */
    @Generated
    public static AnomalyStatus fromString(String name) {
        return fromString(name, AnomalyStatus.class);
    }

    /**
     * Gets known AnomalyStatus values.
     * 
     * @return known AnomalyStatus values.
     */
    @Generated
    public static Collection<AnomalyStatus> values() {
        return values(AnomalyStatus.class);
    }
}
