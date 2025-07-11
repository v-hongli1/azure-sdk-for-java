// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Profile of the managed cluster gateway agent pool.
 */
@Fluent
public final class AgentPoolGatewayProfile implements JsonSerializable<AgentPoolGatewayProfile> {
    /*
     * The Gateway agent pool associates one public IPPrefix for each static egress gateway to provide public egress.
     * The size of Public IPPrefix should be selected by the user. Each node in the agent pool is assigned with one IP
     * from the IPPrefix. The IPPrefix size thus serves as a cap on the size of the Gateway agent pool. Due to Azure
     * public IPPrefix size limitation, the valid value range is [28, 31] (/31 = 2 nodes/IPs, /30 = 4 nodes/IPs, /29 = 8
     * nodes/IPs, /28 = 16 nodes/IPs). The default value is 31.
     */
    private Integer publicIpPrefixSize;

    /**
     * Creates an instance of AgentPoolGatewayProfile class.
     */
    public AgentPoolGatewayProfile() {
    }

    /**
     * Get the publicIpPrefixSize property: The Gateway agent pool associates one public IPPrefix for each static egress
     * gateway to provide public egress. The size of Public IPPrefix should be selected by the user. Each node in the
     * agent pool is assigned with one IP from the IPPrefix. The IPPrefix size thus serves as a cap on the size of the
     * Gateway agent pool. Due to Azure public IPPrefix size limitation, the valid value range is [28, 31] (/31 = 2
     * nodes/IPs, /30 = 4 nodes/IPs, /29 = 8 nodes/IPs, /28 = 16 nodes/IPs). The default value is 31.
     * 
     * @return the publicIpPrefixSize value.
     */
    public Integer publicIpPrefixSize() {
        return this.publicIpPrefixSize;
    }

    /**
     * Set the publicIpPrefixSize property: The Gateway agent pool associates one public IPPrefix for each static egress
     * gateway to provide public egress. The size of Public IPPrefix should be selected by the user. Each node in the
     * agent pool is assigned with one IP from the IPPrefix. The IPPrefix size thus serves as a cap on the size of the
     * Gateway agent pool. Due to Azure public IPPrefix size limitation, the valid value range is [28, 31] (/31 = 2
     * nodes/IPs, /30 = 4 nodes/IPs, /29 = 8 nodes/IPs, /28 = 16 nodes/IPs). The default value is 31.
     * 
     * @param publicIpPrefixSize the publicIpPrefixSize value to set.
     * @return the AgentPoolGatewayProfile object itself.
     */
    public AgentPoolGatewayProfile withPublicIpPrefixSize(Integer publicIpPrefixSize) {
        this.publicIpPrefixSize = publicIpPrefixSize;
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
        jsonWriter.writeNumberField("publicIPPrefixSize", this.publicIpPrefixSize);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AgentPoolGatewayProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AgentPoolGatewayProfile if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AgentPoolGatewayProfile.
     */
    public static AgentPoolGatewayProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AgentPoolGatewayProfile deserializedAgentPoolGatewayProfile = new AgentPoolGatewayProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("publicIPPrefixSize".equals(fieldName)) {
                    deserializedAgentPoolGatewayProfile.publicIpPrefixSize = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAgentPoolGatewayProfile;
        });
    }
}
