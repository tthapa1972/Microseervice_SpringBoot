package com.microservices.demo.twitter.to.kafka.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@Configuration
@ConfigurationProperties(prefix = "twitter-to-kafka-service")
public class TwitterToKafkaServiceConfig {

    private List<String> twitterKeywords;

    private String welcomeMessage;

    private Boolean enableMockTweets;
    private Long mockSleepMs;
    private Integer mockMinTweetLength;
    private Integer mockMaxTweetLength;
    private String twitterV2BaseUrl;
    private String twitterV2RulesBaseUrl;
    private String twitterV2BearerToken;

    public List<String> getTwitterKeywords() {
        return twitterKeywords;
    }

    public void setTwitterKeywords(List<String> twitterKeywords) {
        this.twitterKeywords = twitterKeywords;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public void setWelcomeMessage(String welcomeMessage) {
        this.welcomeMessage = welcomeMessage;
    }

    public String getTwitterV2BaseUrl() {
        return twitterV2BaseUrl;
    }

    public void setTwitterV2BaseUrl(String twitterV2BaseUrl) {
        this.twitterV2BaseUrl = twitterV2BaseUrl;
    }

    public String getTwitterV2RulesBaseUrl() {
        return twitterV2RulesBaseUrl;
    }

    public void setTwitterV2RulesBaseUrl(String twitterV2RulesBaseUrl) {
        this.twitterV2RulesBaseUrl = twitterV2RulesBaseUrl;
    }

    public String getTwitterV2BearerToken() {
        return twitterV2BearerToken;
    }

    public void setTwitterV2BearerToken(String twitterV2BearerToken) {
        this.twitterV2BearerToken = twitterV2BearerToken;
    }

    public Boolean getEnableMockTweets() {
        return enableMockTweets;
    }

    public void setEnableMockTweets(Boolean enableMockTweets) {
        this.enableMockTweets = enableMockTweets;
    }

    public Long getMockSleepMs() {
        return mockSleepMs;
    }

    public void setMockSleepMs(Long mockSleepMs) {
        this.mockSleepMs = mockSleepMs;
    }

    public Integer getMockMinTweetLength() {
        return mockMinTweetLength;
    }

    public void setMockMinTweetLength(Integer mockMinTweetLength) {
        this.mockMinTweetLength = mockMinTweetLength;
    }

    public Integer getMockMaxTweetLength() {
        return mockMaxTweetLength;
    }

    public void setMockMaxTweetLength(Integer mockMaxTweetLength) {
        this.mockMaxTweetLength = mockMaxTweetLength;
    }
}
