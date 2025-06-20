// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.http.netty4;

import io.clientcore.core.http.client.HttpClient;
import io.clientcore.core.http.client.HttpProtocolVersion;
import io.clientcore.core.shared.HttpClientTests;
import io.clientcore.core.shared.HttpClientTestsServer;
import io.clientcore.core.shared.InsecureTrustManager;
import io.clientcore.core.shared.LocalTestServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Timeout;

import java.security.SecureRandom;
import java.util.concurrent.TimeUnit;

@Disabled("Support will be added in the future, in another PR.")
@Timeout(value = 3, unit = TimeUnit.MINUTES)
public class NettyHttp2HttpClientTests extends HttpClientTests {
    private static LocalTestServer server;

    private static final HttpClient HTTP_CLIENT_INSTANCE;

    static {
        HTTP_CLIENT_INSTANCE = new NettyHttpClientBuilder()
            .sslContextModifier(
                builder -> builder.trustManager(new InsecureTrustManager()).secureRandom(new SecureRandom()))
            //.maximumHttpVersion(HttpProtocolVersion.HTTP_2)
            .build();
    }

    @BeforeAll
    public static void startTestServer() {
        server = HttpClientTestsServer.getHttpClientTestsServer(HttpProtocolVersion.HTTP_2, true);

        server.start();
    }

    @AfterAll
    public static void stopTestServer() {
        if (server != null) {
            server.stop();
        }
    }

    @Override
    protected boolean isHttp2() {
        return true;
    }

    @Override
    protected boolean isSecure() {
        return true;
    }

    @Override
    @Deprecated
    protected int getPort() {
        return server.getPort();
    }

    @Override
    protected String getServerUri(boolean secure) {
        return server.getHttpsUri();
    }

    @Override
    protected HttpClient getHttpClient() {
        return HTTP_CLIENT_INSTANCE;
    }
}
