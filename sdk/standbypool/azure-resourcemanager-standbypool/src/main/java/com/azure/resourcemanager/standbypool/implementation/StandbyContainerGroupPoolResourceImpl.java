// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.standbypool.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.standbypool.fluent.models.StandbyContainerGroupPoolResourceInner;
import com.azure.resourcemanager.standbypool.models.StandbyContainerGroupPoolResource;
import com.azure.resourcemanager.standbypool.models.StandbyContainerGroupPoolResourceProperties;
import com.azure.resourcemanager.standbypool.models.StandbyContainerGroupPoolResourceUpdate;
import com.azure.resourcemanager.standbypool.models.StandbyContainerGroupPoolResourceUpdateProperties;
import java.util.Collections;
import java.util.Map;

public final class StandbyContainerGroupPoolResourceImpl implements StandbyContainerGroupPoolResource,
    StandbyContainerGroupPoolResource.Definition, StandbyContainerGroupPoolResource.Update {
    private StandbyContainerGroupPoolResourceInner innerObject;

    private final com.azure.resourcemanager.standbypool.StandbyPoolManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public String location() {
        return this.innerModel().location();
    }

    public Map<String, String> tags() {
        Map<String, String> inner = this.innerModel().tags();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public StandbyContainerGroupPoolResourceProperties properties() {
        return this.innerModel().properties();
    }

    public SystemData systemData() {
        return this.innerModel().systemData();
    }

    public Region region() {
        return Region.fromName(this.regionName());
    }

    public String regionName() {
        return this.location();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public StandbyContainerGroupPoolResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.standbypool.StandbyPoolManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String standbyContainerGroupPoolName;

    private StandbyContainerGroupPoolResourceUpdate updateProperties;

    public StandbyContainerGroupPoolResourceImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public StandbyContainerGroupPoolResource create() {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .createOrUpdate(resourceGroupName, standbyContainerGroupPoolName, this.innerModel(), Context.NONE);
        return this;
    }

    public StandbyContainerGroupPoolResource create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .createOrUpdate(resourceGroupName, standbyContainerGroupPoolName, this.innerModel(), context);
        return this;
    }

    StandbyContainerGroupPoolResourceImpl(String name,
        com.azure.resourcemanager.standbypool.StandbyPoolManager serviceManager) {
        this.innerObject = new StandbyContainerGroupPoolResourceInner();
        this.serviceManager = serviceManager;
        this.standbyContainerGroupPoolName = name;
    }

    public StandbyContainerGroupPoolResourceImpl update() {
        this.updateProperties = new StandbyContainerGroupPoolResourceUpdate();
        return this;
    }

    public StandbyContainerGroupPoolResource apply() {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .updateWithResponse(resourceGroupName, standbyContainerGroupPoolName, updateProperties, Context.NONE)
            .getValue();
        return this;
    }

    public StandbyContainerGroupPoolResource apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .updateWithResponse(resourceGroupName, standbyContainerGroupPoolName, updateProperties, context)
            .getValue();
        return this;
    }

    StandbyContainerGroupPoolResourceImpl(StandbyContainerGroupPoolResourceInner innerObject,
        com.azure.resourcemanager.standbypool.StandbyPoolManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.standbyContainerGroupPoolName
            = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "standbyContainerGroupPools");
    }

    public StandbyContainerGroupPoolResource refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .getByResourceGroupWithResponse(resourceGroupName, standbyContainerGroupPoolName, Context.NONE)
            .getValue();
        return this;
    }

    public StandbyContainerGroupPoolResource refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getStandbyContainerGroupPools()
            .getByResourceGroupWithResponse(resourceGroupName, standbyContainerGroupPoolName, context)
            .getValue();
        return this;
    }

    public StandbyContainerGroupPoolResourceImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public StandbyContainerGroupPoolResourceImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public StandbyContainerGroupPoolResourceImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public StandbyContainerGroupPoolResourceImpl
        withProperties(StandbyContainerGroupPoolResourceProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public StandbyContainerGroupPoolResourceImpl
        withProperties(StandbyContainerGroupPoolResourceUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
