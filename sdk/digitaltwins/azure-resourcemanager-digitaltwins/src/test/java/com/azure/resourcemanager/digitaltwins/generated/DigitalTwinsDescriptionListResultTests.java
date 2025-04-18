// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.digitaltwins.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.digitaltwins.fluent.models.DigitalTwinsDescriptionInner;
import com.azure.resourcemanager.digitaltwins.fluent.models.PrivateEndpointConnectionInner;
import com.azure.resourcemanager.digitaltwins.models.ConnectionProperties;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsDescriptionListResult;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsIdentity;
import com.azure.resourcemanager.digitaltwins.models.DigitalTwinsIdentityType;
import com.azure.resourcemanager.digitaltwins.models.PublicNetworkAccess;
import com.azure.resourcemanager.digitaltwins.models.UserAssignedIdentity;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class DigitalTwinsDescriptionListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DigitalTwinsDescriptionListResult model = BinaryData.fromString(
            "{\"nextLink\":\"jmkljavbqidtqajz\",\"value\":[{\"properties\":{\"createdTime\":\"2021-04-22T22:07:48Z\",\"lastUpdatedTime\":\"2021-11-19T04:41:57Z\",\"provisioningState\":\"Provisioning\",\"hostName\":\"khbzhfepgzg\",\"privateEndpointConnections\":[{\"properties\":{},\"id\":\"locx\",\"name\":\"c\",\"type\":\"aierhhb\"},{\"properties\":{},\"id\":\"glu\",\"name\":\"majtjaod\",\"type\":\"obnbdxkqpxokaj\"},{\"properties\":{},\"id\":\"npime\",\"name\":\"gstxgcp\",\"type\":\"dg\"}],\"publicNetworkAccess\":\"Disabled\"},\"identity\":{\"type\":\"UserAssigned\",\"principalId\":\"djwzrlov\",\"tenantId\":\"lwhijcoejctbzaq\",\"userAssignedIdentities\":{\"axcfjpgddtocjjx\":{\"clientId\":\"cbkbfkg\",\"principalId\":\"dkexxppofm\"},\"jnxqbzvddntwn\":{\"clientId\":\"pmouexhdz\",\"principalId\":\"bqe\"}}},\"location\":\"icbtwnpzao\",\"tags\":{\"qkwpyeicxmqc\":\"hrhcffcyddglmjth\",\"pbobjo\":\"wqvhkhixuigdt\",\"w\":\"hm\",\"a\":\"a\"},\"id\":\"hrzayvvtpgvdf\",\"name\":\"iotkftutqxl\",\"type\":\"gxlefgugnxkrxd\"}]}")
            .toObject(DigitalTwinsDescriptionListResult.class);
        Assertions.assertEquals("jmkljavbqidtqajz", model.nextLink());
        Assertions.assertEquals("icbtwnpzao", model.value().get(0).location());
        Assertions.assertEquals("hrhcffcyddglmjth", model.value().get(0).tags().get("qkwpyeicxmqc"));
        Assertions.assertEquals(DigitalTwinsIdentityType.USER_ASSIGNED, model.value().get(0).identity().type());
        Assertions.assertEquals(PublicNetworkAccess.DISABLED, model.value().get(0).publicNetworkAccess());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DigitalTwinsDescriptionListResult model
            = new DigitalTwinsDescriptionListResult().withNextLink("jmkljavbqidtqajz")
                .withValue(Arrays.asList(new DigitalTwinsDescriptionInner().withLocation("icbtwnpzao")
                    .withTags(mapOf("qkwpyeicxmqc", "hrhcffcyddglmjth", "pbobjo", "wqvhkhixuigdt", "w", "hm", "a", "a"))
                    .withIdentity(new DigitalTwinsIdentity().withType(DigitalTwinsIdentityType.USER_ASSIGNED)
                        .withUserAssignedIdentities(mapOf("axcfjpgddtocjjx", new UserAssignedIdentity(),
                            "jnxqbzvddntwn", new UserAssignedIdentity())))
                    .withPrivateEndpointConnections(
                        Arrays.asList(new PrivateEndpointConnectionInner().withProperties(new ConnectionProperties()),
                            new PrivateEndpointConnectionInner().withProperties(new ConnectionProperties()),
                            new PrivateEndpointConnectionInner().withProperties(new ConnectionProperties())))
                    .withPublicNetworkAccess(PublicNetworkAccess.DISABLED)));
        model = BinaryData.fromObject(model).toObject(DigitalTwinsDescriptionListResult.class);
        Assertions.assertEquals("jmkljavbqidtqajz", model.nextLink());
        Assertions.assertEquals("icbtwnpzao", model.value().get(0).location());
        Assertions.assertEquals("hrhcffcyddglmjth", model.value().get(0).tags().get("qkwpyeicxmqc"));
        Assertions.assertEquals(DigitalTwinsIdentityType.USER_ASSIGNED, model.value().get(0).identity().type());
        Assertions.assertEquals(PublicNetworkAccess.DISABLED, model.value().get(0).publicNetworkAccess());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
