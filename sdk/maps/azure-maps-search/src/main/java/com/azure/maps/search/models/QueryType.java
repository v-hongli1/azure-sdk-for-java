// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.search.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * The type of query being returned: NEARBY or NON_NEAR.
 */
public final class QueryType extends ExpandableStringEnum<QueryType> {
    /**
     * Search was performed around a certain latitude and longitude with a defined radius.
     */
    public static final QueryType NEARBY = fromString("NEARBY");

    /**
     * Search was performed globally, without biasing to a certain latitude and longitude, and no defined radius.
     */
    public static final QueryType GLOBAL = fromString("NON_NEAR");

    /**
     * Creates a new instance of QueryType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public QueryType() {
    }

    /**
     * Creates or finds a QueryType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding QueryType.
     */
    public static QueryType fromString(String name) {
        return fromString(name, QueryType.class);
    }

    /**
     * Gets known QueryType values.
     * 
     * @return known QueryType values.
     */
    public static Collection<QueryType> values() {
        return values(QueryType.class);
    }
}
