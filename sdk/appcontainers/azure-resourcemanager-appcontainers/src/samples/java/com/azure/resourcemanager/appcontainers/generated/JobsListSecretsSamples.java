// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

/**
 * Samples for Jobs ListSecrets.
 */
public final class JobsListSecretsSamples {
    /*
     * x-ms-original-file:
     * specification/app/resource-manager/Microsoft.App/stable/2025-01-01/examples/Job_ListSecrets.json
     */
    /**
     * Sample code: List Container Apps Job Secrets.
     * 
     * @param manager Entry point to ContainerAppsApiManager.
     */
    public static void
        listContainerAppsJobSecrets(com.azure.resourcemanager.appcontainers.ContainerAppsApiManager manager) {
        manager.jobs().listSecretsWithResponse("rg", "testcontainerappsjob0", com.azure.core.util.Context.NONE);
    }
}
