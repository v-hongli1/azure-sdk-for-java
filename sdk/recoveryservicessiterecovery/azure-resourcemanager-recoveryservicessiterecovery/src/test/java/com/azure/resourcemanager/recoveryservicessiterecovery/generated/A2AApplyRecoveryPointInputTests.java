// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.A2AApplyRecoveryPointInput;

public final class A2AApplyRecoveryPointInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        A2AApplyRecoveryPointInput model
            = BinaryData.fromString("{\"instanceType\":\"A2A\"}").toObject(A2AApplyRecoveryPointInput.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        A2AApplyRecoveryPointInput model = new A2AApplyRecoveryPointInput();
        model = BinaryData.fromObject(model).toObject(A2AApplyRecoveryPointInput.class);
    }
}
