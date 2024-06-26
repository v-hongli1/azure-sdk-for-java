// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.desktopvirtualization.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.desktopvirtualization.models.SendMessage;
import org.junit.jupiter.api.Assertions;

public final class SendMessageTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SendMessage model =
            BinaryData
                .fromString("{\"messageTitle\":\"srdvetn\",\"messageBody\":\"dtutnwldu\"}")
                .toObject(SendMessage.class);
        Assertions.assertEquals("srdvetn", model.messageTitle());
        Assertions.assertEquals("dtutnwldu", model.messageBody());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SendMessage model = new SendMessage().withMessageTitle("srdvetn").withMessageBody("dtutnwldu");
        model = BinaryData.fromObject(model).toObject(SendMessage.class);
        Assertions.assertEquals("srdvetn", model.messageTitle());
        Assertions.assertEquals("dtutnwldu", model.messageBody());
    }
}
