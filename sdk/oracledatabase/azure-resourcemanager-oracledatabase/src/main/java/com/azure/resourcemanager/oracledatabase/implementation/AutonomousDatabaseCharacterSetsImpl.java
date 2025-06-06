// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.oracledatabase.fluent.AutonomousDatabaseCharacterSetsClient;
import com.azure.resourcemanager.oracledatabase.fluent.models.AutonomousDatabaseCharacterSetInner;
import com.azure.resourcemanager.oracledatabase.models.AutonomousDatabaseCharacterSet;
import com.azure.resourcemanager.oracledatabase.models.AutonomousDatabaseCharacterSets;

public final class AutonomousDatabaseCharacterSetsImpl implements AutonomousDatabaseCharacterSets {
    private static final ClientLogger LOGGER = new ClientLogger(AutonomousDatabaseCharacterSetsImpl.class);

    private final AutonomousDatabaseCharacterSetsClient innerClient;

    private final com.azure.resourcemanager.oracledatabase.OracleDatabaseManager serviceManager;

    public AutonomousDatabaseCharacterSetsImpl(AutonomousDatabaseCharacterSetsClient innerClient,
        com.azure.resourcemanager.oracledatabase.OracleDatabaseManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public Response<AutonomousDatabaseCharacterSet> getWithResponse(String location, String adbscharsetname,
        Context context) {
        Response<AutonomousDatabaseCharacterSetInner> inner
            = this.serviceClient().getWithResponse(location, adbscharsetname, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new AutonomousDatabaseCharacterSetImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public AutonomousDatabaseCharacterSet get(String location, String adbscharsetname) {
        AutonomousDatabaseCharacterSetInner inner = this.serviceClient().get(location, adbscharsetname);
        if (inner != null) {
            return new AutonomousDatabaseCharacterSetImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public PagedIterable<AutonomousDatabaseCharacterSet> listByLocation(String location) {
        PagedIterable<AutonomousDatabaseCharacterSetInner> inner = this.serviceClient().listByLocation(location);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new AutonomousDatabaseCharacterSetImpl(inner1, this.manager()));
    }

    public PagedIterable<AutonomousDatabaseCharacterSet> listByLocation(String location, Context context) {
        PagedIterable<AutonomousDatabaseCharacterSetInner> inner
            = this.serviceClient().listByLocation(location, context);
        return ResourceManagerUtils.mapPage(inner,
            inner1 -> new AutonomousDatabaseCharacterSetImpl(inner1, this.manager()));
    }

    private AutonomousDatabaseCharacterSetsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.oracledatabase.OracleDatabaseManager manager() {
        return this.serviceManager;
    }
}
