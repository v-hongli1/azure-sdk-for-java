// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * SKU of a public IP address.
 */
@Fluent
public final class PublicIpAddressSku implements JsonSerializable<PublicIpAddressSku> {
    /*
     * Name of a public IP address SKU.
     */
    private PublicIpAddressSkuName name;

    /*
     * Tier of a public IP address SKU.
     */
    private PublicIpAddressSkuTier tier;

    /**
     * Creates an instance of PublicIpAddressSku class.
     */
    public PublicIpAddressSku() {
    }

    /**
     * Get the name property: Name of a public IP address SKU.
     * 
     * @return the name value.
     */
    public PublicIpAddressSkuName name() {
        return this.name;
    }

    /**
     * Set the name property: Name of a public IP address SKU.
     * 
     * @param name the name value to set.
     * @return the PublicIpAddressSku object itself.
     */
    public PublicIpAddressSku withName(PublicIpAddressSkuName name) {
        this.name = name;
        return this;
    }

    /**
     * Get the tier property: Tier of a public IP address SKU.
     * 
     * @return the tier value.
     */
    public PublicIpAddressSkuTier tier() {
        return this.tier;
    }

    /**
     * Set the tier property: Tier of a public IP address SKU.
     * 
     * @param tier the tier value to set.
     * @return the PublicIpAddressSku object itself.
     */
    public PublicIpAddressSku withTier(PublicIpAddressSkuTier tier) {
        this.tier = tier;
        return this;
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
        jsonWriter.writeStringField("name", this.name == null ? null : this.name.toString());
        jsonWriter.writeStringField("tier", this.tier == null ? null : this.tier.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PublicIpAddressSku from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PublicIpAddressSku if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the PublicIpAddressSku.
     */
    public static PublicIpAddressSku fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PublicIpAddressSku deserializedPublicIpAddressSku = new PublicIpAddressSku();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedPublicIpAddressSku.name = PublicIpAddressSkuName.fromString(reader.getString());
                } else if ("tier".equals(fieldName)) {
                    deserializedPublicIpAddressSku.tier = PublicIpAddressSkuTier.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPublicIpAddressSku;
        });
    }
}
