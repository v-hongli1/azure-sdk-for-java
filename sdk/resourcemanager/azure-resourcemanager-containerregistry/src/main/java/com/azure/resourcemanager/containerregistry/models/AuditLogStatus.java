// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerregistry.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Indicates whether audit logs are enabled on the connected registry.
 */
public final class AuditLogStatus extends ExpandableStringEnum<AuditLogStatus> {
    /**
     * Static value Enabled for AuditLogStatus.
     */
    public static final AuditLogStatus ENABLED = fromString("Enabled");

    /**
     * Static value Disabled for AuditLogStatus.
     */
    public static final AuditLogStatus DISABLED = fromString("Disabled");

    /**
     * Creates a new instance of AuditLogStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public AuditLogStatus() {
    }

    /**
     * Creates or finds a AuditLogStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding AuditLogStatus.
     */
    public static AuditLogStatus fromString(String name) {
        return fromString(name, AuditLogStatus.class);
    }

    /**
     * Gets known AuditLogStatus values.
     * 
     * @return known AuditLogStatus values.
     */
    public static Collection<AuditLogStatus> values() {
        return values(AuditLogStatus.class);
    }
}
