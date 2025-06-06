// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.communication.phonenumbers;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.azure.communication.phonenumbers.models.AvailablePhoneNumber;
import com.azure.communication.phonenumbers.models.BrowsePhoneNumbersOptions;
import com.azure.communication.phonenumbers.models.CreateOrUpdateReservationOptions;
import com.azure.communication.phonenumbers.models.PhoneNumberAssignmentType;
import com.azure.communication.phonenumbers.models.PhoneNumberCapabilities;
import com.azure.communication.phonenumbers.models.PhoneNumberCapabilityType;
import com.azure.communication.phonenumbers.models.PhoneNumberOperation;
import com.azure.communication.phonenumbers.models.PhoneNumberSearchOptions;
import com.azure.communication.phonenumbers.models.PhoneNumberSearchResult;
import com.azure.communication.phonenumbers.models.PhoneNumberType;
import com.azure.communication.phonenumbers.models.PhoneNumbersBrowseResult;
import com.azure.communication.phonenumbers.models.PhoneNumbersReservation;
import com.azure.communication.phonenumbers.models.PurchasedPhoneNumber;
import com.azure.core.credential.AzureKeyCredential;
import com.azure.core.http.HttpClient;
import com.azure.core.http.netty.NettyAsyncHttpClientBuilder;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.util.Context;
import com.azure.core.util.polling.LongRunningOperationStatus;
import com.azure.core.util.polling.PollResponse;
import com.azure.core.util.polling.SyncPoller;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class ReadmeSamples {

    /**
     * Sample code for creating a sync Phone Number Client.
     *
     * @return the Phone Number Client.
     */
    public PhoneNumbersClient createPhoneNumberClient() {
        // BEGIN: readme-sample-createPhoneNumberClient
        // You can find your endpoint and access token from your resource in the Azure Portal
        String endpoint = "https://<RESOURCE_NAME>.communication.azure.com";
        AzureKeyCredential keyCredential = new AzureKeyCredential("SECRET");

        // Create an HttpClient builder of your choice and customize it
        HttpClient httpClient = new NettyAsyncHttpClientBuilder().build();

        PhoneNumbersClient phoneNumberClient = new PhoneNumbersClientBuilder()
            .endpoint(endpoint)
            .credential(keyCredential)
            .httpClient(httpClient)
            .buildClient();
        // END: readme-sample-createPhoneNumberClient

        return phoneNumberClient;
    }

    /**
     * Sample code for creating a sync Communication Identity Client using AAD authentication.
     *
     * @return the Phone Number Client.
     */
    public PhoneNumbersClient createPhoneNumberClientWithAAD() {
        // BEGIN: readme-sample-createPhoneNumberClientWithAAD
        // You can find your endpoint and access key from your resource in the Azure Portal
        String endpoint = "https://<RESOURCE_NAME>.communication.azure.com";

        // Create an HttpClient builder of your choice and customize it
        HttpClient httpClient = new NettyAsyncHttpClientBuilder().build();

        PhoneNumbersClient phoneNumberClient = new PhoneNumbersClientBuilder()
            .endpoint(endpoint)
            .credential(new DefaultAzureCredentialBuilder().build())
            .httpClient(httpClient)
            .buildClient();
        // END: readme-sample-createPhoneNumberClientWithAAD

        return phoneNumberClient;
    }

    /**
     * Sample code for getting an purchased phone number.
     *
     * @return the purchased phone number.
     */
    public PurchasedPhoneNumber getPurchasedPhoneNumber() {
        PhoneNumbersClient phoneNumberClient = createPhoneNumberClient();

        // BEGIN: readme-sample-getPurchasedPhoneNumber
        PurchasedPhoneNumber phoneNumber = phoneNumberClient.getPurchasedPhoneNumber("+18001234567");
        System.out.println("Phone Number Value: " + phoneNumber.getPhoneNumber());
        System.out.println("Phone Number Country Code: " + phoneNumber.getCountryCode());
        // END: readme-sample-getPurchasedPhoneNumber

        return phoneNumber;
    }

    /**
     * Sample code for browsing and reserving available phone numbers and purchasing
     * the reservation.
     *
     */
    public void browseAndReservePhoneNumbers() {
        // BEGIN: readme-sample-browseAndReservePhoneNumbers
        PhoneNumbersClient phoneNumberClient = createPhoneNumberClient();
        String reservationId = UUID.randomUUID().toString();

        BrowsePhoneNumbersOptions browseRequest = new BrowsePhoneNumbersOptions("US", PhoneNumberType.TOLL_FREE)
                .setAssignmentType(PhoneNumberAssignmentType.APPLICATION)
                .setCapabilities(new PhoneNumberCapabilities().setCalling(PhoneNumberCapabilityType.INBOUND_OUTBOUND)
                        .setSms(PhoneNumberCapabilityType.INBOUND_OUTBOUND));

        PhoneNumbersBrowseResult result = phoneNumberClient.browseAvailableNumbers(browseRequest);

        List<AvailablePhoneNumber> numbersToAdd = new ArrayList<>();

        numbersToAdd.add(result.getPhoneNumbers().get(0));

        PhoneNumbersReservation reservationResponse = phoneNumberClient.createOrUpdateReservation(
                new CreateOrUpdateReservationOptions(reservationId).setPhoneNumbersToAdd(numbersToAdd));
        System.out.println("Reservation ID: " + reservationResponse.getId());
        // END: readme-sample-browseAndReservePhoneNumbers

        // BEGIN: readme-sample-purchaseReservation
        PollResponse<PhoneNumberOperation> purchaseResponse =
            phoneNumberClient.beginReservationPurchase(reservationId, Context.NONE).waitForCompletion();
        System.out.println("Purchase reservation is complete: " + purchaseResponse.getStatus());
        // END: readme-sample-purchaseReservation
    }

    /**
     * Sample code for listing all purchased phone numbers.
     *
     * @return all purchased phone number.
     */
    public PagedIterable<PurchasedPhoneNumber> listPhoneNumbers() {
        // BEGIN: readme-sample-listPhoneNumbers
        PagedIterable<PurchasedPhoneNumber> phoneNumbers = createPhoneNumberClient().listPurchasedPhoneNumbers(Context.NONE);
        PurchasedPhoneNumber phoneNumber = phoneNumbers.iterator().next();
        System.out.println("Phone Number Value: " + phoneNumber.getPhoneNumber());
        System.out.println("Phone Number Country Code: " + phoneNumber.getCountryCode());
        // END: readme-sample-listPhoneNumbers

        return phoneNumbers;
    }

    /**
     * Search for available phone numbers and purchase phone numbers
     */
    public void searchAvailablePhoneNumbersAndPurchasePhoneNumbers() {
        // BEGIN: readme-sample-searchAvailablePhoneNumbers
        PhoneNumbersClient phoneNumberClient = createPhoneNumberClient();
        PhoneNumberCapabilities capabilities = new PhoneNumberCapabilities()
            .setCalling(PhoneNumberCapabilityType.INBOUND)
            .setSms(PhoneNumberCapabilityType.INBOUND_OUTBOUND);
        PhoneNumberSearchOptions searchOptions = new PhoneNumberSearchOptions().setAreaCode("800").setQuantity(1);

        SyncPoller<PhoneNumberOperation, PhoneNumberSearchResult> poller = phoneNumberClient
            .beginSearchAvailablePhoneNumbers("US", PhoneNumberType.TOLL_FREE, PhoneNumberAssignmentType.APPLICATION, capabilities, searchOptions, Context.NONE);
        PollResponse<PhoneNumberOperation> response = poller.waitForCompletion();
        String searchId = "";

        if (LongRunningOperationStatus.SUCCESSFULLY_COMPLETED == response.getStatus()) {
            PhoneNumberSearchResult searchResult = poller.getFinalResult();
            searchId = searchResult.getSearchId();
            System.out.println("Searched phone numbers: " + searchResult.getPhoneNumbers());
            System.out.println("Search expires by: " + searchResult.getSearchExpiresBy());
            System.out.println("Phone number costs:" + searchResult.getCost().getAmount());
        }
        // END: readme-sample-searchAvailablePhoneNumbers

        // BEGIN: readme-sample-purchasePhoneNumbers
        PollResponse<PhoneNumberOperation> purchaseResponse =
            phoneNumberClient.beginPurchasePhoneNumbers(searchId, Context.NONE).waitForCompletion();
        System.out.println("Purchase phone numbers is complete: " + purchaseResponse.getStatus());
        // END: readme-sample-purchasePhoneNumbers
    }

    /**
     * Release acquired phone number
     */
    public void releasePhoneNumber() {
        PhoneNumbersClient phoneNumberClient = createPhoneNumberClient();

        // BEGIN: readme-sample-releasePhoneNumber
        PollResponse<PhoneNumberOperation> releaseResponse =
            phoneNumberClient.beginReleasePhoneNumber("+18001234567", Context.NONE).waitForCompletion();
        System.out.println("Release phone number is complete: " + releaseResponse.getStatus());
        // END: readme-sample-releasePhoneNumber
    }

    /**
     * Update phone number capabilities
     */
    public void updatePhoneNumberCapabilities() {
        PhoneNumbersClient phoneNumberClient = createPhoneNumberClient();

        // BEGIN: readme-sample-updatePhoneNumberCapabilities
        PhoneNumberCapabilities capabilities = new PhoneNumberCapabilities();
        capabilities
            .setCalling(PhoneNumberCapabilityType.INBOUND)
            .setSms(PhoneNumberCapabilityType.INBOUND_OUTBOUND);

        SyncPoller<PhoneNumberOperation, PurchasedPhoneNumber> poller = phoneNumberClient.beginUpdatePhoneNumberCapabilities("+18001234567", capabilities, Context.NONE);
        PollResponse<PhoneNumberOperation> response = poller.waitForCompletion();

        if (LongRunningOperationStatus.SUCCESSFULLY_COMPLETED == response.getStatus()) {
            PurchasedPhoneNumber phoneNumber = poller.getFinalResult();
            System.out.println("Phone Number Calling capabilities: " + phoneNumber.getCapabilities().getCalling()); //Phone Number Calling capabilities: inbound
            System.out.println("Phone Number SMS capabilities: " + phoneNumber.getCapabilities().getSms()); //Phone Number SMS capabilities: inbound+outbound
        }
        // END: readme-sample-updatePhoneNumberCapabilities
    }
}
