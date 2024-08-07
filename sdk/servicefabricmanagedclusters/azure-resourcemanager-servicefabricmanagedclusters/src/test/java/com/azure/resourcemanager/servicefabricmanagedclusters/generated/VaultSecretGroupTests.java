// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabricmanagedclusters.generated;

import com.azure.core.management.SubResource;
import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.VaultCertificate;
import com.azure.resourcemanager.servicefabricmanagedclusters.models.VaultSecretGroup;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VaultSecretGroupTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VaultSecretGroup model = BinaryData.fromString(
            "{\"sourceVault\":{\"id\":\"yuhqlbjbsybbqwrv\"},\"vaultCertificates\":[{\"certificateUrl\":\"dgmfpgvmpipasl\",\"certificateStore\":\"haq\"},{\"certificateUrl\":\"x\",\"certificateStore\":\"smwutwbdsrezpd\"},{\"certificateUrl\":\"hneuyowqkd\",\"certificateStore\":\"ytisibir\"}]}")
            .toObject(VaultSecretGroup.class);
        Assertions.assertEquals("yuhqlbjbsybbqwrv", model.sourceVault().id());
        Assertions.assertEquals("dgmfpgvmpipasl", model.vaultCertificates().get(0).certificateUrl());
        Assertions.assertEquals("haq", model.vaultCertificates().get(0).certificateStore());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VaultSecretGroup model
            = new VaultSecretGroup().withSourceVault(new SubResource().withId("yuhqlbjbsybbqwrv"))
                .withVaultCertificates(Arrays.asList(
                    new VaultCertificate().withCertificateUrl("dgmfpgvmpipasl").withCertificateStore("haq"),
                    new VaultCertificate().withCertificateUrl("x").withCertificateStore("smwutwbdsrezpd"),
                    new VaultCertificate().withCertificateUrl("hneuyowqkd").withCertificateStore("ytisibir")));
        model = BinaryData.fromObject(model).toObject(VaultSecretGroup.class);
        Assertions.assertEquals("yuhqlbjbsybbqwrv", model.sourceVault().id());
        Assertions.assertEquals("dgmfpgvmpipasl", model.vaultCertificates().get(0).certificateUrl());
        Assertions.assertEquals("haq", model.vaultCertificates().get(0).certificateStore());
    }
}
