// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.monitor.opentelemetry.autoconfigure.implementation.quickpulse.swagger.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Request document type.
 */
@Fluent
public final class Request extends DocumentIngress {
    /*
     * Telemetry type. Types not defined in enum will get replaced with a 'Unknown' type.
     */
    @Generated
    private DocumentType documentType = DocumentType.REQUEST;

    /*
     * Name of the request, e.g., 'GET /values/{id}'.
     */
    @Generated
    private String name;

    /*
     * Request URL with all query string parameters.
     */
    @Generated
    private String url;

    /*
     * Result of a request execution. For http requests, it could be some HTTP status code.
     */
    @Generated
    private String responseCode;

    /*
     * Request duration in ISO 8601 duration format, i.e., P[n]Y[n]M[n]DT[n]H[n]M[n]S or P[n]W.
     */
    @Generated
    private String duration;

    /**
     * Creates an instance of Request class.
     */
    @Generated
    public Request() {
    }

    /**
     * Get the documentType property: Telemetry type. Types not defined in enum will get replaced with a 'Unknown' type.
     * 
     * @return the documentType value.
     */
    @Generated
    @Override
    public DocumentType getDocumentType() {
        return this.documentType;
    }

    /**
     * Get the name property: Name of the request, e.g., 'GET /values/{id}'.
     * 
     * @return the name value.
     */
    @Generated
    public String getName() {
        return this.name;
    }

    /**
     * Set the name property: Name of the request, e.g., 'GET /values/{id}'.
     * 
     * @param name the name value to set.
     * @return the Request object itself.
     */
    @Generated
    public Request setName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the url property: Request URL with all query string parameters.
     * 
     * @return the url value.
     */
    @Generated
    public String getUrl() {
        return this.url;
    }

    /**
     * Set the url property: Request URL with all query string parameters.
     * 
     * @param url the url value to set.
     * @return the Request object itself.
     */
    @Generated
    public Request setUrl(String url) {
        this.url = url;
        return this;
    }

    /**
     * Get the responseCode property: Result of a request execution. For http requests, it could be some HTTP status
     * code.
     * 
     * @return the responseCode value.
     */
    @Generated
    public String getResponseCode() {
        return this.responseCode;
    }

    /**
     * Set the responseCode property: Result of a request execution. For http requests, it could be some HTTP status
     * code.
     * 
     * @param responseCode the responseCode value to set.
     * @return the Request object itself.
     */
    @Generated
    public Request setResponseCode(String responseCode) {
        this.responseCode = responseCode;
        return this;
    }

    /**
     * Get the duration property: Request duration in ISO 8601 duration format, i.e., P[n]Y[n]M[n]DT[n]H[n]M[n]S or
     * P[n]W.
     * 
     * @return the duration value.
     */
    @Generated
    public String getDuration() {
        return this.duration;
    }

    /**
     * Set the duration property: Request duration in ISO 8601 duration format, i.e., P[n]Y[n]M[n]DT[n]H[n]M[n]S or
     * P[n]W.
     * 
     * @param duration the duration value to set.
     * @return the Request object itself.
     */
    @Generated
    public Request setDuration(String duration) {
        this.duration = duration;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Request setDocumentStreamIds(List<String> documentStreamIds) {
        super.setDocumentStreamIds(documentStreamIds);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public Request setProperties(List<KeyValuePairString> properties) {
        super.setProperties(properties);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("DocumentStreamIds", getDocumentStreamIds(),
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("Properties", getProperties(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("DocumentType", this.documentType == null ? null : this.documentType.toString());
        jsonWriter.writeStringField("Name", this.name);
        jsonWriter.writeStringField("Url", this.url);
        jsonWriter.writeStringField("ResponseCode", this.responseCode);
        jsonWriter.writeStringField("Duration", this.duration);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Request from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Request if the JsonReader was pointing to an instance of it, or null if it was pointing to
     * JSON null.
     * @throws IOException If an error occurs while reading the Request.
     */
    @Generated
    public static Request fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Request deserializedRequest = new Request();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("DocumentStreamIds".equals(fieldName)) {
                    List<String> documentStreamIds = reader.readArray(reader1 -> reader1.getString());
                    deserializedRequest.setDocumentStreamIds(documentStreamIds);
                } else if ("Properties".equals(fieldName)) {
                    List<KeyValuePairString> properties
                        = reader.readArray(reader1 -> KeyValuePairString.fromJson(reader1));
                    deserializedRequest.setProperties(properties);
                } else if ("DocumentType".equals(fieldName)) {
                    deserializedRequest.documentType = DocumentType.fromString(reader.getString());
                } else if ("Name".equals(fieldName)) {
                    deserializedRequest.name = reader.getString();
                } else if ("Url".equals(fieldName)) {
                    deserializedRequest.url = reader.getString();
                } else if ("ResponseCode".equals(fieldName)) {
                    deserializedRequest.responseCode = reader.getString();
                } else if ("Duration".equals(fieldName)) {
                    deserializedRequest.duration = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRequest;
        });
    }
}
