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
import java.util.List;

/**
 * IP Community ID list properties.
 */
@Fluent
public class IpCommunityIdList implements JsonSerializable<IpCommunityIdList> {
    /*
     * List of IP Community resource IDs.
     */
    private List<String> ipCommunityIds;

    /**
     * Creates an instance of IpCommunityIdList class.
     */
    public IpCommunityIdList() {
    }

    /**
     * Get the ipCommunityIds property: List of IP Community resource IDs.
     * 
     * @return the ipCommunityIds value.
     */
    public List<String> ipCommunityIds() {
        return this.ipCommunityIds;
    }

    /**
     * Set the ipCommunityIds property: List of IP Community resource IDs.
     * 
     * @param ipCommunityIds the ipCommunityIds value to set.
     * @return the IpCommunityIdList object itself.
     */
    public IpCommunityIdList withIpCommunityIds(List<String> ipCommunityIds) {
        this.ipCommunityIds = ipCommunityIds;
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
        jsonWriter.writeArrayField("ipCommunityIds", this.ipCommunityIds,
            (writer, element) -> writer.writeString(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of IpCommunityIdList from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of IpCommunityIdList if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the IpCommunityIdList.
     */
    public static IpCommunityIdList fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            IpCommunityIdList deserializedIpCommunityIdList = new IpCommunityIdList();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("ipCommunityIds".equals(fieldName)) {
                    List<String> ipCommunityIds = reader.readArray(reader1 -> reader1.getString());
                    deserializedIpCommunityIdList.ipCommunityIds = ipCommunityIds;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedIpCommunityIdList;
        });
    }
}
