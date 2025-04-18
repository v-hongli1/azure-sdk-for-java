// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.datafactory.fluent.models.WebActivityTypeProperties;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Web activity.
 */
@Fluent
public final class WebActivity extends ExecutionActivity {
    /*
     * Type of activity.
     */
    private String type = "WebActivity";

    /*
     * Web activity properties.
     */
    private WebActivityTypeProperties innerTypeProperties = new WebActivityTypeProperties();

    /**
     * Creates an instance of WebActivity class.
     */
    public WebActivity() {
    }

    /**
     * Get the type property: Type of activity.
     * 
     * @return the type value.
     */
    @Override
    public String type() {
        return this.type;
    }

    /**
     * Get the innerTypeProperties property: Web activity properties.
     * 
     * @return the innerTypeProperties value.
     */
    WebActivityTypeProperties innerTypeProperties() {
        return this.innerTypeProperties;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withLinkedServiceName(LinkedServiceReference linkedServiceName) {
        super.withLinkedServiceName(linkedServiceName);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withPolicy(ActivityPolicy policy) {
        super.withPolicy(policy);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withName(String name) {
        super.withName(name);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withDescription(String description) {
        super.withDescription(description);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withState(ActivityState state) {
        super.withState(state);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withOnInactiveMarkAs(ActivityOnInactiveMarkAs onInactiveMarkAs) {
        super.withOnInactiveMarkAs(onInactiveMarkAs);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withDependsOn(List<ActivityDependency> dependsOn) {
        super.withDependsOn(dependsOn);
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public WebActivity withUserProperties(List<UserProperty> userProperties) {
        super.withUserProperties(userProperties);
        return this;
    }

    /**
     * Get the method property: Rest API method for target endpoint.
     * 
     * @return the method value.
     */
    public WebActivityMethod method() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().method();
    }

    /**
     * Set the method property: Rest API method for target endpoint.
     * 
     * @param method the method value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withMethod(WebActivityMethod method) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withMethod(method);
        return this;
    }

    /**
     * Get the url property: Web activity target endpoint and path. Type: string (or Expression with resultType string).
     * 
     * @return the url value.
     */
    public Object url() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().url();
    }

    /**
     * Set the url property: Web activity target endpoint and path. Type: string (or Expression with resultType string).
     * 
     * @param url the url value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withUrl(Object url) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withUrl(url);
        return this;
    }

    /**
     * Get the headers property: Represents the headers that will be sent to the request. For example, to set the
     * language and type on a request: "headers" : { "Accept-Language": "en-us", "Content-Type": "application/json" }.
     * Type: string (or Expression with resultType string).
     * 
     * @return the headers value.
     */
    public Map<String, Object> headers() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().headers();
    }

    /**
     * Set the headers property: Represents the headers that will be sent to the request. For example, to set the
     * language and type on a request: "headers" : { "Accept-Language": "en-us", "Content-Type": "application/json" }.
     * Type: string (or Expression with resultType string).
     * 
     * @param headers the headers value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withHeaders(Map<String, Object> headers) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withHeaders(headers);
        return this;
    }

    /**
     * Get the body property: Represents the payload that will be sent to the endpoint. Required for POST/PUT method,
     * not allowed for GET method Type: string (or Expression with resultType string).
     * 
     * @return the body value.
     */
    public Object body() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().body();
    }

    /**
     * Set the body property: Represents the payload that will be sent to the endpoint. Required for POST/PUT method,
     * not allowed for GET method Type: string (or Expression with resultType string).
     * 
     * @param body the body value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withBody(Object body) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withBody(body);
        return this;
    }

    /**
     * Get the authentication property: Authentication method used for calling the endpoint.
     * 
     * @return the authentication value.
     */
    public WebActivityAuthentication authentication() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().authentication();
    }

    /**
     * Set the authentication property: Authentication method used for calling the endpoint.
     * 
     * @param authentication the authentication value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withAuthentication(WebActivityAuthentication authentication) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withAuthentication(authentication);
        return this;
    }

    /**
     * Get the disableCertValidation property: When set to true, Certificate validation will be disabled.
     * 
     * @return the disableCertValidation value.
     */
    public Boolean disableCertValidation() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().disableCertValidation();
    }

    /**
     * Set the disableCertValidation property: When set to true, Certificate validation will be disabled.
     * 
     * @param disableCertValidation the disableCertValidation value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withDisableCertValidation(Boolean disableCertValidation) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withDisableCertValidation(disableCertValidation);
        return this;
    }

    /**
     * Get the httpRequestTimeout property: Timeout for the HTTP request to get a response. Format is in TimeSpan
     * (hh:mm:ss). This value is the timeout to get a response, not the activity timeout. The default value is 00:01:00
     * (1 minute). The range is from 1 to 10 minutes.
     * 
     * @return the httpRequestTimeout value.
     */
    public Object httpRequestTimeout() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().httpRequestTimeout();
    }

    /**
     * Set the httpRequestTimeout property: Timeout for the HTTP request to get a response. Format is in TimeSpan
     * (hh:mm:ss). This value is the timeout to get a response, not the activity timeout. The default value is 00:01:00
     * (1 minute). The range is from 1 to 10 minutes.
     * 
     * @param httpRequestTimeout the httpRequestTimeout value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withHttpRequestTimeout(Object httpRequestTimeout) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withHttpRequestTimeout(httpRequestTimeout);
        return this;
    }

    /**
     * Get the turnOffAsync property: Option to disable invoking HTTP GET on location given in response header of a HTTP
     * 202 Response. If set true, it stops invoking HTTP GET on http location given in response header. If set false
     * then continues to invoke HTTP GET call on location given in http response headers.
     * 
     * @return the turnOffAsync value.
     */
    public Boolean turnOffAsync() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().turnOffAsync();
    }

    /**
     * Set the turnOffAsync property: Option to disable invoking HTTP GET on location given in response header of a HTTP
     * 202 Response. If set true, it stops invoking HTTP GET on http location given in response header. If set false
     * then continues to invoke HTTP GET call on location given in http response headers.
     * 
     * @param turnOffAsync the turnOffAsync value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withTurnOffAsync(Boolean turnOffAsync) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withTurnOffAsync(turnOffAsync);
        return this;
    }

    /**
     * Get the datasets property: List of datasets passed to web endpoint.
     * 
     * @return the datasets value.
     */
    public List<DatasetReference> datasets() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().datasets();
    }

    /**
     * Set the datasets property: List of datasets passed to web endpoint.
     * 
     * @param datasets the datasets value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withDatasets(List<DatasetReference> datasets) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withDatasets(datasets);
        return this;
    }

    /**
     * Get the linkedServices property: List of linked services passed to web endpoint.
     * 
     * @return the linkedServices value.
     */
    public List<LinkedServiceReference> linkedServices() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().linkedServices();
    }

    /**
     * Set the linkedServices property: List of linked services passed to web endpoint.
     * 
     * @param linkedServices the linkedServices value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withLinkedServices(List<LinkedServiceReference> linkedServices) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withLinkedServices(linkedServices);
        return this;
    }

    /**
     * Get the connectVia property: The integration runtime reference.
     * 
     * @return the connectVia value.
     */
    public IntegrationRuntimeReference connectVia() {
        return this.innerTypeProperties() == null ? null : this.innerTypeProperties().connectVia();
    }

    /**
     * Set the connectVia property: The integration runtime reference.
     * 
     * @param connectVia the connectVia value to set.
     * @return the WebActivity object itself.
     */
    public WebActivity withConnectVia(IntegrationRuntimeReference connectVia) {
        if (this.innerTypeProperties() == null) {
            this.innerTypeProperties = new WebActivityTypeProperties();
        }
        this.innerTypeProperties().withConnectVia(connectVia);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        if (innerTypeProperties() == null) {
            throw LOGGER.atError()
                .log(
                    new IllegalArgumentException("Missing required property innerTypeProperties in model WebActivity"));
        } else {
            innerTypeProperties().validate();
        }
        if (name() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property name in model WebActivity"));
        }
        if (dependsOn() != null) {
            dependsOn().forEach(e -> e.validate());
        }
        if (userProperties() != null) {
            userProperties().forEach(e -> e.validate());
        }
        if (linkedServiceName() != null) {
            linkedServiceName().validate();
        }
        if (policy() != null) {
            policy().validate();
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(WebActivity.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("name", name());
        jsonWriter.writeStringField("description", description());
        jsonWriter.writeStringField("state", state() == null ? null : state().toString());
        jsonWriter.writeStringField("onInactiveMarkAs",
            onInactiveMarkAs() == null ? null : onInactiveMarkAs().toString());
        jsonWriter.writeArrayField("dependsOn", dependsOn(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("userProperties", userProperties(), (writer, element) -> writer.writeJson(element));
        jsonWriter.writeJsonField("linkedServiceName", linkedServiceName());
        jsonWriter.writeJsonField("policy", policy());
        jsonWriter.writeJsonField("typeProperties", this.innerTypeProperties);
        jsonWriter.writeStringField("type", this.type);
        if (additionalProperties() != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties().entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of WebActivity from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of WebActivity if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the WebActivity.
     */
    public static WebActivity fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            WebActivity deserializedWebActivity = new WebActivity();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("name".equals(fieldName)) {
                    deserializedWebActivity.withName(reader.getString());
                } else if ("description".equals(fieldName)) {
                    deserializedWebActivity.withDescription(reader.getString());
                } else if ("state".equals(fieldName)) {
                    deserializedWebActivity.withState(ActivityState.fromString(reader.getString()));
                } else if ("onInactiveMarkAs".equals(fieldName)) {
                    deserializedWebActivity
                        .withOnInactiveMarkAs(ActivityOnInactiveMarkAs.fromString(reader.getString()));
                } else if ("dependsOn".equals(fieldName)) {
                    List<ActivityDependency> dependsOn
                        = reader.readArray(reader1 -> ActivityDependency.fromJson(reader1));
                    deserializedWebActivity.withDependsOn(dependsOn);
                } else if ("userProperties".equals(fieldName)) {
                    List<UserProperty> userProperties = reader.readArray(reader1 -> UserProperty.fromJson(reader1));
                    deserializedWebActivity.withUserProperties(userProperties);
                } else if ("linkedServiceName".equals(fieldName)) {
                    deserializedWebActivity.withLinkedServiceName(LinkedServiceReference.fromJson(reader));
                } else if ("policy".equals(fieldName)) {
                    deserializedWebActivity.withPolicy(ActivityPolicy.fromJson(reader));
                } else if ("typeProperties".equals(fieldName)) {
                    deserializedWebActivity.innerTypeProperties = WebActivityTypeProperties.fromJson(reader);
                } else if ("type".equals(fieldName)) {
                    deserializedWebActivity.type = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedWebActivity.withAdditionalProperties(additionalProperties);

            return deserializedWebActivity;
        });
    }
}
