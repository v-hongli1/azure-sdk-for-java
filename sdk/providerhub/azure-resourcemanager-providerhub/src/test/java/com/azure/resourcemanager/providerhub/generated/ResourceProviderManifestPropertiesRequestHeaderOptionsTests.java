// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.OptInHeaderType;
import com.azure.resourcemanager.providerhub.models.OptOutHeaderType;
import com.azure.resourcemanager.providerhub.models.ResourceProviderManifestPropertiesRequestHeaderOptions;
import org.junit.jupiter.api.Assertions;

public final class ResourceProviderManifestPropertiesRequestHeaderOptionsTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        ResourceProviderManifestPropertiesRequestHeaderOptions model = BinaryData
            .fromString(
                "{\"optInHeaders\":\"MSIResourceIdEncoded\",\"optOutHeaders\":\"SystemDataCreatedByLastModifiedBy\"}")
            .toObject(ResourceProviderManifestPropertiesRequestHeaderOptions.class);
        Assertions.assertEquals(OptInHeaderType.MSIRESOURCE_ID_ENCODED, model.optInHeaders());
        Assertions.assertEquals(OptOutHeaderType.SYSTEM_DATA_CREATED_BY_LAST_MODIFIED_BY, model.optOutHeaders());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        ResourceProviderManifestPropertiesRequestHeaderOptions model
            = new ResourceProviderManifestPropertiesRequestHeaderOptions()
                .withOptInHeaders(OptInHeaderType.MSIRESOURCE_ID_ENCODED)
                .withOptOutHeaders(OptOutHeaderType.SYSTEM_DATA_CREATED_BY_LAST_MODIFIED_BY);
        model = BinaryData.fromObject(model).toObject(ResourceProviderManifestPropertiesRequestHeaderOptions.class);
        Assertions.assertEquals(OptInHeaderType.MSIRESOURCE_ID_ENCODED, model.optInHeaders());
        Assertions.assertEquals(OptOutHeaderType.SYSTEM_DATA_CREATED_BY_LAST_MODIFIED_BY, model.optOutHeaders());
    }
}
