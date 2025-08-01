// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.providerhub.models.DefaultRolloutStatusManifestCheckinStatus;
import org.junit.jupiter.api.Assertions;

public final class DefaultRolloutStatusManifestCheckinStatusTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        DefaultRolloutStatusManifestCheckinStatus model = BinaryData.fromString(
            "{\"isCheckedIn\":true,\"statusMessage\":\"soibjudpfrx\",\"pullRequest\":\"thzvaytdwkqbrqu\",\"commitId\":\"axhexiilivp\"}")
            .toObject(DefaultRolloutStatusManifestCheckinStatus.class);
        Assertions.assertTrue(model.isCheckedIn());
        Assertions.assertEquals("soibjudpfrx", model.statusMessage());
        Assertions.assertEquals("thzvaytdwkqbrqu", model.pullRequest());
        Assertions.assertEquals("axhexiilivp", model.commitId());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        DefaultRolloutStatusManifestCheckinStatus model
            = new DefaultRolloutStatusManifestCheckinStatus().withIsCheckedIn(true)
                .withStatusMessage("soibjudpfrx")
                .withPullRequest("thzvaytdwkqbrqu")
                .withCommitId("axhexiilivp");
        model = BinaryData.fromObject(model).toObject(DefaultRolloutStatusManifestCheckinStatus.class);
        Assertions.assertTrue(model.isCheckedIn());
        Assertions.assertEquals("soibjudpfrx", model.statusMessage());
        Assertions.assertEquals("thzvaytdwkqbrqu", model.pullRequest());
        Assertions.assertEquals("axhexiilivp", model.commitId());
    }
}
