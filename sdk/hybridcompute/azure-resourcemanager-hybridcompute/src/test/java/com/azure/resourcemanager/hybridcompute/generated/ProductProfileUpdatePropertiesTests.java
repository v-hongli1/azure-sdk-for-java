// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcompute.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.hybridcompute.fluent.models.ProductProfileUpdateProperties;
import com.azure.resourcemanager.hybridcompute.models.LicenseProfileProductType;
import com.azure.resourcemanager.hybridcompute.models.LicenseProfileSubscriptionStatusUpdate;
import com.azure.resourcemanager.hybridcompute.models.ProductFeatureUpdate;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class ProductProfileUpdatePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ProductProfileUpdateProperties model = BinaryData.fromString(
            "{\"subscriptionStatus\":\"Enable\",\"productType\":\"WindowsServer\",\"productFeatures\":[{\"name\":\"rxjjstoqbeitpk\",\"subscriptionStatus\":\"Enable\"}]}")
            .toObject(ProductProfileUpdateProperties.class);
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE, model.subscriptionStatus());
        Assertions.assertEquals(LicenseProfileProductType.WINDOWS_SERVER, model.productType());
        Assertions.assertEquals("rxjjstoqbeitpk", model.productFeatures().get(0).name());
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE,
            model.productFeatures().get(0).subscriptionStatus());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ProductProfileUpdateProperties model
            = new ProductProfileUpdateProperties().withSubscriptionStatus(LicenseProfileSubscriptionStatusUpdate.ENABLE)
                .withProductType(LicenseProfileProductType.WINDOWS_SERVER)
                .withProductFeatures(Arrays.asList(new ProductFeatureUpdate().withName("rxjjstoqbeitpk")
                    .withSubscriptionStatus(LicenseProfileSubscriptionStatusUpdate.ENABLE)));
        model = BinaryData.fromObject(model).toObject(ProductProfileUpdateProperties.class);
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE, model.subscriptionStatus());
        Assertions.assertEquals(LicenseProfileProductType.WINDOWS_SERVER, model.productType());
        Assertions.assertEquals("rxjjstoqbeitpk", model.productFeatures().get(0).name());
        Assertions.assertEquals(LicenseProfileSubscriptionStatusUpdate.ENABLE,
            model.productFeatures().get(0).subscriptionStatus());
    }
}
