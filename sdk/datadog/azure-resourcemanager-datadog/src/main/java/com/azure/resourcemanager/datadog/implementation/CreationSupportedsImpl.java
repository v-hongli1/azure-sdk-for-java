// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datadog.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.datadog.fluent.CreationSupportedsClient;
import com.azure.resourcemanager.datadog.fluent.models.CreateResourceSupportedResponseInner;
import com.azure.resourcemanager.datadog.models.CreateResourceSupportedResponse;
import com.azure.resourcemanager.datadog.models.CreationSupporteds;

public final class CreationSupportedsImpl implements CreationSupporteds {
    private static final ClientLogger LOGGER = new ClientLogger(CreationSupportedsImpl.class);

    private final CreationSupportedsClient innerClient;

    private final com.azure.resourcemanager.datadog.MicrosoftDatadogManager serviceManager;

    public CreationSupportedsImpl(CreationSupportedsClient innerClient,
        com.azure.resourcemanager.datadog.MicrosoftDatadogManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<CreateResourceSupportedResponse> list(String datadogOrganizationId) {
        PagedIterable<CreateResourceSupportedResponseInner> inner = this.serviceClient().list(datadogOrganizationId);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new CreateResourceSupportedResponseImpl(inner1, this.manager()));
    }

    public PagedIterable<CreateResourceSupportedResponse> list(String datadogOrganizationId, Context context) {
        PagedIterable<CreateResourceSupportedResponseInner> inner
            = this.serviceClient().list(datadogOrganizationId, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new CreateResourceSupportedResponseImpl(inner1, this.manager()));
    }

    public Response<CreateResourceSupportedResponse> getWithResponse(String datadogOrganizationId, Context context) {
        Response<CreateResourceSupportedResponseInner> inner
            = this.serviceClient().getWithResponse(datadogOrganizationId, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new CreateResourceSupportedResponseImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public CreateResourceSupportedResponse get(String datadogOrganizationId) {
        CreateResourceSupportedResponseInner inner = this.serviceClient().get(datadogOrganizationId);
        if (inner != null) {
            return new CreateResourceSupportedResponseImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    private CreationSupportedsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.datadog.MicrosoftDatadogManager manager() {
        return this.serviceManager;
    }
}
