// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.route.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for RouteType.
 */
public final class RouteType extends ExpandableStringEnum<RouteType> {
    /**
     * The fastest route.
     */
    @Generated
    public static final RouteType FASTEST = fromString("fastest");

    /**
     * The shortest route by distance.
     */
    @Generated
    public static final RouteType SHORTEST = fromString("shortest");

    /**
     * A route balanced by economy and speed.
     */
    @Generated
    public static final RouteType ECONOMY = fromString("eco");

    /**
     * Includes interesting or challenging roads and uses as few motorways as possible. You can choose the level of
     * turns included and also the degree of hilliness. See the hilliness and windingness parameters for how to set
     * this. There is a limit of 900 km on routes planned with `routeType`=thrilling.
     */
    @Generated
    public static final RouteType THRILLING = fromString("thrilling");

    /**
     * Creates a new instance of RouteType value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public RouteType() {
    }

    /**
     * Creates or finds a RouteType from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding RouteType.
     */
    @Generated
    public static RouteType fromString(String name) {
        return fromString(name, RouteType.class);
    }

    /**
     * Gets known RouteType values.
     * 
     * @return known RouteType values.
     */
    @Generated
    public static Collection<RouteType> values() {
        return values(RouteType.class);
    }
}
