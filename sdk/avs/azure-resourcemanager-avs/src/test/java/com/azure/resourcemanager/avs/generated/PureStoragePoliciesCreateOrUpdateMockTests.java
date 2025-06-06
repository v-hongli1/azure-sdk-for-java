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
import com.azure.resourcemanager.avs.models.PureStoragePolicy;
import com.azure.resourcemanager.avs.models.PureStoragePolicyProperties;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class PureStoragePoliciesCreateOrUpdateMockTests {
    @Test
    public void testCreateOrUpdate() throws Exception {
        String responseStr
            = "{\"properties\":{\"storagePolicyDefinition\":\"ixqcahyhxalybxaw\",\"storagePoolId\":\"ijpodtblxpkkwj\",\"provisioningState\":\"Succeeded\"},\"id\":\"qhykincn\",\"name\":\"emehllizh\",\"type\":\"eumoqod\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AvsManager manager = AvsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PureStoragePolicy response = manager.pureStoragePolicies()
            .define("xlzdesygrijwa")
            .withExistingPrivateCloud("swmowegmmuteyxe", "guqigijiitns")
            .withProperties(new PureStoragePolicyProperties().withStoragePolicyDefinition("fanraybfu")
                .withStoragePoolId("qfrojsydgrhyd"))
            .create();

        Assertions.assertEquals("ixqcahyhxalybxaw", response.properties().storagePolicyDefinition());
        Assertions.assertEquals("ijpodtblxpkkwj", response.properties().storagePoolId());
    }
}
