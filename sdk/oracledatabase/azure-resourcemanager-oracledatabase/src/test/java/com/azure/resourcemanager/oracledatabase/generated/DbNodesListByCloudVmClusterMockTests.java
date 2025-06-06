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
import com.azure.resourcemanager.oracledatabase.models.DbNode;
import com.azure.resourcemanager.oracledatabase.models.DbNodeMaintenanceType;
import com.azure.resourcemanager.oracledatabase.models.DbNodeProvisioningState;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DbNodesListByCloudVmClusterMockTests {
    @Test
    public void testListByCloudVmCluster() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"ocid\":\"o\",\"additionalDetails\":\"udcdabtqwpwyawb\",\"backupIpId\":\"sqbuc\",\"backupVnic2Id\":\"gkyexaoguy\",\"backupVnicId\":\"p\",\"cpuCoreCount\":178808534,\"dbNodeStorageSizeInGbs\":1061352715,\"dbServerId\":\"ltxijjumfqwazln\",\"dbSystemId\":\"nm\",\"faultDomain\":\"ngz\",\"hostIpId\":\"qxtbjwgnyf\",\"hostname\":\"fzsvtuikzh\",\"lifecycleState\":\"Updating\",\"lifecycleDetails\":\"glcfhmlrqryxyn\",\"maintenanceType\":\"VmdbRebootMigration\",\"memorySizeInGbs\":1242311262,\"softwareStorageSizeInGb\":1655994607,\"timeCreated\":\"2021-03-13T11:56:36Z\",\"timeMaintenanceWindowEnd\":\"2021-07-07T00:29:31Z\",\"timeMaintenanceWindowStart\":\"2020-12-31T18:39:01Z\",\"vnic2Id\":\"ptgoeiybbabp\",\"vnicId\":\"hv\",\"provisioningState\":\"Succeeded\"},\"id\":\"vntjlrigjk\",\"name\":\"kyrioovzid\",\"type\":\"xwaabzmifrygznmm\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        OracleDatabaseManager manager = OracleDatabaseManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureCloud.AZURE_PUBLIC_CLOUD));

        PagedIterable<DbNode> response
            = manager.dbNodes().listByCloudVmCluster("ferr", "wexjkmfxapjwogq", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("o", response.iterator().next().properties().ocid());
        Assertions.assertEquals("udcdabtqwpwyawb", response.iterator().next().properties().additionalDetails());
        Assertions.assertEquals("sqbuc", response.iterator().next().properties().backupIpId());
        Assertions.assertEquals("gkyexaoguy", response.iterator().next().properties().backupVnic2Id());
        Assertions.assertEquals("p", response.iterator().next().properties().backupVnicId());
        Assertions.assertEquals(178808534, response.iterator().next().properties().cpuCoreCount());
        Assertions.assertEquals(1061352715, response.iterator().next().properties().dbNodeStorageSizeInGbs());
        Assertions.assertEquals("ltxijjumfqwazln", response.iterator().next().properties().dbServerId());
        Assertions.assertEquals("nm", response.iterator().next().properties().dbSystemId());
        Assertions.assertEquals("ngz", response.iterator().next().properties().faultDomain());
        Assertions.assertEquals("qxtbjwgnyf", response.iterator().next().properties().hostIpId());
        Assertions.assertEquals("fzsvtuikzh", response.iterator().next().properties().hostname());
        Assertions.assertEquals(DbNodeProvisioningState.UPDATING,
            response.iterator().next().properties().lifecycleState());
        Assertions.assertEquals("glcfhmlrqryxyn", response.iterator().next().properties().lifecycleDetails());
        Assertions.assertEquals(DbNodeMaintenanceType.VMDB_REBOOT_MIGRATION,
            response.iterator().next().properties().maintenanceType());
        Assertions.assertEquals(1242311262, response.iterator().next().properties().memorySizeInGbs());
        Assertions.assertEquals(1655994607, response.iterator().next().properties().softwareStorageSizeInGb());
        Assertions.assertEquals(OffsetDateTime.parse("2021-03-13T11:56:36Z"),
            response.iterator().next().properties().timeCreated());
        Assertions.assertEquals(OffsetDateTime.parse("2021-07-07T00:29:31Z"),
            response.iterator().next().properties().timeMaintenanceWindowEnd());
        Assertions.assertEquals(OffsetDateTime.parse("2020-12-31T18:39:01Z"),
            response.iterator().next().properties().timeMaintenanceWindowStart());
        Assertions.assertEquals("ptgoeiybbabp", response.iterator().next().properties().vnic2Id());
        Assertions.assertEquals("hv", response.iterator().next().properties().vnicId());
    }
}
