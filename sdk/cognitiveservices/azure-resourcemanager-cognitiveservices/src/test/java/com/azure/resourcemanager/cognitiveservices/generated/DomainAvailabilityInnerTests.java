// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cognitiveservices.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.cognitiveservices.fluent.models.DomainAvailabilityInner;
import org.junit.jupiter.api.Assertions;

public final class DomainAvailabilityInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DomainAvailabilityInner model = BinaryData.fromString(
            "{\"isSubdomainAvailable\":false,\"reason\":\"ze\",\"subdomainName\":\"kdltfzxmhhvhg\",\"type\":\"eodkwobda\",\"kind\":\"tibqdxbxwakb\"}")
            .toObject(DomainAvailabilityInner.class);
        Assertions.assertFalse(model.isSubdomainAvailable());
        Assertions.assertEquals("ze", model.reason());
        Assertions.assertEquals("kdltfzxmhhvhg", model.subdomainName());
        Assertions.assertEquals("eodkwobda", model.type());
        Assertions.assertEquals("tibqdxbxwakb", model.kind());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DomainAvailabilityInner model = new DomainAvailabilityInner().withIsSubdomainAvailable(false)
            .withReason("ze")
            .withSubdomainName("kdltfzxmhhvhg")
            .withType("eodkwobda")
            .withKind("tibqdxbxwakb");
        model = BinaryData.fromObject(model).toObject(DomainAvailabilityInner.class);
        Assertions.assertFalse(model.isSubdomainAvailable());
        Assertions.assertEquals("ze", model.reason());
        Assertions.assertEquals("kdltfzxmhhvhg", model.subdomainName());
        Assertions.assertEquals("eodkwobda", model.type());
        Assertions.assertEquals("tibqdxbxwakb", model.kind());
    }
}
