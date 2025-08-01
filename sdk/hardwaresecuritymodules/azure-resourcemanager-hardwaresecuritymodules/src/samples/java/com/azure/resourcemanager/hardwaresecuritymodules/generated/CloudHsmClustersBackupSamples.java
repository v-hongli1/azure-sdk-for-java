// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.hardwaresecuritymodules.generated;

import com.azure.resourcemanager.hardwaresecuritymodules.models.BackupRequestProperties;

/**
 * Samples for CloudHsmClusters Backup.
 */
public final class CloudHsmClustersBackupSamples {
    /*
     * x-ms-original-file: 2025-03-31/CloudHsmCluster_CreateOrValidate_Backup_MaximumSet_Gen.json
     */
    /**
     * Sample code: CloudHsmCluster_Create_Backup_MaximumSet_Gen.
     * 
     * @param manager Entry point to HardwareSecurityModulesManager.
     */
    public static void cloudHsmClusterCreateBackupMaximumSetGen(
        com.azure.resourcemanager.hardwaresecuritymodules.HardwareSecurityModulesManager manager) {
        manager.cloudHsmClusters()
            .backup("rgcloudhsm", "chsm1",
                new BackupRequestProperties()
                    .withAzureStorageBlobContainerUri(
                        "https://myaccount.blob.core.windows.net/sascontainer/sasContainer")
                    .withToken("fakeTokenPlaceholder"),
                com.azure.core.util.Context.NONE);
    }
}
