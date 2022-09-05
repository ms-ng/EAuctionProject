package com.nguwar.microservices.biddingqueryservice.service;

import com.nguwar.microservices.biddingqueryservice.dto.Bid;
import com.nguwar.microservices.biddingqueryservice.dto.Product;
import org.apache.kafka.streams.state.QueryableStoreTypes;
import org.apache.kafka.streams.state.ReadOnlyKeyValueStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.binder.kafka.streams.InteractiveQueryService;
import org.springframework.stereotype.Service;


import java.util.Arrays;

@Service
public class BiddingQueryService {
    @Autowired
    private InteractiveQueryService queryService;

    public Product getProductBiddings(Long productId){
        String storeName = "product-store-testtest";
        ReadOnlyKeyValueStore<Long, Product> orderedItemsStore = queryService.getQueryableStore(storeName,
                QueryableStoreTypes.keyValueStore());

        // get the items for the given customer
        Product productBiddings = orderedItemsStore.get(productId);

        return productBiddings;
    }
}
