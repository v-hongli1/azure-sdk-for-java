// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.messaging.eventgrid.systemevents;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Schema of the Data property of an EventGridEvent for a
 * Microsoft.ResourceNotifications.Resources.Deleted event.
 */
@Immutable
public final class ResourceNotificationsResourceManagementDeletedEventData
    extends ResourceNotificationsResourceDeletedEventData {

    /**
     * Creates an instance of ResourceNotificationsResourceManagementDeletedEventData class.
     *
     * @param resourceDetails the resourceDetails value to set.
     * @param operationalDetails the operationalDetails value to set.
     */
    @Generated
    private ResourceNotificationsResourceManagementDeletedEventData(
        ResourceNotificationsResourceDeletedDetails resourceDetails,
        ResourceNotificationsOperationalDetails operationalDetails) {
        super(resourceDetails, operationalDetails);
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("resourceInfo", getResourceDetails());
        jsonWriter.writeJsonField("operationalInfo", getOperationalDetails());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ResourceNotificationsResourceManagementDeletedEventData from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of ResourceNotificationsResourceManagementDeletedEventData if the JsonReader was pointing to
     * an instance of it, or null if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ResourceNotificationsResourceManagementDeletedEventData.
     */
    @Generated
    public static ResourceNotificationsResourceManagementDeletedEventData fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            ResourceNotificationsResourceDeletedDetails resourceDetails = null;
            ResourceNotificationsOperationalDetails operationalDetails = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();
                if ("resourceInfo".equals(fieldName)) {
                    resourceDetails = ResourceNotificationsResourceDeletedDetails.fromJson(reader);
                } else if ("operationalInfo".equals(fieldName)) {
                    operationalDetails = ResourceNotificationsOperationalDetails.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }
            return new ResourceNotificationsResourceManagementDeletedEventData(resourceDetails, operationalDetails);
        });
    }
}
