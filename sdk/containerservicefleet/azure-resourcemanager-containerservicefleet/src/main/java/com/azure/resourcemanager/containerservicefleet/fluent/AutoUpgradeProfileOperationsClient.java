// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.management.polling.PollResult;
import com.azure.core.util.Context;
import com.azure.core.util.polling.SyncPoller;
import com.azure.resourcemanager.containerservicefleet.fluent.models.GenerateResponseInner;

/**
 * An instance of this class provides access to all the operations defined in AutoUpgradeProfileOperationsClient.
 */
public interface AutoUpgradeProfileOperationsClient {
    /**
     * A long-running resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param fleetName The name of the Fleet resource.
     * @param autoUpgradeProfileName The name of the AutoUpgradeProfile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<GenerateResponseInner>, GenerateResponseInner>
        beginGenerateUpdateRun(String resourceGroupName, String fleetName, String autoUpgradeProfileName);

    /**
     * A long-running resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param fleetName The name of the Fleet resource.
     * @param autoUpgradeProfileName The name of the AutoUpgradeProfile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link SyncPoller} for polling of long-running operation.
     */
    @ServiceMethod(returns = ReturnType.LONG_RUNNING_OPERATION)
    SyncPoller<PollResult<GenerateResponseInner>, GenerateResponseInner> beginGenerateUpdateRun(
        String resourceGroupName, String fleetName, String autoUpgradeProfileName, Context context);

    /**
     * A long-running resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param fleetName The name of the Fleet resource.
     * @param autoUpgradeProfileName The name of the AutoUpgradeProfile resource.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    GenerateResponseInner generateUpdateRun(String resourceGroupName, String fleetName, String autoUpgradeProfileName);

    /**
     * A long-running resource action.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param fleetName The name of the Fleet resource.
     * @param autoUpgradeProfileName The name of the AutoUpgradeProfile resource.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    GenerateResponseInner generateUpdateRun(String resourceGroupName, String fleetName, String autoUpgradeProfileName,
        Context context);
}
