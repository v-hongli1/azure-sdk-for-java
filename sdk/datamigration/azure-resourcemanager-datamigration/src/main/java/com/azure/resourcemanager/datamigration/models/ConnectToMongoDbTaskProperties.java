// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datamigration.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.exception.ManagementError;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datamigration.fluent.models.CommandPropertiesInner;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * Properties for the task that validates the connection to and provides information about a MongoDB server.
 */
@Fluent
public final class ConnectToMongoDbTaskProperties extends ProjectTaskProperties {
    /*
     * Task type.
     */
    private TaskType taskType = TaskType.CONNECT_MONGO_DB;

    /*
     * Describes a connection to a MongoDB data source
     */
    private MongoDbConnectionInfo input;

    /*
     * An array containing a single MongoDbClusterInfo object
     */
    private List<MongoDbClusterInfo> output;

    /**
     * Creates an instance of ConnectToMongoDbTaskProperties class.
     */
    public ConnectToMongoDbTaskProperties() {
    }

    /**
     * Get the taskType property: Task type.
     * 
     * @return the taskType value.
     */
    @Override
    public TaskType taskType() {
        return this.taskType;
    }

    /**
     * Get the input property: Describes a connection to a MongoDB data source.
     * 
     * @return the input value.
     */
    public MongoDbConnectionInfo input() {
        return this.input;
    }

    /**
     * Set the input property: Describes a connection to a MongoDB data source.
     * 
     * @param input the input value to set.
     * @return the ConnectToMongoDbTaskProperties object itself.
     */
    public ConnectToMongoDbTaskProperties withInput(MongoDbConnectionInfo input) {
        this.input = input;
        return this;
    }

    /**
     * Get the output property: An array containing a single MongoDbClusterInfo object.
     * 
     * @return the output value.
     */
    public List<MongoDbClusterInfo> output() {
        return this.output;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ConnectToMongoDbTaskProperties withClientData(Map<String, String> clientData) {
        super.withClientData(clientData);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (input() != null) {
            input().validate();
        }
        if (output() != null) {
            output().forEach(e -> e.validate());
        }
        if (commands() != null) {
            commands().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeMapField("clientData", clientData(), (writer, element) -> writer.writeString(element));
        jsonWriter.writeStringField("taskType", this.taskType == null ? null : this.taskType.toString());
        jsonWriter.writeJsonField("input", this.input);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ConnectToMongoDbTaskProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectToMongoDbTaskProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ConnectToMongoDbTaskProperties.
     */
    public static ConnectToMongoDbTaskProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectToMongoDbTaskProperties deserializedConnectToMongoDbTaskProperties
                = new ConnectToMongoDbTaskProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("errors".equals(fieldName)) {
                    List<ManagementError> errors = reader.readArray(reader1 -> ManagementError.fromJson(reader1));
                    deserializedConnectToMongoDbTaskProperties.withErrors(errors);
                } else if ("state".equals(fieldName)) {
                    deserializedConnectToMongoDbTaskProperties.withState(TaskState.fromString(reader.getString()));
                } else if ("commands".equals(fieldName)) {
                    List<CommandPropertiesInner> commands
                        = reader.readArray(reader1 -> CommandPropertiesInner.fromJson(reader1));
                    deserializedConnectToMongoDbTaskProperties.withCommands(commands);
                } else if ("clientData".equals(fieldName)) {
                    Map<String, String> clientData = reader.readMap(reader1 -> reader1.getString());
                    deserializedConnectToMongoDbTaskProperties.withClientData(clientData);
                } else if ("taskType".equals(fieldName)) {
                    deserializedConnectToMongoDbTaskProperties.taskType = TaskType.fromString(reader.getString());
                } else if ("input".equals(fieldName)) {
                    deserializedConnectToMongoDbTaskProperties.input = MongoDbConnectionInfo.fromJson(reader);
                } else if ("output".equals(fieldName)) {
                    List<MongoDbClusterInfo> output = reader.readArray(reader1 -> MongoDbClusterInfo.fromJson(reader1));
                    deserializedConnectToMongoDbTaskProperties.output = output;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectToMongoDbTaskProperties;
        });
    }
}
