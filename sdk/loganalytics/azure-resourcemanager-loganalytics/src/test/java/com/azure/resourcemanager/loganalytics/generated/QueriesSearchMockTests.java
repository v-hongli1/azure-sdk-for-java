// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.loganalytics.generated;

import com.azure.core.credential.AccessToken;
import com.azure.core.http.HttpClient;
import com.azure.core.http.rest.PagedIterable;
import com.azure.core.management.AzureEnvironment;
import com.azure.core.management.profile.AzureProfile;
import com.azure.core.test.http.MockHttpResponse;
import com.azure.resourcemanager.loganalytics.LogAnalyticsManager;
import com.azure.resourcemanager.loganalytics.models.LogAnalyticsQueryPackQuery;
import com.azure.resourcemanager.loganalytics.models.LogAnalyticsQueryPackQuerySearchProperties;
import com.azure.resourcemanager.loganalytics.models.LogAnalyticsQueryPackQuerySearchPropertiesRelated;
import java.nio.charset.StandardCharsets;
import java.time.OffsetDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;

public final class QueriesSearchMockTests {
    @Test
    public void testSearch() throws Exception {
        String responseStr
            = "{\"value\":[{\"properties\":{\"id\":\"heioqa\",\"displayName\":\"hvseufuqyrx\",\"timeCreated\":\"2021-03-18T00:27:23Z\",\"timeModified\":\"2020-12-31T00:49:04Z\",\"author\":\"lsismjqfrd\",\"description\":\"amqu\",\"body\":\"iosrsjuivfcdis\",\"related\":{\"categories\":[\"xzhczexrxz\",\"ujrtrhqvwr\"],\"resourceTypes\":[\"h\"],\"solutions\":[\"nzonzl\",\"piqywnc\",\"jtszcof\",\"zehtdhgb\"]},\"tags\":{\"bccxjmonfdgn\":[\"eljeamurvzmlovua\",\"ashcxlpmjerbdk\",\"lvidizozs\"],\"uqj\":[\"cypuuwwlt\"]},\"properties\":\"datazenkeifzzhmkd\"},\"id\":\"vflyhbxcu\",\"name\":\"hxgsrboldfor\",\"type\":\"wjlvizbfhfov\"}]}";

        HttpClient httpClient
            = response -> Mono.just(new MockHttpResponse(response, 200, responseStr.getBytes(StandardCharsets.UTF_8)));
        LogAnalyticsManager manager = LogAnalyticsManager.configure()
            .withHttpClient(httpClient)
            .authenticate(tokenRequestContext -> Mono.just(new AccessToken("this_is_a_token", OffsetDateTime.MAX)),
                new AzureProfile("", "", AzureEnvironment.AZURE));

        PagedIterable<LogAnalyticsQueryPackQuery> response = manager.queries()
            .search("jzhajoy", "hjlmu",
                new LogAnalyticsQueryPackQuerySearchProperties()
                    .withRelated(new LogAnalyticsQueryPackQuerySearchPropertiesRelated()
                        .withCategories(Arrays.asList("rimrs", "pteecjme"))
                        .withResourceTypes(Arrays.asList("stvasylwxdzaumw"))
                        .withSolutions(Arrays.asList("hguuf", "zboyjathwt")))
                    .withTags(mapOf("mwmdxmebwjscjpa", Arrays.asList("a"), "ekpndzaapmudq",
                        Arrays.asList("xveabf", "xnmwmqtibxyijddt", "qcttadijaeukmrsi"), "e",
                        Arrays.asList("qwigpibudqwyxe"))),
                5927921282145979607L, true, "zznrtffyaqi", com.azure.core.util.Context.NONE);

        Assertions.assertEquals("hvseufuqyrx", response.iterator().next().displayName());
        Assertions.assertEquals("amqu", response.iterator().next().description());
        Assertions.assertEquals("iosrsjuivfcdis", response.iterator().next().body());
        Assertions.assertEquals("xzhczexrxz", response.iterator().next().related().categories().get(0));
        Assertions.assertEquals("h", response.iterator().next().related().resourceTypes().get(0));
        Assertions.assertEquals("nzonzl", response.iterator().next().related().solutions().get(0));
        Assertions.assertEquals("eljeamurvzmlovua", response.iterator().next().tags().get("bccxjmonfdgn").get(0));
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
