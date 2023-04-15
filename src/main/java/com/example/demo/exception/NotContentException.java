package com.example.demo.exception;

public class NotContentException extends Exception {

    private static final String DESCRIPTION = "No existen datos";
    private static final long serialVersionUID = 6830756676887746370L;

    public NotContentException() {
        super(DESCRIPTION);
    }

    public NotContentException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
