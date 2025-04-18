// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.implementation;

import com.azure.core.util.Context;
import com.azure.resourcemanager.apimanagement.fluent.models.LoggerContractInner;
import com.azure.resourcemanager.apimanagement.models.LoggerContract;
import com.azure.resourcemanager.apimanagement.models.LoggerType;
import com.azure.resourcemanager.apimanagement.models.LoggerUpdateContract;
import java.util.Collections;
import java.util.Map;

public final class LoggerContractImpl implements LoggerContract, LoggerContract.Definition, LoggerContract.Update {
    private LoggerContractInner innerObject;

    private final com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager;

    public String id() {
        return this.innerModel().id();
    }

    public String name() {
        return this.innerModel().name();
    }

    public String type() {
        return this.innerModel().type();
    }

    public LoggerType loggerType() {
        return this.innerModel().loggerType();
    }

    public String description() {
        return this.innerModel().description();
    }

    public Map<String, String> credentials() {
        Map<String, String> inner = this.innerModel().credentials();
        if (inner != null) {
            return Collections.unmodifiableMap(inner);
        } else {
            return Collections.emptyMap();
        }
    }

    public Boolean isBuffered() {
        return this.innerModel().isBuffered();
    }

    public String resourceId() {
        return this.innerModel().resourceId();
    }

    public String resourceGroupName() {
        return resourceGroupName;
    }

    public LoggerContractInner innerModel() {
        return this.innerObject;
    }

    private com.azure.resourcemanager.apimanagement.ApiManagementManager manager() {
        return this.serviceManager;
    }

    private String resourceGroupName;

    private String serviceName;

    private String loggerId;

    private String createIfMatch;

    private String updateIfMatch;

    private LoggerUpdateContract updateParameters;

    public LoggerContractImpl withExistingService(String resourceGroupName, String serviceName) {
        this.resourceGroupName = resourceGroupName;
        this.serviceName = serviceName;
        return this;
    }

    public LoggerContract create() {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .createOrUpdateWithResponse(resourceGroupName, serviceName, loggerId, this.innerModel(), createIfMatch,
                Context.NONE)
            .getValue();
        return this;
    }

    public LoggerContract create(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .createOrUpdateWithResponse(resourceGroupName, serviceName, loggerId, this.innerModel(), createIfMatch,
                context)
            .getValue();
        return this;
    }

    LoggerContractImpl(String name, com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager) {
        this.innerObject = new LoggerContractInner();
        this.serviceManager = serviceManager;
        this.loggerId = name;
        this.createIfMatch = null;
    }

    public LoggerContractImpl update() {
        this.updateIfMatch = null;
        this.updateParameters = new LoggerUpdateContract();
        return this;
    }

    public LoggerContract apply() {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .updateWithResponse(resourceGroupName, serviceName, loggerId, updateIfMatch, updateParameters, Context.NONE)
            .getValue();
        return this;
    }

    public LoggerContract apply(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .updateWithResponse(resourceGroupName, serviceName, loggerId, updateIfMatch, updateParameters, context)
            .getValue();
        return this;
    }

    LoggerContractImpl(LoggerContractInner innerObject,
        com.azure.resourcemanager.apimanagement.ApiManagementManager serviceManager) {
        this.innerObject = innerObject;
        this.serviceManager = serviceManager;
        this.resourceGroupName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "resourceGroups");
        this.serviceName = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "service");
        this.loggerId = ResourceManagerUtils.getValueFromIdByName(innerObject.id(), "loggers");
    }

    public LoggerContract refresh() {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .getWithResponse(resourceGroupName, serviceName, loggerId, Context.NONE)
            .getValue();
        return this;
    }

    public LoggerContract refresh(Context context) {
        this.innerObject = serviceManager.serviceClient()
            .getLoggers()
            .getWithResponse(resourceGroupName, serviceName, loggerId, context)
            .getValue();
        return this;
    }

    public LoggerContractImpl withLoggerType(LoggerType loggerType) {
        if (isInCreateMode()) {
            this.innerModel().withLoggerType(loggerType);
            return this;
        } else {
            this.updateParameters.withLoggerType(loggerType);
            return this;
        }
    }

    public LoggerContractImpl withDescription(String description) {
        if (isInCreateMode()) {
            this.innerModel().withDescription(description);
            return this;
        } else {
            this.updateParameters.withDescription(description);
            return this;
        }
    }

    public LoggerContractImpl withCredentials(Map<String, String> credentials) {
        if (isInCreateMode()) {
            this.innerModel().withCredentials(credentials);
            return this;
        } else {
            this.updateParameters.withCredentials(credentials);
            return this;
        }
    }

    public LoggerContractImpl withIsBuffered(Boolean isBuffered) {
        if (isInCreateMode()) {
            this.innerModel().withIsBuffered(isBuffered);
            return this;
        } else {
            this.updateParameters.withIsBuffered(isBuffered);
            return this;
        }
    }

    public LoggerContractImpl withResourceId(String resourceId) {
        this.innerModel().withResourceId(resourceId);
        return this;
    }

    public LoggerContractImpl withIfMatch(String ifMatch) {
        if (isInCreateMode()) {
            this.createIfMatch = ifMatch;
            return this;
        } else {
            this.updateIfMatch = ifMatch;
            return this;
        }
    }

    private boolean isInCreateMode() {
        return this.innerModel().id() == null;
    }
}
