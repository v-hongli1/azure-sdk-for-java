// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.oracledatabase.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Details of removing Virtual Machines from the Exadata VM cluster on Exascale Infrastructure. Applies to Exadata
 * Database Service on Exascale Infrastructure only.
 */
@Fluent
public final class RemoveVirtualMachineFromExadbVmClusterDetails
    implements JsonSerializable<RemoveVirtualMachineFromExadbVmClusterDetails> {
    /*
     * The list of ExaCS DB nodes for the Exadata VM cluster on Exascale Infrastructure to be removed.
     */
    private List<DbNodeDetails> dbNodes;

    /**
     * Creates an instance of RemoveVirtualMachineFromExadbVmClusterDetails class.
     */
    public RemoveVirtualMachineFromExadbVmClusterDetails() {
    }

    /**
     * Get the dbNodes property: The list of ExaCS DB nodes for the Exadata VM cluster on Exascale Infrastructure to be
     * removed.
     * 
     * @return the dbNodes value.
     */
    public List<DbNodeDetails> dbNodes() {
        return this.dbNodes;
    }

    /**
     * Set the dbNodes property: The list of ExaCS DB nodes for the Exadata VM cluster on Exascale Infrastructure to be
     * removed.
     * 
     * @param dbNodes the dbNodes value to set.
     * @return the RemoveVirtualMachineFromExadbVmClusterDetails object itself.
     */
    public RemoveVirtualMachineFromExadbVmClusterDetails withDbNodes(List<DbNodeDetails> dbNodes) {
        this.dbNodes = dbNodes;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (dbNodes() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property dbNodes in model RemoveVirtualMachineFromExadbVmClusterDetails"));
        } else {
            dbNodes().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RemoveVirtualMachineFromExadbVmClusterDetails.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("dbNodes", this.dbNodes, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RemoveVirtualMachineFromExadbVmClusterDetails from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RemoveVirtualMachineFromExadbVmClusterDetails if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RemoveVirtualMachineFromExadbVmClusterDetails.
     */
    public static RemoveVirtualMachineFromExadbVmClusterDetails fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RemoveVirtualMachineFromExadbVmClusterDetails deserializedRemoveVirtualMachineFromExadbVmClusterDetails
                = new RemoveVirtualMachineFromExadbVmClusterDetails();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("dbNodes".equals(fieldName)) {
                    List<DbNodeDetails> dbNodes = reader.readArray(reader1 -> DbNodeDetails.fromJson(reader1));
                    deserializedRemoveVirtualMachineFromExadbVmClusterDetails.dbNodes = dbNodes;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRemoveVirtualMachineFromExadbVmClusterDetails;
        });
    }
}
