package com.nguwar.microservices.biddingqueryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;

@EnableKafka
@SpringBootApplication
public class BiddingQueryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiddingQueryServiceApplication.class, args);
	}

}
