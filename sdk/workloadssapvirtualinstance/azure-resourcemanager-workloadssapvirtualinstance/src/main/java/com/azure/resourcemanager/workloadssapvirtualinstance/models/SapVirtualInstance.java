// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.workloadssapvirtualinstance.models;

import com.azure.core.management.Region;
import com.azure.core.management.SystemData;
import com.azure.core.util.Context;
import com.azure.resourcemanager.workloadssapvirtualinstance.fluent.models.SapVirtualInstanceInner;
import java.util.Map;

/**
 * An immutable client-side representation of SapVirtualInstance.
 */
public interface SapVirtualInstance {
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
     * Gets the properties property: The resource-specific properties for this resource.
     * 
     * @return the properties value.
     */
    SapVirtualInstanceProperties properties();

    /**
     * Gets the identity property: The managed service identities assigned to this resource.
     * 
     * @return the identity value.
     */
    SAPVirtualInstanceIdentity identity();

    /**
     * Gets the systemData property: Azure Resource Manager metadata containing createdBy and modifiedBy information.
     * 
     * @return the systemData value.
     */
    SystemData systemData();

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
     * Gets the inner com.azure.resourcemanager.workloadssapvirtualinstance.fluent.models.SapVirtualInstanceInner
     * object.
     * 
     * @return the inner object.
     */
    SapVirtualInstanceInner innerModel();

    /**
     * The entirety of the SapVirtualInstance definition.
     */
    interface Definition extends DefinitionStages.Blank, DefinitionStages.WithLocation,
        DefinitionStages.WithResourceGroup, DefinitionStages.WithCreate {
    }

    /**
     * The SapVirtualInstance definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the SapVirtualInstance definition.
         */
        interface Blank extends WithLocation {
        }

        /**
         * The stage of the SapVirtualInstance definition allowing to specify location.
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
         * The stage of the SapVirtualInstance definition allowing to specify parent resource.
         */
        interface WithResourceGroup {
            /**
             * Specifies resourceGroupName.
             * 
             * @param resourceGroupName The name of the resource group. The name is case insensitive.
             * @return the next definition stage.
             */
            WithCreate withExistingResourceGroup(String resourceGroupName);
        }

        /**
         * The stage of the SapVirtualInstance definition which contains all the minimum required properties for the
         * resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate
            extends DefinitionStages.WithTags, DefinitionStages.WithProperties, DefinitionStages.WithIdentity {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            SapVirtualInstance create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            SapVirtualInstance create(Context context);
        }

        /**
         * The stage of the SapVirtualInstance definition allowing to specify tags.
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
         * The stage of the SapVirtualInstance definition allowing to specify properties.
         */
        interface WithProperties {
            /**
             * Specifies the properties property: The resource-specific properties for this resource..
             * 
             * @param properties The resource-specific properties for this resource.
             * @return the next definition stage.
             */
            WithCreate withProperties(SapVirtualInstanceProperties properties);
        }

        /**
         * The stage of the SapVirtualInstance definition allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: The managed service identities assigned to this resource..
             * 
             * @param identity The managed service identities assigned to this resource.
             * @return the next definition stage.
             */
            WithCreate withIdentity(SAPVirtualInstanceIdentity identity);
        }
    }

    /**
     * Begins update for the SapVirtualInstance resource.
     * 
     * @return the stage of resource update.
     */
    SapVirtualInstance.Update update();

    /**
     * The template for SapVirtualInstance update.
     */
    interface Update extends UpdateStages.WithTags, UpdateStages.WithIdentity, UpdateStages.WithProperties {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        SapVirtualInstance apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        SapVirtualInstance apply(Context context);
    }

    /**
     * The SapVirtualInstance update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the SapVirtualInstance update allowing to specify tags.
         */
        interface WithTags {
            /**
             * Specifies the tags property: Gets or sets the Resource tags..
             * 
             * @param tags Gets or sets the Resource tags.
             * @return the next definition stage.
             */
            Update withTags(Map<String, String> tags);
        }

        /**
         * The stage of the SapVirtualInstance update allowing to specify identity.
         */
        interface WithIdentity {
            /**
             * Specifies the identity property: Managed service identity (user assigned identities).
             * 
             * @param identity Managed service identity (user assigned identities).
             * @return the next definition stage.
             */
            Update withIdentity(SAPVirtualInstanceIdentity identity);
        }

        /**
         * The stage of the SapVirtualInstance update allowing to specify properties.
         */
        interface WithProperties {
            /**
             * Specifies the properties property: The update properties..
             * 
             * @param properties The update properties.
             * @return the next definition stage.
             */
            Update withProperties(UpdateSapVirtualInstanceProperties properties);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    SapVirtualInstance refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    SapVirtualInstance refresh(Context context);

    /**
     * Starts the SAP application, that is the Central Services instance and Application server instances.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    OperationStatusResult start();

    /**
     * Starts the SAP application, that is the Central Services instance and Application server instances.
     * 
     * @param body The Virtual Instance for SAP solutions resource start request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    OperationStatusResult start(StartRequest body, Context context);

    /**
     * Stops the SAP Application, that is the Application server instances and Central Services instance.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    OperationStatusResult stop();

    /**
     * Stops the SAP Application, that is the Application server instances and Central Services instance.
     * 
     * @param body The Virtual Instance for SAP solutions resource stop request body.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the response.
     */
    OperationStatusResult stop(StopRequest body, Context context);
}
