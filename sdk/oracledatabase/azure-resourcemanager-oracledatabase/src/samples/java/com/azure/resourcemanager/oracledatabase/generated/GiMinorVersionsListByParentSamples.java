// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.generated;

import com.azure.resourcemanager.oracledatabase.models.ShapeFamily;

/**
 * Samples for GiMinorVersions ListByParent.
 */
public final class GiMinorVersionsListByParentSamples {
    /*
     * x-ms-original-file: 2025-03-01/GiMinorVersions_ListByParent_MaximumSet_Gen.json
     */
    /**
     * Sample code: GiMinorVersions_ListByParent_MaximumSet.
     * 
     * @param manager Entry point to OracleDatabaseManager.
     */
    public static void
        giMinorVersionsListByParentMaximumSet(com.azure.resourcemanager.oracledatabase.OracleDatabaseManager manager) {
        manager.giMinorVersions()
            .listByParent("eastus", "giVersionName", ShapeFamily.fromString("rtfcosvtlpeeqoicsjqggtgc"), null,
                com.azure.core.util.Context.NONE);
    }
}
