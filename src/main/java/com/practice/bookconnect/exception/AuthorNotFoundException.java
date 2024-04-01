package com.practice.bookconnect.exception;

public class AuthorNotFoundException extends RuntimeException {
    public AuthorNotFoundException(String message){
        super(message);
    }
}
