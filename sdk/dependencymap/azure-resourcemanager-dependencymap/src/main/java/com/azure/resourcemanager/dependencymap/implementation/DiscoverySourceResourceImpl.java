// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.dependencymap.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.dependencymap.fluent.models.DiscoverySourceResourceInner;
import com.azure.resourcemanager.dependencymap.models.DiscoverySourceResource;
import com.azure.resourcemanager.dependencymap.models.DiscoverySourceResourceProperties;
import com.azure.resourcemanager.dependencymap.models.DiscoverySourceResourceTagsUpdate;
import java.util.Collections;
import java.util.Map;

public final class DiscoverySourceResourceImpl
    implements DiscoverySourceResource, DiscoverySourceResource.Definition, DiscoverySourceResource.Update {
    private DiscoverySourceResourceInner innerObject;

    private final com.azure.resourcemanager.dependencymap.DependencyMapManager serviceManager;

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

    public DiscoverySourceResourceProperties properties() {
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

    public DiscoverySourceResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.dependencymap.DependencyMapManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String mapName;

    private String sourceName;

    private DiscoverySourceResourceTagsUpdate updateProperties;

    public DiscoverySourceResourceImpl withExistingMap(String resourceGroupName, String mapName) {
        this.resourceGroupName = resourceGroupName;
        this.mapName = mapName;
        return this;
    }

    public DiscoverySourceResource create() {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .createOrUpdate(resourceGroupName, mapName, sourceName, this.innerModel(), Context.NONE);
        return this;
    }

    public DiscoverySourceResource create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .createOrUpdate(resourceGroupName, mapName, sourceName, this.innerModel(), context);
        return this;
    }

    DiscoverySourceResourceImpl(String name,
        com.azure.resourcemanager.dependencymap.DependencyMapManager serviceManager) {
        this.innerObject = new DiscoverySourceResourceInner();
        this.serviceManager = serviceManager;
        this.sourceName = name;
    }

    public DiscoverySourceResourceImpl update() {
        this.updateProperties = new DiscoverySourceResourceTagsUpdate();
        return this;
    }

    public DiscoverySourceResource apply() {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .update(resourceGroupName, mapName, sourceName, updateProperties, Context.NONE);
        return this;
    }

    public DiscoverySourceResource apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .update(resourceGroupName, mapName, sourceName, updateProperties, context);
        return this;
    }

    DiscoverySourceResourceImpl(DiscoverySourceResourceInner innerObject,
        com.azure.resourcemanager.dependencymap.DependencyMapManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.mapName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "maps");
        this.sourceName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "discoverySources");
    }

    public DiscoverySourceResource refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .getWithResponse(resourceGroupName, mapName, sourceName, Context.NONE)
            .getValue();
        return this;
    }

    public DiscoverySourceResource refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getDiscoverySources()
            .getWithResponse(resourceGroupName, mapName, sourceName, context)
            .getValue();
        return this;
    }

    public DiscoverySourceResourceImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public DiscoverySourceResourceImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public DiscoverySourceResourceImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public DiscoverySourceResourceImpl withProperties(DiscoverySourceResourceProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
