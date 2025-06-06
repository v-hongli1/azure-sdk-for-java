// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.data.appconfiguration.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for SettingLabelFields.
 */
public final class SettingLabelFields extends ExpandableStringEnum<SettingLabelFields> {
    /**
     * Static value name for SettingLabelFields.
     */
    @Generated
    public static final SettingLabelFields NAME = fromString("name");

    /**
     * Creates a new instance of SettingLabelFields value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public SettingLabelFields() {
    }

    /**
     * Creates or finds a SettingLabelFields from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding SettingLabelFields.
     */
    @Generated
    public static SettingLabelFields fromString(String name) {
        return fromString(name, SettingLabelFields.class);
    }

    /**
     * Gets known SettingLabelFields values.
     * 
     * @return known SettingLabelFields values.
     */
    @Generated
    public static Collection<SettingLabelFields> values() {
        return values(SettingLabelFields.class);
    }
}
