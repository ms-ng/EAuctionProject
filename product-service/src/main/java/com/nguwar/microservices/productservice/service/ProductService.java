package com.nguwar.microservices.productservice.service;

import com.nguwar.microservices.productservice.exception.ProductDeletionException;
import com.nguwar.microservices.productservice.model.Product;
import com.nguwar.microservices.productservice.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product addProduct(Product product){
        return this.productRepository.save(product);
    }

    public Optional<Product> getProduct(long productId) {
        return this.productRepository.findById(productId);
    }

    public void deleteProduct(long productId) throws ProductDeletionException {
        /*
        Optional<Product> product = this.getProduct(productId);

        if(!product.isPresent()) throw new ProductDeletionException("Product does not exist");

        if(product.get().getBidEndDate().isBefore(ZonedDateTime.now()))
            throw new ProductDeletionException("Bid ended for this product. Deletion not allowed anymore.");

        //to check bid existed or not
        if(false)
            throw new ProductDeletionException("Deletion not allowed. There are existing bid placed.");

        this.productRepository.deleteById(productId);

         */
    }
}
