// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.network.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.SubResource;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.network.models.ProvisioningState;
import java.io.IOException;
import java.util.List;

/**
 * Nat Gateway properties.
 */
@Fluent
public final class NatGatewayPropertiesFormat implements JsonSerializable<NatGatewayPropertiesFormat> {
    /*
     * The idle timeout of the nat gateway.
     */
    private Integer idleTimeoutInMinutes;

    /*
     * An array of public ip addresses V4 associated with the nat gateway resource.
     */
    private List<SubResource> publicIpAddresses;

    /*
     * An array of public ip addresses V6 associated with the nat gateway resource.
     */
    private List<SubResource> publicIpAddressesV6;

    /*
     * An array of public ip prefixes V4 associated with the nat gateway resource.
     */
    private List<SubResource> publicIpPrefixes;

    /*
     * An array of public ip prefixes V6 associated with the nat gateway resource.
     */
    private List<SubResource> publicIpPrefixesV6;

    /*
     * An array of references to the subnets using this nat gateway resource.
     */
    private List<SubResource> subnets;

    /*
     * A reference to the source virtual network using this nat gateway resource.
     */
    private SubResource sourceVirtualNetwork;

    /*
     * The resource GUID property of the NAT gateway resource.
     */
    private String resourceGuid;

    /*
     * The provisioning state of the NAT gateway resource.
     */
    private ProvisioningState provisioningState;

    /**
     * Creates an instance of NatGatewayPropertiesFormat class.
     */
    public NatGatewayPropertiesFormat() {
    }

    /**
     * Get the idleTimeoutInMinutes property: The idle timeout of the nat gateway.
     * 
     * @return the idleTimeoutInMinutes value.
     */
    public Integer idleTimeoutInMinutes() {
        return this.idleTimeoutInMinutes;
    }

    /**
     * Set the idleTimeoutInMinutes property: The idle timeout of the nat gateway.
     * 
     * @param idleTimeoutInMinutes the idleTimeoutInMinutes value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withIdleTimeoutInMinutes(Integer idleTimeoutInMinutes) {
        this.idleTimeoutInMinutes = idleTimeoutInMinutes;
        return this;
    }

    /**
     * Get the publicIpAddresses property: An array of public ip addresses V4 associated with the nat gateway resource.
     * 
     * @return the publicIpAddresses value.
     */
    public List<SubResource> publicIpAddresses() {
        return this.publicIpAddresses;
    }

    /**
     * Set the publicIpAddresses property: An array of public ip addresses V4 associated with the nat gateway resource.
     * 
     * @param publicIpAddresses the publicIpAddresses value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withPublicIpAddresses(List<SubResource> publicIpAddresses) {
        this.publicIpAddresses = publicIpAddresses;
        return this;
    }

    /**
     * Get the publicIpAddressesV6 property: An array of public ip addresses V6 associated with the nat gateway
     * resource.
     * 
     * @return the publicIpAddressesV6 value.
     */
    public List<SubResource> publicIpAddressesV6() {
        return this.publicIpAddressesV6;
    }

    /**
     * Set the publicIpAddressesV6 property: An array of public ip addresses V6 associated with the nat gateway
     * resource.
     * 
     * @param publicIpAddressesV6 the publicIpAddressesV6 value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withPublicIpAddressesV6(List<SubResource> publicIpAddressesV6) {
        this.publicIpAddressesV6 = publicIpAddressesV6;
        return this;
    }

    /**
     * Get the publicIpPrefixes property: An array of public ip prefixes V4 associated with the nat gateway resource.
     * 
     * @return the publicIpPrefixes value.
     */
    public List<SubResource> publicIpPrefixes() {
        return this.publicIpPrefixes;
    }

    /**
     * Set the publicIpPrefixes property: An array of public ip prefixes V4 associated with the nat gateway resource.
     * 
     * @param publicIpPrefixes the publicIpPrefixes value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withPublicIpPrefixes(List<SubResource> publicIpPrefixes) {
        this.publicIpPrefixes = publicIpPrefixes;
        return this;
    }

    /**
     * Get the publicIpPrefixesV6 property: An array of public ip prefixes V6 associated with the nat gateway resource.
     * 
     * @return the publicIpPrefixesV6 value.
     */
    public List<SubResource> publicIpPrefixesV6() {
        return this.publicIpPrefixesV6;
    }

    /**
     * Set the publicIpPrefixesV6 property: An array of public ip prefixes V6 associated with the nat gateway resource.
     * 
     * @param publicIpPrefixesV6 the publicIpPrefixesV6 value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withPublicIpPrefixesV6(List<SubResource> publicIpPrefixesV6) {
        this.publicIpPrefixesV6 = publicIpPrefixesV6;
        return this;
    }

    /**
     * Get the subnets property: An array of references to the subnets using this nat gateway resource.
     * 
     * @return the subnets value.
     */
    public List<SubResource> subnets() {
        return this.subnets;
    }

    /**
     * Get the sourceVirtualNetwork property: A reference to the source virtual network using this nat gateway resource.
     * 
     * @return the sourceVirtualNetwork value.
     */
    public SubResource sourceVirtualNetwork() {
        return this.sourceVirtualNetwork;
    }

    /**
     * Set the sourceVirtualNetwork property: A reference to the source virtual network using this nat gateway resource.
     * 
     * @param sourceVirtualNetwork the sourceVirtualNetwork value to set.
     * @return the NatGatewayPropertiesFormat object itself.
     */
    public NatGatewayPropertiesFormat withSourceVirtualNetwork(SubResource sourceVirtualNetwork) {
        this.sourceVirtualNetwork = sourceVirtualNetwork;
        return this;
    }

    /**
     * Get the resourceGuid property: The resource GUID property of the NAT gateway resource.
     * 
     * @return the resourceGuid value.
     */
    public String resourceGuid() {
        return this.resourceGuid;
    }

    /**
     * Get the provisioningState property: The provisioning state of the NAT gateway resource.
     * 
     * @return the provisioningState value.
     */
    public ProvisioningState provisioningState() {
        return this.provisioningState;
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
        jsonWriter.writeNumberField("idleTimeoutInMinutes", this.idleTimeoutInMinutes);
        jsonWriter.writeArrayField("publicIpAddresses", this.publicIpAddresses,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("publicIpAddressesV6", this.publicIpAddressesV6,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("publicIpPrefixes", this.publicIpPrefixes,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("publicIpPrefixesV6", this.publicIpPrefixesV6,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("sourceVirtualNetwork", this.sourceVirtualNetwork);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of NatGatewayPropertiesFormat from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of NatGatewayPropertiesFormat if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the NatGatewayPropertiesFormat.
     */
    public static NatGatewayPropertiesFormat fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            NatGatewayPropertiesFormat deserializedNatGatewayPropertiesFormat = new NatGatewayPropertiesFormat();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("idleTimeoutInMinutes".equals(fieldName)) {
                    deserializedNatGatewayPropertiesFormat.idleTimeoutInMinutes
                        = reader.getNullable(JsonReader::getInt);
                } else if ("publicIpAddresses".equals(fieldName)) {
                    List<SubResource> publicIpAddresses = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedNatGatewayPropertiesFormat.publicIpAddresses = publicIpAddresses;
                } else if ("publicIpAddressesV6".equals(fieldName)) {
                    List<SubResource> publicIpAddressesV6 = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedNatGatewayPropertiesFormat.publicIpAddressesV6 = publicIpAddressesV6;
                } else if ("publicIpPrefixes".equals(fieldName)) {
                    List<SubResource> publicIpPrefixes = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedNatGatewayPropertiesFormat.publicIpPrefixes = publicIpPrefixes;
                } else if ("publicIpPrefixesV6".equals(fieldName)) {
                    List<SubResource> publicIpPrefixesV6 = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedNatGatewayPropertiesFormat.publicIpPrefixesV6 = publicIpPrefixesV6;
                } else if ("subnets".equals(fieldName)) {
                    List<SubResource> subnets = reader.readArray(reader1 -> SubResource.fromJson(reader1));
                    deserializedNatGatewayPropertiesFormat.subnets = subnets;
                } else if ("sourceVirtualNetwork".equals(fieldName)) {
                    deserializedNatGatewayPropertiesFormat.sourceVirtualNetwork = SubResource.fromJson(reader);
                } else if ("resourceGuid".equals(fieldName)) {
                    deserializedNatGatewayPropertiesFormat.resourceGuid = reader.getString();
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedNatGatewayPropertiesFormat.provisioningState
                        = ProvisioningState.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedNatGatewayPropertiesFormat;
        });
    }
}
