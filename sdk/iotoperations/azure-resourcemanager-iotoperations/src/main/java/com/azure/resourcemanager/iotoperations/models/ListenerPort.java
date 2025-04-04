// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.iotoperations.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Defines a TCP port on which a `BrokerListener` listens.
 */
@Fluent
public final class ListenerPort implements JsonSerializable<ListenerPort> {
    /*
     * Reference to client authentication settings. Omit to disable authentication.
     */
    private String authenticationRef;

    /*
     * Reference to client authorization settings. Omit to disable authorization.
     */
    private String authorizationRef;

    /*
     * Kubernetes node port. Only relevant when this port is associated with a `NodePort` listener.
     */
    private Integer nodePort;

    /*
     * TCP port for accepting client connections.
     */
    private int port;

    /*
     * Protocol to use for client connections.
     */
    private BrokerProtocolType protocol;

    /*
     * TLS server certificate settings for this port. Omit to disable TLS.
     */
    private TlsCertMethod tls;

    /**
     * Creates an instance of ListenerPort class.
     */
    public ListenerPort() {
    }

    /**
     * Get the authenticationRef property: Reference to client authentication settings. Omit to disable authentication.
     * 
     * @return the authenticationRef value.
     */
    public String authenticationRef() {
        return this.authenticationRef;
    }

    /**
     * Set the authenticationRef property: Reference to client authentication settings. Omit to disable authentication.
     * 
     * @param authenticationRef the authenticationRef value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withAuthenticationRef(String authenticationRef) {
        this.authenticationRef = authenticationRef;
        return this;
    }

    /**
     * Get the authorizationRef property: Reference to client authorization settings. Omit to disable authorization.
     * 
     * @return the authorizationRef value.
     */
    public String authorizationRef() {
        return this.authorizationRef;
    }

    /**
     * Set the authorizationRef property: Reference to client authorization settings. Omit to disable authorization.
     * 
     * @param authorizationRef the authorizationRef value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withAuthorizationRef(String authorizationRef) {
        this.authorizationRef = authorizationRef;
        return this;
    }

    /**
     * Get the nodePort property: Kubernetes node port. Only relevant when this port is associated with a `NodePort`
     * listener.
     * 
     * @return the nodePort value.
     */
    public Integer nodePort() {
        return this.nodePort;
    }

    /**
     * Set the nodePort property: Kubernetes node port. Only relevant when this port is associated with a `NodePort`
     * listener.
     * 
     * @param nodePort the nodePort value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withNodePort(Integer nodePort) {
        this.nodePort = nodePort;
        return this;
    }

    /**
     * Get the port property: TCP port for accepting client connections.
     * 
     * @return the port value.
     */
    public int port() {
        return this.port;
    }

    /**
     * Set the port property: TCP port for accepting client connections.
     * 
     * @param port the port value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withPort(int port) {
        this.port = port;
        return this;
    }

    /**
     * Get the protocol property: Protocol to use for client connections.
     * 
     * @return the protocol value.
     */
    public BrokerProtocolType protocol() {
        return this.protocol;
    }

    /**
     * Set the protocol property: Protocol to use for client connections.
     * 
     * @param protocol the protocol value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withProtocol(BrokerProtocolType protocol) {
        this.protocol = protocol;
        return this;
    }

    /**
     * Get the tls property: TLS server certificate settings for this port. Omit to disable TLS.
     * 
     * @return the tls value.
     */
    public TlsCertMethod tls() {
        return this.tls;
    }

    /**
     * Set the tls property: TLS server certificate settings for this port. Omit to disable TLS.
     * 
     * @param tls the tls value to set.
     * @return the ListenerPort object itself.
     */
    public ListenerPort withTls(TlsCertMethod tls) {
        this.tls = tls;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (tls() != null) {
            tls().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeIntField("port", this.port);
        jsonWriter.writeStringField("authenticationRef", this.authenticationRef);
        jsonWriter.writeStringField("authorizationRef", this.authorizationRef);
        jsonWriter.writeNumberField("nodePort", this.nodePort);
        jsonWriter.writeStringField("protocol", this.protocol == null ? null : this.protocol.toString());
        jsonWriter.writeJsonField("tls", this.tls);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ListenerPort from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ListenerPort if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ListenerPort.
     */
    public static ListenerPort fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ListenerPort deserializedListenerPort = new ListenerPort();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("port".equals(fieldName)) {
                    deserializedListenerPort.port = reader.getInt();
                } else if ("authenticationRef".equals(fieldName)) {
                    deserializedListenerPort.authenticationRef = reader.getString();
                } else if ("authorizationRef".equals(fieldName)) {
                    deserializedListenerPort.authorizationRef = reader.getString();
                } else if ("nodePort".equals(fieldName)) {
                    deserializedListenerPort.nodePort = reader.getNullable(JsonReader::getInt);
                } else if ("protocol".equals(fieldName)) {
                    deserializedListenerPort.protocol = BrokerProtocolType.fromString(reader.getString());
                } else if ("tls".equals(fieldName)) {
                    deserializedListenerPort.tls = TlsCertMethod.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedListenerPort;
        });
    }
}
