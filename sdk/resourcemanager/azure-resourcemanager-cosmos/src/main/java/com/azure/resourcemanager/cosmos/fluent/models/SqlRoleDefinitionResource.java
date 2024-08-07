// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.cosmos.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.cosmos.models.Permission;
import com.azure.resourcemanager.cosmos.models.RoleDefinitionType;
import java.io.IOException;
import java.util.List;

/**
 * Azure Cosmos DB SQL Role Definition resource object.
 */
@Fluent
public final class SqlRoleDefinitionResource implements JsonSerializable<SqlRoleDefinitionResource> {
    /*
     * A user-friendly name for the Role Definition. Must be unique for the database account.
     */
    private String roleName;

    /*
     * Indicates whether the Role Definition was built-in or user created.
     */
    private RoleDefinitionType type;

    /*
     * A set of fully qualified Scopes at or below which Role Assignments may be created using this Role Definition.
     * This will allow application of this Role Definition on the entire database account or any underlying Database /
     * Collection. Must have at least one element. Scopes higher than Database account are not enforceable as assignable
     * Scopes. Note that resources referenced in assignable Scopes need not exist.
     */
    private List<String> assignableScopes;

    /*
     * The set of operations allowed through this Role Definition.
     */
    private List<Permission> permissions;

    /**
     * Creates an instance of SqlRoleDefinitionResource class.
     */
    public SqlRoleDefinitionResource() {
    }

    /**
     * Get the roleName property: A user-friendly name for the Role Definition. Must be unique for the database account.
     * 
     * @return the roleName value.
     */
    public String roleName() {
        return this.roleName;
    }

    /**
     * Set the roleName property: A user-friendly name for the Role Definition. Must be unique for the database account.
     * 
     * @param roleName the roleName value to set.
     * @return the SqlRoleDefinitionResource object itself.
     */
    public SqlRoleDefinitionResource withRoleName(String roleName) {
        this.roleName = roleName;
        return this;
    }

    /**
     * Get the type property: Indicates whether the Role Definition was built-in or user created.
     * 
     * @return the type value.
     */
    public RoleDefinitionType type() {
        return this.type;
    }

    /**
     * Set the type property: Indicates whether the Role Definition was built-in or user created.
     * 
     * @param type the type value to set.
     * @return the SqlRoleDefinitionResource object itself.
     */
    public SqlRoleDefinitionResource withType(RoleDefinitionType type) {
        this.type = type;
        return this;
    }

    /**
     * Get the assignableScopes property: A set of fully qualified Scopes at or below which Role Assignments may be
     * created using this Role Definition. This will allow application of this Role Definition on the entire database
     * account or any underlying Database / Collection. Must have at least one element. Scopes higher than Database
     * account are not enforceable as assignable Scopes. Note that resources referenced in assignable Scopes need not
     * exist.
     * 
     * @return the assignableScopes value.
     */
    public List<String> assignableScopes() {
        return this.assignableScopes;
    }

    /**
     * Set the assignableScopes property: A set of fully qualified Scopes at or below which Role Assignments may be
     * created using this Role Definition. This will allow application of this Role Definition on the entire database
     * account or any underlying Database / Collection. Must have at least one element. Scopes higher than Database
     * account are not enforceable as assignable Scopes. Note that resources referenced in assignable Scopes need not
     * exist.
     * 
     * @param assignableScopes the assignableScopes value to set.
     * @return the SqlRoleDefinitionResource object itself.
     */
    public SqlRoleDefinitionResource withAssignableScopes(List<String> assignableScopes) {
        this.assignableScopes = assignableScopes;
        return this;
    }

    /**
     * Get the permissions property: The set of operations allowed through this Role Definition.
     * 
     * @return the permissions value.
     */
    public List<Permission> permissions() {
        return this.permissions;
    }

    /**
     * Set the permissions property: The set of operations allowed through this Role Definition.
     * 
     * @param permissions the permissions value to set.
     * @return the SqlRoleDefinitionResource object itself.
     */
    public SqlRoleDefinitionResource withPermissions(List<Permission> permissions) {
        this.permissions = permissions;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (permissions() != null) {
            permissions().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("roleName", this.roleName);
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        jsonWriter.writeArrayField("assignableScopes", this.assignableScopes,
            (writer, element) -> writer.writeString(element));
        jsonWriter.writeArrayField("permissions", this.permissions, (writer, element) -> writer.writeJson(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SqlRoleDefinitionResource from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SqlRoleDefinitionResource if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IOException If an error occurs while reading the SqlRoleDefinitionResource.
     */
    public static SqlRoleDefinitionResource fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SqlRoleDefinitionResource deserializedSqlRoleDefinitionResource = new SqlRoleDefinitionResource();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("roleName".equals(fieldName)) {
                    deserializedSqlRoleDefinitionResource.roleName = reader.getString();
                } else if ("type".equals(fieldName)) {
                    deserializedSqlRoleDefinitionResource.type = RoleDefinitionType.fromString(reader.getString());
                } else if ("assignableScopes".equals(fieldName)) {
                    List<String> assignableScopes = reader.readArray(reader1 -> reader1.getString());
                    deserializedSqlRoleDefinitionResource.assignableScopes = assignableScopes;
                } else if ("permissions".equals(fieldName)) {
                    List<Permission> permissions = reader.readArray(reader1 -> Permission.fromJson(reader1));
                    deserializedSqlRoleDefinitionResource.permissions = permissions;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSqlRoleDefinitionResource;
        });
    }
}
