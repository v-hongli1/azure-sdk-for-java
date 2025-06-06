// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.eventgrid.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Properties of an event published to an Event Grid topic using the CloudEvent 1.0 Schema.
 */
@Fluent
public final class CloudEvent implements JsonSerializable<CloudEvent> {
    /*
     * An identifier for the event. The combination of id and source must be unique for each distinct event.
     */
    @Generated
    private String id;

    /*
     * Identifies the context in which an event happened. The combination of id and source must be unique for each
     * distinct event.
     */
    @Generated
    private String source;

    /*
     * Event data specific to the event type.
     */
    @Generated
    private Object data;

    /*
     * Event data specific to the event type, encoded as a base64 string.
     */
    @Generated
    private byte[] dataBase64;

    /*
     * Type of event related to the originating occurrence.
     */
    @Generated
    private String type;

    /*
     * The time (in UTC) the event was generated, in RFC3339 format.
     */
    @Generated
    private OffsetDateTime time;

    /*
     * The version of the CloudEvents specification which the event uses.
     */
    @Generated
    private String specversion;

    /*
     * Identifies the schema that data adheres to.
     */
    @Generated
    private String dataschema;

    /*
     * Content type of data value.
     */
    @Generated
    private String datacontenttype;

    /*
     * This describes the subject of the event in the context of the event producer (identified by source).
     */
    @Generated
    private String subject;

    /*
     * Properties of an event published to an Event Grid topic using the CloudEvent 1.0 Schema
     */
    @Generated
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of CloudEvent class.
     */
    @Generated
    public CloudEvent() {
    }

    /**
     * Get the id property: An identifier for the event. The combination of id and source must be unique for each
     * distinct event.
     * 
     * @return the id value.
     */
    @Generated
    public String getId() {
        return this.id;
    }

    /**
     * Set the id property: An identifier for the event. The combination of id and source must be unique for each
     * distinct event.
     * 
     * @param id the id value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setId(String id) {
        this.id = id;
        return this;
    }

    /**
     * Get the source property: Identifies the context in which an event happened. The combination of id and source must
     * be unique for each distinct event.
     * 
     * @return the source value.
     */
    @Generated
    public String getSource() {
        return this.source;
    }

    /**
     * Set the source property: Identifies the context in which an event happened. The combination of id and source must
     * be unique for each distinct event.
     * 
     * @param source the source value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setSource(String source) {
        this.source = source;
        return this;
    }

    /**
     * Get the data property: Event data specific to the event type.
     * 
     * @return the data value.
     */
    @Generated
    public Object getData() {
        return this.data;
    }

    /**
     * Set the data property: Event data specific to the event type.
     * 
     * @param data the data value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setData(Object data) {
        this.data = data;
        return this;
    }

    /**
     * Get the dataBase64 property: Event data specific to the event type, encoded as a base64 string.
     * 
     * @return the dataBase64 value.
     */
    @Generated
    public byte[] getDataBase64() {
        return CoreUtils.clone(this.dataBase64);
    }

    /**
     * Set the dataBase64 property: Event data specific to the event type, encoded as a base64 string.
     * 
     * @param dataBase64 the dataBase64 value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setDataBase64(byte[] dataBase64) {
        this.dataBase64 = CoreUtils.clone(dataBase64);
        return this;
    }

    /**
     * Get the type property: Type of event related to the originating occurrence.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    /**
     * Set the type property: Type of event related to the originating occurrence.
     * 
     * @param type the type value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setType(String type) {
        this.type = type;
        return this;
    }

    /**
     * Get the time property: The time (in UTC) the event was generated, in RFC3339 format.
     * 
     * @return the time value.
     */
    @Generated
    public OffsetDateTime getTime() {
        return this.time;
    }

    /**
     * Set the time property: The time (in UTC) the event was generated, in RFC3339 format.
     * 
     * @param time the time value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setTime(OffsetDateTime time) {
        this.time = time;
        return this;
    }

    /**
     * Get the specversion property: The version of the CloudEvents specification which the event uses.
     * 
     * @return the specversion value.
     */
    @Generated
    public String getSpecversion() {
        return this.specversion;
    }

    /**
     * Set the specversion property: The version of the CloudEvents specification which the event uses.
     * 
     * @param specversion the specversion value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setSpecversion(String specversion) {
        this.specversion = specversion;
        return this;
    }

    /**
     * Get the dataschema property: Identifies the schema that data adheres to.
     * 
     * @return the dataschema value.
     */
    @Generated
    public String getDataschema() {
        return this.dataschema;
    }

    /**
     * Set the dataschema property: Identifies the schema that data adheres to.
     * 
     * @param dataschema the dataschema value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setDataschema(String dataschema) {
        this.dataschema = dataschema;
        return this;
    }

    /**
     * Get the datacontenttype property: Content type of data value.
     * 
     * @return the datacontenttype value.
     */
    @Generated
    public String getDatacontenttype() {
        return this.datacontenttype;
    }

    /**
     * Set the datacontenttype property: Content type of data value.
     * 
     * @param datacontenttype the datacontenttype value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setDatacontenttype(String datacontenttype) {
        this.datacontenttype = datacontenttype;
        return this;
    }

    /**
     * Get the subject property: This describes the subject of the event in the context of the event producer
     * (identified by source).
     * 
     * @return the subject value.
     */
    @Generated
    public String getSubject() {
        return this.subject;
    }

    /**
     * Set the subject property: This describes the subject of the event in the context of the event producer
     * (identified by source).
     * 
     * @param subject the subject value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setSubject(String subject) {
        this.subject = subject;
        return this;
    }

    /**
     * Get the additionalProperties property: Properties of an event published to an Event Grid topic using the
     * CloudEvent 1.0 Schema.
     * 
     * @return the additionalProperties value.
     */
    @Generated
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: Properties of an event published to an Event Grid topic using the
     * CloudEvent 1.0 Schema.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the CloudEvent object itself.
     */
    @Generated
    public CloudEvent setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", this.id);
        jsonWriter.writeStringField("source", this.source);
        jsonWriter.writeStringField("type", this.type);
        jsonWriter.writeStringField("specversion", this.specversion);
        if (this.data != null) {
            jsonWriter.writeUntypedField("data", this.data);
        }
        jsonWriter.writeBinaryField("data_base64", this.dataBase64);
        jsonWriter.writeStringField("time",
            this.time == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.time));
        jsonWriter.writeStringField("dataschema", this.dataschema);
        jsonWriter.writeStringField("datacontenttype", this.datacontenttype);
        jsonWriter.writeStringField("subject", this.subject);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CloudEvent from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of CloudEvent if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the CloudEvent.
     */
    @Generated
    public static CloudEvent fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CloudEvent deserializedCloudEvent = new CloudEvent();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedCloudEvent.id = reader.getString();
                } else if ("source".equals(fieldName)) {
                    deserializedCloudEvent.source = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedCloudEvent.type = reader.getString();
                } else if ("specversion".equals(fieldName)) {
                    deserializedCloudEvent.specversion = reader.getString();
                } else if ("data".equals(fieldName)) {
                    deserializedCloudEvent.data = reader.readUntyped();
                } else if ("data_base64".equals(fieldName)) {
                    deserializedCloudEvent.dataBase64 = reader.getBinary();
                } else if ("time".equals(fieldName)) {
                    deserializedCloudEvent.time = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("dataschema".equals(fieldName)) {
                    deserializedCloudEvent.dataschema = reader.getString();
                } else if ("datacontenttype".equals(fieldName)) {
                    deserializedCloudEvent.datacontenttype = reader.getString();
                } else if ("subject".equals(fieldName)) {
                    deserializedCloudEvent.subject = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedCloudEvent.additionalProperties = additionalProperties;

            return deserializedCloudEvent;
        });
    }
}
