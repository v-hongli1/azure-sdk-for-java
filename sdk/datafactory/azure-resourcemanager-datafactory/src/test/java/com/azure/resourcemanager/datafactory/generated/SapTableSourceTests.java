// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datafactory.models.SapTablePartitionSettings;
import com.azure.resourcemanager.datafactory.models.SapTableSource;

public final class SapTableSourceTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        SapTableSource model = BinaryData.fromString(
            "{\"type\":\"SapTableSource\",\"rowCount\":\"dataoukfjwkctdn\",\"rowSkips\":\"dataokqeuzslny\",\"rfcTableFields\":\"datauywijnlpeczq\",\"rfcTableOptions\":\"datamzkqydthf\",\"batchSize\":\"dataycmwvphrwuf\",\"customRfcReadTableFunctionModule\":\"dataov\",\"sapDataColumnDelimiter\":\"dataisqlekc\",\"partitionOption\":\"datadhlskeifwqtcownx\",\"partitionSettings\":{\"partitionColumnName\":\"dataptvbudb\",\"partitionUpperBound\":\"datajvmllyjelnhmu\",\"partitionLowerBound\":\"dataxkofzx\",\"maxPartitionsNumber\":\"datasleokbama\"},\"queryTimeout\":\"datawgccgblepamvl\",\"additionalColumns\":\"dataxdaoj\",\"sourceRetryCount\":\"datalqoxwqlnxvnmrl\",\"sourceRetryWait\":\"datajzya\",\"maxConcurrentConnections\":\"datafecwnufldzjc\",\"disableMetricsCollection\":\"datahjbzpoh\",\"\":{\"lnvfshtujaqp\":\"datagpefvboxvw\"}}")
            .toObject(SapTableSource.class);
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        SapTableSource model = new SapTableSource().withSourceRetryCount("datalqoxwqlnxvnmrl")
            .withSourceRetryWait("datajzya")
            .withMaxConcurrentConnections("datafecwnufldzjc")
            .withDisableMetricsCollection("datahjbzpoh")
            .withQueryTimeout("datawgccgblepamvl")
            .withAdditionalColumns("dataxdaoj")
            .withRowCount("dataoukfjwkctdn")
            .withRowSkips("dataokqeuzslny")
            .withRfcTableFields("datauywijnlpeczq")
            .withRfcTableOptions("datamzkqydthf")
            .withBatchSize("dataycmwvphrwuf")
            .withCustomRfcReadTableFunctionModule("dataov")
            .withSapDataColumnDelimiter("dataisqlekc")
            .withPartitionOption("datadhlskeifwqtcownx")
            .withPartitionSettings(new SapTablePartitionSettings().withPartitionColumnName("dataptvbudb")
                .withPartitionUpperBound("datajvmllyjelnhmu")
                .withPartitionLowerBound("dataxkofzx")
                .withMaxPartitionsNumber("datasleokbama"));
        model = BinaryData.fromObject(model).toObject(SapTableSource.class);
    }
}
