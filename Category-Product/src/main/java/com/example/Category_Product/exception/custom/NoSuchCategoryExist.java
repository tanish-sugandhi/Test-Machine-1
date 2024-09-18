package com.example.Category_Product.exception.custom;

import com.example.Category_Product.exception.GenericException;
import org.springframework.http.HttpStatus;

public class NoSuchCategoryExist extends GenericException {
    public NoSuchCategoryExist(String message, HttpStatus httpStatus){
        super(message, httpStatus);
    }
}
