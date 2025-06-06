// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.avs.AvsManager;
import com.azure.resourcemanager.avs.models.WorkloadNetworkPublicIp;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WorkloadNetworksListPublicIPsMockTests {
    @Test
    public void testListPublicIPs() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"displayName\":\"uiiznktwfansnvpd\",\"numberOfPublicIPs\":2885516766254746853,\"publicIPBlock\":\"ostbzbkiwb\",\"provisioningState\":\"Succeeded\"},\"id\":\"ophzfylsgcrp\",\"name\":\"bcunezzceze\",\"type\":\"fwyfwlwxjwet\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AvsManager manager = AvsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<WorkloadNetworkPublicIp> response
            = manager.workloadNetworks().listPublicIPs("rylniofrzg", "zjedmstkvnlv", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("uiiznktwfansnvpd", response.iterator().next().displayName());
        Assertions.assertEquals(2885516766254746853L, response.iterator().next().numberOfPublicIPs());
    }
}
