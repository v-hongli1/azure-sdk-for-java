// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storageactions.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.storageactions.StorageActionsManager;
import com.azure.resourcemanager.storageactions.models.ManagedServiceIdentityType;
import com.azure.resourcemanager.storageactions.models.StorageTask;
import com.azure.resourcemanager.storageactions.models.StorageTaskOperationName;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class StorageTasksListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"identity\":{\"principalId\":\"86428182-8c91-44b6-8efa-d39e7f75367f\",\"tenantId\":\"61fefe32-6acc-437c-b38d-9b808fcbd63d\",\"type\":\"None\",\"userAssignedIdentities\":{\"ok\":{\"principalId\":\"53b4df2f-342a-42a7-bbee-7d6efa18c9f9\",\"clientId\":\"f8930408-eab6-4732-9665-a663651805db\"},\"jyoxgvclt\":{\"principalId\":\"a0e81129-d10b-4182-a51e-3fef4fe158a7\",\"clientId\":\"269a2beb-5f59-4c90-84d5-c210c2ef73a1\"},\"ncghkje\":{\"principalId\":\"c6e8aaea-7223-46d4-af27-a55e99b2a0c8\",\"clientId\":\"6cbde63d-fa7b-4d6d-9c07-93ca62642a97\"},\"hbijhtxfvgxb\":{\"principalId\":\"aa35ebb1-57db-41c1-8b35-76dc989fef05\",\"clientId\":\"1687c360-55dc-4cff-914e-0b8d823645a1\"}}},\"properties\":{\"taskVersion\":7678271281177155084,\"enabled\":true,\"description\":\"eh\",\"action\":{\"if\":{\"condition\":\"pvecxgodeb\",\"operations\":[{\"name\":\"SetBlobTier\"},{\"name\":\"SetBlobLegalHold\"}]},\"else\":{\"operations\":[{\"name\":\"SetBlobTier\"},{\"name\":\"SetBlobExpiry\"},{\"name\":\"UndeleteBlob\"}]}},\"provisioningState\":\"ValidateSubscriptionQuotaBegin\",\"creationTimeInUtc\":\"2021-10-09T22:24:23Z\"},\"location\":\"flz\",\"tags\":{\"qzahmgkbrp\":\"xzpuzycisp\",\"hibnuqqkpika\":\"y\",\"buynhijggm\":\"rgvtqag\"},\"id\":\"bfs\",\"name\":\"arbu\",\"type\":\"rcvpnazzmhjrunmp\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        StorageActionsManager manager = StorageActionsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<StorageTask> response = manager.storageTasks().list(com.azure.core.util.Context.NONE);

        Assertions.assertEquals("flz", response.iterator().next().location());
        Assertions.assertEquals("xzpuzycisp", response.iterator().next().tags().get("qzahmgkbrp"));
        Assertions.assertEquals(ManagedServiceIdentityType.NONE, response.iterator().next().identity().type());
        Assertions.assertTrue(response.iterator().next().properties().enabled());
        Assertions.assertEquals("eh", response.iterator().next().properties().description());
        Assertions.assertEquals("pvecxgodeb",
            response.iterator().next().properties().action().ifProperty().condition());
        Assertions.assertEquals(StorageTaskOperationName.SET_BLOB_TIER,
            response.iterator().next().properties().action().ifProperty().operations().get(0).name());
        Assertions.assertEquals(StorageTaskOperationName.SET_BLOB_TIER,
            response.iterator().next().properties().action().elseProperty().operations().get(0).name());
    }
}
