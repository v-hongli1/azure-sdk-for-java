// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.Activity;
import com.azure.resourcemanager.datafactory.models.ActivityDependency;
import com.azure.resourcemanager.datafactory.models.ActivityOnInactiveMarkAs;
import com.azure.resourcemanager.datafactory.models.ActivityState;
import com.azure.resourcemanager.datafactory.models.DependencyCondition;
import com.azure.resourcemanager.datafactory.models.Expression;
import com.azure.resourcemanager.datafactory.models.IfConditionActivity;
import com.azure.resourcemanager.datafactory.models.UserProperty;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class IfConditionActivityTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IfConditionActivity model = BinaryData.fromString(
            "{\"type\":\"IfCondition\",\"typeProperties\":{\"expression\":{\"value\":\"ygzaya\"},\"ifTrueActivities\":[{\"type\":\"Activity\",\"name\":\"mlae\",\"description\":\"hucxmybuqjpgbiya\",\"state\":\"Active\",\"onInactiveMarkAs\":\"Succeeded\",\"dependsOn\":[{\"activity\":\"inhpvbmbfi\",\"dependencyConditions\":[\"Completed\",\"Failed\"],\"\":{\"wasl\":\"dataydkdcv\",\"otief\":\"datawwgzyvo\",\"kjblmypuonuvmym\":\"datahaqqavhfdezom\"}},{\"activity\":\"aiwxlrphaddsxs\",\"dependencyConditions\":[\"Succeeded\"],\"\":{\"roedwipauclety\":\"datayzd\"}}],\"userProperties\":[{\"name\":\"iavguskvvnzngh\",\"value\":\"dataoqe\"}],\"\":{\"jkkvacizdaejn\":\"datayfl\",\"wyfuqqbafrbhr\":\"datab\",\"kvok\":\"datap\"}},{\"type\":\"Activity\",\"name\":\"mere\",\"description\":\"oessuwkcnhdecxbi\",\"state\":\"Inactive\",\"onInactiveMarkAs\":\"Failed\",\"dependsOn\":[{\"activity\":\"fdojxbyxfxdnt\",\"dependencyConditions\":[\"Completed\",\"Failed\"],\"\":{\"aidqzflasvah\":\"datageg\",\"ojdnmrxjlumrzfd\":\"dataq\",\"nkadanl\":\"datao\"}},{\"activity\":\"qlrmbgiaoxpfko\",\"dependencyConditions\":[\"Failed\"],\"\":{\"azvyftklb\":\"dataezurhgucnsspbl\",\"dkwibdri\":\"dataribgczkkmrlp\",\"cztmwwmybviwkrje\":\"dataedshuxlh\"}},{\"activity\":\"sjglpon\",\"dependencyConditions\":[\"Completed\",\"Skipped\",\"Skipped\"],\"\":{\"kcad\":\"dataiud\",\"rbfa\":\"datayoouvqpc\",\"wzufmyanectf\":\"dataduzzyxlyuw\"}}],\"userProperties\":[{\"name\":\"g\",\"value\":\"dataghohoxcontsrv\"}],\"\":{\"lqlib\":\"datarrkcv\",\"zs\":\"datamfn\",\"gzljgrtfic\":\"datahkkktlodsyyzmf\"}}],\"ifFalseActivities\":[{\"type\":\"Activity\",\"name\":\"mzbasxapcegtcdu\",\"description\":\"tpkttjnney\",\"state\":\"Inactive\",\"onInactiveMarkAs\":\"Skipped\",\"dependsOn\":[{\"activity\":\"gh\",\"dependencyConditions\":[\"Completed\",\"Succeeded\",\"Succeeded\",\"Succeeded\"],\"\":{\"jafcfidd\":\"datavfdo\",\"jzuqhyqvmob\":\"dataktutwczdwmt\"}},{\"activity\":\"judpeedzowve\",\"dependencyConditions\":[\"Completed\",\"Succeeded\",\"Completed\",\"Failed\"],\"\":{\"pobmfmdsi\":\"datatsrrle\",\"qgluhr\":\"datall\"}},{\"activity\":\"imojozhdcptxxb\",\"dependencyConditions\":[\"Succeeded\"],\"\":{\"cvqeowe\":\"datacmwnyu\",\"fsntopfqgu\":\"datavnrngi\",\"wvzagurgurpc\":\"datavqqrcyeu\",\"yuzhkefownc\":\"datau\"}},{\"activity\":\"dcrwoiqsrqebjgo\",\"dependencyConditions\":[\"Succeeded\",\"Skipped\"],\"\":{\"gchkmqfkm\":\"datad\"}}],\"userProperties\":[{\"name\":\"omq\",\"value\":\"databslwxcf\"},{\"name\":\"vedxyeba\",\"value\":\"datawnmnxppgfep\"},{\"name\":\"nedjvataeao\",\"value\":\"datakn\"},{\"name\":\"ynvv\",\"value\":\"datafbmrppjfceab\"}],\"\":{\"ewi\":\"datazs\",\"vdjmvzcycg\":\"datan\",\"pyexjrguziglr\":\"datatelimqxwih\",\"mrvgcbf\":\"datahz\"}}]},\"name\":\"isklotwnppstpq\",\"description\":\"deawolhl\",\"state\":\"Inactive\",\"onInactiveMarkAs\":\"Succeeded\",\"dependsOn\":[{\"activity\":\"mhqylrsywiscoq\",\"dependencyConditions\":[\"Completed\"],\"\":{\"qkcikfeshxo\":\"datapchdpdevcmp\",\"d\":\"datatvkxpsxlpypzgdet\",\"sutspocrskkraap\":\"datagyhu\"}},{\"activity\":\"zmziiftjig\",\"dependencyConditions\":[\"Failed\",\"Failed\",\"Skipped\"],\"\":{\"lciooxybmktbwdfj\":\"datayywc\",\"j\":\"dataepycpw\"}}],\"userProperties\":[{\"name\":\"hrtqnbdgc\",\"value\":\"dataicknsbbc\"},{\"name\":\"bqxwojvejxh\",\"value\":\"dataeolzftfyjcen\"}],\"\":{\"zbmlhgytkthevod\":\"datalpmlxhzwyyye\",\"jftcrjoh\":\"datadnegwsyxdf\",\"bh\":\"datai\"}}")
            .toObject(IfConditionActivity.class);
        Assertions.assertEquals("isklotwnppstpq", model.name());
        Assertions.assertEquals("deawolhl", model.description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SUCCEEDED, model.onInactiveMarkAs());
        Assertions.assertEquals("mhqylrsywiscoq", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("hrtqnbdgc", model.userProperties().get(0).name());
        Assertions.assertEquals("ygzaya", model.expression().value());
        Assertions.assertEquals("mlae", model.ifTrueActivities().get(0).name());
        Assertions.assertEquals("hucxmybuqjpgbiya", model.ifTrueActivities().get(0).description());
        Assertions.assertEquals(ActivityState.ACTIVE, model.ifTrueActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SUCCEEDED, model.ifTrueActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("inhpvbmbfi", model.ifTrueActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.ifTrueActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("iavguskvvnzngh", model.ifTrueActivities().get(0).userProperties().get(0).name());
        Assertions.assertEquals("mzbasxapcegtcdu", model.ifFalseActivities().get(0).name());
        Assertions.assertEquals("tpkttjnney", model.ifFalseActivities().get(0).description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.ifFalseActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SKIPPED, model.ifFalseActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("gh", model.ifFalseActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.ifFalseActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("omq", model.ifFalseActivities().get(0).userProperties().get(0).name());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IfConditionActivity model
            = new IfConditionActivity().withName("isklotwnppstpq")
                .withDescription("deawolhl")
                .withState(ActivityState.INACTIVE)
                .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.SUCCEEDED)
                .withDependsOn(Arrays.asList(
                    new ActivityDependency().withActivity("mhqylrsywiscoq")
                        .withDependencyConditions(Arrays.asList(DependencyCondition.COMPLETED))
                        .withAdditionalProperties(mapOf()),
                    new ActivityDependency().withActivity("zmziiftjig")
                        .withDependencyConditions(Arrays.asList(DependencyCondition.FAILED, DependencyCondition.FAILED,
                            DependencyCondition.SKIPPED))
                        .withAdditionalProperties(mapOf())))
                .withUserProperties(Arrays.asList(new UserProperty().withName("hrtqnbdgc").withValue("dataicknsbbc"),
                    new UserProperty().withName("bqxwojvejxh").withValue("dataeolzftfyjcen")))
                .withExpression(new Expression().withValue("ygzaya"))
                .withIfTrueActivities(
                    Arrays
                        .asList(
                            new Activity().withName("mlae")
                                .withDescription("hucxmybuqjpgbiya")
                                .withState(ActivityState.ACTIVE)
                                .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.SUCCEEDED)
                                .withDependsOn(
                                    Arrays.asList(
                                        new ActivityDependency().withActivity("inhpvbmbfi")
                                            .withDependencyConditions(Arrays.asList(DependencyCondition.COMPLETED,
                                                DependencyCondition.FAILED))
                                            .withAdditionalProperties(mapOf()),
                                        new ActivityDependency().withActivity("aiwxlrphaddsxs")
                                            .withDependencyConditions(Arrays.asList(DependencyCondition.SUCCEEDED))
                                            .withAdditionalProperties(mapOf())))
                                .withUserProperties(
                                    Arrays.asList(new UserProperty().withName("iavguskvvnzngh").withValue("dataoqe")))
                                .withAdditionalProperties(mapOf("type", "Activity")),
                            new Activity().withName("mere")
                                .withDescription("oessuwkcnhdecxbi")
                                .withState(ActivityState.INACTIVE)
                                .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.FAILED)
                                .withDependsOn(
                                    Arrays.asList(
                                        new ActivityDependency().withActivity("fdojxbyxfxdnt")
                                            .withDependencyConditions(Arrays
                                                .asList(DependencyCondition.COMPLETED, DependencyCondition.FAILED))
                                            .withAdditionalProperties(mapOf()),
                                        new ActivityDependency().withActivity("qlrmbgiaoxpfko")
                                            .withDependencyConditions(Arrays.asList(DependencyCondition.FAILED))
                                            .withAdditionalProperties(mapOf()),
                                        new ActivityDependency()
                                            .withActivity("sjglpon")
                                            .withDependencyConditions(Arrays.asList(DependencyCondition.COMPLETED,
                                                DependencyCondition.SKIPPED, DependencyCondition.SKIPPED))
                                            .withAdditionalProperties(mapOf())))
                                .withUserProperties(
                                    Arrays.asList(new UserProperty().withName("g").withValue("dataghohoxcontsrv")))
                                .withAdditionalProperties(mapOf("type", "Activity"))))
                .withIfFalseActivities(Arrays.asList(new Activity().withName("mzbasxapcegtcdu")
                    .withDescription("tpkttjnney")
                    .withState(ActivityState.INACTIVE)
                    .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.SKIPPED)
                    .withDependsOn(Arrays.asList(new ActivityDependency().withActivity("gh")
                        .withDependencyConditions(
                            Arrays.asList(DependencyCondition.COMPLETED, DependencyCondition.SUCCEEDED,
                                DependencyCondition.SUCCEEDED, DependencyCondition.SUCCEEDED))
                        .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("judpeedzowve")
                            .withDependencyConditions(
                                Arrays.asList(DependencyCondition.COMPLETED, DependencyCondition.SUCCEEDED,
                                    DependencyCondition.COMPLETED, DependencyCondition.FAILED))
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("imojozhdcptxxb")
                            .withDependencyConditions(Arrays.asList(DependencyCondition.SUCCEEDED))
                            .withAdditionalProperties(mapOf()),
                        new ActivityDependency().withActivity("dcrwoiqsrqebjgo")
                            .withDependencyConditions(
                                Arrays.asList(DependencyCondition.SUCCEEDED, DependencyCondition.SKIPPED))
                            .withAdditionalProperties(mapOf())))
                    .withUserProperties(Arrays.asList(new UserProperty().withName("omq").withValue("databslwxcf"),
                        new UserProperty().withName("vedxyeba").withValue("datawnmnxppgfep"),
                        new UserProperty().withName("nedjvataeao").withValue("datakn"),
                        new UserProperty().withName("ynvv").withValue("datafbmrppjfceab")))
                    .withAdditionalProperties(mapOf("type", "Activity"))));
        model = BinaryData.fromObject(model).toObject(IfConditionActivity.class);
        Assertions.assertEquals("isklotwnppstpq", model.name());
        Assertions.assertEquals("deawolhl", model.description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SUCCEEDED, model.onInactiveMarkAs());
        Assertions.assertEquals("mhqylrsywiscoq", model.dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED, model.dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("hrtqnbdgc", model.userProperties().get(0).name());
        Assertions.assertEquals("ygzaya", model.expression().value());
        Assertions.assertEquals("mlae", model.ifTrueActivities().get(0).name());
        Assertions.assertEquals("hucxmybuqjpgbiya", model.ifTrueActivities().get(0).description());
        Assertions.assertEquals(ActivityState.ACTIVE, model.ifTrueActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SUCCEEDED, model.ifTrueActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("inhpvbmbfi", model.ifTrueActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.ifTrueActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("iavguskvvnzngh", model.ifTrueActivities().get(0).userProperties().get(0).name());
        Assertions.assertEquals("mzbasxapcegtcdu", model.ifFalseActivities().get(0).name());
        Assertions.assertEquals("tpkttjnney", model.ifFalseActivities().get(0).description());
        Assertions.assertEquals(ActivityState.INACTIVE, model.ifFalseActivities().get(0).state());
        Assertions.assertEquals(ActivityOnInactiveMarkAs.SKIPPED, model.ifFalseActivities().get(0).onInactiveMarkAs());
        Assertions.assertEquals("gh", model.ifFalseActivities().get(0).dependsOn().get(0).activity());
        Assertions.assertEquals(DependencyCondition.COMPLETED,
            model.ifFalseActivities().get(0).dependsOn().get(0).dependencyConditions().get(0));
        Assertions.assertEquals("omq", model.ifFalseActivities().get(0).userProperties().get(0).name());
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
