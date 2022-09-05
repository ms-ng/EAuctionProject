package com.nguwar.microservices.biddingqueryservice;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.jmx.config.EnableIntegrationMBeanExport;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

import java.util.function.Function;


@EnableKafka
@EnableKafkaStreams
@SpringBootApplication
public class BiddingQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiddingQueryServiceApplication.class, args);
	}

	@Bean
	public Function<KStream<String, String>, KStream<String, String>> biddingProcessor() {
		return placedBidStream -> {
			return placedBidStream.mapValues(v -> v + "hello");
		};
	}

}
