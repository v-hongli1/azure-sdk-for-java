// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.data.tables.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for OdataMetadataFormat.
 */
public final class OdataMetadataFormat extends ExpandableStringEnum<OdataMetadataFormat> {
    /**
     * Static value application/json;odata=nometadata for OdataMetadataFormat.
     */
    @Generated
    public static final OdataMetadataFormat APPLICATION_JSON_ODATA_NOMETADATA
        = fromString("application/json;odata=nometadata");

    /**
     * Static value application/json;odata=minimalmetadata for OdataMetadataFormat.
     */
    @Generated
    public static final OdataMetadataFormat APPLICATION_JSON_ODATA_MINIMALMETADATA
        = fromString("application/json;odata=minimalmetadata");

    /**
     * Static value application/json;odata=fullmetadata for OdataMetadataFormat.
     */
    @Generated
    public static final OdataMetadataFormat APPLICATION_JSON_ODATA_FULLMETADATA
        = fromString("application/json;odata=fullmetadata");

    /**
     * Creates a new instance of OdataMetadataFormat value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public OdataMetadataFormat() {
    }

    /**
     * Creates or finds a OdataMetadataFormat from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding OdataMetadataFormat.
     */
    @Generated
    public static OdataMetadataFormat fromString(String name) {
        return fromString(name, OdataMetadataFormat.class);
    }

    /**
     * Gets known OdataMetadataFormat values.
     * 
     * @return known OdataMetadataFormat values.
     */
    @Generated
    public static Collection<OdataMetadataFormat> values() {
        return values(OdataMetadataFormat.class);
    }
}
