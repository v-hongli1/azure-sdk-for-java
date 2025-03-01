// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresql.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.postgresql.models.NameAvailabilityRequest;
import org.junit.jupiter.api.Assertions;

public final class NameAvailabilityRequestTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        NameAvailabilityRequest model = BinaryData.fromString("{\"name\":\"iuebbaumny\",\"type\":\"ped\"}")
            .toObject(NameAvailabilityRequest.class);
        Assertions.assertEquals("iuebbaumny", model.name());
        Assertions.assertEquals("ped", model.type());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        NameAvailabilityRequest model = new NameAvailabilityRequest().withName("iuebbaumny").withType("ped");
        model = BinaryData.fromObject(model).toObject(NameAvailabilityRequest.class);
        Assertions.assertEquals("iuebbaumny", model.name());
        Assertions.assertEquals("ped", model.type());
    }
}
