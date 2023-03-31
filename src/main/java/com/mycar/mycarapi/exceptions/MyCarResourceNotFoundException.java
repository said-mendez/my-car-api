package com.mycar.mycarapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MyCarResourceNotFoundException extends RuntimeException {
    public MyCarResourceNotFoundException(String message) {
        super(message);
    }
}
