// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.monitor.query.implementation.metricsnamespaces.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Kind of namespace.
 */
public final class NamespaceClassification extends ExpandableStringEnum<NamespaceClassification> {
    /**
     * Static value Platform for NamespaceClassification.
     */
    @Generated
    public static final NamespaceClassification PLATFORM = fromString("Platform");

    /**
     * Static value Custom for NamespaceClassification.
     */
    @Generated
    public static final NamespaceClassification CUSTOM = fromString("Custom");

    /**
     * Static value Qos for NamespaceClassification.
     */
    @Generated
    public static final NamespaceClassification QOS = fromString("Qos");

    /**
     * Creates a new instance of NamespaceClassification value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public NamespaceClassification() {
    }

    /**
     * Creates or finds a NamespaceClassification from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding NamespaceClassification.
     */
    @Generated
    public static NamespaceClassification fromString(String name) {
        return fromString(name, NamespaceClassification.class);
    }

    /**
     * Gets known NamespaceClassification values.
     * 
     * @return known NamespaceClassification values.
     */
    @Generated
    public static Collection<NamespaceClassification> values() {
        return values(NamespaceClassification.class);
    }
}
