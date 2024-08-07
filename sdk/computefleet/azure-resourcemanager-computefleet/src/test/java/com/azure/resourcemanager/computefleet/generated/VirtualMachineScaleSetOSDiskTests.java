// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.computefleet.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.computefleet.models.CachingTypes;
import com.azure.resourcemanager.computefleet.models.DiffDiskOptions;
import com.azure.resourcemanager.computefleet.models.DiffDiskPlacement;
import com.azure.resourcemanager.computefleet.models.DiffDiskSettings;
import com.azure.resourcemanager.computefleet.models.DiskCreateOptionTypes;
import com.azure.resourcemanager.computefleet.models.DiskDeleteOptionTypes;
import com.azure.resourcemanager.computefleet.models.DiskEncryptionSetParameters;
import com.azure.resourcemanager.computefleet.models.OperatingSystemTypes;
import com.azure.resourcemanager.computefleet.models.SecurityEncryptionTypes;
import com.azure.resourcemanager.computefleet.models.StorageAccountTypes;
import com.azure.resourcemanager.computefleet.models.VirtualHardDisk;
import com.azure.resourcemanager.computefleet.models.VirtualMachineScaleSetManagedDiskParameters;
import com.azure.resourcemanager.computefleet.models.VirtualMachineScaleSetOSDisk;
import com.azure.resourcemanager.computefleet.models.VMDiskSecurityProfile;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class VirtualMachineScaleSetOSDiskTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        VirtualMachineScaleSetOSDisk model = BinaryData.fromString(
            "{\"name\":\"ehzzvypyqrim\",\"caching\":\"None\",\"writeAcceleratorEnabled\":false,\"createOption\":\"Restore\",\"diffDiskSettings\":{\"option\":\"Local\",\"placement\":\"CacheDisk\"},\"diskSizeGB\":1230254023,\"osType\":\"Windows\",\"image\":{\"uri\":\"xhcr\"},\"vhdContainers\":[\"hjtckwhd\",\"oifiyipjxsqwpgr\"],\"managedDisk\":{\"storageAccountType\":\"StandardSSD_ZRS\",\"diskEncryptionSet\":{\"id\":\"cjxvsnbyxqab\"},\"securityProfile\":{\"securityEncryptionType\":\"NonPersistedTPM\",\"diskEncryptionSet\":{\"id\":\"ysh\"}}},\"deleteOption\":\"Delete\"}")
            .toObject(VirtualMachineScaleSetOSDisk.class);
        Assertions.assertEquals("ehzzvypyqrim", model.name());
        Assertions.assertEquals(CachingTypes.NONE, model.caching());
        Assertions.assertEquals(false, model.writeAcceleratorEnabled());
        Assertions.assertEquals(DiskCreateOptionTypes.RESTORE, model.createOption());
        Assertions.assertEquals(DiffDiskOptions.LOCAL, model.diffDiskSettings().option());
        Assertions.assertEquals(DiffDiskPlacement.CACHE_DISK, model.diffDiskSettings().placement());
        Assertions.assertEquals(1230254023, model.diskSizeGB());
        Assertions.assertEquals(OperatingSystemTypes.WINDOWS, model.osType());
        Assertions.assertEquals("xhcr", model.image().uri());
        Assertions.assertEquals("hjtckwhd", model.vhdContainers().get(0));
        Assertions.assertEquals(StorageAccountTypes.STANDARD_SSD_ZRS, model.managedDisk().storageAccountType());
        Assertions.assertEquals("cjxvsnbyxqab", model.managedDisk().diskEncryptionSet().id());
        Assertions.assertEquals(SecurityEncryptionTypes.NON_PERSISTED_TPM,
            model.managedDisk().securityProfile().securityEncryptionType());
        Assertions.assertEquals("ysh", model.managedDisk().securityProfile().diskEncryptionSet().id());
        Assertions.assertEquals(DiskDeleteOptionTypes.DELETE, model.deleteOption());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        VirtualMachineScaleSetOSDisk model = new VirtualMachineScaleSetOSDisk().withName("ehzzvypyqrim")
            .withCaching(CachingTypes.NONE)
            .withWriteAcceleratorEnabled(false)
            .withCreateOption(DiskCreateOptionTypes.RESTORE)
            .withDiffDiskSettings(
                new DiffDiskSettings().withOption(DiffDiskOptions.LOCAL).withPlacement(DiffDiskPlacement.CACHE_DISK))
            .withDiskSizeGB(1230254023)
            .withOsType(OperatingSystemTypes.WINDOWS)
            .withImage(new VirtualHardDisk().withUri("xhcr"))
            .withVhdContainers(Arrays.asList("hjtckwhd", "oifiyipjxsqwpgr"))
            .withManagedDisk(
                new VirtualMachineScaleSetManagedDiskParameters()
                    .withStorageAccountType(StorageAccountTypes.STANDARD_SSD_ZRS)
                    .withDiskEncryptionSet(new DiskEncryptionSetParameters().withId("cjxvsnbyxqab"))
                    .withSecurityProfile(new VMDiskSecurityProfile()
                        .withSecurityEncryptionType(SecurityEncryptionTypes.NON_PERSISTED_TPM)
                        .withDiskEncryptionSet(new DiskEncryptionSetParameters().withId("ysh"))))
            .withDeleteOption(DiskDeleteOptionTypes.DELETE);
        model = BinaryData.fromObject(model).toObject(VirtualMachineScaleSetOSDisk.class);
        Assertions.assertEquals("ehzzvypyqrim", model.name());
        Assertions.assertEquals(CachingTypes.NONE, model.caching());
        Assertions.assertEquals(false, model.writeAcceleratorEnabled());
        Assertions.assertEquals(DiskCreateOptionTypes.RESTORE, model.createOption());
        Assertions.assertEquals(DiffDiskOptions.LOCAL, model.diffDiskSettings().option());
        Assertions.assertEquals(DiffDiskPlacement.CACHE_DISK, model.diffDiskSettings().placement());
        Assertions.assertEquals(1230254023, model.diskSizeGB());
        Assertions.assertEquals(OperatingSystemTypes.WINDOWS, model.osType());
        Assertions.assertEquals("xhcr", model.image().uri());
        Assertions.assertEquals("hjtckwhd", model.vhdContainers().get(0));
        Assertions.assertEquals(StorageAccountTypes.STANDARD_SSD_ZRS, model.managedDisk().storageAccountType());
        Assertions.assertEquals("cjxvsnbyxqab", model.managedDisk().diskEncryptionSet().id());
        Assertions.assertEquals(SecurityEncryptionTypes.NON_PERSISTED_TPM,
            model.managedDisk().securityProfile().securityEncryptionType());
        Assertions.assertEquals("ysh", model.managedDisk().securityProfile().diskEncryptionSet().id());
        Assertions.assertEquals(DiskDeleteOptionTypes.DELETE, model.deleteOption());
    }
}
