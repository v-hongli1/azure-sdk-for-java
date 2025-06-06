// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.messaging.servicebus.administration.models.EntityStatus;
import com.azure.xml.XmlReader;
import com.azure.xml.XmlSerializable;
import com.azure.xml.XmlToken;
import com.azure.xml.XmlWriter;
import java.time.Duration;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import javax.xml.namespace.QName;
import javax.xml.stream.XMLStreamException;

/**
 * Description of a Service Bus topic resource.
 */
@Fluent
public final class TopicDescription implements XmlSerializable<TopicDescription> {
    private static final String SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT
        = "http://schemas.microsoft.com/netservices/2010/10/servicebus/connect";

    /*
     * ISO 8601 default message timespan to live value. This is the duration after which the message expires, starting
     * from when the message is sent to Service Bus. This is the default value used when TimeToLive is not set on a
     * message itself.
     */
    @Generated
    private Duration defaultMessageTimeToLive;

    /*
     * The maximum size of the topic in megabytes, which is the size of memory allocated for the topic.
     */
    @Generated
    private Long maxSizeInMegabytes;

    /*
     * A value indicating if this topic requires duplicate detection.
     */
    @Generated
    private Boolean requiresDuplicateDetection;

    /*
     * ISO 8601 timeSpan structure that defines the duration of the duplicate detection history. The default value is 10
     * minutes.
     */
    @Generated
    private Duration duplicateDetectionHistoryTimeWindow;

    /*
     * Value that indicates whether server-side batched operations are enabled.
     */
    @Generated
    private Boolean enableBatchedOperations;

    /*
     * The size of the topic, in bytes.
     */
    @Generated
    private Long sizeInBytes;

    /*
     * Filter messages before publishing.
     */
    @Generated
    private Boolean filteringMessagesBeforePublishing;

    /*
     * A value indicating if the resource can be accessed without authorization.
     */
    @Generated
    private Boolean isAnonymousAccessible;

    /*
     * Authorization rules for resource.
     */
    @Generated
    private List<AuthorizationRule> authorizationRules;

    /*
     * Status of a Service Bus resource
     */
    @Generated
    private EntityStatus status;

    /*
     * The exact time the topic was created.
     */
    @Generated
    private OffsetDateTime createdAt;

    /*
     * The exact time a message was updated in the topic.
     */
    @Generated
    private OffsetDateTime updatedAt;

    /*
     * Last time a message was sent, or the last time there was a receive request to this topic.
     */
    @Generated
    private OffsetDateTime accessedAt;

    /*
     * Indicates if messages are received in the same order they are sent. If partitioned topics, defaults to false, and
     * setting it to true has no effect. For unpartitioned topics, setting it to false will improve perf, but messages
     * may not be received in the order they are sent.
     */
    @Generated
    private Boolean supportOrdering;

    /*
     * Details about the message counts in entity.
     */
    @Generated
    private MessageCountDetails messageCountDetails;

    /*
     * The number of subscriptions in the topic.
     */
    @Generated
    private Integer subscriptionCount;

    /*
     * ISO 8601 timeSpan idle interval after which the topic is automatically deleted. The minimum duration is 5
     * minutes.
     */
    @Generated
    private Duration autoDeleteOnIdle;

    /*
     * A value that indicates whether the topic is to be partitioned across multiple message brokers.
     */
    @Generated
    private Boolean enablePartitioning;

    /*
     * Availability status of the entity
     */
    @Generated
    private EntityAvailabilityStatus entityAvailabilityStatus;

    /*
     * A value that indicates whether the topic's subscription is to be partitioned.
     */
    @Generated
    private Boolean enableSubscriptionPartitioning;

    /*
     * A value that indicates whether Express Entities are enabled. An express topic holds a message in memory
     * temporarily before writing it to persistent storage.
     */
    @Generated
    private Boolean enableExpress;

    /*
     * Metadata associated with the topic.
     */
    @Generated
    private String userMetadata;

    /*
     * The maximum size in kilobytes of message payload that can be accepted by the topic.
     */
    @Generated
    private Long maxMessageSizeInKilobytes;

    /**
     * Creates an instance of TopicDescription class.
     */
    @Generated
    public TopicDescription() {
    }

    /**
     * Get the defaultMessageTimeToLive property: ISO 8601 default message timespan to live value. This is the duration
     * after which the message expires, starting from when the message is sent to Service Bus. This is the default value
     * used when TimeToLive is not set on a message itself.
     * 
     * @return the defaultMessageTimeToLive value.
     */
    @Generated
    public Duration getDefaultMessageTimeToLive() {
        return this.defaultMessageTimeToLive;
    }

    /**
     * Set the defaultMessageTimeToLive property: ISO 8601 default message timespan to live value. This is the duration
     * after which the message expires, starting from when the message is sent to Service Bus. This is the default value
     * used when TimeToLive is not set on a message itself.
     * 
     * @param defaultMessageTimeToLive the defaultMessageTimeToLive value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setDefaultMessageTimeToLive(Duration defaultMessageTimeToLive) {
        this.defaultMessageTimeToLive = defaultMessageTimeToLive;
        return this;
    }

    /**
     * Get the maxSizeInMegabytes property: The maximum size of the topic in megabytes, which is the size of memory
     * allocated for the topic.
     * 
     * @return the maxSizeInMegabytes value.
     */
    @Generated
    public Long getMaxSizeInMegabytes() {
        return this.maxSizeInMegabytes;
    }

    /**
     * Set the maxSizeInMegabytes property: The maximum size of the topic in megabytes, which is the size of memory
     * allocated for the topic.
     * 
     * @param maxSizeInMegabytes the maxSizeInMegabytes value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setMaxSizeInMegabytes(Long maxSizeInMegabytes) {
        this.maxSizeInMegabytes = maxSizeInMegabytes;
        return this;
    }

    /**
     * Get the requiresDuplicateDetection property: A value indicating if this topic requires duplicate detection.
     * 
     * @return the requiresDuplicateDetection value.
     */
    @Generated
    public Boolean isRequiresDuplicateDetection() {
        return this.requiresDuplicateDetection;
    }

    /**
     * Set the requiresDuplicateDetection property: A value indicating if this topic requires duplicate detection.
     * 
     * @param requiresDuplicateDetection the requiresDuplicateDetection value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setRequiresDuplicateDetection(Boolean requiresDuplicateDetection) {
        this.requiresDuplicateDetection = requiresDuplicateDetection;
        return this;
    }

    /**
     * Get the duplicateDetectionHistoryTimeWindow property: ISO 8601 timeSpan structure that defines the duration of
     * the duplicate detection history. The default value is 10 minutes.
     * 
     * @return the duplicateDetectionHistoryTimeWindow value.
     */
    @Generated
    public Duration getDuplicateDetectionHistoryTimeWindow() {
        return this.duplicateDetectionHistoryTimeWindow;
    }

    /**
     * Set the duplicateDetectionHistoryTimeWindow property: ISO 8601 timeSpan structure that defines the duration of
     * the duplicate detection history. The default value is 10 minutes.
     * 
     * @param duplicateDetectionHistoryTimeWindow the duplicateDetectionHistoryTimeWindow value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setDuplicateDetectionHistoryTimeWindow(Duration duplicateDetectionHistoryTimeWindow) {
        this.duplicateDetectionHistoryTimeWindow = duplicateDetectionHistoryTimeWindow;
        return this;
    }

    /**
     * Get the enableBatchedOperations property: Value that indicates whether server-side batched operations are
     * enabled.
     * 
     * @return the enableBatchedOperations value.
     */
    @Generated
    public Boolean isEnableBatchedOperations() {
        return this.enableBatchedOperations;
    }

    /**
     * Set the enableBatchedOperations property: Value that indicates whether server-side batched operations are
     * enabled.
     * 
     * @param enableBatchedOperations the enableBatchedOperations value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setEnableBatchedOperations(Boolean enableBatchedOperations) {
        this.enableBatchedOperations = enableBatchedOperations;
        return this;
    }

    /**
     * Get the sizeInBytes property: The size of the topic, in bytes.
     * 
     * @return the sizeInBytes value.
     */
    @Generated
    public Long getSizeInBytes() {
        return this.sizeInBytes;
    }

    /**
     * Set the sizeInBytes property: The size of the topic, in bytes.
     * 
     * @param sizeInBytes the sizeInBytes value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setSizeInBytes(Long sizeInBytes) {
        this.sizeInBytes = sizeInBytes;
        return this;
    }

    /**
     * Get the filteringMessagesBeforePublishing property: Filter messages before publishing.
     * 
     * @return the filteringMessagesBeforePublishing value.
     */
    @Generated
    public Boolean isFilteringMessagesBeforePublishing() {
        return this.filteringMessagesBeforePublishing;
    }

    /**
     * Set the filteringMessagesBeforePublishing property: Filter messages before publishing.
     * 
     * @param filteringMessagesBeforePublishing the filteringMessagesBeforePublishing value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setFilteringMessagesBeforePublishing(Boolean filteringMessagesBeforePublishing) {
        this.filteringMessagesBeforePublishing = filteringMessagesBeforePublishing;
        return this;
    }

    /**
     * Get the isAnonymousAccessible property: A value indicating if the resource can be accessed without authorization.
     * 
     * @return the isAnonymousAccessible value.
     */
    @Generated
    public Boolean isAnonymousAccessible() {
        return this.isAnonymousAccessible;
    }

    /**
     * Set the isAnonymousAccessible property: A value indicating if the resource can be accessed without authorization.
     * 
     * @param isAnonymousAccessible the isAnonymousAccessible value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setIsAnonymousAccessible(Boolean isAnonymousAccessible) {
        this.isAnonymousAccessible = isAnonymousAccessible;
        return this;
    }

    /**
     * Get the authorizationRules property: Authorization rules for resource.
     * 
     * @return the authorizationRules value.
     */
    @Generated
    public List<AuthorizationRule> getAuthorizationRules() {
        if (this.authorizationRules == null) {
            this.authorizationRules = new ArrayList<>();
        }
        return this.authorizationRules;
    }

    /**
     * Set the authorizationRules property: Authorization rules for resource.
     * 
     * @param authorizationRules the authorizationRules value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setAuthorizationRules(List<AuthorizationRule> authorizationRules) {
        this.authorizationRules = authorizationRules;
        return this;
    }

    /**
     * Get the status property: Status of a Service Bus resource.
     * 
     * @return the status value.
     */
    @Generated
    public EntityStatus getStatus() {
        return this.status;
    }

    /**
     * Set the status property: Status of a Service Bus resource.
     * 
     * @param status the status value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setStatus(EntityStatus status) {
        this.status = status;
        return this;
    }

    /**
     * Get the createdAt property: The exact time the topic was created.
     * 
     * @return the createdAt value.
     */
    @Generated
    public OffsetDateTime getCreatedAt() {
        return this.createdAt;
    }

    /**
     * Set the createdAt property: The exact time the topic was created.
     * 
     * @param createdAt the createdAt value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setCreatedAt(OffsetDateTime createdAt) {
        this.createdAt = createdAt;
        return this;
    }

    /**
     * Get the updatedAt property: The exact time a message was updated in the topic.
     * 
     * @return the updatedAt value.
     */
    @Generated
    public OffsetDateTime getUpdatedAt() {
        return this.updatedAt;
    }

    /**
     * Set the updatedAt property: The exact time a message was updated in the topic.
     * 
     * @param updatedAt the updatedAt value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setUpdatedAt(OffsetDateTime updatedAt) {
        this.updatedAt = updatedAt;
        return this;
    }

    /**
     * Get the accessedAt property: Last time a message was sent, or the last time there was a receive request to this
     * topic.
     * 
     * @return the accessedAt value.
     */
    @Generated
    public OffsetDateTime getAccessedAt() {
        return this.accessedAt;
    }

    /**
     * Set the accessedAt property: Last time a message was sent, or the last time there was a receive request to this
     * topic.
     * 
     * @param accessedAt the accessedAt value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setAccessedAt(OffsetDateTime accessedAt) {
        this.accessedAt = accessedAt;
        return this;
    }

    /**
     * Get the supportOrdering property: Indicates if messages are received in the same order they are sent. If
     * partitioned topics, defaults to false, and setting it to true has no effect. For unpartitioned topics, setting it
     * to false will improve perf, but messages may not be received in the order they are sent.
     * 
     * @return the supportOrdering value.
     */
    @Generated
    public Boolean isSupportOrdering() {
        return this.supportOrdering;
    }

    /**
     * Set the supportOrdering property: Indicates if messages are received in the same order they are sent. If
     * partitioned topics, defaults to false, and setting it to true has no effect. For unpartitioned topics, setting it
     * to false will improve perf, but messages may not be received in the order they are sent.
     * 
     * @param supportOrdering the supportOrdering value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setSupportOrdering(Boolean supportOrdering) {
        this.supportOrdering = supportOrdering;
        return this;
    }

    /**
     * Get the messageCountDetails property: Details about the message counts in entity.
     * 
     * @return the messageCountDetails value.
     */
    @Generated
    public MessageCountDetails getMessageCountDetails() {
        return this.messageCountDetails;
    }

    /**
     * Set the messageCountDetails property: Details about the message counts in entity.
     * 
     * @param messageCountDetails the messageCountDetails value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setMessageCountDetails(MessageCountDetails messageCountDetails) {
        this.messageCountDetails = messageCountDetails;
        return this;
    }

    /**
     * Get the subscriptionCount property: The number of subscriptions in the topic.
     * 
     * @return the subscriptionCount value.
     */
    @Generated
    public Integer getSubscriptionCount() {
        return this.subscriptionCount;
    }

    /**
     * Set the subscriptionCount property: The number of subscriptions in the topic.
     * 
     * @param subscriptionCount the subscriptionCount value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setSubscriptionCount(Integer subscriptionCount) {
        this.subscriptionCount = subscriptionCount;
        return this;
    }

    /**
     * Get the autoDeleteOnIdle property: ISO 8601 timeSpan idle interval after which the topic is automatically
     * deleted. The minimum duration is 5 minutes.
     * 
     * @return the autoDeleteOnIdle value.
     */
    @Generated
    public Duration getAutoDeleteOnIdle() {
        return this.autoDeleteOnIdle;
    }

    /**
     * Set the autoDeleteOnIdle property: ISO 8601 timeSpan idle interval after which the topic is automatically
     * deleted. The minimum duration is 5 minutes.
     * 
     * @param autoDeleteOnIdle the autoDeleteOnIdle value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setAutoDeleteOnIdle(Duration autoDeleteOnIdle) {
        this.autoDeleteOnIdle = autoDeleteOnIdle;
        return this;
    }

    /**
     * Get the enablePartitioning property: A value that indicates whether the topic is to be partitioned across
     * multiple message brokers.
     * 
     * @return the enablePartitioning value.
     */
    @Generated
    public Boolean isEnablePartitioning() {
        return this.enablePartitioning;
    }

    /**
     * Set the enablePartitioning property: A value that indicates whether the topic is to be partitioned across
     * multiple message brokers.
     * 
     * @param enablePartitioning the enablePartitioning value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setEnablePartitioning(Boolean enablePartitioning) {
        this.enablePartitioning = enablePartitioning;
        return this;
    }

    /**
     * Get the entityAvailabilityStatus property: Availability status of the entity.
     * 
     * @return the entityAvailabilityStatus value.
     */
    @Generated
    public EntityAvailabilityStatus getEntityAvailabilityStatus() {
        return this.entityAvailabilityStatus;
    }

    /**
     * Set the entityAvailabilityStatus property: Availability status of the entity.
     * 
     * @param entityAvailabilityStatus the entityAvailabilityStatus value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setEntityAvailabilityStatus(EntityAvailabilityStatus entityAvailabilityStatus) {
        this.entityAvailabilityStatus = entityAvailabilityStatus;
        return this;
    }

    /**
     * Get the enableSubscriptionPartitioning property: A value that indicates whether the topic's subscription is to be
     * partitioned.
     * 
     * @return the enableSubscriptionPartitioning value.
     */
    @Generated
    public Boolean isEnableSubscriptionPartitioning() {
        return this.enableSubscriptionPartitioning;
    }

    /**
     * Set the enableSubscriptionPartitioning property: A value that indicates whether the topic's subscription is to be
     * partitioned.
     * 
     * @param enableSubscriptionPartitioning the enableSubscriptionPartitioning value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setEnableSubscriptionPartitioning(Boolean enableSubscriptionPartitioning) {
        this.enableSubscriptionPartitioning = enableSubscriptionPartitioning;
        return this;
    }

    /**
     * Get the enableExpress property: A value that indicates whether Express Entities are enabled. An express topic
     * holds a message in memory temporarily before writing it to persistent storage.
     * 
     * @return the enableExpress value.
     */
    @Generated
    public Boolean isEnableExpress() {
        return this.enableExpress;
    }

    /**
     * Set the enableExpress property: A value that indicates whether Express Entities are enabled. An express topic
     * holds a message in memory temporarily before writing it to persistent storage.
     * 
     * @param enableExpress the enableExpress value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setEnableExpress(Boolean enableExpress) {
        this.enableExpress = enableExpress;
        return this;
    }

    /**
     * Get the userMetadata property: Metadata associated with the topic.
     * 
     * @return the userMetadata value.
     */
    @Generated
    public String getUserMetadata() {
        return this.userMetadata;
    }

    /**
     * Set the userMetadata property: Metadata associated with the topic.
     * 
     * @param userMetadata the userMetadata value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setUserMetadata(String userMetadata) {
        this.userMetadata = userMetadata;
        return this;
    }

    /**
     * Get the maxMessageSizeInKilobytes property: The maximum size in kilobytes of message payload that can be accepted
     * by the topic.
     * 
     * @return the maxMessageSizeInKilobytes value.
     */
    @Generated
    public Long getMaxMessageSizeInKilobytes() {
        return this.maxMessageSizeInKilobytes;
    }

    /**
     * Set the maxMessageSizeInKilobytes property: The maximum size in kilobytes of message payload that can be accepted
     * by the topic.
     * 
     * @param maxMessageSizeInKilobytes the maxMessageSizeInKilobytes value to set.
     * @return the TopicDescription object itself.
     */
    @Generated
    public TopicDescription setMaxMessageSizeInKilobytes(Long maxMessageSizeInKilobytes) {
        this.maxMessageSizeInKilobytes = maxMessageSizeInKilobytes;
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
        rootElementName = rootElementName == null || rootElementName.isEmpty() ? "TopicDescription" : rootElementName;
        xmlWriter.writeStartElement(rootElementName);
        xmlWriter.writeNamespace(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT);
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "DefaultMessageTimeToLive",
            CoreUtils.durationToStringWithDays(this.defaultMessageTimeToLive));
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "MaxSizeInMegabytes",
            this.maxSizeInMegabytes);
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "RequiresDuplicateDetection",
            this.requiresDuplicateDetection);
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "DuplicateDetectionHistoryTimeWindow",
            CoreUtils.durationToStringWithDays(this.duplicateDetectionHistoryTimeWindow));
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "EnableBatchedOperations",
            this.enableBatchedOperations);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "SizeInBytes", this.sizeInBytes);
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "FilteringMessagesBeforePublishing",
            this.filteringMessagesBeforePublishing);
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "IsAnonymousAccessible",
            this.isAnonymousAccessible);
        if (this.authorizationRules != null) {
            xmlWriter.writeStartElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "AuthorizationRules");
            for (AuthorizationRule element : this.authorizationRules) {
                xmlWriter.writeXml(element, "AuthorizationRule");
            }
            xmlWriter.writeEndElement();
        }
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "Status",
            this.status == null ? null : this.status.toString());
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "CreatedAt",
            this.createdAt == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.createdAt));
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "UpdatedAt",
            this.updatedAt == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.updatedAt));
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "AccessedAt",
            this.accessedAt == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(this.accessedAt));
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "SupportOrdering",
            this.supportOrdering);
        xmlWriter.writeXml(this.messageCountDetails, "CountDetails");
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "SubscriptionCount",
            this.subscriptionCount);
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "AutoDeleteOnIdle",
            CoreUtils.durationToStringWithDays(this.autoDeleteOnIdle));
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "EnablePartitioning",
            this.enablePartitioning);
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "EntityAvailabilityStatus",
            this.entityAvailabilityStatus == null ? null : this.entityAvailabilityStatus.toString());
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "EnableSubscriptionPartitioning",
            this.enableSubscriptionPartitioning);
        xmlWriter.writeBooleanElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "EnableExpress", this.enableExpress);
        xmlWriter.writeStringElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "UserMetadata", this.userMetadata);
        xmlWriter.writeNumberElement(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, "MaxMessageSizeInKilobytes",
            this.maxMessageSizeInKilobytes);
        return xmlWriter.writeEndElement();
    }

    /**
     * Reads an instance of TopicDescription from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @return An instance of TopicDescription if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the TopicDescription.
     */
    @Generated
    public static TopicDescription fromXml(XmlReader xmlReader) throws XMLStreamException {
        return fromXml(xmlReader, null);
    }

    /**
     * Reads an instance of TopicDescription from the XmlReader.
     * 
     * @param xmlReader The XmlReader being read.
     * @param rootElementName Optional root element name to override the default defined by the model. Used to support
     * cases where the model can deserialize from different root element names.
     * @return An instance of TopicDescription if the XmlReader was pointing to an instance of it, or null if it was
     * pointing to XML null.
     * @throws XMLStreamException If an error occurs while reading the TopicDescription.
     */
    @Generated
    public static TopicDescription fromXml(XmlReader xmlReader, String rootElementName) throws XMLStreamException {
        String finalRootElementName
            = rootElementName == null || rootElementName.isEmpty() ? "TopicDescription" : rootElementName;
        return xmlReader.readObject(SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT, finalRootElementName, reader -> {
            TopicDescription deserializedTopicDescription = new TopicDescription();
            while (reader.nextElement() != XmlToken.END_ELEMENT) {
                QName elementName = reader.getElementName();

                if ("DefaultMessageTimeToLive".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.defaultMessageTimeToLive = reader.getNullableElement(Duration::parse);
                } else if ("MaxSizeInMegabytes".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.maxSizeInMegabytes = reader.getNullableElement(Long::parseLong);
                } else if ("RequiresDuplicateDetection".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.requiresDuplicateDetection
                        = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("DuplicateDetectionHistoryTimeWindow".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.duplicateDetectionHistoryTimeWindow
                        = reader.getNullableElement(Duration::parse);
                } else if ("EnableBatchedOperations".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.enableBatchedOperations
                        = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("SizeInBytes".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.sizeInBytes = reader.getNullableElement(Long::parseLong);
                } else if ("FilteringMessagesBeforePublishing".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.filteringMessagesBeforePublishing
                        = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("IsAnonymousAccessible".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.isAnonymousAccessible
                        = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("AuthorizationRules".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    while (reader.nextElement() != XmlToken.END_ELEMENT) {
                        elementName = reader.getElementName();
                        if ("AuthorizationRule".equals(elementName.getLocalPart())
                            && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                            if (deserializedTopicDescription.authorizationRules == null) {
                                deserializedTopicDescription.authorizationRules = new ArrayList<>();
                            }
                            deserializedTopicDescription.authorizationRules
                                .add(AuthorizationRule.fromXml(reader, "AuthorizationRule"));
                        } else {
                            reader.skipElement();
                        }
                    }
                } else if ("Status".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.status = EntityStatus.fromString(reader.getStringElement());
                } else if ("CreatedAt".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.createdAt
                        = reader.getNullableElement(dateString -> CoreUtils.parseBestOffsetDateTime(dateString));
                } else if ("UpdatedAt".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.updatedAt
                        = reader.getNullableElement(dateString -> CoreUtils.parseBestOffsetDateTime(dateString));
                } else if ("AccessedAt".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.accessedAt
                        = reader.getNullableElement(dateString -> CoreUtils.parseBestOffsetDateTime(dateString));
                } else if ("SupportOrdering".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.supportOrdering = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("CountDetails".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.messageCountDetails
                        = MessageCountDetails.fromXml(reader, "CountDetails");
                } else if ("SubscriptionCount".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.subscriptionCount = reader.getNullableElement(Integer::parseInt);
                } else if ("AutoDeleteOnIdle".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.autoDeleteOnIdle = reader.getNullableElement(Duration::parse);
                } else if ("EnablePartitioning".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.enablePartitioning = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("EntityAvailabilityStatus".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.entityAvailabilityStatus
                        = EntityAvailabilityStatus.fromString(reader.getStringElement());
                } else if ("EnableSubscriptionPartitioning".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.enableSubscriptionPartitioning
                        = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("EnableExpress".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.enableExpress = reader.getNullableElement(Boolean::parseBoolean);
                } else if ("UserMetadata".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.userMetadata = reader.getStringElement();
                } else if ("MaxMessageSizeInKilobytes".equals(elementName.getLocalPart())
                    && SCHEMAS_MICROSOFT_COM_SERVICEBUS_CONNECT.equals(elementName.getNamespaceURI())) {
                    deserializedTopicDescription.maxMessageSizeInKilobytes = reader.getNullableElement(Long::parseLong);
                } else {
                    reader.skipElement();
                }
            }

            return deserializedTopicDescription;
        });
    }
}
