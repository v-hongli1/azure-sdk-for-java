// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.digitaltwins.core;

import com.azure.core.http.HttpClient;
import com.azure.core.http.policy.HttpLogDetailLevel;
import com.azure.core.http.policy.HttpLogOptions;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.test.TestProxyTestBase;
import com.azure.core.test.models.CustomMatcher;
import com.azure.core.test.utils.MockTokenCredential;
import com.azure.core.util.Configuration;
import com.azure.identity.AzurePowerShellCredentialBuilder;
import com.azure.identity.DefaultAzureCredentialBuilder;
import com.azure.json.JsonProviders;
import com.azure.json.JsonReader;
import com.azure.json.ReadValueCallback;

import java.io.IOException;
import java.util.Arrays;
import java.util.function.Function;

public class DigitalTwinsTestBase extends TestProxyTestBase {
    private static final String PLAYBACK_ENDPOINT = "https://playback.api.wus2.digitaltwins.azure.net";
    private boolean sanitizersRemoved = false;

    protected static final String DIGITALTWINS_URL
        = Configuration.getGlobalConfiguration().get("DIGITALTWINS_URL", PLAYBACK_ENDPOINT);

    protected DigitalTwinsClientBuilder getDigitalTwinsClientBuilder(HttpClient httpClient,
        DigitalTwinsServiceVersion serviceVersion) {
        DigitalTwinsClientBuilder builder = new DigitalTwinsClientBuilder();

        builder.serviceVersion(serviceVersion);

        if (!interceptorManager.isLiveMode() && !sanitizersRemoved) {
            // Removes `name` and `id` sanitizer from the list of common sanitizers.
            interceptorManager.removeSanitizers("AZSDK3430", "AZSDK3493");
            sanitizersRemoved = true;
        }

        if (interceptorManager.isPlaybackMode()) {
            builder.httpClient(interceptorManager.getPlaybackClient());
            builder.credential(new MockTokenCredential());
            builder.endpoint(PLAYBACK_ENDPOINT);
            interceptorManager.addMatchers(
                Arrays.asList(new CustomMatcher().setHeadersKeyOnlyMatch(Arrays.asList("Telemetry-Source-Time"))));

            return builder;
        } else if (interceptorManager.isRecordMode()) {
            builder.addPolicy(interceptorManager.getRecordPolicy());
            builder.credential(new DefaultAzureCredentialBuilder().build());
        } else {
            builder.credential(new AzurePowerShellCredentialBuilder().build());
        }

        builder.httpClient(httpClient);
        builder.endpoint(DIGITALTWINS_URL);
        builder.httpLogOptions(new HttpLogOptions().setLogLevel(HttpLogDetailLevel.BODY_AND_HEADERS));

        return builder;
    }

    protected DigitalTwinsClientBuilder getDigitalTwinsClientBuilder(HttpClient httpClient,
        DigitalTwinsServiceVersion serviceVersion, HttpPipelinePolicy... policies) {
        DigitalTwinsClientBuilder builder = getDigitalTwinsClientBuilder(httpClient, serviceVersion);

        if (policies != null) {
            for (HttpPipelinePolicy policy : policies) {
                builder.addPolicy(policy);
            }
        }

        return builder;
    }

    protected DigitalTwinsClient getClient(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        return getDigitalTwinsClientBuilder(httpClient, serviceVersion).buildClient();
    }

    protected DigitalTwinsAsyncClient getAsyncClient(HttpClient httpClient, DigitalTwinsServiceVersion serviceVersion) {
        return getDigitalTwinsClientBuilder(httpClient, serviceVersion).buildAsyncClient();
    }

    /**
     * This function generates a random string of integers for use when creating models with a random version. It takes
     * a maxLength parameter that determines how long of a string of integers will be produced.
     * <p>
     * For instance, if maxLength is 5, then the longest string of integers generated by this function may be "12345"
     */
    private final Function<Integer, String> randomIntegerStringGenerator = (maxLength) -> {
        // This random string provided by azure.core is recorded, but it is also not guaranteed to be only integers
        // It usually generates a string like "154A52c29F42D" or similar. We need a string of random integers though
        // since our e2e tests need a random version number for our models. This function will convert the random
        // string of characters into a random string of integers.
        char[] randomCharactersString = testResourceNamer.randomName("", maxLength).toCharArray();
        StringBuilder randomIntegersString = new StringBuilder(randomCharactersString.length);

        // Convert the random string of characters into a random string of integers. A given random string of characters will always
        // be converted into the same random string of integers which is important since a recorded test and its replay
        // need to use the same random model version number so that the service calls match the session records.
        for (char c : randomCharactersString) {
            randomIntegersString.append(((int) c) % 10);
        }

        return randomIntegersString.toString();
    };

    public Function<Integer, String> getRandomIntegerStringGenerator() {
        return randomIntegerStringGenerator;
    }

    // Used for converting json strings into BasicDigitalTwins, BasicRelationships, etc.
    static <T> T deserializeJsonString(String rawJsonString, ReadValueCallback<JsonReader, T> deserializer)
        throws IOException {
        try (JsonReader jsonReader = JsonProviders.createReader(rawJsonString)) {
            return deserializer.read(jsonReader);
        }
    }
}
