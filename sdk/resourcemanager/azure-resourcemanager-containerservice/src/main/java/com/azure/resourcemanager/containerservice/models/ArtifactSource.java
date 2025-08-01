// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.containerservice.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The artifact source. The source where the artifacts are downloaded from.
 */
public final class ArtifactSource extends ExpandableStringEnum<ArtifactSource> {
    /**
     * Static value Cache for ArtifactSource.
     */
    public static final ArtifactSource CACHE = fromString("Cache");

    /**
     * Static value Direct for ArtifactSource.
     */
    public static final ArtifactSource DIRECT = fromString("Direct");

    /**
     * Creates a new instance of ArtifactSource value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public ArtifactSource() {
    }

    /**
     * Creates or finds a ArtifactSource from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding ArtifactSource.
     */
    public static ArtifactSource fromString(String name) {
        return fromString(name, ArtifactSource.class);
    }

    /**
     * Gets known ArtifactSource values.
     * 
     * @return known ArtifactSource values.
     */
    public static Collection<ArtifactSource> values() {
        return values(ArtifactSource.class);
    }
}
