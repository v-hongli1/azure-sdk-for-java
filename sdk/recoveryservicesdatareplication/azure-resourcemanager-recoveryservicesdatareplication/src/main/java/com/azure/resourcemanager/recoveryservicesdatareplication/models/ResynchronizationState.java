// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Gets or sets the resynchronization state.
 */
public final class ResynchronizationState extends ExpandableStringEnum<ResynchronizationState> {
    /**
     * Resynchronization is not active.
     */
    public static final ResynchronizationState NONE = fromString("None");

    /**
     * Resynchronization has been initiated.
     */
    public static final ResynchronizationState RESYNCHRONIZATION_INITIATED = fromString("ResynchronizationInitiated");

    /**
     * Resynchronization has been completed successfully.
     */
    public static final ResynchronizationState RESYNCHRONIZATION_COMPLETED = fromString("ResynchronizationCompleted");

    /**
     * Resynchronization has failed and would need to be started again.
     */
    public static final ResynchronizationState RESYNCHRONIZATION_FAILED = fromString("ResynchronizationFailed");

    /**
     * Creates a new instance of ResynchronizationState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ResynchronizationState() {
    }

    /**
     * Creates or finds a ResynchronizationState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ResynchronizationState.
     */
    public static ResynchronizationState fromString(String name) {
        return fromString(name, ResynchronizationState.class);
    }

    /**
     * Gets known ResynchronizationState values.
     * 
     * @return known ResynchronizationState values.
     */
    public static Collection<ResynchronizationState> values() {
        return values(ResynchronizationState.class);
    }
}
