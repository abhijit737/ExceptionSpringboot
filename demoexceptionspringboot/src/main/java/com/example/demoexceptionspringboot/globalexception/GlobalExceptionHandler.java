package com.example.demoexceptionspringboot.globalexception;

import com.example.demoexceptionspringboot.customexceptions.FirstNameValidationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import com.example.demoexceptionspringboot.errors.Error;

public class GlobalExceptionHandler {
    @ExceptionHandler(value = FirstNameValidationException.class)
    public ResponseEntity<Error> emailValidation(FirstNameValidationException exception) {
        Error error = new Error(1000, exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}