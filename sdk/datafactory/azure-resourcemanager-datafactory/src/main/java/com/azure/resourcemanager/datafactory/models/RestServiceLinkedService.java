// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.RestServiceLinkedServiceTypeProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Rest Service linked service.
 */
@Fluent
public final class RestServiceLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    private String type = "RestService";

    /*
     * Rest Service linked service properties.
     */
    private RestServiceLinkedServiceTypeProperties innerTypeProperties = new RestServiceLinkedServiceTypeProperties();

    /**
     * Creates an instance of RestServiceLinkedService class.
     */
    public RestServiceLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Rest Service linked service properties.
     * 
     * @return the innerTypeProperties value.
     */
    RestServiceLinkedServiceTypeProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RestServiceLinkedService withVersion(String version) {
        super.withVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RestServiceLinkedService withConnectVia(IntegrationRuntimeReference connectVia) {
        super.withConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RestServiceLinkedService withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RestServiceLinkedService withParameters(Map<String, ParameterSpecification> parameters) {
        super.withParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public RestServiceLinkedService withAnnotations(List<Object> annotations) {
        super.withAnnotations(annotations);
        return this;
    }

    /**
     * Get the url property: The base URL of the REST service. Type: string (or Expression with resultType string).
     * 
     * @return the url value.
     */
    public Object url() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().url();
    }

    /**
     * Set the url property: The base URL of the REST service. Type: string (or Expression with resultType string).
     * 
     * @param url the url value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withUrl(Object url) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withUrl(url);
        return this;
    }

    /**
     * Get the enableServerCertificateValidation property: Whether to validate server side SSL certificate when
     * connecting to the endpoint.The default value is true. Type: boolean (or Expression with resultType boolean).
     * 
     * @return the enableServerCertificateValidation value.
     */
    public Object enableServerCertificateValidation() {
        return this.innerTypeProperties() == null
            ? null
            : this.innerTypeProperties().enableServerCertificateValidation();
    }

    /**
     * Set the enableServerCertificateValidation property: Whether to validate server side SSL certificate when
     * connecting to the endpoint.The default value is true. Type: boolean (or Expression with resultType boolean).
     * 
     * @param enableServerCertificateValidation the enableServerCertificateValidation value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withEnableServerCertificateValidation(Object enableServerCertificateValidation) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withEnableServerCertificateValidation(enableServerCertificateValidation);
        return this;
    }

    /**
     * Get the authenticationType property: Type of authentication used to connect to the REST service.
     * 
     * @return the authenticationType value.
     */
    public RestServiceAuthenticationType authenticationType() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().authenticationType();
    }

    /**
     * Set the authenticationType property: Type of authentication used to connect to the REST service.
     * 
     * @param authenticationType the authenticationType value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withAuthenticationType(RestServiceAuthenticationType authenticationType) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAuthenticationType(authenticationType);
        return this;
    }

    /**
     * Get the username property: The user name used in Basic authentication type. Type: string (or Expression with
     * resultType string).
     * 
     * @return the username value.
     */
    public Object username() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().username();
    }

    /**
     * Set the username property: The user name used in Basic authentication type. Type: string (or Expression with
     * resultType string).
     * 
     * @param username the username value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withUsername(Object username) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withUsername(username);
        return this;
    }

    /**
     * Get the password property: The password used in Basic authentication type.
     * 
     * @return the password value.
     */
    public SecretBase password() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().password();
    }

    /**
     * Set the password property: The password used in Basic authentication type.
     * 
     * @param password the password value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withPassword(SecretBase password) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withPassword(password);
        return this;
    }

    /**
     * Get the authHeaders property: The additional HTTP headers in the request to RESTful API used for authorization.
     * Type: object (or Expression with resultType object).
     * 
     * @return the authHeaders value.
     */
    public Object authHeaders() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().authHeaders();
    }

    /**
     * Set the authHeaders property: The additional HTTP headers in the request to RESTful API used for authorization.
     * Type: object (or Expression with resultType object).
     * 
     * @param authHeaders the authHeaders value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withAuthHeaders(Object authHeaders) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAuthHeaders(authHeaders);
        return this;
    }

    /**
     * Get the servicePrincipalId property: The application's client ID used in AadServicePrincipal authentication type.
     * Type: string (or Expression with resultType string).
     * 
     * @return the servicePrincipalId value.
     */
    public Object servicePrincipalId() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().servicePrincipalId();
    }

    /**
     * Set the servicePrincipalId property: The application's client ID used in AadServicePrincipal authentication type.
     * Type: string (or Expression with resultType string).
     * 
     * @param servicePrincipalId the servicePrincipalId value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withServicePrincipalId(Object servicePrincipalId) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServicePrincipalId(servicePrincipalId);
        return this;
    }

    /**
     * Get the servicePrincipalKey property: The application's key used in AadServicePrincipal authentication type.
     * 
     * @return the servicePrincipalKey value.
     */
    public SecretBase servicePrincipalKey() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().servicePrincipalKey();
    }

    /**
     * Set the servicePrincipalKey property: The application's key used in AadServicePrincipal authentication type.
     * 
     * @param servicePrincipalKey the servicePrincipalKey value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withServicePrincipalKey(SecretBase servicePrincipalKey) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServicePrincipalKey(servicePrincipalKey);
        return this;
    }

    /**
     * Get the tenant property: The tenant information (domain name or tenant ID) used in AadServicePrincipal
     * authentication type under which your application resides. Type: string (or Expression with resultType string).
     * 
     * @return the tenant value.
     */
    public Object tenant() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().tenant();
    }

    /**
     * Set the tenant property: The tenant information (domain name or tenant ID) used in AadServicePrincipal
     * authentication type under which your application resides. Type: string (or Expression with resultType string).
     * 
     * @param tenant the tenant value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withTenant(Object tenant) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withTenant(tenant);
        return this;
    }

    /**
     * Get the azureCloudType property: Indicates the azure cloud type of the service principle auth. Allowed values are
     * AzurePublic, AzureChina, AzureUsGovernment, AzureGermany. Default value is the data factory regions’ cloud type.
     * Type: string (or Expression with resultType string).
     * 
     * @return the azureCloudType value.
     */
    public Object azureCloudType() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().azureCloudType();
    }

    /**
     * Set the azureCloudType property: Indicates the azure cloud type of the service principle auth. Allowed values are
     * AzurePublic, AzureChina, AzureUsGovernment, AzureGermany. Default value is the data factory regions’ cloud type.
     * Type: string (or Expression with resultType string).
     * 
     * @param azureCloudType the azureCloudType value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withAzureCloudType(Object azureCloudType) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAzureCloudType(azureCloudType);
        return this;
    }

    /**
     * Get the aadResourceId property: The resource you are requesting authorization to use. Type: string (or Expression
     * with resultType string).
     * 
     * @return the aadResourceId value.
     */
    public Object aadResourceId() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().aadResourceId();
    }

    /**
     * Set the aadResourceId property: The resource you are requesting authorization to use. Type: string (or Expression
     * with resultType string).
     * 
     * @param aadResourceId the aadResourceId value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withAadResourceId(Object aadResourceId) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withAadResourceId(aadResourceId);
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @return the encryptedCredential value.
     */
    public String encryptedCredential() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().encryptedCredential();
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string.
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withEncryptedCredential(String encryptedCredential) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withEncryptedCredential(encryptedCredential);
        return this;
    }

    /**
     * Get the credential property: The credential reference containing authentication information.
     * 
     * @return the credential value.
     */
    public CredentialReference credential() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().credential();
    }

    /**
     * Set the credential property: The credential reference containing authentication information.
     * 
     * @param credential the credential value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withCredential(CredentialReference credential) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withCredential(credential);
        return this;
    }

    /**
     * Get the clientId property: The client ID associated with your application. Type: string (or Expression with
     * resultType string).
     * 
     * @return the clientId value.
     */
    public Object clientId() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().clientId();
    }

    /**
     * Set the clientId property: The client ID associated with your application. Type: string (or Expression with
     * resultType string).
     * 
     * @param clientId the clientId value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withClientId(Object clientId) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withClientId(clientId);
        return this;
    }

    /**
     * Get the clientSecret property: The client secret associated with your application.
     * 
     * @return the clientSecret value.
     */
    public SecretBase clientSecret() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().clientSecret();
    }

    /**
     * Set the clientSecret property: The client secret associated with your application.
     * 
     * @param clientSecret the clientSecret value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withClientSecret(SecretBase clientSecret) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withClientSecret(clientSecret);
        return this;
    }

    /**
     * Get the tokenEndpoint property: The token endpoint of the authorization server to acquire access token. Type:
     * string (or Expression with resultType string).
     * 
     * @return the tokenEndpoint value.
     */
    public Object tokenEndpoint() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().tokenEndpoint();
    }

    /**
     * Set the tokenEndpoint property: The token endpoint of the authorization server to acquire access token. Type:
     * string (or Expression with resultType string).
     * 
     * @param tokenEndpoint the tokenEndpoint value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withTokenEndpoint(Object tokenEndpoint) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withTokenEndpoint(tokenEndpoint);
        return this;
    }

    /**
     * Get the resource property: The target service or resource to which the access will be requested. Type: string (or
     * Expression with resultType string).
     * 
     * @return the resource value.
     */
    public Object resource() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().resource();
    }

    /**
     * Set the resource property: The target service or resource to which the access will be requested. Type: string (or
     * Expression with resultType string).
     * 
     * @param resource the resource value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withResource(Object resource) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withResource(resource);
        return this;
    }

    /**
     * Get the scope property: The scope of the access required. It describes what kind of access will be requested.
     * Type: string (or Expression with resultType string).
     * 
     * @return the scope value.
     */
    public Object scope() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().scope();
    }

    /**
     * Set the scope property: The scope of the access required. It describes what kind of access will be requested.
     * Type: string (or Expression with resultType string).
     * 
     * @param scope the scope value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withScope(Object scope) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withScope(scope);
        return this;
    }

    /**
     * Get the servicePrincipalCredentialType property: The service principal credential type to use in Server-To-Server
     * authentication. 'ServicePrincipalKey' for key/secret, 'ServicePrincipalCert' for certificate. Type: string (or
     * Expression with resultType string).
     * 
     * @return the servicePrincipalCredentialType value.
     */
    public Object servicePrincipalCredentialType() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().servicePrincipalCredentialType();
    }

    /**
     * Set the servicePrincipalCredentialType property: The service principal credential type to use in Server-To-Server
     * authentication. 'ServicePrincipalKey' for key/secret, 'ServicePrincipalCert' for certificate. Type: string (or
     * Expression with resultType string).
     * 
     * @param servicePrincipalCredentialType the servicePrincipalCredentialType value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withServicePrincipalCredentialType(Object servicePrincipalCredentialType) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServicePrincipalCredentialType(servicePrincipalCredentialType);
        return this;
    }

    /**
     * Get the servicePrincipalEmbeddedCert property: Specify the base64 encoded certificate of your application
     * registered in Azure Active Directory. Type: string (or Expression with resultType string).
     * 
     * @return the servicePrincipalEmbeddedCert value.
     */
    public SecretBase servicePrincipalEmbeddedCert() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().servicePrincipalEmbeddedCert();
    }

    /**
     * Set the servicePrincipalEmbeddedCert property: Specify the base64 encoded certificate of your application
     * registered in Azure Active Directory. Type: string (or Expression with resultType string).
     * 
     * @param servicePrincipalEmbeddedCert the servicePrincipalEmbeddedCert value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService withServicePrincipalEmbeddedCert(SecretBase servicePrincipalEmbeddedCert) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServicePrincipalEmbeddedCert(servicePrincipalEmbeddedCert);
        return this;
    }

    /**
     * Get the servicePrincipalEmbeddedCertPassword property: Specify the password of your certificate if your
     * certificate has a password and you are using AadServicePrincipal authentication. Type: string (or Expression with
     * resultType string).
     * 
     * @return the servicePrincipalEmbeddedCertPassword value.
     */
    public SecretBase servicePrincipalEmbeddedCertPassword() {
        return this.innerTypeProperties() == null
            ? null
            : this.innerTypeProperties().servicePrincipalEmbeddedCertPassword();
    }

    /**
     * Set the servicePrincipalEmbeddedCertPassword property: Specify the password of your certificate if your
     * certificate has a password and you are using AadServicePrincipal authentication. Type: string (or Expression with
     * resultType string).
     * 
     * @param servicePrincipalEmbeddedCertPassword the servicePrincipalEmbeddedCertPassword value to set.
     * @return the RestServiceLinkedService object itself.
     */
    public RestServiceLinkedService
        withServicePrincipalEmbeddedCertPassword(SecretBase servicePrincipalEmbeddedCertPassword) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new RestServiceLinkedServiceTypeProperties();
        }
        this.innerTypeProperties().withServicePrincipalEmbeddedCertPassword(servicePrincipalEmbeddedCertPassword);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException(
                    "Missing required property innerTypeProperties in model RestServiceLinkedService"));
        } else {
            innerTypeProperties().validate();
        }
        if (connectVia() != null) {
            connectVia().validate();
        }
        if (parameters() != null) {
            parameters().values().forEach(e -> {
                if (e != null) {
                    e.validate();
                }
            });
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(RestServiceLinkedService.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", version());
        jsonWriter.writeJsonField("connectVia", connectVia());
        jsonWriter.writeStringField("description", description());
        jsonWriter.writeMapField("parameters", parameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", annotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        jsonWriter.writeStringField("type", this.type);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of RestServiceLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of RestServiceLinkedService if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the RestServiceLinkedService.
     */
    public static RestServiceLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            RestServiceLinkedService deserializedRestServiceLinkedService = new RestServiceLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedRestServiceLinkedService.withVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedRestServiceLinkedService.withConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedRestServiceLinkedService.withDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedRestServiceLinkedService.withParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedRestServiceLinkedService.withAnnotations(annotations);
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedRestServiceLinkedService.innerTypeProperties
                        = RestServiceLinkedServiceTypeProperties.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedRestServiceLinkedService.type = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedRestServiceLinkedService.withAdditionalProperties(additionalProperties);

            return deserializedRestServiceLinkedService;
        });
    }
}
