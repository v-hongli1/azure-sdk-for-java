// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.newrelicobservability.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * List of all the New relic accounts for the given user.
 */
@Fluent
public final class AccountProperties implements JsonSerializable<AccountProperties> {
    /*
     * organization id
     */
    private String organizationId;

    /*
     * account id
     */
    private String accountId;

    /*
     * account name
     */
    private String accountName;

    /*
     * Region where New Relic account is present
     */
    private String region;

    /**
     * Creates an instance of AccountProperties class.
     */
    public AccountProperties() {
    }

    /**
     * Get the organizationId property: organization id.
     * 
     * @return the organizationId value.
     */
    public String organizationId() {
        return this.organizationId;
    }

    /**
     * Set the organizationId property: organization id.
     * 
     * @param organizationId the organizationId value to set.
     * @return the AccountProperties object itself.
     */
    public AccountProperties withOrganizationId(String organizationId) {
        this.organizationId = organizationId;
        return this;
    }

    /**
     * Get the accountId property: account id.
     * 
     * @return the accountId value.
     */
    public String accountId() {
        return this.accountId;
    }

    /**
     * Set the accountId property: account id.
     * 
     * @param accountId the accountId value to set.
     * @return the AccountProperties object itself.
     */
    public AccountProperties withAccountId(String accountId) {
        this.accountId = accountId;
        return this;
    }

    /**
     * Get the accountName property: account name.
     * 
     * @return the accountName value.
     */
    public String accountName() {
        return this.accountName;
    }

    /**
     * Set the accountName property: account name.
     * 
     * @param accountName the accountName value to set.
     * @return the AccountProperties object itself.
     */
    public AccountProperties withAccountName(String accountName) {
        this.accountName = accountName;
        return this;
    }

    /**
     * Get the region property: Region where New Relic account is present.
     * 
     * @return the region value.
     */
    public String region() {
        return this.region;
    }

    /**
     * Set the region property: Region where New Relic account is present.
     * 
     * @param region the region value to set.
     * @return the AccountProperties object itself.
     */
    public AccountProperties withRegion(String region) {
        this.region = region;
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
        jsonWriter.writeStringField("organizationId", this.organizationId);
        jsonWriter.writeStringField("accountId", this.accountId);
        jsonWriter.writeStringField("accountName", this.accountName);
        jsonWriter.writeStringField("region", this.region);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AccountProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AccountProperties if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the AccountProperties.
     */
    public static AccountProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AccountProperties deserializedAccountProperties = new AccountProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("organizationId".equals(fieldName)) {
                    deserializedAccountProperties.organizationId = reader.getString();
                } else if ("accountId".equals(fieldName)) {
                    deserializedAccountProperties.accountId = reader.getString();
                } else if ("accountName".equals(fieldName)) {
                    deserializedAccountProperties.accountName = reader.getString();
                } else if ("region".equals(fieldName)) {
                    deserializedAccountProperties.region = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAccountProperties;
        });
    }
}
