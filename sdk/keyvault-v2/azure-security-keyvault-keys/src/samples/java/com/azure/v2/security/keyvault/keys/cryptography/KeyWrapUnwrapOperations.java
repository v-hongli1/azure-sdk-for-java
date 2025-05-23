// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.v2.security.keyvault.keys.cryptography;

import com.azure.v2.identity.DefaultAzureCredentialBuilder;
import com.azure.v2.security.keyvault.keys.cryptography.models.KeyWrapAlgorithm;
import com.azure.v2.security.keyvault.keys.cryptography.models.UnwrapResult;
import com.azure.v2.security.keyvault.keys.cryptography.models.WrapResult;

import java.util.Random;


/**
 * Sample demonstrates how to set, get, update and delete a key.
 */
public class KeyWrapUnwrapOperations {
    /**
     * Authenticates with the key vault and shows how to set, get, update and delete a key in the key vault.
     *
     * @param args Unused. Arguments to the program.
     *
     * @throws IllegalArgumentException when invalid key vault endpoint is passed.
     * @throws InterruptedException when the thread is interrupted in sleep mode.
     */
    public static void main(String[] args) throws InterruptedException, IllegalArgumentException {
        /* Instantiate a CryptographyClient that will be used to call the service. Notice that the client is using
        default Azure credentials. For more information on this and other types of credentials, see this document:
        https://docs.microsoft.com/java/api/overview/azure/identity-readme?view=azure-java-stable.

        To get started, you'll need a key identifier for a key stored in a key vault. See the README
        (https://github.com/vcolin7/azure-sdk-for-java/blob/feature/vicolina/keyvault/v2/sdk/keyvault-v2/azure-security-keyvault-keys/README.md)
        for links and instructions. */
        CryptographyClient cryptoClient = new CryptographyClientBuilder()
            .credential(new DefaultAzureCredentialBuilder().build())
            .keyIdentifier("<your-key-id-from-keyvault")
            .buildClient();

        byte[] plaintext = new byte[100];
        new Random(0x1234567L).nextBytes(plaintext);

        // Let's wrap a simple dummy key content.
        WrapResult wrapResult = cryptoClient.wrapKey(KeyWrapAlgorithm.RSA_OAEP, plaintext);

        System.out.printf("Returned encrypted key size is %d bytes with algorithm %s\n",
            wrapResult.getEncryptedKey().length, wrapResult.getAlgorithm().toString());

        // Let's unwrap the encrypted key response.
        UnwrapResult unwrapResult = cryptoClient.unwrapKey(KeyWrapAlgorithm.RSA_OAEP, wrapResult.getEncryptedKey());

        System.out.printf("Returned unwrapped key size is %d bytes\n", unwrapResult.getKey().length);

        // Let's do key wrap and unwrap operations with a symmetric key.
        byte[] symmetricKeyContent =
            {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07, 0x08, 0x09, 0x0A, 0x0B, 0x0C, 0x0D, 0x0E, 0x0F};
        byte[] keyContentToWrap =
            {0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, (byte) 0x88, (byte) 0x99, (byte) 0xAA, (byte) 0xBB,
                (byte) 0xCC, (byte) 0xDD, (byte) 0xEE, (byte) 0xFF};

    }
}

