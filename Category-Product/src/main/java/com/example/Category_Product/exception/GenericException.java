package com.example.Category_Product.exception;

import org.springframework.http.HttpStatus;

public class GenericException extends RuntimeException {
    final HttpStatus httpStatus;

    public GenericException(String message,Exception exception,HttpStatus httpStatus){
        super(message,exception);
        this.httpStatus=httpStatus;
    }

    public GenericException(String message,HttpStatus httpStatus)
    {
        super(message);
        this.httpStatus=httpStatus;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}
