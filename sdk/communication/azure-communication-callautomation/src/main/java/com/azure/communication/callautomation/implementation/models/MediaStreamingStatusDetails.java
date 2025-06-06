// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.
package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for MediaStreamingStatusDetails.
 */
public final class MediaStreamingStatusDetails extends ExpandableStringEnum<MediaStreamingStatusDetails> {

    /**
     * Static value subscriptionStarted for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails SUBSCRIPTION_STARTED = fromString("subscriptionStarted");

    /**
     * Static value streamConnectionReestablished for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails STREAM_CONNECTION_REESTABLISHED
        = fromString("streamConnectionReestablished");

    /**
     * Static value streamConnectionUnsuccessful for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails STREAM_CONNECTION_UNSUCCESSFUL
        = fromString("streamConnectionUnsuccessful");

    /**
     * Static value streamUrlMissing for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails STREAM_URL_MISSING = fromString("streamUrlMissing");

    /**
     * Static value serviceShutdown for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails SERVICE_SHUTDOWN = fromString("serviceShutdown");

    /**
     * Static value streamConnectionInterrupted for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails STREAM_CONNECTION_INTERRUPTED
        = fromString("streamConnectionInterrupted");

    /**
     * Static value speechServicesConnectionError for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails SPEECH_SERVICES_CONNECTION_ERROR
        = fromString("speechServicesConnectionError");

    /**
     * Static value subscriptionStopped for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails SUBSCRIPTION_STOPPED = fromString("subscriptionStopped");

    /**
     * Static value unspecifiedError for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails UNSPECIFIED_ERROR = fromString("unspecifiedError");

    /**
     * Static value authenticationFailure for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails AUTHENTICATION_FAILURE = fromString("authenticationFailure");

    /**
     * Static value badRequest for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails BAD_REQUEST = fromString("badRequest");

    /**
     * Static value tooManyRequests for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails TOO_MANY_REQUESTS = fromString("tooManyRequests");

    /**
     * Static value forbidden for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails FORBIDDEN = fromString("forbidden");

    /**
     * Static value serviceTimeout for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails SERVICE_TIMEOUT = fromString("serviceTimeout");

    /**
     * Static value initialWebSocketConnectionFailed for MediaStreamingStatusDetails.
     */
    @Generated
    public static final MediaStreamingStatusDetails INITIAL_WEBSOCKET_CONNECTION_FAILED
        = fromString("initialWebSocketConnectionFailed");

    /**
     * Creates a new instance of MediaStreamingStatusDetails value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public MediaStreamingStatusDetails() {
    }

    /**
     * Creates or finds a MediaStreamingStatusDetails from its string representation.
     *
     * @param name a name to look for.
     * @return the corresponding MediaStreamingStatusDetails.
     */
    @Generated
    public static MediaStreamingStatusDetails fromString(String name) {
        return fromString(name, MediaStreamingStatusDetails.class);
    }

    /**
     * Gets known MediaStreamingStatusDetails values.
     *
     * @return known MediaStreamingStatusDetails values.
     */
    @Generated
    public static Collection<MediaStreamingStatusDetails> values() {
        return values(MediaStreamingStatusDetails.class);
    }
}
