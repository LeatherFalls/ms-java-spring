package com.dev.hrworker.resources.exceptions;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException error, HttpServletRequest req) {
        HttpStatus code = HttpStatus.NOT_FOUND;
        StandardError err = new StandardError(System.currentTimeMillis(), code.value(), "Not found", error.getMessage(), req.getRequestURI());
        return ResponseEntity.status(code).body(err);
    }
}
