// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.connectedvmware.generated;

import com.azure.resourcemanager.connectedvmware.models.VCenter;
import java.util.HashMap;
import java.util.Map;

/**
 * Samples for VCenters Update.
 */
public final class VCentersUpdateSamples {
    /*
     * x-ms-original-file:
     * specification/connectedvmware/resource-manager/Microsoft.ConnectedVMwarevSphere/stable/2023-10-01/examples/
     * UpdateVCenter.json
     */
    /**
     * Sample code: UpdateVCenter.
     * 
     * @param manager Entry point to ConnectedVMwareManager.
     */
    public static void updateVCenter(com.azure.resourcemanager.connectedvmware.ConnectedVMwareManager manager) {
        VCenter resource = manager.vCenters()
            .getByResourceGroupWithResponse("testrg", "ContosoVCenter", com.azure.core.util.Context.NONE)
            .getValue();
        resource.update().withTags(mapOf("tag1", "value1", "tag2", "value2")).apply();
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
