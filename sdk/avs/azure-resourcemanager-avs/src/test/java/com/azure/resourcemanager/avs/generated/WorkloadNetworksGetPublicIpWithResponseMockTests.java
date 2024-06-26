// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.avs.AvsManager;
import com.azure.resourcemanager.avs.models.WorkloadNetworkPublicIp;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WorkloadNetworksGetPublicIpWithResponseMockTests {
    @Test
    public void testGetPublicIpWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"displayName\":\"fg\",\"numberOfPublicIPs\":1524478115165309750,\"publicIPBlock\":\"pcbbnzqcykna\",\"provisioningState\":\"Deleting\"},\"id\":\"yuicdhzbdy\",\"name\":\"wwgbdv\",\"type\":\"bid\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AvsManager manager = AvsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        WorkloadNetworkPublicIp response = manager.workloadNetworks()
            .getPublicIpWithResponse("vfxzopjh", "zxlioh", "d", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("fg", response.displayName());
        Assertions.assertEquals(1524478115165309750L, response.numberOfPublicIPs());
    }
}
