// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.maps.route.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.List;

/**
 * A valid `GeoJSON GeometryCollection` object type. Please refer to [RFC
 * 7946](https://tools.ietf.org/html/rfc7946#section-3.1.8) for details.
 */
@Fluent
public final class GeoJsonGeometryCollection extends GeoJsonGeometry {
    /*
     * Specifies the `GeoJSON` type. Must be one of the nine valid GeoJSON object types - Point, MultiPoint, LineString,
     * MultiLineString, Polygon, MultiPolygon, GeometryCollection, Feature and FeatureCollection.
     */
    @Generated
    private GeoJsonObjectType type = GeoJsonObjectType.GEO_JSON_GEOMETRY_COLLECTION;

    /*
     * Contains a list of valid `GeoJSON` geometry objects. **Note** that coordinates in GeoJSON are in x, y order
     * (longitude, latitude).
     */
    @Generated
    private List<GeoJsonGeometry> geometries;

    /**
     * Creates an instance of GeoJsonGeometryCollection class.
     */
    @Generated
    public GeoJsonGeometryCollection() {
    }

    /**
     * Get the type property: Specifies the `GeoJSON` type. Must be one of the nine valid GeoJSON object types - Point,
     * MultiPoint, LineString, MultiLineString, Polygon, MultiPolygon, GeometryCollection, Feature and
     * FeatureCollection.
     * 
     * @return the type value.
     */
    @Generated
    @Override
    public GeoJsonObjectType getType() {
        return this.type;
    }

    /**
     * Get the geometries property: Contains a list of valid `GeoJSON` geometry objects. **Note** that coordinates in
     * GeoJSON are in x, y order (longitude, latitude).
     * 
     * @return the geometries value.
     */
    @Generated
    public List<GeoJsonGeometry> getGeometries() {
        return this.geometries;
    }

    /**
     * Set the geometries property: Contains a list of valid `GeoJSON` geometry objects. **Note** that coordinates in
     * GeoJSON are in x, y order (longitude, latitude).
     * 
     * @param geometries the geometries value to set.
     * @return the GeoJsonGeometryCollection object itself.
     */
    @Generated
    public GeoJsonGeometryCollection setGeometries(List<GeoJsonGeometry> geometries) {
        this.geometries = geometries;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeArrayField("geometries", this.geometries, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("type", this.type == null ? null : this.type.toString());
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of GeoJsonGeometryCollection from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of GeoJsonGeometryCollection if the JsonReader was pointing to an instance of it, or null if
     * it was pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the GeoJsonGeometryCollection.
     */
    @Generated
    public static GeoJsonGeometryCollection fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            GeoJsonGeometryCollection deserializedGeoJsonGeometryCollection = new GeoJsonGeometryCollection();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("geometries".equals(fieldName)) {
                    List<GeoJsonGeometry> geometries = reader.readArray(reader1 -> GeoJsonGeometry.fromJson(reader1));
                    deserializedGeoJsonGeometryCollection.geometries = geometries;
                } else if ("type".equals(fieldName)) {
                    deserializedGeoJsonGeometryCollection.type = GeoJsonObjectType.fromString(reader.getString());
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedGeoJsonGeometryCollection;
        });
    }
}
