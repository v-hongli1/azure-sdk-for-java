// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kusto.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.kusto.models.SuspensionDetails;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;

public final class SuspensionDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SuspensionDetails model = BinaryData.fromString("{\"suspensionStartDate\":\"2021-07-29T14:30:38Z\"}")
            .toObject(SuspensionDetails.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-29T14:30:38Z"), model.suspensionStartDate());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SuspensionDetails model
            = new SuspensionDetails().withSuspensionStartDate(OffsetDateTime.parse("2021-07-29T14:30:38Z"));
        model = BinaryData.fromObject(model).toObject(SuspensionDetails.class);
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-29T14:30:38Z"), model.suspensionStartDate());
    }
}
