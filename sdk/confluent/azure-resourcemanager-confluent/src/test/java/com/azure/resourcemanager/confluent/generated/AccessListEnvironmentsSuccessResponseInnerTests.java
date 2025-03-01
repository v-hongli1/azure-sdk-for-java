// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.confluent.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.confluent.fluent.models.AccessListEnvironmentsSuccessResponseInner;
import com.azure.resourcemanager.confluent.models.ConfluentListMetadata;
import com.azure.resourcemanager.confluent.models.EnvironmentRecord;
import com.azure.resourcemanager.confluent.models.MetadataEntity;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;

public final class AccessListEnvironmentsSuccessResponseInnerTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        AccessListEnvironmentsSuccessResponseInner model = BinaryData.fromString(
            "{\"kind\":\"hheunmmqhgyx\",\"metadata\":{\"first\":\"noc\",\"last\":\"oklyaxuconuq\",\"prev\":\"fkbey\",\"next\":\"wrmjmwvvjektc\",\"total_size\":1803945661},\"data\":[{\"kind\":\"lrsf\",\"id\":\"zpwv\",\"metadata\":{\"self\":\"q\",\"resource_name\":\"iqylihkaetck\",\"created_at\":\"fcivfsnkym\",\"updated_at\":\"tqhjfbebrjcx\",\"deleted_at\":\"fuwutttxf\"},\"display_name\":\"rbirphxe\"},{\"kind\":\"yva\",\"id\":\"nljky\",\"metadata\":{\"self\":\"vuujq\",\"resource_name\":\"dokgjl\",\"created_at\":\"oxgvclt\",\"updated_at\":\"sncghkjeszz\",\"deleted_at\":\"ijhtxf\"},\"display_name\":\"xbf\"}]}")
            .toObject(AccessListEnvironmentsSuccessResponseInner.class);
        Assertions.assertEquals("hheunmmqhgyx", model.kind());
        Assertions.assertEquals("noc", model.metadata().first());
        Assertions.assertEquals("oklyaxuconuq", model.metadata().last());
        Assertions.assertEquals("fkbey", model.metadata().prev());
        Assertions.assertEquals("wrmjmwvvjektc", model.metadata().next());
        Assertions.assertEquals(1803945661, model.metadata().totalSize());
        Assertions.assertEquals("lrsf", model.data().get(0).kind());
        Assertions.assertEquals("zpwv", model.data().get(0).id());
        Assertions.assertEquals("q", model.data().get(0).metadata().self());
        Assertions.assertEquals("iqylihkaetck", model.data().get(0).metadata().resourceName());
        Assertions.assertEquals("fcivfsnkym", model.data().get(0).metadata().createdAt());
        Assertions.assertEquals("tqhjfbebrjcx", model.data().get(0).metadata().updatedAt());
        Assertions.assertEquals("fuwutttxf", model.data().get(0).metadata().deletedAt());
        Assertions.assertEquals("rbirphxe", model.data().get(0).displayName());
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        AccessListEnvironmentsSuccessResponseInner model
            = new AccessListEnvironmentsSuccessResponseInner().withKind("hheunmmqhgyx")
                .withMetadata(new ConfluentListMetadata().withFirst("noc")
                    .withLast("oklyaxuconuq")
                    .withPrev("fkbey")
                    .withNext("wrmjmwvvjektc")
                    .withTotalSize(1803945661))
                .withData(Arrays.asList(
                    new EnvironmentRecord().withKind("lrsf")
                        .withId("zpwv")
                        .withMetadata(new MetadataEntity().withSelf("q")
                            .withResourceName("iqylihkaetck")
                            .withCreatedAt("fcivfsnkym")
                            .withUpdatedAt("tqhjfbebrjcx")
                            .withDeletedAt("fuwutttxf"))
                        .withDisplayName("rbirphxe"),
                    new EnvironmentRecord().withKind("yva")
                        .withId("nljky")
                        .withMetadata(new MetadataEntity().withSelf("vuujq")
                            .withResourceName("dokgjl")
                            .withCreatedAt("oxgvclt")
                            .withUpdatedAt("sncghkjeszz")
                            .withDeletedAt("ijhtxf"))
                        .withDisplayName("xbf")));
        model = BinaryData.fromObject(model).toObject(AccessListEnvironmentsSuccessResponseInner.class);
        Assertions.assertEquals("hheunmmqhgyx", model.kind());
        Assertions.assertEquals("noc", model.metadata().first());
        Assertions.assertEquals("oklyaxuconuq", model.metadata().last());
        Assertions.assertEquals("fkbey", model.metadata().prev());
        Assertions.assertEquals("wrmjmwvvjektc", model.metadata().next());
        Assertions.assertEquals(1803945661, model.metadata().totalSize());
        Assertions.assertEquals("lrsf", model.data().get(0).kind());
        Assertions.assertEquals("zpwv", model.data().get(0).id());
        Assertions.assertEquals("q", model.data().get(0).metadata().self());
        Assertions.assertEquals("iqylihkaetck", model.data().get(0).metadata().resourceName());
        Assertions.assertEquals("fcivfsnkym", model.data().get(0).metadata().createdAt());
        Assertions.assertEquals("tqhjfbebrjcx", model.data().get(0).metadata().updatedAt());
        Assertions.assertEquals("fuwutttxf", model.data().get(0).metadata().deletedAt());
        Assertions.assertEquals("rbirphxe", model.data().get(0).displayName());
    }
}
