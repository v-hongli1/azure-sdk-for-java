// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callautomation.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.util.ExpandableStringEnum;
import java.util.Collection;

/**
 * Defines values for MediaStreamingStatus.
 */
public final class MediaStreamingStatus extends ExpandableStringEnum<MediaStreamingStatus> {
    /**
     * Static value mediaStreamingStarted for MediaStreamingStatus.
     */
    @Generated
    public static final MediaStreamingStatus MEDIA_STREAMING_STARTED = fromString("mediaStreamingStarted");

    /**
     * Static value mediaStreamingFailed for MediaStreamingStatus.
     */
    @Generated
    public static final MediaStreamingStatus MEDIA_STREAMING_FAILED = fromString("mediaStreamingFailed");

    /**
     * Static value mediaStreamingStopped for MediaStreamingStatus.
     */
    @Generated
    public static final MediaStreamingStatus MEDIA_STREAMING_STOPPED = fromString("mediaStreamingStopped");

    /**
     * Static value unspecifiedError for MediaStreamingStatus.
     */
    @Generated
    public static final MediaStreamingStatus UNSPECIFIED_ERROR = fromString("unspecifiedError");

    /**
     * Creates a new instance of MediaStreamingStatus value.
     * 
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Generated
    @Deprecated
    public MediaStreamingStatus() {
    }

    /**
     * Creates or finds a MediaStreamingStatus from its string representation.
     * 
     * @param name a name to look for.
     * @return the corresponding MediaStreamingStatus.
     */
    @Generated
    public static MediaStreamingStatus fromString(String name) {
        return fromString(name, MediaStreamingStatus.class);
    }

    /**
     * Gets known MediaStreamingStatus values.
     * 
     * @return known MediaStreamingStatus values.
     */
    @Generated
    public static Collection<MediaStreamingStatus> values() {
        return values(MediaStreamingStatus.class);
    }
}
