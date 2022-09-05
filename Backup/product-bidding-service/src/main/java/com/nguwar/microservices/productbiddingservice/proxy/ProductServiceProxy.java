package com.nguwar.microservices.biddingcommandservice.proxy;

import com.nguwar.microservices.biddingcommandservice.dto.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="product-service")
public interface ProductServiceProxy {

    @GetMapping("/product-service/v1/{productId}")
    public Product retrieveProduct(
            @PathVariable long productId);
}
