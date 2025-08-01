// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.policyinsights.models.ComplianceDetail;
import org.junit.jupiter.api.Assertions;

public final class ComplianceDetailTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ComplianceDetail model = BinaryData.fromString("{\"complianceState\":\"hwahfbousn\",\"count\":793996513}")
            .toObject(ComplianceDetail.class);
        Assertions.assertEquals("hwahfbousn", model.complianceState());
        Assertions.assertEquals(793996513, model.count());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ComplianceDetail model = new ComplianceDetail().withComplianceState("hwahfbousn").withCount(793996513);
        model = BinaryData.fromObject(model).toObject(ComplianceDetail.class);
        Assertions.assertEquals("hwahfbousn", model.complianceState());
        Assertions.assertEquals(793996513, model.count());
    }
}
