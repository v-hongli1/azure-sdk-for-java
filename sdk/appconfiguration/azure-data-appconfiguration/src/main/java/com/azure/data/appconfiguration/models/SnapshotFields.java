// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.data.appconfiguration.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for SnapshotFields.
 */
public final class SnapshotFields extends ExpandableStringEnum<SnapshotFields> {
    /**
     * Populates the snapshot 'name' from the service.
     */
    @Generated
    public static final SnapshotFields NAME = fromString("name");

    /**
     * Populates the snapshot 'status' from the service.
     */
    @Generated
    public static final SnapshotFields STATUS = fromString("status");

    /**
     * Populates the snapshot 'filters' from the service.
     */
    @Generated
    public static final SnapshotFields FILTERS = fromString("filters");

    /**
     * Populates the snapshot 'composition_type' from the service.
     */
    @Generated
    public static final SnapshotFields SNAPSHOT_COMPOSITION = fromString("composition_type");

    /**
     * Populates the snapshot 'created' from the service.
     */
    @Generated
    public static final SnapshotFields CREATED_AT = fromString("created");

    /**
     * Populates the snapshot 'expires' from the service.
     */
    @Generated
    public static final SnapshotFields EXPIRES_AT = fromString("expires");

    /**
     * Populates the snapshot 'retention_period' from the service.
     */
    @Generated
    public static final SnapshotFields RETENTION_PERIOD = fromString("retention_period");

    /**
     * Populates the snapshot 'items_count' from the service.
     */
    @Generated
    public static final SnapshotFields ITEM_COUNT = fromString("items_count");

    /**
     * Populates the snapshot 'size' from the service.
     */
    @Generated
    public static final SnapshotFields SIZE_IN_BYTES = fromString("size");

    /**
     * Populates the snapshot `etag` from the service.
     */
    @Generated
    public static final SnapshotFields ETAG = fromString("etag");

    /**
     * Populates the snapshot `tags` from the service.
     */
    @Generated
    public static final SnapshotFields TAGS = fromString("tags");

    /**
     * Creates a new instance of SnapshotFields value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public SnapshotFields() {
    }

    /**
     * Creates or finds a SnapshotFields from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SnapshotFields.
     */
    @Generated
    public static SnapshotFields fromString(String name) {
        return fromString(name, SnapshotFields.class);
    }

    /**
     * Gets known SnapshotFields values.
     * 
     * @return known SnapshotFields values.
     */
    @Generated
    public static Collection<SnapshotFields> values() {
        return values(SnapshotFields.class);
    }
}
