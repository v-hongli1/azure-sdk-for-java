// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotfirmwaredefense.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.iotfirmwaredefense.IoTFirmwareDefenseManager;
import com.azure.resourcemanager.iotfirmwaredefense.models.SbomComponentResource;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SbomComponentsListByFirmwareMockTests {
    @Test
    public void testListByFirmware() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"componentId\":\"pi\",\"componentName\":\"waasip\",\"version\":\"iobyu\",\"license\":\"rpqlp\",\"filePaths\":[\"ciuqgbdb\",\"t\",\"uvfbtkuwh\",\"mhykojoxafnndl\"],\"provisioningState\":\"Extracting\"},\"id\":\"koymkcd\",\"name\":\"h\",\"type\":\"pkkpw\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        IoTFirmwareDefenseManager manager = IoTFirmwareDefenseManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<SbomComponentResource> response = manager.sbomComponents()
            .listByFirmware("wbwo", "nwashrtd", "kcnqxwbpo", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("pi", response.iterator().next().componentId());
        Assertions.assertEquals("waasip", response.iterator().next().componentName());
        Assertions.assertEquals("iobyu", response.iterator().next().version());
        Assertions.assertEquals("rpqlp", response.iterator().next().license());
        Assertions.assertEquals("ciuqgbdb", response.iterator().next().filePaths().get(0));
    }
}
