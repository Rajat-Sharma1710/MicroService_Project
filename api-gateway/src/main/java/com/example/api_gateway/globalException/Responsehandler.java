package com.example.api_gateway.globalException;

import java.time.LocalDateTime;

public class Responsehandler {

    private String message;
    private String status;
    private LocalDateTime timeStamp;

    public Responsehandler(String message, String status) {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}
