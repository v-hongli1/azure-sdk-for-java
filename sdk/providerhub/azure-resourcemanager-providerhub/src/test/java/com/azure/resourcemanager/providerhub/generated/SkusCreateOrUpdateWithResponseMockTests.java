// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.providerhub.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.providerhub.ProviderHubManager;
import com.azure.resourcemanager.providerhub.models.ProvisioningState;
import com.azure.resourcemanager.providerhub.models.SkuCapability;
import com.azure.resourcemanager.providerhub.models.SkuCost;
import com.azure.resourcemanager.providerhub.models.SkuLocationInfo;
import com.azure.resourcemanager.providerhub.models.SkuResource;
import com.azure.resourcemanager.providerhub.models.SkuResourceProperties;
import com.azure.resourcemanager.providerhub.models.SkuScaleType;
import com.azure.resourcemanager.providerhub.models.SkuSetting;
import com.azure.resourcemanager.providerhub.models.SkuSettingCapacity;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class SkusCreateOrUpdateWithResponseMockTests {
    @Test
    public void testCreateOrUpdateWithResponse() throws Exception {
        String responseStr
            = "{\"properties\":{\"skuSettings\":[{\"name\":\"utpum\",\"tier\":\"wjfl\",\"size\":\"ynbpvzlqywauy\",\"family\":\"jckhmocgj\",\"kind\":\"gouarhwvixqq\",\"locations\":[\"jkyb\"],\"locationInfo\":[{\"location\":\"clrvtzqnrbctbh\"}],\"requiredQuotaIds\":[\"xpc\",\"rdnyeita\",\"eq\",\"dynzjahwr\"],\"requiredFeatures\":[\"mzczfkicee\",\"saaxwspca\",\"ikhfjqebglcxk\",\"gzzromv\"],\"capacity\":{\"minimum\":1816993869,\"maximum\":990994976,\"default\":667896708,\"scaleType\":\"Manual\"},\"costs\":[{\"meterId\":\"fsvpink\"}],\"capabilities\":[{\"name\":\"tqtdis\",\"value\":\"xspvckojazb\"},{\"name\":\"gspftesu\",\"value\":\"zpvpvdyly\"},{\"name\":\"covqseusrfjbdxzf\",\"value\":\"nxmlbmuoswk\"},{\"name\":\"mdihdcy\",\"value\":\"yzlwhbwzjnufzrf\"}]},{\"name\":\"m\",\"tier\":\"gnnbzrtf\",\"size\":\"dzuubjtvgjsxm\",\"family\":\"jjvavdpww\",\"kind\":\"tdp\",\"locations\":[\"tsffo\"],\"locationInfo\":[{\"location\":\"nmhkscauwaz\"},{\"location\":\"gwd\"},{\"location\":\"riwgybjp\"},{\"location\":\"zokscvg\"}],\"requiredQuotaIds\":[\"x\",\"gbyfgwe\",\"qkjvxprwpxsoohu\",\"xlcskltez\"],\"requiredFeatures\":[\"ggzlf\"],\"capacity\":{\"minimum\":1280061028,\"maximum\":1441272490,\"default\":2110152605,\"scaleType\":\"Automatic\"},\"costs\":[{\"meterId\":\"mdylperp\"},{\"meterId\":\"lttjzgcz\"},{\"meterId\":\"cmfpfbodet\"}],\"capabilities\":[{\"name\":\"rgvtsh\",\"value\":\"vftwaiv\"}]}],\"provisioningState\":\"Canceled\"},\"id\":\"kevz\",\"name\":\"jypanhxmpdxxzet\",\"type\":\"wzjwotnxlkfhg\"}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        ProviderHubManager manager = ProviderHubManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        SkuResource response
            = manager.skus()
                .define("xmolpcqydeyk")
                .withExistingResourcetypeRegistration("yrgkoekv", "wxxyxhighctx")
                .withProperties(
                    new SkuResourceProperties()
                        .withSkuSettings(
                            Arrays
                                .asList(
                                    new SkuSetting().withName("ic")
                                        .withTier("frjeizikgqaboohx")
                                        .withSize("sgyc")
                                        .withFamily("xrmdvewuyqaeohpj")
                                        .withKind("ejkbvhhdaurgho")
                                        .withLocations(Arrays.asList("exbkhx", "xjoezlqxrkdknko", "ektm"))
                                        .withLocationInfo(
                                            Arrays.asList(new SkuLocationInfo().withLocation("omtzamicb")))
                                        .withRequiredQuotaIds(Arrays.asList("cdgzseznux", "euairaabmdlqjb"))
                                        .withRequiredFeatures(Arrays.asList("f", "xlhupmomihzbdnp", "pkcdpreyxely"))
                                        .withCapacity(new SkuSettingCapacity().withMinimum(1691730280)
                                            .withMaximum(560856986)
                                            .withDefaultProperty(1940675746)
                                            .withScaleType(SkuScaleType.AUTOMATIC))
                                        .withCosts(Arrays.asList(
                                            new SkuCost().withMeterId("jyg"),
                                            new SkuCost().withMeterId("sfxrkbhammgm")))
                                        .withCapabilities(Arrays.asList(
                                            new SkuCapability().withName("efgvqcp").withValue("wjgquxweyslandkd"),
                                            new SkuCapability().withName("djhunhghcgawnr").withValue("nquoxsotireimse"),
                                            new SkuCapability().withName("bfsx").withValue("tcyilbvz"),
                                            new SkuCapability().withName("mxcjzlquzexokjx").withValue("bjvbzinzab"))),
                                    new SkuSetting().withName("mvoglj")
                                        .withTier("lpgidn")
                                        .withSize("ehaqidoyzltgio")
                                        .withFamily("oqpe")
                                        .withKind("aeapfsergd")
                                        .withLocations(Arrays.asList("qnacyheq"))
                                        .withLocationInfo(Arrays.asList(new SkuLocationInfo().withLocation("qq"),
                                            new SkuLocationInfo().withLocation("cjubkhjozfymcwm")))
                                        .withRequiredQuotaIds(Arrays.asList("yvqyvliqiips", "jbsv"))
                                        .withRequiredFeatures(Arrays.asList("ieswhddzydisn", "epywyjlnldpxottd", "i"))
                                        .withCapacity(new SkuSettingCapacity().withMinimum(1476716256)
                                            .withMaximum(635013372)
                                            .withDefaultProperty(1061804775)
                                            .withScaleType(SkuScaleType.MANUAL))
                                        .withCosts(Arrays.asList(new SkuCost().withMeterId("ee"),
                                            new SkuCost().withMeterId("iphryvcjwqwo"),
                                            new SkuCost().withMeterId("sratjhdhzyb")))
                                        .withCapabilities(Arrays.asList(
                                            new SkuCapability().withName("jhfrzgdkkagv").withValue("ukhsusmmorf")))))
                        .withProvisioningState(ProvisioningState.ROLLOUT_IN_PROGRESS))
                .create();

        Assertions.assertEquals("utpum", response.properties().skuSettings().get(0).name());
        Assertions.assertEquals("wjfl", response.properties().skuSettings().get(0).tier());
        Assertions.assertEquals("ynbpvzlqywauy", response.properties().skuSettings().get(0).size());
        Assertions.assertEquals("jckhmocgj", response.properties().skuSettings().get(0).family());
        Assertions.assertEquals("gouarhwvixqq", response.properties().skuSettings().get(0).kind());
        Assertions.assertEquals("jkyb", response.properties().skuSettings().get(0).locations().get(0));
        Assertions.assertEquals("clrvtzqnrbctbh",
            response.properties().skuSettings().get(0).locationInfo().get(0).location());
        Assertions.assertEquals("xpc", response.properties().skuSettings().get(0).requiredQuotaIds().get(0));
        Assertions.assertEquals("mzczfkicee", response.properties().skuSettings().get(0).requiredFeatures().get(0));
        Assertions.assertEquals(1816993869, response.properties().skuSettings().get(0).capacity().minimum());
        Assertions.assertEquals(990994976, response.properties().skuSettings().get(0).capacity().maximum());
        Assertions.assertEquals(667896708, response.properties().skuSettings().get(0).capacity().defaultProperty());
        Assertions.assertEquals(SkuScaleType.MANUAL, response.properties().skuSettings().get(0).capacity().scaleType());
        Assertions.assertEquals("fsvpink", response.properties().skuSettings().get(0).costs().get(0).meterId());
        Assertions.assertEquals("tqtdis", response.properties().skuSettings().get(0).capabilities().get(0).name());
        Assertions.assertEquals("xspvckojazb",
            response.properties().skuSettings().get(0).capabilities().get(0).value());
        Assertions.assertEquals(ProvisioningState.CANCELED, response.properties().provisioningState());
    }
}
