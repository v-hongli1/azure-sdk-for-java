// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.generated;

/**
 * Samples for DataExports Get.
 */
public final class DataExportsGetSamples {
    /*
     * x-ms-original-file:
     * specification/operationalinsights/resource-manager/Microsoft.OperationalInsights/stable/2020-08-01/examples/
     * DataExportGet.json
     */
    /**
     * Sample code: DataExportGet.
     * 
     * @param manager Entry point to LogAnalyticsManager.
     */
    public static void dataExportGet(com.azure.resourcemanager.loganalytics.LogAnalyticsManager manager) {
        manager.dataExports().getWithResponse("RgTest1", "DeWnTest1234", "export1", com.azure.core.util.Context.NONE);
    }
}
