// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcegraph.implementation;

import com.azure.core.management.Region;
import com.azure.core.util.Context;
import com.azure.resourcemanager.resourcegraph.fluent.models.GraphQueryResourceInner;
import com.azure.resourcemanager.resourcegraph.models.GraphQueryResource;
import com.azure.resourcemanager.resourcegraph.models.GraphQueryUpdateParameters;
import com.azure.resourcemanager.resourcegraph.models.ResultKind;
import java.time.OffsetDateTime;
import java.util.Collections;
import java.util.Map;

public final class GraphQueryResourceImpl
    implements GraphQueryResource, GraphQueryResource.Definition, GraphQueryResource.Update {
    private GraphQueryResourceInner innerObject;

    private final com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager;

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

    public String etag() {
        return this.innerModel().etag();
    }

    public OffsetDateTime timeModified() {
        return this.innerModel().timeModified();
    }

    public String description() {
        return this.innerModel().description();
    }

    public String query() {
        return this.innerModel().query();
    }

    public ResultKind resultKind() {
        return this.innerModel().resultKind();
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

    public GraphQueryResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.resourcegraph.ResourceGraphManager manager() {
        return this.serviceManager;
    }

    private String subscriptionId;

    private String resourceGroupName;

    private String resourceName;

    private GraphQueryUpdateParameters updateBody;

    public GraphQueryResourceImpl withExistingResourceGroup(String subscriptionId, String resourceGroupName) {
        this.subscriptionId = subscriptionId;
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public GraphQueryResource create() {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .createOrUpdateWithResponse(subscriptionId, resourceGroupName, resourceName, this.innerModel(),
                Context.NONE)
            .getValue();
        return this;
    }

    public GraphQueryResource create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .createOrUpdateWithResponse(subscriptionId, resourceGroupName, resourceName, this.innerModel(), context)
            .getValue();
        return this;
    }

    GraphQueryResourceImpl(String name, com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager) {
        this.innerObject = new GraphQueryResourceInner();
        this.serviceManager = serviceManager;
        this.resourceName = name;
    }

    public GraphQueryResourceImpl update() {
        this.updateBody = new GraphQueryUpdateParameters();
        return this;
    }

    public GraphQueryResource apply() {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .updateWithResponse(subscriptionId, resourceGroupName, resourceName, updateBody, Context.NONE)
            .getValue();
        return this;
    }

    public GraphQueryResource apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .updateWithResponse(subscriptionId, resourceGroupName, resourceName, updateBody, context)
            .getValue();
        return this;
    }

    GraphQueryResourceImpl(GraphQueryResourceInner innerObject,
        com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.subscriptionId = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "subscriptions");
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.resourceName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "queries");
    }

    public GraphQueryResource refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .getByResourceGroupWithResponse(subscriptionId, resourceGroupName, resourceName, Context.NONE)
            .getValue();
        return this;
    }

    public GraphQueryResource refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getGraphQueries()
            .getByResourceGroupWithResponse(subscriptionId, resourceGroupName, resourceName, context)
            .getValue();
        return this;
    }

    public GraphQueryResourceImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public GraphQueryResourceImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public GraphQueryResourceImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateBody.withTags(tags);
            return this;
        }
    }

    public GraphQueryResourceImpl withEtag(String etag) {
        if (isInCreateMode()) {
            this.innerModel().withEtag(etag);
            return this;
        } else {
            this.updateBody.withEtag(etag);
            return this;
        }
    }

    public GraphQueryResourceImpl withDescription(String description) {
        if (isInCreateMode()) {
            this.innerModel().withDescription(description);
            return this;
        } else {
            this.updateBody.withDescription(description);
            return this;
        }
    }

    public GraphQueryResourceImpl withQuery(String query) {
        if (isInCreateMode()) {
            this.innerModel().withQuery(query);
            return this;
        } else {
            this.updateBody.withQuery(query);
            return this;
        }
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
