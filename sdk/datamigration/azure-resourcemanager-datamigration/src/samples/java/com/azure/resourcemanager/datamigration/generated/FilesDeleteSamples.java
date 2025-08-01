// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

/**
 * Samples for Files Delete.
 */
public final class FilesDeleteSamples {
    /*
     * x-ms-original-file:
     * specification/datamigration/resource-manager/Microsoft.DataMigration/preview/2025-03-15-preview/examples/
     * Files_Delete.json
     */
    /**
     * Sample code: Files_Delete.
     * 
     * @param manager Entry point to DataMigrationManager.
     */
    public static void filesDelete(com.azure.resourcemanager.datamigration.DataMigrationManager manager) {
        manager.files()
            .deleteWithResponse("DmsSdkRg", "DmsSdkService", "DmsSdkProject", "x114d023d8",
                com.azure.core.util.Context.NONE);
    }
}
