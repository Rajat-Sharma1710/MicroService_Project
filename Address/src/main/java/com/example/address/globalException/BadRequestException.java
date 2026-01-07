package com.example.address.globalException;

import org.springframework.http.HttpStatus;

public class BadRequestException extends RuntimeException{
    private String message;

    private HttpStatus status;

    public BadRequestException(String message) {
        this.message = message;
        this.status = HttpStatus.NOT_FOUND;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
