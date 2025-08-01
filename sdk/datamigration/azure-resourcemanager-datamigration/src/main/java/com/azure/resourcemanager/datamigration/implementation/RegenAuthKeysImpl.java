// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.implementation;

import com.azure.resourcemanager.datamigration.fluent.models.RegenAuthKeysInner;
import com.azure.resourcemanager.datamigration.models.RegenAuthKeys;

public final class RegenAuthKeysImpl implements RegenAuthKeys {
    private RegenAuthKeysInner innerObject;

    private final com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager;

    RegenAuthKeysImpl(RegenAuthKeysInner innerObject,
        com.azure.resourcemanager.datamigration.DataMigrationManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String keyName() {
        return this.innerModel().keyName();
    }

    public String authKey1() {
        return this.innerModel().authKey1();
    }

    public String authKey2() {
        return this.innerModel().authKey2();
    }

    public RegenAuthKeysInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.datamigration.DataMigrationManager manager() {
        return this.serviceManager;
    }
}
