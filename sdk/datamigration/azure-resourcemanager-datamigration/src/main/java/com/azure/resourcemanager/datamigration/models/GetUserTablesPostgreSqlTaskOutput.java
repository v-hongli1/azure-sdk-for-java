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
import java.util.List;

/**
 * Output for the task that gets the list of tables for a provided list of PostgreSQL databases.
 */
@Immutable
public final class GetUserTablesPostgreSqlTaskOutput implements JsonSerializable<GetUserTablesPostgreSqlTaskOutput> {
    /*
     * The database this result is for
     */
    private String databaseName;

    /*
     * List of valid tables found for this database
     */
    private List<DatabaseTable> tables;

    /*
     * Validation errors associated with the task
     */
    private List<ReportableException> validationErrors;

    /**
     * Creates an instance of GetUserTablesPostgreSqlTaskOutput class.
     */
    public GetUserTablesPostgreSqlTaskOutput() {
    }

    /**
     * Get the databaseName property: The database this result is for.
     * 
     * @return the databaseName value.
     */
    public String databaseName() {
        return this.databaseName;
    }

    /**
     * Get the tables property: List of valid tables found for this database.
     * 
     * @return the tables value.
     */
    public List<DatabaseTable> tables() {
        return this.tables;
    }

    /**
     * Get the validationErrors property: Validation errors associated with the task.
     * 
     * @return the validationErrors value.
     */
    public List<ReportableException> validationErrors() {
        return this.validationErrors;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (tables() != null) {
            tables().forEach(e -> e.validate());
        }
        if (validationErrors() != null) {
            validationErrors().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GetUserTablesPostgreSqlTaskOutput from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GetUserTablesPostgreSqlTaskOutput if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the GetUserTablesPostgreSqlTaskOutput.
     */
    public static GetUserTablesPostgreSqlTaskOutput fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GetUserTablesPostgreSqlTaskOutput deserializedGetUserTablesPostgreSqlTaskOutput
                = new GetUserTablesPostgreSqlTaskOutput();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("databaseName".equals(fieldName)) {
                    deserializedGetUserTablesPostgreSqlTaskOutput.databaseName = reader.getString();
                } else if ("tables".equals(fieldName)) {
                    List<DatabaseTable> tables = reader.readArray(reader1 -> DatabaseTable.fromJson(reader1));
                    deserializedGetUserTablesPostgreSqlTaskOutput.tables = tables;
                } else if ("validationErrors".equals(fieldName)) {
                    List<ReportableException> validationErrors
                        = reader.readArray(reader1 -> ReportableException.fromJson(reader1));
                    deserializedGetUserTablesPostgreSqlTaskOutput.validationErrors = validationErrors;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGetUserTablesPostgreSqlTaskOutput;
        });
    }
}
