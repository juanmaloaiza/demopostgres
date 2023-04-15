package com.example.demo.exception;

public class DataDuplicateException extends  Exception{

    private static final String DESCRIPTION = "Datos duplicados";
    private static final long serialVersionUID = 6830756676887746370L;

    public DataDuplicateException() {
        super(DESCRIPTION);
    }

    public DataDuplicateException(String detail) {
        super(DESCRIPTION + ". " + detail);
    }
}
