// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * The format definition of a storage.
 */
@Fluent
public class DatasetStorageFormat implements JsonSerializable<DatasetStorageFormat> {
    /*
     * Type of dataset storage format.
     */
    private String type = "DatasetStorageFormat";

    /*
     * Serializer. Type: string (or Expression with resultType string).
     */
    private Object serializer;

    /*
     * Deserializer. Type: string (or Expression with resultType string).
     */
    private Object deserializer;

    /*
     * The format definition of a storage.
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of DatasetStorageFormat class.
     */
    public DatasetStorageFormat() {
    }

    /**
     * Get the type property: Type of dataset storage format.
     * 
     * @return the type value.
     */
    public String getType() {
        return this.type;
    }

    /**
     * Get the serializer property: Serializer. Type: string (or Expression with resultType string).
     * 
     * @return the serializer value.
     */
    public Object getSerializer() {
        return this.serializer;
    }

    /**
     * Set the serializer property: Serializer. Type: string (or Expression with resultType string).
     * 
     * @param serializer the serializer value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat setSerializer(Object serializer) {
        this.serializer = serializer;
        return this;
    }

    /**
     * Get the deserializer property: Deserializer. Type: string (or Expression with resultType string).
     * 
     * @return the deserializer value.
     */
    public Object getDeserializer() {
        return this.deserializer;
    }

    /**
     * Set the deserializer property: Deserializer. Type: string (or Expression with resultType string).
     * 
     * @param deserializer the deserializer value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat setDeserializer(Object deserializer) {
        this.deserializer = deserializer;
        return this;
    }

    /**
     * Get the additionalProperties property: The format definition of a storage.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: The format definition of a storage.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the DatasetStorageFormat object itself.
     */
    public DatasetStorageFormat setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeUntypedField("serializer", this.serializer);
        jsonWriter.writeUntypedField("deserializer", this.deserializer);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DatasetStorageFormat from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DatasetStorageFormat if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DatasetStorageFormat.
     */
    public static DatasetStorageFormat fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("TextFormat".equals(discriminatorValue)) {
                    return TextFormat.fromJson(readerToUse.reset());
                } else if ("JsonFormat".equals(discriminatorValue)) {
                    return JsonFormat.fromJson(readerToUse.reset());
                } else if ("AvroFormat".equals(discriminatorValue)) {
                    return AvroFormat.fromJson(readerToUse.reset());
                } else if ("OrcFormat".equals(discriminatorValue)) {
                    return OrcFormat.fromJson(readerToUse.reset());
                } else if ("ParquetFormat".equals(discriminatorValue)) {
                    return ParquetFormat.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    static DatasetStorageFormat fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DatasetStorageFormat deserializedDatasetStorageFormat = new DatasetStorageFormat();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedDatasetStorageFormat.type = reader.getString();
                } else if ("serializer".equals(fieldName)) {
                    deserializedDatasetStorageFormat.serializer = reader.readUntyped();
                } else if ("deserializer".equals(fieldName)) {
                    deserializedDatasetStorageFormat.deserializer = reader.readUntyped();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedDatasetStorageFormat.additionalProperties = additionalProperties;

            return deserializedDatasetStorageFormat;
        });
    }
}
