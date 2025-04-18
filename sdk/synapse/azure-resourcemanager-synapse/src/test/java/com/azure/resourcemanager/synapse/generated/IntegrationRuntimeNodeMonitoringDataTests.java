// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.models.IntegrationRuntimeNodeMonitoringData;
import java.util.HashMap;
import java.util.Map;

public final class IntegrationRuntimeNodeMonitoringDataTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IntegrationRuntimeNodeMonitoringData model = BinaryData.fromString(
            "{\"nodeName\":\"nkjzkdeslpvlop\",\"availableMemoryInMB\":1665401728,\"cpuUtilization\":1768535097,\"concurrentJobsLimit\":879866119,\"concurrentJobsRunning\":1973154307,\"maxConcurrentJobs\":1713070379,\"sentBytes\":74.692726,\"receivedBytes\":59.623474,\"\":{\"ojnabckhsmtxpsie\":\"databbaumnyquped\"}}")
            .toObject(IntegrationRuntimeNodeMonitoringData.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IntegrationRuntimeNodeMonitoringData model = new IntegrationRuntimeNodeMonitoringData()
            .withAdditionalProperties(mapOf("nodeName", "nkjzkdeslpvlop", "cpuUtilization", 1768535097, "receivedBytes",
                59.623474f, "concurrentJobsLimit", 879866119, "concurrentJobsRunning", 1973154307, "maxConcurrentJobs",
                1713070379, "availableMemoryInMB", 1665401728, "sentBytes", 74.692726f));
        model = BinaryData.fromObject(model).toObject(IntegrationRuntimeNodeMonitoringData.class);
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
