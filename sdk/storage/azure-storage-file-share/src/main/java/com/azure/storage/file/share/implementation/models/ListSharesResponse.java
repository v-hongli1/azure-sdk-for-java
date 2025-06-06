// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.share.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * An enumeration of shares.
 */
@Fluent
public final class ListSharesResponse implements XmlSerializable<ListSharesResponse> {
    /*
     * The ServiceEndpoint property.
     */
    @Generated
    private String serviceEndpoint;

    /*
     * The Prefix property.
     */
    @Generated
    private String prefix;

    /*
     * The Marker property.
     */
    @Generated
    private String marker;

    /*
     * The MaxResults property.
     */
    @Generated
    private Integer maxResults;

    /*
     * The ShareItems property.
     */
    @Generated
    private List<ShareItemInternal> shareItems;

    /*
     * The NextMarker property.
     */
    @Generated
    private String nextMarker;

    /**
     * Creates an instance of ListSharesResponse class.
     */
    @Generated
    public ListSharesResponse() {
    }

    /**
     * Get the serviceEndpoint property: The ServiceEndpoint property.
     * 
     * @return the serviceEndpoint value.
     */
    @Generated
    public String getServiceEndpoint() {
        return this.serviceEndpoint;
    }

    /**
     * Set the serviceEndpoint property: The ServiceEndpoint property.
     * 
     * @param serviceEndpoint the serviceEndpoint value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setServiceEndpoint(String serviceEndpoint) {
        this.serviceEndpoint = serviceEndpoint;
        return this;
    }

    /**
     * Get the prefix property: The Prefix property.
     * 
     * @return the prefix value.
     */
    @Generated
    public String getPrefix() {
        return this.prefix;
    }

    /**
     * Set the prefix property: The Prefix property.
     * 
     * @param prefix the prefix value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setPrefix(String prefix) {
        this.prefix = prefix;
        return this;
    }

    /**
     * Get the marker property: The Marker property.
     * 
     * @return the marker value.
     */
    @Generated
    public String getMarker() {
        return this.marker;
    }

    /**
     * Set the marker property: The Marker property.
     * 
     * @param marker the marker value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setMarker(String marker) {
        this.marker = marker;
        return this;
    }

    /**
     * Get the maxResults property: The MaxResults property.
     * 
     * @return the maxResults value.
     */
    @Generated
    public Integer getMaxResults() {
        return this.maxResults;
    }

    /**
     * Set the maxResults property: The MaxResults property.
     * 
     * @param maxResults the maxResults value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setMaxResults(Integer maxResults) {
        this.maxResults = maxResults;
        return this;
    }

    /**
     * Get the shareItems property: The ShareItems property.
     * 
     * @return the shareItems value.
     */
    @Generated
    public List<ShareItemInternal> getShareItems() {
        if (this.shareItems == null) {
            this.shareItems = new ArrayList<>();
        }
        return this.shareItems;
    }

    /**
     * Set the shareItems property: The ShareItems property.
     * 
     * @param shareItems the shareItems value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setShareItems(List<ShareItemInternal> shareItems) {
        this.shareItems = shareItems;
        return this;
    }

    /**
     * Get the nextMarker property: The NextMarker property.
     * 
     * @return the nextMarker value.
     */
    @Generated
    public String getNextMarker() {
        return this.nextMarker;
    }

    /**
     * Set the nextMarker property: The NextMarker property.
     * 
     * @param nextMarker the nextMarker value to set.
     * @return the ListSharesResponse object itself.
     */
    @Generated
    public ListSharesResponse setNextMarker(String nextMarker) {
        this.nextMarker = nextMarker;
        return this;
    }

    @Generated
    @Override
    public XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        return toXml(xmlWriter, null);
    }

    @Generated
    @Override
    public XmlWriter toXml(XmlWriter xmlWriter, String rootElementName) throws XMLStreamException {
        rootElementName = rootElementName == null || rootElementName.isEmpty() ? "EnumerationResults" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeStringAttribute("ServiceEndpoint", this.serviceEndpoint);
        xmlWriter.writeStringElement("Prefix", this.prefix);
        xmlWriter.writeStringElement("Marker", this.marker);
        xmlWriter.writeNumberElement("MaxResults", this.maxResults);
        if (this.shareItems != null) {
            xmlWriter.writeStartElement("Shares");
            for (ShareItemInternal element : this.shareItems) {
                xmlWriter.writeXml(element, "Share");
            }
            xmlWriter.writeEndElement();
        }
        xmlWriter.writeStringElement("NextMarker", this.nextMarker);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of ListSharesResponse from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of ListSharesResponse if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the ListSharesResponse.
     */
    @Generated
    public static ListSharesResponse fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of ListSharesResponse from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of ListSharesResponse if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the ListSharesResponse.
     */
    @Generated
    public static ListSharesResponse fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName
            = rootElementName == null || rootElementName.isEmpty() ? "EnumerationResults" : rootElementName;
        return xmlReader.readObject(finalRootElementName, reader -> {
            ListSharesResponse deserializedListSharesResponse = new ListSharesResponse();
            deserializedListSharesResponse.serviceEndpoint = reader.getStringAttribute(null, "ServiceEndpoint");
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("Prefix".equals(elementName.getLocalPart())) {
                    deserializedListSharesResponse.prefix = reader.getStringElement();
                } else if ("Marker".equals(elementName.getLocalPart())) {
                    deserializedListSharesResponse.marker = reader.getStringElement();
                } else if ("MaxResults".equals(elementName.getLocalPart())) {
                    deserializedListSharesResponse.maxResults = reader.getNullableElement(Integer::parseInt);
                } else if ("Shares".equals(elementName.getLocalPart())) {
                    while (reader.nextElement() != XmlToken.END_ELEMENT) {
                        elementName = reader.getElementName();
                        if ("Share".equals(elementName.getLocalPart())) {
                            if (deserializedListSharesResponse.shareItems == null) {
                                deserializedListSharesResponse.shareItems = new ArrayList<>();
                            }
                            deserializedListSharesResponse.shareItems.add(ShareItemInternal.fromXml(reader, "Share"));
                        } else {
                            reader.skipElement();
                        }
                    }
                } else if ("NextMarker".equals(elementName.getLocalPart())) {
                    deserializedListSharesResponse.nextMarker = reader.getStringElement();
                } else {
                    reader.skipElement();
                }
            }

            return deserializedListSharesResponse;
        });
    }
}
