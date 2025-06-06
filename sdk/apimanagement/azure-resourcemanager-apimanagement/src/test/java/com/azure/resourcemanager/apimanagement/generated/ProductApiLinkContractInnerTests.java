// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.fluent.models.ProductApiLinkContractInner;
import org.junit.jupiter.api.Assertions;

public final class ProductApiLinkContractInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ProductApiLinkContractInner model = BinaryData.fromString(
            "{\"properties\":{\"apiId\":\"uozkgyf\"},\"id\":\"eoehgfmqmskkixvl\",\"name\":\"jxplh\",\"type\":\"evasyntvzjyie\"}")
            .toObject(ProductApiLinkContractInner.class);
        Assertions.assertEquals("uozkgyf", model.apiId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ProductApiLinkContractInner model = new ProductApiLinkContractInner().withApiId("uozkgyf");
        model = BinaryData.fromObject(model).toObject(ProductApiLinkContractInner.class);
        Assertions.assertEquals("uozkgyf", model.apiId());
    }
}
