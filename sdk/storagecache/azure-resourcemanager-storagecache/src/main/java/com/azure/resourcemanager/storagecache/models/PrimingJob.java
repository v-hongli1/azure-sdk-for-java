// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.storagecache.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.util.logging.ClientLogger;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A priming job instance.
 */
@Fluent
public final class PrimingJob implements JsonSerializable<PrimingJob> {
    /*
     * The priming job name.
     */
    private String primingJobName;

    /*
     * The URL for the priming manifest file to download. This file must be readable from the HPC Cache. When the file
     * is in Azure blob storage the URL should include a Shared Access Signature (SAS) granting read permissions on the
     * blob.
     */
    private String primingManifestUrl;

    /*
     * The unique identifier of the priming job.
     */
    private String primingJobId;

    /*
     * The state of the priming operation.
     */
    private PrimingJobState primingJobState;

    /*
     * The status code of the priming job.
     */
    private String primingJobStatus;

    /*
     * The job details or error information if any.
     */
    private String primingJobDetails;

    /*
     * The current progress of the priming job, as a percentage.
     */
    private Double primingJobPercentComplete;

    /**
     * Creates an instance of PrimingJob class.
     */
    public PrimingJob() {
    }

    /**
     * Get the primingJobName property: The priming job name.
     * 
     * @return the primingJobName value.
     */
    public String primingJobName() {
        return this.primingJobName;
    }

    /**
     * Set the primingJobName property: The priming job name.
     * 
     * @param primingJobName the primingJobName value to set.
     * @return the PrimingJob object itself.
     */
    public PrimingJob withPrimingJobName(String primingJobName) {
        this.primingJobName = primingJobName;
        return this;
    }

    /**
     * Get the primingManifestUrl property: The URL for the priming manifest file to download. This file must be
     * readable from the HPC Cache. When the file is in Azure blob storage the URL should include a Shared Access
     * Signature (SAS) granting read permissions on the blob.
     * 
     * @return the primingManifestUrl value.
     */
    public String primingManifestUrl() {
        return this.primingManifestUrl;
    }

    /**
     * Set the primingManifestUrl property: The URL for the priming manifest file to download. This file must be
     * readable from the HPC Cache. When the file is in Azure blob storage the URL should include a Shared Access
     * Signature (SAS) granting read permissions on the blob.
     * 
     * @param primingManifestUrl the primingManifestUrl value to set.
     * @return the PrimingJob object itself.
     */
    public PrimingJob withPrimingManifestUrl(String primingManifestUrl) {
        this.primingManifestUrl = primingManifestUrl;
        return this;
    }

    /**
     * Get the primingJobId property: The unique identifier of the priming job.
     * 
     * @return the primingJobId value.
     */
    public String primingJobId() {
        return this.primingJobId;
    }

    /**
     * Get the primingJobState property: The state of the priming operation.
     * 
     * @return the primingJobState value.
     */
    public PrimingJobState primingJobState() {
        return this.primingJobState;
    }

    /**
     * Get the primingJobStatus property: The status code of the priming job.
     * 
     * @return the primingJobStatus value.
     */
    public String primingJobStatus() {
        return this.primingJobStatus;
    }

    /**
     * Get the primingJobDetails property: The job details or error information if any.
     * 
     * @return the primingJobDetails value.
     */
    public String primingJobDetails() {
        return this.primingJobDetails;
    }

    /**
     * Get the primingJobPercentComplete property: The current progress of the priming job, as a percentage.
     * 
     * @return the primingJobPercentComplete value.
     */
    public Double primingJobPercentComplete() {
        return this.primingJobPercentComplete;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (primingJobName() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property primingJobName in model PrimingJob"));
        }
        if (primingManifestUrl() == null) {
            throw LOGGER.atError()
                .log(new IllegalArgumentException("Missing required property primingManifestUrl in model PrimingJob"));
        }
    }

    private static final ClientLogger LOGGER = new ClientLogger(PrimingJob.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("primingJobName", this.primingJobName);
        jsonWriter.writeStringField("primingManifestUrl", this.primingManifestUrl);
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of PrimingJob from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of PrimingJob if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the PrimingJob.
     */
    public static PrimingJob fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            PrimingJob deserializedPrimingJob = new PrimingJob();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("primingJobName".equals(fieldName)) {
                    deserializedPrimingJob.primingJobName = reader.getString();
                } else if ("primingManifestUrl".equals(fieldName)) {
                    deserializedPrimingJob.primingManifestUrl = reader.getString();
                } else if ("primingJobId".equals(fieldName)) {
                    deserializedPrimingJob.primingJobId = reader.getString();
                } else if ("primingJobState".equals(fieldName)) {
                    deserializedPrimingJob.primingJobState = PrimingJobState.fromString(reader.getString());
                } else if ("primingJobStatus".equals(fieldName)) {
                    deserializedPrimingJob.primingJobStatus = reader.getString();
                } else if ("primingJobDetails".equals(fieldName)) {
                    deserializedPrimingJob.primingJobDetails = reader.getString();
                } else if ("primingJobPercentComplete".equals(fieldName)) {
                    deserializedPrimingJob.primingJobPercentComplete = reader.getNullable(JsonReader::getDouble);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedPrimingJob;
        });
    }
}
