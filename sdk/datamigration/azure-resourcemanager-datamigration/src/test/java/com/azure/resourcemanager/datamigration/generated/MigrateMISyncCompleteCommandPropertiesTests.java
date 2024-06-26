// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.MigrateMISyncCompleteCommandInput;
import com.azure.resourcemanager.datamigration.models.MigrateMISyncCompleteCommandProperties;
import org.junit.jupiter.api.Assertions;

public final class MigrateMISyncCompleteCommandPropertiesTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MigrateMISyncCompleteCommandProperties model =
            BinaryData
                .fromString(
                    "{\"commandType\":\"Migrate.SqlServer.AzureDbSqlMi.Complete\",\"input\":{\"sourceDatabaseName\":\"f\"},\"output\":{\"errors\":[{\"message\":\"v\",\"actionableMessage\":\"csonpclhoco\",\"filePath\":\"lkevle\",\"lineNumber\":\"zfbuhf\",\"hResult\":53032115,\"stackTrace\":\"x\"},{\"message\":\"feiithlvmez\",\"actionableMessage\":\"shxmzsbbzoggigrx\",\"filePath\":\"ur\",\"lineNumber\":\"xxjnspydptk\",\"hResult\":1482419493,\"stackTrace\":\"ou\"},{\"message\":\"vudwtiukbldng\",\"actionableMessage\":\"ocipazyxoeg\",\"filePath\":\"g\",\"lineNumber\":\"piu\",\"hResult\":2007054909,\"stackTrace\":\"evqzntypmrbp\"},{\"message\":\"c\",\"actionableMessage\":\"qjsdpydnfyhxdeo\",\"filePath\":\"zi\",\"lineNumber\":\"ifsjttgzfbishcb\",\"hResult\":1409405599,\"stackTrace\":\"deyeamdphagalpbu\"}]},\"errors\":[],\"state\":\"Succeeded\"}")
                .toObject(MigrateMISyncCompleteCommandProperties.class);
        Assertions.assertEquals("f", model.input().sourceDatabaseName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MigrateMISyncCompleteCommandProperties model =
            new MigrateMISyncCompleteCommandProperties()
                .withInput(new MigrateMISyncCompleteCommandInput().withSourceDatabaseName("f"));
        model = BinaryData.fromObject(model).toObject(MigrateMISyncCompleteCommandProperties.class);
        Assertions.assertEquals("f", model.input().sourceDatabaseName());
    }
}
