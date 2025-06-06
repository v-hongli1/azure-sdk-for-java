// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.storage.file.share.options;

import com.azure.storage.file.share.models.ShareRequestConditions;

/**
 * Options for obtaining a {@link java.nio.channels.SeekableByteChannel} backed by an Azure Storage Share File.
 */
public final class ShareFileSeekableByteChannelReadOptions {
    private ShareRequestConditions requestConditions;
    private Long chunkSizeInBytes;

    /**
     * Creates a new instance of {@link ShareFileSeekableByteChannelReadOptions}.
     */
    public ShareFileSeekableByteChannelReadOptions() {
    }

    /**
     * Gets the size of individual writes to the service.
     *
     * @return The size of individual writes to the service.
     */
    public Long getChunkSizeInBytes() {
        return chunkSizeInBytes;
    }

    /**
     * Sets the size of individual writes to the service.
     *
     * @param chunkSizeInBytes The size of individual writes to the service.
     * @return The updated instance.
     */
    public ShareFileSeekableByteChannelReadOptions setChunkSizeInBytes(Long chunkSizeInBytes) {
        this.chunkSizeInBytes = chunkSizeInBytes;
        return this;
    }

    /**
     * Gets the request conditions to be used by the resulting channel.
     *
     * @return Request conditions to be used by the resulting channel.
     */
    public ShareRequestConditions getRequestConditions() {
        return requestConditions;
    }

    /**
     * Sets the request conditions to be used by the resulting channel.
     *
     * @param requestConditions Request conditions to be used by the resulting channel.
     * @return The updated instance.
     */
    public ShareFileSeekableByteChannelReadOptions setRequestConditions(ShareRequestConditions requestConditions) {
        this.requestConditions = requestConditions;
        return this;
    }
}
