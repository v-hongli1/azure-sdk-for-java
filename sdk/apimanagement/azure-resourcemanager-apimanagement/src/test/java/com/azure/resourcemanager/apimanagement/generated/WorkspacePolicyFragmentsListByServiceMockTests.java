// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.apimanagement.ApiManagementManager;
import com.azure.resourcemanager.apimanagement.models.PolicyFragmentContentFormat;
import com.azure.resourcemanager.apimanagement.models.PolicyFragmentContract;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WorkspacePolicyFragmentsListByServiceMockTests {
    @Test
    public void testListByService() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"value\":\"k\",\"description\":\"uqhopafobpyeob\",\"format\":\"rawxml\",\"provisioningState\":\"vqafdhp\"},\"id\":\"iiu\",\"name\":\"yrobckelowsm\",\"type\":\"vdtqhrtn\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ApiManagementManager manager = ApiManagementManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<PolicyFragmentContract> response = manager.workspacePolicyFragments()
            .listByService("qtjcrpaxwxlfx", "e", "vdzidldmxfqftyw", "ba", "zhdciuxotb", 1812532011, 1829984946,
                com.azure.core.util.Context.NONE);

        Assertions.assertEquals("k", response.iterator().next().value());
        Assertions.assertEquals("uqhopafobpyeob", response.iterator().next().description());
        Assertions.assertEquals(PolicyFragmentContentFormat.RAWXML, response.iterator().next().format());
    }
}
