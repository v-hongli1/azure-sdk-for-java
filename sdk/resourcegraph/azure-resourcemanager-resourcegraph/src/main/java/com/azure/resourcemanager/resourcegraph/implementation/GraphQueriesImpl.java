// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.resourcegraph.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.resourcegraph.fluent.GraphQueriesClient;
import com.azure.resourcemanager.resourcegraph.fluent.models.GraphQueryResourceInner;
import com.azure.resourcemanager.resourcegraph.models.GraphQueries;
import com.azure.resourcemanager.resourcegraph.models.GraphQueryResource;

public final class GraphQueriesImpl implements GraphQueries {
    private static final ClientLogger LOGGER = new ClientLogger(GraphQueriesImpl.class);

    private final GraphQueriesClient innerClient;

    private final com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager;

    public GraphQueriesImpl(GraphQueriesClient innerClient,
        com.azure.resourcemanager.resourcegraph.ResourceGraphManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<GraphQueryResource> list(String subscriptionId) {
        PagedIterable<GraphQueryResourceInner> inner = this.serviceClient().list(subscriptionId);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GraphQueryResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<GraphQueryResource> list(String subscriptionId, Context context) {
        PagedIterable<GraphQueryResourceInner> inner = this.serviceClient().list(subscriptionId, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GraphQueryResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<GraphQueryResource> listByResourceGroup(String subscriptionId, String resourceGroupName) {
        PagedIterable<GraphQueryResourceInner> inner
            = this.serviceClient().listByResourceGroup(subscriptionId, resourceGroupName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GraphQueryResourceImpl(inner1, this.manager()));
    }

    public PagedIterable<GraphQueryResource> listByResourceGroup(String subscriptionId, String resourceGroupName,
        Context context) {
        PagedIterable<GraphQueryResourceInner> inner
            = this.serviceClient().listByResourceGroup(subscriptionId, resourceGroupName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GraphQueryResourceImpl(inner1, this.manager()));
    }

    public Response<GraphQueryResource> getByResourceGroupWithResponse(String subscriptionId, String resourceGroupName,
        String resourceName, Context context) {
        Response<GraphQueryResourceInner> inner = this.serviceClient()
            .getByResourceGroupWithResponse(subscriptionId, resourceGroupName, resourceName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new GraphQueryResourceImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public GraphQueryResource getByResourceGroup(String subscriptionId, String resourceGroupName, String resourceName) {
        GraphQueryResourceInner inner
            = this.serviceClient().getByResourceGroup(subscriptionId, resourceGroupName, resourceName);
        if (inner != null) {
            return new GraphQueryResourceImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteWithResponse(String subscriptionId, String resourceGroupName, String resourceName,
        Context context) {
        return this.serviceClient().deleteWithResponse(subscriptionId, resourceGroupName, resourceName, context);
    }

    public void delete(String subscriptionId, String resourceGroupName, String resourceName) {
        this.serviceClient().delete(subscriptionId, resourceGroupName, resourceName);
    }

    public GraphQueryResource getById(String id) {
        String subscriptionId = ResourceManagerUtils.getValueFromIdByName(id, "subscriptions");
        if (subscriptionId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'subscriptions'.", id)));
        }
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "queries");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'queries'.", id)));
        }
        return this.getByResourceGroupWithResponse(subscriptionId, resourceGroupName, resourceName, Context.NONE)
            .getValue();
    }

    public Response<GraphQueryResource> getByIdWithResponse(String id, Context context) {
        String subscriptionId = ResourceManagerUtils.getValueFromIdByName(id, "subscriptions");
        if (subscriptionId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'subscriptions'.", id)));
        }
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "queries");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'queries'.", id)));
        }
        return this.getByResourceGroupWithResponse(subscriptionId, resourceGroupName, resourceName, context);
    }

    public void deleteById(String id) {
        String subscriptionId = ResourceManagerUtils.getValueFromIdByName(id, "subscriptions");
        if (subscriptionId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'subscriptions'.", id)));
        }
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "queries");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'queries'.", id)));
        }
        this.deleteWithResponse(subscriptionId, resourceGroupName, resourceName, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String subscriptionId = ResourceManagerUtils.getValueFromIdByName(id, "subscriptions");
        if (subscriptionId == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'subscriptions'.", id)));
        }
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String resourceName = ResourceManagerUtils.getValueFromIdByName(id, "queries");
        if (resourceName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'queries'.", id)));
        }
        return this.deleteWithResponse(subscriptionId, resourceGroupName, resourceName, context);
    }

    private GraphQueriesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.resourcegraph.ResourceGraphManager manager() {
        return this.serviceManager;
    }

    public GraphQueryResourceImpl define(String name) {
        return new GraphQueryResourceImpl(name, this.manager());
    }
}
