// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.managednetworkfabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * IP Extended Community set operation properties.
 */
@Fluent
public class IpExtendedCommunitySetOperationProperties
    implements JsonSerializable<IpExtendedCommunitySetOperationProperties> {
    /*
     * List of IP Extended Community IDs.
     */
    private IpExtendedCommunityIdList set;

    /**
     * Creates an instance of IpExtendedCommunitySetOperationProperties class.
     */
    public IpExtendedCommunitySetOperationProperties() {
    }

    /**
     * Get the set property: List of IP Extended Community IDs.
     * 
     * @return the set value.
     */
    public IpExtendedCommunityIdList set() {
        return this.set;
    }

    /**
     * Set the set property: List of IP Extended Community IDs.
     * 
     * @param set the set value to set.
     * @return the IpExtendedCommunitySetOperationProperties object itself.
     */
    public IpExtendedCommunitySetOperationProperties withSet(IpExtendedCommunityIdList set) {
        this.set = set;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (set() != null) {
            set().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("set", this.set);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IpExtendedCommunitySetOperationProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IpExtendedCommunitySetOperationProperties if the JsonReader was pointing to an instance of
     * it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the IpExtendedCommunitySetOperationProperties.
     */
    public static IpExtendedCommunitySetOperationProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IpExtendedCommunitySetOperationProperties deserializedIpExtendedCommunitySetOperationProperties
                = new IpExtendedCommunitySetOperationProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("set".equals(fieldName)) {
                    deserializedIpExtendedCommunitySetOperationProperties.set
                        = IpExtendedCommunityIdList.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIpExtendedCommunitySetOperationProperties;
        });
    }
}
