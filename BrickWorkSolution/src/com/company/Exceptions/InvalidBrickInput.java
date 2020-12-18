package com.company.Exceptions;

public class InvalidBrickInput extends RuntimeException {
    public InvalidBrickInput(String message) {
        super(message);
    }
}
