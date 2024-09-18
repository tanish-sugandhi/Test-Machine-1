package com.example.Category_Product.exception.custom;

import com.example.Category_Product.exception.GenericException;
import org.springframework.http.HttpStatus;

public class NoSuchProductExist extends GenericException {
    public NoSuchProductExist(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}
