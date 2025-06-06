// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Database type enum.
 */
public final class DataBaseType extends ExpandableStringEnum<DataBaseType> {
    /**
     * Regular DB.
     */
    public static final DataBaseType REGULAR = fromString("Regular");

    /**
     * Clone DB.
     */
    public static final DataBaseType CLONE = fromString("Clone");

    /**
     * Clone DB from backup timestamp.
     */
    public static final DataBaseType CLONE_FROM_BACKUP_TIMESTAMP = fromString("CloneFromBackupTimestamp");

    /**
     * Cross Region Disaster Recovery.
     */
    public static final DataBaseType CROSS_REGION_DISASTER_RECOVERY = fromString("CrossRegionDisasterRecovery");

    /**
     * Creates a new instance of DataBaseType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DataBaseType() {
    }

    /**
     * Creates or finds a DataBaseType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DataBaseType.
     */
    public static DataBaseType fromString(String name) {
        return fromString(name, DataBaseType.class);
    }

    /**
     * Gets known DataBaseType values.
     * 
     * @return known DataBaseType values.
     */
    public static Collection<DataBaseType> values() {
        return values(DataBaseType.class);
    }
}
