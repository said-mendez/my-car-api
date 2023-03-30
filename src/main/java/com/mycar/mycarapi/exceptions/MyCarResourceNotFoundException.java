package com.mycar.mycarapi.exceptions;

public class MyCarResourceNotFoundException extends RuntimeException {
    public MyCarResourceNotFoundException(String message) {
        super(message);
    }
}
