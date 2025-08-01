// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.datamigration.models.MigrateOracleAzureDbPostgreSqlSyncDatabaseInput;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class MigrateOracleAzureDbPostgreSqlSyncDatabaseInputTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        MigrateOracleAzureDbPostgreSqlSyncDatabaseInput model = BinaryData.fromString(
            "{\"caseManipulation\":\"odacpunettepdjxq\",\"name\":\"koynuiylpckae\",\"schemaName\":\"edveskwxegqp\",\"tableMap\":{\"hctmjtsgh\":\"fn\",\"rpzeqac\":\"bcbcpz\"},\"targetDatabaseName\":\"dtzmpype\",\"migrationSetting\":{\"fkhuytu\":\"czshnuqndaizu\"},\"sourceSetting\":{\"tvegwqiukvzwy\":\"hmt\"},\"targetSetting\":{\"vb\":\"thaokgkskj\",\"kpeexpgeumilh\":\"shajqf\",\"ninbdbzsxcwqqrs\":\"uitrdexyiono\"}}")
            .toObject(MigrateOracleAzureDbPostgreSqlSyncDatabaseInput.class);
        Assertions.assertEquals("odacpunettepdjxq", model.caseManipulation());
        Assertions.assertEquals("koynuiylpckae", model.name());
        Assertions.assertEquals("edveskwxegqp", model.schemaName());
        Assertions.assertEquals("fn", model.tableMap().get("hctmjtsgh"));
        Assertions.assertEquals("dtzmpype", model.targetDatabaseName());
        Assertions.assertEquals("czshnuqndaizu", model.migrationSetting().get("fkhuytu"));
        Assertions.assertEquals("hmt", model.sourceSetting().get("tvegwqiukvzwy"));
        Assertions.assertEquals("thaokgkskj", model.targetSetting().get("vb"));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        MigrateOracleAzureDbPostgreSqlSyncDatabaseInput model = new MigrateOracleAzureDbPostgreSqlSyncDatabaseInput()
            .withCaseManipulation("odacpunettepdjxq")
            .withName("koynuiylpckae")
            .withSchemaName("edveskwxegqp")
            .withTableMap(mapOf("hctmjtsgh", "fn", "rpzeqac", "bcbcpz"))
            .withTargetDatabaseName("dtzmpype")
            .withMigrationSetting(mapOf("fkhuytu", "czshnuqndaizu"))
            .withSourceSetting(mapOf("tvegwqiukvzwy", "hmt"))
            .withTargetSetting(mapOf("vb", "thaokgkskj", "kpeexpgeumilh", "shajqf", "ninbdbzsxcwqqrs", "uitrdexyiono"));
        model = BinaryData.fromObject(model).toObject(MigrateOracleAzureDbPostgreSqlSyncDatabaseInput.class);
        Assertions.assertEquals("odacpunettepdjxq", model.caseManipulation());
        Assertions.assertEquals("koynuiylpckae", model.name());
        Assertions.assertEquals("edveskwxegqp", model.schemaName());
        Assertions.assertEquals("fn", model.tableMap().get("hctmjtsgh"));
        Assertions.assertEquals("dtzmpype", model.targetDatabaseName());
        Assertions.assertEquals("czshnuqndaizu", model.migrationSetting().get("fkhuytu"));
        Assertions.assertEquals("hmt", model.sourceSetting().get("tvegwqiukvzwy"));
        Assertions.assertEquals("thaokgkskj", model.targetSetting().get("vb"));
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
