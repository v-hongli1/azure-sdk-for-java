// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.implementation;

import com.azure.resourcemanager.oracledatabase.fluent.models.SaasSubscriptionDetailsInner;
import com.azure.resourcemanager.oracledatabase.models.SaasSubscriptionDetails;
import java.time.OffsetDateTime;

public final class SaasSubscriptionDetailsImpl implements SaasSubscriptionDetails {
    private SaasSubscriptionDetailsInner innerObject;

    private final com.azure.resourcemanager.oracledatabase.OracleDatabaseManager serviceManager;

    SaasSubscriptionDetailsImpl(SaasSubscriptionDetailsInner innerObject,
        com.azure.resourcemanager.oracledatabase.OracleDatabaseManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
    }

    public String id() {
        return this.innerModel().id();
    }

    public String subscriptionName() {
        return this.innerModel().subscriptionName();
    }

    public OffsetDateTime timeCreated() {
        return this.innerModel().timeCreated();
    }

    public String offerId() {
        return this.innerModel().offerId();
    }

    public String planId() {
        return this.innerModel().planId();
    }

    public String saasSubscriptionStatus() {
        return this.innerModel().saasSubscriptionStatus();
    }

    public String publisherId() {
        return this.innerModel().publisherId();
    }

    public String purchaserEmailId() {
        return this.innerModel().purchaserEmailId();
    }

    public String purchaserTenantId() {
        return this.innerModel().purchaserTenantId();
    }

    public String termUnit() {
        return this.innerModel().termUnit();
    }

    public Boolean isAutoRenew() {
        return this.innerModel().isAutoRenew();
    }

    public Boolean isFreeTrial() {
        return this.innerModel().isFreeTrial();
    }

    public SaasSubscriptionDetailsInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.oracledatabase.OracleDatabaseManager manager() {
        return this.serviceManager;
    }
}
