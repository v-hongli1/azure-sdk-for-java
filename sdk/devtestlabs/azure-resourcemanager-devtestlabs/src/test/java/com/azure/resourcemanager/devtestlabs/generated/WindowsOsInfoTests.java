// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.devtestlabs.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.devtestlabs.models.WindowsOsInfo;
import com.azure.resourcemanager.devtestlabs.models.WindowsOsState;
import org.junit.jupiter.api.Assertions;

public final class WindowsOsInfoTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        WindowsOsInfo model
            = BinaryData.fromString("{\"windowsOsState\":\"NonSysprepped\"}").toObject(WindowsOsInfo.class);
        Assertions.assertEquals(WindowsOsState.NON_SYSPREPPED, model.windowsOsState());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        WindowsOsInfo model = new WindowsOsInfo().withWindowsOsState(WindowsOsState.NON_SYSPREPPED);
        model = BinaryData.fromObject(model).toObject(WindowsOsInfo.class);
        Assertions.assertEquals(WindowsOsState.NON_SYSPREPPED, model.windowsOsState());
    }
}
