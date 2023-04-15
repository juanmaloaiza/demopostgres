package com.example.demo.exception;

public class NotFoundException extends Exception {
    private static final String DESCRIPTION = "Recurso no disponible";
    private static final long serialVersionUID = 6830756676887746370L;

    public NotFoundException() {
        super(DESCRIPTION);
    }

    public NotFoundException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }

}
