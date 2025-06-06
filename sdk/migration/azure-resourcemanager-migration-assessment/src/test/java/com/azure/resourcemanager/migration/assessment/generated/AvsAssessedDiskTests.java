// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.migration.assessment.models.AvsAssessedDisk;

public final class AvsAssessedDiskTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AvsAssessedDisk model = BinaryData.fromString(
            "{\"name\":\"uzqogsexnevf\",\"displayName\":\"wnwmewzs\",\"gigabytesProvisioned\":87.22587,\"megabytesPerSecondOfRead\":25.413382,\"megabytesPerSecondOfWrite\":66.84359,\"numberOfReadOperationsPerSecond\":4.8421144,\"numberOfWriteOperationsPerSecond\":47.16871}")
            .toObject(AvsAssessedDisk.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AvsAssessedDisk model = new AvsAssessedDisk();
        model = BinaryData.fromObject(model).toObject(AvsAssessedDisk.class);
    }
}
