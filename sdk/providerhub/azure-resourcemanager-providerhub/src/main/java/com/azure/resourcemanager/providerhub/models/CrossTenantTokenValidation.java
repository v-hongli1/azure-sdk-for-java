// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The cross tenant token validation.
 */
public final class CrossTenantTokenValidation extends ExpandableStringEnum<CrossTenantTokenValidation> {
    /**
     * Static value EnsureSecureValidation for CrossTenantTokenValidation.
     */
    public static final CrossTenantTokenValidation ENSURE_SECURE_VALIDATION = fromString("EnsureSecureValidation");

    /**
     * Static value PassthroughInsecureToken for CrossTenantTokenValidation.
     */
    public static final CrossTenantTokenValidation PASSTHROUGH_INSECURE_TOKEN = fromString("PassthroughInsecureToken");

    /**
     * Creates a new instance of CrossTenantTokenValidation value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public CrossTenantTokenValidation() {
    }

    /**
     * Creates or finds a CrossTenantTokenValidation from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding CrossTenantTokenValidation.
     */
    public static CrossTenantTokenValidation fromString(String name) {
        return fromString(name, CrossTenantTokenValidation.class);
    }

    /**
     * Gets known CrossTenantTokenValidation values.
     * 
     * @return known CrossTenantTokenValidation values.
     */
    public static Collection<CrossTenantTokenValidation> values() {
        return values(CrossTenantTokenValidation.class);
    }
}
