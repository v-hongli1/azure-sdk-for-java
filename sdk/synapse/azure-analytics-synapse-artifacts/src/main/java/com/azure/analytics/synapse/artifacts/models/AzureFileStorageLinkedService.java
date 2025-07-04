// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.synapse.artifacts.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Azure File Storage linked service.
 */
@Fluent
public class AzureFileStorageLinkedService extends LinkedService {
    /*
     * Type of linked service.
     */
    @Generated
    private String type = "AzureFileStorage";

    /*
     * Host name of the server. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object host;

    /*
     * User ID to logon the server. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object userId;

    /*
     * Password to logon the server.
     */
    @Generated
    private SecretBase password;

    /*
     * The connection string. It is mutually exclusive with sasUri property. Type: string, SecureString or
     * AzureKeyVaultSecretReference.
     */
    @Generated
    private Object connectionString;

    /*
     * The Azure key vault secret reference of accountKey in connection string.
     */
    @Generated
    private AzureKeyVaultSecretReference accountKey;

    /*
     * SAS URI of the Azure File resource. It is mutually exclusive with connectionString property. Type: string,
     * SecureString or AzureKeyVaultSecretReference.
     */
    @Generated
    private Object sasUri;

    /*
     * The Azure key vault secret reference of sasToken in sas uri.
     */
    @Generated
    private AzureKeyVaultSecretReference sasToken;

    /*
     * The azure file share name. It is required when auth with accountKey/sasToken. Type: string (or Expression with
     * resultType string).
     */
    @Generated
    private Object fileShare;

    /*
     * The azure file share snapshot version. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object snapshot;

    /*
     * The encrypted credential used for authentication. Credentials are encrypted using the integration runtime
     * credential manager. Type: string (or Expression with resultType string).
     */
    @Generated
    private Object encryptedCredential;

    /*
     * File service endpoint of the Azure File Storage resource. It is mutually exclusive with connectionString, sasUri
     * property.
     */
    @Generated
    private Object serviceEndpoint;

    /*
     * The credential reference containing authentication information.
     */
    @Generated
    private CredentialReference credential;

    /**
     * Creates an instance of AzureFileStorageLinkedService class.
     */
    @Generated
    public AzureFileStorageLinkedService() {
    }

    /**
     * Get the type property: Type of linked service.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public String getType() {
        return this.type;
    }

    /**
     * Get the host property: Host name of the server. Type: string (or Expression with resultType string).
     * 
     * @return the host value.
     */
    @Generated
    public Object getHost() {
        return this.host;
    }

    /**
     * Set the host property: Host name of the server. Type: string (or Expression with resultType string).
     * 
     * @param host the host value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setHost(Object host) {
        this.host = host;
        return this;
    }

    /**
     * Get the userId property: User ID to logon the server. Type: string (or Expression with resultType string).
     * 
     * @return the userId value.
     */
    @Generated
    public Object getUserId() {
        return this.userId;
    }

    /**
     * Set the userId property: User ID to logon the server. Type: string (or Expression with resultType string).
     * 
     * @param userId the userId value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setUserId(Object userId) {
        this.userId = userId;
        return this;
    }

    /**
     * Get the password property: Password to logon the server.
     * 
     * @return the password value.
     */
    @Generated
    public SecretBase getPassword() {
        return this.password;
    }

    /**
     * Set the password property: Password to logon the server.
     * 
     * @param password the password value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setPassword(SecretBase password) {
        this.password = password;
        return this;
    }

    /**
     * Get the connectionString property: The connection string. It is mutually exclusive with sasUri property. Type:
     * string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @return the connectionString value.
     */
    @Generated
    public Object getConnectionString() {
        return this.connectionString;
    }

    /**
     * Set the connectionString property: The connection string. It is mutually exclusive with sasUri property. Type:
     * string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @param connectionString the connectionString value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setConnectionString(Object connectionString) {
        this.connectionString = connectionString;
        return this;
    }

    /**
     * Get the accountKey property: The Azure key vault secret reference of accountKey in connection string.
     * 
     * @return the accountKey value.
     */
    @Generated
    public AzureKeyVaultSecretReference getAccountKey() {
        return this.accountKey;
    }

    /**
     * Set the accountKey property: The Azure key vault secret reference of accountKey in connection string.
     * 
     * @param accountKey the accountKey value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setAccountKey(AzureKeyVaultSecretReference accountKey) {
        this.accountKey = accountKey;
        return this;
    }

    /**
     * Get the sasUri property: SAS URI of the Azure File resource. It is mutually exclusive with connectionString
     * property. Type: string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @return the sasUri value.
     */
    @Generated
    public Object getSasUri() {
        return this.sasUri;
    }

    /**
     * Set the sasUri property: SAS URI of the Azure File resource. It is mutually exclusive with connectionString
     * property. Type: string, SecureString or AzureKeyVaultSecretReference.
     * 
     * @param sasUri the sasUri value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setSasUri(Object sasUri) {
        this.sasUri = sasUri;
        return this;
    }

    /**
     * Get the sasToken property: The Azure key vault secret reference of sasToken in sas uri.
     * 
     * @return the sasToken value.
     */
    @Generated
    public AzureKeyVaultSecretReference getSasToken() {
        return this.sasToken;
    }

    /**
     * Set the sasToken property: The Azure key vault secret reference of sasToken in sas uri.
     * 
     * @param sasToken the sasToken value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setSasToken(AzureKeyVaultSecretReference sasToken) {
        this.sasToken = sasToken;
        return this;
    }

    /**
     * Get the fileShare property: The azure file share name. It is required when auth with accountKey/sasToken. Type:
     * string (or Expression with resultType string).
     * 
     * @return the fileShare value.
     */
    @Generated
    public Object getFileShare() {
        return this.fileShare;
    }

    /**
     * Set the fileShare property: The azure file share name. It is required when auth with accountKey/sasToken. Type:
     * string (or Expression with resultType string).
     * 
     * @param fileShare the fileShare value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setFileShare(Object fileShare) {
        this.fileShare = fileShare;
        return this;
    }

    /**
     * Get the snapshot property: The azure file share snapshot version. Type: string (or Expression with resultType
     * string).
     * 
     * @return the snapshot value.
     */
    @Generated
    public Object getSnapshot() {
        return this.snapshot;
    }

    /**
     * Set the snapshot property: The azure file share snapshot version. Type: string (or Expression with resultType
     * string).
     * 
     * @param snapshot the snapshot value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setSnapshot(Object snapshot) {
        this.snapshot = snapshot;
        return this;
    }

    /**
     * Get the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     * 
     * @return the encryptedCredential value.
     */
    @Generated
    public Object getEncryptedCredential() {
        return this.encryptedCredential;
    }

    /**
     * Set the encryptedCredential property: The encrypted credential used for authentication. Credentials are encrypted
     * using the integration runtime credential manager. Type: string (or Expression with resultType string).
     * 
     * @param encryptedCredential the encryptedCredential value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setEncryptedCredential(Object encryptedCredential) {
        this.encryptedCredential = encryptedCredential;
        return this;
    }

    /**
     * Get the serviceEndpoint property: File service endpoint of the Azure File Storage resource. It is mutually
     * exclusive with connectionString, sasUri property.
     * 
     * @return the serviceEndpoint value.
     */
    @Generated
    public Object getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    /**
     * Set the serviceEndpoint property: File service endpoint of the Azure File Storage resource. It is mutually
     * exclusive with connectionString, sasUri property.
     * 
     * @param serviceEndpoint the serviceEndpoint value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setServiceEndpoint(Object serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
        return this;
    }

    /**
     * Get the credential property: The credential reference containing authentication information.
     * 
     * @return the credential value.
     */
    @Generated
    public CredentialReference getCredential() {
        return this.credential;
    }

    /**
     * Set the credential property: The credential reference containing authentication information.
     * 
     * @param credential the credential value to set.
     * @return the AzureFileStorageLinkedService object itself.
     */
    @Generated
    public AzureFileStorageLinkedService setCredential(CredentialReference credential) {
        this.credential = credential;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AzureFileStorageLinkedService setVersion(String version) {
        super.setVersion(version);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AzureFileStorageLinkedService setConnectVia(IntegrationRuntimeReference connectVia) {
        super.setConnectVia(connectVia);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AzureFileStorageLinkedService setDescription(String description) {
        super.setDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AzureFileStorageLinkedService setParameters(Map<String, ParameterSpecification> parameters) {
        super.setParameters(parameters);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public AzureFileStorageLinkedService setAnnotations(List<Object> annotations) {
        super.setAnnotations(annotations);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("version", getVersion());
        jsonWriter.writeJsonField("connectVia", getConnectVia());
        jsonWriter.writeStringField("description", getDescription());
        jsonWriter.writeMapField("parameters", getParameters(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("annotations", getAnnotations(), (writer, element) -> writer.writeUntyped(element));
        jsonWriter.writeStringField("type", this.type);
        if (host != null
            || userId != null
            || password != null
            || connectionString != null
            || accountKey != null
            || sasUri != null
            || sasToken != null
            || fileShare != null
            || snapshot != null
            || encryptedCredential != null
            || serviceEndpoint != null
            || credential != null) {
            jsonWriter.writeStartObject("typeProperties");
            jsonWriter.writeUntypedField("host", this.host);
            if (this.userId != null) {
                jsonWriter.writeUntypedField("userId", this.userId);
            }
            jsonWriter.writeJsonField("password", this.password);
            if (this.connectionString != null) {
                jsonWriter.writeUntypedField("connectionString", this.connectionString);
            }
            jsonWriter.writeJsonField("accountKey", this.accountKey);
            if (this.sasUri != null) {
                jsonWriter.writeUntypedField("sasUri", this.sasUri);
            }
            jsonWriter.writeJsonField("sasToken", this.sasToken);
            if (this.fileShare != null) {
                jsonWriter.writeUntypedField("fileShare", this.fileShare);
            }
            if (this.snapshot != null) {
                jsonWriter.writeUntypedField("snapshot", this.snapshot);
            }
            if (this.encryptedCredential != null) {
                jsonWriter.writeUntypedField("encryptedCredential", this.encryptedCredential);
            }
            if (this.serviceEndpoint != null) {
                jsonWriter.writeUntypedField("serviceEndpoint", this.serviceEndpoint);
            }
            jsonWriter.writeJsonField("credential", this.credential);
            jsonWriter.writeEndObject();
        }
        if (getAdditionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : getAdditionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AzureFileStorageLinkedService from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AzureFileStorageLinkedService if the JsonReader was pointing to an instance of it, or null
     * if it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the AzureFileStorageLinkedService.
     */
    @Generated
    public static AzureFileStorageLinkedService fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AzureFileStorageLinkedService deserializedAzureFileStorageLinkedService
                = new AzureFileStorageLinkedService();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("version".equals(fieldName)) {
                    deserializedAzureFileStorageLinkedService.setVersion(reader.getString());
                } else if ("connectVia".equals(fieldName)) {
                    deserializedAzureFileStorageLinkedService
                        .setConnectVia(IntegrationRuntimeReference.fromJson(reader));
                } else if ("description".equals(fieldName)) {
                    deserializedAzureFileStorageLinkedService.setDescription(reader.getString());
                } else if ("parameters".equals(fieldName)) {
                    Map<String, ParameterSpecification> parameters
                        = reader.readMap(reader1 -> ParameterSpecification.fromJson(reader1));
                    deserializedAzureFileStorageLinkedService.setParameters(parameters);
                } else if ("annotations".equals(fieldName)) {
                    List<Object> annotations = reader.readArray(reader1 -> reader1.readUntyped());
                    deserializedAzureFileStorageLinkedService.setAnnotations(annotations);
                } else if ("type".equals(fieldName)) {
                    deserializedAzureFileStorageLinkedService.type = reader.getString();
                } else if ("typeProperties".equals(fieldName) && reader.currentToken() == JsonToken.START_OBJECT) {
                    while (reader.nextToken() != JsonToken.END_OBJECT) {
                        fieldName = reader.getFieldName();
                        reader.nextToken();

                        if ("host".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.host = reader.readUntyped();
                        } else if ("userId".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.userId = reader.readUntyped();
                        } else if ("password".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.password = SecretBase.fromJson(reader);
                        } else if ("connectionString".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.connectionString = reader.readUntyped();
                        } else if ("accountKey".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.accountKey
                                = AzureKeyVaultSecretReference.fromJson(reader);
                        } else if ("sasUri".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.sasUri = reader.readUntyped();
                        } else if ("sasToken".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.sasToken
                                = AzureKeyVaultSecretReference.fromJson(reader);
                        } else if ("fileShare".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.fileShare = reader.readUntyped();
                        } else if ("snapshot".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.snapshot = reader.readUntyped();
                        } else if ("encryptedCredential".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.encryptedCredential = reader.readUntyped();
                        } else if ("serviceEndpoint".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.serviceEndpoint = reader.readUntyped();
                        } else if ("credential".equals(fieldName)) {
                            deserializedAzureFileStorageLinkedService.credential = CredentialReference.fromJson(reader);
                        } else {
                            reader.skipChildren();
                        }
                    }
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedAzureFileStorageLinkedService.setAdditionalProperties(additionalProperties);

            return deserializedAzureFileStorageLinkedService;
        });
    }
}
