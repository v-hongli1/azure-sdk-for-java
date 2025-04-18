// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mobilenetwork.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The supported NAS Encryption types.
 */
public final class NasEncryptionType extends ExpandableStringEnum<NasEncryptionType> {
    /**
     * Static value NEA0/EEA0 for NasEncryptionType.
     */
    public static final NasEncryptionType NEA0_EEA0 = fromString("NEA0/EEA0");

    /**
     * Static value NEA1/EEA1 for NasEncryptionType.
     */
    public static final NasEncryptionType NEA1_EEA1 = fromString("NEA1/EEA1");

    /**
     * Static value NEA2/EEA2 for NasEncryptionType.
     */
    public static final NasEncryptionType NEA2_EEA2 = fromString("NEA2/EEA2");

    /**
     * Creates a new instance of NasEncryptionType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public NasEncryptionType() {
    }

    /**
     * Creates or finds a NasEncryptionType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding NasEncryptionType.
     */
    public static NasEncryptionType fromString(String name) {
        return fromString(name, NasEncryptionType.class);
    }

    /**
     * Gets known NasEncryptionType values.
     * 
     * @return known NasEncryptionType values.
     */
    public static Collection<NasEncryptionType> values() {
        return values(NasEncryptionType.class);
    }
}
