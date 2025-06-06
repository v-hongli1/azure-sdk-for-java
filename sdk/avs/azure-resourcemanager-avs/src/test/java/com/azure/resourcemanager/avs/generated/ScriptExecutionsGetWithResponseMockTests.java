// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.avs.AvsManager;
import com.azure.resourcemanager.avs.models.ScriptExecution;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ScriptExecutionsGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"scriptCmdletId\":\"watmqa\",\"parameters\":[{\"type\":\"ScriptExecutionParameter\",\"name\":\"eatgroeshoy\"},{\"type\":\"ScriptExecutionParameter\",\"name\":\"zcbyfq\"}],\"hiddenParameters\":[{\"type\":\"ScriptExecutionParameter\",\"name\":\"aoyte\"},{\"type\":\"ScriptExecutionParameter\",\"name\":\"qpuvjmv\"},{\"type\":\"ScriptExecutionParameter\",\"name\":\"mtdwcky\"}],\"failureReason\":\"oejnndljdju\",\"timeout\":\"kb\",\"retention\":\"eqy\",\"submittedAt\":\"2021-11-21T07:30:22Z\",\"startedAt\":\"2021-09-18T05:11:06Z\",\"finishedAt\":\"2021-08-22T22:08:22Z\",\"provisioningState\":\"Succeeded\",\"output\":[\"pl\",\"ryshwddkvbxgk\"],\"namedOutputs\":{\"arvvlfnt\":\"dataybwptda\",\"oiwenazerohzrsq\":\"datamt\",\"wqapfgsdp\":\"datalsxkd\"},\"information\":[\"ssmzhhkuui\",\"ldqqctekv\",\"lblhtjq\"],\"warnings\":[\"vweht\",\"emxhzzy\",\"ev\"],\"errors\":[\"ivzrrryveimipsk\",\"yzatvfuzkaft\"]},\"id\":\"vru\",\"name\":\"wigsyeipqdsm\",\"type\":\"tgrqgdgkkile\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AvsManager manager = AvsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        ScriptExecution response = manager.scriptExecutions()
            .getWithResponse("vwisp", "xkdtxfkndlqvtwkn", "gmmbu", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("watmqa", response.scriptCmdletId());
        Assertions.assertEquals("eatgroeshoy", response.parameters().get(0).name());
        Assertions.assertEquals("aoyte", response.hiddenParameters().get(0).name());
        Assertions.assertEquals("oejnndljdju", response.failureReason());
        Assertions.assertEquals("kb", response.timeout());
        Assertions.assertEquals("eqy", response.retention());
        Assertions.assertEquals("pl", response.output().get(0));
    }
}
