// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.v2.security.keyvault.certificates.implementation.models;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * The certificate list result.
 */
@Metadata(properties = { MetadataProperties.IMMUTABLE })
public final class CertificateListResult implements JsonSerializable<CertificateListResult> {

    /*
     * A response message containing a list of certificates in the key vault along with a link to the next page of
     * certificates.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private List<CertificateItem> value;

    /*
     * The URL to get the next set of certificates.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private String nextLink;

    /**
     * Creates an instance of CertificateListResult class.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    private CertificateListResult() {
    }

    /**
     * Get the value property: A response message containing a list of certificates in the key vault along with a link
     * to the next page of certificates.
     *
     * @return the value value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public List<CertificateItem> getValue() {
        return this.value;
    }

    /**
     * Get the nextLink property: The URL to get the next set of certificates.
     *
     * @return the nextLink value.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public String getNextLink() {
        return this.nextLink;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of CertificateListResult from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of CertificateListResult if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the CertificateListResult.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static CertificateListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            CertificateListResult deserializedCertificateListResult = new CertificateListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("value".equals(fieldName)) {
                    List<CertificateItem> value = reader.readArray(reader1 -> CertificateItem.fromJson(reader1));
                    deserializedCertificateListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedCertificateListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }
            return deserializedCertificateListResult;
        });
    }
}
