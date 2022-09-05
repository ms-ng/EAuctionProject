package com.nguwar.microservices.productservice.exception;

public class ProductDeletionException extends RuntimeException{
    public ProductDeletionException(String errorMessage) {
        super(errorMessage);
    }
}
