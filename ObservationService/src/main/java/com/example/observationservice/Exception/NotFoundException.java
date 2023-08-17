package com.example.observationservice.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Not Found");
    }
}
