// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.consumption.models;

import com.azure.resourcemanager.consumption.fluent.models.ReservationTransactionInner;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;

/**
 * An immutable client-side representation of ReservationTransaction.
 */
public interface ReservationTransaction {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    List<String> tags();

    /**
     * Gets the eventDate property: The date of the transaction.
     * 
     * @return the eventDate value.
     */
    OffsetDateTime eventDate();

    /**
     * Gets the reservationOrderId property: The reservation order ID is the identifier for a reservation purchase. Each
     * reservation order ID represents a single purchase transaction. A reservation order contains reservations. The
     * reservation order specifies the VM size and region for the reservations.
     * 
     * @return the reservationOrderId value.
     */
    String reservationOrderId();

    /**
     * Gets the description property: The description of the transaction.
     * 
     * @return the description value.
     */
    String description();

    /**
     * Gets the eventType property: The type of the transaction (Purchase, Cancel or Refund).
     * 
     * @return the eventType value.
     */
    String eventType();

    /**
     * Gets the quantity property: The quantity of the transaction.
     * 
     * @return the quantity value.
     */
    BigDecimal quantity();

    /**
     * Gets the amount property: The charge of the transaction.
     * 
     * @return the amount value.
     */
    BigDecimal amount();

    /**
     * Gets the currency property: The ISO currency in which the transaction is charged, for example, USD.
     * 
     * @return the currency value.
     */
    String currency();

    /**
     * Gets the reservationOrderName property: The name of the reservation order.
     * 
     * @return the reservationOrderName value.
     */
    String reservationOrderName();

    /**
     * Gets the purchasingEnrollment property: The purchasing enrollment.
     * 
     * @return the purchasingEnrollment value.
     */
    String purchasingEnrollment();

    /**
     * Gets the purchasingSubscriptionGuid property: The subscription guid that makes the transaction.
     * 
     * @return the purchasingSubscriptionGuid value.
     */
    UUID purchasingSubscriptionGuid();

    /**
     * Gets the purchasingSubscriptionName property: The subscription name that makes the transaction.
     * 
     * @return the purchasingSubscriptionName value.
     */
    String purchasingSubscriptionName();

    /**
     * Gets the armSkuName property: This is the ARM Sku name. It can be used to join with the serviceType field in
     * additional info in usage records.
     * 
     * @return the armSkuName value.
     */
    String armSkuName();

    /**
     * Gets the term property: This is the term of the transaction.
     * 
     * @return the term value.
     */
    String term();

    /**
     * Gets the region property: The region of the transaction.
     * 
     * @return the region value.
     */
    String region();

    /**
     * Gets the accountName property: The name of the account that makes the transaction.
     * 
     * @return the accountName value.
     */
    String accountName();

    /**
     * Gets the accountOwnerEmail property: The email of the account owner that makes the transaction.
     * 
     * @return the accountOwnerEmail value.
     */
    String accountOwnerEmail();

    /**
     * Gets the departmentName property: The department name.
     * 
     * @return the departmentName value.
     */
    String departmentName();

    /**
     * Gets the costCenter property: The cost center of this department if it is a department and a cost center is
     * provided.
     * 
     * @return the costCenter value.
     */
    String costCenter();

    /**
     * Gets the currentEnrollment property: The current enrollment.
     * 
     * @return the currentEnrollment value.
     */
    String currentEnrollment();

    /**
     * Gets the billingFrequency property: The billing frequency, which can be either one-time or recurring.
     * 
     * @return the billingFrequency value.
     */
    String billingFrequency();

    /**
     * Gets the billingMonth property: The billing month(yyyyMMdd), on which the event initiated.
     * 
     * @return the billingMonth value.
     */
    Integer billingMonth();

    /**
     * Gets the monetaryCommitment property: The monetary commitment amount at the enrollment scope.
     * 
     * @return the monetaryCommitment value.
     */
    BigDecimal monetaryCommitment();

    /**
     * Gets the overage property: The overage amount at the enrollment scope.
     * 
     * @return the overage value.
     */
    BigDecimal overage();

    /**
     * Gets the inner com.azure.resourcemanager.consumption.fluent.models.ReservationTransactionInner object.
     * 
     * @return the inner object.
     */
    ReservationTransactionInner innerModel();
}
