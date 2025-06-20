// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.scanning.generated;

import com.azure.analytics.purview.scanning.ClassificationRulesClient;
import com.azure.analytics.purview.scanning.PurviewScanningClientBuilder;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class ClassificationRulesDelete {
    public static void main(String[] args) {
        ClassificationRulesClient classificationRulesClient
            = new PurviewScanningClientBuilder().credential(new DefaultAzureCredentialBuilder().build())
                .endpoint("{Endpoint}")
                .buildClassificationRulesClient();
        // BEGIN:com.azure.analytics.purview.scanning.generated.classification-rules-delete.classification-rules-delete
        RequestOptions requestOptions = new RequestOptions();
        Response<BinaryData> response
            = classificationRulesClient.deleteWithResponse("ClassificationRule1", requestOptions);
        // END:com.azure.analytics.purview.scanning.generated.classification-rules-delete.classification-rules-delete
    }
}
