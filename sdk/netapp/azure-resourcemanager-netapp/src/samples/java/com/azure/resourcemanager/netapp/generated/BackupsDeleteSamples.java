// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for Backups Delete.
 */
public final class BackupsDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/BackupsUnderBackupVault_Delete.
     * json
     */
    /**
     * Sample code: BackupsUnderBackupVault_Delete.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void backupsUnderBackupVaultDelete(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.backups()
            .delete("resourceGroup", "account1", "backupVault1", "backup1", com.azure.core.util.Context.NONE);
    }
}
