// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmosdbforpostgresql.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.cosmosdbforpostgresql.CosmosDBForPostgreSqlManager;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PrivateEndpoint;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PrivateEndpointConnection;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PrivateEndpointServiceConnectionStatus;
import com.azure.resourcemanager.cosmosdbforpostgresql.models.PrivateLinkServiceConnectionState;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PrivateEndpointConnectionsCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"groupIds\":[\"foakgg\",\"fpagaowpulp\"],\"privateEndpoint\":{\"id\":\"ylsyxkqjnsje\"},\"privateLinkServiceConnectionState\":{\"status\":\"Rejected\",\"description\":\"agxsdszuemps\",\"actionsRequired\":\"kfzbeyvpnqicvi\"},\"provisioningState\":\"Succeeded\"},\"id\":\"jxdxrbuukz\",\"name\":\"lewyhmlwpaz\",\"type\":\"zpof\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        CosmosDBForPostgreSqlManager manager = CosmosDBForPostgreSqlManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PrivateEndpointConnection response = manager.privateEndpointConnections()
            .define("xiilivpdtiirqt")
            .withExistingServerGroupsv2("thzvaytdwkqbrqu", "paxh")
            .withPrivateEndpoint(new PrivateEndpoint())
            .withPrivateLinkServiceConnectionState(
                new PrivateLinkServiceConnectionState().withStatus(PrivateEndpointServiceConnectionStatus.APPROVED)
                    .withDescription("oa")
                    .withActionsRequired("kniod"))
            .create();

        Assertions.assertEquals(PrivateEndpointServiceConnectionStatus.REJECTED,
            response.privateLinkServiceConnectionState().status());
        Assertions.assertEquals("agxsdszuemps", response.privateLinkServiceConnectionState().description());
        Assertions.assertEquals("kfzbeyvpnqicvi", response.privateLinkServiceConnectionState().actionsRequired());
    }
}
