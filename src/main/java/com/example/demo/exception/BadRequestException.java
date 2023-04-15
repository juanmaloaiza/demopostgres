package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus (HttpStatus.BAD_REQUEST)
public class BadRequestException extends Exception{

    private static final String DESCRIPTION = "Bad Request Exception";
    private static final long serialVersionUID = 6830756676887746370L;
    public BadRequestException(String message) {
        super(DESCRIPTION);
    }
}
