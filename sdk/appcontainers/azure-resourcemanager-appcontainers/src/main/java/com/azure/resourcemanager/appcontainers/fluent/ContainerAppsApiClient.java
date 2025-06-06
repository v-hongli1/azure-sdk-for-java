// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcontainers.fluent;

import com.azure.core.http.HttpPipeline;
import java.time.Duration;

/**
 * The interface for ContainerAppsApiClient class.
 */
public interface ContainerAppsApiClient {
    /**
     * Gets The ID of the target subscription.
     * 
     * @return the subscriptionId value.
     */
    String getSubscriptionId();

    /**
     * Gets server parameter.
     * 
     * @return the endpoint value.
     */
    String getEndpoint();

    /**
     * Gets Api Version.
     * 
     * @return the apiVersion value.
     */
    String getApiVersion();

    /**
     * Gets The HTTP pipeline to send requests through.
     * 
     * @return the httpPipeline value.
     */
    HttpPipeline getHttpPipeline();

    /**
     * Gets The default poll interval for long-running operation.
     * 
     * @return the defaultPollInterval value.
     */
    Duration getDefaultPollInterval();

    /**
     * Gets the ContainerAppsAuthConfigsClient object to access its operations.
     * 
     * @return the ContainerAppsAuthConfigsClient object.
     */
    ContainerAppsAuthConfigsClient getContainerAppsAuthConfigs();

    /**
     * Gets the AvailableWorkloadProfilesClient object to access its operations.
     * 
     * @return the AvailableWorkloadProfilesClient object.
     */
    AvailableWorkloadProfilesClient getAvailableWorkloadProfiles();

    /**
     * Gets the BillingMetersClient object to access its operations.
     * 
     * @return the BillingMetersClient object.
     */
    BillingMetersClient getBillingMeters();

    /**
     * Gets the ConnectedEnvironmentsClient object to access its operations.
     * 
     * @return the ConnectedEnvironmentsClient object.
     */
    ConnectedEnvironmentsClient getConnectedEnvironments();

    /**
     * Gets the ConnectedEnvironmentsCertificatesClient object to access its operations.
     * 
     * @return the ConnectedEnvironmentsCertificatesClient object.
     */
    ConnectedEnvironmentsCertificatesClient getConnectedEnvironmentsCertificates();

    /**
     * Gets the ConnectedEnvironmentsDaprComponentsClient object to access its operations.
     * 
     * @return the ConnectedEnvironmentsDaprComponentsClient object.
     */
    ConnectedEnvironmentsDaprComponentsClient getConnectedEnvironmentsDaprComponents();

    /**
     * Gets the ConnectedEnvironmentsStoragesClient object to access its operations.
     * 
     * @return the ConnectedEnvironmentsStoragesClient object.
     */
    ConnectedEnvironmentsStoragesClient getConnectedEnvironmentsStorages();

    /**
     * Gets the ContainerAppsClient object to access its operations.
     * 
     * @return the ContainerAppsClient object.
     */
    ContainerAppsClient getContainerApps();

    /**
     * Gets the ContainerAppsRevisionsClient object to access its operations.
     * 
     * @return the ContainerAppsRevisionsClient object.
     */
    ContainerAppsRevisionsClient getContainerAppsRevisions();

    /**
     * Gets the ContainerAppsRevisionReplicasClient object to access its operations.
     * 
     * @return the ContainerAppsRevisionReplicasClient object.
     */
    ContainerAppsRevisionReplicasClient getContainerAppsRevisionReplicas();

    /**
     * Gets the ContainerAppsDiagnosticsClient object to access its operations.
     * 
     * @return the ContainerAppsDiagnosticsClient object.
     */
    ContainerAppsDiagnosticsClient getContainerAppsDiagnostics();

    /**
     * Gets the ManagedEnvironmentDiagnosticsClient object to access its operations.
     * 
     * @return the ManagedEnvironmentDiagnosticsClient object.
     */
    ManagedEnvironmentDiagnosticsClient getManagedEnvironmentDiagnostics();

    /**
     * Gets the ManagedEnvironmentsDiagnosticsClient object to access its operations.
     * 
     * @return the ManagedEnvironmentsDiagnosticsClient object.
     */
    ManagedEnvironmentsDiagnosticsClient getManagedEnvironmentsDiagnostics();

    /**
     * Gets the JobsClient object to access its operations.
     * 
     * @return the JobsClient object.
     */
    JobsClient getJobs();

    /**
     * Gets the OperationsClient object to access its operations.
     * 
     * @return the OperationsClient object.
     */
    OperationsClient getOperations();

    /**
     * Gets the JavaComponentsClient object to access its operations.
     * 
     * @return the JavaComponentsClient object.
     */
    JavaComponentsClient getJavaComponents();

    /**
     * Gets the JobsExecutionsClient object to access its operations.
     * 
     * @return the JobsExecutionsClient object.
     */
    JobsExecutionsClient getJobsExecutions();

    /**
     * Gets the ResourceProvidersClient object to access its operations.
     * 
     * @return the ResourceProvidersClient object.
     */
    ResourceProvidersClient getResourceProviders();

    /**
     * Gets the ManagedEnvironmentsClient object to access its operations.
     * 
     * @return the ManagedEnvironmentsClient object.
     */
    ManagedEnvironmentsClient getManagedEnvironments();

    /**
     * Gets the CertificatesClient object to access its operations.
     * 
     * @return the CertificatesClient object.
     */
    CertificatesClient getCertificates();

    /**
     * Gets the ManagedCertificatesClient object to access its operations.
     * 
     * @return the ManagedCertificatesClient object.
     */
    ManagedCertificatesClient getManagedCertificates();

    /**
     * Gets the NamespacesClient object to access its operations.
     * 
     * @return the NamespacesClient object.
     */
    NamespacesClient getNamespaces();

    /**
     * Gets the DaprComponentsClient object to access its operations.
     * 
     * @return the DaprComponentsClient object.
     */
    DaprComponentsClient getDaprComponents();

    /**
     * Gets the ManagedEnvironmentsStoragesClient object to access its operations.
     * 
     * @return the ManagedEnvironmentsStoragesClient object.
     */
    ManagedEnvironmentsStoragesClient getManagedEnvironmentsStorages();

    /**
     * Gets the ContainerAppsSessionPoolsClient object to access its operations.
     * 
     * @return the ContainerAppsSessionPoolsClient object.
     */
    ContainerAppsSessionPoolsClient getContainerAppsSessionPools();

    /**
     * Gets the ContainerAppsSourceControlsClient object to access its operations.
     * 
     * @return the ContainerAppsSourceControlsClient object.
     */
    ContainerAppsSourceControlsClient getContainerAppsSourceControls();

    /**
     * Gets the UsagesClient object to access its operations.
     * 
     * @return the UsagesClient object.
     */
    UsagesClient getUsages();

    /**
     * Gets the ManagedEnvironmentUsagesClient object to access its operations.
     * 
     * @return the ManagedEnvironmentUsagesClient object.
     */
    ManagedEnvironmentUsagesClient getManagedEnvironmentUsages();
}
