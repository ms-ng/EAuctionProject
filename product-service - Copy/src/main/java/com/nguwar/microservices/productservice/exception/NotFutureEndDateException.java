package com.nguwar.microservices.productservice.exception;

public class NotFutureEndDateException extends RuntimeException{
    public NotFutureEndDateException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
