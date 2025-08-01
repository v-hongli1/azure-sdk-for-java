// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Output for the task that migrates Oracle databases to Azure Database for PostgreSQL for online migrations.
 */
@Immutable
public class MigrateOracleAzureDbPostgreSqlSyncTaskOutput
    implements JsonSerializable<MigrateOracleAzureDbPostgreSqlSyncTaskOutput> {
    /*
     * Result type
     */
    private String resultType = "MigrateOracleAzureDbPostgreSqlSyncTaskOutput";

    /*
     * Result identifier
     */
    private String id;

    /**
     * Creates an instance of MigrateOracleAzureDbPostgreSqlSyncTaskOutput class.
     */
    public MigrateOracleAzureDbPostgreSqlSyncTaskOutput() {
    }

    /**
     * Get the resultType property: Result type.
     * 
     * @return the resultType value.
     */
    public String resultType() {
        return this.resultType;
    }

    /**
     * Get the id property: Result identifier.
     * 
     * @return the id value.
     */
    public String id() {
        return this.id;
    }

    /**
     * Set the id property: Result identifier.
     * 
     * @param id the id value to set.
     * @return the MigrateOracleAzureDbPostgreSqlSyncTaskOutput object itself.
     */
    MigrateOracleAzureDbPostgreSqlSyncTaskOutput withId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("resultType", this.resultType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MigrateOracleAzureDbPostgreSqlSyncTaskOutput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MigrateOracleAzureDbPostgreSqlSyncTaskOutput if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MigrateOracleAzureDbPostgreSqlSyncTaskOutput.
     */
    public static MigrateOracleAzureDbPostgreSqlSyncTaskOutput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("resultType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("MigrationLevelOutput".equals(discriminatorValue)) {
                    return MigrateOracleAzureDbPostgreSqlSyncTaskOutputMigrationLevel.fromJson(readerToUse.reset());
                } else if ("DatabaseLevelOutput".equals(discriminatorValue)) {
                    return MigrateOracleAzureDbPostgreSqlSyncTaskOutputDatabaseLevel.fromJson(readerToUse.reset());
                } else if ("TableLevelOutput".equals(discriminatorValue)) {
                    return MigrateOracleAzureDbPostgreSqlSyncTaskOutputTableLevel.fromJson(readerToUse.reset());
                } else if ("ErrorOutput".equals(discriminatorValue)) {
                    return MigrateOracleAzureDbPostgreSqlSyncTaskOutputError.fromJson(readerToUse.reset());
                } else if ("DatabaseLevelErrorOutput".equals(discriminatorValue)) {
                    return MigrateOracleAzureDbPostgreSqlSyncTaskOutputDatabaseError.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static MigrateOracleAzureDbPostgreSqlSyncTaskOutput fromJsonKnownDiscriminator(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            MigrateOracleAzureDbPostgreSqlSyncTaskOutput deserializedMigrateOracleAzureDbPostgreSqlSyncTaskOutput
                = new MigrateOracleAzureDbPostgreSqlSyncTaskOutput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resultType".equals(fieldName)) {
                    deserializedMigrateOracleAzureDbPostgreSqlSyncTaskOutput.resultType = reader.getString();
                } else if ("id".equals(fieldName)) {
                    deserializedMigrateOracleAzureDbPostgreSqlSyncTaskOutput.id = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedMigrateOracleAzureDbPostgreSqlSyncTaskOutput;
        });
    }
}
