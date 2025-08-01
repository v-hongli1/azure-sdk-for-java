// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.providerhub.ProviderHubManager;
import com.azure.resourcemanager.providerhub.models.SkuResource;
import com.azure.resourcemanager.providerhub.models.SkuScaleType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SkusGetWithResponseMockTests {
    @Test
    public void testGetWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"skuSettings\":[{\"name\":\"p\",\"tier\":\"slwhdmcvhtbb\",\"size\":\"hfvhuwzbxpcqz\",\"family\":\"hotjec\",\"kind\":\"mx\",\"locations\":[\"rrskapbxwieexuy\",\"derltfokyksyim\"],\"locationInfo\":[{\"location\":\"grvkcxzznnuif\"},{\"location\":\"rsejegprkj\"},{\"location\":\"uw\"},{\"location\":\"jmwvvbtuqkxxi\"}],\"requiredQuotaIds\":[\"xqldek\"],\"requiredFeatures\":[\"gxieqfkyfhi\",\"vjaqu\",\"by\"],\"capacity\":{\"minimum\":719939038,\"maximum\":720463808,\"default\":41577514,\"scaleType\":\"Manual\"},\"costs\":[{\"meterId\":\"eumexmjbxc\"},{\"meterId\":\"ccwkqmtx\"}],\"capabilities\":[{\"name\":\"qis\",\"value\":\"rpilgftrqrejdaah\"}]}],\"provisioningState\":\"Creating\"},\"id\":\"ldahlfxlmu\",\"name\":\"fmuad\",\"type\":\"nfsncs\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ProviderHubManager manager = ProviderHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        SkuResource response = manager.skus()
            .getWithResponse("pbpgnrholhujbfwx", "plkys", "l", com.azure.core.util.Context.NONE)
            .getValue();

        Assertions.assertEquals("p", response.properties().skuSettings().get(0).name());
        Assertions.assertEquals("slwhdmcvhtbb", response.properties().skuSettings().get(0).tier());
        Assertions.assertEquals("hfvhuwzbxpcqz", response.properties().skuSettings().get(0).size());
        Assertions.assertEquals("hotjec", response.properties().skuSettings().get(0).family());
        Assertions.assertEquals("mx", response.properties().skuSettings().get(0).kind());
        Assertions.assertEquals("rrskapbxwieexuy", response.properties().skuSettings().get(0).locations().get(0));
        Assertions.assertEquals("grvkcxzznnuif",
            response.properties().skuSettings().get(0).locationInfo().get(0).location());
        Assertions.assertEquals("xqldek", response.properties().skuSettings().get(0).requiredQuotaIds().get(0));
        Assertions.assertEquals("gxieqfkyfhi", response.properties().skuSettings().get(0).requiredFeatures().get(0));
        Assertions.assertEquals(719939038, response.properties().skuSettings().get(0).capacity().minimum());
        Assertions.assertEquals(720463808, response.properties().skuSettings().get(0).capacity().maximum());
        Assertions.assertEquals(41577514, response.properties().skuSettings().get(0).capacity().defaultProperty());
        Assertions.assertEquals(SkuScaleType.MANUAL, response.properties().skuSettings().get(0).capacity().scaleType());
        Assertions.assertEquals("eumexmjbxc", response.properties().skuSettings().get(0).costs().get(0).meterId());
        Assertions.assertEquals("qis", response.properties().skuSettings().get(0).capabilities().get(0).name());
        Assertions.assertEquals("rpilgftrqrejdaah",
            response.properties().skuSettings().get(0).capabilities().get(0).value());
    }
}
