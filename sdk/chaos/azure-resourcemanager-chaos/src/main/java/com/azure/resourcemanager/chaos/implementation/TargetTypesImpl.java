// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.chaos.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.chaos.fluent.TargetTypesClient;
import com.azure.resourcemanager.chaos.fluent.models.TargetTypeInner;
import com.azure.resourcemanager.chaos.models.TargetType;
import com.azure.resourcemanager.chaos.models.TargetTypes;

public final class TargetTypesImpl implements TargetTypes {
    private static final ClientLogger LOGGER = new ClientLogger(TargetTypesImpl.class);

    private final TargetTypesClient innerClient;

    private final com.azure.resourcemanager.chaos.ChaosManager serviceManager;

    public TargetTypesImpl(TargetTypesClient innerClient, com.azure.resourcemanager.chaos.ChaosManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<TargetType> getWithResponse(String location, String targetTypeName, Context context) {
        Response<TargetTypeInner> inner = this.serviceClient().getWithResponse(location, targetTypeName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new TargetTypeImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public TargetType get(String location, String targetTypeName) {
        TargetTypeInner inner = this.serviceClient().get(location, targetTypeName);
        if (inner != null) {
            return new TargetTypeImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<TargetType> list(String location) {
        PagedIterable<TargetTypeInner> inner = this.serviceClient().list(location);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TargetTypeImpl(inner1, this.manager()));
    }

    public PagedIterable<TargetType> list(String location, String continuationToken, Context context) {
        PagedIterable<TargetTypeInner> inner = this.serviceClient().list(location, continuationToken, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new TargetTypeImpl(inner1, this.manager()));
    }

    private TargetTypesClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.chaos.ChaosManager manager() {
        return this.serviceManager;
    }
}
