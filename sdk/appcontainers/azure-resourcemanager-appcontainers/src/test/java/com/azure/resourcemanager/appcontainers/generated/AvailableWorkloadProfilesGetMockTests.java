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
import com.azure.resourcemanager.appcontainers.models.Applicability;
import com.azure.resourcemanager.appcontainers.models.AvailableWorkloadProfile;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AvailableWorkloadProfilesGetMockTests {
    @Test
    public void testGet() throws Exception {
        String responseStr
            = "{\"value\":[{\"location\":\"ydsx\",\"properties\":{\"category\":\"ohec\",\"applicability\":\"Custom\",\"cores\":685509922,\"memoryGiB\":402118107,\"gpus\":952248828,\"displayName\":\"eallklmtkhlo\"},\"id\":\"x\",\"name\":\"pvbrdfjmzsyz\",\"type\":\"hotlhikcyychunsj\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerAppsApiManager manager = ContainerAppsApiManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<AvailableWorkloadProfile> response
            = manager.availableWorkloadProfiles().get("w", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("ydsx", response.iterator().next().location());
        Assertions.assertEquals("ohec", response.iterator().next().properties().category());
        Assertions.assertEquals(Applicability.CUSTOM, response.iterator().next().properties().applicability());
        Assertions.assertEquals(685509922, response.iterator().next().properties().cores());
        Assertions.assertEquals(402118107, response.iterator().next().properties().memoryGiB());
        Assertions.assertEquals(952248828, response.iterator().next().properties().gpus());
        Assertions.assertEquals("eallklmtkhlo", response.iterator().next().properties().displayName());
    }
}
