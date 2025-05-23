// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.http.client;

import io.clientcore.core.http.models.HttpRequest;
import io.clientcore.core.http.models.Response;
import io.clientcore.core.implementation.http.client.GlobalJdkHttpClient;
import io.clientcore.core.models.CoreException;
import io.clientcore.core.models.binarydata.BinaryData;

/**
 * A generic interface for sending HTTP requests and getting responses.
 */
public interface HttpClient {
    /**
     * Sends the provided request with contextual information.
     *
     * @param request The HTTP request to send.
     * @return The response.
     * @throws CoreException If any error occurs during sending the request or receiving the response.
     */
    Response<BinaryData> send(HttpRequest request);

    /**
     * Get a new instance of the {@link HttpClient} that the {@link HttpClientProvider} loaded from the classpath is
     * configured to create.
     *
     * <p>If no {@link HttpClientProvider} can be found on the classpath, a new instance of the default
     * {@link HttpClient} implementation will be returned instead.
     *
     * @return A new instance of {@link HttpClient} that the {@link HttpClientProvider} loaded from the classpath is
     * configured to create.
     */
    static HttpClient getNewInstance() {
        return HttpClientProvider.getProviders()
            .create(HttpClientProvider::getNewInstance, () -> new JdkHttpClientBuilder().build(), null);
    }

    /**
     * Get a shared instance of the {@link HttpClient} that the {@link HttpClientProvider} loaded from the classpath is
     * configured to create.
     *
     * <p>If no {@link HttpClientProvider} can be found on the classpath, a shared instance of the default
     * {@link HttpClient} implementation will be returned instead.
     *
     * @return A shared instance of {@link HttpClient} that the {@link HttpClientProvider} loaded from the classpath is
     * configured to create.
     */
    static HttpClient getSharedInstance() {
        return HttpClientProvider.getProviders()
            .create(HttpClientProvider::getSharedInstance, GlobalJdkHttpClient.HTTP_CLIENT::getHttpClient, null);
    }
}
