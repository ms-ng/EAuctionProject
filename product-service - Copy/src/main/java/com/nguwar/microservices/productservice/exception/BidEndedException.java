package com.nguwar.microservices.productservice.exception;

public class BidEndedException extends RuntimeException{
    public BidEndedException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
