// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.peering.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * The properties that define an exchange peering facility.
 */
@Fluent
public final class ExchangePeeringFacility implements JsonSerializable<ExchangePeeringFacility> {
    /*
     * The name of the exchange peering facility.
     */
    private String exchangeName;

    /*
     * The bandwidth of the connection between Microsoft and the exchange peering facility.
     */
    private Integer bandwidthInMbps;

    /*
     * The IPv4 address of Microsoft at the exchange peering facility.
     */
    private String microsoftIPv4Address;

    /*
     * The IPv6 address of Microsoft at the exchange peering facility.
     */
    private String microsoftIPv6Address;

    /*
     * The IPv4 prefixes associated with the exchange peering facility.
     */
    private String facilityIPv4Prefix;

    /*
     * The IPv6 prefixes associated with the exchange peering facility.
     */
    private String facilityIPv6Prefix;

    /*
     * The PeeringDB.com ID of the facility.
     */
    private Integer peeringDBFacilityId;

    /*
     * The PeeringDB.com URL of the facility.
     */
    private String peeringDBFacilityLink;

    /**
     * Creates an instance of ExchangePeeringFacility class.
     */
    public ExchangePeeringFacility() {
    }

    /**
     * Get the exchangeName property: The name of the exchange peering facility.
     * 
     * @return the exchangeName value.
     */
    public String exchangeName() {
        return this.exchangeName;
    }

    /**
     * Set the exchangeName property: The name of the exchange peering facility.
     * 
     * @param exchangeName the exchangeName value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
        return this;
    }

    /**
     * Get the bandwidthInMbps property: The bandwidth of the connection between Microsoft and the exchange peering
     * facility.
     * 
     * @return the bandwidthInMbps value.
     */
    public Integer bandwidthInMbps() {
        return this.bandwidthInMbps;
    }

    /**
     * Set the bandwidthInMbps property: The bandwidth of the connection between Microsoft and the exchange peering
     * facility.
     * 
     * @param bandwidthInMbps the bandwidthInMbps value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withBandwidthInMbps(Integer bandwidthInMbps) {
        this.bandwidthInMbps = bandwidthInMbps;
        return this;
    }

    /**
     * Get the microsoftIPv4Address property: The IPv4 address of Microsoft at the exchange peering facility.
     * 
     * @return the microsoftIPv4Address value.
     */
    public String microsoftIPv4Address() {
        return this.microsoftIPv4Address;
    }

    /**
     * Set the microsoftIPv4Address property: The IPv4 address of Microsoft at the exchange peering facility.
     * 
     * @param microsoftIPv4Address the microsoftIPv4Address value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withMicrosoftIPv4Address(String microsoftIPv4Address) {
        this.microsoftIPv4Address = microsoftIPv4Address;
        return this;
    }

    /**
     * Get the microsoftIPv6Address property: The IPv6 address of Microsoft at the exchange peering facility.
     * 
     * @return the microsoftIPv6Address value.
     */
    public String microsoftIPv6Address() {
        return this.microsoftIPv6Address;
    }

    /**
     * Set the microsoftIPv6Address property: The IPv6 address of Microsoft at the exchange peering facility.
     * 
     * @param microsoftIPv6Address the microsoftIPv6Address value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withMicrosoftIPv6Address(String microsoftIPv6Address) {
        this.microsoftIPv6Address = microsoftIPv6Address;
        return this;
    }

    /**
     * Get the facilityIPv4Prefix property: The IPv4 prefixes associated with the exchange peering facility.
     * 
     * @return the facilityIPv4Prefix value.
     */
    public String facilityIPv4Prefix() {
        return this.facilityIPv4Prefix;
    }

    /**
     * Set the facilityIPv4Prefix property: The IPv4 prefixes associated with the exchange peering facility.
     * 
     * @param facilityIPv4Prefix the facilityIPv4Prefix value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withFacilityIPv4Prefix(String facilityIPv4Prefix) {
        this.facilityIPv4Prefix = facilityIPv4Prefix;
        return this;
    }

    /**
     * Get the facilityIPv6Prefix property: The IPv6 prefixes associated with the exchange peering facility.
     * 
     * @return the facilityIPv6Prefix value.
     */
    public String facilityIPv6Prefix() {
        return this.facilityIPv6Prefix;
    }

    /**
     * Set the facilityIPv6Prefix property: The IPv6 prefixes associated with the exchange peering facility.
     * 
     * @param facilityIPv6Prefix the facilityIPv6Prefix value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withFacilityIPv6Prefix(String facilityIPv6Prefix) {
        this.facilityIPv6Prefix = facilityIPv6Prefix;
        return this;
    }

    /**
     * Get the peeringDBFacilityId property: The PeeringDB.com ID of the facility.
     * 
     * @return the peeringDBFacilityId value.
     */
    public Integer peeringDBFacilityId() {
        return this.peeringDBFacilityId;
    }

    /**
     * Set the peeringDBFacilityId property: The PeeringDB.com ID of the facility.
     * 
     * @param peeringDBFacilityId the peeringDBFacilityId value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withPeeringDBFacilityId(Integer peeringDBFacilityId) {
        this.peeringDBFacilityId = peeringDBFacilityId;
        return this;
    }

    /**
     * Get the peeringDBFacilityLink property: The PeeringDB.com URL of the facility.
     * 
     * @return the peeringDBFacilityLink value.
     */
    public String peeringDBFacilityLink() {
        return this.peeringDBFacilityLink;
    }

    /**
     * Set the peeringDBFacilityLink property: The PeeringDB.com URL of the facility.
     * 
     * @param peeringDBFacilityLink the peeringDBFacilityLink value to set.
     * @return the ExchangePeeringFacility object itself.
     */
    public ExchangePeeringFacility withPeeringDBFacilityLink(String peeringDBFacilityLink) {
        this.peeringDBFacilityLink = peeringDBFacilityLink;
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
        jsonWriter.writeStringField("exchangeName", this.exchangeName);
        jsonWriter.writeNumberField("bandwidthInMbps", this.bandwidthInMbps);
        jsonWriter.writeStringField("microsoftIPv4Address", this.microsoftIPv4Address);
        jsonWriter.writeStringField("microsoftIPv6Address", this.microsoftIPv6Address);
        jsonWriter.writeStringField("facilityIPv4Prefix", this.facilityIPv4Prefix);
        jsonWriter.writeStringField("facilityIPv6Prefix", this.facilityIPv6Prefix);
        jsonWriter.writeNumberField("peeringDBFacilityId", this.peeringDBFacilityId);
        jsonWriter.writeStringField("peeringDBFacilityLink", this.peeringDBFacilityLink);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of ExchangePeeringFacility from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of ExchangePeeringFacility if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the ExchangePeeringFacility.
     */
    public static ExchangePeeringFacility fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ExchangePeeringFacility deserializedExchangePeeringFacility = new ExchangePeeringFacility();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("exchangeName".equals(fieldName)) {
                    deserializedExchangePeeringFacility.exchangeName = reader.getString();
                } else if ("bandwidthInMbps".equals(fieldName)) {
                    deserializedExchangePeeringFacility.bandwidthInMbps = reader.getNullable(JsonReader::getInt);
                } else if ("microsoftIPv4Address".equals(fieldName)) {
                    deserializedExchangePeeringFacility.microsoftIPv4Address = reader.getString();
                } else if ("microsoftIPv6Address".equals(fieldName)) {
                    deserializedExchangePeeringFacility.microsoftIPv6Address = reader.getString();
                } else if ("facilityIPv4Prefix".equals(fieldName)) {
                    deserializedExchangePeeringFacility.facilityIPv4Prefix = reader.getString();
                } else if ("facilityIPv6Prefix".equals(fieldName)) {
                    deserializedExchangePeeringFacility.facilityIPv6Prefix = reader.getString();
                } else if ("peeringDBFacilityId".equals(fieldName)) {
                    deserializedExchangePeeringFacility.peeringDBFacilityId = reader.getNullable(JsonReader::getInt);
                } else if ("peeringDBFacilityLink".equals(fieldName)) {
                    deserializedExchangePeeringFacility.peeringDBFacilityLink = reader.getString();
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedExchangePeeringFacility;
        });
    }
}
