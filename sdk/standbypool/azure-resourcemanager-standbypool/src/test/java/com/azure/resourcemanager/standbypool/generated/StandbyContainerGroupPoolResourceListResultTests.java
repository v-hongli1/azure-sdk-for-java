// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) TypeSpec Code Generator.

package com.azure.resourcemanager.standbypool.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.standbypool.implementation.models.StandbyContainerGroupPoolResourceListResult;
import com.azure.resourcemanager.standbypool.models.RefillPolicy;
import org.junit.jupiter.api.Assertions;

public final class StandbyContainerGroupPoolResourceListResultTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        StandbyContainerGroupPoolResourceListResult model = BinaryData.fromString(
            "{\"value\":[{\"properties\":{\"elasticityProfile\":{\"maxReadyCapacity\":7557755322277139478,\"refillPolicy\":\"always\"},\"containerGroupProperties\":{\"containerGroupProfile\":{\"id\":\"l\",\"revision\":620396584491866948},\"subnetIds\":[{\"id\":\"rlkhbzhfepgzgq\"},{\"id\":\"xzlocxscp\"},{\"id\":\"ierhhbcsglummaj\"}]},\"zones\":[\"odxobnbdxkqpxok\",\"jionpimexgstxgc\"],\"provisioningState\":\"Succeeded\"},\"location\":\"maajrmvdjwzrlo\",\"tags\":{\"qsycbkbfkgu\":\"lwhijcoejctbzaq\",\"axcfjpgddtocjjx\":\"dkexxppofm\",\"eojnxqbzvddn\":\"vpmouexhdzxib\",\"aoqvuh\":\"wndeicbtwnp\"},\"id\":\"hcffcyddglmjthjq\",\"name\":\"wpyeicxmqciwqvh\",\"type\":\"hix\"},{\"properties\":{\"elasticityProfile\":{\"maxReadyCapacity\":4083184887004469884,\"refillPolicy\":\"always\"},\"containerGroupProperties\":{\"containerGroupProfile\":{\"id\":\"pbobjo\",\"revision\":44240254811320065},\"subnetIds\":[{\"id\":\"a\"}]},\"zones\":[\"hrzayvvtpgvdf\",\"iotkftutqxl\",\"gxlefgugnxkrxd\"],\"provisioningState\":\"Succeeded\"},\"location\":\"tthzrvqd\",\"tags\":{\"skanyk\":\"hjybigehoqfbo\"},\"id\":\"zlcuiywgqywgndrv\",\"name\":\"nhzgpphrcgyn\",\"type\":\"ocpecfvmmco\"},{\"properties\":{\"elasticityProfile\":{\"maxReadyCapacity\":3154425840860812324,\"refillPolicy\":\"always\"},\"containerGroupProperties\":{\"containerGroupProfile\":{\"id\":\"evgbmqjq\",\"revision\":403687781519599145},\"subnetIds\":[{\"id\":\"ivkwlzuvccfwnfnb\"},{\"id\":\"cfionl\"},{\"id\":\"bxetqgtzxdpn\"}]},\"zones\":[\"qwxrjfeallnw\"],\"provisioningState\":\"Failed\"},\"location\":\"snjampmng\",\"tags\":{\"aqw\":\"c\",\"xnj\":\"ochcbonqvpkvl\"},\"id\":\"ase\",\"name\":\"pheoflokeyy\",\"type\":\"enjbdlwtgrhp\"},{\"properties\":{\"elasticityProfile\":{\"maxReadyCapacity\":2017008461416192410,\"refillPolicy\":\"always\"},\"containerGroupProperties\":{\"containerGroupProfile\":{\"id\":\"asxazjpqyegualhb\",\"revision\":4998269354671391171},\"subnetIds\":[{\"id\":\"zzvdudgwds\"},{\"id\":\"fhotw\"}]},\"zones\":[\"npwlbjnpg\",\"cftadeh\"],\"provisioningState\":\"Failed\"},\"location\":\"yfsoppu\",\"tags\":{\"jbavorxzdm\":\"snzwd\",\"nvowgujju\":\"hctbqvudwxdn\"},\"id\":\"wdkcglhsl\",\"name\":\"zj\",\"type\":\"yggdtjixh\"}],\"nextLink\":\"uofqwe\"}")
            .toObject(StandbyContainerGroupPoolResourceListResult.class);
        Assertions.assertEquals("maajrmvdjwzrlo", model.value().get(0).location());
        Assertions.assertEquals("lwhijcoejctbzaq", model.value().get(0).tags().get("qsycbkbfkgu"));
        Assertions.assertEquals(7557755322277139478L,
            model.value().get(0).properties().elasticityProfile().maxReadyCapacity());
        Assertions.assertEquals(RefillPolicy.ALWAYS,
            model.value().get(0).properties().elasticityProfile().refillPolicy());
        Assertions.assertEquals("l",
            model.value().get(0).properties().containerGroupProperties().containerGroupProfile().id());
        Assertions.assertEquals(620396584491866948L,
            model.value().get(0).properties().containerGroupProperties().containerGroupProfile().revision());
        Assertions.assertEquals("rlkhbzhfepgzgq",
            model.value().get(0).properties().containerGroupProperties().subnetIds().get(0).id());
        Assertions.assertEquals("odxobnbdxkqpxok", model.value().get(0).properties().zones().get(0));
        Assertions.assertEquals("uofqwe", model.nextLink());
    }
}
