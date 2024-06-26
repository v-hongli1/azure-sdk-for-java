// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicesbackup.implementation;

import com.azure.resourcemanager.recoveryservicesbackup.fluent.models.BackupResourceEncryptionConfigExtendedResourceInner;
import com.azure.resourcemanager.recoveryservicesbackup.models.BackupResourceEncryptionConfigExtended;
import com.azure.resourcemanager.recoveryservicesbackup.models.BackupResourceEncryptionConfigExtendedResource;
import java.util.Collections;
import java.util.Map;

public final class BackupResourceEncryptionConfigExtendedResourceImpl
    implements BackupResourceEncryptionConfigExtendedResource {
    private BackupResourceEncryptionConfigExtendedResourceInner innerObject;

    private final com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager;

    BackupResourceEncryptionConfigExtendedResourceImpl(BackupResourceEncryptionConfigExtendedResourceInner innerObject,
        com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

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

    public BackupResourceEncryptionConfigExtended properties() {
        return this.innerModel().properties();
    }

    public String etag() {
        return this.innerModel().etag();
    }

    public BackupResourceEncryptionConfigExtendedResourceInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.recoveryservicesbackup.RecoveryServicesBackupManager manager() {
        return this.serviceManager;
    }
}
