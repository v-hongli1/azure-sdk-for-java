// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.analytics.purview.workflow.generated;

import com.azure.analytics.purview.workflow.ApprovalClient;
import com.azure.analytics.purview.workflow.ApprovalClientBuilder;
import com.azure.core.http.rest.RequestOptions;
import com.azure.core.http.rest.Response;
import com.azure.core.util.BinaryData;
import com.azure.core.util.Configuration;
import com.azure.identity.DefaultAzureCredentialBuilder;

public class ApprovalApprove {
    public static void main(String[] args) {
        ApprovalClient approvalClient
            = new ApprovalClientBuilder().credential(new DefaultAzureCredentialBuilder().build())
                .endpoint(Configuration.getGlobalConfiguration().get("ENDPOINT"))
                .buildClient();
        // BEGIN:com.azure.analytics.purview.workflow.generated.approval-approve.approval-approve
        BinaryData approvalResponseComment = BinaryData.fromString("{\"comment\":\"Thanks for raising this!\"}");
        RequestOptions requestOptions = new RequestOptions();
        Response<Void> response = approvalClient.approveWithResponse("98d98e2c-23fa-4157-a3f8-ff8ce5cc095c",
            approvalResponseComment, requestOptions);
        // END:com.azure.analytics.purview.workflow.generated.approval-approve.approval-approve
    }
}
