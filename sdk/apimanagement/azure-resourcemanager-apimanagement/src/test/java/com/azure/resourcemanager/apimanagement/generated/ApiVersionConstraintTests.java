// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.models.ApiVersionConstraint;
import org.junit.jupiter.api.Assertions;

public final class ApiVersionConstraintTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApiVersionConstraint model
            = BinaryData.fromString("{\"minApiVersion\":\"ekewnazeaj\"}").toObject(ApiVersionConstraint.class);
        Assertions.assertEquals("ekewnazeaj", model.minApiVersion());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApiVersionConstraint model = new ApiVersionConstraint().withMinApiVersion("ekewnazeaj");
        model = BinaryData.fromObject(model).toObject(ApiVersionConstraint.class);
        Assertions.assertEquals("ekewnazeaj", model.minApiVersion());
    }
}
