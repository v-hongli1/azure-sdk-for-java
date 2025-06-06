// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import javax.xml.stream.XMLStreamException;

/**
 * The RuleAction model.
 */
@Immutable
public class RuleAction implements XmlSerializable<RuleAction> {
    private static final String SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT
        = "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect";

    private static final String WWW_W3_ORG_TWO_ZERO_ZERO_ONE_XMLSCHEMA_INSTANCE
        = "http://www.w3.org/2001/XMLSchema-instance";

    /*
     * The type property.
     */
    @Generated
    private String type = "RuleAction";

    /**
     * Creates an instance of RuleAction class.
     */
    @Generated
    public RuleAction() {
    }

    /**
     * Get the type property: The type property.
     * 
     * @return the type value.
     */
    @Generated
    public String getType() {
        return this.type;
    }

    @Generated
    @Override
    public XmlWriter toXml(XmlWriter xmlWriter) throws XMLStreamException {
        return toXml(xmlWriter, null);
    }

    @Generated
    @Override
    public XmlWriter toXml(XmlWriter xmlWriter, String rootElementName) throws XMLStreamException {
        rootElementName = rootElementName == null || rootElementName.isEmpty() ? "Action" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeNamespace(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT);
        xmlWriter.writeNamespace("xsi", WWW_W3_ORG_TWO_ZERO_ZERO_ONE_XMLSCHEMA_INSTANCE);
        xmlWriter.writeStringAttribute(WWW_W3_ORG_TWO_ZERO_ZERO_ONE_XMLSCHEMA_INSTANCE, "type", this.type);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of RuleAction from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of RuleAction if the XmlReader was pointing to an instance of it, or null if it was pointing
     * to XML null.
     * @throws IllegalStateException If the deserialized XML object has an invalid polymorphic discriminator value.
     * @throws XMLStreamException If an error occurs while reading the RuleAction.
     */
    @Generated
    public static RuleAction fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of RuleAction from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of RuleAction if the XmlReader was pointing to an instance of it, or null if it was pointing
     * to XML null.
     * @throws IllegalStateException If the deserialized XML object has an invalid polymorphic discriminator value.
     * @throws XMLStreamException If an error occurs while reading the RuleAction.
     */
    @Generated
    public static RuleAction fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName = rootElementName == null || rootElementName.isEmpty() ? "Action" : rootElementName;
        return xmlReader.readObject(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, finalRootElementName, reader -> {
            // Get the XML discriminator attribute.
            String discriminatorValue
                = reader.getStringAttribute(WWW_W3_ORG_TWO_ZERO_ZERO_ONE_XMLSCHEMA_INSTANCE, "type");
            // Use the discriminator value to determine which subtype should be deserialized.
            if ("SqlRuleAction".equals(discriminatorValue)) {
                return SqlRuleAction.fromXml(reader, finalRootElementName);
            } else if ("EmptyRuleAction".equals(discriminatorValue)) {
                return EmptyRuleAction.fromXml(reader, finalRootElementName);
            } else {
                return fromXmlInternal(reader, finalRootElementName);
            }
        });
    }

    @Generated
    static RuleAction fromXmlInternal(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName = rootElementName == null || rootElementName.isEmpty() ? "Action" : rootElementName;
        return xmlReader.readObject(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, finalRootElementName, reader -> {
            RuleAction deserializedRuleAction = new RuleAction();
            deserializedRuleAction.type
                = reader.getStringAttribute(WWW_W3_ORG_TWO_ZERO_ZERO_ONE_XMLSCHEMA_INSTANCE, "type");
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                reader.skipElement();
            }

            return deserializedRuleAction;
        });
    }
}
