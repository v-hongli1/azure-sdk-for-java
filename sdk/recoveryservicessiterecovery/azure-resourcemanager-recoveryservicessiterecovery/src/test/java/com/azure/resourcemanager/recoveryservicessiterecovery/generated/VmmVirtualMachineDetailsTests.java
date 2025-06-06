// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.DiskDetails;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.OSDetails;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.PresenceStatus;
import com.azure.resourcemanager.recoveryservicessiterecovery.models.VmmVirtualMachineDetails;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VmmVirtualMachineDetailsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VmmVirtualMachineDetails model = BinaryData.fromString(
            "{\"instanceType\":\"VmmVirtualMachine\",\"sourceItemId\":\"xtdyqavfxbqmzxsy\",\"generation\":\"sinpaamihwbghvw\",\"osDetails\":{\"osType\":\"bgchcgsfzhbjkiy\",\"productType\":\"bjsdj\",\"osEdition\":\"xeysgwkcffe\",\"oSVersion\":\"nzcbivove\",\"oSMajorVersion\":\"khfeqcooplfpo\",\"oSMinorVersion\":\"mgck\",\"userSelectedOSName\":\"jpeebz\"},\"diskDetails\":[{\"maxSizeMB\":2010651742034093062,\"vhdType\":\"loutnp\",\"vhdId\":\"xooqohgpncdmwkh\",\"vhdName\":\"fhsl\"},{\"maxSizeMB\":1443206319301913427,\"vhdType\":\"uiunyevdyzdsyt\",\"vhdId\":\"kswhcamwuynfxk\",\"vhdName\":\"sfcmvhadrpb\"},{\"maxSizeMB\":834293234995642747,\"vhdType\":\"kljq\",\"vhdId\":\"w\",\"vhdName\":\"jtvjkowggxawwd\"},{\"maxSizeMB\":854046334941595684,\"vhdType\":\"kteiidlbovwbclpr\",\"vhdId\":\"gani\",\"vhdName\":\"jcn\"}],\"hasPhysicalDisk\":\"Unknown\",\"hasFibreChannelAdapter\":\"NotPresent\",\"hasSharedVhd\":\"Unknown\",\"hyperVHostId\":\"skwwnqhqlqgpwxtv\"}")
            .toObject(VmmVirtualMachineDetails.class);
        Assertions.assertEquals("xtdyqavfxbqmzxsy", model.sourceItemId());
        Assertions.assertEquals("sinpaamihwbghvw", model.generation());
        Assertions.assertEquals("bgchcgsfzhbjkiy", model.osDetails().osType());
        Assertions.assertEquals("bjsdj", model.osDetails().productType());
        Assertions.assertEquals("xeysgwkcffe", model.osDetails().osEdition());
        Assertions.assertEquals("nzcbivove", model.osDetails().oSVersion());
        Assertions.assertEquals("khfeqcooplfpo", model.osDetails().oSMajorVersion());
        Assertions.assertEquals("mgck", model.osDetails().oSMinorVersion());
        Assertions.assertEquals("jpeebz", model.osDetails().userSelectedOSName());
        Assertions.assertEquals(2010651742034093062L, model.diskDetails().get(0).maxSizeMB());
        Assertions.assertEquals("loutnp", model.diskDetails().get(0).vhdType());
        Assertions.assertEquals("xooqohgpncdmwkh", model.diskDetails().get(0).vhdId());
        Assertions.assertEquals("fhsl", model.diskDetails().get(0).vhdName());
        Assertions.assertEquals(PresenceStatus.UNKNOWN, model.hasPhysicalDisk());
        Assertions.assertEquals(PresenceStatus.NOT_PRESENT, model.hasFibreChannelAdapter());
        Assertions.assertEquals(PresenceStatus.UNKNOWN, model.hasSharedVhd());
        Assertions.assertEquals("skwwnqhqlqgpwxtv", model.hyperVHostId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VmmVirtualMachineDetails model = new VmmVirtualMachineDetails().withSourceItemId("xtdyqavfxbqmzxsy")
            .withGeneration("sinpaamihwbghvw")
            .withOsDetails(new OSDetails().withOsType("bgchcgsfzhbjkiy")
                .withProductType("bjsdj")
                .withOsEdition("xeysgwkcffe")
                .withOSVersion("nzcbivove")
                .withOSMajorVersion("khfeqcooplfpo")
                .withOSMinorVersion("mgck")
                .withUserSelectedOSName("jpeebz"))
            .withDiskDetails(Arrays.asList(
                new DiskDetails().withMaxSizeMB(2010651742034093062L)
                    .withVhdType("loutnp")
                    .withVhdId("xooqohgpncdmwkh")
                    .withVhdName("fhsl"),
                new DiskDetails().withMaxSizeMB(1443206319301913427L)
                    .withVhdType("uiunyevdyzdsyt")
                    .withVhdId("kswhcamwuynfxk")
                    .withVhdName("sfcmvhadrpb"),
                new DiskDetails().withMaxSizeMB(834293234995642747L)
                    .withVhdType("kljq")
                    .withVhdId("w")
                    .withVhdName("jtvjkowggxawwd"),
                new DiskDetails().withMaxSizeMB(854046334941595684L)
                    .withVhdType("kteiidlbovwbclpr")
                    .withVhdId("gani")
                    .withVhdName("jcn")))
            .withHasPhysicalDisk(PresenceStatus.UNKNOWN)
            .withHasFibreChannelAdapter(PresenceStatus.NOT_PRESENT)
            .withHasSharedVhd(PresenceStatus.UNKNOWN)
            .withHyperVHostId("skwwnqhqlqgpwxtv");
        model = BinaryData.fromObject(model).toObject(VmmVirtualMachineDetails.class);
        Assertions.assertEquals("xtdyqavfxbqmzxsy", model.sourceItemId());
        Assertions.assertEquals("sinpaamihwbghvw", model.generation());
        Assertions.assertEquals("bgchcgsfzhbjkiy", model.osDetails().osType());
        Assertions.assertEquals("bjsdj", model.osDetails().productType());
        Assertions.assertEquals("xeysgwkcffe", model.osDetails().osEdition());
        Assertions.assertEquals("nzcbivove", model.osDetails().oSVersion());
        Assertions.assertEquals("khfeqcooplfpo", model.osDetails().oSMajorVersion());
        Assertions.assertEquals("mgck", model.osDetails().oSMinorVersion());
        Assertions.assertEquals("jpeebz", model.osDetails().userSelectedOSName());
        Assertions.assertEquals(2010651742034093062L, model.diskDetails().get(0).maxSizeMB());
        Assertions.assertEquals("loutnp", model.diskDetails().get(0).vhdType());
        Assertions.assertEquals("xooqohgpncdmwkh", model.diskDetails().get(0).vhdId());
        Assertions.assertEquals("fhsl", model.diskDetails().get(0).vhdName());
        Assertions.assertEquals(PresenceStatus.UNKNOWN, model.hasPhysicalDisk());
        Assertions.assertEquals(PresenceStatus.NOT_PRESENT, model.hasFibreChannelAdapter());
        Assertions.assertEquals(PresenceStatus.UNKNOWN, model.hasSharedVhd());
        Assertions.assertEquals("skwwnqhqlqgpwxtv", model.hyperVHostId());
    }
}
