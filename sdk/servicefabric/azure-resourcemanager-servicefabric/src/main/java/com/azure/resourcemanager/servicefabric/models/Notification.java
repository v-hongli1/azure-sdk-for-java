// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.servicefabric.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * Describes the notification channel for cluster events.
 */
@Fluent
public final class Notification implements JsonSerializable<Notification> {
    /*
     * Indicates if the notification is enabled.
     */
    private boolean isEnabled;

    /*
     * The category of notification.
     */
    private NotificationCategory notificationCategory;

    /*
     * The level of notification.
     */
    private NotificationLevel notificationLevel;

    /*
     * List of targets that subscribe to the notification.
     */
    private List<NotificationTarget> notificationTargets;

    /**
     * Creates an instance of Notification class.
     */
    public Notification() {
    }

    /**
     * Get the isEnabled property: Indicates if the notification is enabled.
     * 
     * @return the isEnabled value.
     */
    public boolean isEnabled() {
        return this.isEnabled;
    }

    /**
     * Set the isEnabled property: Indicates if the notification is enabled.
     * 
     * @param isEnabled the isEnabled value to set.
     * @return the Notification object itself.
     */
    public Notification withIsEnabled(boolean isEnabled) {
        this.isEnabled = isEnabled;
        return this;
    }

    /**
     * Get the notificationCategory property: The category of notification.
     * 
     * @return the notificationCategory value.
     */
    public NotificationCategory notificationCategory() {
        return this.notificationCategory;
    }

    /**
     * Set the notificationCategory property: The category of notification.
     * 
     * @param notificationCategory the notificationCategory value to set.
     * @return the Notification object itself.
     */
    public Notification withNotificationCategory(NotificationCategory notificationCategory) {
        this.notificationCategory = notificationCategory;
        return this;
    }

    /**
     * Get the notificationLevel property: The level of notification.
     * 
     * @return the notificationLevel value.
     */
    public NotificationLevel notificationLevel() {
        return this.notificationLevel;
    }

    /**
     * Set the notificationLevel property: The level of notification.
     * 
     * @param notificationLevel the notificationLevel value to set.
     * @return the Notification object itself.
     */
    public Notification withNotificationLevel(NotificationLevel notificationLevel) {
        this.notificationLevel = notificationLevel;
        return this;
    }

    /**
     * Get the notificationTargets property: List of targets that subscribe to the notification.
     * 
     * @return the notificationTargets value.
     */
    public List<NotificationTarget> notificationTargets() {
        return this.notificationTargets;
    }

    /**
     * Set the notificationTargets property: List of targets that subscribe to the notification.
     * 
     * @param notificationTargets the notificationTargets value to set.
     * @return the Notification object itself.
     */
    public Notification withNotificationTargets(List<NotificationTarget> notificationTargets) {
        this.notificationTargets = notificationTargets;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (notificationCategory() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property notificationCategory in model Notification"));
        }
        if (notificationLevel() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property notificationLevel in model Notification"));
        }
        if (notificationTargets() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property notificationTargets in model Notification"));
        } else {
            notificationTargets().forEach(e -> e.validate());
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(Notification.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeBooleanField("isEnabled", this.isEnabled);
        jsonWriter.writeStringField("notificationCategory",
            this.notificationCategory == null ? null : this.notificationCategory.toString());
        jsonWriter.writeStringField("notificationLevel",
            this.notificationLevel == null ? null : this.notificationLevel.toString());
        jsonWriter.writeArrayField("notificationTargets", this.notificationTargets,
            (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of Notification from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of Notification if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the Notification.
     */
    public static Notification fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            Notification deserializedNotification = new Notification();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("isEnabled".equals(fieldName)) {
                    deserializedNotification.isEnabled = reader.getBoolean();
                } else if ("notificationCategory".equals(fieldName)) {
                    deserializedNotification.notificationCategory = NotificationCategory.fromString(reader.getString());
                } else if ("notificationLevel".equals(fieldName)) {
                    deserializedNotification.notificationLevel = NotificationLevel.fromString(reader.getString());
                } else if ("notificationTargets".equals(fieldName)) {
                    List<NotificationTarget> notificationTargets
                        = reader.readArray(reader1 -> NotificationTarget.fromJson(reader1));
                    deserializedNotification.notificationTargets = notificationTargets;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNotification;
        });
    }
}
