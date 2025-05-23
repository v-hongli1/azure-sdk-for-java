// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The type of key used to encrypt the data of the disk.
 */
public final class EncryptionType extends ExpandableStringEnum<EncryptionType> {
    /**
     * Static value EncryptionAtRestWithPlatformKey for EncryptionType.
     */
    public static final EncryptionType ENCRYPTION_AT_REST_WITH_PLATFORM_KEY
        = fromString("EncryptionAtRestWithPlatformKey");

    /**
     * Static value EncryptionAtRestWithCustomerManagedKey for EncryptionType.
     */
    public static final EncryptionType ENCRYPTION_AT_REST_WITH_CUSTOMER_MANAGED_KEY
        = fromString("EncryptionAtRestWithCustomerManagedKey");

    /**
     * Creates a new instance of EncryptionType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public EncryptionType() {
    }

    /**
     * Creates or finds a EncryptionType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding EncryptionType.
     */
    public static EncryptionType fromString(String name) {
        return fromString(name, EncryptionType.class);
    }

    /**
     * Gets known EncryptionType values.
     * 
     * @return known EncryptionType values.
     */
    public static Collection<EncryptionType> values() {
        return values(EncryptionType.class);
    }
}
