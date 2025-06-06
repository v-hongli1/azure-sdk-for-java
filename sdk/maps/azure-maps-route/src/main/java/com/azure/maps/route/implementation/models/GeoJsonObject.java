// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.route.implementation.models;

import com.azure.core.annotation.Generated;
import com.azure.core.annotation.Immutable;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;

/**
 * A valid `GeoJSON` object. Please refer to [RFC 7946](https://tools.ietf.org/html/rfc7946#section-3) for details.
 */
@Immutable
public class GeoJsonObject implements JsonSerializable<GeoJsonObject> {
    /*
     * Specifies the `GeoJSON` type. Must be one of the nine valid GeoJSON object types - Point, MultiPoint, LineString,
     * MultiLineString, Polygon, MultiPolygon, GeometryCollection, Feature and FeatureCollection.
     */
    @Generated
    private GeoJsonObjectType type;

    /**
     * Creates an instance of GeoJsonObject class.
     */
    @Generated
    public GeoJsonObject() {
    }

    /**
     * Get the type property: Specifies the `GeoJSON` type. Must be one of the nine valid GeoJSON object types - Point,
     * MultiPoint, LineString, MultiLineString, Polygon, MultiPolygon, GeometryCollection, Feature and
     * FeatureCollection.
     * 
     * @return the type value.
     */
    @Generated
    public GeoJsonObjectType getType() {
        return this.type;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GeoJsonObject from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GeoJsonObject if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IOException If an error occurs while reading the GeoJsonObject.
     */
    @Generated
    public static GeoJsonObject fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            String discriminatorValue = null;
            try (JsonReader readerToUse = reader.bufferObject()) {
                readerToUse.nextToken(); // Prepare for reading
                while (readerToUse.nextToken() != JsonToken.END_OBJECT) {
                    String fieldName = readerToUse.getFieldName();
                    readerToUse.nextToken();
                    if ("type".equals(fieldName)) {
                        discriminatorValue = readerToUse.getString();
                        break;
                    } else {
                        readerToUse.skipChildren();
                    }
                }
                // Use the discriminator value to determine which subtype should be deserialized.
                if ("GeoJsonGeometry".equals(discriminatorValue)) {
                    return GeoJsonGeometry.fromJsonKnownDiscriminator(readerToUse.reset());
                } else if ("MultiPoint".equals(discriminatorValue)) {
                    return GeoJsonMultiPoint.fromJson(readerToUse.reset());
                } else if ("GeometryCollection".equals(discriminatorValue)) {
                    return GeoJsonGeometryCollection.fromJson(readerToUse.reset());
                } else if ("MultiPolygon".equals(discriminatorValue)) {
                    return GeoJsonMultiPolygon.fromJson(readerToUse.reset());
                } else if ("Point".equals(discriminatorValue)) {
                    return GeoJsonPoint.fromJson(readerToUse.reset());
                } else if ("LineString".equals(discriminatorValue)) {
                    return GeoJsonLineString.fromJson(readerToUse.reset());
                } else if ("MultiLineString".equals(discriminatorValue)) {
                    return GeoJsonMultiLineString.fromJson(readerToUse.reset());
                } else if ("Polygon".equals(discriminatorValue)) {
                    return GeoJsonPolygon.fromJson(readerToUse.reset());
                } else if ("Feature".equals(discriminatorValue)) {
                    return GeoJsonFeature.fromJson(readerToUse.reset());
                } else if ("FeatureCollection".equals(discriminatorValue)) {
                    return GeoJsonFeatureCollection.fromJson(readerToUse.reset());
                } else {
                    return fromJsonKnownDiscriminator(readerToUse.reset());
                }
            }
        });
    }

    @Generated
    static GeoJsonObject fromJsonKnownDiscriminator(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GeoJsonObject deserializedGeoJsonObject = new GeoJsonObject();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("type".equals(fieldName)) {
                    deserializedGeoJsonObject.type = GeoJsonObjectType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGeoJsonObject;
        });
    }
}
