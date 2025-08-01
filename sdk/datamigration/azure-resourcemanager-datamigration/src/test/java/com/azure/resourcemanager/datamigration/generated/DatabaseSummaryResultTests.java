// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.DatabaseSummaryResult;

public final class DatabaseSummaryResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DatabaseSummaryResult model = BinaryData.fromString(
            "{\"sizeMB\":33.23106588969031,\"name\":\"tzqdd\",\"startedOn\":\"2021-01-15T07:24:05Z\",\"endedOn\":\"2021-04-30T19:25:35Z\",\"state\":\"Warning\",\"statusMessage\":\"amtuatmzwcjjnc\",\"itemsCount\":6761769972871161630,\"itemsCompletedCount\":3496579606720695064,\"errorPrefix\":\"gbgatzuuvbxn\",\"resultPrefix\":\"ebwgga\"}")
            .toObject(DatabaseSummaryResult.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DatabaseSummaryResult model = new DatabaseSummaryResult();
        model = BinaryData.fromObject(model).toObject(DatabaseSummaryResult.class);
    }
}
