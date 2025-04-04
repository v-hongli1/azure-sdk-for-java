// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.databoxedge.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Trigger Kind.
 */
public final class TriggerEventType extends ExpandableStringEnum<TriggerEventType> {
    /**
     * Static value FileEvent for TriggerEventType.
     */
    public static final TriggerEventType FILE_EVENT = fromString("FileEvent");

    /**
     * Static value PeriodicTimerEvent for TriggerEventType.
     */
    public static final TriggerEventType PERIODIC_TIMER_EVENT = fromString("PeriodicTimerEvent");

    /**
     * Creates a new instance of TriggerEventType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TriggerEventType() {
    }

    /**
     * Creates or finds a TriggerEventType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding TriggerEventType.
     */
    public static TriggerEventType fromString(String name) {
        return fromString(name, TriggerEventType.class);
    }

    /**
     * Gets known TriggerEventType values.
     * 
     * @return known TriggerEventType values.
     */
    public static Collection<TriggerEventType> values() {
        return values(TriggerEventType.class);
    }
}
