// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

import com.azure.core.http.HttpClient;
import com.azure.core.http.HttpMethod;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.HttpResponse;
import com.azure.core.test.TestBase;
import com.azure.core.util.Configuration;
import com.azure.core.util.logging.ClientLogger;
import com.azure.core.util.logging.LogLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledIfEnvironmentVariable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

public class LiveManagedIdentityTests extends TestBase {

    @Test
    @EnabledIfEnvironmentVariable(named = "AZURE_TEST_MODE", matches = "LIVE")
    public void testManagedIdentityFuncDeployment() {
        HttpClient client = HttpClient.createDefault();
        String functionUrl = "https://" + System.getenv("IDENTITY_FUNCTION_NAME") + ".azurewebsites.net/api/mitest";
        HttpRequest request = new HttpRequest(HttpMethod.GET, functionUrl);
        try (HttpResponse httpResponse = client.send(request).block()) {
            if (httpResponse.getStatusCode() != 200) {
                fail("Failed to get response from function app");
            }
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "AZURE_TEST_MODE", matches = "LIVE")
    public void testManagedIdentityWebAppDeployment() {
        HttpClient client = HttpClient.createDefault();
        String functionUrl = "https://" + System.getenv("IDENTITY_WEBAPP_NAME") + ".azurewebsites.net/mitest";
        ClientLogger logger = new ClientLogger(LiveManagedIdentityTests.class);
        logger.log(LogLevel.INFORMATIONAL, () -> "webappURL: " + functionUrl);
        HttpRequest request = new HttpRequest(HttpMethod.GET, functionUrl);
        try (HttpResponse httpResponse = client.send(request).block()) {
            if (httpResponse.getStatusCode() != 200) {
                fail("Failed to get response from web app");
            }
        }
    }

    @Test
    @EnabledIfEnvironmentVariable(named = "AZURE_TEST_MODE", matches = "LIVE")
    public void testManagedIdentityAksDeployment() {

        //Setup Env
         Configuration configuration = Configuration.getGlobalConfiguration().clone();

        String spClientId = configuration.get("IDENTITY_CLIENT_ID");
        String secret = configuration.get("IDENTITY_CLIENT_SECRET");
        String tenantId = configuration.get("IDENTITY_TENANT_ID");
        String resourceGroup = configuration.get("IDENTITY_RESOURCE_GROUP");
        String aksCluster = configuration.get("IDENTITY_AKS_CLUSTER_NAME");
        String subscriptionId = configuration.get("IDENTITY_SUBSCRIPTION_ID");
        String buildArtifact = configuration.get("BUILD_SOURCEDIRECTORY");
        String targetFramework = configuration.get("TESTTARGETFRAMEWORK");
        String podName = configuration.get("IDENTITY_AKS_POD_NAME");

        String azPath = runCommand("which", "az");

        String kubectlPath = runCommand("which", "kubectl");

        runCommand(azPath, "login --service-principal -u " + spClientId + " -p " + secret + " --tenant " + tenantId);

        runCommand(azPath, "account set --subscription " + subscriptionId);

        runCommand(azPath, "aks get-credentials --resource-group " + resourceGroup + " --name " + aksCluster + " --overwrite-existing");

        String podOutput = runCommand(kubectlPath, "get pods -o jsonpath='{.items[0].metadata.name}'");
        assertTrue(podOutput.contains(podName), "Pod name not found in the output");

        runCommand(kubectlPath, "cp " + buildArtifact + "/artifacts/bin/live-test-apps/identity-test-container");


        String output = runCommand(kubectlPath, "exec -it " + podName + " -- /bin/bash -c 'cd identity-test-container && java -jar identity-test-container-1.0.0.jar'");


        Assertions.assertTrue(output.contains("Successfully retrieved managed identity tokens"), "Failed to get response from AKS");
    }

    private String runCommand(String command, String args) {
        try {
            System.out.println("Running command: " + command + " " + args);
            ProcessBuilder processBuilder = new ProcessBuilder(command, args);
            processBuilder.redirectErrorStream(true);
            Process process = processBuilder.start();

            // Set timeout
            boolean finished = process.waitFor(30, TimeUnit.SECONDS);
            if (!finished) {
                process.destroy();
                throw new RuntimeException("Process execution timeout");
            }

            // Read output
            StringBuilder output = new StringBuilder();
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    output.append(line).append(System.lineSeparator());
                }
            }

            System.out.println("Output:" + System.lineSeparator() + output);
            return output.toString();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
