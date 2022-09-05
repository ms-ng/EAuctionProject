package com.nguwar.microservices.productservice.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorMessageDTO {
    private String object;
    private String field;
    private String message;
    private Object rejectedValue;

}
