package com.springsecurity.foods.Bases;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalException{

    @ExceptionHandler(FoodsException.class)
    public ResponseEntity<Map<String,String>> userErros(FoodsException e) {
        return createErrorResponse(e.getMessage());
    }
    private ResponseEntity<Map<String, String>> createErrorResponse(String problem) {
        Map<String, String> errors = new HashMap<>();
        errors.put("error", problem);
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
