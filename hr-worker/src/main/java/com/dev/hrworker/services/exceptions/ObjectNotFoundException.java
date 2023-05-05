package com.dev.hrworker.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
    public ObjectNotFoundException(Long id, String message) {
        super(message + " " + id);
    }
}
