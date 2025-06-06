// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.ai.agents.persistent.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Represents a message creation within a streaming run step delta.
 */
@Immutable
public final class RunStepDeltaMessageCreation extends RunStepDeltaDetail {

    /*
     * The object type for the run step detail object.
     */
    @Generated
    private String type = "message_creation";

    /*
     * The message creation data.
     */
    @Generated
    private RunStepDeltaMessageCreationObject messageCreation;

    /**
     * Creates an instance of RunStepDeltaMessageCreation class.
     */
    @Generated
    private RunStepDeltaMessageCreation() {
    }

    /**
     * Get the type property: The object type for the run step detail object.
     *
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the messageCreation property: The message creation data.
     *
     * @return the messageCreation value.
     */
    @Generated
    public RunStepDeltaMessageCreationObject getMessageCreation() {
        return this.messageCreation;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeJsonField("message_creation", this.messageCreation);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RunStepDeltaMessageCreation from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of RunStepDeltaMessageCreation if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RunStepDeltaMessageCreation.
     */
    @Generated
    public static RunStepDeltaMessageCreation fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RunStepDeltaMessageCreation deserializedRunStepDeltaMessageCreation = new RunStepDeltaMessageCreation();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("type".equals(fieldName)) {
                    deserializedRunStepDeltaMessageCreation.type = reader.getString();
                } else if ("message_creation".equals(fieldName)) {
                    deserializedRunStepDeltaMessageCreation.messageCreation
                        = RunStepDeltaMessageCreationObject.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedRunStepDeltaMessageCreation;
        });
    }
}
