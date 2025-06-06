// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.share.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for NfsFileType.
 */
public final class NfsFileType extends ExpandableStringEnum<NfsFileType> {
    /**
     * Static value Regular for NfsFileType.
     */
    @Generated
    public static final NfsFileType REGULAR = fromString("Regular");

    /**
     * Static value Directory for NfsFileType.
     */
    @Generated
    public static final NfsFileType DIRECTORY = fromString("Directory");

    /**
     * Static value SymLink for NfsFileType.
     */
    @Generated
    public static final NfsFileType SYM_LINK = fromString("SymLink");

    /**
     * Creates a new instance of NfsFileType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public NfsFileType() {
    }

    /**
     * Creates or finds a NfsFileType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding NfsFileType.
     */
    @Generated
    public static NfsFileType fromString(String name) {
        return fromString(name, NfsFileType.class);
    }

    /**
     * Gets known NfsFileType values.
     * 
     * @return known NfsFileType values.
     */
    @Generated
    public static Collection<NfsFileType> values() {
        return values(NfsFileType.class);
    }
}
