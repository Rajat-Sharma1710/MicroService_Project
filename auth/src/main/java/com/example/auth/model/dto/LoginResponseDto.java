package com.example.auth.model.dto;

public class LoginResponseDto {

    private String userName;
    private String jwtToken;

    private String validUntil;

    public LoginResponseDto(String userName, String jwtToken, String validUntil) {
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

    public String getValidUntil() {
        return validUntil;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }
}
