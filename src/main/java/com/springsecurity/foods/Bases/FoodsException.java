package com.springsecurity.foods.Bases;

public class FoodsException extends RuntimeException{
    private String message;
    public FoodsException(String message){
        super(message);
    }
}
