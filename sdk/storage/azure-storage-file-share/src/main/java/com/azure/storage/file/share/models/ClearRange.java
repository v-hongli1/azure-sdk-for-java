// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.storage.file.share.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * The ClearRange model.
 */
@Fluent
public final class ClearRange implements XmlSerializable<ClearRange> {
    /*
     * The Start property.
     */
    @Generated
    private long start;

    /*
     * The End property.
     */
    @Generated
    private long end;

    /**
     * Creates an instance of ClearRange class.
     */
    @Generated
    public ClearRange() {
    }

    /**
     * Get the start property: The Start property.
     * 
     * @return the start value.
     */
    @Generated
    public long getStart() {
        return this.start;
    }

    /**
     * Set the start property: The Start property.
     * 
     * @param start the start value to set.
     * @return the ClearRange object itself.
     */
    @Generated
    public ClearRange setStart(long start) {
        this.start = start;
        return this;
    }

    /**
     * Get the end property: The End property.
     * 
     * @return the end value.
     */
    @Generated
    public long getEnd() {
        return this.end;
    }

    /**
     * Set the end property: The End property.
     * 
     * @param end the end value to set.
     * @return the ClearRange object itself.
     */
    @Generated
    public ClearRange setEnd(long end) {
        this.end = end;
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
        rootElementName = rootElementName == null || rootElementName.isEmpty() ? "ClearRange" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeLongElement("Start", this.start);
        xmlWriter.writeLongElement("End", this.end);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of ClearRange from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of ClearRange if the XmlReader was pointing to an instance of it, or null if it was pointing
     * to XML null.
     * @throws XMLStreamException If an error occurs while reading the ClearRange.
     */
    @Generated
    public static ClearRange fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of ClearRange from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of ClearRange if the XmlReader was pointing to an instance of it, or null if it was pointing
     * to XML null.
     * @throws XMLStreamException If an error occurs while reading the ClearRange.
     */
    @Generated
    public static ClearRange fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName
            = rootElementName == null || rootElementName.isEmpty() ? "ClearRange" : rootElementName;
        return xmlReader.readObject(finalRootElementName, reader -> {
            ClearRange deserializedClearRange = new ClearRange();
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("Start".equals(elementName.getLocalPart())) {
                    deserializedClearRange.start = reader.getLongElement();
                } else if ("End".equals(elementName.getLocalPart())) {
                    deserializedClearRange.end = reader.getLongElement();
                } else {
                    reader.skipElement();
                }
            }

            return deserializedClearRange;
        });
    }
}
