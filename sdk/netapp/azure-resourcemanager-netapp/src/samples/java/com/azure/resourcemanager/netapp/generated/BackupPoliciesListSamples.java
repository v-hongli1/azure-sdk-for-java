// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

/**
 * Samples for BackupPolicies List.
 */
public final class BackupPoliciesListSamples {
    /*
     * x-ms-original-file:
     * specification/netapp/resource-manager/Microsoft.NetApp/stable/2025-03-01/examples/BackupPolicies_List.json
     */
    /**
     * Sample code: BackupPolicies_List.
     * 
     * @param manager Entry point to NetAppFilesManager.
     */
    public static void backupPoliciesList(com.azure.resourcemanager.netapp.NetAppFilesManager manager) {
        manager.backupPolicies().list("myRG", "account1", com.azure.core.util.Context.NONE);
    }
}
