// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appconfiguration.models;

import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.appconfiguration.fluent.models.ConfigurationStoreInner;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of ConfigurationStore.
 */
public interface ConfigurationStore {
    /**
     * Gets the id property: Fully qualified resource Id for the resource.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: The name of the resource.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the type property: The type of the resource.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the location property: The geo-location where the resource lives.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the tags property: Resource tags.
     * 
     * @return the tags value.
     */
    Map<String, String> tags();

    /**
     * Gets the identity property: The managed identity information, if configured.
     * 
     * @return the identity value.
     */
    ResourceIdentity identity();

    /**
     * Gets the sku property: The sku of the configuration store.
     * 
     * @return the sku value.
     */
    Sku sku();

    /**
     * Gets the systemData property: Resource system metadata.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

    /**
     * Gets the provisioningState property: The provisioning state of the configuration store.
     * 
     * @return the provisioningState value.
     */
    ProvisioningState provisioningState();

    /**
     * Gets the creationDate property: The creation date of configuration store.
     * 
     * @return the creationDate value.
     */
    OffsetDateTime creationDate();

    /**
     * Gets the endpoint property: The DNS endpoint where the configuration store API will be available.
     * 
     * @return the endpoint value.
     */
    String endpoint();

    /**
     * Gets the encryption property: The encryption settings of the configuration store.
     * 
     * @return the encryption value.
     */
    EncryptionProperties encryption();

    /**
     * Gets the privateEndpointConnections property: The list of private endpoint connections that are set up for this
     * resource.
     * 
     * @return the privateEndpointConnections value.
     */
    List<PrivateEndpointConnectionReference> privateEndpointConnections();

    /**
     * Gets the publicNetworkAccess property: Control permission for data plane traffic coming from public networks
     * while private endpoint is enabled.
     * 
     * @return the publicNetworkAccess value.
     */
    PublicNetworkAccess publicNetworkAccess();

    /**
     * Gets the disableLocalAuth property: Disables all authentication methods other than AAD authentication.
     * 
     * @return the disableLocalAuth value.
     */
    Boolean disableLocalAuth();

    /**
     * Gets the softDeleteRetentionInDays property: The amount of time in days that the configuration store will be
     * retained when it is soft deleted.
     * 
     * @return the softDeleteRetentionInDays value.
     */
    Integer softDeleteRetentionInDays();

    /**
     * Gets the defaultKeyValueRevisionRetentionPeriodInSeconds property: The duration in seconds to retain new key
     * value revisions. Defaults to 604800 (7 days) for Free SKU stores and 2592000 (30 days) for Standard SKU stores
     * and Premium SKU stores.
     * 
     * @return the defaultKeyValueRevisionRetentionPeriodInSeconds value.
     */
    Long defaultKeyValueRevisionRetentionPeriodInSeconds();

    /**
     * Gets the enablePurgeProtection property: Property specifying whether protection against purge is enabled for this
     * configuration store.
     * 
     * @return the enablePurgeProtection value.
     */
    Boolean enablePurgeProtection();

    /**
     * Gets the dataPlaneProxy property: Property specifying the configuration of data plane proxy for Azure Resource
     * Manager (ARM).
     * 
     * @return the dataPlaneProxy value.
     */
    DataPlaneProxyProperties dataPlaneProxy();

    /**
     * Gets the createMode property: Indicates whether the configuration store need to be recovered.
     * 
     * @return the createMode value.
     */
    CreateMode createMode();

    /**
     * Gets the region of the resource.
     * 
     * @return the region of the resource.
     */
    Region region();

    /**
     * Gets the name of the resource region.
     * 
     * @return the name of the resource region.
     */
    String regionName();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.appconfiguration.fluent.models.ConfigurationStoreInner object.
     * 
     * @return the inner object.
     */
    ConfigurationStoreInner innerModel();

    /**
     * The entirety of the ConfigurationStore definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithSku, DefinitionStages.WithCreate {
    }

    /**
     * The ConfigurationStore definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the ConfigurationStore definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify location.
         */
        interface WithLocation {
            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(Region location);

            /**
             * Specifies the region for the resource.
             * 
             * @param location The geo-location where the resource lives.
             * @return the next definition stage.
             */
            WithResourceGroup withRegion(String location);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The name of the resource group to which the container registry belongs.
             * @return the next definition stage.
             */
            WithSku withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: The sku of the configuration store..
             * 
             * @param sku The sku of the configuration store.
             * @return the next definition stage.
             */
            WithCreate withSku(Sku sku);
        }

        /**
         * The stage of the ConfigurationStore definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithTags, DefinitionStages.WithIdentity,
            DefinitionStages.WithEncryption, DefinitionStages.WithPublicNetworkAccess,
            DefinitionStages.WithDisableLocalAuth, DefinitionStages.WithSoftDeleteRetentionInDays,
            DefinitionStages.WithDefaultKeyValueRevisionRetentionPeriodInSeconds,
            DefinitionStages.WithEnablePurgeProtection, DefinitionStages.WithDataPlaneProxy,
            DefinitionStages.WithCreateMode {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            ConfigurationStore create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            ConfigurationStore create(Context context);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Resource tags..
             * 
             * @param tags Resource tags.
             * @return the next definition stage.
             */
            WithCreate withTags(Map<String, String> tags);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: The managed identity information, if configured..
             * 
             * @param identity The managed identity information, if configured.
             * @return the next definition stage.
             */
            WithCreate withIdentity(ResourceIdentity identity);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify encryption.
         */
        interface WithEncryption {
            /**
             * Specifies the encryption property: The encryption settings of the configuration store..
             * 
             * @param encryption The encryption settings of the configuration store.
             * @return the next definition stage.
             */
            WithCreate withEncryption(EncryptionProperties encryption);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify publicNetworkAccess.
         */
        interface WithPublicNetworkAccess {
            /**
             * Specifies the publicNetworkAccess property: Control permission for data plane traffic coming from public
             * networks while private endpoint is enabled..
             * 
             * @param publicNetworkAccess Control permission for data plane traffic coming from public networks while
             * private endpoint is enabled.
             * @return the next definition stage.
             */
            WithCreate withPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify disableLocalAuth.
         */
        interface WithDisableLocalAuth {
            /**
             * Specifies the disableLocalAuth property: Disables all authentication methods other than AAD
             * authentication..
             * 
             * @param disableLocalAuth Disables all authentication methods other than AAD authentication.
             * @return the next definition stage.
             */
            WithCreate withDisableLocalAuth(Boolean disableLocalAuth);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify softDeleteRetentionInDays.
         */
        interface WithSoftDeleteRetentionInDays {
            /**
             * Specifies the softDeleteRetentionInDays property: The amount of time in days that the configuration store
             * will be retained when it is soft deleted..
             * 
             * @param softDeleteRetentionInDays The amount of time in days that the configuration store will be retained
             * when it is soft deleted.
             * @return the next definition stage.
             */
            WithCreate withSoftDeleteRetentionInDays(Integer softDeleteRetentionInDays);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify
         * defaultKeyValueRevisionRetentionPeriodInSeconds.
         */
        interface WithDefaultKeyValueRevisionRetentionPeriodInSeconds {
            /**
             * Specifies the defaultKeyValueRevisionRetentionPeriodInSeconds property: The duration in seconds to retain
             * new key value revisions. Defaults to 604800 (7 days) for Free SKU stores and 2592000 (30 days) for
             * Standard SKU stores and Premium SKU stores..
             * 
             * @param defaultKeyValueRevisionRetentionPeriodInSeconds The duration in seconds to retain new key value
             * revisions. Defaults to 604800 (7 days) for Free SKU stores and 2592000 (30 days) for Standard SKU stores
             * and Premium SKU stores.
             * @return the next definition stage.
             */
            WithCreate withDefaultKeyValueRevisionRetentionPeriodInSeconds(
                Long defaultKeyValueRevisionRetentionPeriodInSeconds);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify enablePurgeProtection.
         */
        interface WithEnablePurgeProtection {
            /**
             * Specifies the enablePurgeProtection property: Property specifying whether protection against purge is
             * enabled for this configuration store..
             * 
             * @param enablePurgeProtection Property specifying whether protection against purge is enabled for this
             * configuration store.
             * @return the next definition stage.
             */
            WithCreate withEnablePurgeProtection(Boolean enablePurgeProtection);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify dataPlaneProxy.
         */
        interface WithDataPlaneProxy {
            /**
             * Specifies the dataPlaneProxy property: Property specifying the configuration of data plane proxy for
             * Azure Resource Manager (ARM)..
             * 
             * @param dataPlaneProxy Property specifying the configuration of data plane proxy for Azure Resource
             * Manager (ARM).
             * @return the next definition stage.
             */
            WithCreate withDataPlaneProxy(DataPlaneProxyProperties dataPlaneProxy);
        }

        /**
         * The stage of the ConfigurationStore definition allowing to specify createMode.
         */
        interface WithCreateMode {
            /**
             * Specifies the createMode property: Indicates whether the configuration store need to be recovered..
             * 
             * @param createMode Indicates whether the configuration store need to be recovered.
             * @return the next definition stage.
             */
            WithCreate withCreateMode(CreateMode createMode);
        }
    }

    /**
     * Begins update for the ConfigurationStore resource.
     * 
     * @return the stage of resource update.
     */
    ConfigurationStore.Update update();

    /**
     * The template for ConfigurationStore update.
     */
    interface Update
        extends UpdateStages.WithTags, UpdateStages.WithIdentity, UpdateStages.WithSku, UpdateStages.WithEncryption,
        UpdateStages.WithDisableLocalAuth, UpdateStages.WithPublicNetworkAccess, UpdateStages.WithEnablePurgeProtection,
        UpdateStages.WithDataPlaneProxy, UpdateStages.WithDefaultKeyValueRevisionRetentionPeriodInSeconds {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        ConfigurationStore apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        ConfigurationStore apply(Context context);
    }

    /**
     * The ConfigurationStore update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the ConfigurationStore update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: The ARM resource tags..
             * 
             * @param tags The ARM resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: The managed identity information for the configuration store..
             * 
             * @param identity The managed identity information for the configuration store.
             * @return the next definition stage.
             */
            Update withIdentity(ResourceIdentity identity);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify sku.
         */
        interface WithSku {
            /**
             * Specifies the sku property: The SKU of the configuration store..
             * 
             * @param sku The SKU of the configuration store.
             * @return the next definition stage.
             */
            Update withSku(Sku sku);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify encryption.
         */
        interface WithEncryption {
            /**
             * Specifies the encryption property: The encryption settings of the configuration store..
             * 
             * @param encryption The encryption settings of the configuration store.
             * @return the next definition stage.
             */
            Update withEncryption(EncryptionProperties encryption);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify disableLocalAuth.
         */
        interface WithDisableLocalAuth {
            /**
             * Specifies the disableLocalAuth property: Disables all authentication methods other than AAD
             * authentication..
             * 
             * @param disableLocalAuth Disables all authentication methods other than AAD authentication.
             * @return the next definition stage.
             */
            Update withDisableLocalAuth(Boolean disableLocalAuth);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify publicNetworkAccess.
         */
        interface WithPublicNetworkAccess {
            /**
             * Specifies the publicNetworkAccess property: Control permission for data plane traffic coming from public
             * networks while private endpoint is enabled..
             * 
             * @param publicNetworkAccess Control permission for data plane traffic coming from public networks while
             * private endpoint is enabled.
             * @return the next definition stage.
             */
            Update withPublicNetworkAccess(PublicNetworkAccess publicNetworkAccess);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify enablePurgeProtection.
         */
        interface WithEnablePurgeProtection {
            /**
             * Specifies the enablePurgeProtection property: Property specifying whether protection against purge is
             * enabled for this configuration store..
             * 
             * @param enablePurgeProtection Property specifying whether protection against purge is enabled for this
             * configuration store.
             * @return the next definition stage.
             */
            Update withEnablePurgeProtection(Boolean enablePurgeProtection);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify dataPlaneProxy.
         */
        interface WithDataPlaneProxy {
            /**
             * Specifies the dataPlaneProxy property: Property specifying the configuration of data plane proxy for
             * Azure Resource Manager (ARM)..
             * 
             * @param dataPlaneProxy Property specifying the configuration of data plane proxy for Azure Resource
             * Manager (ARM).
             * @return the next definition stage.
             */
            Update withDataPlaneProxy(DataPlaneProxyProperties dataPlaneProxy);
        }

        /**
         * The stage of the ConfigurationStore update allowing to specify
         * defaultKeyValueRevisionRetentionPeriodInSeconds.
         */
        interface WithDefaultKeyValueRevisionRetentionPeriodInSeconds {
            /**
             * Specifies the defaultKeyValueRevisionRetentionPeriodInSeconds property: The duration in seconds to retain
             * new key value revisions. Defaults to 604800 (7 days) for Free SKU stores and 2592000 (30 days) for
             * Standard SKU stores and Premium SKU stores..
             * 
             * @param defaultKeyValueRevisionRetentionPeriodInSeconds The duration in seconds to retain new key value
             * revisions. Defaults to 604800 (7 days) for Free SKU stores and 2592000 (30 days) for Standard SKU stores
             * and Premium SKU stores.
             * @return the next definition stage.
             */
            Update withDefaultKeyValueRevisionRetentionPeriodInSeconds(
                Long defaultKeyValueRevisionRetentionPeriodInSeconds);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    ConfigurationStore refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    ConfigurationStore refresh(Context context);

    /**
     * Lists the access key for the specified configuration store.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the result of a request to list API keys as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ApiKey> listKeys();

    /**
     * Lists the access key for the specified configuration store.
     * 
     * @param skipToken A skip token is used to continue retrieving items after an operation returns a partial result.
     * If a previous response contains a nextLink element, the value of the nextLink element will include a skipToken
     * parameter that specifies a starting point to use for subsequent calls.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the result of a request to list API keys as paginated response with {@link PagedIterable}.
     */
    PagedIterable<ApiKey> listKeys(String skipToken, Context context);

    /**
     * Regenerates an access key for the specified configuration store.
     * 
     * @param regenerateKeyParameters The parameters for regenerating an access key.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an API key used for authenticating with a configuration store endpoint along with {@link Response}.
     */
    Response<ApiKey> regenerateKeyWithResponse(RegenerateKeyParameters regenerateKeyParameters, Context context);

    /**
     * Regenerates an access key for the specified configuration store.
     * 
     * @param regenerateKeyParameters The parameters for regenerating an access key.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return an API key used for authenticating with a configuration store endpoint.
     */
    ApiKey regenerateKey(RegenerateKeyParameters regenerateKeyParameters);
}
