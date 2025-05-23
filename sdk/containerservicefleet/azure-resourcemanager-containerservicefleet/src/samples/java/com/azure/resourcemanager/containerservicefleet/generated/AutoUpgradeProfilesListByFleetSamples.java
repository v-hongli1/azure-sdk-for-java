// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

/**
 * Samples for AutoUpgradeProfiles ListByFleet.
 */
public final class AutoUpgradeProfilesListByFleetSamples {
    /*
     * x-ms-original-file: 2025-03-01/AutoUpgradeProfiles_ListByFleet.json
     */
    /**
     * Sample code: Lists the AutoUpgradeProfile resources by fleet.
     * 
     * @param manager Entry point to ContainerServiceFleetManager.
     */
    public static void listsTheAutoUpgradeProfileResourcesByFleet(
        com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager manager) {
        manager.autoUpgradeProfiles().listByFleet("rg1", "fleet1", com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2025-03-01/AutoUpgradeProfiles_ListByFleet_MaximumSet_Gen.json
     */
    /**
     * Sample code: Lists the AutoUpgradeProfile resources by fleet. - generated by [MaximumSet] rule.
     * 
     * @param manager Entry point to ContainerServiceFleetManager.
     */
    public static void listsTheAutoUpgradeProfileResourcesByFleetGeneratedByMaximumSetRule(
        com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager manager) {
        manager.autoUpgradeProfiles().listByFleet("rgfleets", "fleet1", com.azure.core.util.Context.NONE);
    }
}
