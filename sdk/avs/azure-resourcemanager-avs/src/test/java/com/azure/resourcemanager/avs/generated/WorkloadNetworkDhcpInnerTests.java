// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.avs.fluent.models.WorkloadNetworkDhcpInner;
import com.azure.resourcemanager.avs.models.WorkloadNetworkDhcpEntity;
import org.junit.jupiter.api.Assertions;

public final class WorkloadNetworkDhcpInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WorkloadNetworkDhcpInner model = BinaryData.fromString(
            "{\"properties\":{\"dhcpType\":\"WorkloadNetworkDhcpEntity\",\"displayName\":\"arhmofcqhsmy\",\"segments\":[\"dtmlxhekuksjt\",\"ukcdmparcryuanzw\",\"xzdxtayrlhmwh\"],\"provisioningState\":\"Updating\",\"revision\":8654696713359533876},\"id\":\"mt\",\"name\":\"kknryrtihf\",\"type\":\"tijbpzvgnwzsymgl\"}")
            .toObject(WorkloadNetworkDhcpInner.class);
        Assertions.assertEquals("arhmofcqhsmy", model.properties().displayName());
        Assertions.assertEquals(8654696713359533876L, model.properties().revision());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WorkloadNetworkDhcpInner model = new WorkloadNetworkDhcpInner().withProperties(
            new WorkloadNetworkDhcpEntity().withDisplayName("arhmofcqhsmy").withRevision(8654696713359533876L));
        model = BinaryData.fromObject(model).toObject(WorkloadNetworkDhcpInner.class);
        Assertions.assertEquals("arhmofcqhsmy", model.properties().displayName());
        Assertions.assertEquals(8654696713359533876L, model.properties().revision());
    }
}
