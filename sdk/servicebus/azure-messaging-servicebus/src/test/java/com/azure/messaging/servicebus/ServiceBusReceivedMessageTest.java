// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.messaging.servicebus;

import com.azure.core.amqp.AmqpMessageConstant;
import com.azure.core.util.BinaryData;
import com.azure.messaging.servicebus.models.ServiceBusMessageState;
import org.apache.qpid.proton.amqp.Binary;
import org.apache.qpid.proton.amqp.messaging.Data;
import org.apache.qpid.proton.message.Message;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Map;
import java.util.stream.Stream;

import static com.azure.core.amqp.AmqpMessageConstant.DEAD_LETTER_DESCRIPTION_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.DEAD_LETTER_REASON_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.DEAD_LETTER_SOURCE_KEY_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.ENQUEUED_SEQUENCE_NUMBER_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.ENQUEUED_TIME_UTC_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.LOCKED_UNTIL_KEY_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.SCHEDULED_ENQUEUE_UTC_TIME_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.SEQUENCE_NUMBER_ANNOTATION_NAME;
import static com.azure.core.amqp.AmqpMessageConstant.MESSAGE_STATE_ANNOTATION_NAME;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServiceBusReceivedMessageTest {

    // Create a giant payload with 10000 characters that are "a".
    private static final String PAYLOAD = new String(new char[10000]).replace("\0", "a");
    private static final byte[] PAYLOAD_BYTES = PAYLOAD.getBytes(UTF_8);
    private static final BinaryData PAYLOAD_BINARY = BinaryData.fromString(PAYLOAD);

    @Test
    public void messagePropertiesShouldNotBeNull() {
        // Act
        final ServiceBusReceivedMessage receivedMessage = new ServiceBusReceivedMessage(PAYLOAD_BINARY);

        // Assert
        assertNotNull(receivedMessage.getBody());
        assertNotNull(receivedMessage.getApplicationProperties());
    }

    /**
     * Verify that we can create an Message with an empty byte array.
     */
    @Test
    public void canCreateWithEmptyArray() {
        // Arrange
        byte[] byteArray = new byte[0];

        // Act
        final ServiceBusReceivedMessage serviceBusMessageData
            = new ServiceBusReceivedMessage(BinaryData.fromBytes(byteArray));

        // Assert
        final byte[] actual = serviceBusMessageData.getBody().toBytes();
        assertNotNull(actual);
        assertEquals(0, actual.length);
    }

    /**
     * Verify that we can create an Message with the correct body contents.
     */
    @Test
    public void canCreateWithBinaryDataPayload() {
        // Act
        final ServiceBusReceivedMessage serviceBusMessageData = new ServiceBusReceivedMessage(PAYLOAD_BINARY);

        // Assert
        assertNotNull(serviceBusMessageData.getBody());
        assertEquals(PAYLOAD, serviceBusMessageData.getBody().toString());
    }

    /**
     * Verify that we can create an Message with the correct byte array contents.
     */
    @Test
    public void canCreateWithByteArrayPayload() {
        // Act
        final ServiceBusReceivedMessage serviceBusMessageData = new ServiceBusReceivedMessage(PAYLOAD_BINARY);

        // Assert
        assertNotNull(serviceBusMessageData.getBody());
        assertArrayEquals(PAYLOAD_BYTES, serviceBusMessageData.getBody().toBytes());
    }

    @Test
    public void toServiceBusMessageTest() {
        //Arrange
        Message amqpMessage = mock(Message.class);
        Data data = new Data(new Binary(PAYLOAD_BYTES));
        when(amqpMessage.getBody()).thenReturn(data);
        //
        final ServiceBusReceivedMessage originalMessage = new ServiceBusReceivedMessage(PAYLOAD_BINARY);
        originalMessage.setMessageId("mid");
        originalMessage.setContentType("type");
        originalMessage.setCorrelationId("cid");
        originalMessage.setReplyTo("rto");
        originalMessage.setTimeToLive(Duration.ofSeconds(10));
        originalMessage.setReplyToSessionId("rsessionid");
        originalMessage.setSubject("subject");
        originalMessage.setTo("to");
        final Map<String, Object> originalMessageAnnotations
            = originalMessage.getRawAmqpMessage().getMessageAnnotations();
        originalMessageAnnotations.put(DEAD_LETTER_SOURCE_KEY_ANNOTATION_NAME.getValue(), "message annotations");
        originalMessageAnnotations.put(ENQUEUED_SEQUENCE_NUMBER_ANNOTATION_NAME.getValue(), Long.valueOf(3));
        originalMessageAnnotations.put(LOCKED_UNTIL_KEY_ANNOTATION_NAME.getValue(),
            new Date(Instant.now().toEpochMilli()));
        originalMessageAnnotations.put(ENQUEUED_TIME_UTC_ANNOTATION_NAME.getValue(),
            new Date(Instant.now().toEpochMilli()));
        originalMessageAnnotations.put(SCHEDULED_ENQUEUE_UTC_TIME_NAME.getValue(),
            new Date(Instant.now().toEpochMilli()));
        originalMessageAnnotations.put(SEQUENCE_NUMBER_ANNOTATION_NAME.getValue(), Long.valueOf(3));

        final Map<String, Object> originalApplicationProperties
            = originalMessage.getRawAmqpMessage().getApplicationProperties();
        originalApplicationProperties.put(DEAD_LETTER_DESCRIPTION_ANNOTATION_NAME.getValue(), "description");
        originalApplicationProperties.put(DEAD_LETTER_REASON_ANNOTATION_NAME.getValue(), "description");

        originalMessage.getRawAmqpMessage().getHeader().setDeliveryCount(Long.valueOf(5));

        // Act
        final ServiceBusMessage actual = new ServiceBusMessage(originalMessage);

        // Assert
        assertNotNull(actual);
        assertNotNull(actual.getBody());
        assertEquals(PAYLOAD, actual.getBody().toString());
        assertEquals(originalMessage.getMessageId(), actual.getMessageId());
        assertEquals(originalMessage.getContentType(), actual.getContentType());
        assertEquals(originalMessage.getCorrelationId(), actual.getCorrelationId());
        assertEquals(originalMessage.getReplyTo(), actual.getReplyTo());
        assertEquals(originalMessage.getTimeToLive().toMillis(), actual.getTimeToLive().toMillis());
        assertEquals(originalMessage.getSubject(), actual.getSubject());
        assertEquals(originalMessage.getReplyToSessionId(), actual.getReplyToSessionId());
        assertEquals(originalMessage.getTo(), actual.getTo());

        // Following values should be cleaned up.
        assertNullValues(actual.getRawAmqpMessage().getMessageAnnotations(), DEAD_LETTER_SOURCE_KEY_ANNOTATION_NAME,
            ENQUEUED_SEQUENCE_NUMBER_ANNOTATION_NAME, LOCKED_UNTIL_KEY_ANNOTATION_NAME, SEQUENCE_NUMBER_ANNOTATION_NAME,
            ENQUEUED_TIME_UTC_ANNOTATION_NAME);

        assertNullValues(actual.getRawAmqpMessage().getApplicationProperties(), DEAD_LETTER_DESCRIPTION_ANNOTATION_NAME,
            DEAD_LETTER_REASON_ANNOTATION_NAME);

        assertNull(actual.getRawAmqpMessage().getHeader().getDeliveryCount());
        assertNull(actual.getScheduledEnqueueTime());
    }

    public static Stream<Arguments> canGetMessageState() {
        return Stream.of(Arguments.of(0, ServiceBusMessageState.ACTIVE),
            Arguments.of(1, ServiceBusMessageState.DEFERRED), Arguments.of(2, ServiceBusMessageState.SCHEDULED));
    }

    @MethodSource
    @ParameterizedTest
    public void canGetMessageState(Integer value, ServiceBusMessageState expected) {
        // Arrange
        final ServiceBusReceivedMessage message = new ServiceBusReceivedMessage(PAYLOAD_BINARY);
        message.getRawAmqpMessage().getMessageAnnotations().put(MESSAGE_STATE_ANNOTATION_NAME.getValue(), value);

        // Act
        final ServiceBusMessageState actual = message.getState();

        // Assert
        assertEquals(expected, actual);
    }

    @Test
    public void defaultMessageState() {
        final ServiceBusReceivedMessage message = new ServiceBusReceivedMessage(PAYLOAD_BINARY);

        assertEquals(ServiceBusMessageState.ACTIVE, message.getState());
    }

    @Test
    public void throwsOnInvalidMessageState() {
        // Arrange
        final ServiceBusReceivedMessage message = new ServiceBusReceivedMessage(PAYLOAD_BINARY);
        message.getRawAmqpMessage().getMessageAnnotations().put(MESSAGE_STATE_ANNOTATION_NAME.getValue(), 10);

        // Act & Assert
        assertThrows(UnsupportedOperationException.class, () -> message.getState());
    }

    public void assertNullValues(Map<String, Object> dataMap, AmqpMessageConstant... keys) {
        for (AmqpMessageConstant key : keys) {
            assertNull(dataMap.get(key.getValue()));
        }
    }
}
