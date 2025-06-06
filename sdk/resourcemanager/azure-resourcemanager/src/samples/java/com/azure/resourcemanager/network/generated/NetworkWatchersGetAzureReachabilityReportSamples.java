// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.generated;

import com.azure.resourcemanager.network.models.AzureReachabilityReportLocation;
import com.azure.resourcemanager.network.models.AzureReachabilityReportParameters;
import java.time.OffsetDateTime;
import java.util.Arrays;

/**
 * Samples for NetworkWatchers GetAzureReachabilityReport.
 */
public final class NetworkWatchersGetAzureReachabilityReportSamples {
    /*
     * x-ms-original-file: specification/network/resource-manager/Microsoft.Network/stable/2024-07-01/examples/
     * NetworkWatcherAzureReachabilityReportGet.json
     */
    /**
     * Sample code: Get Azure Reachability Report.
     * 
     * @param azure The entry point for accessing resource management APIs in Azure.
     */
    public static void getAzureReachabilityReport(com.azure.resourcemanager.AzureResourceManager azure) {
        azure.networks()
            .manager()
            .serviceClient()
            .getNetworkWatchers()
            .getAzureReachabilityReport("rg1", "nw1",
                new AzureReachabilityReportParameters()
                    .withProviderLocation(
                        new AzureReachabilityReportLocation().withCountry("United States").withState("washington"))
                    .withProviders(Arrays.asList("Frontier Communications of America, Inc. - ASN 5650"))
                    .withAzureLocations(Arrays.asList("West US"))
                    .withStartTime(OffsetDateTime.parse("2017-09-07T00:00:00Z"))
                    .withEndTime(OffsetDateTime.parse("2017-09-10T00:00:00Z")),
                com.azure.core.util.Context.NONE);
    }
}
