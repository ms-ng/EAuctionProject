package com.nguwar.microservices.biddingqueryservice.service;

import com.nguwar.microservices.biddingqueryservice.model.CreatedProductBid;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class Listener {

    @KafkaListener(topics = "bid-created-ee")
    public void listenBidCreated(ConsumerRecord<Long, CreatedProductBid> payload) {
        System.out.println("Received Kafka Message : " + payload.value().getBuyerEmail());
    }

    @KafkaListener(topics = "bid-updated-ee")
    public void listenBidUpdated(ConsumerRecord<Long, CreatedProductBid> payload) {
        System.out.println("Received Kafka Message : " + payload.value().getBuyerEmail());
    }
}
