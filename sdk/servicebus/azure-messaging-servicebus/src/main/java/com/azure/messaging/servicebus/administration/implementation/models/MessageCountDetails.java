// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * Details about the message counts in entity.
 */
@Fluent
public final class MessageCountDetails implements XmlSerializable<MessageCountDetails> {
    private static final String SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT
        = "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect";

    private static final String SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS
        = "http://schemas.microsoft.com/netservices/2011/06/servicebus";

    /*
     * Number of active messages in the queue, topic, or subscription.
     */
    @Generated
    private Integer activeMessageCount;

    /*
     * Number of messages that are dead lettered.
     */
    @Generated
    private Integer deadLetterMessageCount;

    /*
     * Number of scheduled messages.
     */
    @Generated
    private Integer scheduledMessageCount;

    /*
     * Number of messages transferred into dead letters.
     */
    @Generated
    private Integer transferDeadLetterMessageCount;

    /*
     * Number of messages transferred to another queue, topic, or subscription.
     */
    @Generated
    private Integer transferMessageCount;

    /**
     * Creates an instance of MessageCountDetails class.
     */
    @Generated
    public MessageCountDetails() {
    }

    /**
     * Get the activeMessageCount property: Number of active messages in the queue, topic, or subscription.
     * 
     * @return the activeMessageCount value.
     */
    @Generated
    public Integer getActiveMessageCount() {
        return this.activeMessageCount;
    }

    /**
     * Set the activeMessageCount property: Number of active messages in the queue, topic, or subscription.
     * 
     * @param activeMessageCount the activeMessageCount value to set.
     * @return the MessageCountDetails object itself.
     */
    @Generated
    public MessageCountDetails setActiveMessageCount(Integer activeMessageCount) {
        this.activeMessageCount = activeMessageCount;
        return this;
    }

    /**
     * Get the deadLetterMessageCount property: Number of messages that are dead lettered.
     * 
     * @return the deadLetterMessageCount value.
     */
    @Generated
    public Integer getDeadLetterMessageCount() {
        return this.deadLetterMessageCount;
    }

    /**
     * Set the deadLetterMessageCount property: Number of messages that are dead lettered.
     * 
     * @param deadLetterMessageCount the deadLetterMessageCount value to set.
     * @return the MessageCountDetails object itself.
     */
    @Generated
    public MessageCountDetails setDeadLetterMessageCount(Integer deadLetterMessageCount) {
        this.deadLetterMessageCount = deadLetterMessageCount;
        return this;
    }

    /**
     * Get the scheduledMessageCount property: Number of scheduled messages.
     * 
     * @return the scheduledMessageCount value.
     */
    @Generated
    public Integer getScheduledMessageCount() {
        return this.scheduledMessageCount;
    }

    /**
     * Set the scheduledMessageCount property: Number of scheduled messages.
     * 
     * @param scheduledMessageCount the scheduledMessageCount value to set.
     * @return the MessageCountDetails object itself.
     */
    @Generated
    public MessageCountDetails setScheduledMessageCount(Integer scheduledMessageCount) {
        this.scheduledMessageCount = scheduledMessageCount;
        return this;
    }

    /**
     * Get the transferDeadLetterMessageCount property: Number of messages transferred into dead letters.
     * 
     * @return the transferDeadLetterMessageCount value.
     */
    @Generated
    public Integer getTransferDeadLetterMessageCount() {
        return this.transferDeadLetterMessageCount;
    }

    /**
     * Set the transferDeadLetterMessageCount property: Number of messages transferred into dead letters.
     * 
     * @param transferDeadLetterMessageCount the transferDeadLetterMessageCount value to set.
     * @return the MessageCountDetails object itself.
     */
    @Generated
    public MessageCountDetails setTransferDeadLetterMessageCount(Integer transferDeadLetterMessageCount) {
        this.transferDeadLetterMessageCount = transferDeadLetterMessageCount;
        return this;
    }

    /**
     * Get the transferMessageCount property: Number of messages transferred to another queue, topic, or subscription.
     * 
     * @return the transferMessageCount value.
     */
    @Generated
    public Integer getTransferMessageCount() {
        return this.transferMessageCount;
    }

    /**
     * Set the transferMessageCount property: Number of messages transferred to another queue, topic, or subscription.
     * 
     * @param transferMessageCount the transferMessageCount value to set.
     * @return the MessageCountDetails object itself.
     */
    @Generated
    public MessageCountDetails setTransferMessageCount(Integer transferMessageCount) {
        this.transferMessageCount = transferMessageCount;
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
        rootElementName = rootElementName == null || rootElementName.isEmpty() ? "CountDetails" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeNamespace(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT);
        xmlWriter.writeNamespace("d2p1", SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS, "ActiveMessageCount",
            this.activeMessageCount);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS, "DeadLetterMessageCount",
            this.deadLetterMessageCount);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS, "ScheduledMessageCount",
            this.scheduledMessageCount);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS, "TransferDeadLetterMessageCount",
            this.transferDeadLetterMessageCount);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS, "TransferMessageCount",
            this.transferMessageCount);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of MessageCountDetails from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of MessageCountDetails if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the MessageCountDetails.
     */
    @Generated
    public static MessageCountDetails fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of MessageCountDetails from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of MessageCountDetails if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the MessageCountDetails.
     */
    @Generated
    public static MessageCountDetails fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName
            = rootElementName == null || rootElementName.isEmpty() ? "CountDetails" : rootElementName;
        return xmlReader.readObject(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, finalRootElementName, reader -> {
            MessageCountDetails deserializedMessageCountDetails = new MessageCountDetails();
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("ActiveMessageCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS.equals(elementName.getNamespaceURI())) {
                    deserializedMessageCountDetails.activeMessageCount = reader.getNullableElement(Integer::parseInt);
                } else if ("DeadLetterMessageCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS.equals(elementName.getNamespaceURI())) {
                    deserializedMessageCountDetails.deadLetterMessageCount
                        = reader.getNullableElement(Integer::parseInt);
                } else if ("ScheduledMessageCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS.equals(elementName.getNamespaceURI())) {
                    deserializedMessageCountDetails.scheduledMessageCount
                        = reader.getNullableElement(Integer::parseInt);
                } else if ("TransferDeadLetterMessageCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS.equals(elementName.getNamespaceURI())) {
                    deserializedMessageCountDetails.transferDeadLetterMessageCount
                        = reader.getNullableElement(Integer::parseInt);
                } else if ("TransferMessageCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_ZERO_SIX_SERVICEBUS.equals(elementName.getNamespaceURI())) {
                    deserializedMessageCountDetails.transferMessageCount = reader.getNullableElement(Integer::parseInt);
                } else {
                    reader.skipElement();
                }
            }

            return deserializedMessageCountDetails;
        });
    }
}
