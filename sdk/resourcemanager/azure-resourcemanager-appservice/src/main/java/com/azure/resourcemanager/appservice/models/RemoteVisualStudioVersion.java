// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.resourcemanager.appservice.models;

import com.azure.core.util.ExpandableStringEnum;

import java.util.Collection;

/** Defines values for remote visual studio version for remote debugging. */
public final class RemoteVisualStudioVersion extends ExpandableStringEnum<RemoteVisualStudioVersion> {
    /** Static value VS2017 for RemoteVisualStudioVersion. */
    public static final RemoteVisualStudioVersion VS2017 = RemoteVisualStudioVersion.fromString("VS2017");

    /** Static value VS2019 for RemoteVisualStudioVersion. */
    public static final RemoteVisualStudioVersion VS2019 = RemoteVisualStudioVersion.fromString("VS2019");

    /**
     * Creates a new instance of RemoteVisualStudioVersion value.
     *
     * @deprecated Use the {@link #fromString(String)} factory method.
     */
    @Deprecated
    public RemoteVisualStudioVersion() {
    }

    /**
     * Finds or creates a Visual Studio version based on the specified name.
     *
     * @param name a name
     * @return a RemoteVisualStudioVersion instance
     */
    public static RemoteVisualStudioVersion fromString(String name) {
        return fromString(name, RemoteVisualStudioVersion.class);
    }

    /**
     * Gets known Visual Studio versions.
     *
     * @return known Visual Studio versions
     */
    public static Collection<RemoteVisualStudioVersion> values() {
        return values(RemoteVisualStudioVersion.class);
    }
}
