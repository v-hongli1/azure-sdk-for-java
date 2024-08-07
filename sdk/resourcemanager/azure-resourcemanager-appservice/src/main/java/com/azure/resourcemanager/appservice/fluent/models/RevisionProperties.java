// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appservice.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appservice.models.RevisionHealthState;
import com.azure.resourcemanager.appservice.models.RevisionProvisioningState;
import com.azure.resourcemanager.appservice.models.Template;
import java.io.IOException;
import java.time.OffsetDateTime;

/**
 * Revision resource specific properties.
 */
@Immutable
public final class RevisionProperties implements JsonSerializable<RevisionProperties> {
    /*
     * Timestamp describing when the revision was created
     * by controller
     */
    private OffsetDateTime createdTime;

    /*
     * Fully qualified domain name of the revision
     */
    private String fqdn;

    /*
     * Container App Revision Template with all possible settings and the
     * defaults if user did not provide them. The defaults are populated
     * as they were at the creation time
     */
    private Template template;

    /*
     * Boolean describing if the Revision is Active
     */
    private Boolean active;

    /*
     * Number of pods currently running for this revision
     */
    private Integer replicas;

    /*
     * Traffic weight assigned to this revision
     */
    private Integer trafficWeight;

    /*
     * Optional Field - Platform Error Message
     */
    private String provisioningError;

    /*
     * Current health State of the revision
     */
    private RevisionHealthState healthState;

    /*
     * Current provisioning State of the revision
     */
    private RevisionProvisioningState provisioningState;

    /**
     * Creates an instance of RevisionProperties class.
     */
    public RevisionProperties() {
    }

    /**
     * Get the createdTime property: Timestamp describing when the revision was created
     * by controller.
     * 
     * @return the createdTime value.
     */
    public OffsetDateTime createdTime() {
        return this.createdTime;
    }

    /**
     * Get the fqdn property: Fully qualified domain name of the revision.
     * 
     * @return the fqdn value.
     */
    public String fqdn() {
        return this.fqdn;
    }

    /**
     * Get the template property: Container App Revision Template with all possible settings and the
     * defaults if user did not provide them. The defaults are populated
     * as they were at the creation time.
     * 
     * @return the template value.
     */
    public Template template() {
        return this.template;
    }

    /**
     * Get the active property: Boolean describing if the Revision is Active.
     * 
     * @return the active value.
     */
    public Boolean active() {
        return this.active;
    }

    /**
     * Get the replicas property: Number of pods currently running for this revision.
     * 
     * @return the replicas value.
     */
    public Integer replicas() {
        return this.replicas;
    }

    /**
     * Get the trafficWeight property: Traffic weight assigned to this revision.
     * 
     * @return the trafficWeight value.
     */
    public Integer trafficWeight() {
        return this.trafficWeight;
    }

    /**
     * Get the provisioningError property: Optional Field - Platform Error Message.
     * 
     * @return the provisioningError value.
     */
    public String provisioningError() {
        return this.provisioningError;
    }

    /**
     * Get the healthState property: Current health State of the revision.
     * 
     * @return the healthState value.
     */
    public RevisionHealthState healthState() {
        return this.healthState;
    }

    /**
     * Get the provisioningState property: Current provisioning State of the revision.
     * 
     * @return the provisioningState value.
     */
    public RevisionProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (template() != null) {
            template().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RevisionProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RevisionProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the RevisionProperties.
     */
    public static RevisionProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RevisionProperties deserializedRevisionProperties = new RevisionProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("createdTime".equals(fieldName)) {
                    deserializedRevisionProperties.createdTime = reader
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString()));
                } else if ("fqdn".equals(fieldName)) {
                    deserializedRevisionProperties.fqdn = reader.getString();
                } else if ("template".equals(fieldName)) {
                    deserializedRevisionProperties.template = Template.fromJson(reader);
                } else if ("active".equals(fieldName)) {
                    deserializedRevisionProperties.active = reader.getNullable(JsonReader::getBoolean);
                } else if ("replicas".equals(fieldName)) {
                    deserializedRevisionProperties.replicas = reader.getNullable(JsonReader::getInt);
                } else if ("trafficWeight".equals(fieldName)) {
                    deserializedRevisionProperties.trafficWeight = reader.getNullable(JsonReader::getInt);
                } else if ("provisioningError".equals(fieldName)) {
                    deserializedRevisionProperties.provisioningError = reader.getString();
                } else if ("healthState".equals(fieldName)) {
                    deserializedRevisionProperties.healthState = RevisionHealthState.fromString(reader.getString());
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedRevisionProperties.provisioningState
                        = RevisionProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedRevisionProperties;
        });
    }
}
