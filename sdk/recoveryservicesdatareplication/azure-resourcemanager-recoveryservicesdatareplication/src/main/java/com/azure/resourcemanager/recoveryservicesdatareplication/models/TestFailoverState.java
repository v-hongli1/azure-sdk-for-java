// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.recoveryservicesdatareplication.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Gets or sets the test failover state.
 */
public final class TestFailoverState extends ExpandableStringEnum<TestFailoverState> {
    /**
     * Test failover is not active.
     */
    public static final TestFailoverState NONE = fromString("None");

    /**
     * Test failover has been initiated.
     */
    public static final TestFailoverState TEST_FAILOVER_INITIATED = fromString("TestFailoverInitiated");

    /**
     * Preparing test protected entities is in progress.
     */
    public static final TestFailoverState TEST_FAILOVER_COMPLETING = fromString("TestFailoverCompleting");

    /**
     * Test failover has been completed successfully.
     */
    public static final TestFailoverState TEST_FAILOVER_COMPLETED = fromString("TestFailoverCompleted");

    /**
     * Test failover initiation failed..
     */
    public static final TestFailoverState TEST_FAILOVER_FAILED = fromString("TestFailoverFailed");

    /**
     * Preparing test protected entities failed.
     */
    public static final TestFailoverState TEST_FAILOVER_COMPLETION_FAILED = fromString("TestFailoverCompletionFailed");

    /**
     * Test failover cleanup has been initiated.
     */
    public static final TestFailoverState TEST_FAILOVER_CLEANUP_INITIATED = fromString("TestFailoverCleanupInitiated");

    /**
     * Cleaning up test protected entities is in progress.
     */
    public static final TestFailoverState TEST_FAILOVER_CLEANUP_COMPLETING
        = fromString("TestFailoverCleanupCompleting");

    /**
     * Test failover cleanup has completed/failed. This is a transient state before the state is moved back to None.
     */
    public static final TestFailoverState MARKED_FOR_DELETION = fromString("MarkedForDeletion");

    /**
     * Creates a new instance of TestFailoverState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public TestFailoverState() {
    }

    /**
     * Creates or finds a TestFailoverState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding TestFailoverState.
     */
    public static TestFailoverState fromString(String name) {
        return fromString(name, TestFailoverState.class);
    }

    /**
     * Gets known TestFailoverState values.
     * 
     * @return known TestFailoverState values.
     */
    public static Collection<TestFailoverState> values() {
        return values(TestFailoverState.class);
    }
}
