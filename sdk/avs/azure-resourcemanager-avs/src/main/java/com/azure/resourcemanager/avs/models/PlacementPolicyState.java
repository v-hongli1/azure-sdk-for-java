// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Placement Policy state.
 */
public final class PlacementPolicyState extends ExpandableStringEnum<PlacementPolicyState> {
    /**
     * is enabled.
     */
    public static final PlacementPolicyState ENABLED = fromString("Enabled");

    /**
     * is disabled.
     */
    public static final PlacementPolicyState DISABLED = fromString("Disabled");

    /**
     * Creates a new instance of PlacementPolicyState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public PlacementPolicyState() {
    }

    /**
     * Creates or finds a PlacementPolicyState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding PlacementPolicyState.
     */
    public static PlacementPolicyState fromString(String name) {
        return fromString(name, PlacementPolicyState.class);
    }

    /**
     * Gets known PlacementPolicyState values.
     * 
     * @return known PlacementPolicyState values.
     */
    public static Collection<PlacementPolicyState> values() {
        return values(PlacementPolicyState.class);
    }
}
