// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.fabric.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.fabric.fluent.models.FabricCapacityInner;
import com.azure.resourcemanager.fabric.models.FabricCapacity;
import com.azure.resourcemanager.fabric.models.FabricCapacityProperties;
import com.azure.resourcemanager.fabric.models.FabricCapacityUpdate;
import com.azure.resourcemanager.fabric.models.FabricCapacityUpdateProperties;
import com.azure.resourcemanager.fabric.models.RpSku;
import java.util.Collections;
import java.util.Map;

public final class FabricCapacityImpl implements FabricCapacity, FabricCapacity.Definition, FabricCapacity.Update {
    private FabricCapacityInner innerObject;

    private final com.azure.resourcemanager.fabric.FabricManager serviceManager;

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

    public FabricCapacityProperties properties() {
        return this.innerModel().properties();
    }

    public RpSku sku() {
        return this.innerModel().sku();
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

    public FabricCapacityInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.fabric.FabricManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String capacityName;

    private FabricCapacityUpdate updateProperties;

    public FabricCapacityImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public FabricCapacity create() {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .createOrUpdate(resourceGroupName, capacityName, this.innerModel(), Context.NONE);
        return this;
    }

    public FabricCapacity create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .createOrUpdate(resourceGroupName, capacityName, this.innerModel(), context);
        return this;
    }

    FabricCapacityImpl(String name, com.azure.resourcemanager.fabric.FabricManager serviceManager) {
        this.innerObject = new FabricCapacityInner();
        this.serviceManager = serviceManager;
        this.capacityName = name;
    }

    public FabricCapacityImpl update() {
        this.updateProperties = new FabricCapacityUpdate();
        return this;
    }

    public FabricCapacity apply() {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .update(resourceGroupName, capacityName, updateProperties, Context.NONE);
        return this;
    }

    public FabricCapacity apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .update(resourceGroupName, capacityName, updateProperties, context);
        return this;
    }

    FabricCapacityImpl(FabricCapacityInner innerObject, com.azure.resourcemanager.fabric.FabricManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.capacityName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "capacities");
    }

    public FabricCapacity refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .getByResourceGroupWithResponse(resourceGroupName, capacityName, Context.NONE)
            .getValue();
        return this;
    }

    public FabricCapacity refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFabricCapacities()
            .getByResourceGroupWithResponse(resourceGroupName, capacityName, context)
            .getValue();
        return this;
    }

    public void resume() {
        serviceManager.fabricCapacities().resume(resourceGroupName, capacityName);
    }

    public void resume(Context context) {
        serviceManager.fabricCapacities().resume(resourceGroupName, capacityName, context);
    }

    public void suspend() {
        serviceManager.fabricCapacities().suspend(resourceGroupName, capacityName);
    }

    public void suspend(Context context) {
        serviceManager.fabricCapacities().suspend(resourceGroupName, capacityName, context);
    }

    public FabricCapacityImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public FabricCapacityImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public FabricCapacityImpl withProperties(FabricCapacityProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public FabricCapacityImpl withSku(RpSku sku) {
        if (isInCreateMode()) {
            this.innerModel().withSku(sku);
            return this;
        } else {
            this.updateProperties.withSku(sku);
            return this;
        }
    }

    public FabricCapacityImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public FabricCapacityImpl withProperties(FabricCapacityUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
