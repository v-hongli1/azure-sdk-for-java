// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.customerinsights.models;

import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.customerinsights.fluent.models.PredictionModelStatusInner;
import com.azure.resourcemanager.customerinsights.fluent.models.PredictionResourceFormatInner;
import java.util.List;
import java.util.Map;

/**
 * An immutable client-side representation of PredictionResourceFormat.
 */
public interface PredictionResourceFormat {
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
     * Gets the description property: Description of the prediction.
     * 
     * @return the description value.
     */
    Map<String, String> description();

    /**
     * Gets the displayName property: Display name of the prediction.
     * 
     * @return the displayName value.
     */
    Map<String, String> displayName();

    /**
     * Gets the involvedInteractionTypes property: Interaction types involved in the prediction.
     * 
     * @return the involvedInteractionTypes value.
     */
    List<String> involvedInteractionTypes();

    /**
     * Gets the involvedKpiTypes property: KPI types involved in the prediction.
     * 
     * @return the involvedKpiTypes value.
     */
    List<String> involvedKpiTypes();

    /**
     * Gets the involvedRelationships property: Relationships involved in the prediction.
     * 
     * @return the involvedRelationships value.
     */
    List<String> involvedRelationships();

    /**
     * Gets the negativeOutcomeExpression property: Negative outcome expression.
     * 
     * @return the negativeOutcomeExpression value.
     */
    String negativeOutcomeExpression();

    /**
     * Gets the positiveOutcomeExpression property: Positive outcome expression.
     * 
     * @return the positiveOutcomeExpression value.
     */
    String positiveOutcomeExpression();

    /**
     * Gets the primaryProfileType property: Primary profile type.
     * 
     * @return the primaryProfileType value.
     */
    String primaryProfileType();

    /**
     * Gets the provisioningState property: Provisioning state.
     * 
     * @return the provisioningState value.
     */
    ProvisioningStates provisioningState();

    /**
     * Gets the predictionName property: Name of the prediction.
     * 
     * @return the predictionName value.
     */
    String predictionName();

    /**
     * Gets the scopeExpression property: Scope expression.
     * 
     * @return the scopeExpression value.
     */
    String scopeExpression();

    /**
     * Gets the tenantId property: The hub name.
     * 
     * @return the tenantId value.
     */
    String tenantId();

    /**
     * Gets the autoAnalyze property: Whether do auto analyze.
     * 
     * @return the autoAnalyze value.
     */
    boolean autoAnalyze();

    /**
     * Gets the mappings property: Definition of the link mapping of prediction.
     * 
     * @return the mappings value.
     */
    PredictionMappings mappings();

    /**
     * Gets the scoreLabel property: Score label.
     * 
     * @return the scoreLabel value.
     */
    String scoreLabel();

    /**
     * Gets the grades property: The prediction grades.
     * 
     * @return the grades value.
     */
    List<PredictionGradesItem> grades();

    /**
     * Gets the systemGeneratedEntities property: System generated entities.
     * 
     * @return the systemGeneratedEntities value.
     */
    PredictionSystemGeneratedEntities systemGeneratedEntities();

    /**
     * Gets the name of the resource group.
     * 
     * @return the name of the resource group.
     */
    String resourceGroupName();

    /**
     * Gets the inner com.azure.resourcemanager.customerinsights.fluent.models.PredictionResourceFormatInner object.
     * 
     * @return the inner object.
     */
    PredictionResourceFormatInner innerModel();

    /**
     * The entirety of the PredictionResourceFormat definition.
     */
    interface Definition
        extends DefinitionStages.Blank, DefinitionStages.WithParentResource, DefinitionStages.WithCreate {
    }

    /**
     * The PredictionResourceFormat definition stages.
     */
    interface DefinitionStages {
        /**
         * The first stage of the PredictionResourceFormat definition.
         */
        interface Blank extends WithParentResource {
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify parent resource.
         */
        interface WithParentResource {
            /**
             * Specifies resourceGroupName, hubName.
             * 
             * @param resourceGroupName The name of the resource group.
             * @param hubName The name of the hub.
             * @return the next definition stage.
             */
            WithCreate withExistingHub(String resourceGroupName, String hubName);
        }

        /**
         * The stage of the PredictionResourceFormat definition which contains all the minimum required properties for
         * the resource to be created, but also allows for any other optional properties to be specified.
         */
        interface WithCreate extends DefinitionStages.WithDescription, DefinitionStages.WithDisplayName,
            DefinitionStages.WithInvolvedInteractionTypes, DefinitionStages.WithInvolvedKpiTypes,
            DefinitionStages.WithInvolvedRelationships, DefinitionStages.WithNegativeOutcomeExpression,
            DefinitionStages.WithPositiveOutcomeExpression, DefinitionStages.WithPrimaryProfileType,
            DefinitionStages.WithPredictionName, DefinitionStages.WithScopeExpression, DefinitionStages.WithAutoAnalyze,
            DefinitionStages.WithMappings, DefinitionStages.WithScoreLabel, DefinitionStages.WithGrades {
            /**
             * Executes the create request.
             * 
             * @return the created resource.
             */
            PredictionResourceFormat create();

            /**
             * Executes the create request.
             * 
             * @param context The context to associate with this operation.
             * @return the created resource.
             */
            PredictionResourceFormat create(Context context);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description of the prediction..
             * 
             * @param description Description of the prediction.
             * @return the next definition stage.
             */
            WithCreate withDescription(Map<String, String> description);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify displayName.
         */
        interface WithDisplayName {
            /**
             * Specifies the displayName property: Display name of the prediction..
             * 
             * @param displayName Display name of the prediction.
             * @return the next definition stage.
             */
            WithCreate withDisplayName(Map<String, String> displayName);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify involvedInteractionTypes.
         */
        interface WithInvolvedInteractionTypes {
            /**
             * Specifies the involvedInteractionTypes property: Interaction types involved in the prediction..
             * 
             * @param involvedInteractionTypes Interaction types involved in the prediction.
             * @return the next definition stage.
             */
            WithCreate withInvolvedInteractionTypes(List<String> involvedInteractionTypes);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify involvedKpiTypes.
         */
        interface WithInvolvedKpiTypes {
            /**
             * Specifies the involvedKpiTypes property: KPI types involved in the prediction..
             * 
             * @param involvedKpiTypes KPI types involved in the prediction.
             * @return the next definition stage.
             */
            WithCreate withInvolvedKpiTypes(List<String> involvedKpiTypes);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify involvedRelationships.
         */
        interface WithInvolvedRelationships {
            /**
             * Specifies the involvedRelationships property: Relationships involved in the prediction..
             * 
             * @param involvedRelationships Relationships involved in the prediction.
             * @return the next definition stage.
             */
            WithCreate withInvolvedRelationships(List<String> involvedRelationships);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify negativeOutcomeExpression.
         */
        interface WithNegativeOutcomeExpression {
            /**
             * Specifies the negativeOutcomeExpression property: Negative outcome expression..
             * 
             * @param negativeOutcomeExpression Negative outcome expression.
             * @return the next definition stage.
             */
            WithCreate withNegativeOutcomeExpression(String negativeOutcomeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify positiveOutcomeExpression.
         */
        interface WithPositiveOutcomeExpression {
            /**
             * Specifies the positiveOutcomeExpression property: Positive outcome expression..
             * 
             * @param positiveOutcomeExpression Positive outcome expression.
             * @return the next definition stage.
             */
            WithCreate withPositiveOutcomeExpression(String positiveOutcomeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify primaryProfileType.
         */
        interface WithPrimaryProfileType {
            /**
             * Specifies the primaryProfileType property: Primary profile type..
             * 
             * @param primaryProfileType Primary profile type.
             * @return the next definition stage.
             */
            WithCreate withPrimaryProfileType(String primaryProfileType);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify predictionName.
         */
        interface WithPredictionName {
            /**
             * Specifies the predictionName property: Name of the prediction..
             * 
             * @param predictionName Name of the prediction.
             * @return the next definition stage.
             */
            WithCreate withPredictionName(String predictionName);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify scopeExpression.
         */
        interface WithScopeExpression {
            /**
             * Specifies the scopeExpression property: Scope expression..
             * 
             * @param scopeExpression Scope expression.
             * @return the next definition stage.
             */
            WithCreate withScopeExpression(String scopeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify autoAnalyze.
         */
        interface WithAutoAnalyze {
            /**
             * Specifies the autoAnalyze property: Whether do auto analyze..
             * 
             * @param autoAnalyze Whether do auto analyze.
             * @return the next definition stage.
             */
            WithCreate withAutoAnalyze(boolean autoAnalyze);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify mappings.
         */
        interface WithMappings {
            /**
             * Specifies the mappings property: Definition of the link mapping of prediction..
             * 
             * @param mappings Definition of the link mapping of prediction.
             * @return the next definition stage.
             */
            WithCreate withMappings(PredictionMappings mappings);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify scoreLabel.
         */
        interface WithScoreLabel {
            /**
             * Specifies the scoreLabel property: Score label..
             * 
             * @param scoreLabel Score label.
             * @return the next definition stage.
             */
            WithCreate withScoreLabel(String scoreLabel);
        }

        /**
         * The stage of the PredictionResourceFormat definition allowing to specify grades.
         */
        interface WithGrades {
            /**
             * Specifies the grades property: The prediction grades..
             * 
             * @param grades The prediction grades.
             * @return the next definition stage.
             */
            WithCreate withGrades(List<PredictionGradesItem> grades);
        }
    }

    /**
     * Begins update for the PredictionResourceFormat resource.
     * 
     * @return the stage of resource update.
     */
    PredictionResourceFormat.Update update();

    /**
     * The template for PredictionResourceFormat update.
     */
    interface Update
        extends UpdateStages.WithDescription, UpdateStages.WithDisplayName, UpdateStages.WithInvolvedInteractionTypes,
        UpdateStages.WithInvolvedKpiTypes, UpdateStages.WithInvolvedRelationships,
        UpdateStages.WithNegativeOutcomeExpression, UpdateStages.WithPositiveOutcomeExpression,
        UpdateStages.WithPrimaryProfileType, UpdateStages.WithPredictionName, UpdateStages.WithScopeExpression,
        UpdateStages.WithAutoAnalyze, UpdateStages.WithMappings, UpdateStages.WithScoreLabel, UpdateStages.WithGrades {
        /**
         * Executes the update request.
         * 
         * @return the updated resource.
         */
        PredictionResourceFormat apply();

        /**
         * Executes the update request.
         * 
         * @param context The context to associate with this operation.
         * @return the updated resource.
         */
        PredictionResourceFormat apply(Context context);
    }

    /**
     * The PredictionResourceFormat update stages.
     */
    interface UpdateStages {
        /**
         * The stage of the PredictionResourceFormat update allowing to specify description.
         */
        interface WithDescription {
            /**
             * Specifies the description property: Description of the prediction..
             * 
             * @param description Description of the prediction.
             * @return the next definition stage.
             */
            Update withDescription(Map<String, String> description);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify displayName.
         */
        interface WithDisplayName {
            /**
             * Specifies the displayName property: Display name of the prediction..
             * 
             * @param displayName Display name of the prediction.
             * @return the next definition stage.
             */
            Update withDisplayName(Map<String, String> displayName);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify involvedInteractionTypes.
         */
        interface WithInvolvedInteractionTypes {
            /**
             * Specifies the involvedInteractionTypes property: Interaction types involved in the prediction..
             * 
             * @param involvedInteractionTypes Interaction types involved in the prediction.
             * @return the next definition stage.
             */
            Update withInvolvedInteractionTypes(List<String> involvedInteractionTypes);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify involvedKpiTypes.
         */
        interface WithInvolvedKpiTypes {
            /**
             * Specifies the involvedKpiTypes property: KPI types involved in the prediction..
             * 
             * @param involvedKpiTypes KPI types involved in the prediction.
             * @return the next definition stage.
             */
            Update withInvolvedKpiTypes(List<String> involvedKpiTypes);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify involvedRelationships.
         */
        interface WithInvolvedRelationships {
            /**
             * Specifies the involvedRelationships property: Relationships involved in the prediction..
             * 
             * @param involvedRelationships Relationships involved in the prediction.
             * @return the next definition stage.
             */
            Update withInvolvedRelationships(List<String> involvedRelationships);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify negativeOutcomeExpression.
         */
        interface WithNegativeOutcomeExpression {
            /**
             * Specifies the negativeOutcomeExpression property: Negative outcome expression..
             * 
             * @param negativeOutcomeExpression Negative outcome expression.
             * @return the next definition stage.
             */
            Update withNegativeOutcomeExpression(String negativeOutcomeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify positiveOutcomeExpression.
         */
        interface WithPositiveOutcomeExpression {
            /**
             * Specifies the positiveOutcomeExpression property: Positive outcome expression..
             * 
             * @param positiveOutcomeExpression Positive outcome expression.
             * @return the next definition stage.
             */
            Update withPositiveOutcomeExpression(String positiveOutcomeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify primaryProfileType.
         */
        interface WithPrimaryProfileType {
            /**
             * Specifies the primaryProfileType property: Primary profile type..
             * 
             * @param primaryProfileType Primary profile type.
             * @return the next definition stage.
             */
            Update withPrimaryProfileType(String primaryProfileType);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify predictionName.
         */
        interface WithPredictionName {
            /**
             * Specifies the predictionName property: Name of the prediction..
             * 
             * @param predictionName Name of the prediction.
             * @return the next definition stage.
             */
            Update withPredictionName(String predictionName);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify scopeExpression.
         */
        interface WithScopeExpression {
            /**
             * Specifies the scopeExpression property: Scope expression..
             * 
             * @param scopeExpression Scope expression.
             * @return the next definition stage.
             */
            Update withScopeExpression(String scopeExpression);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify autoAnalyze.
         */
        interface WithAutoAnalyze {
            /**
             * Specifies the autoAnalyze property: Whether do auto analyze..
             * 
             * @param autoAnalyze Whether do auto analyze.
             * @return the next definition stage.
             */
            Update withAutoAnalyze(boolean autoAnalyze);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify mappings.
         */
        interface WithMappings {
            /**
             * Specifies the mappings property: Definition of the link mapping of prediction..
             * 
             * @param mappings Definition of the link mapping of prediction.
             * @return the next definition stage.
             */
            Update withMappings(PredictionMappings mappings);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify scoreLabel.
         */
        interface WithScoreLabel {
            /**
             * Specifies the scoreLabel property: Score label..
             * 
             * @param scoreLabel Score label.
             * @return the next definition stage.
             */
            Update withScoreLabel(String scoreLabel);
        }

        /**
         * The stage of the PredictionResourceFormat update allowing to specify grades.
         */
        interface WithGrades {
            /**
             * Specifies the grades property: The prediction grades..
             * 
             * @param grades The prediction grades.
             * @return the next definition stage.
             */
            Update withGrades(List<PredictionGradesItem> grades);
        }
    }

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @return the refreshed resource.
     */
    PredictionResourceFormat refresh();

    /**
     * Refreshes the resource to sync with Azure.
     * 
     * @param context The context to associate with this operation.
     * @return the refreshed resource.
     */
    PredictionResourceFormat refresh(Context context);

    /**
     * Gets training results.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return training results along with {@link Response}.
     */
    Response<PredictionTrainingResults> getTrainingResultsWithResponse(Context context);

    /**
     * Gets training results.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return training results.
     */
    PredictionTrainingResults getTrainingResults();

    /**
     * Gets model status of the prediction.
     * 
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return model status of the prediction along with {@link Response}.
     */
    Response<PredictionModelStatus> getModelStatusWithResponse(Context context);

    /**
     * Gets model status of the prediction.
     * 
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return model status of the prediction.
     */
    PredictionModelStatus getModelStatus();

    /**
     * Creates or updates the model status of prediction.
     * 
     * @param parameters Parameters supplied to the create/update prediction model status operation.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    Response<Void> modelStatusWithResponse(PredictionModelStatusInner parameters, Context context);

    /**
     * Creates or updates the model status of prediction.
     * 
     * @param parameters Parameters supplied to the create/update prediction model status operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    void modelStatus(PredictionModelStatusInner parameters);
}
