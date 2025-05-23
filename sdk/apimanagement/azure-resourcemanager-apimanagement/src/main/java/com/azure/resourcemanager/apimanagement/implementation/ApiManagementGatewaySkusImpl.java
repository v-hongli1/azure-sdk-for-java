// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.apimanagement.fluent.ApiManagementGatewaySkusClient;
import com.azure.resourcemanager.apimanagement.fluent.models.GatewayResourceSkuResultInner;
import com.azure.resourcemanager.apimanagement.models.ApiManagementGatewaySkus;
import com.azure.resourcemanager.apimanagement.models.GatewayResourceSkuResult;

public final class ApiManagementGatewaySkusImpl implements ApiManagementGatewaySkus {
    private static final ClientLogger LOGGER = new ClientLogger(ApiManagementGatewaySkusImpl.class);

    private final ApiManagementGatewaySkusClient innerClient;

    private final com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager;

    public ApiManagementGatewaySkusImpl(ApiManagementGatewaySkusClient innerClient,
        com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<GatewayResourceSkuResult> listAvailableSkus(String resourceGroupName, String gatewayName) {
        PagedIterable<GatewayResourceSkuResultInner> inner
            = this.serviceClient().listAvailableSkus(resourceGroupName, gatewayName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GatewayResourceSkuResultImpl(inner1, this.manager()));
    }

    public PagedIterable<GatewayResourceSkuResult> listAvailableSkus(String resourceGroupName, String gatewayName,
        Context context) {
        PagedIterable<GatewayResourceSkuResultInner> inner
            = this.serviceClient().listAvailableSkus(resourceGroupName, gatewayName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new GatewayResourceSkuResultImpl(inner1, this.manager()));
    }

    private ApiManagementGatewaySkusClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.apimanagement.ApiManagementManager manager() {
        return this.serviceManager;
    }
}
