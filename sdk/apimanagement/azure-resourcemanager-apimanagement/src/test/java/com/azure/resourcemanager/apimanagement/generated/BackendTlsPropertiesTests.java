// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.models.BackendTlsProperties;
import org.junit.jupiter.api.Assertions;

public final class BackendTlsPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        BackendTlsProperties model
            = BinaryData.fromString("{\"validateCertificateChain\":true,\"validateCertificateName\":false}")
                .toObject(BackendTlsProperties.class);
        Assertions.assertTrue(model.validateCertificateChain());
        Assertions.assertFalse(model.validateCertificateName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        BackendTlsProperties model
            = new BackendTlsProperties().withValidateCertificateChain(true).withValidateCertificateName(false);
        model = BinaryData.fromObject(model).toObject(BackendTlsProperties.class);
        Assertions.assertTrue(model.validateCertificateChain());
        Assertions.assertFalse(model.validateCertificateName());
    }
}
