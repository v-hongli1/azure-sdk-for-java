// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.netapp.fluent.models.SnapshotPolicyInner;
import com.azure.resourcemanager.netapp.models.DailySchedule;
import com.azure.resourcemanager.netapp.models.HourlySchedule;
import com.azure.resourcemanager.netapp.models.MonthlySchedule;
import com.azure.resourcemanager.netapp.models.SnapshotPoliciesList;
import com.azure.resourcemanager.netapp.models.WeeklySchedule;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class SnapshotPoliciesListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SnapshotPoliciesList model = BinaryData.fromString(
            "{\"value\":[{\"etag\":\"wuipiccjzkzivg\",\"properties\":{\"hourlySchedule\":{\"snapshotsToKeep\":1892001157,\"minute\":192957128,\"usedBytes\":8913535749004515550},\"dailySchedule\":{\"snapshotsToKeep\":1925040131,\"hour\":1333255063,\"minute\":1895502820,\"usedBytes\":9137242569252833170},\"weeklySchedule\":{\"snapshotsToKeep\":1429248323,\"day\":\"stkwqqtch\",\"hour\":96926313,\"minute\":1505256116,\"usedBytes\":2875480604821792642},\"monthlySchedule\":{\"snapshotsToKeep\":1434664141,\"daysOfMonth\":\"dvwvgpio\",\"hour\":976430532,\"minute\":434631779,\"usedBytes\":7829146254653912667},\"enabled\":true,\"provisioningState\":\"pxgy\"},\"location\":\"gvr\",\"tags\":{\"dblx\":\"pkukghi\",\"fnjhfjxwmszkkfo\":\"wi\",\"kzikfjawneaivxwc\":\"rey\",\"fatkld\":\"elpcirelsfeaenwa\"},\"id\":\"xbjhwuaanozjosph\",\"name\":\"oulpjrv\",\"type\":\"ag\"},{\"etag\":\"vimjwos\",\"properties\":{\"hourlySchedule\":{\"snapshotsToKeep\":559166654,\"minute\":1413257471,\"usedBytes\":9203595708461944640},\"dailySchedule\":{\"snapshotsToKeep\":468391476,\"hour\":279496369,\"minute\":1686364184,\"usedBytes\":8833737654987642365},\"weeklySchedule\":{\"snapshotsToKeep\":1320070179,\"day\":\"khly\",\"hour\":1943663819,\"minute\":1081755723,\"usedBytes\":2422688696917876077},\"monthlySchedule\":{\"snapshotsToKeep\":1278183507,\"daysOfMonth\":\"nyga\",\"hour\":624778524,\"minute\":2007776195,\"usedBytes\":7064706580171927315},\"enabled\":false,\"provisioningState\":\"llrxcyjmoad\"},\"location\":\"varmywdmj\",\"tags\":{\"rw\":\"bjhhyx\"},\"id\":\"yc\",\"name\":\"duhpk\",\"type\":\"kgymareqnajxqug\"}]}")
            .toObject(SnapshotPoliciesList.class);
        Assertions.assertEquals("gvr", model.value().get(0).location());
        Assertions.assertEquals("pkukghi", model.value().get(0).tags().get("dblx"));
        Assertions.assertEquals(1892001157, model.value().get(0).hourlySchedule().snapshotsToKeep());
        Assertions.assertEquals(192957128, model.value().get(0).hourlySchedule().minute());
        Assertions.assertEquals(8913535749004515550L, model.value().get(0).hourlySchedule().usedBytes());
        Assertions.assertEquals(1925040131, model.value().get(0).dailySchedule().snapshotsToKeep());
        Assertions.assertEquals(1333255063, model.value().get(0).dailySchedule().hour());
        Assertions.assertEquals(1895502820, model.value().get(0).dailySchedule().minute());
        Assertions.assertEquals(9137242569252833170L, model.value().get(0).dailySchedule().usedBytes());
        Assertions.assertEquals(1429248323, model.value().get(0).weeklySchedule().snapshotsToKeep());
        Assertions.assertEquals("stkwqqtch", model.value().get(0).weeklySchedule().day());
        Assertions.assertEquals(96926313, model.value().get(0).weeklySchedule().hour());
        Assertions.assertEquals(1505256116, model.value().get(0).weeklySchedule().minute());
        Assertions.assertEquals(2875480604821792642L, model.value().get(0).weeklySchedule().usedBytes());
        Assertions.assertEquals(1434664141, model.value().get(0).monthlySchedule().snapshotsToKeep());
        Assertions.assertEquals("dvwvgpio", model.value().get(0).monthlySchedule().daysOfMonth());
        Assertions.assertEquals(976430532, model.value().get(0).monthlySchedule().hour());
        Assertions.assertEquals(434631779, model.value().get(0).monthlySchedule().minute());
        Assertions.assertEquals(7829146254653912667L, model.value().get(0).monthlySchedule().usedBytes());
        Assertions.assertEquals(true, model.value().get(0).enabled());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SnapshotPoliciesList model = new SnapshotPoliciesList().withValue(Arrays.asList(
            new SnapshotPolicyInner().withLocation("gvr")
                .withTags(mapOf("dblx", "pkukghi", "fnjhfjxwmszkkfo", "wi", "kzikfjawneaivxwc", "rey", "fatkld",
                    "elpcirelsfeaenwa"))
                .withHourlySchedule(new HourlySchedule().withSnapshotsToKeep(1892001157)
                    .withMinute(192957128)
                    .withUsedBytes(8913535749004515550L))
                .withDailySchedule(new DailySchedule().withSnapshotsToKeep(1925040131)
                    .withHour(1333255063)
                    .withMinute(1895502820)
                    .withUsedBytes(9137242569252833170L))
                .withWeeklySchedule(new WeeklySchedule().withSnapshotsToKeep(1429248323)
                    .withDay("stkwqqtch")
                    .withHour(96926313)
                    .withMinute(1505256116)
                    .withUsedBytes(2875480604821792642L))
                .withMonthlySchedule(new MonthlySchedule().withSnapshotsToKeep(1434664141)
                    .withDaysOfMonth("dvwvgpio")
                    .withHour(976430532)
                    .withMinute(434631779)
                    .withUsedBytes(7829146254653912667L))
                .withEnabled(true),
            new SnapshotPolicyInner().withLocation("varmywdmj")
                .withTags(mapOf("rw", "bjhhyx"))
                .withHourlySchedule(new HourlySchedule().withSnapshotsToKeep(559166654)
                    .withMinute(1413257471)
                    .withUsedBytes(9203595708461944640L))
                .withDailySchedule(new DailySchedule().withSnapshotsToKeep(468391476)
                    .withHour(279496369)
                    .withMinute(1686364184)
                    .withUsedBytes(8833737654987642365L))
                .withWeeklySchedule(new WeeklySchedule().withSnapshotsToKeep(1320070179)
                    .withDay("khly")
                    .withHour(1943663819)
                    .withMinute(1081755723)
                    .withUsedBytes(2422688696917876077L))
                .withMonthlySchedule(new MonthlySchedule().withSnapshotsToKeep(1278183507)
                    .withDaysOfMonth("nyga")
                    .withHour(624778524)
                    .withMinute(2007776195)
                    .withUsedBytes(7064706580171927315L))
                .withEnabled(false)));
        model = BinaryData.fromObject(model).toObject(SnapshotPoliciesList.class);
        Assertions.assertEquals("gvr", model.value().get(0).location());
        Assertions.assertEquals("pkukghi", model.value().get(0).tags().get("dblx"));
        Assertions.assertEquals(1892001157, model.value().get(0).hourlySchedule().snapshotsToKeep());
        Assertions.assertEquals(192957128, model.value().get(0).hourlySchedule().minute());
        Assertions.assertEquals(8913535749004515550L, model.value().get(0).hourlySchedule().usedBytes());
        Assertions.assertEquals(1925040131, model.value().get(0).dailySchedule().snapshotsToKeep());
        Assertions.assertEquals(1333255063, model.value().get(0).dailySchedule().hour());
        Assertions.assertEquals(1895502820, model.value().get(0).dailySchedule().minute());
        Assertions.assertEquals(9137242569252833170L, model.value().get(0).dailySchedule().usedBytes());
        Assertions.assertEquals(1429248323, model.value().get(0).weeklySchedule().snapshotsToKeep());
        Assertions.assertEquals("stkwqqtch", model.value().get(0).weeklySchedule().day());
        Assertions.assertEquals(96926313, model.value().get(0).weeklySchedule().hour());
        Assertions.assertEquals(1505256116, model.value().get(0).weeklySchedule().minute());
        Assertions.assertEquals(2875480604821792642L, model.value().get(0).weeklySchedule().usedBytes());
        Assertions.assertEquals(1434664141, model.value().get(0).monthlySchedule().snapshotsToKeep());
        Assertions.assertEquals("dvwvgpio", model.value().get(0).monthlySchedule().daysOfMonth());
        Assertions.assertEquals(976430532, model.value().get(0).monthlySchedule().hour());
        Assertions.assertEquals(434631779, model.value().get(0).monthlySchedule().minute());
        Assertions.assertEquals(7829146254653912667L, model.value().get(0).monthlySchedule().usedBytes());
        Assertions.assertEquals(true, model.value().get(0).enabled());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
