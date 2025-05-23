// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Mode of Migration to stv2. Default is PreserveIp.
 */
public final class MigrateToStv2Mode extends ExpandableStringEnum<MigrateToStv2Mode> {
    /**
     * Static value PreserveIp for MigrateToStv2Mode.
     */
    public static final MigrateToStv2Mode PRESERVE_IP = fromString("PreserveIp");

    /**
     * Static value NewIP for MigrateToStv2Mode.
     */
    public static final MigrateToStv2Mode NEW_IP = fromString("NewIP");

    /**
     * Creates a new instance of MigrateToStv2Mode value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MigrateToStv2Mode() {
    }

    /**
     * Creates or finds a MigrateToStv2Mode from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MigrateToStv2Mode.
     */
    public static MigrateToStv2Mode fromString(String name) {
        return fromString(name, MigrateToStv2Mode.class);
    }

    /**
     * Gets known MigrateToStv2Mode values.
     * 
     * @return known MigrateToStv2Mode values.
     */
    public static Collection<MigrateToStv2Mode> values() {
        return values(MigrateToStv2Mode.class);
    }
}
