// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.migration.assessment.implementation;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.http.rest.SimpleResponse;
import com.azure.core.util.Context;
import com.azure.core.util.logging.ClientLogger;
import com.azure.resourcemanager.migration.assessment.fluent.HypervCollectorsOperationsClient;
import com.azure.resourcemanager.migration.assessment.fluent.models.HypervCollectorInner;
import com.azure.resourcemanager.migration.assessment.models.HypervCollector;
import com.azure.resourcemanager.migration.assessment.models.HypervCollectorsOperations;

public final class HypervCollectorsOperationsImpl implements HypervCollectorsOperations {
    private static final ClientLogger LOGGER = new ClientLogger(HypervCollectorsOperationsImpl.class);

    private final HypervCollectorsOperationsClient innerClient;

    private final com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager serviceManager;

    public HypervCollectorsOperationsImpl(HypervCollectorsOperationsClient innerClient,
        com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager serviceManager) {
        this.innerClient = innerClient;
        this.serviceManager = serviceManager;
    }

    public PagedIterable<HypervCollector> listByAssessmentProject(String resourceGroupName, String projectName) {
        PagedIterable<HypervCollectorInner> inner
            = this.serviceClient().listByAssessmentProject(resourceGroupName, projectName);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new HypervCollectorImpl(inner1, this.manager()));
    }

    public PagedIterable<HypervCollector> listByAssessmentProject(String resourceGroupName, String projectName,
        Context context) {
        PagedIterable<HypervCollectorInner> inner
            = this.serviceClient().listByAssessmentProject(resourceGroupName, projectName, context);
        return ResourceManagerUtils.mapPage(inner, inner1 -> new HypervCollectorImpl(inner1, this.manager()));
    }

    public Response<HypervCollector> getWithResponse(String resourceGroupName, String projectName,
        String hypervCollectorName, Context context) {
        Response<HypervCollectorInner> inner
            = this.serviceClient().getWithResponse(resourceGroupName, projectName, hypervCollectorName, context);
        if (inner != null) {
            return new SimpleResponse<>(inner.getRequest(), inner.getStatusCode(), inner.getHeaders(),
                new HypervCollectorImpl(inner.getValue(), this.manager()));
        } else {
            return null;
        }
    }

    public HypervCollector get(String resourceGroupName, String projectName, String hypervCollectorName) {
        HypervCollectorInner inner = this.serviceClient().get(resourceGroupName, projectName, hypervCollectorName);
        if (inner != null) {
            return new HypervCollectorImpl(inner, this.manager());
        } else {
            return null;
        }
    }

    public Response<Void> deleteWithResponse(String resourceGroupName, String projectName, String hypervCollectorName,
        Context context) {
        return this.serviceClient().deleteWithResponse(resourceGroupName, projectName, hypervCollectorName, context);
    }

    public void delete(String resourceGroupName, String projectName, String hypervCollectorName) {
        this.serviceClient().delete(resourceGroupName, projectName, hypervCollectorName);
    }

    public HypervCollector getById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String projectName = ResourceManagerUtils.getValueFromIdByName(id, "assessmentProjects");
        if (projectName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'assessmentProjects'.", id)));
        }
        String hypervCollectorName = ResourceManagerUtils.getValueFromIdByName(id, "hypervcollectors");
        if (hypervCollectorName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'hypervcollectors'.", id)));
        }
        return this.getWithResponse(resourceGroupName, projectName, hypervCollectorName, Context.NONE).getValue();
    }

    public Response<HypervCollector> getByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String projectName = ResourceManagerUtils.getValueFromIdByName(id, "assessmentProjects");
        if (projectName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'assessmentProjects'.", id)));
        }
        String hypervCollectorName = ResourceManagerUtils.getValueFromIdByName(id, "hypervcollectors");
        if (hypervCollectorName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'hypervcollectors'.", id)));
        }
        return this.getWithResponse(resourceGroupName, projectName, hypervCollectorName, context);
    }

    public void deleteById(String id) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String projectName = ResourceManagerUtils.getValueFromIdByName(id, "assessmentProjects");
        if (projectName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'assessmentProjects'.", id)));
        }
        String hypervCollectorName = ResourceManagerUtils.getValueFromIdByName(id, "hypervcollectors");
        if (hypervCollectorName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'hypervcollectors'.", id)));
        }
        this.deleteWithResponse(resourceGroupName, projectName, hypervCollectorName, Context.NONE);
    }

    public Response<Void> deleteByIdWithResponse(String id, Context context) {
        String resourceGroupName = ResourceManagerUtils.getValueFromIdByName(id, "resourceGroups");
        if (resourceGroupName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'resourceGroups'.", id)));
        }
        String projectName = ResourceManagerUtils.getValueFromIdByName(id, "assessmentProjects");
        if (projectName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'assessmentProjects'.", id)));
        }
        String hypervCollectorName = ResourceManagerUtils.getValueFromIdByName(id, "hypervcollectors");
        if (hypervCollectorName == null) {
            throw LOGGER.logExceptionAsError(new IllegalArgumentException(
                String.format("The resource ID '%s' is not valid. Missing path segment 'hypervcollectors'.", id)));
        }
        return this.deleteWithResponse(resourceGroupName, projectName, hypervCollectorName, context);
    }

    private HypervCollectorsOperationsClient serviceClient() {
        return this.innerClient;
    }

    private com.azure.resourcemanager.migration.assessment.MigrationAssessmentManager manager() {
        return this.serviceManager;
    }

    public HypervCollectorImpl define(String name) {
        return new HypervCollectorImpl(name, this.manager());
    }
}
