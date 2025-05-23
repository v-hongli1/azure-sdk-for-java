// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.apimanagement.models.ApiContactInformation;
import org.junit.jupiter.api.Assertions;

public final class ApiContactInformationTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ApiContactInformation model
            = BinaryData.fromString("{\"name\":\"jzzvdud\",\"url\":\"dslfhotwmcy\",\"email\":\"wlbjnpgacftade\"}")
                .toObject(ApiContactInformation.class);
        Assertions.assertEquals("jzzvdud", model.name());
        Assertions.assertEquals("dslfhotwmcy", model.url());
        Assertions.assertEquals("wlbjnpgacftade", model.email());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ApiContactInformation model
            = new ApiContactInformation().withName("jzzvdud").withUrl("dslfhotwmcy").withEmail("wlbjnpgacftade");
        model = BinaryData.fromObject(model).toObject(ApiContactInformation.class);
        Assertions.assertEquals("jzzvdud", model.name());
        Assertions.assertEquals("dslfhotwmcy", model.url());
        Assertions.assertEquals("wlbjnpgacftade", model.email());
    }
}
