// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.cloud.autoconfigure.implementation.kafka;

import com.azure.spring.cloud.autoconfigure.implementation.context.AzureGlobalPropertiesAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.cloud.stream.binder.kafka.KafkaMessageChannelBinder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Configuration for OAuth2 support on Spring Cloud Stream Kafka Binder. Provide Azure Identity-based
 * OAuth2 authentication for Event Hubs for Kafka on the basis of Spring Cloud Stream configuration.
 *
 * @since 4.3.0
 */
@Configuration(proxyBeanMethods = false)
@ConditionalOnClass(KafkaMessageChannelBinder.class)
@Import(AzureGlobalPropertiesAutoConfiguration.class)
public class AzureKafkaSpringCloudStreamConfiguration {

    @Bean
    static KafkaBinderConfigurationPropertiesBeanPostProcessor kafkaBinderConfigurationPropertiesBeanPostProcessor() {
        return new KafkaBinderConfigurationPropertiesBeanPostProcessor();
    }
}
