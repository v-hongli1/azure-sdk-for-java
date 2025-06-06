// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.messaging.servicebus.administration.models;

import com.azure.messaging.servicebus.administration.implementation.EntityHelper;
import com.azure.messaging.servicebus.administration.implementation.models.SubscriptionDescription;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.azure.messaging.servicebus.implementation.ServiceBusConstants.DEFAULT_LOCK_DURATION;
import static com.azure.messaging.servicebus.implementation.ServiceBusConstants.DEFAULT_MAX_DELIVERY_COUNT;
import static com.azure.messaging.servicebus.implementation.ServiceBusConstants.MAX_DURATION;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class CreateSubscriptionOptionsTest {
    /**
     * Creates an instance with the given defaults.
     */
    @Test
    void constructor() {
        // Act
        final CreateSubscriptionOptions actual = new CreateSubscriptionOptions();

        // Assert
        assertEquals(MAX_DURATION, actual.getAutoDeleteOnIdle());
        assertEquals(MAX_DURATION, actual.getDefaultMessageTimeToLive());
        assertTrue(actual.isBatchedOperationsEnabled());
        assertEquals(DEFAULT_LOCK_DURATION, actual.getLockDuration());
        assertEquals(DEFAULT_MAX_DELIVERY_COUNT, actual.getMaxDeliveryCount());
        assertFalse(actual.isSessionRequired());
        assertFalse(actual.isDeadLetteringOnMessageExpiration());
        assertEquals(EntityStatus.ACTIVE, actual.getStatus());
        assertNull(actual.getUserMetadata());
    }

    @Test
    void constructorWithOptions() {
        // Arrange
        final SubscriptionDescription description
            = new SubscriptionDescription().setAutoDeleteOnIdle(Duration.ofSeconds(15))
                .setDefaultMessageTimeToLive(Duration.ofSeconds(50))
                .setEnableBatchedOperations(false)
                .setForwardTo("Forward-To-This-Queue")
                .setForwardDeadLetteredMessagesTo("Dead-Lettered-Forward-To")
                .setLockDuration(Duration.ofSeconds(120))
                .setMaxDeliveryCount(15)
                .setRequiresSession(true)
                .setStatus(EntityStatus.DELETING)
                .setUserMetadata("Test-queue-Metadata");

        final SubscriptionProperties expected = EntityHelper.toModel(description);

        // Act
        final CreateSubscriptionOptions actual = new CreateSubscriptionOptions(expected);

        // Assert
        assertEquals(expected.getAutoDeleteOnIdle(), actual.getAutoDeleteOnIdle());
        assertEquals(expected.getDefaultMessageTimeToLive(), actual.getDefaultMessageTimeToLive());
        assertFalse(actual.isDeadLetteringOnMessageExpiration());
        assertEquals(expected.isBatchedOperationsEnabled(), actual.isBatchedOperationsEnabled());
        assertEquals(expected.getForwardTo(), actual.getForwardTo());
        assertEquals(expected.getForwardDeadLetteredMessagesTo(), actual.getForwardDeadLetteredMessagesTo());
        assertEquals(expected.getLockDuration(), actual.getLockDuration());
        assertEquals(expected.getMaxDeliveryCount(), actual.getMaxDeliveryCount());
        assertEquals(expected.isSessionRequired(), actual.isSessionRequired());
        assertEquals(expected.getStatus(), actual.getStatus());
        assertEquals(expected.getUserMetadata(), actual.getUserMetadata());
    }
}
