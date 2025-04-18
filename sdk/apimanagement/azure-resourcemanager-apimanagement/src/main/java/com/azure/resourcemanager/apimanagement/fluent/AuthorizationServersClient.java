// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.apimanagement.fluent;

import com.azure.core.annotation.ReturnType;
import com.azure.core.annotation.ServiceMethod;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.http.rest.Response;
import com.azure.core.util.Context;
import com.azure.resourcemanager.apimanagement.fluent.models.AuthorizationServerContractInner;
import com.azure.resourcemanager.apimanagement.fluent.models.AuthorizationServerSecretsContractInner;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServerUpdateContract;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServersCreateOrUpdateResponse;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServersGetEntityTagResponse;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServersGetResponse;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServersListSecretsResponse;
import com.azure.resourcemanager.apimanagement.models.AuthorizationServersUpdateResponse;

/**
 * An instance of this class provides access to all the operations defined in AuthorizationServersClient.
 */
public interface AuthorizationServersClient {
    /**
     * Lists a collection of authorization servers defined within a service instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged OAuth2 Authorization Servers list representation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AuthorizationServerContractInner> listByService(String resourceGroupName, String serviceName);

    /**
     * Lists a collection of authorization servers defined within a service instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param filter | Field | Usage | Supported operators | Supported functions
     * |&lt;/br&gt;|-------------|-------------|-------------|-------------|&lt;/br&gt;| name | filter | ge, le, eq, ne,
     * gt, lt | substringof, contains, startswith, endswith |&lt;/br&gt;| displayName | filter | ge, le, eq, ne, gt, lt
     * | substringof, contains, startswith, endswith |&lt;/br&gt;.
     * @param top Number of records to return.
     * @param skip Number of records to skip.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return paged OAuth2 Authorization Servers list representation as paginated response with {@link PagedIterable}.
     */
    @ServiceMethod(returns = ReturnType.COLLECTION)
    PagedIterable<AuthorizationServerContractInner> listByService(String resourceGroupName, String serviceName,
        String filter, Integer top, Integer skip, Context context);

    /**
     * Gets the entity state (Etag) version of the authorizationServer specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the entity state (Etag) version of the authorizationServer specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServersGetEntityTagResponse getEntityTagWithResponse(String resourceGroupName, String serviceName,
        String authsid, Context context);

    /**
     * Gets the entity state (Etag) version of the authorizationServer specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void getEntityTag(String resourceGroupName, String serviceName, String authsid);

    /**
     * Gets the details of the authorization server specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the authorization server specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServersGetResponse getWithResponse(String resourceGroupName, String serviceName, String authsid,
        Context context);

    /**
     * Gets the details of the authorization server specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the details of the authorization server specified by its identifier.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServerContractInner get(String resourceGroupName, String serviceName, String authsid);

    /**
     * Creates new authorization server or updates an existing authorization server.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param parameters Create or update parameters.
     * @param ifMatch ETag of the Entity. Not required when creating an entity, but required when updating an entity.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return external OAuth authorization server settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServersCreateOrUpdateResponse createOrUpdateWithResponse(String resourceGroupName, String serviceName,
        String authsid, AuthorizationServerContractInner parameters, String ifMatch, Context context);

    /**
     * Creates new authorization server or updates an existing authorization server.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param parameters Create or update parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return external OAuth authorization server settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServerContractInner createOrUpdate(String resourceGroupName, String serviceName, String authsid,
        AuthorizationServerContractInner parameters);

    /**
     * Updates the details of the authorization server specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param parameters OAuth2 Server settings Update parameters.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return external OAuth authorization server settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServersUpdateResponse updateWithResponse(String resourceGroupName, String serviceName, String authsid,
        String ifMatch, AuthorizationServerUpdateContract parameters, Context context);

    /**
     * Updates the details of the authorization server specified by its identifier.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param parameters OAuth2 Server settings Update parameters.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return external OAuth authorization server settings.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServerContractInner update(String resourceGroupName, String serviceName, String authsid,
        String ifMatch, AuthorizationServerUpdateContract parameters);

    /**
     * Deletes specific authorization server instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the {@link Response}.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    Response<Void> deleteWithResponse(String resourceGroupName, String serviceName, String authsid, String ifMatch,
        Context context);

    /**
     * Deletes specific authorization server instance.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param ifMatch ETag of the Entity. ETag should match the current entity state from the header response of the GET
     * request or it should be * for unconditional update.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    void delete(String resourceGroupName, String serviceName, String authsid, String ifMatch);

    /**
     * Gets the client secret details of the authorization server.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @param context The context to associate with this operation.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the client secret details of the authorization server.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServersListSecretsResponse listSecretsWithResponse(String resourceGroupName, String serviceName,
        String authsid, Context context);

    /**
     * Gets the client secret details of the authorization server.
     * 
     * @param resourceGroupName The name of the resource group. The name is case insensitive.
     * @param serviceName The name of the API Management service.
     * @param authsid Identifier of the authorization server.
     * @throws IllegalArgumentException thrown if parameters fail the validation.
     * @throws com.azure.core.management.exception.ManagementException thrown if the request is rejected by server.
     * @throws RuntimeException all other wrapped checked exceptions if the request fails to be sent.
     * @return the client secret details of the authorization server.
     */
    @ServiceMethod(returns = ReturnType.SINGLE)
    AuthorizationServerSecretsContractInner listSecrets(String resourceGroupName, String serviceName, String authsid);
}
