package com.example.demoexceptionspringboot.customexceptions;

public class FirstNameValidationException extends RuntimeException {

    public FirstNameValidationException(String message) {
        super(message);

    }
}