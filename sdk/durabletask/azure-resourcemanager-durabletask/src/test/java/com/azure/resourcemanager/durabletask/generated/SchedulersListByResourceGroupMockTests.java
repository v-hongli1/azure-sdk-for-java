// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.durabletask.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.durabletask.DurableTaskManager;
import com.azure.resourcemanager.durabletask.models.Scheduler;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SchedulersListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Updating\",\"endpoint\":\"mdwzjeiachboo\",\"ipAllowlist\":[\"lnrosfqp\",\"eeh\",\"zvypyqrimzinp\",\"swjdkirso\"],\"sku\":{\"name\":\"dqxhcrmnohjtckwh\",\"capacity\":1629637737,\"redundancyState\":\"Zone\"}},\"location\":\"yip\",\"tags\":{\"rcjxvsnbyxqabn\":\"qwpgrjbzn\",\"hurzafblj\":\"ocpcy\"},\"id\":\"gpbtoqcjmklj\",\"name\":\"vbqid\",\"type\":\"qajzyulpkudjkr\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DurableTaskManager manager = DurableTaskManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Scheduler> response
            = manager.schedulers().listByResourceGroup("yc", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("yip", response.iterator().next().location());
        Assertions.assertEquals("qwpgrjbzn", response.iterator().next().tags().get("rcjxvsnbyxqabn"));
        Assertions.assertEquals("lnrosfqp", response.iterator().next().properties().ipAllowlist().get(0));
        Assertions.assertEquals("dqxhcrmnohjtckwh", response.iterator().next().properties().sku().name());
        Assertions.assertEquals(1629637737, response.iterator().next().properties().sku().capacity());
    }
}
