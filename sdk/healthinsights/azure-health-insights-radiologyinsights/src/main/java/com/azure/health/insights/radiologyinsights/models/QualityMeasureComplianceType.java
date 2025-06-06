// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.
package com.azure.health.insights.radiologyinsights.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Whether the document is compliant.
 */
public final class QualityMeasureComplianceType extends ExpandableStringEnum<QualityMeasureComplianceType> {

    /**
     * not eligible.
     */
    @Generated
    public static final QualityMeasureComplianceType NOT_ELIGIBLE = fromString("notEligible");

    /**
     * performance not met.
     */
    @Generated
    public static final QualityMeasureComplianceType PERFORMANCE_NOT_MET = fromString("performanceNotMet");

    /**
     * performance met.
     */
    @Generated
    public static final QualityMeasureComplianceType PERFORMANCE_MET = fromString("performanceMet");

    /**
     * denominator exception.
     */
    @Generated
    public static final QualityMeasureComplianceType DENOMINATOR_EXCEPTION = fromString("denominatorException");

    /**
     * Creates a new instance of QualityMeasureComplianceType value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public QualityMeasureComplianceType() {
    }

    /**
     * Creates or finds a QualityMeasureComplianceType from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding QualityMeasureComplianceType.
     */
    @Generated
    public static QualityMeasureComplianceType fromString(String name) {
        return fromString(name, QualityMeasureComplianceType.class);
    }

    /**
     * Gets known QualityMeasureComplianceType values.
     *
     * @return known QualityMeasureComplianceType values.
     */
    @Generated
    public static Collection<QualityMeasureComplianceType> values() {
        return values(QualityMeasureComplianceType.class);
    }
}
