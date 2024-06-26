// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysqlflexibleserver.implementation;

import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.mysqlflexibleserver.fluent.LongRunningBackupsClient;
import com.azure.resourcemanager.mysqlflexibleserver.models.LongRunningBackups;

public final class LongRunningBackupsImpl implements LongRunningBackups {
    private static final ClientLogger LOGGER = new ClientLogger(LongRunningBackupsImpl.class);

    private final LongRunningBackupsClient innerClient;

    private final com.azure.resourcemanager.mysqlflexibleserver.MySqlManager serviceManager;

    public LongRunningBackupsImpl(LongRunningBackupsClient innerClient,
        com.azure.resourcemanager.mysqlflexibleserver.MySqlManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    private LongRunningBackupsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.mysqlflexibleserver.MySqlManager manager() {
        return this.serviceManager;
    }

    public ServerBackupV2Impl define(String name) {
        return new ServerBackupV2Impl(name, this.manager());
    }
}
