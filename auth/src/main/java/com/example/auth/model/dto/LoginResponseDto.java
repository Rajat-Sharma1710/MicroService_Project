package com.example.auth.model.dto;

import java.util.Date;

public class LoginResponseDto {

    private String userName;
    private String jwtToken;

    private Date validUntil;

    public LoginResponseDto(String userName, String jwtToken, Date validUntil) {
        this.userName = userName;
        this.jwtToken = jwtToken;
        this.validUntil = validUntil;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Date getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(Date validUntil) {
        this.validUntil = validUntil;
    }
}
