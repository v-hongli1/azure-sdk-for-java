// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.eventgrid.EventGridManager;
import com.azure.resourcemanager.eventgrid.models.PermissionBinding;
import com.azure.resourcemanager.eventgrid.models.PermissionType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PermissionBindingsListByNamespaceMockTests {
    @Test
    public void testListByNamespace() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"description\":\"cdsgxceluji\",\"topicSpaceName\":\"lluunxh\",\"permission\":\"Subscriber\",\"clientGroupName\":\"xzfwugeupcknec\",\"provisioningState\":\"Creating\"},\"id\":\"rvfp\",\"name\":\"jdmngsytqpdzfyxc\",\"type\":\"wawoxcgzbejqf\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<PermissionBinding> response = manager.permissionBindings()
            .listByNamespace("icruo", "krjflsgaojb", "qpqsdoctpzpuj", 225216862, com.azure.core.util.Context.NONE);

        Assertions.assertEquals("cdsgxceluji", response.iterator().next().description());
        Assertions.assertEquals("lluunxh", response.iterator().next().topicSpaceName());
        Assertions.assertEquals(PermissionType.SUBSCRIBER, response.iterator().next().permission());
        Assertions.assertEquals("xzfwugeupcknec", response.iterator().next().clientGroupName());
    }
}
