// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.avs.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.avs.AvsManager;
import com.azure.resourcemanager.avs.models.Datastore;
import com.azure.resourcemanager.avs.models.MountOptionEnum;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DatastoresListMockTests {
    @Test
    public void testList() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"provisioningState\":\"Failed\",\"netAppVolume\":{\"id\":\"pwpgddei\"},\"diskPoolVolume\":{\"targetId\":\"wzovgk\",\"lunName\":\"um\",\"mountOption\":\"ATTACH\",\"path\":\"cjc\"},\"elasticSanVolume\":{\"targetId\":\"tbw\"},\"pureStorageVolume\":{\"storagePoolId\":\"sqowxwc\",\"sizeGb\":1657840420},\"status\":\"DeadOrError\"},\"id\":\"ytwvczcswkacve\",\"name\":\"yfdvlvhbwrnfxtgd\",\"type\":\"pqthehnmnaoya\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        AvsManager manager = AvsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Datastore> response
            = manager.datastores().list("jggsvo", "jkxibda", "hrkmdyomkxfbvfbh", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("pwpgddei", response.iterator().next().netAppVolume().id());
        Assertions.assertEquals("wzovgk", response.iterator().next().diskPoolVolume().targetId());
        Assertions.assertEquals("um", response.iterator().next().diskPoolVolume().lunName());
        Assertions.assertEquals(MountOptionEnum.ATTACH, response.iterator().next().diskPoolVolume().mountOption());
        Assertions.assertEquals("tbw", response.iterator().next().elasticSanVolume().targetId());
        Assertions.assertEquals("sqowxwc", response.iterator().next().pureStorageVolume().storagePoolId());
        Assertions.assertEquals(1657840420, response.iterator().next().pureStorageVolume().sizeGb());
    }
}
