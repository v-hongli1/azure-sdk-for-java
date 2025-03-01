// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.voiceservices.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The purpose of the TestLine resource.
 */
public final class TestLinePurpose extends ExpandableStringEnum<TestLinePurpose> {
    /**
     * Static value Manual for TestLinePurpose.
     */
    public static final TestLinePurpose MANUAL = fromString("Manual");

    /**
     * Static value Automated for TestLinePurpose.
     */
    public static final TestLinePurpose AUTOMATED = fromString("Automated");

    /**
     * Creates a new instance of TestLinePurpose value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TestLinePurpose() {
    }

    /**
     * Creates or finds a TestLinePurpose from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding TestLinePurpose.
     */
    public static TestLinePurpose fromString(String name) {
        return fromString(name, TestLinePurpose.class);
    }

    /**
     * Gets known TestLinePurpose values.
     * 
     * @return known TestLinePurpose values.
     */
    public static Collection<TestLinePurpose> values() {
        return values(TestLinePurpose.class);
    }
}
