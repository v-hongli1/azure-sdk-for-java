// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.deviceregistry.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.deviceregistry.fluent.models.AssetInner;
import com.azure.resourcemanager.deviceregistry.models.Asset;
import com.azure.resourcemanager.deviceregistry.models.AssetProperties;
import com.azure.resourcemanager.deviceregistry.models.AssetUpdate;
import com.azure.resourcemanager.deviceregistry.models.AssetUpdateProperties;
import com.azure.resourcemanager.deviceregistry.models.ExtendedLocation;
import java.util.Collections;
import java.util.Map;

public final class AssetImpl implements Asset, Asset.Definition, Asset.Update {
    private AssetInner innerObject;

    private final com.azure.resourcemanager.deviceregistry.DeviceRegistryManager serviceManager;

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

    public AssetProperties properties() {
        return this.innerModel().properties();
    }

    public ExtendedLocation extendedLocation() {
        return this.innerModel().extendedLocation();
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

    public AssetInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.deviceregistry.DeviceRegistryManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String assetName;

    private AssetUpdate updateProperties;

    public AssetImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public Asset create() {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .createOrReplace(resourceGroupName, assetName, this.innerModel(), Context.NONE);
        return this;
    }

    public Asset create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .createOrReplace(resourceGroupName, assetName, this.innerModel(), context);
        return this;
    }

    AssetImpl(String name, com.azure.resourcemanager.deviceregistry.DeviceRegistryManager serviceManager) {
        this.innerObject = new AssetInner();
        this.serviceManager = serviceManager;
        this.assetName = name;
    }

    public AssetImpl update() {
        this.updateProperties = new AssetUpdate();
        return this;
    }

    public Asset apply() {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .update(resourceGroupName, assetName, updateProperties, Context.NONE);
        return this;
    }

    public Asset apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .update(resourceGroupName, assetName, updateProperties, context);
        return this;
    }

    AssetImpl(AssetInner innerObject, com.azure.resourcemanager.deviceregistry.DeviceRegistryManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.assetName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "assets");
    }

    public Asset refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .getByResourceGroupWithResponse(resourceGroupName, assetName, Context.NONE)
            .getValue();
        return this;
    }

    public Asset refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getAssets()
            .getByResourceGroupWithResponse(resourceGroupName, assetName, context)
            .getValue();
        return this;
    }

    public AssetImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public AssetImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public AssetImpl withExtendedLocation(ExtendedLocation extendedLocation) {
        this.innerModel().withExtendedLocation(extendedLocation);
        return this;
    }

    public AssetImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public AssetImpl withProperties(AssetProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public AssetImpl withProperties(AssetUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
