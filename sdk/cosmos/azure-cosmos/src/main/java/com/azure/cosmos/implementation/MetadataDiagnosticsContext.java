// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package com.azure.cosmos.implementation;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;

import java.io.IOException;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MetadataDiagnosticsContext {
    public volatile List<MetadataDiagnostics> metadataDiagnosticList;

    public MetadataDiagnosticsContext() {}

    public MetadataDiagnosticsContext(MetadataDiagnosticsContext toBeCloned) {
        if (toBeCloned.metadataDiagnosticList != null) {
            this.metadataDiagnosticList = Collections.synchronizedList(
                new ArrayList<>(toBeCloned.metadataDiagnosticList));
        }
    }

    public void addMetaDataDiagnostic(MetadataDiagnostics metaDataDiagnostic) {
        if (metadataDiagnosticList == null) {
            metadataDiagnosticList = Collections.synchronizedList(new ArrayList<>());
        }

        metadataDiagnosticList.add(metaDataDiagnostic);
    }

    public boolean isEmpty() {
        return metadataDiagnosticList == null || metadataDiagnosticList.isEmpty();
    }

    @JsonSerialize(using = MetaDataDiagnosticSerializer.class)
    public static class MetadataDiagnostics {
        public volatile Instant startTimeUTC;
        public volatile Instant endTimeUTC;
        public volatile MetadataType metaDataName;

        public MetadataDiagnostics(Instant startTimeUTC, Instant endTimeUTC, MetadataType metaDataName) {
            this.startTimeUTC = startTimeUTC;
            this.endTimeUTC = endTimeUTC;
            this.metaDataName = metaDataName;
        }
    }

    @JsonSerialize(using = MetaDataDiagnosticSerializer.class)
    public static class ContainerLookupMetadataDiagnostics extends MetadataDiagnostics {
        public volatile String activityId;
        public volatile String collectionRid;

        public ContainerLookupMetadataDiagnostics(
            Instant startTimeUTC,
            Instant endTimeUTC,
            MetadataType metaDataName,
            String activityId,
            String collectionRid) {
            super(startTimeUTC, endTimeUTC, metaDataName);
            this.activityId = activityId;
            this.collectionRid = collectionRid;
        }
    }

    static class MetaDataDiagnosticSerializer extends StdSerializer<MetadataDiagnostics> {

        private static final long serialVersionUID = -6585518025594634820L;

        public MetaDataDiagnosticSerializer() {
            super(MetadataDiagnostics.class);
        }

        @Override
        public void serialize(MetadataDiagnostics metaDataDiagnostic, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            Duration durationinMS = metaDataDiagnostic.startTimeUTC == null ?
                null : metaDataDiagnostic.endTimeUTC == null ?
                Duration.ZERO : Duration.between(metaDataDiagnostic.startTimeUTC, metaDataDiagnostic.endTimeUTC);
            jsonGenerator.writeStartObject();
            jsonGenerator.writeObjectField("metaDataName", metaDataDiagnostic.metaDataName);
            jsonGenerator.writeStringField("startTimeUTC", DiagnosticsInstantSerializer.fromInstant(metaDataDiagnostic.startTimeUTC));
            jsonGenerator.writeStringField("endTimeUTC", DiagnosticsInstantSerializer.fromInstant(metaDataDiagnostic.endTimeUTC));
            if(durationinMS != null) {
                jsonGenerator.writeNumberField("durationinMS", durationinMS.toMillis());
            }

            if (metaDataDiagnostic instanceof ContainerLookupMetadataDiagnostics) {
                jsonGenerator.writeStringField("activityId", ((ContainerLookupMetadataDiagnostics)metaDataDiagnostic).activityId);
                jsonGenerator.writeStringField("collectionRid", ((ContainerLookupMetadataDiagnostics)metaDataDiagnostic).collectionRid);
            }

            jsonGenerator.writeEndObject();
        }
    }

    public enum MetadataType {
        CONTAINER_LOOK_UP,
        PARTITION_KEY_RANGE_LOOK_UP,
        SERVER_ADDRESS_LOOKUP,
        MASTER_ADDRESS_LOOK_UP
    }

}
