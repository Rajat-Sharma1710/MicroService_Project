package com.example.api_gateway.globalException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(BadRequestException.class)
    private ResponseEntity<Responsehandler> handleBadRequestException(BadRequestException exception) {
        Responsehandler handler = new Responsehandler(exception.getMessage(), exception.getStatus().name());
        return new ResponseEntity<>(handler, exception.getStatus());
    }
}
