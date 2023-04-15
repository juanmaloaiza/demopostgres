package com.example.demo.exception;

public class DataAssociateException extends Exception{

    private static final String DESCRIPTION = "Datos  asociados";
    private static final long serialVersionUID = 6830756676887746370L;

    public DataAssociateException( String detail) {
        super(DESCRIPTION + "." +detail);
    }
}
