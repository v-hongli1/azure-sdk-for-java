// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.hybridcontainerservice.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Profile of the HA Proxy load balancer.
 */
@Fluent
public final class NetworkProfileLoadBalancerProfile implements JsonSerializable<NetworkProfileLoadBalancerProfile> {
    /*
     * Number of HA Proxy load balancer VMs. The default value is 0.
     */
    private Integer count;

    /**
     * Creates an instance of NetworkProfileLoadBalancerProfile class.
     */
    public NetworkProfileLoadBalancerProfile() {
    }

    /**
     * Get the count property: Number of HA Proxy load balancer VMs. The default value is 0.
     * 
     * @return the count value.
     */
    public Integer count() {
        return this.count;
    }

    /**
     * Set the count property: Number of HA Proxy load balancer VMs. The default value is 0.
     * 
     * @param count the count value to set.
     * @return the NetworkProfileLoadBalancerProfile object itself.
     */
    public NetworkProfileLoadBalancerProfile withCount(Integer count) {
        this.count = count;
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
        jsonWriter.writeNumberField("count", this.count);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NetworkProfileLoadBalancerProfile from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NetworkProfileLoadBalancerProfile if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NetworkProfileLoadBalancerProfile.
     */
    public static NetworkProfileLoadBalancerProfile fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NetworkProfileLoadBalancerProfile deserializedNetworkProfileLoadBalancerProfile
                = new NetworkProfileLoadBalancerProfile();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("count".equals(fieldName)) {
                    deserializedNetworkProfileLoadBalancerProfile.count = reader.getNullable(JsonReader::getInt);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNetworkProfileLoadBalancerProfile;
        });
    }
}
