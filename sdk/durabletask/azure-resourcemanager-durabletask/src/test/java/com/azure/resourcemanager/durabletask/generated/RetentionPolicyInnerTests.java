// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.durabletask.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.durabletask.fluent.models.RetentionPolicyInner;
import com.azure.resourcemanager.durabletask.models.PurgeableOrchestrationState;
import com.azure.resourcemanager.durabletask.models.RetentionPolicyDetails;
import com.azure.resourcemanager.durabletask.models.RetentionPolicyProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class RetentionPolicyInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RetentionPolicyInner model = BinaryData.fromString(
            "{\"properties\":{\"provisioningState\":\"Succeeded\",\"retentionPolicies\":[{\"retentionPeriodInDays\":102076266,\"orchestrationState\":\"Canceled\"},{\"retentionPeriodInDays\":398629650,\"orchestrationState\":\"Terminated\"},{\"retentionPeriodInDays\":958772842,\"orchestrationState\":\"Completed\"},{\"retentionPeriodInDays\":1168655887,\"orchestrationState\":\"Completed\"}]},\"id\":\"f\",\"name\":\"dgmb\",\"type\":\"bexppb\"}")
            .toObject(RetentionPolicyInner.class);
        Assertions.assertEquals(102076266, model.properties().retentionPolicies().get(0).retentionPeriodInDays());
        Assertions.assertEquals(PurgeableOrchestrationState.CANCELED,
            model.properties().retentionPolicies().get(0).orchestrationState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RetentionPolicyInner model = new RetentionPolicyInner()
            .withProperties(new RetentionPolicyProperties().withRetentionPolicies(Arrays.asList(
                new RetentionPolicyDetails().withRetentionPeriodInDays(102076266)
                    .withOrchestrationState(PurgeableOrchestrationState.CANCELED),
                new RetentionPolicyDetails().withRetentionPeriodInDays(398629650)
                    .withOrchestrationState(PurgeableOrchestrationState.TERMINATED),
                new RetentionPolicyDetails().withRetentionPeriodInDays(958772842)
                    .withOrchestrationState(PurgeableOrchestrationState.COMPLETED),
                new RetentionPolicyDetails().withRetentionPeriodInDays(1168655887)
                    .withOrchestrationState(PurgeableOrchestrationState.COMPLETED))));
        model = BinaryData.fromObject(model).toObject(RetentionPolicyInner.class);
        Assertions.assertEquals(102076266, model.properties().retentionPolicies().get(0).retentionPeriodInDays());
        Assertions.assertEquals(PurgeableOrchestrationState.CANCELED,
            model.properties().retentionPolicies().get(0).orchestrationState());
    }
}
