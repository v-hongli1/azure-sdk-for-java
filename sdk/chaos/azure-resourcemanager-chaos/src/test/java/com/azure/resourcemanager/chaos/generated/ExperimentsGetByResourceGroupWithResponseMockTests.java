// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.chaos.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.chaos.ChaosManager;
import com.azure.resourcemanager.chaos.models.Experiment;
import com.azure.resourcemanager.chaos.models.ResourceIdentityType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ExperimentsGetByResourceGroupWithResponseMockTests {
    @Test
    public void testGetByResourceGroupWithResponse() throws Exception {
        String responseStr
            = "{\"identity\":{\"type\":\"SystemAssigned\",\"userAssignedIdentities\":{\"opqgikyzirtxdyux\":{\"principalId\":\"11bfccb8-091b-4396-ac7f-4a3661819ad9\",\"clientId\":\"03ce86b3-7836-4d0f-941d-a3636ee0f4db\"},\"ntps\":{\"principalId\":\"fc8311c3-9c68-4898-b7e7-d8389895dd54\",\"clientId\":\"f6a5722b-3a59-4fb7-a222-66619357a1fb\"},\"ioilqukrydxtq\":{\"principalId\":\"56d3852c-c618-4166-a4a3-9d23296b57b2\",\"clientId\":\"e5a56a23-cc84-4843-9824-8fe74201885c\"},\"ox\":{\"principalId\":\"844c5723-5023-42b4-ab08-72f752953f81\",\"clientId\":\"7586d2a0-ae2f-47a2-991e-d55823b33ddf\"}},\"principalId\":\"ggufhyaomtb\",\"tenantId\":\"havgrvk\"},\"properties\":{\"provisioningState\":\"Creating\",\"steps\":[{\"name\":\"jzhpjbibgjmfx\",\"branches\":[{\"name\":\"vfcluyovwxnbkfe\",\"actions\":[]}]},{\"name\":\"zxscyhwzdgirujb\",\"branches\":[{\"name\":\"omvzzbtd\",\"actions\":[]},{\"name\":\"qvpn\",\"actions\":[]},{\"name\":\"yujviylwdshfssn\",\"actions\":[]}]},{\"name\":\"bgye\",\"branches\":[{\"name\":\"ymsgaojfmwnc\",\"actions\":[]},{\"name\":\"tmr\",\"actions\":[]},{\"name\":\"hirctymoxoftpipi\",\"actions\":[]}]}],\"selectors\":[{\"type\":\"ChaosTargetSelector\",\"id\":\"czuhxacpqjlihh\",\"filter\":{\"type\":\"ChaosTargetFilter\"},\"\":{\"ucvpamrs\":\"dataskasdvlmfwdgzxu\",\"risjnhnytxifqjz\":\"dataeuzvx\",\"lw\":\"dataxmrhu\",\"woqhihe\":\"datacesutrgjupauut\"}},{\"type\":\"ChaosTargetSelector\",\"id\":\"qg\",\"filter\":{\"type\":\"ChaosTargetFilter\"},\"\":{\"xjvfoimwksl\":\"datafqntcyp\"}},{\"type\":\"ChaosTargetSelector\",\"id\":\"rcizjxvyd\",\"filter\":{\"type\":\"ChaosTargetFilter\"},\"\":{\"gdyftumrtwna\":\"datacvlhv\",\"wkojgcyztsfmzn\":\"datajslb\"}}]},\"location\":\"aeqphchqnr\",\"tags\":{\"huwrykqgaifm\":\"x\",\"jdz\":\"iklbydvkhb\",\"srhnjivo\":\"xcv\"},\"id\":\"v\",\"name\":\"novqfzge\",\"type\":\"jdftuljltd\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ChaosManager manager = ChaosManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        Experiment response = manager.experiments()
            .getByResourceGroupWithResponse("z", "ybycnunvj", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("aeqphchqnr", response.location());
        Assertions.assertEquals("x", response.tags().get("huwrykqgaifm"));
        Assertions.assertEquals(ResourceIdentityType.SYSTEM_ASSIGNED, response.identity().type());
        Assertions.assertEquals("jzhpjbibgjmfx", response.steps().get(0).name());
        Assertions.assertEquals("vfcluyovwxnbkfe", response.steps().get(0).branches().get(0).name());
        Assertions.assertEquals("czuhxacpqjlihh", response.selectors().get(0).id());
    }
}
