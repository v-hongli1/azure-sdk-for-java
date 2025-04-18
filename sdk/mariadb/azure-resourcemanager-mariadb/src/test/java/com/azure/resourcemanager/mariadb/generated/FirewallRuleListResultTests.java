// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mariadb.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.mariadb.fluent.models.FirewallRuleInner;
import com.azure.resourcemanager.mariadb.models.FirewallRuleListResult;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class FirewallRuleListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        FirewallRuleListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"startIpAddress\":\"rpymzidnsez\",\"endIpAddress\":\"xtbzsgfyccsne\"},\"id\":\"mdwzjeiachboo\",\"name\":\"flnrosfqpteehzz\",\"type\":\"ypyqrimzinp\"}]}")
            .toObject(FirewallRuleListResult.class);
        Assertions.assertEquals("rpymzidnsez", model.value().get(0).startIpAddress());
        Assertions.assertEquals("xtbzsgfyccsne", model.value().get(0).endIpAddress());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        FirewallRuleListResult model = new FirewallRuleListResult().withValue(
            Arrays.asList(new FirewallRuleInner().withStartIpAddress("rpymzidnsez").withEndIpAddress("xtbzsgfyccsne")));
        model = BinaryData.fromObject(model).toObject(FirewallRuleListResult.class);
        Assertions.assertEquals("rpymzidnsez", model.value().get(0).startIpAddress());
        Assertions.assertEquals("xtbzsgfyccsne", model.value().get(0).endIpAddress());
    }
}
