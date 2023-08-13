package com.example.demoexceptionspringboot.controller;

import com.example.demoexceptionspringboot.customexceptions.EmailValidationException;
import com.example.demoexceptionspringboot.customexceptions.FirstNameValidationException;
import com.example.demoexceptionspringboot.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoexceptionspringboot.errors.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {


    @PostMapping ("/user")
    public User addUser(@RequestBody User user) {
        if(!user.getEmail().contains("@")){
            try {
                throw new EmailValidationException("Not a valid Email :: " + user.getEmail());
            }catch(Exception e){
                e.printStackTrace();

            }
        }
        if(user.getFname().contains("!")){
            throw new FirstNameValidationException("Not a valid name :: "+user.getFname());
        }

        return user;

    }

    @ExceptionHandler(value = EmailValidationException.class)
    public ResponseEntity<Error> emailValidation(EmailValidationException exception) {
        Error error=new Error(1000,exception.getMessage());
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }



}
