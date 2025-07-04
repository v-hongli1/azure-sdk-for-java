// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The status for a storage task.
 * 
 * @deprecated This class is deprecated and may be removed in future releases. System events are now available in the
 * azure-messaging-eventgrid-systemevents package.
 */
@Deprecated
public final class StorageTaskCompletedStatus extends ExpandableStringEnum<StorageTaskCompletedStatus> {

    /**
     * Static value Succeeded for StorageTaskCompletedStatus.
     */
    @Generated
    public static final StorageTaskCompletedStatus SUCCEEDED = fromString("Succeeded");

    /**
     * Static value Failed for StorageTaskCompletedStatus.
     */
    @Generated
    public static final StorageTaskCompletedStatus FAILED = fromString("Failed");

    /**
     * Creates a new instance of StorageTaskCompletedStatus value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public StorageTaskCompletedStatus() {
    }

    /**
     * Creates or finds a StorageTaskCompletedStatus from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding StorageTaskCompletedStatus.
     */
    @Generated
    public static StorageTaskCompletedStatus fromString(String name) {
        return fromString(name, StorageTaskCompletedStatus.class);
    }

    /**
     * Gets known StorageTaskCompletedStatus values.
     *
     * @return known StorageTaskCompletedStatus values.
     */
    @Generated
    public static Collection<StorageTaskCompletedStatus> values() {
        return values(StorageTaskCompletedStatus.class);
    }
}
