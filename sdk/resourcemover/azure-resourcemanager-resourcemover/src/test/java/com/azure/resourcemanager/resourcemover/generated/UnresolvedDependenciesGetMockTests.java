// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcemover.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.resourcemover.ResourceMoverManager;
import com.azure.resourcemanager.resourcemover.models.DependencyLevel;
import com.azure.resourcemanager.resourcemover.models.UnresolvedDependency;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class UnresolvedDependenciesGetMockTests {
    @Test
    public void testGet() throws Exception {
        String responseStr = "{\"value\":[{\"count\":27324889,\"id\":\"zfeqztppri\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ResourceMoverManager manager = ResourceMoverManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<UnresolvedDependency> response = manager.unresolvedDependencies()
            .get("nqicvinvkjjxdxrb", "ukzclewyhmlwpaz", DependencyLevel.DIRECT, "pofncck", "yfzqwhxxbu",
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals(27324889, response.iterator().next().count());
        Assertions.assertEquals("zfeqztppri", response.iterator().next().id());
    }
}
