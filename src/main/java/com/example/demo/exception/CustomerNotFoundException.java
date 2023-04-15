package com.example.demo.exception;


public class CustomerNotFoundException extends Exception {

    private static final String DESCRIPTION = "Cliente no existe";
    private static final long serialVersionUID = 6830756676887746370L;

    public CustomerNotFoundException() {
        super(DESCRIPTION);
    }
}
