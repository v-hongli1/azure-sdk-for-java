// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The partition mechanism that will be used for Netezza read in parallel.
 */
public final class NetezzaPartitionOption extends ExpandableStringEnum<NetezzaPartitionOption> {
    /**
     * Static value None for NetezzaPartitionOption.
     */
    @Generated
    public static final NetezzaPartitionOption NONE = fromString("None");

    /**
     * Static value DataSlice for NetezzaPartitionOption.
     */
    @Generated
    public static final NetezzaPartitionOption DATA_SLICE = fromString("DataSlice");

    /**
     * Static value DynamicRange for NetezzaPartitionOption.
     */
    @Generated
    public static final NetezzaPartitionOption DYNAMIC_RANGE = fromString("DynamicRange");

    /**
     * Creates a new instance of NetezzaPartitionOption value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public NetezzaPartitionOption() {
    }

    /**
     * Creates or finds a NetezzaPartitionOption from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding NetezzaPartitionOption.
     */
    @Generated
    public static NetezzaPartitionOption fromString(String name) {
        return fromString(name, NetezzaPartitionOption.class);
    }

    /**
     * Gets known NetezzaPartitionOption values.
     * 
     * @return known NetezzaPartitionOption values.
     */
    @Generated
    public static Collection<NetezzaPartitionOption> values() {
        return values(NetezzaPartitionOption.class);
    }
}
