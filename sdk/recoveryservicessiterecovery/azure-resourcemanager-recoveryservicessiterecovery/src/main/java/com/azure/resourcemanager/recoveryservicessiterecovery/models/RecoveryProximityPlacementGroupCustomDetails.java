// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.recoveryservicessiterecovery.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Recovery Proximity placement group custom input.
 */
@Immutable
public class RecoveryProximityPlacementGroupCustomDetails
    implements JsonSerializable<RecoveryProximityPlacementGroupCustomDetails> {
    /*
     * The class type.
     */
    private String resourceType = "RecoveryProximityPlacementGroupCustomDetails";

    /**
     * Creates an instance of RecoveryProximityPlacementGroupCustomDetails class.
     */
    public RecoveryProximityPlacementGroupCustomDetails() {
    }

    /**
     * Get the resourceType property: The class type.
     * 
     * @return the resourceType value.
     */
    public String resourceType() {
        return this.resourceType;
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
        jsonWriter.writeStringField("resourceType", this.resourceType);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RecoveryProximityPlacementGroupCustomDetails from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RecoveryProximityPlacementGroupCustomDetails if the JsonReader was pointing to an instance
     * of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the RecoveryProximityPlacementGroupCustomDetails.
     */
    public static RecoveryProximityPlacementGroupCustomDetails fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("resourceType".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("Existing".equals(discriminatorValue)) {
                    return ExistingRecoveryProximityPlacementGroup.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static RecoveryProximityPlacementGroupCustomDetails fromJsonKnownDiscriminator(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            RecoveryProximityPlacementGroupCustomDetails deserializedRecoveryProximityPlacementGroupCustomDetails
                = new RecoveryProximityPlacementGroupCustomDetails();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceType".equals(fieldName)) {
                    deserializedRecoveryProximityPlacementGroupCustomDetails.resourceType = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRecoveryProximityPlacementGroupCustomDetails;
        });
    }
}
