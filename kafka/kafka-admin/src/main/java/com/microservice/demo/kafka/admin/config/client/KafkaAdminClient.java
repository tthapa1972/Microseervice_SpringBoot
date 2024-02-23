package com.microservice.demo.kafka.admin.config.client;

import com.microservices.demo.config.KafkaConfig;
import com.microservices.demo.config.RetryConfig;
import org.apache.kafka.clients.admin.AdminClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaAdminClient {

    private static final Logger LOG = LoggerFactory.getLogger(KafkaAdminClient.class);

    private KafkaConfig kafkaConfigData;

    private RetryConfig retryConfigData;

    private AdminClient adminClient;

    private RetryTemplate retryTemplate;

    public KafkaAdminClient(KafkaConfig config,
                            RetryConfig retryConfigData,
                            AdminClient client,
                            RetryTemplate template) {
        this.kafkaConfigData = config;
        this.retryConfigData = retryConfigData;
        this.adminClient = client;
        this.retryTemplate = template;
    }
}
