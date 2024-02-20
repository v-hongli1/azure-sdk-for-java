package com.azure;

import com.azure.identity.ManagedIdentityCredential;
import com.azure.identity.ManagedIdentityCredentialBuilder;
import com.azure.storage.blob.BlobServiceClient;
import com.azure.storage.blob.BlobServiceClientBuilder;
import com.microsoft.azure.functions.ExecutionContext;
import com.microsoft.azure.functions.HttpMethod;
import com.microsoft.azure.functions.HttpRequestMessage;
import com.microsoft.azure.functions.HttpResponseMessage;
import com.microsoft.azure.functions.HttpStatus;
import com.microsoft.azure.functions.annotation.AuthorizationLevel;
import com.microsoft.azure.functions.annotation.FunctionName;
import com.microsoft.azure.functions.annotation.HttpTrigger;

import java.util.Optional;

/**
 * Program to fetch token from Workload Identity Credential.
 */
public class Program {

    public static void main(String[] args) {
        WorkloadIdentityCredential workloadIdentityCredential = new WorkloadIdentityCredentialBuilder().build();
        try {
            AccessToken accessToken = workloadIdentityCredential
                .getTokenSync(new TokenRequestContext().addScopes("https://management.azure.com/.default"));
            System.out.println("Successfully acquired a token from WorkloadIdentityCredential");
        } catch (Exception ex) {
            System.out.println("Failed to acquire a token from WorkloadIdentityCredential");
        }
    }
}
