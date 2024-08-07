// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Describes the connection monitor endpoint.
 */
@Fluent
public final class ConnectionMonitorEndpoint implements JsonSerializable<ConnectionMonitorEndpoint> {
    /*
     * The name of the connection monitor endpoint.
     */
    private String name;

    /*
     * The endpoint type.
     */
    private EndpointType type;

    /*
     * Resource ID of the connection monitor endpoint are supported for AzureVM, AzureVMSS, AzureVNet, AzureSubnet,
     * MMAWorkspaceMachine, MMAWorkspaceNetwork, AzureArcVM endpoint type.
     */
    private String resourceId;

    /*
     * Address of the connection monitor endpoint. Supported for AzureVM, ExternalAddress, ArcMachine,
     * MMAWorkspaceMachine endpoint type.
     */
    private String address;

    /*
     * Filter field is getting deprecated and should not be used. Instead use Include/Exclude scope fields for it.
     */
    private ConnectionMonitorEndpointFilter filter;

    /*
     * Endpoint scope defines which target resource to monitor in case of compound resource endpoints like VMSS,
     * AzureSubnet, AzureVNet, MMAWorkspaceNetwork, AzureArcNetwork.
     */
    private ConnectionMonitorEndpointScope scope;

    /*
     * Test coverage for the endpoint.
     */
    private CoverageLevel coverageLevel;

    /*
     * Location details is optional and only being used for 'AzureArcNetwork' type endpoints, which contains region
     * details.
     */
    private ConnectionMonitorEndpointLocationDetails locationDetails;

    /*
     * Subscription ID for connection monitor endpoint. It's an optional parameter which is being used for
     * 'AzureArcNetwork' type endpoint.
     */
    private String subscriptionId;

    /**
     * Creates an instance of ConnectionMonitorEndpoint class.
     */
    public ConnectionMonitorEndpoint() {
    }

    /**
     * Get the name property: The name of the connection monitor endpoint.
     * 
     * @return the name value.
     */
    public String name() {
        return this.name;
    }

    /**
     * Set the name property: The name of the connection monitor endpoint.
     * 
     * @param name the name value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get the type property: The endpoint type.
     * 
     * @return the type value.
     */
    public EndpointType type() {
        return this.type;
    }

    /**
     * Set the type property: The endpoint type.
     * 
     * @param type the type value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withType(EndpointType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the resourceId property: Resource ID of the connection monitor endpoint are supported for AzureVM, AzureVMSS,
     * AzureVNet, AzureSubnet, MMAWorkspaceMachine, MMAWorkspaceNetwork, AzureArcVM endpoint type.
     * 
     * @return the resourceId value.
     */
    public String resourceId() {
        return this.resourceId;
    }

    /**
     * Set the resourceId property: Resource ID of the connection monitor endpoint are supported for AzureVM, AzureVMSS,
     * AzureVNet, AzureSubnet, MMAWorkspaceMachine, MMAWorkspaceNetwork, AzureArcVM endpoint type.
     * 
     * @param resourceId the resourceId value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withResourceId(String resourceId) {
        this.resourceId = resourceId;
        return this;
    }

    /**
     * Get the address property: Address of the connection monitor endpoint. Supported for AzureVM, ExternalAddress,
     * ArcMachine, MMAWorkspaceMachine endpoint type.
     * 
     * @return the address value.
     */
    public String address() {
        return this.address;
    }

    /**
     * Set the address property: Address of the connection monitor endpoint. Supported for AzureVM, ExternalAddress,
     * ArcMachine, MMAWorkspaceMachine endpoint type.
     * 
     * @param address the address value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withAddress(String address) {
        this.address = address;
        return this;
    }

    /**
     * Get the filter property: Filter field is getting deprecated and should not be used. Instead use Include/Exclude
     * scope fields for it.
     * 
     * @return the filter value.
     */
    public ConnectionMonitorEndpointFilter filter() {
        return this.filter;
    }

    /**
     * Set the filter property: Filter field is getting deprecated and should not be used. Instead use Include/Exclude
     * scope fields for it.
     * 
     * @param filter the filter value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withFilter(ConnectionMonitorEndpointFilter filter) {
        this.filter = filter;
        return this;
    }

    /**
     * Get the scope property: Endpoint scope defines which target resource to monitor in case of compound resource
     * endpoints like VMSS, AzureSubnet, AzureVNet, MMAWorkspaceNetwork, AzureArcNetwork.
     * 
     * @return the scope value.
     */
    public ConnectionMonitorEndpointScope scope() {
        return this.scope;
    }

    /**
     * Set the scope property: Endpoint scope defines which target resource to monitor in case of compound resource
     * endpoints like VMSS, AzureSubnet, AzureVNet, MMAWorkspaceNetwork, AzureArcNetwork.
     * 
     * @param scope the scope value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withScope(ConnectionMonitorEndpointScope scope) {
        this.scope = scope;
        return this;
    }

    /**
     * Get the coverageLevel property: Test coverage for the endpoint.
     * 
     * @return the coverageLevel value.
     */
    public CoverageLevel coverageLevel() {
        return this.coverageLevel;
    }

    /**
     * Set the coverageLevel property: Test coverage for the endpoint.
     * 
     * @param coverageLevel the coverageLevel value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withCoverageLevel(CoverageLevel coverageLevel) {
        this.coverageLevel = coverageLevel;
        return this;
    }

    /**
     * Get the locationDetails property: Location details is optional and only being used for 'AzureArcNetwork' type
     * endpoints, which contains region details.
     * 
     * @return the locationDetails value.
     */
    public ConnectionMonitorEndpointLocationDetails locationDetails() {
        return this.locationDetails;
    }

    /**
     * Set the locationDetails property: Location details is optional and only being used for 'AzureArcNetwork' type
     * endpoints, which contains region details.
     * 
     * @param locationDetails the locationDetails value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withLocationDetails(ConnectionMonitorEndpointLocationDetails locationDetails) {
        this.locationDetails = locationDetails;
        return this;
    }

    /**
     * Get the subscriptionId property: Subscription ID for connection monitor endpoint. It's an optional parameter
     * which is being used for 'AzureArcNetwork' type endpoint.
     * 
     * @return the subscriptionId value.
     */
    public String subscriptionId() {
        return this.subscriptionId;
    }

    /**
     * Set the subscriptionId property: Subscription ID for connection monitor endpoint. It's an optional parameter
     * which is being used for 'AzureArcNetwork' type endpoint.
     * 
     * @param subscriptionId the subscriptionId value to set.
     * @return the ConnectionMonitorEndpoint object itself.
     */
    public ConnectionMonitorEndpoint withSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model ConnectionMonitorEndpoint"));
        }
        if (filter() != null) {
            filter().validate();
        }
        if (scope() != null) {
            scope().validate();
        }
        if (locationDetails() != null) {
            locationDetails().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(ConnectionMonitorEndpoint.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", this.name);
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeStringField("resourceId", this.resourceId);
        jsonWriter.writeStringField("address", this.address);
        jsonWriter.writeJsonField("filter", this.filter);
        jsonWriter.writeJsonField("scope", this.scope);
        jsonWriter.writeStringField("coverageLevel", this.coverageLevel == null ? null : this.coverageLevel.toString());
        jsonWriter.writeJsonField("locationDetails", this.locationDetails);
        jsonWriter.writeStringField("subscriptionId", this.subscriptionId);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ConnectionMonitorEndpoint from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ConnectionMonitorEndpoint if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the ConnectionMonitorEndpoint.
     */
    public static ConnectionMonitorEndpoint fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ConnectionMonitorEndpoint deserializedConnectionMonitorEndpoint = new ConnectionMonitorEndpoint();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.name = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.type = EndpointType.fromString(reader.getString());
                } else if ("resourceId".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.resourceId = reader.getString();
                } else if ("address".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.address = reader.getString();
                } else if ("filter".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.filter = ConnectionMonitorEndpointFilter.fromJson(reader);
                } else if ("scope".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.scope = ConnectionMonitorEndpointScope.fromJson(reader);
                } else if ("coverageLevel".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.coverageLevel = CoverageLevel.fromString(reader.getString());
                } else if ("locationDetails".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.locationDetails
                        = ConnectionMonitorEndpointLocationDetails.fromJson(reader);
                } else if ("subscriptionId".equals(fieldName)) {
                    deserializedConnectionMonitorEndpoint.subscriptionId = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedConnectionMonitorEndpoint;
        });
    }
}
