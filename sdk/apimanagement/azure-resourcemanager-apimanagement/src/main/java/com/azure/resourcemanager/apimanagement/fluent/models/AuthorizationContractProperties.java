// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.apimanagement.models.AuthorizationError;
import com.azure.resourcemanager.apimanagement.models.AuthorizationType;
import com.azure.resourcemanager.apimanagement.models.OAuth2GrantType;
import java.io.IOException;
import java.util.Map;

/**
 * Authorization details.
 */
@Fluent
public final class AuthorizationContractProperties implements JsonSerializable<AuthorizationContractProperties> {
    /*
     * Authorization type options
     */
    private AuthorizationType authorizationType;

    /*
     * OAuth2 grant type options
     */
    private OAuth2GrantType oAuth2GrantType;

    /*
     * Authorization parameters
     */
    private Map<String, String> parameters;

    /*
     * Authorization error details.
     */
    private AuthorizationError error;

    /*
     * Status of the Authorization
     */
    private String status;

    /**
     * Creates an instance of AuthorizationContractProperties class.
     */
    public AuthorizationContractProperties() {
    }

    /**
     * Get the authorizationType property: Authorization type options.
     * 
     * @return the authorizationType value.
     */
    public AuthorizationType authorizationType() {
        return this.authorizationType;
    }

    /**
     * Set the authorizationType property: Authorization type options.
     * 
     * @param authorizationType the authorizationType value to set.
     * @return the AuthorizationContractProperties object itself.
     */
    public AuthorizationContractProperties withAuthorizationType(AuthorizationType authorizationType) {
        this.authorizationType = authorizationType;
        return this;
    }

    /**
     * Get the oAuth2GrantType property: OAuth2 grant type options.
     * 
     * @return the oAuth2GrantType value.
     */
    public OAuth2GrantType oAuth2GrantType() {
        return this.oAuth2GrantType;
    }

    /**
     * Set the oAuth2GrantType property: OAuth2 grant type options.
     * 
     * @param oAuth2GrantType the oAuth2GrantType value to set.
     * @return the AuthorizationContractProperties object itself.
     */
    public AuthorizationContractProperties withOAuth2GrantType(OAuth2GrantType oAuth2GrantType) {
        this.oAuth2GrantType = oAuth2GrantType;
        return this;
    }

    /**
     * Get the parameters property: Authorization parameters.
     * 
     * @return the parameters value.
     */
    public Map<String, String> parameters() {
        return this.parameters;
    }

    /**
     * Set the parameters property: Authorization parameters.
     * 
     * @param parameters the parameters value to set.
     * @return the AuthorizationContractProperties object itself.
     */
    public AuthorizationContractProperties withParameters(Map<String, String> parameters) {
        this.parameters = parameters;
        return this;
    }

    /**
     * Get the error property: Authorization error details.
     * 
     * @return the error value.
     */
    public AuthorizationError error() {
        return this.error;
    }

    /**
     * Set the error property: Authorization error details.
     * 
     * @param error the error value to set.
     * @return the AuthorizationContractProperties object itself.
     */
    public AuthorizationContractProperties withError(AuthorizationError error) {
        this.error = error;
        return this;
    }

    /**
     * Get the status property: Status of the Authorization.
     * 
     * @return the status value.
     */
    public String status() {
        return this.status;
    }

    /**
     * Set the status property: Status of the Authorization.
     * 
     * @param status the status value to set.
     * @return the AuthorizationContractProperties object itself.
     */
    public AuthorizationContractProperties withStatus(String status) {
        this.status = status;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (error() != null) {
            error().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("authorizationType",
            this.authorizationType == null ? null : this.authorizationType.toString());
        jsonWriter.writeStringField("oauth2grantType",
            this.oAuth2GrantType == null ? null : this.oAuth2GrantType.toString());
        jsonWriter.writeMapField("parameters", this.parameters, (writer, element) -> writer.writeString(element));
        jsonWriter.writeJsonField("error", this.error);
        jsonWriter.writeStringField("status", this.status);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AuthorizationContractProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AuthorizationContractProperties if the JsonReader was pointing to an instance of it, or
     * null if it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AuthorizationContractProperties.
     */
    public static AuthorizationContractProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AuthorizationContractProperties deserializedAuthorizationContractProperties
                = new AuthorizationContractProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("authorizationType".equals(fieldName)) {
                    deserializedAuthorizationContractProperties.authorizationType
                        = AuthorizationType.fromString(reader.getString());
                } else if ("oauth2grantType".equals(fieldName)) {
                    deserializedAuthorizationContractProperties.oAuth2GrantType
                        = OAuth2GrantType.fromString(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, String> parameters = reader.readMap(reader1 -> reader1.getString());
                    deserializedAuthorizationContractProperties.parameters = parameters;
                } else if ("error".equals(fieldName)) {
                    deserializedAuthorizationContractProperties.error = AuthorizationError.fromJson(reader);
                } else if ("status".equals(fieldName)) {
                    deserializedAuthorizationContractProperties.status = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAuthorizationContractProperties;
        });
    }
}
