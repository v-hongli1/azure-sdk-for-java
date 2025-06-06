// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.oracledatabase.OracleDatabaseManager;
import com.azure.resourcemanager.oracledatabase.models.GiVersion;
import com.azure.resourcemanager.oracledatabase.models.SystemShapes;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class GiVersionsListByLocationMockTests {
    @Test
    public void testListByLocation() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"version\":\"iqbi\"},\"id\":\"tmwwi\",\"name\":\"h\",\"type\":\"hfqpofv\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        OracleDatabaseManager manager = OracleDatabaseManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<GiVersion> response = manager.giVersions()
            .listByLocation("bgsxgnxfyqonmpq", SystemShapes.EXA_DB_XS, "wdofdbxiqx", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("iqbi", response.iterator().next().properties().version());
    }
}
