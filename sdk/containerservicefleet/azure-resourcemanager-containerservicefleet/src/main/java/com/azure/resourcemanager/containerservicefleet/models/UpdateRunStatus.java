// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.containerservicefleet.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The status of a UpdateRun.
 */
@Immutable
public final class UpdateRunStatus implements JsonSerializable<UpdateRunStatus> {
    /*
     * The status of the UpdateRun.
     */
    private UpdateStatus status;

    /*
     * The stages composing an update run. Stages are run sequentially withing an UpdateRun.
     */
    private List<UpdateStageStatus> stages;

    /*
     * The node image upgrade specs for the update run. It is only set in update run when `NodeImageSelection.type` is
     * `Consistent`.
     */
    private NodeImageSelectionStatus nodeImageSelection;

    /**
     * Creates an instance of UpdateRunStatus class.
     */
    private UpdateRunStatus() {
    }

    /**
     * Get the status property: The status of the UpdateRun.
     * 
     * @return the status value.
     */
    public UpdateStatus status() {
        return this.status;
    }

    /**
     * Get the stages property: The stages composing an update run. Stages are run sequentially withing an UpdateRun.
     * 
     * @return the stages value.
     */
    public List<UpdateStageStatus> stages() {
        return this.stages;
    }

    /**
     * Get the nodeImageSelection property: The node image upgrade specs for the update run. It is only set in update
     * run when `NodeImageSelection.type` is `Consistent`.
     * 
     * @return the nodeImageSelection value.
     */
    public NodeImageSelectionStatus nodeImageSelection() {
        return this.nodeImageSelection;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (status() != null) {
            status().validate();
        }
        if (stages() != null) {
            stages().forEach(e -> e.validate());
        }
        if (nodeImageSelection() != null) {
            nodeImageSelection().validate();
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
     * Reads an instance of UpdateRunStatus from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of UpdateRunStatus if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the UpdateRunStatus.
     */
    public static UpdateRunStatus fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            UpdateRunStatus deserializedUpdateRunStatus = new UpdateRunStatus();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("status".equals(fieldName)) {
                    deserializedUpdateRunStatus.status = UpdateStatus.fromJson(reader);
                } else if ("stages".equals(fieldName)) {
                    List<UpdateStageStatus> stages = reader.readArray(reader1 -> UpdateStageStatus.fromJson(reader1));
                    deserializedUpdateRunStatus.stages = stages;
                } else if ("nodeImageSelection".equals(fieldName)) {
                    deserializedUpdateRunStatus.nodeImageSelection = NodeImageSelectionStatus.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedUpdateRunStatus;
        });
    }
}
