// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * mount option.
 */
public final class MountOptionEnum extends ExpandableStringEnum<MountOptionEnum> {
    /**
     * is mount.
     */
    public static final MountOptionEnum MOUNT = fromString("MOUNT");

    /**
     * is attach.
     */
    public static final MountOptionEnum ATTACH = fromString("ATTACH");

    /**
     * Creates a new instance of MountOptionEnum value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public MountOptionEnum() {
    }

    /**
     * Creates or finds a MountOptionEnum from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MountOptionEnum.
     */
    public static MountOptionEnum fromString(String name) {
        return fromString(name, MountOptionEnum.class);
    }

    /**
     * Gets known MountOptionEnum values.
     * 
     * @return known MountOptionEnum values.
     */
    public static Collection<MountOptionEnum> values() {
        return values(MountOptionEnum.class);
    }
}
