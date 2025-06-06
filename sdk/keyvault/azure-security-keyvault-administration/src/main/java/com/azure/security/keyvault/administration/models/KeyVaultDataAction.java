// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.security.keyvault.administration.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Supported permissions for data actions.
 */
public final class KeyVaultDataAction extends ExpandableStringEnum<KeyVaultDataAction> {
    /**
     * Read HSM key metadata.
     */
    @Generated
    public static final KeyVaultDataAction READ_HSM_KEY = fromString("Microsoft.KeyVault/managedHsm/keys/read/action");

    /**
     * Update an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction WRITE_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/write/action");

    /**
     * Read deleted HSM key.
     */
    @Generated
    public static final KeyVaultDataAction READ_DELETED_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/deletedKeys/read/action");

    /**
     * Recover deleted HSM key.
     */
    @Generated
    public static final KeyVaultDataAction RECOVER_DELETED_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/deletedKeys/recover/action");

    /**
     * Backup HSM keys.
     */
    @Generated
    public static final KeyVaultDataAction BACKUP_HSM_KEYS
        = fromString("Microsoft.KeyVault/managedHsm/keys/backup/action");

    /**
     * Restore HSM keys.
     */
    @Generated
    public static final KeyVaultDataAction RESTORE_HSM_KEYS
        = fromString("Microsoft.KeyVault/managedHsm/keys/restore/action");

    /**
     * Delete role assignment.
     */
    @Generated
    public static final KeyVaultDataAction DELETE_ROLE_ASSIGNMENT
        = fromString("Microsoft.KeyVault/managedHsm/roleAssignments/delete/action");

    /**
     * Get role assignment.
     */
    @Generated
    public static final KeyVaultDataAction GET_ROLE_ASSIGNMENT
        = fromString("Microsoft.KeyVault/managedHsm/roleAssignments/read/action");

    /**
     * Create or update role assignment.
     */
    @Generated
    public static final KeyVaultDataAction WRITE_ROLE_ASSIGNMENT
        = fromString("Microsoft.KeyVault/managedHsm/roleAssignments/write/action");

    /**
     * Get role definition.
     */
    @Generated
    public static final KeyVaultDataAction READ_ROLE_DEFINITION
        = fromString("Microsoft.KeyVault/managedHsm/roleDefinitions/read/action");

    /**
     * Create or update role definition.
     */
    @Generated
    public static final KeyVaultDataAction WRITE_ROLE_DEFINITION
        = fromString("Microsoft.KeyVault/managedHsm/roleDefinitions/write/action");

    /**
     * Delete role definition.
     */
    @Generated
    public static final KeyVaultDataAction DELETE_ROLE_DEFINITION
        = fromString("Microsoft.KeyVault/managedHsm/roleDefinitions/delete/action");

    /**
     * Encrypt using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction ENCRYPT_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/encrypt/action");

    /**
     * Decrypt using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction DECRYPT_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/decrypt/action");

    /**
     * Wrap using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction WRAP_HSM_KEY = fromString("Microsoft.KeyVault/managedHsm/keys/wrap/action");

    /**
     * Unwrap using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction UNWRAP_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/unwrap/action");

    /**
     * Sign using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction SIGN_HSM_KEY = fromString("Microsoft.KeyVault/managedHsm/keys/sign/action");

    /**
     * Verify using an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction VERIFY_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/verify/action");

    /**
     * Create an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction CREATE_HSM_KEY = fromString("Microsoft.KeyVault/managedHsm/keys/create");

    /**
     * Delete an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction DELETE_HSM_KEY = fromString("Microsoft.KeyVault/managedHsm/keys/delete");

    /**
     * Export an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction EXPORT_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/export/action");

    /**
     * Release an HSM key using Secure Key Release.
     */
    @Generated
    public static final KeyVaultDataAction RELEASE_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/release/action");

    /**
     * Import an HSM key.
     */
    @Generated
    public static final KeyVaultDataAction IMPORT_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/import/action");

    /**
     * Purge a deleted HSM key.
     */
    @Generated
    public static final KeyVaultDataAction PURGE_DELETED_HSM_KEY
        = fromString("Microsoft.KeyVault/managedHsm/keys/deletedKeys/delete");

    /**
     * Download an HSM security domain.
     */
    @Generated
    public static final KeyVaultDataAction DOWNLOAD_HSM_SECURITY_DOMAIN
        = fromString("Microsoft.KeyVault/managedHsm/securitydomain/download/action");

    /**
     * Check status of HSM security domain download.
     */
    @Generated
    public static final KeyVaultDataAction DOWNLOAD_HSM_SECURITY_DOMAIN_STATUS
        = fromString("Microsoft.KeyVault/managedHsm/securitydomain/download/read");

    /**
     * Upload an HSM security domain.
     */
    @Generated
    public static final KeyVaultDataAction UPLOAD_HSM_SECURITY_DOMAIN
        = fromString("Microsoft.KeyVault/managedHsm/securitydomain/upload/action");

    /**
     * Check the status of the HSM security domain exchange file.
     */
    @Generated
    public static final KeyVaultDataAction READ_HSM_SECURITY_DOMAIN_STATUS
        = fromString("Microsoft.KeyVault/managedHsm/securitydomain/upload/read");

    /**
     * Download an HSM security domain transfer key.
     */
    @Generated
    public static final KeyVaultDataAction READ_HSM_SECURITY_DOMAIN_TRANSFER_KEY
        = fromString("Microsoft.KeyVault/managedHsm/securitydomain/transferkey/read");

    /**
     * Start an HSM backup.
     */
    @Generated
    public static final KeyVaultDataAction START_HSM_BACKUP
        = fromString("Microsoft.KeyVault/managedHsm/backup/start/action");

    /**
     * Start an HSM restore.
     */
    @Generated
    public static final KeyVaultDataAction START_HSM_RESTORE
        = fromString("Microsoft.KeyVault/managedHsm/restore/start/action");

    /**
     * Read an HSM backup status.
     */
    @Generated
    public static final KeyVaultDataAction READ_HSM_BACKUP_STATUS
        = fromString("Microsoft.KeyVault/managedHsm/backup/status/action");

    /**
     * Read an HSM restore status.
     */
    @Generated
    public static final KeyVaultDataAction READ_HSM_RESTORE_STATUS
        = fromString("Microsoft.KeyVault/managedHsm/restore/status/action");

    /**
     * Generate random numbers.
     */
    @Generated
    public static final KeyVaultDataAction RANDOM_NUMBERS_GENERATE
        = fromString("Microsoft.KeyVault/managedHsm/rng/action");

    /**
     * Creates a new instance of KeyVaultDataAction value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public KeyVaultDataAction() {
    }

    /**
     * Creates or finds a KeyVaultDataAction from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding KeyVaultDataAction.
     */
    @Generated
    public static KeyVaultDataAction fromString(String name) {
        return fromString(name, KeyVaultDataAction.class);
    }

    /**
     * Gets known KeyVaultDataAction values.
     * 
     * @return known KeyVaultDataAction values.
     */
    @Generated
    public static Collection<KeyVaultDataAction> values() {
        return values(KeyVaultDataAction.class);
    }
}
