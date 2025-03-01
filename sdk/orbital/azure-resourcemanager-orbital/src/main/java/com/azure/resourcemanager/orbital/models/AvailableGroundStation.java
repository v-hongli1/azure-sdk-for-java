// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.orbital.models;

import com.azure.resourcemanager.orbital.fluent.models.AvailableGroundStationInner;

/**
 * An immutable client-side representation of AvailableGroundStation.
 */
public interface AvailableGroundStation {
    /**
     * Gets the id property: ID of groundStation.
     * 
     * @return the id value.
     */
    String id();

    /**
     * Gets the name property: Name of the ground station.
     * 
     * @return the name value.
     */
    String name();

    /**
     * Gets the location property: Azure region.
     * 
     * @return the location value.
     */
    String location();

    /**
     * Gets the type property: Resource type.
     * 
     * @return the type value.
     */
    String type();

    /**
     * Gets the city property: City of ground station.
     * 
     * @return the city value.
     */
    String city();

    /**
     * Gets the providerName property: Ground station provider name.
     * 
     * @return the providerName value.
     */
    String providerName();

    /**
     * Gets the longitudeDegrees property: Longitude of the ground station in decimal degrees.
     * 
     * @return the longitudeDegrees value.
     */
    Float longitudeDegrees();

    /**
     * Gets the latitudeDegrees property: Latitude of the ground station in decimal degrees.
     * 
     * @return the latitudeDegrees value.
     */
    Float latitudeDegrees();

    /**
     * Gets the altitudeMeters property: Altitude of the ground station.
     * 
     * @return the altitudeMeters value.
     */
    Float altitudeMeters();

    /**
     * Gets the releaseMode property: Release Status of a ground station.
     * 
     * @return the releaseMode value.
     */
    ReleaseMode releaseMode();

    /**
     * Gets the inner com.azure.resourcemanager.orbital.fluent.models.AvailableGroundStationInner object.
     * 
     * @return the inner object.
     */
    AvailableGroundStationInner innerModel();
}
