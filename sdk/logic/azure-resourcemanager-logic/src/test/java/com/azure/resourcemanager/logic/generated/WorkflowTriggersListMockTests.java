// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.logic.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.logic.LogicManager;
import com.azure.resourcemanager.logic.models.WorkflowTrigger;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class WorkflowTriggersListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Registering\",\"createdTime\":\"2021-04-11T16:59:14Z\",\"changedTime\":\"2021-05-01T01:18:09Z\",\"state\":\"Completed\",\"status\":\"NotSpecified\",\"lastExecutionTime\":\"2021-03-26T19:04Z\",\"nextExecutionTime\":\"2021-01-05T19:17:51Z\",\"recurrence\":{\"frequency\":\"NotSpecified\",\"interval\":1022163228,\"startTime\":\"ppxthsfux\",\"endTime\":\"goexudn\",\"timeZone\":\"oorgtxdlewhbxvri\",\"schedule\":{\"minutes\":[990789977,1212762636,1810908296],\"hours\":[400889009],\"weekDays\":[\"Thursday\",\"Monday\",\"Monday\"],\"monthDays\":[1071751296],\"monthlyOccurrences\":[{}]}},\"workflow\":{\"id\":\"atp\",\"name\":\"ljajz\",\"type\":\"gwarbvblat\"}},\"name\":\"jk\",\"type\":\"todgisfej\",\"id\":\"p\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        LogicManager manager = LogicManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<WorkflowTrigger> response = manager.workflowTriggers()
            .list("rwfu", "xalvdhmumsmnub", 1775243032, "xrpstypxidqnv", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("p", response.iterator().next().id());
    }
}
