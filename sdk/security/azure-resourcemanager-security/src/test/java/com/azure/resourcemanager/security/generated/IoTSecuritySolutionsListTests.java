// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
// Code generated by Microsoft (R) AutoRest Code Generator.

package com.azure.resourcemanager.security.generated;

import com.azure.core.util.BinaryData;
import com.azure.resourcemanager.security.fluent.models.IoTSecuritySolutionModelInner;
import com.azure.resourcemanager.security.models.AdditionalWorkspaceDataType;
import com.azure.resourcemanager.security.models.AdditionalWorkspacesProperties;
import com.azure.resourcemanager.security.models.AdditionalWorkspaceType;
import com.azure.resourcemanager.security.models.DataSource;
import com.azure.resourcemanager.security.models.ExportData;
import com.azure.resourcemanager.security.models.IoTSecuritySolutionsList;
import com.azure.resourcemanager.security.models.RecommendationConfigStatus;
import com.azure.resourcemanager.security.models.RecommendationConfigurationProperties;
import com.azure.resourcemanager.security.models.RecommendationType;
import com.azure.resourcemanager.security.models.SecuritySolutionStatus;
import com.azure.resourcemanager.security.models.UnmaskedIpLoggingStatus;
import com.azure.resourcemanager.security.models.UserDefinedResourcesProperties;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Assertions;

public final class IoTSecuritySolutionsListTests {
    @org.junit.jupiter.api.Test
    public void testDeserialize() throws Exception {
        IoTSecuritySolutionsList model = BinaryData.fromString(
            "{\"value\":[{\"location\":\"vlnsnnjz\",\"properties\":{\"workspace\":\"folpymwamxqzra\",\"displayName\":\"p\",\"status\":\"Enabled\",\"export\":[\"RawEvents\"],\"disabledDataSources\":[\"TwinData\",\"TwinData\",\"TwinData\"],\"iotHubs\":[\"lejchcsr\"],\"userDefinedResources\":{\"query\":\"knmzlanrupdwvnp\",\"querySubscriptions\":[\"nzqtpjhmqrhvt\",\"laiwdcxsmlzzh\",\"dtxetlgydlh\"]},\"autoDiscoveredResources\":[\"n\",\"pxy\"],\"recommendationsConfiguration\":[{\"recommendationType\":\"IoT_EdgeHubMemOptimize\",\"name\":\"geaar\",\"status\":\"Enabled\"},{\"recommendationType\":\"IoT_PermissiveInputFirewallRules\",\"name\":\"kglklbyulidwcw\",\"status\":\"Disabled\"}],\"unmaskedIpLoggingStatus\":\"Disabled\",\"additionalWorkspaces\":[{\"workspace\":\"nfhjirwgdnqzbr\",\"type\":\"Sentinel\",\"dataTypes\":[\"Alerts\",\"Alerts\",\"RawEvents\"]},{\"workspace\":\"ksjcitdigs\",\"type\":\"Sentinel\",\"dataTypes\":[\"Alerts\"]},{\"workspace\":\"lkeuac\",\"type\":\"Sentinel\",\"dataTypes\":[\"Alerts\",\"Alerts\",\"Alerts\"]},{\"workspace\":\"swfpfmd\",\"type\":\"Sentinel\",\"dataTypes\":[\"RawEvents\",\"Alerts\"]}]},\"tags\":{\"shhkvpedw\":\"qjjyslurl\",\"wwsko\":\"slsrhmpq\"},\"id\":\"dcbrwimuvq\",\"name\":\"josovyrrl\",\"type\":\"a\"},{\"location\":\"inuqtljq\",\"properties\":{\"workspace\":\"pihehce\",\"displayName\":\"ybmrqbrjbbmp\",\"status\":\"Enabled\",\"export\":[\"RawEvents\"],\"disabledDataSources\":[\"TwinData\",\"TwinData\",\"TwinData\",\"TwinData\"],\"iotHubs\":[\"eqwjksgh\"],\"userDefinedResources\":{\"query\":\"gzhxog\",\"querySubscriptions\":[\"gsv\",\"u\",\"kxibdafh\",\"kmdyomkxfbvfbh\"]},\"autoDiscoveredResources\":[\"rhpw\"],\"recommendationsConfiguration\":[{\"recommendationType\":\"IoT_IPFilter_PermissiveRule\",\"name\":\"im\",\"status\":\"Disabled\"}],\"unmaskedIpLoggingStatus\":\"Disabled\",\"additionalWorkspaces\":[{\"workspace\":\"kumuikjcjca\",\"type\":\"Sentinel\",\"dataTypes\":[\"Alerts\",\"Alerts\",\"Alerts\"]},{\"workspace\":\"wxwcomli\",\"type\":\"Sentinel\",\"dataTypes\":[\"Alerts\"]},{\"workspace\":\"cswkacvejy\",\"type\":\"Sentinel\",\"dataTypes\":[\"RawEvents\"]}]},\"tags\":{\"qthe\":\"nfxtgdd\",\"naoyank\":\"n\",\"swankltytmh\":\"oe\"},\"id\":\"roznnhdrlktgj\",\"name\":\"sggux\",\"type\":\"eml\"}],\"nextLink\":\"waeeczgfb\"}")
            .toObject(IoTSecuritySolutionsList.class);
        Assertions.assertEquals("vlnsnnjz", model.value().get(0).location());
        Assertions.assertEquals("qjjyslurl", model.value().get(0).tags().get("shhkvpedw"));
        Assertions.assertEquals("folpymwamxqzra", model.value().get(0).workspace());
        Assertions.assertEquals("p", model.value().get(0).displayName());
        Assertions.assertEquals(SecuritySolutionStatus.ENABLED, model.value().get(0).status());
        Assertions.assertEquals(ExportData.RAW_EVENTS, model.value().get(0).export().get(0));
        Assertions.assertEquals(DataSource.TWIN_DATA, model.value().get(0).disabledDataSources().get(0));
        Assertions.assertEquals("lejchcsr", model.value().get(0).iotHubs().get(0));
        Assertions.assertEquals("knmzlanrupdwvnp", model.value().get(0).userDefinedResources().query());
        Assertions.assertEquals("nzqtpjhmqrhvt",
            model.value().get(0).userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_EDGE_HUB_MEM_OPTIMIZE,
            model.value().get(0).recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.ENABLED,
            model.value().get(0).recommendationsConfiguration().get(0).status());
        Assertions.assertEquals(UnmaskedIpLoggingStatus.DISABLED, model.value().get(0).unmaskedIpLoggingStatus());
        Assertions.assertEquals("nfhjirwgdnqzbr", model.value().get(0).additionalWorkspaces().get(0).workspace());
        Assertions.assertEquals(AdditionalWorkspaceType.SENTINEL,
            model.value().get(0).additionalWorkspaces().get(0).type());
        Assertions.assertEquals(AdditionalWorkspaceDataType.ALERTS,
            model.value().get(0).additionalWorkspaces().get(0).dataTypes().get(0));
    }

    @org.junit.jupiter.api.Test
    public void testSerialize() throws Exception {
        IoTSecuritySolutionsList model = new IoTSecuritySolutionsList().withValue(Arrays.asList(
            new IoTSecuritySolutionModelInner().withLocation("vlnsnnjz")
                .withTags(mapOf("shhkvpedw", "qjjyslurl", "wwsko", "slsrhmpq"))
                .withWorkspace("folpymwamxqzra")
                .withDisplayName("p")
                .withStatus(SecuritySolutionStatus.ENABLED)
                .withExport(Arrays.asList(ExportData.RAW_EVENTS))
                .withDisabledDataSources(
                    Arrays.asList(DataSource.TWIN_DATA, DataSource.TWIN_DATA, DataSource.TWIN_DATA))
                .withIotHubs(Arrays.asList("lejchcsr"))
                .withUserDefinedResources(new UserDefinedResourcesProperties().withQuery("knmzlanrupdwvnp")
                    .withQuerySubscriptions(Arrays.asList("nzqtpjhmqrhvt", "laiwdcxsmlzzh", "dtxetlgydlh")))
                .withRecommendationsConfiguration(Arrays.asList(
                    new RecommendationConfigurationProperties()
                        .withRecommendationType(RecommendationType.IO_T_EDGE_HUB_MEM_OPTIMIZE)
                        .withStatus(RecommendationConfigStatus.ENABLED),
                    new RecommendationConfigurationProperties()
                        .withRecommendationType(RecommendationType.IO_T_PERMISSIVE_INPUT_FIREWALL_RULES)
                        .withStatus(RecommendationConfigStatus.DISABLED)))
                .withUnmaskedIpLoggingStatus(UnmaskedIpLoggingStatus.DISABLED)
                .withAdditionalWorkspaces(Arrays.asList(
                    new AdditionalWorkspacesProperties().withWorkspace("nfhjirwgdnqzbr")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.ALERTS,
                            AdditionalWorkspaceDataType.ALERTS, AdditionalWorkspaceDataType.RAW_EVENTS)),
                    new AdditionalWorkspacesProperties().withWorkspace("ksjcitdigs")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.ALERTS)),
                    new AdditionalWorkspacesProperties().withWorkspace("lkeuac")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.ALERTS,
                            AdditionalWorkspaceDataType.ALERTS, AdditionalWorkspaceDataType.ALERTS)),
                    new AdditionalWorkspacesProperties().withWorkspace("swfpfmd")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.RAW_EVENTS,
                            AdditionalWorkspaceDataType.ALERTS)))),
            new IoTSecuritySolutionModelInner().withLocation("inuqtljq")
                .withTags(mapOf("qthe", "nfxtgdd", "naoyank", "n", "swankltytmh", "oe"))
                .withWorkspace("pihehce")
                .withDisplayName("ybmrqbrjbbmp")
                .withStatus(SecuritySolutionStatus.ENABLED)
                .withExport(Arrays.asList(ExportData.RAW_EVENTS))
                .withDisabledDataSources(Arrays.asList(DataSource.TWIN_DATA, DataSource.TWIN_DATA, DataSource.TWIN_DATA,
                    DataSource.TWIN_DATA))
                .withIotHubs(Arrays.asList("eqwjksgh"))
                .withUserDefinedResources(new UserDefinedResourcesProperties().withQuery("gzhxog")
                    .withQuerySubscriptions(Arrays.asList("gsv", "u", "kxibdafh", "kmdyomkxfbvfbh")))
                .withRecommendationsConfiguration(Arrays.asList(new RecommendationConfigurationProperties()
                    .withRecommendationType(RecommendationType.IO_T_IPFILTER_PERMISSIVE_RULE)
                    .withStatus(RecommendationConfigStatus.DISABLED)))
                .withUnmaskedIpLoggingStatus(UnmaskedIpLoggingStatus.DISABLED)
                .withAdditionalWorkspaces(Arrays.asList(
                    new AdditionalWorkspacesProperties().withWorkspace("kumuikjcjca")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.ALERTS,
                            AdditionalWorkspaceDataType.ALERTS, AdditionalWorkspaceDataType.ALERTS)),
                    new AdditionalWorkspacesProperties().withWorkspace("wxwcomli")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.ALERTS)),
                    new AdditionalWorkspacesProperties().withWorkspace("cswkacvejy")
                        .withType(AdditionalWorkspaceType.SENTINEL)
                        .withDataTypes(Arrays.asList(AdditionalWorkspaceDataType.RAW_EVENTS))))));
        model = BinaryData.fromObject(model).toObject(IoTSecuritySolutionsList.class);
        Assertions.assertEquals("vlnsnnjz", model.value().get(0).location());
        Assertions.assertEquals("qjjyslurl", model.value().get(0).tags().get("shhkvpedw"));
        Assertions.assertEquals("folpymwamxqzra", model.value().get(0).workspace());
        Assertions.assertEquals("p", model.value().get(0).displayName());
        Assertions.assertEquals(SecuritySolutionStatus.ENABLED, model.value().get(0).status());
        Assertions.assertEquals(ExportData.RAW_EVENTS, model.value().get(0).export().get(0));
        Assertions.assertEquals(DataSource.TWIN_DATA, model.value().get(0).disabledDataSources().get(0));
        Assertions.assertEquals("lejchcsr", model.value().get(0).iotHubs().get(0));
        Assertions.assertEquals("knmzlanrupdwvnp", model.value().get(0).userDefinedResources().query());
        Assertions.assertEquals("nzqtpjhmqrhvt",
            model.value().get(0).userDefinedResources().querySubscriptions().get(0));
        Assertions.assertEquals(RecommendationType.IO_T_EDGE_HUB_MEM_OPTIMIZE,
            model.value().get(0).recommendationsConfiguration().get(0).recommendationType());
        Assertions.assertEquals(RecommendationConfigStatus.ENABLED,
            model.value().get(0).recommendationsConfiguration().get(0).status());
        Assertions.assertEquals(UnmaskedIpLoggingStatus.DISABLED, model.value().get(0).unmaskedIpLoggingStatus());
        Assertions.assertEquals("nfhjirwgdnqzbr", model.value().get(0).additionalWorkspaces().get(0).workspace());
        Assertions.assertEquals(AdditionalWorkspaceType.SENTINEL,
            model.value().get(0).additionalWorkspaces().get(0).type());
        Assertions.assertEquals(AdditionalWorkspaceDataType.ALERTS,
            model.value().get(0).additionalWorkspaces().get(0).dataTypes().get(0));
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
