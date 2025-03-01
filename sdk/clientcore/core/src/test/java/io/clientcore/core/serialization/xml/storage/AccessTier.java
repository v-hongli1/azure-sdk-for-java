// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.serialization.xml.storage;

import java.util.Collection;

/** Defines values for AccessTier. */
public final class AccessTier extends ExpandableStringEnum<AccessTier> {
    /** Static value P4 for AccessTier. */
    public static final AccessTier P4 = fromString("P4");

    /** Static value P6 for AccessTier. */
    public static final AccessTier P6 = fromString("P6");

    /** Static value P10 for AccessTier. */
    public static final AccessTier P10 = fromString("P10");

    /** Static value P15 for AccessTier. */
    public static final AccessTier P15 = fromString("P15");

    /** Static value P20 for AccessTier. */
    public static final AccessTier P20 = fromString("P20");

    /** Static value P30 for AccessTier. */
    public static final AccessTier P30 = fromString("P30");

    /** Static value P40 for AccessTier. */
    public static final AccessTier P40 = fromString("P40");

    /** Static value P50 for AccessTier. */
    public static final AccessTier P50 = fromString("P50");

    /** Static value P60 for AccessTier. */
    public static final AccessTier P60 = fromString("P60");

    /** Static value P70 for AccessTier. */
    public static final AccessTier P70 = fromString("P70");

    /** Static value P80 for AccessTier. */
    public static final AccessTier P80 = fromString("P80");

    /** Static value Hot for AccessTier. */
    public static final AccessTier HOT = fromString("Hot");

    /** Static value Cool for AccessTier. */
    public static final AccessTier COOL = fromString("Cool");

    /** Static value Archive for AccessTier. */
    public static final AccessTier ARCHIVE = fromString("Archive");

    /** Static value Premium for AccessTier. */
    public static final AccessTier PREMIUM = fromString("Premium");

    /**
     * Creates or finds a AccessTier from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding AccessTier.
     */
    public static AccessTier fromString(String name) {
        return fromString(name, AccessTier.class);
    }

    /**
     * Gets known AccessTier values.
     *
     * @return known AccessTier values.
     */
    public static Collection<AccessTier> values() {
        return values(AccessTier.class);
    }
}
