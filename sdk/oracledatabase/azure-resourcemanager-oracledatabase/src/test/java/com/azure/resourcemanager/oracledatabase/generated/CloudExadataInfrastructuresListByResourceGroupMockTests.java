// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.oracledatabase.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.oracledatabase.OracleDatabaseManager;
import com.azure.resourcemanager.oracledatabase.models.CloudExadataInfrastructure;
import com.azure.resourcemanager.oracledatabase.models.DayOfWeekName;
import com.azure.resourcemanager.oracledatabase.models.MonthName;
import com.azure.resourcemanager.oracledatabase.models.PatchingMode;
import com.azure.resourcemanager.oracledatabase.models.Preference;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class CloudExadataInfrastructuresListByResourceGroupMockTests {
    @Test
    public void testListByResourceGroup() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"ocid\":\"biipuip\",\"computeCount\":1675022105,\"storageCount\":1120696384,\"totalStorageSizeInGbs\":1863787560,\"availableStorageSizeInGbs\":219234320,\"timeCreated\":\"k\",\"lifecycleDetails\":\"zshq\",\"maintenanceWindow\":{\"preference\":\"NoPreference\",\"months\":[{\"name\":\"March\"}],\"weeksOfMonth\":[716188449,64895608],\"daysOfWeek\":[{\"name\":\"Sunday\"},{\"name\":\"Wednesday\"},{\"name\":\"Tuesday\"},{\"name\":\"Thursday\"}],\"hoursOfDay\":[930610088,1550180718],\"leadTimeInWeeks\":1854784529,\"patchingMode\":\"Rolling\",\"customActionTimeoutInMins\":922125964,\"isCustomActionTimeoutEnabled\":false,\"isMonthlyPatchingEnabled\":false},\"estimatedPatchingTime\":{\"estimatedDbServerPatchingTime\":1970760163,\"estimatedNetworkSwitchesPatchingTime\":2094171015,\"estimatedStorageServerPatchingTime\":781598898,\"totalEstimatedPatchingTime\":1999414611},\"customerContacts\":[{\"email\":\"i\"},{\"email\":\"dvoqyt\"},{\"email\":\"byowbblgyavutp\"}],\"provisioningState\":\"Failed\",\"lifecycleState\":\"Provisioning\",\"shape\":\"oismsksbpimlqol\",\"ociUrl\":\"kcgxxlxsffgcvi\",\"cpuCount\":1820797792,\"maxCpuCount\":514804559,\"memorySizeInGbs\":1803667290,\"maxMemoryInGbs\":946666624,\"dbNodeStorageSizeInGbs\":1861564740,\"maxDbNodeStorageSizeInGbs\":120685932,\"dataStorageSizeInTbs\":58.67148613046069,\"maxDataStorageInTbs\":0.25873654572299287,\"dbServerVersion\":\"bdyhgkfminsgowz\",\"storageServerVersion\":\"tsttktlahbq\",\"activatedStorageCount\":485437008,\"additionalStorageCount\":867480662,\"displayName\":\"gzukxitmm\",\"lastMaintenanceRunId\":\"gqqqxh\",\"nextMaintenanceRunId\":\"xrxc\",\"monthlyDbServerVersion\":\"uisavokq\",\"monthlyStorageServerVersion\":\"fvazivjlfrqttba\"},\"zones\":[\"katnwxyi\",\"pidkqqfkuvscxkdm\",\"igovi\",\"rxkpmloazuruoc\"],\"location\":\"oorb\",\"tags\":{\"vvjgslor\":\"ybfhjxa\",\"yw\":\"il\",\"gkxnyedabg\":\"t\"},\"id\":\"vudtjuewbcihx\",\"name\":\"uwhcjyxccybv\",\"type\":\"ayakkudzpx\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        OracleDatabaseManager manager = OracleDatabaseManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<CloudExadataInfrastructure> response = manager.cloudExadataInfrastructures()
            .listByResourceGroup("chvcyyysfgdo", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("oorb", response.iterator().next().location());
        Assertions.assertEquals("ybfhjxa", response.iterator().next().tags().get("vvjgslor"));
        Assertions.assertEquals(1675022105, response.iterator().next().properties().computeCount());
        Assertions.assertEquals(1120696384, response.iterator().next().properties().storageCount());
        Assertions.assertEquals(Preference.NO_PREFERENCE,
            response.iterator().next().properties().maintenanceWindow().preference());
        Assertions.assertEquals(MonthName.MARCH,
            response.iterator().next().properties().maintenanceWindow().months().get(0).name());
        Assertions.assertEquals(716188449,
            response.iterator().next().properties().maintenanceWindow().weeksOfMonth().get(0));
        Assertions.assertEquals(DayOfWeekName.SUNDAY,
            response.iterator().next().properties().maintenanceWindow().daysOfWeek().get(0).name());
        Assertions.assertEquals(930610088,
            response.iterator().next().properties().maintenanceWindow().hoursOfDay().get(0));
        Assertions.assertEquals(1854784529,
            response.iterator().next().properties().maintenanceWindow().leadTimeInWeeks());
        Assertions.assertEquals(PatchingMode.ROLLING,
            response.iterator().next().properties().maintenanceWindow().patchingMode());
        Assertions.assertEquals(922125964,
            response.iterator().next().properties().maintenanceWindow().customActionTimeoutInMins());
        Assertions.assertEquals(false,
            response.iterator().next().properties().maintenanceWindow().isCustomActionTimeoutEnabled());
        Assertions.assertEquals(false,
            response.iterator().next().properties().maintenanceWindow().isMonthlyPatchingEnabled());
        Assertions.assertEquals("i", response.iterator().next().properties().customerContacts().get(0).email());
        Assertions.assertEquals("oismsksbpimlqol", response.iterator().next().properties().shape());
        Assertions.assertEquals("gzukxitmm", response.iterator().next().properties().displayName());
        Assertions.assertEquals("katnwxyi", response.iterator().next().zones().get(0));
    }
}
