// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devcenter.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.devcenter.DevCenterManager;
import com.azure.resourcemanager.devcenter.models.AttachedNetworkConnection;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class AttachedNetworksListByDevCenterMockTests {
    @Test
    public void testListByDevCenter() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"MovingResources\",\"networkConnectionId\":\"nsdfzpbgtgky\",\"networkConnectionLocation\":\"dgh\",\"healthCheckStatus\":\"Pending\",\"domainJoinType\":\"AzureADJoin\"},\"id\":\"lwxezwzhokvbwnh\",\"name\":\"tqlgehgppi\",\"type\":\"ifhpf\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DevCenterManager manager = DevCenterManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<AttachedNetworkConnection> response = manager.attachedNetworks()
            .listByDevCenter("btmvpdvjdhttza", "fedxihchrphkm", 525308452, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("nsdfzpbgtgky", response.iterator().next().networkConnectionId());
    }
}
