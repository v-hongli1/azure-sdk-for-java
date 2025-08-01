// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.v2.security.keyvault.administration.models;

import io.clientcore.core.annotations.Metadata;
import io.clientcore.core.annotations.MetadataProperties;
import io.clientcore.core.serialization.json.JsonReader;
import io.clientcore.core.serialization.json.JsonSerializable;
import io.clientcore.core.serialization.json.JsonToken;
import io.clientcore.core.serialization.json.JsonWriter;
import io.clientcore.core.utils.ExpandableEnum;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

/**
 * The role scope.
 */
public final class KeyVaultRoleScope implements ExpandableEnum<String>, JsonSerializable<KeyVaultRoleScope> {

    private static final Map<String, KeyVaultRoleScope> VALUES = new ConcurrentHashMap<>();

    private static final Function<String, KeyVaultRoleScope> NEW_INSTANCE = KeyVaultRoleScope::new;

    /**
     * Global scope.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static final KeyVaultRoleScope GLOBAL = fromValue("/");

    /**
     * Keys scope.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static final KeyVaultRoleScope KEYS = fromValue("/keys");

    private final String value;

    private KeyVaultRoleScope(String value) {
        this.value = value;
    }

    /**
     * Creates or finds a KeyVaultRoleScope.
     *
     * @param value a value to look for.
     * @return the corresponding KeyVaultRoleScope.
     * @throws IllegalArgumentException if value is null.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static KeyVaultRoleScope fromValue(String value) {
        if (value == null) {
            throw new IllegalArgumentException("'value' cannot be null.");
        }
        return VALUES.computeIfAbsent(value, NEW_INSTANCE);
    }

    /**
     * Gets known KeyVaultRoleScope values.
     *
     * @return Known KeyVaultRoleScope values.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static Collection<KeyVaultRoleScope> values() {
        return new ArrayList<>(VALUES.values());
    }

    /**
     * Gets the value of the KeyVaultRoleScope instance.
     *
     * @return the value of the KeyVaultRoleScope instance.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public String getValue() {
        return this.value;
    }

    /**
     * {@inheritDoc}
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeString(getValue());
    }

    /**
     * Reads an instance of KeyVaultRoleScope from the JsonReader.
     *
     * @param jsonReader The JsonReader being read.
     * @return An instance of KeyVaultRoleScope if the JsonReader was pointing to an instance of it, or null if the
     * JsonReader was pointing to JSON null.
     * @throws IOException If an error occurs while reading the KeyVaultRoleScope.
     * @throws IllegalStateException If unexpected JSON token is found.
     */
    @Metadata(properties = { MetadataProperties.GENERATED })
    public static KeyVaultRoleScope fromJson(JsonReader jsonReader) throws IOException {
        JsonToken nextToken = jsonReader.nextToken();
        if (nextToken == JsonToken.NULL) {
            return null;
        }
        if (nextToken != JsonToken.STRING) {
            throw new IllegalStateException(
                String.format("Unexpected JSON token for %s deserialization: %s", JsonToken.STRING, nextToken));
        }
        return KeyVaultRoleScope.fromValue(jsonReader.getString());
    }

    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public String toString() {
        return Objects.toString(this.value);
    }

    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public boolean equals(Object obj) {
        return this == obj;
    }

    @Metadata(properties = { MetadataProperties.GENERATED })
    @Override
    public int hashCode() {
        return Objects.hashCode(this.value);
    }

    /**
     * Creates or finds a {@link KeyVaultRoleScope} from its string representation.
     *
     * @param url A string representing a URL containing the name of the scope to look for.
     * @return The corresponding {@link KeyVaultRoleScope}.
     * @throws IllegalArgumentException If the given {@code url} is malformed.
     */
    public static KeyVaultRoleScope fromUrl(String url) {
        try {
            return fromValue(new URL(url).getPath());
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Creates or finds a {@link KeyVaultRoleScope} from its string representation.
     *
     * @param url A URL containing the name of the scope to look for.
     * @return The corresponding {@link KeyVaultRoleScope}.
     */
    public static KeyVaultRoleScope fromUrl(URL url) {
        return fromValue(url.getPath());
    }
}
