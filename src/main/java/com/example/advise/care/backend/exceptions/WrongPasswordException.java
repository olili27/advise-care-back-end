package com.example.advise.care.backend.exceptions;

public class WrongPasswordException extends Exception{

    public WrongPasswordException(String message) {
        super(message);
    }
}