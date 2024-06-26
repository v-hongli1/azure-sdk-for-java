// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.botservice.models;

import com.azure.core.annotation.Fluent;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;

/** Sms channel definition. */
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "channelName")
@JsonTypeName("SmsChannel")
@Fluent
public final class SmsChannel extends Channel {
    /*
     * The set of properties specific to Sms channel resource
     */
    @JsonProperty(value = "properties")
    private SmsChannelProperties properties;

    /**
     * Get the properties property: The set of properties specific to Sms channel resource.
     *
     * @return the properties value.
     */
    public SmsChannelProperties properties() {
        return this.properties;
    }

    /**
     * Set the properties property: The set of properties specific to Sms channel resource.
     *
     * @param properties the properties value to set.
     * @return the SmsChannel object itself.
     */
    public SmsChannel withProperties(SmsChannelProperties properties) {
        this.properties = properties;
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SmsChannel withEtag(String etag) {
        super.withEtag(etag);
        return this;
    }

    /** {@inheritDoc} */
    @Override
    public SmsChannel withLocation(String location) {
        super.withLocation(location);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (properties() != null) {
            properties().validate();
        }
    }
}
