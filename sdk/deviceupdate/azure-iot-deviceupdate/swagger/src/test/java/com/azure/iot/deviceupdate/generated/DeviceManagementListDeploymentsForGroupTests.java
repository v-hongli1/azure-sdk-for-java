// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.iot.deviceupdate.generated;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.util.BinaryData;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public final class DeviceManagementListDeploymentsForGroupTests extends DeviceUpdateClientTestBase {
    @Test
    @Disabled
    public void testDeviceManagementListDeploymentsForGroupTests() {
        RequestOptions requestOptions = new RequestOptions();
        PagedIterable<BinaryData> response
            = deviceManagementClient.listDeploymentsForGroup("TestGroup", requestOptions);
        Assertions.assertEquals(200, response.iterableByPage().iterator().next().getStatusCode());
        Assertions.assertEquals(BinaryData.fromString(
            "{\"deploymentId\":\"deploymentId1\",\"deviceClassSubgroups\":[\"deviceClassId1\",\"deviceClassId2\"],\"groupId\":\"TestGroup\",\"isCanceled\":false,\"isCloudInitiatedRollback\":false,\"isRetried\":false,\"rollbackPolicy\":{\"failure\":{\"devicesFailedCount\":100,\"devicesFailedPercentage\":50},\"update\":{\"friendlyName\":\"Provider1 Name1 2022 Update\",\"updateId\":{\"name\":\"name1\",\"provider\":\"provider1\",\"version\":\"0.9.0\"}}},\"startDateTime\":\"2020-07-01T12:13:14Z\",\"update\":{\"friendlyName\":\"Provider1 Name1 2022 Update\",\"updateId\":{\"name\":\"name1\",\"provider\":\"provider1\",\"version\":\"1.0.0.0\"}}}")
            .toObject(Object.class), response.iterator().next().toObject(Object.class));
    }
}
