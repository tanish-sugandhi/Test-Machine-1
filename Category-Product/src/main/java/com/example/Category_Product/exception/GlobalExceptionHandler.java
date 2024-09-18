package com.example.Category_Product.exception;

import com.example.Category_Product.exception.custom.NoSuchCategoryExist;
import com.example.Category_Product.exception.custom.NoSuchProductExist;
import com.example.Category_Product.response.ErrorResponse;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoSuchCategoryExist.class)
    protected ResponseEntity<ErrorResponse> handleException(GenericException exception, WebRequest request, HttpServletRequest response) {
        //log.error(exception.getMessage());
        HttpStatus httpStatus = exception.getHttpStatus();
        Integer errorCode = httpStatus.value();
        String errorMessage = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorCode, errorMessage, httpStatus.name());
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
    @ExceptionHandler(NoSuchProductExist.class)
    protected ResponseEntity<ErrorResponse> handleProductException(GenericException exception, WebRequest request, HttpServletRequest response) {
        //log.error(exception.getMessage());
        HttpStatus httpStatus = exception.getHttpStatus();
        Integer errorCode = httpStatus.value();
        String errorMessage = exception.getMessage();
        ErrorResponse errorResponse = new ErrorResponse(errorCode, errorMessage, httpStatus.name());
        return ResponseEntity.status(httpStatus).body(errorResponse);
    }
}
