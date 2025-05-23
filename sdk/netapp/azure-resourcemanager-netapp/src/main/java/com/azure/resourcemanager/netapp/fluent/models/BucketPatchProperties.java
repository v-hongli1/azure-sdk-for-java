// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.netapp.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.netapp.models.BucketServerPatchProperties;
import com.azure.resourcemanager.netapp.models.FileSystemUser;
import com.azure.resourcemanager.netapp.models.NetappProvisioningState;
import java.io.IOException;

/**
 * Bucket resource properties for a Patch operation.
 */
@Fluent
public final class BucketPatchProperties implements JsonSerializable<BucketPatchProperties> {
    /*
     * The volume path mounted inside the bucket.
     */
    private String path;

    /*
     * File System user having access to volume data. For Unix, this is the user's uid and gid. For Windows, this is the
     * user's username. Note that the Unix and Windows user details are mutually exclusive, meaning one or other must be
     * supplied, but not both.
     */
    private FileSystemUser fileSystemUser;

    /*
     * Provisioning state of the resource
     */
    private NetappProvisioningState provisioningState;

    /*
     * Properties of the server managing the lifecycle of volume buckets
     */
    private BucketServerPatchProperties server;

    /**
     * Creates an instance of BucketPatchProperties class.
     */
    public BucketPatchProperties() {
    }

    /**
     * Get the path property: The volume path mounted inside the bucket.
     * 
     * @return the path value.
     */
    public String path() {
        return this.path;
    }

    /**
     * Set the path property: The volume path mounted inside the bucket.
     * 
     * @param path the path value to set.
     * @return the BucketPatchProperties object itself.
     */
    public BucketPatchProperties withPath(String path) {
        this.path = path;
        return this;
    }

    /**
     * Get the fileSystemUser property: File System user having access to volume data. For Unix, this is the user's uid
     * and gid. For Windows, this is the user's username. Note that the Unix and Windows user details are mutually
     * exclusive, meaning one or other must be supplied, but not both.
     * 
     * @return the fileSystemUser value.
     */
    public FileSystemUser fileSystemUser() {
        return this.fileSystemUser;
    }

    /**
     * Set the fileSystemUser property: File System user having access to volume data. For Unix, this is the user's uid
     * and gid. For Windows, this is the user's username. Note that the Unix and Windows user details are mutually
     * exclusive, meaning one or other must be supplied, but not both.
     * 
     * @param fileSystemUser the fileSystemUser value to set.
     * @return the BucketPatchProperties object itself.
     */
    public BucketPatchProperties withFileSystemUser(FileSystemUser fileSystemUser) {
        this.fileSystemUser = fileSystemUser;
        return this;
    }

    /**
     * Get the provisioningState property: Provisioning state of the resource.
     * 
     * @return the provisioningState value.
     */
    public NetappProvisioningState provisioningState() {
        return this.provisioningState;
    }

    /**
     * Get the server property: Properties of the server managing the lifecycle of volume buckets.
     * 
     * @return the server value.
     */
    public BucketServerPatchProperties server() {
        return this.server;
    }

    /**
     * Set the server property: Properties of the server managing the lifecycle of volume buckets.
     * 
     * @param server the server value to set.
     * @return the BucketPatchProperties object itself.
     */
    public BucketPatchProperties withServer(BucketServerPatchProperties server) {
        this.server = server;
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (fileSystemUser() != null) {
            fileSystemUser().validate();
        }
        if (server() != null) {
            server().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("path", this.path);
        jsonWriter.writeJsonField("fileSystemUser", this.fileSystemUser);
        jsonWriter.writeJsonField("server", this.server);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of BucketPatchProperties from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of BucketPatchProperties if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the BucketPatchProperties.
     */
    public static BucketPatchProperties fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            BucketPatchProperties deserializedBucketPatchProperties = new BucketPatchProperties();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("path".equals(fieldName)) {
                    deserializedBucketPatchProperties.path = reader.getString();
                } else if ("fileSystemUser".equals(fieldName)) {
                    deserializedBucketPatchProperties.fileSystemUser = FileSystemUser.fromJson(reader);
                } else if ("provisioningState".equals(fieldName)) {
                    deserializedBucketPatchProperties.provisioningState
                        = NetappProvisioningState.fromString(reader.getString());
                } else if ("server".equals(fieldName)) {
                    deserializedBucketPatchProperties.server = BucketServerPatchProperties.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedBucketPatchProperties;
        });
    }
}
