// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.containerservicefleet.ContainerServiceFleetManager;
import com.azure.resourcemanager.containerservicefleet.models.FleetUpdateStrategy;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class FleetUpdateStrategiesGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Failed\",\"strategy\":{\"stages\":[{\"name\":\"wiwubm\",\"groups\":[{\"name\":\"esl\"},{\"name\":\"nkww\"},{\"name\":\"pp\"},{\"name\":\"flcxoga\"}],\"afterStageWaitInSeconds\":584568005},{\"name\":\"nzmnsikvm\",\"groups\":[{\"name\":\"eqqkdltfzxm\"}],\"afterStageWaitInSeconds\":172476059},{\"name\":\"hgure\",\"groups\":[{\"name\":\"wobdagxtibqdx\"},{\"name\":\"xwak\"},{\"name\":\"ogqxndlkzgxhuri\"}],\"afterStageWaitInSeconds\":1090180987},{\"name\":\"podxunkb\",\"groups\":[{\"name\":\"mubyynt\"},{\"name\":\"lrb\"},{\"name\":\"tkoievseotgq\"},{\"name\":\"l\"}],\"afterStageWaitInSeconds\":1147743130}]}},\"eTag\":\"wlauwzizxbmpg\",\"id\":\"efuzmuvpbttd\",\"name\":\"morppxebmnzbtbh\",\"type\":\"pglkf\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ContainerServiceFleetManager manager = ContainerServiceFleetManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        FleetUpdateStrategy response = manager.fleetUpdateStrategies()
            .getWithResponse("tmweriofzpyq", "emwabnet", "hhszh", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("wiwubm", response.strategy().stages().get(0).name());
        Assertions.assertEquals("esl", response.strategy().stages().get(0).groups().get(0).name());
        Assertions.assertEquals(584568005, response.strategy().stages().get(0).afterStageWaitInSeconds());
    }
}
