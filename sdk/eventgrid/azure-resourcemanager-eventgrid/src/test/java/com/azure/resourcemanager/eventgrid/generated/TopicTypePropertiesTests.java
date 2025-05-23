// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.eventgrid.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.eventgrid.fluent.models.TopicTypeProperties;
import com.azure.resourcemanager.eventgrid.models.ResourceRegionType;
import com.azure.resourcemanager.eventgrid.models.TopicTypeAdditionalEnforcedPermission;
import com.azure.resourcemanager.eventgrid.models.TopicTypeProvisioningState;
import com.azure.resourcemanager.eventgrid.models.TopicTypeSourceScope;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class TopicTypePropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        TopicTypeProperties model = BinaryData.fromString(
            "{\"provider\":\"frgqhaohcm\",\"displayName\":\"oc\",\"description\":\"r\",\"resourceRegionType\":\"GlobalResource\",\"provisioningState\":\"Succeeded\",\"supportedLocations\":[\"yx\",\"meblyd\",\"vkfkmr\",\"cxneh\"],\"sourceResourceFormat\":\"mtodl\",\"supportedScopesForSource\":[\"ResourceGroup\",\"ManagementGroup\",\"ResourceGroup\"],\"areRegionalAndGlobalSourcesSupported\":true,\"additionalEnforcedPermissions\":[{\"permissionName\":\"avyunssxlg\",\"isDataAction\":false},{\"permissionName\":\"gjlgvvpase\",\"isDataAction\":true},{\"permissionName\":\"uxantuygdhgaqipi\",\"isDataAction\":true}]}")
            .toObject(TopicTypeProperties.class);
        Assertions.assertEquals("frgqhaohcm", model.provider());
        Assertions.assertEquals("oc", model.displayName());
        Assertions.assertEquals("r", model.description());
        Assertions.assertEquals(ResourceRegionType.GLOBAL_RESOURCE, model.resourceRegionType());
        Assertions.assertEquals(TopicTypeProvisioningState.SUCCEEDED, model.provisioningState());
        Assertions.assertEquals("yx", model.supportedLocations().get(0));
        Assertions.assertEquals("mtodl", model.sourceResourceFormat());
        Assertions.assertEquals(TopicTypeSourceScope.RESOURCE_GROUP, model.supportedScopesForSource().get(0));
        Assertions.assertEquals(true, model.areRegionalAndGlobalSourcesSupported());
        Assertions.assertEquals("avyunssxlg", model.additionalEnforcedPermissions().get(0).permissionName());
        Assertions.assertEquals(false, model.additionalEnforcedPermissions().get(0).isDataAction());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        TopicTypeProperties model = new TopicTypeProperties().withProvider("frgqhaohcm")
            .withDisplayName("oc")
            .withDescription("r")
            .withResourceRegionType(ResourceRegionType.GLOBAL_RESOURCE)
            .withProvisioningState(TopicTypeProvisioningState.SUCCEEDED)
            .withSupportedLocations(Arrays.asList("yx", "meblyd", "vkfkmr", "cxneh"))
            .withSourceResourceFormat("mtodl")
            .withSupportedScopesForSource(Arrays.asList(TopicTypeSourceScope.RESOURCE_GROUP,
                TopicTypeSourceScope.MANAGEMENT_GROUP, TopicTypeSourceScope.RESOURCE_GROUP))
            .withAreRegionalAndGlobalSourcesSupported(true)
            .withAdditionalEnforcedPermissions(Arrays.asList(
                new TopicTypeAdditionalEnforcedPermission().withPermissionName("avyunssxlg").withIsDataAction(false),
                new TopicTypeAdditionalEnforcedPermission().withPermissionName("gjlgvvpase").withIsDataAction(true),
                new TopicTypeAdditionalEnforcedPermission().withPermissionName("uxantuygdhgaqipi")
                    .withIsDataAction(true)));
        model = BinaryData.fromObject(model).toObject(TopicTypeProperties.class);
        Assertions.assertEquals("frgqhaohcm", model.provider());
        Assertions.assertEquals("oc", model.displayName());
        Assertions.assertEquals("r", model.description());
        Assertions.assertEquals(ResourceRegionType.GLOBAL_RESOURCE, model.resourceRegionType());
        Assertions.assertEquals(TopicTypeProvisioningState.SUCCEEDED, model.provisioningState());
        Assertions.assertEquals("yx", model.supportedLocations().get(0));
        Assertions.assertEquals("mtodl", model.sourceResourceFormat());
        Assertions.assertEquals(TopicTypeSourceScope.RESOURCE_GROUP, model.supportedScopesForSource().get(0));
        Assertions.assertEquals(true, model.areRegionalAndGlobalSourcesSupported());
        Assertions.assertEquals("avyunssxlg", model.additionalEnforcedPermissions().get(0).permissionName());
        Assertions.assertEquals(false, model.additionalEnforcedPermissions().get(0).isDataAction());
    }
}
