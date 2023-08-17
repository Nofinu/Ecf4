package com.example.celestialobjectservice.Exception;

public class NotFoundException extends RuntimeException{
    public NotFoundException() {
        super("Celestial Object Not Found");
    }
}
