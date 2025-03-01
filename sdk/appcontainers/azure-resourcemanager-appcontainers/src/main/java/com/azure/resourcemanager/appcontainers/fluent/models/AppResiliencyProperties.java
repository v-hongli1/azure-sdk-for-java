// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appcontainers.models.CircuitBreakerPolicy;
import com.azure.resourcemanager.appcontainers.models.HttpConnectionPool;
import com.azure.resourcemanager.appcontainers.models.HttpRetryPolicy;
import com.azure.resourcemanager.appcontainers.models.TcpConnectionPool;
import com.azure.resourcemanager.appcontainers.models.TcpRetryPolicy;
import com.azure.resourcemanager.appcontainers.models.TimeoutPolicy;
import java.io.IOException;

/**
 * App Resiliency resource specific properties.
 */
@Fluent
public final class AppResiliencyProperties implements JsonSerializable<AppResiliencyProperties> {
    /*
     * Policy to set request timeouts
     */
    private TimeoutPolicy timeoutPolicy;

    /*
     * Policy that defines http request retry conditions
     */
    private HttpRetryPolicy httpRetryPolicy;

    /*
     * Policy that defines tcp request retry conditions
     */
    private TcpRetryPolicy tcpRetryPolicy;

    /*
     * Policy that defines circuit breaker conditions
     */
    private CircuitBreakerPolicy circuitBreakerPolicy;

    /*
     * Defines parameters for http connection pooling
     */
    private HttpConnectionPool httpConnectionPool;

    /*
     * Defines parameters for tcp connection pooling
     */
    private TcpConnectionPool tcpConnectionPool;

    /**
     * Creates an instance of AppResiliencyProperties class.
     */
    public AppResiliencyProperties() {
    }

    /**
     * Get the timeoutPolicy property: Policy to set request timeouts.
     * 
     * @return the timeoutPolicy value.
     */
    public TimeoutPolicy timeoutPolicy() {
        return this.timeoutPolicy;
    }

    /**
     * Set the timeoutPolicy property: Policy to set request timeouts.
     * 
     * @param timeoutPolicy the timeoutPolicy value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withTimeoutPolicy(TimeoutPolicy timeoutPolicy) {
        this.timeoutPolicy = timeoutPolicy;
        return this;
    }

    /**
     * Get the httpRetryPolicy property: Policy that defines http request retry conditions.
     * 
     * @return the httpRetryPolicy value.
     */
    public HttpRetryPolicy httpRetryPolicy() {
        return this.httpRetryPolicy;
    }

    /**
     * Set the httpRetryPolicy property: Policy that defines http request retry conditions.
     * 
     * @param httpRetryPolicy the httpRetryPolicy value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withHttpRetryPolicy(HttpRetryPolicy httpRetryPolicy) {
        this.httpRetryPolicy = httpRetryPolicy;
        return this;
    }

    /**
     * Get the tcpRetryPolicy property: Policy that defines tcp request retry conditions.
     * 
     * @return the tcpRetryPolicy value.
     */
    public TcpRetryPolicy tcpRetryPolicy() {
        return this.tcpRetryPolicy;
    }

    /**
     * Set the tcpRetryPolicy property: Policy that defines tcp request retry conditions.
     * 
     * @param tcpRetryPolicy the tcpRetryPolicy value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withTcpRetryPolicy(TcpRetryPolicy tcpRetryPolicy) {
        this.tcpRetryPolicy = tcpRetryPolicy;
        return this;
    }

    /**
     * Get the circuitBreakerPolicy property: Policy that defines circuit breaker conditions.
     * 
     * @return the circuitBreakerPolicy value.
     */
    public CircuitBreakerPolicy circuitBreakerPolicy() {
        return this.circuitBreakerPolicy;
    }

    /**
     * Set the circuitBreakerPolicy property: Policy that defines circuit breaker conditions.
     * 
     * @param circuitBreakerPolicy the circuitBreakerPolicy value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withCircuitBreakerPolicy(CircuitBreakerPolicy circuitBreakerPolicy) {
        this.circuitBreakerPolicy = circuitBreakerPolicy;
        return this;
    }

    /**
     * Get the httpConnectionPool property: Defines parameters for http connection pooling.
     * 
     * @return the httpConnectionPool value.
     */
    public HttpConnectionPool httpConnectionPool() {
        return this.httpConnectionPool;
    }

    /**
     * Set the httpConnectionPool property: Defines parameters for http connection pooling.
     * 
     * @param httpConnectionPool the httpConnectionPool value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withHttpConnectionPool(HttpConnectionPool httpConnectionPool) {
        this.httpConnectionPool = httpConnectionPool;
        return this;
    }

    /**
     * Get the tcpConnectionPool property: Defines parameters for tcp connection pooling.
     * 
     * @return the tcpConnectionPool value.
     */
    public TcpConnectionPool tcpConnectionPool() {
        return this.tcpConnectionPool;
    }

    /**
     * Set the tcpConnectionPool property: Defines parameters for tcp connection pooling.
     * 
     * @param tcpConnectionPool the tcpConnectionPool value to set.
     * @return the AppResiliencyProperties object itself.
     */
    public AppResiliencyProperties withTcpConnectionPool(TcpConnectionPool tcpConnectionPool) {
        this.tcpConnectionPool = tcpConnectionPool;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (timeoutPolicy() != null) {
            timeoutPolicy().validate();
        }
        if (httpRetryPolicy() != null) {
            httpRetryPolicy().validate();
        }
        if (tcpRetryPolicy() != null) {
            tcpRetryPolicy().validate();
        }
        if (circuitBreakerPolicy() != null) {
            circuitBreakerPolicy().validate();
        }
        if (httpConnectionPool() != null) {
            httpConnectionPool().validate();
        }
        if (tcpConnectionPool() != null) {
            tcpConnectionPool().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("timeoutPolicy", this.timeoutPolicy);
        jsonWriter.writeJsonField("httpRetryPolicy", this.httpRetryPolicy);
        jsonWriter.writeJsonField("tcpRetryPolicy", this.tcpRetryPolicy);
        jsonWriter.writeJsonField("circuitBreakerPolicy", this.circuitBreakerPolicy);
        jsonWriter.writeJsonField("httpConnectionPool", this.httpConnectionPool);
        jsonWriter.writeJsonField("tcpConnectionPool", this.tcpConnectionPool);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of AppResiliencyProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of AppResiliencyProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the AppResiliencyProperties.
     */
    public static AppResiliencyProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            AppResiliencyProperties deserializedAppResiliencyProperties = new AppResiliencyProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("timeoutPolicy".equals(fieldName)) {
                    deserializedAppResiliencyProperties.timeoutPolicy = TimeoutPolicy.fromJson(reader);
                } else if ("httpRetryPolicy".equals(fieldName)) {
                    deserializedAppResiliencyProperties.httpRetryPolicy = HttpRetryPolicy.fromJson(reader);
                } else if ("tcpRetryPolicy".equals(fieldName)) {
                    deserializedAppResiliencyProperties.tcpRetryPolicy = TcpRetryPolicy.fromJson(reader);
                } else if ("circuitBreakerPolicy".equals(fieldName)) {
                    deserializedAppResiliencyProperties.circuitBreakerPolicy = CircuitBreakerPolicy.fromJson(reader);
                } else if ("httpConnectionPool".equals(fieldName)) {
                    deserializedAppResiliencyProperties.httpConnectionPool = HttpConnectionPool.fromJson(reader);
                } else if ("tcpConnectionPool".equals(fieldName)) {
                    deserializedAppResiliencyProperties.tcpConnectionPool = TcpConnectionPool.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedAppResiliencyProperties;
        });
    }
}
