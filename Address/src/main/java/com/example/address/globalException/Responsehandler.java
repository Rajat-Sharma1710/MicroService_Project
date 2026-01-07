package com.example.address.globalException;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public class Responsehandler {

    private String message;
    private HttpStatus status;
    private LocalDateTime timeStamp;

    public Responsehandler(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
        this.timeStamp = LocalDateTime.now();
    }

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

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
