// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appplatform.generated;

/**
 * Samples for CustomizedAccelerators Delete.
 */
public final class CustomizedAcceleratorsDeleteSamples {
    /*
     * x-ms-original-file: specification/appplatform/resource-manager/Microsoft.AppPlatform/stable/2023-12-01/examples/
     * CustomizedAccelerators_Delete.json
     */
    /**
     * Sample code: CustomizedAccelerators_Delete.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void customizedAcceleratorsDelete(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.springServices()
            .manager()
            .serviceClient()
            .getCustomizedAccelerators()
            .delete("myResourceGroup", "myservice", "default", "acc-name", com.azure.core.util.Context.NONE);
    }
}
