// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.iothub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.iothub.models.ManagedIdentity;
import org.junit.jupiter.api.Assertions;

public final class ManagedIdentityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ManagedIdentity model
            = BinaryData.fromString("{\"userAssignedIdentity\":\"deyeamdphagalpbu\"}").toObject(ManagedIdentity.class);
        Assertions.assertEquals("deyeamdphagalpbu", model.userAssignedIdentity());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ManagedIdentity model = new ManagedIdentity().withUserAssignedIdentity("deyeamdphagalpbu");
        model = BinaryData.fromObject(model).toObject(ManagedIdentity.class);
        Assertions.assertEquals("deyeamdphagalpbu", model.userAssignedIdentity());
    }
}
