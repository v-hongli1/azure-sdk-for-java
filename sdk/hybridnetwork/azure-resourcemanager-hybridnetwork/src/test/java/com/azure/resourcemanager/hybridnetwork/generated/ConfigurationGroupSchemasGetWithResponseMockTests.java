// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridnetwork.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.hybridnetwork.HybridNetworkManager;
import com.azure.resourcemanager.hybridnetwork.models.ConfigurationGroupSchema;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class ConfigurationGroupSchemasGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"provisioningState\":\"Succeeded\",\"versionState\":\"ValidationFailed\",\"description\":\"xk\",\"schemaDefinition\":\"vqihebwtswbzuwf\"},\"location\":\"urageg\",\"tags\":{\"qigkx\":\"cjfelisdjubgg\",\"cyrcmjdmspo\":\"bsazgakg\",\"rylniofrzg\":\"apvu\",\"bcuiiz\":\"zjedmstkvnlv\"},\"id\":\"ktwfa\",\"name\":\"snvpdibmi\",\"type\":\"ostbzbkiwb\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        HybridNetworkManager manager = HybridNetworkManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        ConfigurationGroupSchema response = manager.configurationGroupSchemas()
            .getWithResponse("htmwwinh", "hfqpofv", "bcblemb", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("urageg", response.location());
        Assertions.assertEquals("cjfelisdjubgg", response.tags().get("qigkx"));
        Assertions.assertEquals("xk", response.properties().description());
        Assertions.assertEquals("vqihebwtswbzuwf", response.properties().schemaDefinition());
    }
}
