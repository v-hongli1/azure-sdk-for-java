// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.billingbenefits.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The RenewProperties model.
 */
@Fluent
public final class RenewProperties implements JsonSerializable<RenewProperties> {
    /*
     * The purchaseProperties property.
     */
    private PurchaseRequest purchaseProperties;

    /**
     * Creates an instance of RenewProperties class.
     */
    public RenewProperties() {
    }

    /**
     * Get the purchaseProperties property: The purchaseProperties property.
     * 
     * @return the purchaseProperties value.
     */
    public PurchaseRequest purchaseProperties() {
        return this.purchaseProperties;
    }

    /**
     * Set the purchaseProperties property: The purchaseProperties property.
     * 
     * @param purchaseProperties the purchaseProperties value to set.
     * @return the RenewProperties object itself.
     */
    public RenewProperties withPurchaseProperties(PurchaseRequest purchaseProperties) {
        this.purchaseProperties = purchaseProperties;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (purchaseProperties() != null) {
            purchaseProperties().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("purchaseProperties", this.purchaseProperties);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RenewProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RenewProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the RenewProperties.
     */
    public static RenewProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RenewProperties deserializedRenewProperties = new RenewProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("purchaseProperties".equals(fieldName)) {
                    deserializedRenewProperties.purchaseProperties = PurchaseRequest.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRenewProperties;
        });
    }
}
