// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// 
// Code generated by Microsoft (R) AutoRest Code Generator.
// Changes may cause incorrect behavior and will be lost if the code is regenerated.

package com.azure.search.documents.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * Contains debugging information that can be used to further explore your search results.
 */
@Immutable
public final class DebugInfo implements JsonSerializable<DebugInfo> {
    /*
     * Contains debugging information specific to query rewrites.
     */
    @Generated
    private QueryRewritesDebugInfo queryRewrites;

    /**
     * Creates an instance of DebugInfo class.
     */
    @Generated
    public DebugInfo() {
    }

    /**
     * Get the queryRewrites property: Contains debugging information specific to query rewrites.
     * 
     * @return the queryRewrites value.
     */
    @Generated
    public QueryRewritesDebugInfo getQueryRewrites() {
        return this.queryRewrites;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of DebugInfo from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of DebugInfo if the JsonReader was pointing to an instance of it, or null if it was pointing
     * to JSON null.
     * @throws IOException If an error occurs while reading the DebugInfo.
     */
    @Generated
    public static DebugInfo fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            DebugInfo deserializedDebugInfo = new DebugInfo();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("queryRewrites".equals(fieldName)) {
                    deserializedDebugInfo.queryRewrites = QueryRewritesDebugInfo.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedDebugInfo;
        });
    }
}
