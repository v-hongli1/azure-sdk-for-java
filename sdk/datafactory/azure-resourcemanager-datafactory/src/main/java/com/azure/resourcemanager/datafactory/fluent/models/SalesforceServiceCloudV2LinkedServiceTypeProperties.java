// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.models.SecretBase;
import java.io.IOException;

/**
 * Salesforce Service Cloud V2 linked service properties.
 */
@Fluent
public final class SalesforceServiceCloudV2LinkedServiceTypeProperties
    implements JsonSerializable<SalesforceServiceCloudV2LinkedServiceTypeProperties> {
    /*
     * The URL of Salesforce Service Cloud instance. For example, 'https://[domain].my.salesforce.com'. Type: string (or
     * Expression with resultType string).
     */
    private Object environmentUrl;

    /*
     * The authentication type to be used to connect to the Salesforce. Currently, we only support
     * OAuth2ClientCredentials, it is also the default value
     */
    private Object authenticationType;

    /*
     * The client Id for OAuth 2.0 Client Credentials Flow authentication of the Salesforce instance. Type: string (or
     * Expression with resultType string).
     */
    private Object clientId;

    /*
     * The client secret for OAuth 2.0 Client Credentials Flow authentication of the Salesforce instance.
     */
    private SecretBase clientSecret;

    /*
     * The Salesforce API version used in ADF. The version must be larger than or equal to 47.0 which is required by
     * Salesforce BULK API 2.0. Type: string (or Expression with resultType string).
     */
    private Object apiVersion;

    /*
     * The encrypted credential used for authentication. Credentials are encrypted using the integration runtime
     * credential manager. Type: string.
     */
    private String encryptedCredential;

    /**
     * Creates an instance of SalesforceServiceCloudV2LinkedServiceTypeProperties class.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties() {
    }

    /**
     * Get the environmentUrl property: The URL of Salesforce Service Cloud instance. For example,
     * 'https://[domain].my.salesforce.com'. Type: string (or Expression with resultType string).
     * 
     * @return the environmentUrl value.
     */
    public Object environmentUrl() {
        return this.environmentUrl;
    }

    /**
     * Set the environmentUrl property: The URL of Salesforce Service Cloud instance. For example,
     * 'https://[domain].my.salesforce.com'. Type: string (or Expression with resultType string).
     * 
     * @param environmentUrl the environmentUrl value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withEnvironmentUrl(Object environmentUrl) {
        this.environmentUrl = environmentUrl;
        return this;
    }

    /**
     * Get the authenticationType property: The authentication type to be used to connect to the Salesforce. Currently,
     * we only support OAuth2ClientCredentials, it is also the default value.
     * 
     * @return the authenticationType value.
     */
    public Object authenticationType() {
        return this.authenticationType;
    }

    /**
     * Set the authenticationType property: The authentication type to be used to connect to the Salesforce. Currently,
     * we only support OAuth2ClientCredentials, it is also the default value.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withAuthenticationType(Object authenticationType) {
        this.authenticationType = authenticationType;
        return this;
    }

    /**
     * Get the clientId property: The client Id for OAuth 2.0 Client Credentials Flow authentication of the Salesforce
     * instance. Type: string (or Expression with resultType string).
     * 
     * @return the clientId value.
     */
    public Object clientId() {
        return this.clientId;
    }

    /**
     * Set the clientId property: The client Id for OAuth 2.0 Client Credentials Flow authentication of the Salesforce
     * instance. Type: string (or Expression with resultType string).
     * 
     * @param clientId the clientId value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withClientId(Object clientId) {
        this.clientId = clientId;
        return this;
    }

    /**
     * Get the clientSecret property: The client secret for OAuth 2.0 Client Credentials Flow authentication of the
     * Salesforce instance.
     * 
     * @return the clientSecret value.
     */
    public SecretBase clientSecret() {
        return this.clientSecret;
    }

    /**
     * Set the clientSecret property: The client secret for OAuth 2.0 Client Credentials Flow authentication of the
     * Salesforce instance.
     * 
     * @param clientSecret the clientSecret value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withClientSecret(SecretBase clientSecret) {
        this.clientSecret = clientSecret;
        return this;
    }

    /**
     * Get the apiVersion property: The Salesforce API version used in ADF. The version must be larger than or equal to
     * 47.0 which is required by Salesforce BULK API 2.0. Type: string (or Expression with resultType string).
     * 
     * @return the apiVersion value.
     */
    public Object apiVersion() {
        return this.apiVersion;
    }

    /**
     * Set the apiVersion property: The Salesforce API version used in ADF. The version must be larger than or equal to
     * 47.0 which is required by Salesforce BULK API 2.0. Type: string (or Expression with resultType string).
     * 
     * @param apiVersion the apiVersion value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withApiVersion(Object apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @return the encryptedCredential value.
     */
    public String encryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the SalesforceServiceCloudV2LinkedServiceTypeProperties object itself.
     */
    public SalesforceServiceCloudV2LinkedServiceTypeProperties withEncryptedCredential(String encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (clientSecret() != null) {
            clientSecret().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        if (this.environmentUrl != null) {
            jsonWriter.writeUntypedField("environmentUrl", this.environmentUrl);
        }
        if (this.authenticationType != null) {
            jsonWriter.writeUntypedField("authenticationType", this.authenticationType);
        }
        if (this.clientId != null) {
            jsonWriter.writeUntypedField("clientId", this.clientId);
        }
        jsonWriter.writeJsonField("clientSecret", this.clientSecret);
        if (this.apiVersion != null) {
            jsonWriter.writeUntypedField("apiVersion", this.apiVersion);
        }
        jsonWriter.writeStringField("encryptedCredential", this.encryptedCredential);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SalesforceServiceCloudV2LinkedServiceTypeProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SalesforceServiceCloudV2LinkedServiceTypeProperties if the JsonReader was pointing to an
     * instance of it, or null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SalesforceServiceCloudV2LinkedServiceTypeProperties.
     */
    public static SalesforceServiceCloudV2LinkedServiceTypeProperties fromJson(JsonReader jsonReader)
        throws IOException {
        return jsonReader.readObject(reader -> {
            SalesforceServiceCloudV2LinkedServiceTypeProperties deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties
                = new SalesforceServiceCloudV2LinkedServiceTypeProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("environmentUrl".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.environmentUrl
                        = reader.readUntyped();
                } else if ("authenticationType".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.authenticationType
                        = reader.readUntyped();
                } else if ("clientId".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.clientId = reader.readUntyped();
                } else if ("clientSecret".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.clientSecret
                        = SecretBase.fromJson(reader);
                } else if ("apiVersion".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.apiVersion = reader.readUntyped();
                } else if ("encryptedCredential".equals(fieldName)) {
                    deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties.encryptedCredential
                        = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSalesforceServiceCloudV2LinkedServiceTypeProperties;
        });
    }
}
