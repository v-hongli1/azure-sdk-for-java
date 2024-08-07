// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Provisioning state of the Deployment.
 */
public final class DeploymentResourceProvisioningState
    extends ExpandableStringEnum<DeploymentResourceProvisioningState> {
    /**
     * Static value Creating for DeploymentResourceProvisioningState.
     */
    public static final DeploymentResourceProvisioningState CREATING = fromString("Creating");

    /**
     * Static value Updating for DeploymentResourceProvisioningState.
     */
    public static final DeploymentResourceProvisioningState UPDATING = fromString("Updating");

    /**
     * Static value Succeeded for DeploymentResourceProvisioningState.
     */
    public static final DeploymentResourceProvisioningState SUCCEEDED = fromString("Succeeded");

    /**
     * Static value Failed for DeploymentResourceProvisioningState.
     */
    public static final DeploymentResourceProvisioningState FAILED = fromString("Failed");

    /**
     * Creates a new instance of DeploymentResourceProvisioningState value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public DeploymentResourceProvisioningState() {
    }

    /**
     * Creates or finds a DeploymentResourceProvisioningState from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding DeploymentResourceProvisioningState.
     */
    public static DeploymentResourceProvisioningState fromString(String name) {
        return fromString(name, DeploymentResourceProvisioningState.class);
    }

    /**
     * Gets known DeploymentResourceProvisioningState values.
     * 
     * @return known DeploymentResourceProvisioningState values.
     */
    public static Collection<DeploymentResourceProvisioningState> values() {
        return values(DeploymentResourceProvisioningState.class);
    }
}
