// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mediaservices.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Specifies a configuration for PlayReady licenses.
 */
@Fluent
public final class ContentKeyPolicyPlayReadyConfiguration extends ContentKeyPolicyConfiguration {
    /*
     * The discriminator for derived types.
     */
    private String odataType = "#Microsoft.Media.ContentKeyPolicyPlayReadyConfiguration";

    /*
     * The PlayReady licenses.
     */
    private List<ContentKeyPolicyPlayReadyLicense> licenses;

    /*
     * The custom response data.
     */
    private String responseCustomData;

    /**
     * Creates an instance of ContentKeyPolicyPlayReadyConfiguration class.
     */
    public ContentKeyPolicyPlayReadyConfiguration() {
    }

    /**
     * Get the odataType property: The discriminator for derived types.
     * 
     * @return the odataType value.
     */
    @Override
    public String odataType() {
        return this.odataType;
    }

    /**
     * Get the licenses property: The PlayReady licenses.
     * 
     * @return the licenses value.
     */
    public List<ContentKeyPolicyPlayReadyLicense> licenses() {
        return this.licenses;
    }

    /**
     * Set the licenses property: The PlayReady licenses.
     * 
     * @param licenses the licenses value to set.
     * @return the ContentKeyPolicyPlayReadyConfiguration object itself.
     */
    public ContentKeyPolicyPlayReadyConfiguration withLicenses(List<ContentKeyPolicyPlayReadyLicense> licenses) {
        this.licenses = licenses;
        return this;
    }

    /**
     * Get the responseCustomData property: The custom response data.
     * 
     * @return the responseCustomData value.
     */
    public String responseCustomData() {
        return this.responseCustomData;
    }

    /**
     * Set the responseCustomData property: The custom response data.
     * 
     * @param responseCustomData the responseCustomData value to set.
     * @return the ContentKeyPolicyPlayReadyConfiguration object itself.
     */
    public ContentKeyPolicyPlayReadyConfiguration withResponseCustomData(String responseCustomData) {
        this.responseCustomData = responseCustomData;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (licenses() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property licenses in model ContentKeyPolicyPlayReadyConfiguration"));
        } else {
            licenses().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ContentKeyPolicyPlayReadyConfiguration.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("licenses", this.licenses, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("@odata.type", this.odataType);
        jsonWriter.writeStringField("responseCustomData", this.responseCustomData);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ContentKeyPolicyPlayReadyConfiguration from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ContentKeyPolicyPlayReadyConfiguration if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ContentKeyPolicyPlayReadyConfiguration.
     */
    public static ContentKeyPolicyPlayReadyConfiguration fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ContentKeyPolicyPlayReadyConfiguration deserializedContentKeyPolicyPlayReadyConfiguration
                = new ContentKeyPolicyPlayReadyConfiguration();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("licenses".equals(fieldName)) {
                    List<ContentKeyPolicyPlayReadyLicense> licenses
                        = reader.readArray(reader1 -> ContentKeyPolicyPlayReadyLicense.fromJson(reader1));
                    deserializedContentKeyPolicyPlayReadyConfiguration.licenses = licenses;
                } else if ("@odata.type".equals(fieldName)) {
                    deserializedContentKeyPolicyPlayReadyConfiguration.odataType = reader.getString();
                } else if ("responseCustomData".equals(fieldName)) {
                    deserializedContentKeyPolicyPlayReadyConfiguration.responseCustomData = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedContentKeyPolicyPlayReadyConfiguration;
        });
    }
}
