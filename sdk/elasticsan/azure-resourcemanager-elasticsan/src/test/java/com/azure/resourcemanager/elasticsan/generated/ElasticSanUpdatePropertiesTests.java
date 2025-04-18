// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.elasticsan.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.elasticsan.fluent.models.ElasticSanUpdateProperties;
import com.azure.resourcemanager.elasticsan.models.AutoScalePolicyEnforcement;
import com.azure.resourcemanager.elasticsan.models.AutoScaleProperties;
import com.azure.resourcemanager.elasticsan.models.PublicNetworkAccess;
import com.azure.resourcemanager.elasticsan.models.ScaleUpProperties;
import org.junit.jupiter.api.Assertions;

public final class ElasticSanUpdatePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ElasticSanUpdateProperties model = BinaryData.fromString(
            "{\"baseSizeTiB\":7669458407160761212,\"extendedCapacitySizeTiB\":8086228355940359973,\"publicNetworkAccess\":\"Enabled\",\"autoScaleProperties\":{\"scaleUpProperties\":{\"unusedSizeTiB\":9019954696773982094,\"increaseCapacityUnitByTiB\":7249564448679749970,\"capacityUnitScaleUpLimitTiB\":1856639965917426751,\"autoScalePolicyEnforcement\":\"None\"}}}")
            .toObject(ElasticSanUpdateProperties.class);
        Assertions.assertEquals(7669458407160761212L, model.baseSizeTiB());
        Assertions.assertEquals(8086228355940359973L, model.extendedCapacitySizeTiB());
        Assertions.assertEquals(PublicNetworkAccess.ENABLED, model.publicNetworkAccess());
        Assertions.assertEquals(9019954696773982094L, model.autoScaleProperties().scaleUpProperties().unusedSizeTiB());
        Assertions.assertEquals(7249564448679749970L,
            model.autoScaleProperties().scaleUpProperties().increaseCapacityUnitByTiB());
        Assertions.assertEquals(1856639965917426751L,
            model.autoScaleProperties().scaleUpProperties().capacityUnitScaleUpLimitTiB());
        Assertions.assertEquals(AutoScalePolicyEnforcement.NONE,
            model.autoScaleProperties().scaleUpProperties().autoScalePolicyEnforcement());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ElasticSanUpdateProperties model = new ElasticSanUpdateProperties().withBaseSizeTiB(7669458407160761212L)
            .withExtendedCapacitySizeTiB(8086228355940359973L)
            .withPublicNetworkAccess(PublicNetworkAccess.ENABLED)
            .withAutoScaleProperties(new AutoScaleProperties()
                .withScaleUpProperties(new ScaleUpProperties().withUnusedSizeTiB(9019954696773982094L)
                    .withIncreaseCapacityUnitByTiB(7249564448679749970L)
                    .withCapacityUnitScaleUpLimitTiB(1856639965917426751L)
                    .withAutoScalePolicyEnforcement(AutoScalePolicyEnforcement.NONE)));
        model = BinaryData.fromObject(model).toObject(ElasticSanUpdateProperties.class);
        Assertions.assertEquals(7669458407160761212L, model.baseSizeTiB());
        Assertions.assertEquals(8086228355940359973L, model.extendedCapacitySizeTiB());
        Assertions.assertEquals(PublicNetworkAccess.ENABLED, model.publicNetworkAccess());
        Assertions.assertEquals(9019954696773982094L, model.autoScaleProperties().scaleUpProperties().unusedSizeTiB());
        Assertions.assertEquals(7249564448679749970L,
            model.autoScaleProperties().scaleUpProperties().increaseCapacityUnitByTiB());
        Assertions.assertEquals(1856639965917426751L,
            model.autoScaleProperties().scaleUpProperties().capacityUnitScaleUpLimitTiB());
        Assertions.assertEquals(AutoScalePolicyEnforcement.NONE,
            model.autoScaleProperties().scaleUpProperties().autoScalePolicyEnforcement());
    }
}
