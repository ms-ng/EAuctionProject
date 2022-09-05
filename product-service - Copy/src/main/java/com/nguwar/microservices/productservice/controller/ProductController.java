package com.nguwar.microservices.productservice.controller;

import com.nguwar.microservices.productservice.dto.ProductDTO;
import com.nguwar.microservices.productservice.dto.mapper.ProductMapper;
import com.nguwar.microservices.productservice.exception.ProductDeletionException;
import com.nguwar.microservices.productservice.model.Product;
import com.nguwar.microservices.productservice.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
public class ProductController {

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/product-service/v1/add-product")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product product){
        Product createdProduct = productService.addProduct(product);
        logger.info("new product added with id : ");
        return ResponseEntity.ok("new product added with id : " );
    }

    @DeleteMapping ("/product-service/v1/delete/{productId}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long productId){

        Optional<Product> product = productService.getProduct(productId);

        if(!product.isPresent()) return ResponseEntity.notFound().build();

        try {
            productService.deleteProduct(productId);
        } catch(ProductDeletionException ex) {
            logger.info("existing product not deleted with error : " + ex.getMessage());
        }

        logger.info("existing product deleted with id : " + productId);

        return ResponseEntity.ok("product deleted!");
    }

    @GetMapping ("/product-service/v1/{productId}")
    public ProductDTO getProduct(@PathVariable Long productId){

        Optional<Product> product = productService.getProduct(productId);

        if(!product.isPresent()) throw new RuntimeException("no product!");

        logger.info("existing product retrieved with id : " + productId);

        ProductDTO productDTO = ProductMapper.INSTANCE.productToProductDTO(product.get());

        return productDTO;
    }
}
