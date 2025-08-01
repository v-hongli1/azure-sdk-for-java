// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.policyinsights.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.policyinsights.models.ComponentPolicyEvaluationDetails;
import org.junit.jupiter.api.Assertions;

public final class ComponentPolicyEvaluationDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ComponentPolicyEvaluationDetails model = BinaryData.fromString(
            "{\"evaluatedExpressions\":[{\"result\":\"wcdommpvfqaw\",\"expression\":\"gbrt\",\"expressionKind\":\"iac\",\"path\":\"iexhajl\",\"expressionValue\":\"datat\",\"targetValue\":\"dataqfyuttd\",\"operator\":\"gbpvnwswmtxkyct\"},{\"result\":\"gzwx\",\"expression\":\"mecvogygzyvneeza\",\"expressionKind\":\"gh\",\"path\":\"oqqtl\",\"expressionValue\":\"datahzbkrkjj\",\"targetValue\":\"datavfqnvhnqoewdo\",\"operator\":\"yetesy\"},{\"result\":\"idbz\",\"expression\":\"hqtfbovn\",\"expressionKind\":\"kbwetnj\",\"path\":\"p\",\"expressionValue\":\"datarkzyaupia\",\"targetValue\":\"dataxnafbw\",\"operator\":\"oohtuovmaonurjtu\"}],\"reason\":\"hihpvecmsl\"}")
            .toObject(ComponentPolicyEvaluationDetails.class);
        Assertions.assertEquals("hihpvecmsl", model.reason());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ComponentPolicyEvaluationDetails model = new ComponentPolicyEvaluationDetails().withReason("hihpvecmsl");
        model = BinaryData.fromObject(model).toObject(ComponentPolicyEvaluationDetails.class);
        Assertions.assertEquals("hihpvecmsl", model.reason());
    }
}
