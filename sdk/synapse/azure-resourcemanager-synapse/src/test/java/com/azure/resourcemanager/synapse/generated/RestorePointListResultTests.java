// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.synapse.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.synapse.models.RestorePointListResult;

public final class RestorePointListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        RestorePointListResult model = BinaryData.fromString(
            "{\"value\":[{\"location\":\"jeknizshq\",\"properties\":{\"restorePointType\":\"CONTINUOUS\",\"earliestRestoreDate\":\"2021-06-06T18:17:05Z\",\"restorePointCreationDate\":\"2020-12-31T19:03:55Z\",\"restorePointLabel\":\"mblrrilbywd\"},\"id\":\"smiccwrwfscj\",\"name\":\"n\",\"type\":\"nszqujiz\"},{\"location\":\"oqytibyowbblgy\",\"properties\":{\"restorePointType\":\"CONTINUOUS\",\"earliestRestoreDate\":\"2021-11-26T06:56:03Z\",\"restorePointCreationDate\":\"2021-08-30T13:25:29Z\",\"restorePointLabel\":\"xoi\"},\"id\":\"msksbp\",\"name\":\"mlqoljx\",\"type\":\"cgxxlxs\"}],\"nextLink\":\"gcvizqzdwlvwlyou\"}")
            .toObject(RestorePointListResult.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        RestorePointListResult model = new RestorePointListResult();
        model = BinaryData.fromObject(model).toObject(RestorePointListResult.class);
    }
}
