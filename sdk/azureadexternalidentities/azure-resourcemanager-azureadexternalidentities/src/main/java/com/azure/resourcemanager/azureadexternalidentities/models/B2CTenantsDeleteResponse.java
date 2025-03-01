// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.azureadexternalidentities.models;

import com.azure.core.http.HttpHeaders;
import com.azure.core.http.HttpRequest;
import com.azure.core.http.rest.ResponseBase;

/** Contains all response data for the delete operation. */
public final class B2CTenantsDeleteResponse extends ResponseBase<B2CTenantsDeleteHeaders, Void> {
    /**
     * Creates an instance of B2CTenantsDeleteResponse.
     *
     * @param request the request which resulted in this B2CTenantsDeleteResponse.
     * @param statusCode the status code of the HTTP response.
     * @param rawHeaders the raw headers of the HTTP response.
     * @param value the deserialized value of the HTTP response.
     * @param headers the deserialized headers of the HTTP response.
     */
    public B2CTenantsDeleteResponse(HttpRequest request, int statusCode, HttpHeaders rawHeaders, Void value,
        B2CTenantsDeleteHeaders headers) {
        super(request, statusCode, rawHeaders, value, headers);
    }
}
