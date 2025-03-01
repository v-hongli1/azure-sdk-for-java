// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.spring.cloud.autoconfigure.implementation.aadb2c.configuration.properties;

/**
 * Profile of Azure cloud environment.
 */
public class AadB2cProfileProperties {
    /**
     * Azure Tenant ID. The values allowed for 'tenant-id' are: 'common', 'organizations', 'consumers', or the tenant ID.
     */
    private String tenantId; // tenantId can not set to "common" here, otherwise we can not know whether it's set by customer or it is the default value.

    /**
     *
     * @param tenantId The tenant id.
     */
    public void setTenantId(String tenantId) {
        this.tenantId = tenantId;
    }

    /**
     *
     * @return The tenant id.
     */
    public String getTenantId() {
        return tenantId;
    }
}
