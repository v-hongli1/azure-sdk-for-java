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
import java.util.List;

/**
 * List of p2s vpn connections to be disconnected.
 */
@Fluent
public final class P2SVpnConnectionRequest implements JsonSerializable<P2SVpnConnectionRequest> {
    /*
     * List of p2s vpn connection Ids.
     */
    private List<String> vpnConnectionIds;

    /**
     * Creates an instance of P2SVpnConnectionRequest class.
     */
    public P2SVpnConnectionRequest() {
    }

    /**
     * Get the vpnConnectionIds property: List of p2s vpn connection Ids.
     * 
     * @return the vpnConnectionIds value.
     */
    public List<String> vpnConnectionIds() {
        return this.vpnConnectionIds;
    }

    /**
     * Set the vpnConnectionIds property: List of p2s vpn connection Ids.
     * 
     * @param vpnConnectionIds the vpnConnectionIds value to set.
     * @return the P2SVpnConnectionRequest object itself.
     */
    public P2SVpnConnectionRequest withVpnConnectionIds(List<String> vpnConnectionIds) {
        this.vpnConnectionIds = vpnConnectionIds;
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
        jsonWriter.writeArrayField("vpnConnectionIds", this.vpnConnectionIds,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of P2SVpnConnectionRequest from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of P2SVpnConnectionRequest if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the P2SVpnConnectionRequest.
     */
    public static P2SVpnConnectionRequest fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            P2SVpnConnectionRequest deserializedP2SVpnConnectionRequest = new P2SVpnConnectionRequest();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("vpnConnectionIds".equals(fieldName)) {
                    List<String> vpnConnectionIds = reader.readArray(reader1 -> reader1.getString());
                    deserializedP2SVpnConnectionRequest.vpnConnectionIds = vpnConnectionIds;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedP2SVpnConnectionRequest;
        });
    }
}
