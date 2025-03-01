// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.models.QuotaReport;
import com.azure.resourcemanager.netapp.models.Type;
import org.junit.jupiter.api.Assertions;

public final class QuotaReportTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        QuotaReport model = BinaryData.fromString(
            "{\"quotaType\":\"DefaultGroupQuota\",\"quotaTarget\":\"stkwqqtch\",\"quotaLimitUsedInKiBs\":416295343158305691,\"quotaLimitTotalInKiBs\":5417188415846728288,\"percentageUsed\":24.116516,\"isDerivedQuota\":false}")
            .toObject(QuotaReport.class);
        Assertions.assertEquals(Type.DEFAULT_GROUP_QUOTA, model.quotaType());
        Assertions.assertEquals("stkwqqtch", model.quotaTarget());
        Assertions.assertEquals(416295343158305691L, model.quotaLimitUsedInKiBs());
        Assertions.assertEquals(5417188415846728288L, model.quotaLimitTotalInKiBs());
        Assertions.assertEquals(24.116516F, model.percentageUsed());
        Assertions.assertEquals(false, model.isDerivedQuota());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        QuotaReport model = new QuotaReport().withQuotaType(Type.DEFAULT_GROUP_QUOTA)
            .withQuotaTarget("stkwqqtch")
            .withQuotaLimitUsedInKiBs(416295343158305691L)
            .withQuotaLimitTotalInKiBs(5417188415846728288L)
            .withPercentageUsed(24.116516F)
            .withIsDerivedQuota(false);
        model = BinaryData.fromObject(model).toObject(QuotaReport.class);
        Assertions.assertEquals(Type.DEFAULT_GROUP_QUOTA, model.quotaType());
        Assertions.assertEquals("stkwqqtch", model.quotaTarget());
        Assertions.assertEquals(416295343158305691L, model.quotaLimitUsedInKiBs());
        Assertions.assertEquals(5417188415846728288L, model.quotaLimitTotalInKiBs());
        Assertions.assertEquals(24.116516F, model.percentageUsed());
        Assertions.assertEquals(false, model.isDerivedQuota());
    }
}
