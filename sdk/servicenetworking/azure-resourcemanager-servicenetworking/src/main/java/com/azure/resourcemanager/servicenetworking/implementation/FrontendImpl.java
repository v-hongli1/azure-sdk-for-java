// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.servicenetworking.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.servicenetworking.fluent.models.FrontendInner;
import com.azure.resourcemanager.servicenetworking.models.Frontend;
import com.azure.resourcemanager.servicenetworking.models.FrontendProperties;
import com.azure.resourcemanager.servicenetworking.models.FrontendUpdate;
import com.azure.resourcemanager.servicenetworking.models.FrontendUpdateProperties;
import java.util.Collections;
import java.util.Map;

public final class FrontendImpl implements Frontend, Frontend.Definition, Frontend.Update {
    private FrontendInner innerObject;

    private final com.azure.resourcemanager.servicenetworking.TrafficControllerManager serviceManager;

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

    public FrontendProperties properties() {
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

    public FrontendInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.servicenetworking.TrafficControllerManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String trafficControllerName;

    private String frontendName;

    private FrontendUpdate updateProperties;

    public FrontendImpl withExistingTrafficController(String resourceGroupName, String trafficControllerName) {
        this.resourceGroupName = resourceGroupName;
        this.trafficControllerName = trafficControllerName;
        return this;
    }

    public Frontend create() {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .createOrUpdate(resourceGroupName, trafficControllerName, frontendName, this.innerModel(), Context.NONE);
        return this;
    }

    public Frontend create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .createOrUpdate(resourceGroupName, trafficControllerName, frontendName, this.innerModel(), context);
        return this;
    }

    FrontendImpl(String name, com.azure.resourcemanager.servicenetworking.TrafficControllerManager serviceManager) {
        this.innerObject = new FrontendInner();
        this.serviceManager = serviceManager;
        this.frontendName = name;
    }

    public FrontendImpl update() {
        this.updateProperties = new FrontendUpdate();
        return this;
    }

    public Frontend apply() {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .updateWithResponse(resourceGroupName, trafficControllerName, frontendName, updateProperties, Context.NONE)
            .getValue();
        return this;
    }

    public Frontend apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .updateWithResponse(resourceGroupName, trafficControllerName, frontendName, updateProperties, context)
            .getValue();
        return this;
    }

    FrontendImpl(FrontendInner innerObject,
        com.azure.resourcemanager.servicenetworking.TrafficControllerManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.trafficControllerName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "trafficControllers");
        this.frontendName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "frontends");
    }

    public Frontend refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .getWithResponse(resourceGroupName, trafficControllerName, frontendName, Context.NONE)
            .getValue();
        return this;
    }

    public Frontend refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getFrontendsInterfaces()
            .getWithResponse(resourceGroupName, trafficControllerName, frontendName, context)
            .getValue();
        return this;
    }

    public FrontendImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public FrontendImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public FrontendImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public FrontendImpl withProperties(FrontendProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public FrontendImpl withProperties(FrontendUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel() == null || this.innerModel().id() == null;
    }
}
