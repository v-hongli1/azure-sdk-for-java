// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.annotation.processor.models;

import io.clientcore.core.http.models.HttpMethod;
import io.clientcore.core.utils.CoreUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.lang.model.type.TypeMirror;

/**
 * Represents the context of an HTTP request, including its configuration, parameters, headers, and other details.
 */
public final class HttpRequestContext {

    // Request Configuration
    private String methodName;
    private TypeMirror methodReturnType;
    private final List<MethodParameter> parameters;
    private HttpMethod httpMethod;
    private boolean isConvenience;

    // This comes from the @Host annotation that is applied to the entire service interface, it will likely have one
    // or more substitutions in it, which will be replaced with the appropriate parameter values annotated with @HostParam.
    private String host;

    // This comes from the @HttpRequestInformation.path annotation that is applied to each method in the service interface.
    // It will likely have one or more substitutions in it, which will be replaced with the appropriate parameter values
    // annotated with @PathParam.
    private String path;

    private final Map<String, List<String>> headers;
    private final Map<String, QueryParameter> queryParams;

    private final Map<String, Substitution> substitutions;

    private int[] expectedStatusCodes;

    /**
     * Constructs a new HttpRequestContext with default values.
     */
    public HttpRequestContext() {
        this.parameters = new ArrayList<>();
        this.headers = new HashMap<>();
        this.queryParams = new LinkedHashMap<>();
        this.substitutions = new HashMap<>();
    }

    private Body body;

    /**
     * Gets the method name.
     *
     * @return the method name.
     */
    public String getMethodName() {
        return methodName;
    }

    /**
     * Sets the method name.
     *
     * @param methodName the method name to set.
     */
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    /**
     * Gets the method return type.
     *
     * @return the method return type.
     */
    public TypeMirror getMethodReturnType() {
        return methodReturnType;
    }

    /**
     * Sets the method return type.
     *
     * @param methodReturnType the method return type to set.
     */
    public void setMethodReturnType(TypeMirror methodReturnType) {
        this.methodReturnType = methodReturnType;
    }

    /**
     * Adds a parameter to the method.
     *
     * @param parameter the parameter to add.
     */
    public void addParameter(MethodParameter parameter) {
        this.parameters.add(parameter);
    }

    /**
     * Gets the list of parameters.
     *
     * @return the list of parameters.
     */
    public List<MethodParameter> getParameters() {
        return parameters;
    }

    /**
     * Gets the host.
     *
     * @return the host.
     */
    public String getHost() {
        return host;
    }

    /**
     * Sets the host.
     *
     * @param host the host to set.
     */
    public void setHost(String host) {
        this.host = host;
    }

    /**
     * Gets the path.
     *
     * @return the path.
     */
    public String getPath() {
        return path;
    }

    /**
     * Sets the path.
     *
     * @param path the path to set.
     */
    public void setPath(String path) {
        this.path = path;
    }

    /**
     * Gets the HTTP method.
     *
     * @return the HTTP method.
     */
    public HttpMethod getHttpMethod() {
        return httpMethod;
    }

    /**
     * Sets the HTTP method.
     *
     * @param httpMethod the HTTP method to set.
     */
    public void setHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    /**
     * Gets the headers.
     *
     * @return the headers.
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * Adds a header.
     *
     * @param key the header key.
     * @param value the header value.
     */
    public void addHeader(String key, String value) {
        this.headers.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
    }

    /**
     * Gets the query parameters.
     *
     * @return the query parameters.
     */
    public Map<String, QueryParameter> getQueryParams() {
        return queryParams;
    }

    /**
     * Adds a query parameter.
     *
     * @param key the query parameter key.
     * @param value the query parameter value.
     * @param isMultiple boolean indicating whether this query parameter list values should be sent as individual query
     * params or as a single Json
     * @param shouldEncode boolean indicating whether the query parameter value is URL encoded.
     *
     */
    public void addQueryParam(String key, String value, boolean isMultiple, boolean shouldEncode) {
        QueryParameter existing = queryParams.get(key);
        if (existing != null) {
            existing.addValue(value);
        } else {
            queryParams.put(key, new QueryParameter(value, isMultiple, shouldEncode));
        }
    }

    /**
     * Adds a substitution.
     *
     * @param substitution the substitution to add.
     *
     * @throws IllegalArgumentException if a duplicate substitution is added.
     */
    public void addSubstitution(Substitution substitution) {
        if (substitutions.containsKey(substitution.getParameterName())) {
            throw new IllegalArgumentException(
                "Cannot add duplicate substitution for parameter '" + substitution.getParameterName() + "'");
        }
        substitutions.put(substitution.getParameterName(), substitution);
    }

    /**
     * Gets a substitution by parameter name.
     *
     * @param parameterName the parameter name.
     *
     * @return the substitution.
     */
    public Substitution getSubstitution(String parameterName) {
        return substitutions.get(parameterName);
    }

    /**
     * Sets the body.
     *
     * @param body the body to set.
     */
    public void setBody(Body body) {
        this.body = body;
    }

    /**
     * Gets the body.
     *
     * @return the body.
     */
    public Body getBody() {
        return body;
    }

    /**
     * Sets the expected status codes.
     *
     * @param expectedStatusCodes the expected status codes to set.
     */
    public void setExpectedStatusCodes(int[] expectedStatusCodes) {
        if (expectedStatusCodes != null) {
            Arrays.sort(expectedStatusCodes);
        }
        this.expectedStatusCodes = expectedStatusCodes;
    }

    /**
     * Gets the expected status codes.
     *
     * @return the expected status codes.
     */
    public List<Integer> getExpectedStatusCodes() {
        return Arrays.stream(expectedStatusCodes).boxed().collect(Collectors.toList());
    }

    /**
     * Gets the boolean to true if the provided method is a default method
     *
     * @return the boolean to true if the provided method is a default method
     */
    public boolean isConvenience() {
        return isConvenience;
    }

    /**
     * Sets the boolean to true if the provided method is a default method
     *
     * @param isConvenience the provided method is a default method
     */
    public void setIsConvenience(boolean isConvenience) {
        this.isConvenience = isConvenience;
    }

    /**
     * Sets the static headers from an array of strings.
     *
     * @param headers the array of headers to set.
     */
    public void addStaticHeaders(String[] headers) {
        if (CoreUtils.isNullOrEmpty(headers)) {
            return;
        }
        for (String header : headers) {
            String[] parts = header.split(":", 2);
            String key = parts[0].trim();
            String value = parts.length > 1 ? parts[1].trim() : "";
            // Split on comma, trim, and filter out empty values
            List<String> values = Arrays.stream(value.split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .collect(Collectors.toList());
            this.headers.put(key, values);
        }
    }

    /**
     * Sets the static query parameters from an array of strings.
     *
     * @param queryParams the array of query parameters to set.
     */
    public void addStaticQueryParams(String[] queryParams) {
        if (CoreUtils.isNullOrEmpty(queryParams)) {
            return;
        }
        for (String queryParam : queryParams) {
            String[] parts = queryParam.split("=", 2);
            String key = parts[0].trim();
            String value = parts.length > 1 ? parts[1].trim() : null;
            addQueryParam(key, value, true, false);
        }
    }

    /**
     * Represents a method parameter.
     */
    public static class MethodParameter {
        private final TypeMirror type;
        private final String shortTypeName;
        private final String name;

        /**
         * Constructs a new MethodParameter.
         *
         * @param type the type of the parameter.
         * @param shortTypeName the short type name of the parameter.
         * @param name the name of the parameter.
         */
        public MethodParameter(TypeMirror type, String shortTypeName, String name) {
            this.type = type;
            this.shortTypeName = shortTypeName;
            this.name = name;
        }

        /**
         * Gets the type mirror.
         *
         * @return the type mirror.
         */
        public TypeMirror getTypeMirror() {
            return type;
        }

        /**
         * Gets the short type name.
         *
         * @return the short type name.
         */
        public String getShortTypeName() {
            return shortTypeName;
        }

        /**
         * Gets the name.
         *
         * @return the name.
         */
        public String getName() {
            return name;
        }
    }

    /**
     * Represents the body of an HTTP request.
     */
    public static class Body {
        // This is the content type as specified in the @BodyParam annotation
        private final String contentType;

        // This is the type of the parameter that has been annotated with @BodyParam.
        // This is used to determine which setBody method to call on HttpRequest.
        private final TypeMirror parameterType;

        // This is the parameter name, so we can refer to it when setting the body on the HttpRequest.
        private final String parameterName;

        /**
         * Constructs a new Body.
         *
         * @param contentType the content type.
         * @param parameterType the parameter type.
         * @param parameterName the parameter name.
         */
        public Body(String contentType, TypeMirror parameterType, String parameterName) {
            this.contentType = contentType;
            this.parameterType = parameterType;
            this.parameterName = parameterName;
        }

        /**
         * Gets the content type.
         *
         * @return the content type.
         */
        public String getContentType() {
            return contentType;
        }

        /**
         * Gets the parameter type.
         *
         * @return the parameter type.
         */
        public TypeMirror getParameterType() {
            return parameterType;
        }

        /**
         * Gets the parameter name.
         *
         * @return the parameter name.
         */
        public String getParameterName() {
            return parameterName;
        }
    }

    /**
     * Represents a query parameter.
     */
    public static class QueryParameter {
        private final List<String> values;
        private final boolean isMultiple;
        private final boolean shouldEncode;

        /**
         * Constructs a new QueryParameter.
         *
         * @param value the value of the query parameter.
         * @param isMultiple whether the parameter can accept multiple values.
         * @param shouldEncode whether the parameter and value is encoded
         */
        public QueryParameter(String value, boolean isMultiple, boolean shouldEncode) {
            this.values = new ArrayList<>();
            this.values.add(value);
            this.isMultiple = isMultiple;
            this.shouldEncode = shouldEncode;
        }

        /**
         * Constructs a new QueryParameter with multiple values.
         *
         * @param values the values of the query parameter.
         * @param isMultiple whether the parameter can accept multiple values.
         * @param shouldEncode whether the parameter and value is encoded
         */
        public QueryParameter(List<String> values, boolean isMultiple, boolean shouldEncode) {
            this.values = new ArrayList<>(values);
            this.isMultiple = isMultiple;
            this.shouldEncode = shouldEncode;
        }

        /**
         * Gets the values of the query parameter.
         *
         * @return the values.
         */
        public List<String> getValues() {
            return Collections.unmodifiableList(values);
        }

        /**
         * Adds a value to the query parameter.
         *
         * @param value the value to add.
         */
        public void addValue(String value) {
            this.values.add(value);
        }

        /**
         * Checks if the query parameter can accept multiple values.
         *
         * @return true if it can accept multiple values, false otherwise.
         */
        public boolean isMultiple() {
            return isMultiple;
        }

        /**
         * Checks if the query parameter and value should be encoded.
         *
         * @return true if it should be encoded, false otherwise.
         */
        public boolean shouldEncode() {
            return shouldEncode;
        }
    }
}
