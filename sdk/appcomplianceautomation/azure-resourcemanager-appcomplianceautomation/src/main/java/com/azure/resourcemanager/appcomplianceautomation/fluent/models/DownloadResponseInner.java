// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.appcomplianceautomation.fluent.models;

import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import com.azure.resourcemanager.appcomplianceautomation.models.ComplianceReportItem;
import com.azure.resourcemanager.appcomplianceautomation.models.DownloadResponseComplianceDetailedPdfReport;
import com.azure.resourcemanager.appcomplianceautomation.models.DownloadResponseCompliancePdfReport;
import com.azure.resourcemanager.appcomplianceautomation.models.ResourceItem;
import java.io.IOException;
import java.util.List;

/**
 * Object that includes all the possible response for the download operation.
 */
@Immutable
public final class DownloadResponseInner implements JsonSerializable<DownloadResponseInner> {
    /*
     * Resource list of the report
     */
    private List<ResourceItem> resourceList;

    /*
     * List of the compliance result
     */
    private List<ComplianceReportItem> complianceReport;

    /*
     * Compliance pdf report
     */
    private DownloadResponseCompliancePdfReport compliancePdfReport;

    /*
     * The detailed compliance pdf report
     */
    private DownloadResponseComplianceDetailedPdfReport complianceDetailedPdfReport;

    /**
     * Creates an instance of DownloadResponseInner class.
     */
    private DownloadResponseInner() {
    }

    /**
     * Get the resourceList property: Resource list of the report.
     * 
     * @return the resourceList value.
     */
    public List<ResourceItem> resourceList() {
        return this.resourceList;
    }

    /**
     * Get the complianceReport property: List of the compliance result.
     * 
     * @return the complianceReport value.
     */
    public List<ComplianceReportItem> complianceReport() {
        return this.complianceReport;
    }

    /**
     * Get the compliancePdfReport property: Compliance pdf report.
     * 
     * @return the compliancePdfReport value.
     */
    public DownloadResponseCompliancePdfReport compliancePdfReport() {
        return this.compliancePdfReport;
    }

    /**
     * Get the complianceDetailedPdfReport property: The detailed compliance pdf report.
     * 
     * @return the complianceDetailedPdfReport value.
     */
    public DownloadResponseComplianceDetailedPdfReport complianceDetailedPdfReport() {
        return this.complianceDetailedPdfReport;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    public void validate() {
        if (resourceList() != null) {
            resourceList().forEach(e -> e.validate());
        }
        if (complianceReport() != null) {
            complianceReport().forEach(e -> e.validate());
        }
        if (compliancePdfReport() != null) {
            compliancePdfReport().validate();
        }
        if (complianceDetailedPdfReport() != null) {
            complianceDetailedPdfReport().validate();
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DownloadResponseInner from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DownloadResponseInner if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the DownloadResponseInner.
     */
    public static DownloadResponseInner fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DownloadResponseInner deserializedDownloadResponseInner = new DownloadResponseInner();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("resourceList".equals(fieldName)) {
                    List<ResourceItem> resourceList = reader.readArray(reader1 -> ResourceItem.fromJson(reader1));
                    deserializedDownloadResponseInner.resourceList = resourceList;
                } else if ("complianceReport".equals(fieldName)) {
                    List<ComplianceReportItem> complianceReport
                        = reader.readArray(reader1 -> ComplianceReportItem.fromJson(reader1));
                    deserializedDownloadResponseInner.complianceReport = complianceReport;
                } else if ("compliancePdfReport".equals(fieldName)) {
                    deserializedDownloadResponseInner.compliancePdfReport
                        = DownloadResponseCompliancePdfReport.fromJson(reader);
                } else if ("complianceDetailedPdfReport".equals(fieldName)) {
                    deserializedDownloadResponseInner.complianceDetailedPdfReport
                        = DownloadResponseComplianceDetailedPdfReport.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDownloadResponseInner;
        });
    }
}
