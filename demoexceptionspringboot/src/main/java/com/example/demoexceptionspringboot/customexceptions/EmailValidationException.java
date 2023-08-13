package com.example.demoexceptionspringboot.customexceptions;

public class EmailValidationException extends RuntimeException {

    public EmailValidationException(String error) {
        super(error);

    }
}