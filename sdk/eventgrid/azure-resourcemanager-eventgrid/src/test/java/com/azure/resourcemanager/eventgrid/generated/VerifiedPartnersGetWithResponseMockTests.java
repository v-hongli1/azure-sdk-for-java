// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.eventgrid.EventGridManager;
import com.azure.resourcemanager.eventgrid.models.VerifiedPartner;
import com.azure.resourcemanager.eventgrid.models.VerifiedPartnerProvisioningState;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.UUID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VerifiedPartnersGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"partnerRegistrationImmutableId\":\"956d353d-d339-4e58-b435-d60464fb55c7\",\"organizationName\":\"lndyclwgycv\",\"partnerDisplayName\":\"nzjcyqqzhembtbw\",\"partnerTopicDetails\":{\"description\":\"ba\",\"longDescription\":\"isj\",\"setupUri\":\"eajvmvvlooubsfx\"},\"partnerDestinationDetails\":{\"description\":\"eopsk\",\"longDescription\":\"cjomlupf\",\"setupUri\":\"usjcd\"},\"provisioningState\":\"Canceled\"},\"id\":\"gdw\",\"name\":\"rgdqyxaj\",\"type\":\"lgrcavqcwyzoqzkm\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        EventGridManager manager = EventGridManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        VerifiedPartner response
            = manager.verifiedPartners().getWithResponse("wpsibxovuqoq", com.azure.core.util.Context.NONE).getValue();

        Assertions.assertEquals(UUID.fromString("956d353d-d339-4e58-b435-d60464fb55c7"),
            response.partnerRegistrationImmutableId());
        Assertions.assertEquals("lndyclwgycv", response.organizationName());
        Assertions.assertEquals("nzjcyqqzhembtbw", response.partnerDisplayName());
        Assertions.assertEquals("ba", response.partnerTopicDetails().description());
        Assertions.assertEquals("isj", response.partnerTopicDetails().longDescription());
        Assertions.assertEquals("eajvmvvlooubsfx", response.partnerTopicDetails().setupUri());
        Assertions.assertEquals("eopsk", response.partnerDestinationDetails().description());
        Assertions.assertEquals("cjomlupf", response.partnerDestinationDetails().longDescription());
        Assertions.assertEquals("usjcd", response.partnerDestinationDetails().setupUri());
        Assertions.assertEquals(VerifiedPartnerProvisioningState.CANCELED, response.provisioningState());
    }
}
