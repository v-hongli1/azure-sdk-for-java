// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.

package io.clientcore.core.serialization.json;

import io.clientcore.core.models.binarydata.BinaryData;
import io.clientcore.core.serialization.json.implementation.jackson.core.JsonFactory;
import io.clientcore.core.serialization.json.implementation.jackson.core.JsonGenerator;
import io.clientcore.core.utils.IOExceptionCheckedBiConsumer;

import java.io.Closeable;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * Writes a JSON value as a stream of tokens.
 * <p>
 * Instances of {@link JsonWriter} are created using factory method on this class.
 *
 * @see io.clientcore.core.serialization.json
 */
@SuppressWarnings("resource")
public final class JsonWriter implements Closeable {
    private static final JsonFactory FACTORY = new JsonFactory();

    private final JsonGenerator generator;

    // Initial state is always root.
    private JsonWriteContext context = JsonWriteContext.ROOT;

    /**
     * Creates an instance of {@link JsonWriter}.
     */
    private JsonWriter(JsonGenerator generator, JsonOptions options) {
        this.generator = generator;
        this.generator.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS, true);
    }

    /**
     * Creates a {@link JsonWriter} that writes the given {@link OutputStream}.
     * <p>
     * The passed {@link OutputStream} won't be closed when {@link #close()} is called as the {@link JsonWriter} isn't
     * the owner of the stream.
     * <p>
     * This will call {@link #toStream(OutputStream, JsonOptions)} with null {@link JsonOptions}.
     *
     * @param json The {@link OutputStream} that will be written.
     * @return An instance of {@link JsonWriter}.
     * @throws NullPointerException If {@code json} is null.
     * @throws IOException If a {@link JsonWriter} could not be constructed from the {@link OutputStream}.
     */
    public static JsonWriter toStream(OutputStream json) throws IOException {
        return toStream(json, null);
    }

    /**
     * Creates a {@link JsonWriter} that writes the given {@link OutputStream}.
     * <p>
     * The passed {@link OutputStream} won't be closed when {@link #close()} is called as the {@link JsonWriter}
     * isn't the owner of the stream.
     *
     * @param json The {@link OutputStream} that will be written.
     * @param options {@link JsonOptions} to configure the creation of the {@link JsonWriter}.
     * @return An instance of {@link JsonWriter}.
     * @throws NullPointerException If {@code json} is null.
     * @throws IOException If a {@link JsonWriter} could not be constructed from the {@link OutputStream}.
     */
    public static JsonWriter toStream(OutputStream json, JsonOptions options) throws IOException {
        Objects.requireNonNull(json, "'json' cannot be null.");
        return new JsonWriter(FACTORY.createGenerator(new OutputStreamWriter(json)), options);
    }

    /**
     * Creates a {@link JsonWriter} that writes the given {@link Writer}.
     * <p>
     * The passed {@link Writer} won't be closed when {@link #close()} is called as the {@link JsonWriter} isn't
     * the owner of the stream.
     * <p>
     * This will call {@link #toWriter(Writer, JsonOptions)} with null {@link JsonOptions}.
     *
     * @param json The {@link Writer} that will be written.
     * @return An instance of {@link JsonWriter}.
     * @throws NullPointerException If {@code json} is null.
     * @throws IOException If a {@link JsonWriter} could not be constructed from the {@link Writer}.
     */
    public static JsonWriter toWriter(Writer json) throws IOException {
        return toWriter(json, null);
    }

    /**
     * Creates a {@link JsonWriter} that writes the given {@link Writer}.
     * <p>
     * The passed {@link Writer} won't be closed when {@link #close()} is called as the {@link JsonWriter} isn't
     * the owner of the stream.
     *
     * @param json The {@link Writer} that will be written.
     * @param options {@link JsonOptions} to configure the creation of the {@link JsonWriter}.
     * @return An instance of {@link JsonWriter}.
     * @throws NullPointerException If {@code json} is null.
     * @throws IOException If a {@link JsonWriter} could not be constructed from the {@link Writer}.
     */
    public static JsonWriter toWriter(Writer json, JsonOptions options) throws IOException {
        Objects.requireNonNull(json, "'json' cannot be null.");
        return new JsonWriter(FACTORY.createGenerator(json), options);
    }

    /**
     * Gets the current {@link JsonWriteContext writing context} for the JSON object.
     * <p>
     * The writing context can help determine whether a write operation would be illegal.
     * <p>
     * The initial write context is {@link JsonWriteContext#ROOT}.
     *
     * @return The current writing context.
     */
    public JsonWriteContext getWriteContext() {
        return context;
    }

    /**
     * Closes the JSON stream.
     * <p>
     * If the {@link #getWriteContext() writing context} isn't {@link JsonWriteContext#COMPLETED} when this is called an
     * {@link IllegalStateException} will be thrown.
     * <p>
     * During closing the implementation of {@link JsonWriter} must flush any un-flushed content.
     *
     * @throws IllegalStateException If the {@link JsonWriter} is closed before the
     * {@link #getWriteContext() writing context} is {@link JsonWriteContext#COMPLETED}.
     * @throws IOException If the underlying content store fails to close.
     */
    @Override
    public void close() throws IOException {
        if (context != JsonWriteContext.COMPLETED) {
            throw new IllegalStateException("Writing of the JSON object must be completed before the writer can be "
                + "closed. Current writing state is '" + context.getWriteState() + "'.");
        }

        generator.flush();
        generator.close();
    }

    /**
     * Flushes any un-flushed content written to this writer.
     * <p>
     * It should be assumed that each write call won't flush any contents.
     *
     * @return The flushed JsonWriter object.
     * @throws IOException If the underlying content fails to flush.
     */
    public JsonWriter flush() throws IOException {
        generator.flush();
        return this;
    }

    /**
     * Writes a JSON start object ({@code &#123;}).
     *
     * @return The updated JsonWriter object.
     * @throws IOException If JSON start object fails to be written.
     */
    public JsonWriter writeStartObject() throws IOException {
        context.validateToken(JsonToken.START_OBJECT);
        generator.writeStartObject();

        context = context.updateContext(JsonToken.START_OBJECT);
        return this;
    }

    /**
     * Writes a JSON start object ({@code &#123;}) with a preceding field name.
     * <p>
     * This API is the equivalent of calling {@link #writeFieldName(String)} and {@link #writeStartObject()}, in that
     * order.
     *
     * @param fieldName The field name.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either {@code fieldName} or JSON start object fails to be written.
     */
    public JsonWriter writeStartObject(String fieldName) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeStartObject();
    }

    /**
     * Writes a JSON end object ({@code &#125;}).
     * <p>
     * If the current writing context isn't an object an {@link IllegalStateException} will be thrown.
     *
     * @return The updated JsonWriter object.
     * @throws IOException If JSON end object fails to be written.
     */
    public JsonWriter writeEndObject() throws IOException {
        context.validateToken(JsonToken.END_OBJECT);
        generator.writeEndObject();

        context = context.updateContext(JsonToken.END_OBJECT);
        return this;
    }

    /**
     * Writes a JSON start array ({@code [}).
     *
     * @return The updated JsonWriter object.
     * @throws IOException If JSON start array fails to be written.
     */
    public JsonWriter writeStartArray() throws IOException {
        context.validateToken(JsonToken.START_ARRAY);
        generator.writeStartArray();

        context = context.updateContext(JsonToken.START_ARRAY);
        return this;
    }

    /**
     * Writes a JSON start array ({@code [}) with a preceding field name.
     * <p>
     * This API is the equivalent of calling {@link #writeFieldName(String)} and {@link #writeStartArray()}, in that
     * order.
     *
     * @param fieldName The field name.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either {@code fieldName} or JSON start array fails to be written.
     */
    public JsonWriter writeStartArray(String fieldName) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeStartArray();
    }

    /**
     * Writes a JSON end array ({@code ]}).
     *
     * @return The updated JsonWriter object.
     * @throws IOException If JSON end array fails to be written.
     */
    public JsonWriter writeEndArray() throws IOException {
        context.validateToken(JsonToken.END_ARRAY);
        generator.writeEndArray();

        context = context.updateContext(JsonToken.END_ARRAY);
        return this;
    }

    /**
     * Writes a JSON field name ({@code "fieldName":}).
     *
     * @param fieldName The field name.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If {@code fieldName} fails to be written.
     */
    public JsonWriter writeFieldName(String fieldName) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        context.validateToken(JsonToken.FIELD_NAME);
        generator.writeFieldName(fieldName);

        context = context.updateContext(JsonToken.FIELD_NAME);
        return this;
    }

    /**
     * Writes a {@link JsonSerializable} object.
     * <p>
     * If {@code value} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeJsonField(String, JsonSerializable)} when the value needs to be written
     * to the root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @param value {@link JsonSerializable} object to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the {@link JsonSerializable} fails to be written.
     */
    public JsonWriter writeJson(JsonSerializable<?> value) throws IOException {
        return (value == null) ? this : value.toJson(this);
    }

    /**
     * Writes a JSON array.
     * <p>
     * This API will begin by writing the start array ({@code [}) followed by all elements in the array using the
     * {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element. If null elements
     * should be excluded from serialization use {@link #writeArray(Object[], IOExceptionCheckedBiConsumer, boolean)} and pass
     * true for {@code skipNullElements}.
     * <p>
     * If {@code array} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeArrayField(String, Object[], IOExceptionCheckedBiConsumer)} when the value
     * needs to be written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code elementWriterFunc} is null.
     * @throws IOException If the JSON array fails to be written, either the start or end array or an element write.
     */
    public <T> JsonWriter writeArray(T[] array, IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc)
        throws IOException {
        return writeArray(array, elementWriterFunc, false);
    }

    /**
     * Writes a JSON array.
     * <p>
     * This API will begin by writing the start array ({@code [}) followed by all elements in the array using the
     * {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element if
     * {@code skipNullElements} is false. If {@code skipNullElements} is true, null elements will be excluded from
     * serialization.
     * <p>
     * If {@code array} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeArrayField(String, Object[], IOExceptionCheckedBiConsumer, boolean)} when the
     * value needs to be written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param skipNullElements Whether null elements will be skipped.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code elementWriterFunc} is null.
     * @throws IOException If the JSON array fails to be written, either the start or end array or an element write.
     */
    public <T> JsonWriter writeArray(T[] array, IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc,
        boolean skipNullElements) throws IOException {
        Objects.requireNonNull(elementWriterFunc, "'elementWriterFunc' cannot be null.");

        if (array == null) {
            return writeNull();
        }

        return writeArrayInternal(Arrays.asList(array), elementWriterFunc, null, skipNullElements);
    }

    /**
     * Writes a JSON array.
     * <p>
     * This API will begin by writing the start array ({@code [}) followed by all elements in the array using the
     * {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element. If null elements
     * should be excluded from serialization use {@link #writeArray(Iterable, IOExceptionCheckedBiConsumer, boolean)} and pass
     * true for {@code skipNullElements}.
     * <p>
     * If {@code array} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeArrayField(String, Iterable, IOExceptionCheckedBiConsumer)} when the value
     * needs to be written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code elementWriterFunc} is null.
     * @throws IOException If the JSON array fails to be written, either the start or end array or an element write.
     */
    public <T> JsonWriter writeArray(Iterable<T> array, IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc)
        throws IOException {
        return writeArray(array, elementWriterFunc, false);
    }

    /**
     * Writes a JSON array.
     * <p>
     * This API will begin by writing the start array ({@code [}) followed by all elements in the array using the
     * {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element if
     * {@code skipNullElements} is false. If {@code skipNullElements} is true, null elements will be excluded from
     * serialization.
     * <p>
     * If {@code array} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeArrayField(String, Iterable, IOExceptionCheckedBiConsumer, boolean)} when the
     * value needs to be written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param skipNullElements Whether null elements will be skipped.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code elementWriterFunc} is null.
     * @throws IOException If the JSON array fails to be written, either the start or end array or an element write.
     */
    public <T> JsonWriter writeArray(Iterable<T> array, IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc,
        boolean skipNullElements) throws IOException {
        Objects.requireNonNull(elementWriterFunc, "'elementWriterFunc' cannot be null.");

        if (array == null) {
            return writeNull();
        }

        return writeArrayInternal(array, elementWriterFunc, null, skipNullElements);
    }

    private <T> JsonWriter writeArrayInternal(Iterable<T> array, IOExceptionCheckedBiConsumer<JsonWriter, T> func,
        String fieldName, boolean skipNullElements) throws IOException {
        if (fieldName == null) {
            writeStartArray();
        } else {
            writeStartArray(fieldName);
        }

        for (T element : array) {
            if (element == null) {
                if (skipNullElements) {
                    continue;
                }

                writeNull();
            } else {
                func.accept(this, element);
            }
        }

        return writeEndArray();
    }

    /**
     * Writes a JSON map.
     * <p>
     * This API will begin by writing the start object ({@code &#123;}) followed by key-value fields in the map using
     * the {@code valueWriterFunc} and finishing by writing the end object ({@code &#125;}).
     * <p>
     * If any value in the map is null and the {@code valueWriterFunc} skips null values, such as
     * {@link #writeJson(JsonSerializable)}, {@link JsonToken#NULL} will be written for that value. Otherwise, handling
     * of the null value is determined by {@code valueWriterFunc}.
     * <p>
     * If {@code map} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeMapField(String, Map, IOExceptionCheckedBiConsumer)} when the value needs to be
     * written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param map The map being written.
     * @param valueWriterFunc The function that writes value of each key-value pair in the map.
     * @param <T> The value element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code valueWriterFunc} is null or any key in the map is null.
     * @throws IOException If the JSON map fails to be written, either the start or end object or a key or value write.
     */
    public <T> JsonWriter writeMap(Map<String, T> map, IOExceptionCheckedBiConsumer<JsonWriter, T> valueWriterFunc)
        throws IOException {
        return writeMap(map, valueWriterFunc, false);
    }

    /**
     * Writes a JSON map.
     * <p>
     * This API will begin by writing the start object ({@code &#123;}) followed by key-value fields in the map using
     * the {@code valueWriterFunc} and finishing by writing the end object ({@code &#125;}).
     * <p>
     * If a value in the map is null and {@code skipNullValues} is true, that key-value pair will be skipped. Otherwise,
     * handling of the null value will be based on {@code valueWriterFunc}. If {@code valueWriterFunc} skips null
     * values, such as {@link #writeJson(JsonSerializable)}, {@link JsonToken#NULL} will be written for that value.
     * <p>
     * If {@code map} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeMapField(String, Map, IOExceptionCheckedBiConsumer, boolean)} when the value needs
     * to be written to the root of the JSON value, as an element in an array, or after a call to
     * {@link #writeFieldName(String)}.
     *
     * @param map The map being written.
     * @param valueWriterFunc The function that writes value of each key-value pair in the map.
     * @param skipNullValues Whether null values in the map are skipped.
     * @param <T> The value element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code valueWriterFunc} is null or any key in the map is null.
     * @throws IOException If the JSON map fails to be written, either the start or end object or a key or value write.
     */
    public <T> JsonWriter writeMap(Map<String, T> map, IOExceptionCheckedBiConsumer<JsonWriter, T> valueWriterFunc,
        boolean skipNullValues) throws IOException {
        Objects.requireNonNull(valueWriterFunc, "'valueWriterFunc' cannot be null.");

        if (map == null) {
            return writeNull();
        }

        return writeMapInternal(null, map, valueWriterFunc, skipNullValues);
    }

    private <T> JsonWriter writeMapInternal(String fieldName, Map<String, T> map,
        IOExceptionCheckedBiConsumer<JsonWriter, T> valueWriterFunc, boolean skipNullValues) throws IOException {
        if (fieldName == null) {
            writeStartObject();
        } else {
            writeStartObject(fieldName);
        }

        for (Map.Entry<String, T> entry : map.entrySet()) {
            T value = entry.getValue();
            if (skipNullValues && value == null) {
                // Skipping null values.
                continue;
            }

            // Write the key as the field name.
            writeFieldName(entry.getKey());

            if (value == null) {
                // Write a null value.
                writeNull();
            } else {
                // Write the value.
                valueWriterFunc.accept(this, value);
            }
        }

        return writeEndObject();
    }

    /**
     * Writes a JSON binary value.
     * <p>
     * If {@code value} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeBinaryField(String, byte[])} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @param value Binary value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the binary {@code value} fails to be written.
     */
    public JsonWriter writeBinary(byte[] value) throws IOException {
        context.validateToken(JsonToken.STRING);
        if (value == null) {
            generator.writeNull();
        } else {
            generator.writeBinary(value);
        }

        context = context.updateContext(JsonToken.STRING);
        return this;
    }

    /**
     * Writes a JSON boolean value ({@code true} or {@code false}).
     * <p>
     * This API is used instead of {@link #writeBooleanField(String, boolean)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the nullable {@code Boolean} use {@link #writeBoolean(Boolean)}.
     *
     * @param value boolean value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the boolean {@code value} fails to be written.
     */
    public JsonWriter writeBoolean(boolean value) throws IOException {
        context.validateToken(JsonToken.BOOLEAN);
        generator.writeBoolean(value);

        context = context.updateContext(JsonToken.BOOLEAN);
        return this;
    }

    /**
     * Writes a nullable JSON boolean value ({@code true}, {@code false}, or {@code null}).
     * <p>
     * If {@code value} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeBooleanField(String, Boolean)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the primitive {@code boolean} use {@link #writeBoolean(boolean)}.
     *
     * @param value Boolean value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the Boolean {@code value} fails to be written.
     */
    public JsonWriter writeBoolean(Boolean value) throws IOException {
        return (value == null) ? writeNull() : writeBoolean(value.booleanValue());
    }

    /**
     * Writes a JSON double value.
     * <p>
     * This API is used instead of {@link #writeDoubleField(String, double)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the nullable {@code Double} use {@link #writeNumber(Number)}.
     *
     * @param value double value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the double {@code value} fails to be written.
     */
    public JsonWriter writeDouble(double value) throws IOException {
        context.validateToken(JsonToken.NUMBER);
        generator.writeNumber(value);

        context = context.updateContext(JsonToken.NUMBER);
        return this;
    }

    /**
     * Writes a JSON float value.
     * <p>
     * This API is used instead of {@link #writeFloatField(String, float)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the nullable {@code Float} use {@link #writeNumber(Number)}.
     *
     * @param value float value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the float {@code value} fails to be written.
     */
    public JsonWriter writeFloat(float value) throws IOException {
        context.validateToken(JsonToken.NUMBER);
        generator.writeNumber(value);

        context = context.updateContext(JsonToken.NUMBER);
        return this;
    }

    /**
     * Writes a JSON int value.
     * <p>
     * This API is used instead of {@link #writeIntField(String, int)} when the value needs to be written to the root of
     * the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the nullable {@code Integer} use {@link #writeNumber(Number)}.
     *
     * @param value int value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the int {@code value} fails to be written.
     */
    public JsonWriter writeInt(int value) throws IOException {
        context.validateToken(JsonToken.NUMBER);
        generator.writeNumber(value);

        context = context.updateContext(JsonToken.NUMBER);
        return this;
    }

    /**
     * Writes a JSON long value.
     * <p>
     * This API is used instead of {@link #writeLongField(String, long)} when the value needs to be written to the root
     * of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     * <p>
     * For the nullable {@code Long} use {@link #writeNumber(Number)}.
     *
     * @param value long value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the long {@code value} fails to be written.
     */
    public JsonWriter writeLong(long value) throws IOException {
        context.validateToken(JsonToken.NUMBER);
        generator.writeNumber(value);

        context = context.updateContext(JsonToken.NUMBER);
        return this;
    }

    /**
     * Writes a JSON null.
     * <p>
     * This API is used instead of {@link #writeNullField(String)} when the value needs to be written to the root of the
     * JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @return The updated JsonWriter object.
     * @throws IOException If a JSON null fails to be written.
     */
    public JsonWriter writeNull() throws IOException {
        context.validateToken(JsonToken.NULL);
        generator.writeNull();

        context = context.updateContext(JsonToken.NULL);
        return this;
    }

    /**
     * Writes a nullable JSON number value.
     * <p>
     * If {@code value} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeNumberField(String, Number)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @param value Number value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the Number {@code value} fails to be written.
     */
    public JsonWriter writeNumber(Number value) throws IOException {
        if (value == null) {
            return writeNull();
        } else if (value instanceof Byte || value instanceof Short || value instanceof Integer) {
            return writeInt(value.intValue());
        } else if (value instanceof Long) {
            return writeLong(value.longValue());
        } else if (value instanceof Float) {
            return writeFloat(value.floatValue());
        } else if (value instanceof Double) {
            return writeDouble(value.doubleValue());
        } else {
            return writeRawValue(value.toString());
        }
    }

    /**
     * Writes a JSON String value.
     * <p>
     * If {@code value} is null {@link JsonToken#NULL} will be written.
     * <p>
     * This API is used instead of {@link #writeStringField(String, String)} when the value needs to be written to the
     * root of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @param value String value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the String {@code value} fails to be written.
     */
    public JsonWriter writeString(String value) throws IOException {
        context.validateToken(JsonToken.STRING);
        generator.writeString(value);

        context = context.updateContext(JsonToken.STRING);
        return this;
    }

    /**
     * Writes the passed value literally without any additional handling.
     * <p>
     * Use this API when writing a String value that is already properly formatted JSON, such as a JSON string
     * ({@code "\"string\""}), number ({@code "42"}, {@code "42.0"}), boolean ({@code "true"}, {@code "false"}), null
     * ({@code "null"}), array ({@code "[\"string\", \"array\"]"}), or object ({@code {"\"field\":\"value\""}}).
     * <p>
     * This API is used instead of {@link #writeRawField(String, String)} when the value needs to be written to the root
     * of the JSON value, as an element in an array, or after a call to {@link #writeFieldName(String)}.
     *
     * @param value The raw JSON value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code value} is null.
     * @throws IOException If the raw {@code value} fails to be written.
     */
    public JsonWriter writeRawValue(String value) throws IOException {
        Objects.requireNonNull(value, "'value' cannot be null.");

        context.validateToken(JsonToken.STRING);
        generator.writeRawValue(value);

        context = context.updateContext(JsonToken.STRING);
        return this;
    }

    /**
     * Writes a nullable JSON field.
     * <p>
     * When the {@code value} is null this effectively is the same as {@link #writeNullField(String)}. When the
     * {@code value} isn't null this will write the JSON field name and call the {@code writerFunc} that is supplied
     * with the non-null nullable value and this {@link JsonWriter} to perform the write operation.
     *
     * @param fieldName The field name.
     * @param nullable The nullable JSON value.
     * @param writerFunc The non-null JSON value writer function.
     * @param <T> Type of the nullable value.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code writerFunc} is null.
     * @throws IOException If the {@code fieldName} or the {@code nullable} fails to be written.
     */
    public <T> JsonWriter writeNullableField(String fieldName, T nullable,
        IOExceptionCheckedBiConsumer<JsonWriter, T> writerFunc) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        Objects.requireNonNull(writerFunc, "'writerFunc' cannot be null.");

        if (nullable == null) {
            return writeNullField(fieldName);
        }

        writerFunc.accept(writeFieldName(fieldName), nullable);
        return this;
    }

    /**
     * Writes a {@link JsonSerializable} field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeJson(JsonSerializable)} to simplify adding a key-value
     * to a JSON object.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     *
     * @param fieldName The field name.
     * @param value {@link JsonSerializable} object to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If the {@code fieldName} or the {@link JsonSerializable} fails to be written.
     */
    public JsonWriter writeJsonField(String fieldName, JsonSerializable<?> value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return (value == null) ? this : value.toJson(writeFieldName(fieldName));
    }

    /**
     * Writes a JSON array field.
     * <p>
     * This API will begin by writing the field name and start array ({@code [}) followed by all elements in the array
     * using the {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element. If null elements
     * should be excluded from serialization use {@link #writeArrayField(String, Object[], IOExceptionCheckedBiConsumer, boolean)}
     * and pass true for {@code skipNullElements}.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeArray(Object[], IOExceptionCheckedBiConsumer)} to simplify
     * adding a key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code elementWriterFunc} is null.
     * @throws IOException If the {@code fieldName} or the JSON array fails to be written, either JSON start or end
     * array or the element write.
     */
    public <T> JsonWriter writeArrayField(String fieldName, T[] array,
        IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc) throws IOException {
        return writeArrayField(fieldName, array, elementWriterFunc, false);
    }

    /**
     * Writes a JSON array field.
     * <p>
     * This API will begin by writing the field name and start array ({@code [}) followed by all elements in the array
     * using the {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element if
     * {@code skipNullElements} is false. If {@code skipNullElements} is true, null elements will be excluded from
     * serialization.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeArray(Object[], IOExceptionCheckedBiConsumer, boolean)} to
     * simplify adding a key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param skipNullElements Whether null elements will be skipped.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code elementWriterFunc} is null.
     * @throws IOException If the {@code fieldName} or the JSON array fails to be written, either JSON start or end
     * array or the element write.
     */
    public <T> JsonWriter writeArrayField(String fieldName, T[] array,
        IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc, boolean skipNullElements) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        Objects.requireNonNull(elementWriterFunc, "'elementWriterFunc' cannot be null.");

        if (array == null) {
            return this;
        }

        return writeArrayInternal(Arrays.asList(array), elementWriterFunc, fieldName, skipNullElements);
    }

    /**
     * Writes a JSON array field.
     * <p>
     * This API will begin by writing the field name and start array ({@code [}) followed by all elements in the array
     * using the {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element. If null elements
     * should be excluded from serialization use {@link #writeArrayField(String, Iterable, IOExceptionCheckedBiConsumer, boolean)}
     * and pass true for {@code skipNullElements}.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeArray(Iterable, IOExceptionCheckedBiConsumer)} to simplify
     * adding a key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code elementWriterFunc} is null.
     * @throws IOException If the {@code fieldName} or the JSON array fails to be written, either JSON start or end
     * array or the element write.
     */
    public <T> JsonWriter writeArrayField(String fieldName, Iterable<T> array,
        IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc) throws IOException {
        return writeArrayField(fieldName, array, elementWriterFunc, false);
    }

    /**
     * Writes a JSON array field.
     * <p>
     * This API will begin by writing the field name and start array ({@code [}) followed by all elements in the array
     * using the {@code elementWriterFunc} and finishing by writing the end array ({@code ]}).
     * <p>
     * If an element in the array is null, {@link JsonToken#NULL} will be written for that element if
     * {@code skipNullElements} is false. If {@code skipNullElements} is true, null elements will be excluded from
     * serialization.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeArray(Iterable, IOExceptionCheckedBiConsumer, boolean)} to
     * simplify adding a key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param array The array being written.
     * @param elementWriterFunc The function that writes each element of the array.
     * @param skipNullElements Whether null elements will be skipped.
     * @param <T> The array element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code elementWriterFunc} is null.
     * @throws IOException If the {@code fieldName} or the JSON array fails to be written, either JSON start or end
     * array or the element write.
     */
    public <T> JsonWriter writeArrayField(String fieldName, Iterable<T> array,
        IOExceptionCheckedBiConsumer<JsonWriter, T> elementWriterFunc, boolean skipNullElements) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        Objects.requireNonNull(elementWriterFunc, "'elementWriterFunc' cannot be null.");

        if (array == null) {
            return this;
        }

        return writeArrayInternal(array, elementWriterFunc, fieldName, skipNullElements);
    }

    /**
     * Writes a JSON map field.
     * <p>
     * This API will begin by writing the field name and start object ({@code &#123;}) followed by key-value fields in
     * the map using the {@code valueWriterFunc} and finishing by writing the end object ({@code &#125;}).
     * <p>
     * If any value in the map is null and the {@code valueWriterFunc} skips null values, such as
     * {@link #writeJson(JsonSerializable)}, {@link JsonToken#NULL} will be written for that value. Otherwise, handling
     * of the null value is determined by {@code valueWriterFunc}.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeMap(Map, IOExceptionCheckedBiConsumer)} to simplify adding a
     * key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param map The map being written.
     * @param valueWriterFunc The function that writes each value of the map.
     * @param <T> The value element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code valueWriterFunc} is null or any key in the map is
     * null.
     * @throws IOException If the {@code fieldName} or the JSON map fails to be written, either JSON start or end object
     * or the key or value write.
     */
    public <T> JsonWriter writeMapField(String fieldName, Map<String, T> map,
        IOExceptionCheckedBiConsumer<JsonWriter, T> valueWriterFunc) throws IOException {
        return writeMapField(fieldName, map, valueWriterFunc, false);
    }

    /**
     * Writes a JSON map field.
     * <p>
     * This API will begin by writing the field name and start object ({@code &#123;}) followed by key-value fields in
     * the map using the {@code valueWriterFunc} and finishing by writing the end object ({@code &#125;}).
     * <p>
     * If a value in the map is null and {@code skipNullValues} is true, that key-value pair will be skipped. Otherwise,
     * handling of the null value will be based on {@code valueWriterFunc}. If {@code valueWriterFunc} skips null
     * values, such as {@link #writeJson(JsonSerializable)}, {@link JsonToken#NULL} will be written for that value.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeMap(Map, IOExceptionCheckedBiConsumer, boolean)} to simplify
     * adding a key-value to a JSON object.
     *
     * @param fieldName The field name.
     * @param map The map being written.
     * @param valueWriterFunc The function that writes each value of the map.
     * @param skipNullValues Whether null values in the map are skipped.
     * @param <T> The value element type.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code valueWriterFunc} is null or any key in the map is
     * null.
     * @throws IOException If the {@code fieldName} or the JSON map fails to be written, either JSON start or end object
     * or the key or value write.
     */
    public <T> JsonWriter writeMapField(String fieldName, Map<String, T> map,
        IOExceptionCheckedBiConsumer<JsonWriter, T> valueWriterFunc, boolean skipNullValues) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        Objects.requireNonNull(valueWriterFunc, "'valueWriterFunc' cannot be null.");

        if (map == null) {
            return this;
        }

        return writeMapInternal(fieldName, map, valueWriterFunc, skipNullValues);
    }

    /**
     * Writes a JSON binary field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeBinary(byte[])} to simplify adding a key-value to a
     * JSON object.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     *
     * @param fieldName The field name.
     * @param value Binary value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or binary {@code value} fails to be written.
     */
    public JsonWriter writeBinaryField(String fieldName, byte[] value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        if (value == null) {
            return this;
        }

        return writeFieldName(fieldName).writeBinary(value);
    }

    /**
     * Writes a JSON boolean field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeBoolean(boolean)} to simplify adding a key-value to a
     * JSON object.
     *
     * @param fieldName The field name.
     * @param value boolean value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or boolean {@code value} fails to be written.
     */
    public JsonWriter writeBooleanField(String fieldName, boolean value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeBoolean(value);
    }

    /**
     * Writes a nullable JSON boolean field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeBoolean(Boolean)} to simplify adding a key-value to a
     * JSON object.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     *
     * @param fieldName The field name.
     * @param value Boolean value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or Boolean {@code value} fails to be written.
     */
    public JsonWriter writeBooleanField(String fieldName, Boolean value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return (value == null) ? this : writeBooleanField(fieldName, value.booleanValue());
    }

    /**
     * Writes a JSON double field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeDouble(double)} to simplify adding a key-value to a
     * JSON object.
     *
     * @param fieldName The field name.
     * @param value double value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or double {@code value} fails to be written.
     */
    public JsonWriter writeDoubleField(String fieldName, double value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeDouble(value);
    }

    /**
     * Writes a JSON float field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeFloat(float)} to simplify adding a key-value to a JSON
     * object.
     *
     * @param fieldName The field name.
     * @param value float value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or float {@code value} fails to be written.
     */
    public JsonWriter writeFloatField(String fieldName, float value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeFloat(value);
    }

    /**
     * Writes a JSON int field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeInt(int)} to simplify adding a key-value to a JSON
     * object.
     *
     * @param fieldName The field name.
     * @param value int value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or int {@code value} fails to be written.
     */
    public JsonWriter writeIntField(String fieldName, int value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeInt(value);
    }

    /**
     * Writes a JSON long field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeLong(long)} to simplify adding a key-value to a JSON
     * object.
     *
     * @param fieldName The field name.
     * @param value long value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or long {@code value} fails to be written.
     */
    public JsonWriter writeLongField(String fieldName, long value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeLong(value);
    }

    /**
     * Writes a JSON null field ({@code "fieldName":null}).
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeNull()} to simplify adding a key-value to a JSON
     * object.
     *
     * @param fieldName The field name.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or JSON null fails to be written.
     */
    public JsonWriter writeNullField(String fieldName) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeNull();
    }

    /**
     * Writes a nullable JSON number field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeNumber(Number)} to simplify adding a key-value to a
     * JSON object.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     *
     * @param fieldName The field name.
     * @param value Number value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or Number {@code value} fails to be written.
     */
    public JsonWriter writeNumberField(String fieldName, Number value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        if (value == null) {
            return this;
        }

        return writeFieldName(fieldName).writeNumber(value);
    }

    /**
     * Writes a JSON String field.
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeString(String)} to simplify adding a key-value to a
     * JSON object.
     * <p>
     * The field is only written when {@code value} isn't null, if a null field needs to be written use
     * {@link #writeNullableField(String, Object, IOExceptionCheckedBiConsumer)}.
     *
     * @param fieldName The field name.
     * @param value String value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either the {@code fieldName} or String {@code value} fails to be written.
     */
    public JsonWriter writeStringField(String fieldName, String value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        if (value == null) {
            return this;
        }

        return writeFieldName(fieldName).writeString(value);
    }

    /**
     * Writes the passed field literally without any additional handling.
     * <p>
     * Use this API when writing a String value that is already properly formatted JSON, such as a JSON string
     * ({@code "\"string\""}), number ({@code "42"}, {@code "42.0"}), boolean ({@code "true"}, {@code "false"}), null
     * ({@code "null"}), array ({@code "[\"string\", \"array\"]"}), or object ({@code {"\"field\":\"value\""}}).
     * <p>
     * Combines {@link #writeFieldName(String)} and {@link #writeRawValue(String)} to simplify adding a key-value to a
     * JSON object.
     *
     * @param fieldName The field name.
     * @param value The raw JSON value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} or {@code value} is null.
     * @throws IOException If either the {@code fieldName} or raw {@code value} fails to be written.
     */
    public JsonWriter writeRawField(String fieldName, String value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");
        Objects.requireNonNull(value, "'value' cannot be null.");

        return writeFieldName(fieldName).writeRawValue(value);
    }

    /**
     * Writes the unknown type {@code value} field.
     * <p>
     * The following is how each {@code value} is handled (in this order):
     *
     * <ul>
     *     <li>null -&gt; {@link #writeNull()}</li>
     *     <li>{@code short} -&gt; {@link #writeInt(int)}</li>
     *     <li>{@code int} -&gt; {@link #writeInt(int)}</li>
     *     <li>{@code long} -&gt; {@link #writeLong(long)}</li>
     *     <li>{@code float} -&gt; {@link #writeFloat(float)}</li>
     *     <li>{@code double} -&gt; {@link #writeDouble(double)}</li>
     *     <li>{@code boolean} -&gt; {@link #writeBoolean(boolean)}</li>
     *     <li>{@link CharSequence} -&gt; {@link #writeString(String)}</li>
     *     <li>{@code char} -&gt; {@link #writeString(String)}</li>
     *     <li>{@link JsonSerializable} -&gt; {@link #writeJson(JsonSerializable)}</li>
     *     <li>{@code Object[]} -&gt; {@link #writeUntyped(Object)} for each element</li>
     *     <li>{@link Iterable} -&gt; {@link #writeUntyped(Object)} for each element</li>
     *     <li>{@link Map} -&gt; {@link #writeUntyped(Object)} for each element where the key to {@code toString}'d</li>
     *     <li>{@link Object} -&gt; empty JSON object ({@code {}})</li>
     *     <li>All other values use the {@code toString} value with {@link #writeString(String)}</li>
     * </ul>
     *
     * @param fieldName The field name.
     * @param value The value to write.
     * @return The updated JsonWriter object.
     * @throws NullPointerException If {@code fieldName} is null.
     * @throws IOException If either {@code fieldName} or the untyped {@code value} fails to be written.
     */
    public JsonWriter writeUntypedField(String fieldName, Object value) throws IOException {
        Objects.requireNonNull(fieldName, "'fieldName' cannot be null.");

        return writeFieldName(fieldName).writeUntyped(value);
    }

    /**
     * Writes the unknown type {@code value}.
     * <p>
     * The following is how each {@code value} is handled (in this order):
     *
     * <ul>
     *     <li>null -&gt; {@link #writeNull()}</li>
     *     <li>{@code short} -&gt; {@link #writeInt(int)}</li>
     *     <li>{@code int} -&gt; {@link #writeInt(int)}</li>
     *     <li>{@code long} -&gt; {@link #writeLong(long)}</li>
     *     <li>{@code float} -&gt; {@link #writeFloat(float)}</li>
     *     <li>{@code double} -&gt; {@link #writeDouble(double)}</li>
     *     <li>{@code boolean} -&gt; {@link #writeBoolean(boolean)}</li>
     *     <li>{@link CharSequence} -&gt; {@link #writeString(String)}</li>
     *     <li>{@code char} -&gt; {@link #writeString(String)}</li>
     *     <li>{@link JsonSerializable} -&gt; {@link #writeJson(JsonSerializable)}</li>
     *     <li>{@code Object[]} -&gt; {@link #writeUntyped(Object)} for each element</li>
     *     <li>{@link Iterable} -&gt; {@link #writeUntyped(Object)} for each element</li>
     *     <li>{@link Map} -&gt; {@link #writeUntyped(Object)} for each element where the key to {@code toString}'d</li>
     *     <li>{@link Object} -&gt; empty JSON object ({@code {}})</li>
     *     <li>All other values use the {@code toString} value with {@link #writeString(String)}</li>
     * </ul>
     *
     * @param value The value to write.
     * @return The updated JsonWriter object.
     * @throws IOException If the untyped {@code value} fails to be written.
     */
    public JsonWriter writeUntyped(Object value) throws IOException {
        if (value == null) {
            return writeNull();
        } else if (value instanceof Short) {
            return writeInt((short) value);
        } else if (value instanceof Integer) {
            return writeInt((int) value);
        } else if (value instanceof Long) {
            return writeLong((long) value);
        } else if (value instanceof Float) {
            return writeFloat((float) value);
        } else if (value instanceof Double) {
            return writeDouble((double) value);
        } else if (value instanceof Boolean) {
            return writeBoolean((boolean) value);
        } else if (value instanceof byte[]) {
            return writeBinary((byte[]) value);
        } else if (value instanceof CharSequence) {
            return writeString(String.valueOf(value));
        } else if (value instanceof Character) {
            return writeString(String.valueOf(((Character) value).charValue()));
        } else if (value instanceof JsonSerializable<?>) {
            return ((JsonSerializable<?>) value).toJson(this);
        } else if (value instanceof BinaryData) {
            ((BinaryData) value).writeTo(this);
            return this;
        } else if (value instanceof Object[]) {
            writeStartArray();
            for (Object element : (Object[]) value) {
                writeUntyped(element);
            }
            return writeEndArray();
        } else if (value instanceof Iterable<?>) {
            writeStartArray();
            for (Object element : (Iterable<?>) value) {
                writeUntyped(element);
            }
            return writeEndArray();
        } else if (value instanceof Map<?, ?>) {
            Map<?, ?> mapValue = (Map<?, ?>) value;

            writeStartObject();
            for (Map.Entry<?, ?> entry : mapValue.entrySet()) {
                writeFieldName(String.valueOf(entry.getKey())).writeUntyped(entry.getValue());
            }
            return writeEndObject();
        } else if (value.getClass() == Object.class) {
            return writeStartObject().writeEndObject();
        } else {
            return writeString(String.valueOf(value));
        }
    }
}
