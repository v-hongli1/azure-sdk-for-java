// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.deviceregistry.implementation;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.deviceregistry.fluent.models.SchemaRegistryInner;
import com.azure.resourcemanager.deviceregistry.models.SchemaRegistry;
import com.azure.resourcemanager.deviceregistry.models.SchemaRegistryProperties;
import com.azure.resourcemanager.deviceregistry.models.SchemaRegistryUpdate;
import com.azure.resourcemanager.deviceregistry.models.SchemaRegistryUpdateProperties;
import com.azure.resourcemanager.deviceregistry.models.SystemAssignedServiceIdentity;
import java.util.Collections;
import java.util.Map;

public final class SchemaRegistryImpl implements SchemaRegistry, SchemaRegistry.Definition, SchemaRegistry.Update {
    private SchemaRegistryInner innerObject;

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

    public SchemaRegistryProperties properties() {
        return this.innerModel().properties();
    }

    public SystemAssignedServiceIdentity identity() {
        return this.innerModel().identity();
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

    public SchemaRegistryInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.deviceregistry.DeviceRegistryManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String schemaRegistryName;

    private SchemaRegistryUpdate updateProperties;

    public SchemaRegistryImpl withExistingResourceGroup(String resourceGroupName) {
        this.resourceGroupName = resourceGroupName;
        return this;
    }

    public SchemaRegistry create() {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .createOrReplace(resourceGroupName, schemaRegistryName, this.innerModel(), Context.NONE);
        return this;
    }

    public SchemaRegistry create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .createOrReplace(resourceGroupName, schemaRegistryName, this.innerModel(), context);
        return this;
    }

    SchemaRegistryImpl(String name, com.azure.resourcemanager.deviceregistry.DeviceRegistryManager serviceManager) {
        this.innerObject = new SchemaRegistryInner();
        this.serviceManager = serviceManager;
        this.schemaRegistryName = name;
    }

    public SchemaRegistryImpl update() {
        this.updateProperties = new SchemaRegistryUpdate();
        return this;
    }

    public SchemaRegistry apply() {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .update(resourceGroupName, schemaRegistryName, updateProperties, Context.NONE);
        return this;
    }

    public SchemaRegistry apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .update(resourceGroupName, schemaRegistryName, updateProperties, context);
        return this;
    }

    SchemaRegistryImpl(SchemaRegistryInner innerObject,
        com.azure.resourcemanager.deviceregistry.DeviceRegistryManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.schemaRegistryName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "schemaRegistries");
    }

    public SchemaRegistry refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .getByResourceGroupWithResponse(resourceGroupName, schemaRegistryName, Context.NONE)
            .getValue();
        return this;
    }

    public SchemaRegistry refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getSchemaRegistries()
            .getByResourceGroupWithResponse(resourceGroupName, schemaRegistryName, context)
            .getValue();
        return this;
    }

    public SchemaRegistryImpl withRegion(Region location) {
        this.innerModel().withLocation(location.toString());
        return this;
    }

    public SchemaRegistryImpl withRegion(String location) {
        this.innerModel().withLocation(location);
        return this;
    }

    public SchemaRegistryImpl withTags(Map<String, String> tags) {
        if (isInCreateMode()) {
            this.innerModel().withTags(tags);
            return this;
        } else {
            this.updateProperties.withTags(tags);
            return this;
        }
    }

    public SchemaRegistryImpl withProperties(SchemaRegistryProperties properties) {
        this.innerModel().withProperties(properties);
        return this;
    }

    public SchemaRegistryImpl withIdentity(SystemAssignedServiceIdentity identity) {
        if (isInCreateMode()) {
            this.innerModel().withIdentity(identity);
            return this;
        } else {
            this.updateProperties.withIdentity(identity);
            return this;
        }
    }

    public SchemaRegistryImpl withProperties(SchemaRegistryUpdateProperties properties) {
        this.updateProperties.withProperties(properties);
        return this;
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
