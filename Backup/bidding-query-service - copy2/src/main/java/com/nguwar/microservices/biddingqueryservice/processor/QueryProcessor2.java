package com.nguwar.microservices.biddingqueryservice.processor;

import com.nguwar.microservices.biddingqueryservice.dto.Bid;
import com.nguwar.microservices.biddingqueryservice.dto.Product;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class QueryProcessor2 {

    private static final Serde<String> STRING_SERDE = Serdes.String();

    /*
    @Autowired
    void buildPipeline(StreamsBuilder streamsBuilder) {
        KStream<String, String> messageStream = streamsBuilder
                .stream("input-topic", Consumed.with(STRING_SERDE, STRING_SERDE));

        KTable<String, Long> wordCounts = textStream
                .mapValues((ValueMapper<String, String>) String::toLowerCase)
                .flatMapValues(value -> Arrays.asList(value.split("\\W+")))
                .groupBy((key, value) -> value, Grouped.with(STRING_SERDE, STRING_SERDE))
                .count(Materialized.as("counts"));

        wordCounts.toStream().to("output-topic");
    }
    */


    @Bean
    public Function<KStream<String, String>, KStream<String, String>> productBidProcessor() {
        return placedBidStream -> {
            // group the ordered items by price
            /*
            KStream<Long, Product> productBidStream = (KStream<Long, Product>) placedBidStream.groupByKey().aggregate(
                    this::initializeItems,
                    this::aggregateItems,
                    Materialized.as("product-store-test"));
            */
            return placedBidStream;
        };
    }


    public Product initializeItems() {
        return new Product();
    }

    public Product aggregateItems(Long aggKey, Bid newValue, Product aggValue) {
        int index = aggValue.getBidList().indexOf(newValue);
        aggValue.setId(newValue.getProductId());
        if (index >= 0) {
            aggValue.getBidList().get(index).setBidAmount(newValue.getBidAmount());
        } else {
            aggValue.getBidList().add(newValue);
        }
        return aggValue;
    }

    /*
    @Bean
    public BiConsumer<KStream<Long, Order>, KStream<Long, Order>> orders() {
        return (orderBuy, orderSell) -> orderBuy
                .merge(orderSell)
                .peek((k, v) -> {
                    log.info("New({}): {}", k, v);
                    logic.add(v);
                });
    }

    @Bean
    public BiFunction<KStream<Long, Bid>, KStream<Long, Bid>, KStream<Long, Transaction>> transactions() {
        return (bidCreatedStream, bidUpdatedStream) -> orderBuy
                .selectKey((k, v) -> v.getProductId())
                .join(orderSell.selectKey((k, v) -> v.getProductId()),
                        this::execute,
                        JoinWindows.of(Duration.ofSeconds(10)),
                        StreamJoined.with(Serdes.Integer(), new JsonSerde<>(Order.class), new JsonSerde<>(Order.class)))
                .filterNot((k, v) -> v == null)
                .map((k, v) -> new KeyValue<>(v.getId(), v))
                .peek((k, v) -> log.info("Done -> {}", v));

        return (bidCreatedStream, bidUpdatedStream) -> bidCreatedStream
                .merge(bidUpdatedStream)
                .selectKey((k,v) -> v.getProductId())
                .map((k,v) -> new KeyValue<>(v.getProductId(), v));

    }

     */
}
