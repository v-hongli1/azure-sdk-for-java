// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.WebhookEventSubscriptionDestinationProperties;
import com.azure.resourcemanager.eventgrid.models.DeliveryAttributeMapping;
import com.azure.resourcemanager.eventgrid.models.TlsVersion;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class WebhookEventSubscriptionDestinationPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WebhookEventSubscriptionDestinationProperties model = BinaryData.fromString(
            "{\"endpointUrl\":\"v\",\"endpointBaseUrl\":\"qqjwkrh\",\"maxEventsPerBatch\":1063009582,\"preferredBatchSizeInKilobytes\":1005777788,\"azureActiveDirectoryTenantId\":\"jisgglmvokatuztj\",\"azureActiveDirectoryApplicationIdOrUri\":\"ibpvbkaehxsmzyg\",\"deliveryAttributeMappings\":[{\"type\":\"DeliveryAttributeMapping\",\"name\":\"kwseivmakxhyso\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"juxlkbectvtfjm\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"dchmaiubavlz\"},{\"type\":\"DeliveryAttributeMapping\",\"name\":\"vgmfalkzazmgok\"}],\"minimumTlsVersionAllowed\":\"1.0\"}")
            .toObject(WebhookEventSubscriptionDestinationProperties.class);
        Assertions.assertEquals("v", model.endpointUrl());
        Assertions.assertEquals(1063009582, model.maxEventsPerBatch());
        Assertions.assertEquals(1005777788, model.preferredBatchSizeInKilobytes());
        Assertions.assertEquals("jisgglmvokatuztj", model.azureActiveDirectoryTenantId());
        Assertions.assertEquals("ibpvbkaehxsmzyg", model.azureActiveDirectoryApplicationIdOrUri());
        Assertions.assertEquals("kwseivmakxhyso", model.deliveryAttributeMappings().get(0).name());
        Assertions.assertEquals(TlsVersion.ONE_ZERO, model.minimumTlsVersionAllowed());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WebhookEventSubscriptionDestinationProperties model
            = new WebhookEventSubscriptionDestinationProperties().withEndpointUrl("v")
                .withMaxEventsPerBatch(1063009582)
                .withPreferredBatchSizeInKilobytes(1005777788)
                .withAzureActiveDirectoryTenantId("jisgglmvokatuztj")
                .withAzureActiveDirectoryApplicationIdOrUri("ibpvbkaehxsmzyg")
                .withDeliveryAttributeMappings(Arrays.asList(new DeliveryAttributeMapping().withName("kwseivmakxhyso"),
                    new DeliveryAttributeMapping().withName("juxlkbectvtfjm"),
                    new DeliveryAttributeMapping().withName("dchmaiubavlz"),
                    new DeliveryAttributeMapping().withName("vgmfalkzazmgok")))
                .withMinimumTlsVersionAllowed(TlsVersion.ONE_ZERO);
        model = BinaryData.fromObject(model).toObject(WebhookEventSubscriptionDestinationProperties.class);
        Assertions.assertEquals("v", model.endpointUrl());
        Assertions.assertEquals(1063009582, model.maxEventsPerBatch());
        Assertions.assertEquals(1005777788, model.preferredBatchSizeInKilobytes());
        Assertions.assertEquals("jisgglmvokatuztj", model.azureActiveDirectoryTenantId());
        Assertions.assertEquals("ibpvbkaehxsmzyg", model.azureActiveDirectoryApplicationIdOrUri());
        Assertions.assertEquals("kwseivmakxhyso", model.deliveryAttributeMappings().get(0).name());
        Assertions.assertEquals(TlsVersion.ONE_ZERO, model.minimumTlsVersionAllowed());
    }
}
