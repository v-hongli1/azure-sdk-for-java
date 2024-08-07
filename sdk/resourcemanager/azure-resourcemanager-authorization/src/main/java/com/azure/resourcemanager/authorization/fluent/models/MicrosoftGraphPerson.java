// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.authorization.fluent.models;

import com.azure.core.annotation.Fluent;
import com.azure.json.JsonReader;
import com.azure.json.JsonToken;
import com.azure.json.JsonWriter;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * person.
 */
@Fluent
public final class MicrosoftGraphPerson extends MicrosoftGraphEntity {
    /*
     * The person's birthday.
     */
    private String birthday;

    /*
     * The name of the person's company.
     */
    private String companyName;

    /*
     * The person's department.
     */
    private String department;

    /*
     * The person's display name.
     */
    private String displayName;

    /*
     * The person's given name.
     */
    private String givenName;

    /*
     * The instant message voice over IP (VOIP) session initiation protocol (SIP) address for the user. Read-only.
     */
    private String imAddress;

    /*
     * true if the user has flagged this person as a favorite.
     */
    private Boolean isFavorite;

    /*
     * The person's job title.
     */
    private String jobTitle;

    /*
     * The location of the person's office.
     */
    private String officeLocation;

    /*
     * Free-form notes that the user has taken about this person.
     */
    private String personNotes;

    /*
     * personType
     */
    private MicrosoftGraphPersonType personType;

    /*
     * The person's phone numbers.
     */
    private List<MicrosoftGraphPhone> phones;

    /*
     * The person's addresses.
     */
    private List<MicrosoftGraphLocation> postalAddresses;

    /*
     * The person's profession.
     */
    private String profession;

    /*
     * The person's email addresses.
     */
    private List<MicrosoftGraphScoredEmailAddress> scoredEmailAddresses;

    /*
     * The person's surname.
     */
    private String surname;

    /*
     * The user principal name (UPN) of the person. The UPN is an Internet-style login name for the person based on the
     * Internet standard RFC 822. By convention, this should map to the person's email name. The general format is
     * alias@domain.
     */
    private String userPrincipalName;

    /*
     * The person's websites.
     */
    private List<MicrosoftGraphWebsite> websites;

    /*
     * The phonetic Japanese name of the person's company.
     */
    private String yomiCompany;

    /*
     * person
     */
    private Map<String, Object> additionalProperties;

    /**
     * Creates an instance of MicrosoftGraphPerson class.
     */
    public MicrosoftGraphPerson() {
    }

    /**
     * Get the birthday property: The person's birthday.
     * 
     * @return the birthday value.
     */
    public String birthday() {
        return this.birthday;
    }

    /**
     * Set the birthday property: The person's birthday.
     * 
     * @param birthday the birthday value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withBirthday(String birthday) {
        this.birthday = birthday;
        return this;
    }

    /**
     * Get the companyName property: The name of the person's company.
     * 
     * @return the companyName value.
     */
    public String companyName() {
        return this.companyName;
    }

    /**
     * Set the companyName property: The name of the person's company.
     * 
     * @param companyName the companyName value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    /**
     * Get the department property: The person's department.
     * 
     * @return the department value.
     */
    public String department() {
        return this.department;
    }

    /**
     * Set the department property: The person's department.
     * 
     * @param department the department value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withDepartment(String department) {
        this.department = department;
        return this;
    }

    /**
     * Get the displayName property: The person's display name.
     * 
     * @return the displayName value.
     */
    public String displayName() {
        return this.displayName;
    }

    /**
     * Set the displayName property: The person's display name.
     * 
     * @param displayName the displayName value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withDisplayName(String displayName) {
        this.displayName = displayName;
        return this;
    }

    /**
     * Get the givenName property: The person's given name.
     * 
     * @return the givenName value.
     */
    public String givenName() {
        return this.givenName;
    }

    /**
     * Set the givenName property: The person's given name.
     * 
     * @param givenName the givenName value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withGivenName(String givenName) {
        this.givenName = givenName;
        return this;
    }

    /**
     * Get the imAddress property: The instant message voice over IP (VOIP) session initiation protocol (SIP) address
     * for the user. Read-only.
     * 
     * @return the imAddress value.
     */
    public String imAddress() {
        return this.imAddress;
    }

    /**
     * Set the imAddress property: The instant message voice over IP (VOIP) session initiation protocol (SIP) address
     * for the user. Read-only.
     * 
     * @param imAddress the imAddress value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withImAddress(String imAddress) {
        this.imAddress = imAddress;
        return this;
    }

    /**
     * Get the isFavorite property: true if the user has flagged this person as a favorite.
     * 
     * @return the isFavorite value.
     */
    public Boolean isFavorite() {
        return this.isFavorite;
    }

    /**
     * Set the isFavorite property: true if the user has flagged this person as a favorite.
     * 
     * @param isFavorite the isFavorite value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withIsFavorite(Boolean isFavorite) {
        this.isFavorite = isFavorite;
        return this;
    }

    /**
     * Get the jobTitle property: The person's job title.
     * 
     * @return the jobTitle value.
     */
    public String jobTitle() {
        return this.jobTitle;
    }

    /**
     * Set the jobTitle property: The person's job title.
     * 
     * @param jobTitle the jobTitle value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
        return this;
    }

    /**
     * Get the officeLocation property: The location of the person's office.
     * 
     * @return the officeLocation value.
     */
    public String officeLocation() {
        return this.officeLocation;
    }

    /**
     * Set the officeLocation property: The location of the person's office.
     * 
     * @param officeLocation the officeLocation value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withOfficeLocation(String officeLocation) {
        this.officeLocation = officeLocation;
        return this;
    }

    /**
     * Get the personNotes property: Free-form notes that the user has taken about this person.
     * 
     * @return the personNotes value.
     */
    public String personNotes() {
        return this.personNotes;
    }

    /**
     * Set the personNotes property: Free-form notes that the user has taken about this person.
     * 
     * @param personNotes the personNotes value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withPersonNotes(String personNotes) {
        this.personNotes = personNotes;
        return this;
    }

    /**
     * Get the personType property: personType.
     * 
     * @return the personType value.
     */
    public MicrosoftGraphPersonType personType() {
        return this.personType;
    }

    /**
     * Set the personType property: personType.
     * 
     * @param personType the personType value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withPersonType(MicrosoftGraphPersonType personType) {
        this.personType = personType;
        return this;
    }

    /**
     * Get the phones property: The person's phone numbers.
     * 
     * @return the phones value.
     */
    public List<MicrosoftGraphPhone> phones() {
        return this.phones;
    }

    /**
     * Set the phones property: The person's phone numbers.
     * 
     * @param phones the phones value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withPhones(List<MicrosoftGraphPhone> phones) {
        this.phones = phones;
        return this;
    }

    /**
     * Get the postalAddresses property: The person's addresses.
     * 
     * @return the postalAddresses value.
     */
    public List<MicrosoftGraphLocation> postalAddresses() {
        return this.postalAddresses;
    }

    /**
     * Set the postalAddresses property: The person's addresses.
     * 
     * @param postalAddresses the postalAddresses value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withPostalAddresses(List<MicrosoftGraphLocation> postalAddresses) {
        this.postalAddresses = postalAddresses;
        return this;
    }

    /**
     * Get the profession property: The person's profession.
     * 
     * @return the profession value.
     */
    public String profession() {
        return this.profession;
    }

    /**
     * Set the profession property: The person's profession.
     * 
     * @param profession the profession value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withProfession(String profession) {
        this.profession = profession;
        return this;
    }

    /**
     * Get the scoredEmailAddresses property: The person's email addresses.
     * 
     * @return the scoredEmailAddresses value.
     */
    public List<MicrosoftGraphScoredEmailAddress> scoredEmailAddresses() {
        return this.scoredEmailAddresses;
    }

    /**
     * Set the scoredEmailAddresses property: The person's email addresses.
     * 
     * @param scoredEmailAddresses the scoredEmailAddresses value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withScoredEmailAddresses(List<MicrosoftGraphScoredEmailAddress> scoredEmailAddresses) {
        this.scoredEmailAddresses = scoredEmailAddresses;
        return this;
    }

    /**
     * Get the surname property: The person's surname.
     * 
     * @return the surname value.
     */
    public String surname() {
        return this.surname;
    }

    /**
     * Set the surname property: The person's surname.
     * 
     * @param surname the surname value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withSurname(String surname) {
        this.surname = surname;
        return this;
    }

    /**
     * Get the userPrincipalName property: The user principal name (UPN) of the person. The UPN is an Internet-style
     * login name for the person based on the Internet standard RFC 822. By convention, this should map to the person's
     * email name. The general format is alias&#064;domain.
     * 
     * @return the userPrincipalName value.
     */
    public String userPrincipalName() {
        return this.userPrincipalName;
    }

    /**
     * Set the userPrincipalName property: The user principal name (UPN) of the person. The UPN is an Internet-style
     * login name for the person based on the Internet standard RFC 822. By convention, this should map to the person's
     * email name. The general format is alias&#064;domain.
     * 
     * @param userPrincipalName the userPrincipalName value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withUserPrincipalName(String userPrincipalName) {
        this.userPrincipalName = userPrincipalName;
        return this;
    }

    /**
     * Get the websites property: The person's websites.
     * 
     * @return the websites value.
     */
    public List<MicrosoftGraphWebsite> websites() {
        return this.websites;
    }

    /**
     * Set the websites property: The person's websites.
     * 
     * @param websites the websites value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withWebsites(List<MicrosoftGraphWebsite> websites) {
        this.websites = websites;
        return this;
    }

    /**
     * Get the yomiCompany property: The phonetic Japanese name of the person's company.
     * 
     * @return the yomiCompany value.
     */
    public String yomiCompany() {
        return this.yomiCompany;
    }

    /**
     * Set the yomiCompany property: The phonetic Japanese name of the person's company.
     * 
     * @param yomiCompany the yomiCompany value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withYomiCompany(String yomiCompany) {
        this.yomiCompany = yomiCompany;
        return this;
    }

    /**
     * Get the additionalProperties property: person.
     * 
     * @return the additionalProperties value.
     */
    public Map<String, Object> additionalProperties() {
        return this.additionalProperties;
    }

    /**
     * Set the additionalProperties property: person.
     * 
     * @param additionalProperties the additionalProperties value to set.
     * @return the MicrosoftGraphPerson object itself.
     */
    public MicrosoftGraphPerson withAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
        return this;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MicrosoftGraphPerson withId(String id) {
        super.withId(id);
        return this;
    }

    /**
     * Validates the instance.
     * 
     * @throws IllegalArgumentException thrown if the instance is not valid.
     */
    @Override
    public void validate() {
        super.validate();
        if (personType() != null) {
            personType().validate();
        }
        if (phones() != null) {
            phones().forEach(e -> e.validate());
        }
        if (postalAddresses() != null) {
            postalAddresses().forEach(e -> e.validate());
        }
        if (scoredEmailAddresses() != null) {
            scoredEmailAddresses().forEach(e -> e.validate());
        }
        if (websites() != null) {
            websites().forEach(e -> e.validate());
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JsonWriter toJson(JsonWriter jsonWriter) throws IOException {
        jsonWriter.writeStartObject();
        jsonWriter.writeStringField("id", id());
        jsonWriter.writeStringField("birthday", this.birthday);
        jsonWriter.writeStringField("companyName", this.companyName);
        jsonWriter.writeStringField("department", this.department);
        jsonWriter.writeStringField("displayName", this.displayName);
        jsonWriter.writeStringField("givenName", this.givenName);
        jsonWriter.writeStringField("imAddress", this.imAddress);
        jsonWriter.writeBooleanField("isFavorite", this.isFavorite);
        jsonWriter.writeStringField("jobTitle", this.jobTitle);
        jsonWriter.writeStringField("officeLocation", this.officeLocation);
        jsonWriter.writeStringField("personNotes", this.personNotes);
        jsonWriter.writeJsonField("personType", this.personType);
        jsonWriter.writeArrayField("phones", this.phones, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeArrayField("postalAddresses", this.postalAddresses,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("profession", this.profession);
        jsonWriter.writeArrayField("scoredEmailAddresses", this.scoredEmailAddresses,
            (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("surname", this.surname);
        jsonWriter.writeStringField("userPrincipalName", this.userPrincipalName);
        jsonWriter.writeArrayField("websites", this.websites, (writer, element) -> writer.writeJson(element));
        jsonWriter.writeStringField("yomiCompany", this.yomiCompany);
        if (additionalProperties != null) {
            for (Map.Entry<String, Object> additionalProperty : additionalProperties.entrySet()) {
                jsonWriter.writeUntypedField(additionalProperty.getKey(), additionalProperty.getValue());
            }
        }
        return jsonWriter.writeEndObject();
    }

    /**
     * Reads an instance of MicrosoftGraphPerson from the JsonReader.
     * 
     * @param jsonReader The JsonReader being read.
     * @return An instance of MicrosoftGraphPerson if the JsonReader was pointing to an instance of it, or null if it
     * was pointing to JSON null.
     * @throws IOException If an error occurs while reading the MicrosoftGraphPerson.
     */
    public static MicrosoftGraphPerson fromJson(JsonReader jsonReader) throws IOException {
        return jsonReader.readObject(reader -> {
            MicrosoftGraphPerson deserializedMicrosoftGraphPerson = new MicrosoftGraphPerson();
            Map<String, Object> additionalProperties = null;
            while (reader.nextToken() != JsonToken.END_OBJECT) {
                String fieldName = reader.getFieldName();
                reader.nextToken();

                if ("id".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.withId(reader.getString());
                } else if ("birthday".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.birthday = reader.getString();
                } else if ("companyName".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.companyName = reader.getString();
                } else if ("department".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.department = reader.getString();
                } else if ("displayName".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.displayName = reader.getString();
                } else if ("givenName".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.givenName = reader.getString();
                } else if ("imAddress".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.imAddress = reader.getString();
                } else if ("isFavorite".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.isFavorite = reader.getNullable(JsonReader::getBoolean);
                } else if ("jobTitle".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.jobTitle = reader.getString();
                } else if ("officeLocation".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.officeLocation = reader.getString();
                } else if ("personNotes".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.personNotes = reader.getString();
                } else if ("personType".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.personType = MicrosoftGraphPersonType.fromJson(reader);
                } else if ("phones".equals(fieldName)) {
                    List<MicrosoftGraphPhone> phones
                        = reader.readArray(reader1 -> MicrosoftGraphPhone.fromJson(reader1));
                    deserializedMicrosoftGraphPerson.phones = phones;
                } else if ("postalAddresses".equals(fieldName)) {
                    List<MicrosoftGraphLocation> postalAddresses
                        = reader.readArray(reader1 -> MicrosoftGraphLocation.fromJson(reader1));
                    deserializedMicrosoftGraphPerson.postalAddresses = postalAddresses;
                } else if ("profession".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.profession = reader.getString();
                } else if ("scoredEmailAddresses".equals(fieldName)) {
                    List<MicrosoftGraphScoredEmailAddress> scoredEmailAddresses
                        = reader.readArray(reader1 -> MicrosoftGraphScoredEmailAddress.fromJson(reader1));
                    deserializedMicrosoftGraphPerson.scoredEmailAddresses = scoredEmailAddresses;
                } else if ("surname".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.surname = reader.getString();
                } else if ("userPrincipalName".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.userPrincipalName = reader.getString();
                } else if ("websites".equals(fieldName)) {
                    List<MicrosoftGraphWebsite> websites
                        = reader.readArray(reader1 -> MicrosoftGraphWebsite.fromJson(reader1));
                    deserializedMicrosoftGraphPerson.websites = websites;
                } else if ("yomiCompany".equals(fieldName)) {
                    deserializedMicrosoftGraphPerson.yomiCompany = reader.getString();
                } else {
                    if (additionalProperties == null) {
                        additionalProperties = new LinkedHashMap<>();
                    }

                    additionalProperties.put(fieldName, reader.readUntyped());
                }
            }
            deserializedMicrosoftGraphPerson.additionalProperties = additionalProperties;

            return deserializedMicrosoftGraphPerson;
        });
    }
}
