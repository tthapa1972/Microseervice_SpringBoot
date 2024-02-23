package org.microservice.demo.common.config;

import com.microservices.demo.config.RetryConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.retry.backoff.ExponentialBackOffPolicy;
import org.springframework.retry.policy.SimpleRetryPolicy;
import org.springframework.retry.support.RetryTemplate;

@Configuration
public class RetryTemplateConfig {

    private final RetryConfig retryConfig;

    public RetryTemplateConfig(RetryConfig configData) {
        this.retryConfig = configData;
    }

    @Bean
    public RetryTemplate retryTemplate() {
        RetryTemplate retryTemplate = new RetryTemplate();

        ExponentialBackOffPolicy exponentialBackOffPolicy = new ExponentialBackOffPolicy();
        exponentialBackOffPolicy.setInitialInterval(retryConfig.getInitialIntervalMs());
        exponentialBackOffPolicy.setMaxInterval(retryConfig.getMaxIntervalMs());
        exponentialBackOffPolicy.setMultiplier(retryConfig.getMultiplier());

        retryTemplate.setBackOffPolicy(exponentialBackOffPolicy);

        SimpleRetryPolicy simpleRetryPolicy = new SimpleRetryPolicy();
        simpleRetryPolicy.setMaxAttempts(retryConfig.getMaxAttempts());

        retryTemplate.setRetryPolicy(simpleRetryPolicy);

        return retryTemplate;
    }
}



