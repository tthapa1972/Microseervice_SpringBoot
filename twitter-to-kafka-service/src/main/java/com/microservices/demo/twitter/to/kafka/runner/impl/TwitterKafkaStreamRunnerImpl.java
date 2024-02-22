package com.microservices.demo.twitter.to.kafka.runner.impl;

import com.microservices.demo.twitter.to.kafka.config.TwitterToKafkaServiceConfig;
import com.microservices.demo.twitter.to.kafka.listener.TwitterKafkaStatusListener;
import com.microservices.demo.twitter.to.kafka.runner.StreamRunner;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;
import twitter4j.FilterQuery;
import twitter4j.TwitterException;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

import java.util.Arrays;

@Component
@ConditionalOnExpression("${twitter-to-kafka-service.enable-mock-tweets} && not ${twitter-to-kafka-service.enable-v2-tweets}")
public class TwitterKafkaStreamRunnerImpl implements StreamRunner {

    private static final Logger LOG = LoggerFactory.getLogger(TwitterKafkaStatusListener.class);
    private final TwitterToKafkaServiceConfig twitterToKafkaServiceConfig;

    private final TwitterKafkaStatusListener twitterKafkaStatusListener;


    private TwitterStream twitterStream;

    public TwitterKafkaStreamRunnerImpl(TwitterToKafkaServiceConfig twitterToKafkaServiceConfig, TwitterKafkaStatusListener twitterKafkaStatusListener) {
        this.twitterToKafkaServiceConfig = twitterToKafkaServiceConfig;
        this.twitterKafkaStatusListener = twitterKafkaStatusListener;
    }

    @Override
    public void start() throws TwitterException {

        twitterStream = new TwitterStreamFactory().getInstance();
        twitterStream.addListener(twitterKafkaStatusListener);
        addFilter();

    }

    @PreDestroy
    public void shutdown(){
        LOG.info("Closing twitter Stream");

        if(twitterStream != null){
            twitterStream.shutdown();
        }
    }

    private void addFilter() {
        String []keywords =twitterToKafkaServiceConfig.getTwitterKeywords().toArray(new String[0]);
        FilterQuery filterQuery = new FilterQuery(keywords);
        twitterStream.filter(filterQuery);

        LOG.info("Started Filtering twitter stream for keywords {}", Arrays.toString(keywords));
    }
}
