// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.models.IoTSecurityDeviceRecommendation;

public final class IoTSecurityDeviceRecommendationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IoTSecurityDeviceRecommendation model = BinaryData.fromString(
            "{\"recommendationDisplayName\":\"xrhdwbavxbniwdjs\",\"reportedSeverity\":\"Low\",\"devicesCount\":2880353456116262366}")
            .toObject(IoTSecurityDeviceRecommendation.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IoTSecurityDeviceRecommendation model = new IoTSecurityDeviceRecommendation();
        model = BinaryData.fromObject(model).toObject(IoTSecurityDeviceRecommendation.class);
    }
}
