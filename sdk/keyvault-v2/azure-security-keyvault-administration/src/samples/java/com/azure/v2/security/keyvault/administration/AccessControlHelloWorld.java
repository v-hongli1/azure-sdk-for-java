// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.security.keyvault.administration;

import com.azure.v2.identity.DefaultAzureCredentialBuilder;
import com.azure.v2.security.keyvault.administration.models.KeyVaultRoleAssignment;
import com.azure.v2.security.keyvault.administration.models.KeyVaultRoleDefinition;
import com.azure.v2.security.keyvault.administration.models.KeyVaultRoleScope;

import java.util.ArrayList;
import java.util.List;

/**
 * This sample demonstrates how to create, get, list and delete role assignments in the key vault.
 */
public class AccessControlHelloWorld {
    /**
     * Authenticates with the key vault and shows how to create, get, list and delete role assignments.
     *
     * @param args Unused. Arguments to the program.
     * @throws IllegalArgumentException when an invalid key vault URL is passed.
     */
    public static void main(String[] args) {
        /* Instantiate a KeyVaultAccessControlClient that will be used to call the service. Notice that the client is
        using default Azure credentials. For more information on this and other types of credentials, see this document:
        https://docs.microsoft.com/java/api/overview/azure/identity-readme?view=azure-java-stable.

        To get started, you'll need a URL to an Azure Key Vault Managed HSM. See the README
        (https://github.com/vcolin7/azure-sdk-for-java/blob/feature/vicolina/keyvault/v2/sdk/keyvault-v2/azure-security-keyvault-administration/README.md)
        for links and instructions. */
        KeyVaultAccessControlClient accessControlClient = new KeyVaultAccessControlClientBuilder()
            .endpoint("<your-managed-hsm-url>")
            .credential(new DefaultAzureCredentialBuilder().build())
            .buildClient();

        /* In order to assign a role to a service principal, we'll have to know which role definitions are available.
        Let's get all of them. */
        List<KeyVaultRoleDefinition> roleDefinitions = new ArrayList<>();

        for (KeyVaultRoleDefinition roleDefinition : accessControlClient.listRoleDefinitions(KeyVaultRoleScope.GLOBAL)) {
            roleDefinitions.add(roleDefinition);
            System.out.printf("Retrieved role definition with name: %s %n", roleDefinition.getName());
        }

        // Before assigning any new roles, let's list all the current role assignments.
        for (KeyVaultRoleAssignment roleAssignment : accessControlClient.listRoleAssignments(KeyVaultRoleScope.GLOBAL)) {
            System.out.printf("Retrieved role assignment with name: %s %n", roleAssignment.getName());
        }

        /* Now let's assign a role to a service principal. To do this we'll need a role definition ID and a service
        principal object ID. A role definition ID can be obtained from the 'id' property of one of the role definitions
        returned from listRoleAssignments().

        See the README (https://github.com/vcolin7/azure-sdk-for-java/blob/feature/vicolina/keyvault/v2/sdk/keyvault-v2/azure-security-keyvault-administration/README.md#authenticate-the-client)
        for links and instructions on how to generate a new service principal and obtain it's object ID. You can also
        get the object ID for your currently signed in account by running the following Azure CLI command:
        az ad signed-in-user show --query objectId */
        String servicePrincipalId = "<service-principal-id>";
        KeyVaultRoleDefinition roleDefinition = roleDefinitions.get(0);
        KeyVaultRoleAssignment createdRoleAssignment =
            accessControlClient.createRoleAssignment(KeyVaultRoleScope.GLOBAL, roleDefinition.getId(),
                servicePrincipalId);

        System.out.printf("Created role assignment with name: %s %n", createdRoleAssignment.getName());

        /* To get an existing role assignment, we'll need the 'name' property from an existing assignment. Let's use the
        createdAssignment from the previous example. */
        KeyVaultRoleAssignment retrievedRoleAssignment =
            accessControlClient.getRoleAssignment(KeyVaultRoleScope.GLOBAL, createdRoleAssignment.getName());

        System.out.printf("Retrieved role assignment with name: %s %n", retrievedRoleAssignment.getName());

        /* To remove a role assignment from a service principal, the role assignment must be deleted. Let's delete the
        createdAssignment from the previous example. */
        accessControlClient.deleteRoleAssignment(KeyVaultRoleScope.GLOBAL, createdRoleAssignment.getName());

        System.out.printf("Deleted role assignment with name: %s %n", createdRoleAssignment.getName());
    }
}

