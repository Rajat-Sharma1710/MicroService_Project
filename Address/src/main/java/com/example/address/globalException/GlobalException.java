package com.example.address.globalException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(ResourceNotFoundException.class)
    private ResponseEntity<Responsehandler> handleResourceNotFoundException(ResourceNotFoundException exception) {
        Responsehandler handler = new Responsehandler(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(handler, exception.getStatus());
    }

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<Responsehandler> handleBadRequestException(BadRequestException exception) {
        Responsehandler handler = new Responsehandler(exception.getMessage(), exception.getStatus());
        return new ResponseEntity<>(handler, exception.getStatus());
    }
}
