package com.example.demo.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ErrorMessage {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private LocalDateTime timestamp = LocalDateTime.now();

    private final String error;

    private final String message;

    private final String path;

    public ErrorMessage(Exception exception, String path) {
        this.error = exception.getClass().getSimpleName();
        this.message = exception.getMessage();
        this.path = path;
    }

    public ErrorMessage(String error) {
        this.error = error;
        this.message = error;
        this.path = "/";
    }

    public ErrorMessage(String error, String message, String path) {
        this.error = error;
        this.message = message;
        this.path = path;
    }

    @Override
    public String toString() {
        return "ErrorMessage [error=" + error + ", message=" + message + ", path=" + path + "]";
    }

}
