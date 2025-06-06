// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.fluent.FluxConfigsClient;
import com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.fluent.models.FluxConfigurationInner;
import com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.models.FluxConfigs;
import com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.models.FluxConfiguration;
import com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.models.FluxConfigurationPatch;

public final class FluxConfigsImpl implements FluxConfigs {
    private static final ClientLogger LOGGER = new ClientLogger(FluxConfigsImpl.class);

    private final FluxConfigsClient innerClient;

    private final com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.FluxConfigManager serviceManager;

    public FluxConfigsImpl(FluxConfigsClient innerClient,
        com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.FluxConfigManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<FluxConfiguration> getWithResponse(String resourceGroupName, String clusterRp,
        String clusterResourceName, String clusterName, String fluxConfigurationName, Context context) {
        Response<FluxConfigurationInner> inner = this.serviceClient()
            .getWithResponse(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName,
                context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new FluxConfigurationImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public FluxConfiguration get(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, String fluxConfigurationName) {
        FluxConfigurationInner inner = this.serviceClient()
            .get(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName);
        if (inner != null) {
            return new FluxConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FluxConfiguration createOrUpdate(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, String fluxConfigurationName, FluxConfigurationInner fluxConfiguration) {
        FluxConfigurationInner inner = this.serviceClient()
            .createOrUpdate(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName,
                fluxConfiguration);
        if (inner != null) {
            return new FluxConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FluxConfiguration createOrUpdate(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, String fluxConfigurationName, FluxConfigurationInner fluxConfiguration, Context context) {
        FluxConfigurationInner inner = this.serviceClient()
            .createOrUpdate(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName,
                fluxConfiguration, context);
        if (inner != null) {
            return new FluxConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FluxConfiguration update(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, String fluxConfigurationName, FluxConfigurationPatch fluxConfigurationPatch) {
        FluxConfigurationInner inner = this.serviceClient()
            .update(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName,
                fluxConfigurationPatch);
        if (inner != null) {
            return new FluxConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public FluxConfiguration update(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, String fluxConfigurationName, FluxConfigurationPatch fluxConfigurationPatch,
        Context context) {
        FluxConfigurationInner inner = this.serviceClient()
            .update(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName,
                fluxConfigurationPatch, context);
        if (inner != null) {
            return new FluxConfigurationImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public void delete(String resourceGroupName, String clusterRp, String clusterResourceName, String clusterName,
        String fluxConfigurationName) {
        this.serviceClient()
            .delete(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName);
    }

    public void delete(String resourceGroupName, String clusterRp, String clusterResourceName, String clusterName,
        String fluxConfigurationName, Boolean forceDelete, Context context) {
        this.serviceClient()
            .delete(resourceGroupName, clusterRp, clusterResourceName, clusterName, fluxConfigurationName, forceDelete,
                context);
    }

    public PagedIterable<FluxConfiguration> list(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName) {
        PagedIterable<FluxConfigurationInner> inner
            = this.serviceClient().list(resourceGroupName, clusterRp, clusterResourceName, clusterName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new FluxConfigurationImpl(inner1, this.manager()));
    }

    public PagedIterable<FluxConfiguration> list(String resourceGroupName, String clusterRp, String clusterResourceName,
        String clusterName, Context context) {
        PagedIterable<FluxConfigurationInner> inner
            = this.serviceClient().list(resourceGroupName, clusterRp, clusterResourceName, clusterName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new FluxConfigurationImpl(inner1, this.manager()));
    }

    private FluxConfigsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.kubernetesconfiguration.fluxconfigurations.FluxConfigManager manager() {
        return this.serviceManager;
    }
}
