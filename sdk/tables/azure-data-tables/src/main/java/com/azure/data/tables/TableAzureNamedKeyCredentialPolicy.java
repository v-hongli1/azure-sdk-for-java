// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.data.tables;

import com.azure.core.credential.AzureNamedKeyCredential;
import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpPipelineCallContext;
import com.azure.core.http.HttpPipelineNextPolicy;
import com.azure.core.http.HttpResponse;
import com.azure.core.http.policy.HttpPipelinePolicy;
import com.azure.core.util.Header;
import reactor.core.publisher.Mono;

import java.net.URL;
import java.util.Arrays;
import java.util.Map;

import static com.azure.data.tables.implementation.TableSasUtils.computeHmac256;
import static com.azure.data.tables.implementation.TableUtils.parseQueryStringSplitValues;

/**
 * Policy that adds the SharedKey into the request's Authorization header.
 */
public final class TableAzureNamedKeyCredentialPolicy implements HttpPipelinePolicy {
    private static final String AUTHORIZATION_HEADER_FORMAT = "SharedKeyLite %s:%s";
    private final AzureNamedKeyCredential credential;

    /**
     * Creates a SharedKey pipeline policy that adds the SharedKey into the request's authorization header.
     *
     * @param credential The SharedKey credential used to create the policy.
     */
    public TableAzureNamedKeyCredentialPolicy(AzureNamedKeyCredential credential) {
        this.credential = credential;
    }

    /**
     * Authorizes a {@link com.azure.core.http.HttpRequest} with the SharedKey credential.
     *
     * @param context The context of the request.
     * @param next The next policy in the pipeline.
     *
     * @return A reactive result containing the HTTP response.
     */
    public Mono<HttpResponse> process(HttpPipelineCallContext context, HttpPipelineNextPolicy next) {
        String authorizationValue
            = generateAuthorizationHeader(context.getHttpRequest().getUrl(), context.getHttpRequest().getHeaders());

        context.getHttpRequest().setHeader("Authorization", authorizationValue);

        return next.process();
    }

    /**
     * Generates the Auth Headers
     *
     * @param requestUrl The URL which the request is going to.
     * @param headers The headers of the request.
     *
     * @return The auth header
     */
    String generateAuthorizationHeader(URL requestUrl, HttpHeaders headers) {
        String signature = computeHmac256(this.credential.getAzureNamedKey().getKey(),
            buildStringToSign(requestUrl, headers, this.credential));

        return String.format(AUTHORIZATION_HEADER_FORMAT, this.credential.getAzureNamedKey().getName(), signature);
    }

    /**
     * Creates the String to Sign.
     *
     * @param requestUrl The Url which the request is going to.
     * @param headers The headers of the request.
     *
     * @return A string to sign for the request.
     */
    private static String buildStringToSign(URL requestUrl, HttpHeaders headers, AzureNamedKeyCredential credential) {
        // If the x-ms-header exists ignore the Date header.
        String dateHeader = headers.get("x-ms-date") != null ? "" : getStandardHeaderValue(headers, "Date");

        return String.join("\n", dateHeader, getCanonicalizedResource(requestUrl, credential));
    }

    /**
     * Returns a header value or an empty string if said value is {@code null}.
     *
     * @param headers The request headers.
     * @param headerName The name of the header to get the value for.
     *
     * @return The standard header for the given name.
     */
    private static String getStandardHeaderValue(HttpHeaders headers, String headerName) {
        final Header header = headers.get(headerName);

        return header == null ? "" : header.getValue();
    }

    /**
     * Returns the canonicalized resource needed for a request.
     *
     * @param requestUrl The URL of the request.
     *
     * @return The string that is the canonicalized resource.
     */
    private static String getCanonicalizedResource(URL requestUrl, AzureNamedKeyCredential credential) {
        StringBuilder canonicalizedResource = new StringBuilder("/").append(credential.getAzureNamedKey().getName());

        if (requestUrl.getPath().length() > 0) {
            canonicalizedResource.append(requestUrl.getPath());
        } else {
            canonicalizedResource.append('/');
        }

        if (requestUrl.getQuery() != null) {
            Map<String, String[]> queryParams = parseQueryStringSplitValues(requestUrl.getQuery());
            String[] queryParamValues = queryParams.get("comp");

            if (queryParamValues != null) {
                Arrays.sort(queryParamValues);
                canonicalizedResource.append("?comp=").append(String.join(",", queryParamValues));
            }
        }

        return canonicalizedResource.toString();
    }

    /**
     * Get the {@link AzureNamedKeyCredential} linked to the policy.
     *
     * @return The {@link AzureNamedKeyCredential}.
     */
    public AzureNamedKeyCredential getCredential() {
        return credential;
    }
}
