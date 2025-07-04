// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.textanalytics.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Error code.
 */
public final class WarningCodeValue extends ExpandableStringEnum<WarningCodeValue> {
    /**
     * Static value LongWordsInDocument for WarningCodeValue.
     */
    @Generated
    public static final WarningCodeValue LONG_WORDS_IN_DOCUMENT = fromString("LongWordsInDocument");

    /**
     * Static value DocumentTruncated for WarningCodeValue.
     */
    @Generated
    public static final WarningCodeValue DOCUMENT_TRUNCATED = fromString("DocumentTruncated");

    /**
     * Creates a new instance of WarningCodeValue value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public WarningCodeValue() {
    }

    /**
     * Creates or finds a WarningCodeValue from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding WarningCodeValue.
     */
    @Generated
    public static WarningCodeValue fromString(String name) {
        return fromString(name, WarningCodeValue.class);
    }

    /**
     * Gets known WarningCodeValue values.
     * 
     * @return known WarningCodeValue values.
     */
    @Generated
    public static Collection<WarningCodeValue> values() {
        return values(WarningCodeValue.class);
    }
}
