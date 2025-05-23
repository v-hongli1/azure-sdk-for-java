// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.resourcemanager.apimanagement.models.LoggerType;
import com.azure.resourcemanager.apimanagement.models.LoggerUpdateContract;

/**
 * Samples for WorkspaceLogger Update.
 */
public final class WorkspaceLoggerUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/apimanagement/resource-manager/Microsoft.ApiManagement/stable/2024-05-01/examples/
     * ApiManagementUpdateWorkspaceLogger.json
     */
    /**
     * Sample code: ApiManagementUpdateWorkspaceLogger.
     * 
     * @param manager Entry point to ApiManagementManager.
     */
    public static void
        apiManagementUpdateWorkspaceLogger(com.azure.resourcemanager.apimanagement.ApiManagementManager manager) {
        manager.workspaceLoggers()
            .updateWithResponse("rg1", "apimService1", "wks1", "eh1", "*",
                new LoggerUpdateContract().withLoggerType(LoggerType.AZURE_EVENT_HUB)
                    .withDescription("updating description"),
                com.azure.core.util.Context.NONE);
    }
}
