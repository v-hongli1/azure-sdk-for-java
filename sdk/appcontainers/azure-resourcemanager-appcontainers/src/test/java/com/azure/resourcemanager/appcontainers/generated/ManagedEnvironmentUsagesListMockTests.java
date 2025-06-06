// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.appcontainers.ContainerAppsApiManager;
import com.azure.resourcemanager.appcontainers.models.Usage;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ManagedEnvironmentUsagesListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"currentValue\":62.76494,\"limit\":37.16777,\"name\":{\"value\":\"bkhxj\",\"localizedValue\":\"oez\"}}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerAppsApiManager manager = ContainerAppsApiManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Usage> response
            = manager.managedEnvironmentUsages().list("kbvhhd", "urghoo", com.azure.core.util.Context.NONE);

        Assertions.assertEquals(62.76494f, response.iterator().next().currentValue());
        Assertions.assertEquals(37.16777f, response.iterator().next().limit());
        Assertions.assertEquals("bkhxj", response.iterator().next().name().value());
        Assertions.assertEquals("oez", response.iterator().next().name().localizedValue());
    }
}
