package com.example.auth.model.dto;

public class UserDto {

    private Long id;
    private String[] roles;
    private String userName;

    public UserDto(Long id, String userName, String[] roles) {
        this.id = id;
        this.userName = userName;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String[] getRoles() {
        return roles;
    }

    public void setRoles(String[] roles) {
        this.roles = roles;
    }
}
