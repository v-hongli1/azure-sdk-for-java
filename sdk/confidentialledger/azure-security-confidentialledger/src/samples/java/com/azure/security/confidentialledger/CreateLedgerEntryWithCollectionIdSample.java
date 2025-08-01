// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.security.confidentialledger;

import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Configuration;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class CreateLedgerEntryWithCollectionIdSample {
    public static void main(String[] args) {
        ConfidentialLedgerClient confidentialLedgerClient =
            new ConfidentialLedgerClientBuilder()
                .credential(new DefaultAzureCredentialBuilder().build())
                .ledgerEndpoint(Configuration.getGlobalConfiguration().get("LEDGERENDPOINT"))
                .buildClient();

        BinaryData entry = BinaryData.fromString("{\"contents\":\"Ledger entry with collectionId.\"}");
        RequestOptions requestOptions = new RequestOptions()
            .addQueryParam("collectionId", "Collection1");
        Response<BinaryData> response = confidentialLedgerClient.createLedgerEntryWithResponse(entry, requestOptions);
    }
}
