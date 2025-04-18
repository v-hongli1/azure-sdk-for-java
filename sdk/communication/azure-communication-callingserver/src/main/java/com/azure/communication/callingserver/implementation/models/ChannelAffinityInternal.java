// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.communication.callingserver.implementation.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonSerializable;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;

import java.io.IOException;

/** Channel affinity for a participant. */
@Fluent
public final class ChannelAffinityInternal implements JsonSerializable<ChannelAffinityInternal> {
    /*
     * Channel number to which bitstream from a particular participant will be
     * written.
     */
    private Integer channel;

    /*
     * The identifier for the participant whose bitstream will be written to
     * the channel
     * represented by the channel number.
     */
    private CommunicationIdentifierModel participant;

    /**
     * Get the channel property: Channel number to which bitstream from a particular participant will be written.
     *
     * @return the channel value.
     */
    public Integer getChannel() {
        return this.channel;
    }

    /**
     * Set the channel property: Channel number to which bitstream from a particular participant will be written.
     *
     * @param channel the channel value to set.
     * @return the ChannelAffinityInternal object itself.
     */
    public ChannelAffinityInternal setChannel(Integer channel) {
        this.channel = channel;
        return this;
    }

    /**
     * Get the participant property: The identifier for the participant whose bitstream will be written to the channel
     * represented by the channel number.
     *
     * @return the participant value.
     */
    public CommunicationIdentifierModel getParticipant() {
        return this.participant;
    }

    /**
     * Set the participant property: The identifier for the participant whose bitstream will be written to the channel
     * represented by the channel number.
     *
     * @param participant the participant value to set.
     * @return the ChannelAffinityInternal object itself.
     */
    public ChannelAffinityInternal setParticipant(CommunicationIdentifierModel participant) {
        this.participant = participant;
        return this;
    }

    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        return jsonWriter.writeStartObject()
            .writeNumberField("channel", channel)
            .writeJsonField("participant", participant)
            .writeEndObject();
    }

    /**
     * Reads an instance of {@link ChannelAffinityInternal} from the {@link JsonReader}.
     *
     * @param jsonReader The {@link JsonReader} to read.
     * @return An instance of {@link ChannelAffinityInternal}, or null if the {@link JsonReader} was pointing to
     * {@link JsonToken#NULL}.
     * @throws IOException If an error occurs while reading the {@link JsonReader}.
     */
    public static ChannelAffinityInternal fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            ChannelAffinityInternal channelAffinity = new ChannelAffinityInternal();

            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("channel".equals(fieldName)) {
                    channelAffinity.channel = reader.getNullable(JsonReader::getInt);
                } else if ("participant".equals(fieldName)) {
                    channelAffinity.participant = CommunicationIdentifierModel.fromJson(reader);
                } else {
                    reader.skipChildren();
                }
            }

            return channelAffinity;
        });
    }
}
