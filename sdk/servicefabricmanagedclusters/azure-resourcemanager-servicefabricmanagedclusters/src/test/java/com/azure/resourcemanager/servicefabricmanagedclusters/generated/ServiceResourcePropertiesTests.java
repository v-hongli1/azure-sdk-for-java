// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.MoveCost;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.Partition;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ScalingMechanism;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ScalingPolicy;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ScalingTrigger;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServiceCorrelation;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServiceCorrelationScheme;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServiceLoadMetric;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServiceLoadMetricWeight;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServicePackageActivationMode;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServicePlacementPolicy;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.ServiceResourceProperties;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ServiceResourcePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ServiceResourceProperties model = BinaryData.fromString(
            "{\"serviceKind\":\"ServiceResourceProperties\",\"provisioningState\":\"zbtd\",\"serviceTypeName\":\"xujznbmpowu\",\"partitionDescription\":{\"partitionScheme\":\"Partition\"},\"servicePackageActivationMode\":\"SharedProcess\",\"serviceDnsName\":\"qlveualupjmkh\",\"placementConstraints\":\"obbc\",\"correlationScheme\":[{\"scheme\":\"NonAlignedAffinity\",\"serviceName\":\"tjrip\"}],\"serviceLoadMetrics\":[{\"name\":\"pbewtghfgblcgwx\",\"weight\":\"High\",\"primaryDefaultLoad\":932562427,\"secondaryDefaultLoad\":2103137599,\"defaultLoad\":1823532721},{\"name\":\"egibtnmxiebww\",\"weight\":\"Low\",\"primaryDefaultLoad\":1519275761,\"secondaryDefaultLoad\":193613480,\"defaultLoad\":1034644273},{\"name\":\"rtzju\",\"weight\":\"Medium\",\"primaryDefaultLoad\":598094792,\"secondaryDefaultLoad\":1235130312,\"defaultLoad\":1961357126}],\"servicePlacementPolicies\":[{\"type\":\"ServicePlacementPolicy\"},{\"type\":\"ServicePlacementPolicy\"},{\"type\":\"ServicePlacementPolicy\"}],\"defaultMoveCost\":\"High\",\"scalingPolicies\":[{\"scalingMechanism\":{\"kind\":\"ScalingMechanism\"},\"scalingTrigger\":{\"kind\":\"ScalingTrigger\"}},{\"scalingMechanism\":{\"kind\":\"ScalingMechanism\"},\"scalingTrigger\":{\"kind\":\"ScalingTrigger\"}},{\"scalingMechanism\":{\"kind\":\"ScalingMechanism\"},\"scalingTrigger\":{\"kind\":\"ScalingTrigger\"}}]}")
            .toObject(ServiceResourceProperties.class);
        Assertions.assertEquals("obbc", model.placementConstraints());
        Assertions.assertEquals(ServiceCorrelationScheme.NON_ALIGNED_AFFINITY,
            model.correlationScheme().get(0).scheme());
        Assertions.assertEquals("tjrip", model.correlationScheme().get(0).serviceName());
        Assertions.assertEquals("pbewtghfgblcgwx", model.serviceLoadMetrics().get(0).name());
        Assertions.assertEquals(ServiceLoadMetricWeight.HIGH, model.serviceLoadMetrics().get(0).weight());
        Assertions.assertEquals(932562427, model.serviceLoadMetrics().get(0).primaryDefaultLoad());
        Assertions.assertEquals(2103137599, model.serviceLoadMetrics().get(0).secondaryDefaultLoad());
        Assertions.assertEquals(1823532721, model.serviceLoadMetrics().get(0).defaultLoad());
        Assertions.assertEquals(MoveCost.HIGH, model.defaultMoveCost());
        Assertions.assertEquals("xujznbmpowu", model.serviceTypeName());
        Assertions.assertEquals(ServicePackageActivationMode.SHARED_PROCESS, model.servicePackageActivationMode());
        Assertions.assertEquals("qlveualupjmkh", model.serviceDnsName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ServiceResourceProperties model = new ServiceResourceProperties().withPlacementConstraints("obbc")
            .withCorrelationScheme(
                Arrays.asList(new ServiceCorrelation().withScheme(ServiceCorrelationScheme.NON_ALIGNED_AFFINITY)
                    .withServiceName("tjrip")))
            .withServiceLoadMetrics(Arrays.asList(
                new ServiceLoadMetric().withName("pbewtghfgblcgwx")
                    .withWeight(ServiceLoadMetricWeight.HIGH)
                    .withPrimaryDefaultLoad(932562427)
                    .withSecondaryDefaultLoad(2103137599)
                    .withDefaultLoad(1823532721),
                new ServiceLoadMetric().withName("egibtnmxiebww")
                    .withWeight(ServiceLoadMetricWeight.LOW)
                    .withPrimaryDefaultLoad(1519275761)
                    .withSecondaryDefaultLoad(193613480)
                    .withDefaultLoad(1034644273),
                new ServiceLoadMetric().withName("rtzju")
                    .withWeight(ServiceLoadMetricWeight.MEDIUM)
                    .withPrimaryDefaultLoad(598094792)
                    .withSecondaryDefaultLoad(1235130312)
                    .withDefaultLoad(1961357126)))
            .withServicePlacementPolicies(
                Arrays.asList(new ServicePlacementPolicy(), new ServicePlacementPolicy(), new ServicePlacementPolicy()))
            .withDefaultMoveCost(MoveCost.HIGH)
            .withScalingPolicies(Arrays.asList(
                new ScalingPolicy().withScalingMechanism(new ScalingMechanism())
                    .withScalingTrigger(new ScalingTrigger()),
                new ScalingPolicy().withScalingMechanism(new ScalingMechanism())
                    .withScalingTrigger(new ScalingTrigger()),
                new ScalingPolicy().withScalingMechanism(new ScalingMechanism())
                    .withScalingTrigger(new ScalingTrigger())))
            .withServiceTypeName("xujznbmpowu")
            .withPartitionDescription(new Partition())
            .withServicePackageActivationMode(ServicePackageActivationMode.SHARED_PROCESS)
            .withServiceDnsName("qlveualupjmkh");
        model = BinaryData.fromObject(model).toObject(ServiceResourceProperties.class);
        Assertions.assertEquals("obbc", model.placementConstraints());
        Assertions.assertEquals(ServiceCorrelationScheme.NON_ALIGNED_AFFINITY,
            model.correlationScheme().get(0).scheme());
        Assertions.assertEquals("tjrip", model.correlationScheme().get(0).serviceName());
        Assertions.assertEquals("pbewtghfgblcgwx", model.serviceLoadMetrics().get(0).name());
        Assertions.assertEquals(ServiceLoadMetricWeight.HIGH, model.serviceLoadMetrics().get(0).weight());
        Assertions.assertEquals(932562427, model.serviceLoadMetrics().get(0).primaryDefaultLoad());
        Assertions.assertEquals(2103137599, model.serviceLoadMetrics().get(0).secondaryDefaultLoad());
        Assertions.assertEquals(1823532721, model.serviceLoadMetrics().get(0).defaultLoad());
        Assertions.assertEquals(MoveCost.HIGH, model.defaultMoveCost());
        Assertions.assertEquals("xujznbmpowu", model.serviceTypeName());
        Assertions.assertEquals(ServicePackageActivationMode.SHARED_PROCESS, model.servicePackageActivationMode());
        Assertions.assertEquals("qlveualupjmkh", model.serviceDnsName());
    }
}
