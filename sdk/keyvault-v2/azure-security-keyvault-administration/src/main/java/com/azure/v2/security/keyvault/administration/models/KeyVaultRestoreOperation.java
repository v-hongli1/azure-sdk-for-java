// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.security.keyvault.administration.models;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;

import java.time.OffsetDateTime;

/**
 * A class that contains the details of a restore operation.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class KeyVaultRestoreOperation extends KeyVaultLongRunningOperation {
    /**
     * Creates an object containing the details of a {@link KeyVaultRestoreOperation}.
     *
     * @param status Status of the {@link KeyVaultRestoreOperation}.
     * @param statusDetails The status details of the {@link KeyVaultRestoreOperation}.
     * @param error Error encountered, if any, during the {@link KeyVaultRestoreOperation}.
     * @param startTime The start time of the {@link KeyVaultRestoreOperation}.
     * @param endTime The end time of the {@link KeyVaultRestoreOperation}.
     * @param operationId Identifier for the full {@link KeyVaultRestoreOperation}.
     */
    public KeyVaultRestoreOperation(String status, String statusDetails, KeyVaultAdministrationError error,
        String operationId, OffsetDateTime startTime, OffsetDateTime endTime) {
        super(status, statusDetails, error, operationId, startTime, endTime);
    }
}
