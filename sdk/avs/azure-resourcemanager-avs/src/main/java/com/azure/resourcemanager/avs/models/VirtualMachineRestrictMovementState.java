// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Virtual Machine Restrict Movement state.
 */
public final class VirtualMachineRestrictMovementState
    extends ExpandableStringEnum<VirtualMachineRestrictMovementState> {
    /**
     * is enabled.
     */
    public static final VirtualMachineRestrictMovementState ENABLED = fromString("Enabled");

    /**
     * is disabled.
     */
    public static final VirtualMachineRestrictMovementState DISABLED = fromString("Disabled");

    /**
     * Creates a new instance of VirtualMachineRestrictMovementState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public VirtualMachineRestrictMovementState() {
    }

    /**
     * Creates or finds a VirtualMachineRestrictMovementState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding VirtualMachineRestrictMovementState.
     */
    public static VirtualMachineRestrictMovementState fromString(String name) {
        return fromString(name, VirtualMachineRestrictMovementState.class);
    }

    /**
     * Gets known VirtualMachineRestrictMovementState values.
     * 
     * @return known VirtualMachineRestrictMovementState values.
     */
    public static Collection<VirtualMachineRestrictMovementState> values() {
        return values(VirtualMachineRestrictMovementState.class);
    }
}
