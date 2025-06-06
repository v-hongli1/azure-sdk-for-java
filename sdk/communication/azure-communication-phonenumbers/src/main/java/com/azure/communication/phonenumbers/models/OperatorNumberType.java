// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.phonenumbers.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Type of service associated with the phone number.
 */
public final class OperatorNumberType extends ExpandableStringEnum<OperatorNumberType> {
    /**
     * Static value unknown for OperatorNumberType.
     */
    @Generated
    public static final OperatorNumberType UNKNOWN = fromString("unknown");

    /**
     * Static value other for OperatorNumberType.
     */
    @Generated
    public static final OperatorNumberType OTHER = fromString("other");

    /**
     * Static value geographic for OperatorNumberType.
     */
    @Generated
    public static final OperatorNumberType GEOGRAPHIC = fromString("geographic");

    /**
     * Static value mobile for OperatorNumberType.
     */
    @Generated
    public static final OperatorNumberType MOBILE = fromString("mobile");

    /**
     * Creates a new instance of OperatorNumberType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public OperatorNumberType() {
    }

    /**
     * Creates or finds a OperatorNumberType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding OperatorNumberType.
     */
    @Generated
    public static OperatorNumberType fromString(String name) {
        return fromString(name, OperatorNumberType.class);
    }

    /**
     * Gets known OperatorNumberType values.
     * 
     * @return known OperatorNumberType values.
     */
    @Generated
    public static Collection<OperatorNumberType> values() {
        return values(OperatorNumberType.class);
    }
}
