// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.mysql.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.management.ProxyResource;
import com.azure.core.util.logging.ClientLogger;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;

/** Represents a log file. */
@Fluent
public final class LogFileInner extends ProxyResource {
    @JsonIgnore
    private final ClientLogger logger = new ClientLogger(LogFileInner.class);

    /*
     * The properties of the log file.
     */
    @JsonProperty(value = "properties")
    private LogFileProperties innerProperties;

    /**
     * Get the innerProperties property: The properties of the log file.
     *
     * @return the innerProperties value.
     */
    private LogFileProperties innerProperties() {
        return this.innerProperties;
    }

    /**
     * Get the sizeInKB property: Size of the log file.
     *
     * @return the sizeInKB value.
     */
    public Long sizeInKB() {
        return this.innerProperties() == null ? null : this.innerProperties().sizeInKB();
    }

    /**
     * Set the sizeInKB property: Size of the log file.
     *
     * @param sizeInKB the sizeInKB value to set.
     * @return the LogFileInner object itself.
     */
    public LogFileInner withSizeInKB(Long sizeInKB) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LogFileProperties();
        }
        this.innerProperties().withSizeInKB(sizeInKB);
        return this;
    }

    /**
     * Get the createdTime property: Creation timestamp of the log file.
     *
     * @return the createdTime value.
     */
    public OffsetDateTime createdTime() {
        return this.innerProperties() == null ? null : this.innerProperties().createdTime();
    }

    /**
     * Get the lastModifiedTime property: Last modified timestamp of the log file.
     *
     * @return the lastModifiedTime value.
     */
    public OffsetDateTime lastModifiedTime() {
        return this.innerProperties() == null ? null : this.innerProperties().lastModifiedTime();
    }

    /**
     * Get the type property: Type of the log file.
     *
     * @return the type value.
     */
    public String typePropertiesType() {
        return this.innerProperties() == null ? null : this.innerProperties().type();
    }

    /**
     * Set the type property: Type of the log file.
     *
     * @param type the type value to set.
     * @return the LogFileInner object itself.
     */
    public LogFileInner withTypePropertiesType(String type) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LogFileProperties();
        }
        this.innerProperties().withType(type);
        return this;
    }

    /**
     * Get the url property: The url to download the log file from.
     *
     * @return the url value.
     */
    public String url() {
        return this.innerProperties() == null ? null : this.innerProperties().url();
    }

    /**
     * Set the url property: The url to download the log file from.
     *
     * @param url the url value to set.
     * @return the LogFileInner object itself.
     */
    public LogFileInner withUrl(String url) {
        if (this.innerProperties() == null) {
            this.innerProperties = new LogFileProperties();
        }
        this.innerProperties().withUrl(url);
        return this;
    }

    /**
     * Validates the instance.
     *
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (innerProperties() != null) {
            innerProperties().validate();
        }
    }
}
