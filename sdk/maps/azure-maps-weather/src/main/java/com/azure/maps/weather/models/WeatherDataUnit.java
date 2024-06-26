// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.weather.models;

import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for WeatherDataUnit.
 */
public final class WeatherDataUnit extends ExpandableStringEnum<WeatherDataUnit> {
    /**
     * Return data in metric units. Some example units of metric system are Celsius and kilometer.
     */
    public static final WeatherDataUnit METRIC = fromString("metric");

    /**
     * Return data in imperial units. Some example units of imperial system are Fahrenheit and mile.
     */
    public static final WeatherDataUnit IMPERIAL = fromString("imperial");

    /**
     * Creates a new instance of WeatherDataUnit value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public WeatherDataUnit() {
    }

    /**
     * Creates or finds a WeatherDataUnit from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding WeatherDataUnit.
     */
    public static WeatherDataUnit fromString(String name) {
        return fromString(name, WeatherDataUnit.class);
    }

    /**
     * Gets known WeatherDataUnit values.
     * 
     * @return known WeatherDataUnit values.
     */
    public static Collection<WeatherDataUnit> values() {
        return values(WeatherDataUnit.class);
    }
}
