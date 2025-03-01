// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.generated;

import com.azure.resourcemanager.workloadssapvirtualinstance.models.StopRequest;

/**
 * Samples for SapDatabaseInstances Stop.
 */
public final class SapDatabaseInstancesStopSamples {
    /*
     * x-ms-original-file: 2024-09-01/SapDatabaseInstances_StopInstance.json
     */
    /**
     * Sample code: Stop the database instance of the SAP system.
     * 
     * @param manager Entry point to WorkloadsSapVirtualInstanceManager.
     */
    public static void stopTheDatabaseInstanceOfTheSAPSystem(
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager) {
        manager.sapDatabaseInstances()
            .stop("test-rg", "X00", "db0", new StopRequest().withSoftStopTimeoutSeconds(0L),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2024-09-01/SapDatabaseInstances_StopInstanceSoft.json
     */
    /**
     * Sample code: Soft Stop the database instance of the SAP system.
     * 
     * @param manager Entry point to WorkloadsSapVirtualInstanceManager.
     */
    public static void softStopTheDatabaseInstanceOfTheSAPSystem(
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager) {
        manager.sapDatabaseInstances()
            .stop("test-rg", "X00", "db0", new StopRequest().withSoftStopTimeoutSeconds(300L),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2024-09-01/SapDatabaseInstances_StopInstanceSoftVM.json
     */
    /**
     * Sample code: Soft Stop the database instance of the SAP system and the underlying Virtual Machine(s).
     * 
     * @param manager Entry point to WorkloadsSapVirtualInstanceManager.
     */
    public static void softStopTheDatabaseInstanceOfTheSAPSystemAndTheUnderlyingVirtualMachineS(
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager) {
        manager.sapDatabaseInstances()
            .stop("test-rg", "X00", "db0", new StopRequest().withSoftStopTimeoutSeconds(300L).withDeallocateVm(true),
                com.azure.core.util.Context.NONE);
    }

    /*
     * x-ms-original-file: 2024-09-01/SapDatabaseInstances_StopInstanceVM.json
     */
    /**
     * Sample code: Stop the database instance of the SAP system and the underlying Virtual Machine(s).
     * 
     * @param manager Entry point to WorkloadsSapVirtualInstanceManager.
     */
    public static void stopTheDatabaseInstanceOfTheSAPSystemAndTheUnderlyingVirtualMachineS(
        com.azure.resourcemanager.workloadssapvirtualinstance.WorkloadsSapVirtualInstanceManager manager) {
        manager.sapDatabaseInstances()
            .stop("test-rg", "X00", "db0", new StopRequest().withSoftStopTimeoutSeconds(0L).withDeallocateVm(true),
                com.azure.core.util.Context.NONE);
    }
}
