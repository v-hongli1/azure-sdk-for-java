// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.ai.documentintelligence.generated;

import com.azure.ai.documentintelligence.DocumentIntelligenceAdministrationClient;
import com.azure.ai.documentintelligence.DocumentIntelligenceAdministrationClientBuilder;
import com.azure.ai.documentintelligence.models.DocumentModelDetails;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class GetPrebuiltDocumentModel {
    public static void main(String[] args) {
        DocumentIntelligenceAdministrationClient documentIntelligenceAdministrationClient
            = new DocumentIntelligenceAdministrationClientBuilder()
                .credential(new DefaultAzureCredentialBuilder().build())
                .endpoint("https://myendpoint.cognitiveservices.azure.com")
                .buildClient();
        // BEGIN:com.azure.ai.documentintelligence.generated.get-model.get-prebuilt-document-model
        DocumentModelDetails response = documentIntelligenceAdministrationClient.getModel("prebuilt-invoice");
        // END:com.azure.ai.documentintelligence.generated.get-model.get-prebuilt-document-model
    }
}
