// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

/**
 * Samples for Datasets DeleteSync.
 */
public final class DatasetsDeleteSyncSamples {
    /*
     * x-ms-original-file:
     * specification/datafactory/resource-manager/Microsoft.DataFactory/stable/2018-06-01/examples/Datasets_Delete.json
     */
    /**
     * Sample code: Datasets_Delete.
     * 
     * @param manager Entry point to DataFactoryManager.
     */
    public static void datasetsDelete(com.azure.resourcemanager.datafactory.DataFactoryManager manager) {
        manager.datasets()
            .deleteWithResponse("exampleResourceGroup", "exampleFactoryName", "exampleDataset",
                com.azure.core.util.Context.NONE);
    }
}
