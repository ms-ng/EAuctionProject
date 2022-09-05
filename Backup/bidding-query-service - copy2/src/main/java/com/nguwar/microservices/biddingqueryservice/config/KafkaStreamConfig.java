package com.nguwar.microservices.biddingqueryservice.config;

import com.nguwar.microservices.biddingqueryservice.dto.Bid;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerde;

import java.util.HashMap;
import java.util.Map;

import static org.apache.kafka.streams.StreamsConfig.*;

@Configuration
public class KafkaStreamConfig {

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    KafkaStreamsConfiguration kStreamsConfig() {

        JsonSerde<Bid> jsonSerde = new JsonSerde<>(Bid.class);
        jsonSerde.deserializer().addTrustedPackages("*");
        jsonSerde.deserializer().setRemoveTypeHeaders(false);
        jsonSerde.deserializer().setUseTypeMapperForKey(true);

        Map<String, Object> props = new HashMap<>();
        props.put(APPLICATION_ID_CONFIG, "bidding-query-service");
        props.put(BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.LongSerde.class);
        props.put(DEFAULT_VALUE_SERDE_CLASS_CONFIG, jsonSerde);

        return new KafkaStreamsConfiguration(props);
    }


}