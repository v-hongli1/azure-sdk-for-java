// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.resourcemanager.appcontainers.models.AzureCredentials;
import com.azure.resourcemanager.appcontainers.models.GithubActionConfiguration;
import com.azure.resourcemanager.appcontainers.models.RegistryInfo;

/**
 * Samples for ContainerAppsSourceControls CreateOrUpdate.
 */
public final class ContainerAppsSourceControlsCreateOrUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/app/resource-manager/Microsoft.App/stable/2025-01-01/examples/SourceControls_CreateOrUpdate.json
     */
    /**
     * Sample code: Create or Update Container App SourceControl.
     * 
     * @param manager Entry point to ContainerAppsApiManager.
     */
    public static void createOrUpdateContainerAppSourceControl(
        com.azure.resourcemanager.appcontainers.ContainerAppsApiManager manager) {
        manager.containerAppsSourceControls()
            .define("current")
            .withExistingContainerApp("workerapps-rg-xj", "testcanadacentral")
            .withRepoUrl("https://github.com/xwang971/ghatest")
            .withBranch("master")
            .withGithubActionConfiguration(new GithubActionConfiguration()
                .withRegistryInfo(new RegistryInfo().withRegistryUrl("test-registry.azurecr.io")
                    .withRegistryUsername("test-registry")
                    .withRegistryPassword("fakeTokenPlaceholder"))
                .withAzureCredentials(new AzureCredentials().withClientId("<clientid>")
                    .withClientSecret("fakeTokenPlaceholder")
                    .withTenantId("<tenantid>")
                    .withKind("feaderated"))
                .withContextPath("./")
                .withGithubPersonalAccessToken("fakeTokenPlaceholder")
                .withImage("image/tag"))
            .create();
    }
}
