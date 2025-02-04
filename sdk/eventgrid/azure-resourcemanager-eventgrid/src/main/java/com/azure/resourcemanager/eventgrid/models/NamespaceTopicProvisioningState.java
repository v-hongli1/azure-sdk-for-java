// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Provisioning state of the namespace topic.
 */
public final class NamespaceTopicProvisioningState extends ExpandableStringEnum<NamespaceTopicProvisioningState> {
    /**
     * Static value Creating for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState CREATING = fromString("Creating");

    /**
     * Static value Updating for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState UPDATING = fromString("Updating");

    /**
     * Static value Deleting for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState DELETING = fromString("Deleting");

    /**
     * Static value Succeeded for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState SUCCEEDED = fromString("Succeeded");

    /**
     * Static value Canceled for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState CANCELED = fromString("Canceled");

    /**
     * Static value Failed for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState FAILED = fromString("Failed");

    /**
     * Static value Deleted for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState DELETED = fromString("Deleted");

    /**
     * Static value DeleteFailed for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState DELETE_FAILED = fromString("DeleteFailed");

    /**
     * Static value CreateFailed for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState CREATE_FAILED = fromString("CreateFailed");

    /**
     * Static value UpdatedFailed for NamespaceTopicProvisioningState.
     */
    public static final NamespaceTopicProvisioningState UPDATED_FAILED = fromString("UpdatedFailed");

    /**
     * Creates a new instance of NamespaceTopicProvisioningState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public NamespaceTopicProvisioningState() {
    }

    /**
     * Creates or finds a NamespaceTopicProvisioningState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding NamespaceTopicProvisioningState.
     */
    public static NamespaceTopicProvisioningState fromString(String name) {
        return fromString(name, NamespaceTopicProvisioningState.class);
    }

    /**
     * Gets known NamespaceTopicProvisioningState values.
     * 
     * @return known NamespaceTopicProvisioningState values.
     */
    public static Collection<NamespaceTopicProvisioningState> values() {
        return values(NamespaceTopicProvisioningState.class);
    }
}
