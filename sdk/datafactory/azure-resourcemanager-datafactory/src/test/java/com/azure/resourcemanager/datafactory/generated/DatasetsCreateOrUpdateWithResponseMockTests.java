// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.datafactory.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.datafactory.DataFactoryManager;
import com.azure.resourcemanager.datafactory.models.Dataset;
import com.azure.resourcemanager.datafactory.models.DatasetFolder;
import com.azure.resourcemanager.datafactory.models.DatasetResource;
import com.azure.resourcemanager.datafactory.models.LinkedServiceReference;
import com.azure.resourcemanager.datafactory.models.ParameterSpecification;
import com.azure.resourcemanager.datafactory.models.ParameterType;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class DatasetsCreateOrUpdateWithResponseMockTests {
    @Test
    public void testCreateOrUpdateWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"type\":\"Dataset\",\"description\":\"yqgvofhpguj\",\"structure\":\"datakwwyfsq\",\"schema\":\"datass\",\"linkedServiceName\":{\"referenceName\":\"cxazvrmu\",\"parameters\":{\"bruszqmud\":\"dataegohpwnrmhlotk\",\"lowesixpwfvtwgn\":\"dataefsxmd\"}},\"parameters\":{\"hcjhinjnwpi\":{\"type\":\"Bool\",\"defaultValue\":\"dataxwkomjsfkdv\"}},\"annotations\":[\"datalbajqecngw\",\"datazuaxsrmadakj\"],\"folder\":{\"name\":\"uv\"},\"\":{\"hotwq\":\"databkkekldxclqjn\",\"utmsmdibzvytem\":\"datagvrzlimz\",\"kcxuvdcwtnz\":\"datasa\"}},\"name\":\"eghn\",\"type\":\"wjwwhsfjqxlbclvp\",\"etag\":\"utyrsravsscb\",\"id\":\"xmscafgdtuzcl\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        DataFactoryManager manager = DataFactoryManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        DatasetResource response = manager.datasets()
            .define("gdgfjvitdp")
            .withExistingFactory("iv", "ftjjmtk")
            .withProperties(new Dataset().withDescription("oesx")
                .withStructure("datavslhncasp")
                .withSchema("dataglaxvn")
                .withLinkedServiceName(new LinkedServiceReference().withReferenceName("qhatwxq")
                    .withParameters(mapOf("huudtiecnpka", "databirzjhaicyuplm", "osrywpfcqle", "datatjqjtoeaug")))
                .withParameters(mapOf("colwquxrrjud",
                    new ParameterSpecification().withType(ParameterType.BOOL).withDefaultValue("dataizdecgiom"),
                    "twfmvpsvwwtncvn",
                    new ParameterSpecification().withType(ParameterType.FLOAT).withDefaultValue("datahgsd"), "icovvd",
                    new ParameterSpecification().withType(ParameterType.FLOAT).withDefaultValue("datagnl")))
                .withAnnotations(Arrays.asList("datafnbdpaoijx", "datagfmftrv"))
                .withFolder(new DatasetFolder().withName("jfkpuszsjayrl"))
                .withAdditionalProperties(mapOf("type", "Dataset")))
            .withIfMatch("zipzkkleazkc")
            .create();

        Assertions.assertEquals("xmscafgdtuzcl", response.id());
        Assertions.assertEquals("yqgvofhpguj", response.properties().description());
        Assertions.assertEquals("cxazvrmu", response.properties().linkedServiceName().referenceName());
        Assertions.assertEquals(ParameterType.BOOL, response.properties().parameters().get("hcjhinjnwpi").type());
        Assertions.assertEquals("uv", response.properties().folder().name());
    }

    // Use "Map.of" if available
    @SuppressWarnings("unchecked")
    private static <T> Map<String, T> mapOf(Object... inputs) {
        Map<String, T> map = new HashMap<>();
        for (int i = 0; i < inputs.length; i += 2) {
            String key = (String) inputs[i];
            T value = (T) inputs[i + 1];
            map.put(key, value);
        }
        return map;
    }
}
