// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.postgresqlflexibleserver.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.postgresqlflexibleserver.PostgreSqlManager;
import com.azure.resourcemanager.postgresqlflexibleserver.models.VirtualEndpointResource;
import com.azure.resourcemanager.postgresqlflexibleserver.models.VirtualEndpointType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VirtualEndpointsCreateMockTests {
    @Test
    public void testCreate() throws Exception {
        String responseStr
            = "{\"id\":\"cmmzrrs\",\"name\":\"biwsd\",\"type\":\"pxqwo\",\"properties\":{\"endpointType\":\"ReadWrite\",\"members\":[\"jrmmuabwib\",\"jogjonmc\"],\"virtualEndpoints\":[\"oyzbamwineofvf\",\"akpoldtvevbo\",\"lz\",\"zjknyuxg\"]}}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        PostgreSqlManager manager = PostgreSqlManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        VirtualEndpointResource response = manager.virtualEndpoints()
            .define("hulrtywikdmhla")
            .withExistingFlexibleServer("c", "v")
            .withEndpointType(VirtualEndpointType.READ_WRITE)
            .withMembers(Arrays.asList("mqjch"))
            .create();

        Assertions.assertEquals(VirtualEndpointType.READ_WRITE, response.endpointType());
        Assertions.assertEquals("jrmmuabwib", response.members().get(0));
    }
}
