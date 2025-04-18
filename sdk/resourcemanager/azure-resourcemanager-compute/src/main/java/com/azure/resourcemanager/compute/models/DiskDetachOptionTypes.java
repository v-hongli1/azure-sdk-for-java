// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.compute.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Specifies the detach behavior to be used while detaching a disk or which is already in the process of detachment from
 * the virtual machine. Supported values are: **ForceDetach.** detachOption: **ForceDetach** is applicable only for
 * managed data disks. If a previous detachment attempt of the data disk did not complete due to an unexpected failure
 * from the virtual machine and the disk is still not released then use force-detach as a last resort option to detach
 * the disk forcibly from the VM. All writes might not have been flushed when using this detach behavior. To
 * force-detach a data disk update toBeDetached to 'true' along with setting detachOption: 'ForceDetach'.
 */
public final class DiskDetachOptionTypes extends ExpandableStringEnum<DiskDetachOptionTypes> {
    /**
     * Static value ForceDetach for DiskDetachOptionTypes.
     */
    public static final DiskDetachOptionTypes FORCE_DETACH = fromString("ForceDetach");

    /**
     * Creates a new instance of DiskDetachOptionTypes value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DiskDetachOptionTypes() {
    }

    /**
     * Creates or finds a DiskDetachOptionTypes from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DiskDetachOptionTypes.
     */
    public static DiskDetachOptionTypes fromString(String name) {
        return fromString(name, DiskDetachOptionTypes.class);
    }

    /**
     * Gets known DiskDetachOptionTypes values.
     * 
     * @return known DiskDetachOptionTypes values.
     */
    public static Collection<DiskDetachOptionTypes> values() {
        return values(DiskDetachOptionTypes.class);
    }
}
