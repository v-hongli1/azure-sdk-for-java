// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.ai.metricsadvisor.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.core.annotation.Generated;
import com.azure.core.util.CoreUtils;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * The SeriesResult model.
 */
@Fluent
public final class SeriesResult implements JsonSerializable<SeriesResult> {
    /*
     * The series property.
     */
    @Generated
    private SeriesIdentity series;

    /*
     * timestamps of the series
     */
    @Generated
    private List<OffsetDateTime> timestampList;

    /*
     * values of the series
     */
    @Generated
    private List<Double> valueList;

    /*
     * whether points of the series are anomalies
     */
    @Generated
    private List<Boolean> isAnomalyList;

    /*
     * period calculated on each point of the series
     */
    @Generated
    private List<Integer> periodList;

    /*
     * expected values of the series given by smart detector
     */
    @Generated
    private List<Double> expectedValueList;

    /*
     * lower boundary list of the series given by smart detector
     */
    @Generated
    private List<Double> lowerBoundaryList;

    /*
     * upper boundary list of the series given by smart detector
     */
    @Generated
    private List<Double> upperBoundaryList;

    /**
     * Creates an instance of SeriesResult class.
     */
    @Generated
    public SeriesResult() {
    }

    /**
     * Get the series property: The series property.
     * 
     * @return the series value.
     */
    @Generated
    public SeriesIdentity getSeries() {
        return this.series;
    }

    /**
     * Set the series property: The series property.
     * 
     * @param series the series value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setSeries(SeriesIdentity series) {
        this.series = series;
        return this;
    }

    /**
     * Get the timestampList property: timestamps of the series.
     * 
     * @return the timestampList value.
     */
    @Generated
    public List<OffsetDateTime> getTimestampList() {
        return this.timestampList;
    }

    /**
     * Set the timestampList property: timestamps of the series.
     * 
     * @param timestampList the timestampList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setTimestampList(List<OffsetDateTime> timestampList) {
        this.timestampList = timestampList;
        return this;
    }

    /**
     * Get the valueList property: values of the series.
     * 
     * @return the valueList value.
     */
    @Generated
    public List<Double> getValueList() {
        return this.valueList;
    }

    /**
     * Set the valueList property: values of the series.
     * 
     * @param valueList the valueList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setValueList(List<Double> valueList) {
        this.valueList = valueList;
        return this;
    }

    /**
     * Get the isAnomalyList property: whether points of the series are anomalies.
     * 
     * @return the isAnomalyList value.
     */
    @Generated
    public List<Boolean> getIsAnomalyList() {
        return this.isAnomalyList;
    }

    /**
     * Set the isAnomalyList property: whether points of the series are anomalies.
     * 
     * @param isAnomalyList the isAnomalyList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setIsAnomalyList(List<Boolean> isAnomalyList) {
        this.isAnomalyList = isAnomalyList;
        return this;
    }

    /**
     * Get the periodList property: period calculated on each point of the series.
     * 
     * @return the periodList value.
     */
    @Generated
    public List<Integer> getPeriodList() {
        return this.periodList;
    }

    /**
     * Set the periodList property: period calculated on each point of the series.
     * 
     * @param periodList the periodList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setPeriodList(List<Integer> periodList) {
        this.periodList = periodList;
        return this;
    }

    /**
     * Get the expectedValueList property: expected values of the series given by smart detector.
     * 
     * @return the expectedValueList value.
     */
    @Generated
    public List<Double> getExpectedValueList() {
        return this.expectedValueList;
    }

    /**
     * Set the expectedValueList property: expected values of the series given by smart detector.
     * 
     * @param expectedValueList the expectedValueList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setExpectedValueList(List<Double> expectedValueList) {
        this.expectedValueList = expectedValueList;
        return this;
    }

    /**
     * Get the lowerBoundaryList property: lower boundary list of the series given by smart detector.
     * 
     * @return the lowerBoundaryList value.
     */
    @Generated
    public List<Double> getLowerBoundaryList() {
        return this.lowerBoundaryList;
    }

    /**
     * Set the lowerBoundaryList property: lower boundary list of the series given by smart detector.
     * 
     * @param lowerBoundaryList the lowerBoundaryList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setLowerBoundaryList(List<Double> lowerBoundaryList) {
        this.lowerBoundaryList = lowerBoundaryList;
        return this;
    }

    /**
     * Get the upperBoundaryList property: upper boundary list of the series given by smart detector.
     * 
     * @return the upperBoundaryList value.
     */
    @Generated
    public List<Double> getUpperBoundaryList() {
        return this.upperBoundaryList;
    }

    /**
     * Set the upperBoundaryList property: upper boundary list of the series given by smart detector.
     * 
     * @param upperBoundaryList the upperBoundaryList value to set.
     * @return the SeriesResult object itself.
     */
    @Generated
    public SeriesResult setUpperBoundaryList(List<Double> upperBoundaryList) {
        this.upperBoundaryList = upperBoundaryList;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Generated
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeJsonField("series", this.series);
        jsonWriter.writeArrayField("timestampList", this.timestampList, (writer, element) -> writer
            .writeString(element == null ? null : DateTimeFormatter.ISO_OFFSET_DATE_TIME.format(element)));
        jsonWriter.writeArrayField("valueList", this.valueList, (writer, element) -> writer.writeDouble(element));
        jsonWriter.writeArrayField("isAnomalyList", this.isAnomalyList,
            (writer, element) -> writer.writeBoolean(element));
        jsonWriter.writeArrayField("periodList", this.periodList, (writer, element) -> writer.writeInt(element));
        jsonWriter.writeArrayField("expectedValueList", this.expectedValueList,
            (writer, element) -> writer.writeDouble(element));
        jsonWriter.writeArrayField("lowerBoundaryList", this.lowerBoundaryList,
            (writer, element) -> writer.writeDouble(element));
        jsonWriter.writeArrayField("upperBoundaryList", this.upperBoundaryList,
            (writer, element) -> writer.writeDouble(element));
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of SeriesResult from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of SeriesResult if the JsonReader was pointing to an instance of it, or null if it was
     * pointing to JSON null.
     * @throws IllegalStateException If the deserialized JSON object was missing any required properties.
     * @throws IOException If an error occurs while reading the SeriesResult.
     */
    @Generated
    public static SeriesResult fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            SeriesResult deserializedSeriesResult = new SeriesResult();
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("series".equals(fieldName)) {
                    deserializedSeriesResult.series = SeriesIdentity.fromJson(reader);
                } else if ("timestampList".equals(fieldName)) {
                    List<OffsetDateTime> timestampList = reader.readArray(reader1 -> reader1
                        .getNullable(nonNullReader -> CoreUtils.parseBestOffsetDateTime(nonNullReader.getString())));
                    deserializedSeriesResult.timestampList = timestampList;
                } else if ("valueList".equals(fieldName)) {
                    List<Double> valueList = reader.readArray(reader1 -> reader1.getDouble());
                    deserializedSeriesResult.valueList = valueList;
                } else if ("isAnomalyList".equals(fieldName)) {
                    List<Boolean> isAnomalyList = reader.readArray(reader1 -> reader1.getBoolean());
                    deserializedSeriesResult.isAnomalyList = isAnomalyList;
                } else if ("periodList".equals(fieldName)) {
                    List<Integer> periodList = reader.readArray(reader1 -> reader1.getInt());
                    deserializedSeriesResult.periodList = periodList;
                } else if ("expectedValueList".equals(fieldName)) {
                    List<Double> expectedValueList = reader.readArray(reader1 -> reader1.getDouble());
                    deserializedSeriesResult.expectedValueList = expectedValueList;
                } else if ("lowerBoundaryList".equals(fieldName)) {
                    List<Double> lowerBoundaryList = reader.readArray(reader1 -> reader1.getDouble());
                    deserializedSeriesResult.lowerBoundaryList = lowerBoundaryList;
                } else if ("upperBoundaryList".equals(fieldName)) {
                    List<Double> upperBoundaryList = reader.readArray(reader1 -> reader1.getDouble());
                    deserializedSeriesResult.upperBoundaryList = upperBoundaryList;
                } else {
                    reader.skipChildren();
                }
            }

            return deserializedSeriesResult;
        });
    }
}
