// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.models.AzureCloud;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.netapp.NetAppFilesManager;
import com.azure.resourcemanager.netapp.models.EndpointType;
import com.azure.resourcemanager.netapp.models.Replication;
import com.azure.resourcemanager.netapp.models.ReplicationSchedule;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class VolumesListReplicationsMockTests {
    @Test
    public void testListReplications() throws Exception {
        String responseStr
            = "{\"value\":[{\"replicationId\":\"edexxmlfm\",\"endpointType\":\"dst\",\"replicationSchedule\":\"_10minutely\",\"remoteVolumeResourceId\":\"zuawxtzxpuamwa\",\"remoteVolumeRegion\":\"xrvxcushsphai\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        NetAppFilesManager manager = NetAppFilesManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<Replication> response = manager.volumes()
            .listReplications("ttzhra", "lkafhonqjuje", "ckpzvcpopmxeln", "clt", com.azure.core.util.Context.NONE);

        Assertions.assertEquals(EndpointType.DST, response.iterator().next().endpointType());
        Assertions.assertEquals(ReplicationSchedule.ONE_ZEROMINUTELY, response.iterator().next().replicationSchedule());
        Assertions.assertEquals("zuawxtzxpuamwa", response.iterator().next().remoteVolumeResourceId());
        Assertions.assertEquals("xrvxcushsphai", response.iterator().next().remoteVolumeRegion());
    }
}
