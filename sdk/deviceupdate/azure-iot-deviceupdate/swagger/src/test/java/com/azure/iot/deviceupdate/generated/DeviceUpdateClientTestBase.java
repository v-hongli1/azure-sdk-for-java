// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.iot.deviceupdate.generated;

// The Java test files under 'generated' package are generated for your reference.
// If you wish to modify these files, please copy them out of the 'generated' package, and modify there.
// See https://aka.ms/azsdk/dpg/java/tests for guide on adding a test.

import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.test.TestMode;
import com.azure.core.test.TestProxyTestBase;
import com.azure.core.test.utils.MockTokenCredential;
import com.azure.core.util.Configuration;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.iot.deviceupdate.DeviceManagementClient;
import com.azure.iot.deviceupdate.DeviceManagementClientBuilder;
import com.azure.iot.deviceupdate.DeviceUpdateClient;
import com.azure.iot.deviceupdate.DeviceUpdateClientBuilder;

class DeviceUpdateClientTestBase extends TestProxyTestBase {
    protected DeviceUpdateClient deviceUpdateClient;

    protected DeviceManagementClient deviceManagementClient;

    @Override
    protected void beforeTest() {
        DeviceUpdateClientBuilder deviceUpdateClientbuilder = new DeviceUpdateClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT", "endpoint"))
            .instanceId(Configuration.getGlobalConfiguration().get("INSTANCEID", "instanceid"))
            .httpClient(getHttpClientOrUsePlayback(getHttpClients().findFirst().orElse(null)))
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BASIC));
        if (getTestMode() == TestMode.PLAYBACK) {
            deviceUpdateClientbuilder.credential(new MockTokenCredential());
        } else if (getTestMode() == TestMode.RECORD) {
            deviceUpdateClientbuilder.addPolicy(interceptorManager.getRecordPolicy())
                .credential(new DefaultAzureCredentialBuilder().build());
        } else if (getTestMode() == TestMode.LIVE) {
            deviceUpdateClientbuilder.credential(new DefaultAzureCredentialBuilder().build());
        }
        deviceUpdateClient = deviceUpdateClientbuilder.buildClient();

        DeviceManagementClientBuilder deviceManagementClientbuilder = new DeviceManagementClientBuilder()
            .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT", "endpoint"))
            .instanceId(Configuration.getGlobalConfiguration().get("INSTANCEID", "instanceid"))
            .httpClient(getHttpClientOrUsePlayback(getHttpClients().findFirst().orElse(null)))
            .httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BASIC));
        if (getTestMode() == TestMode.PLAYBACK) {
            deviceManagementClientbuilder.credential(new MockTokenCredential());
        } else if (getTestMode() == TestMode.RECORD) {
            deviceManagementClientbuilder.addPolicy(interceptorManager.getRecordPolicy())
                .credential(new DefaultAzureCredentialBuilder().build());
        } else if (getTestMode() == TestMode.LIVE) {
            deviceManagementClientbuilder.credential(new DefaultAzureCredentialBuilder().build());
        }
        deviceManagementClient = deviceManagementClientbuilder.buildClient();

    }
}
