// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.resourcemanager.recoveryservicessiterecovery.models.A2AApplyClusterRecoveryPointInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ApplyClusterRecoveryPointInput;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.ApplyClusterRecoveryPointInputProperties;
import java.util.Arrays;

/**
 * Samples for ReplicationProtectionClusters ApplyRecoveryPoint.
 */
public final class ReplicationProtectionClustersApplyRecoveryPoint {
    /*
     * x-ms-original-file:
     * specification/recoveryservicessiterecovery/resource-manager/Microsoft.RecoveryServices/stable/2025-01-01/examples
     * /ReplicationProtectionClusters_ApplyRecoveryPoint.json
     */
    /**
     * Sample code: Execute the change recovery point operation for cluster.
     * 
     * @param manager Entry point to SiteRecoveryManager.
     */
    public static void executeTheChangeRecoveryPointOperationForCluster(
        com.azure.resourcemanager.recoveryservicessiterecovery.SiteRecoveryManager manager) {
        manager.replicationProtectionClusters()
            .applyRecoveryPoint("resourceGroupPS1", "vault1", "fabric-pri-eastus", "pri-cloud-eastus", "testcluster",
                new ApplyClusterRecoveryPointInput().withProperties(new ApplyClusterRecoveryPointInputProperties()
                    .withClusterRecoveryPointId(
                        "/Subscriptions/7c943c1b-5122-4097-90c8-861411bdd574/resourceGroups/resourceGroupPS1/providers/Microsoft.RecoveryServices/vaults/shashankvaultpvt/replicationFabrics/fabric-pri-eastus/replicationProtectionContainers/pri-cloud-eastus/replicationProtectionClusters/testcluster/recoveryPoints/cc48b7f3-b267-432b-ad76-45528974dc62")
                    .withIndividualNodeRecoveryPoints(Arrays.asList(
                        "/Subscriptions/7c943c1b-5122-4097-90c8-861411bdd574/resourceGroups/resourceGroupPS1/providers/Microsoft.RecoveryServices/vaults/shashankvaultpvt/replicationFabrics/fabric-pri-eastus/replicationProtectionContainers/pri-cloud-eastus/replicationProtectedItems/testVM/recoveryPoints/b5c2051b-79e3-41ad-9d25-244f6ef8ce7d"))
                    .withProviderSpecificDetails(new A2AApplyClusterRecoveryPointInput())),
                com.azure.core.util.Context.NONE);
    }
}
