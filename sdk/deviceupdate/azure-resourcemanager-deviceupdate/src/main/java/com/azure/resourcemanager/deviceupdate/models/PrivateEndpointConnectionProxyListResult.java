// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.deviceupdate.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.deviceupdate.fluent.models.PrivateEndpointConnectionProxyInner;
import java.io.IOException;
import java.util.List;

/**
 * The available private endpoint connection proxies for an Account (not to be used by anyone, here because of ARM
 * requirements).
 */
@Fluent
public final class PrivateEndpointConnectionProxyListResult
    implements JsonSerializable<PrivateEndpointConnectionProxyListResult> {
    /*
     * The list of available private endpoint connection proxies for an Account
     */
    private List<PrivateEndpointConnectionProxyInner> value;

    /*
     * The URI that can be used to request the next list of private endpoint connection proxies.
     */
    private String nextLink;

    /**
     * Creates an instance of PrivateEndpointConnectionProxyListResult class.
     */
    public PrivateEndpointConnectionProxyListResult() {
    }

    /**
     * Get the value property: The list of available private endpoint connection proxies for an Account.
     * 
     * @return the value value.
     */
    public List<PrivateEndpointConnectionProxyInner> value() {
        return this.value;
    }

    /**
     * Set the value property: The list of available private endpoint connection proxies for an Account.
     * 
     * @param value the value value to set.
     * @return the PrivateEndpointConnectionProxyListResult object itself.
     */
    public PrivateEndpointConnectionProxyListResult withValue(List<PrivateEndpointConnectionProxyInner> value) {
        this.value = value;
        return this;
    }

    /**
     * Get the nextLink property: The URI that can be used to request the next list of private endpoint connection
     * proxies.
     * 
     * @return the nextLink value.
     */
    public String nextLink() {
        return this.nextLink;
    }

    /**
     * Set the nextLink property: The URI that can be used to request the next list of private endpoint connection
     * proxies.
     * 
     * @param nextLink the nextLink value to set.
     * @return the PrivateEndpointConnectionProxyListResult object itself.
     */
    public PrivateEndpointConnectionProxyListResult withNextLink(String nextLink) {
        this.nextLink = nextLink;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (value() != null) {
            value().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("value", this.value, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("nextLink", this.nextLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PrivateEndpointConnectionProxyListResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrivateEndpointConnectionProxyListResult if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the PrivateEndpointConnectionProxyListResult.
     */
    public static PrivateEndpointConnectionProxyListResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrivateEndpointConnectionProxyListResult deserializedPrivateEndpointConnectionProxyListResult
                = new PrivateEndpointConnectionProxyListResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("value".equals(fieldName)) {
                    List<PrivateEndpointConnectionProxyInner> value
                        = reader.readArray(reader1 -> PrivateEndpointConnectionProxyInner.fromJson(reader1));
                    deserializedPrivateEndpointConnectionProxyListResult.value = value;
                } else if ("nextLink".equals(fieldName)) {
                    deserializedPrivateEndpointConnectionProxyListResult.nextLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrivateEndpointConnectionProxyListResult;
        });
    }
}
