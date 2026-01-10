package com.example.auth.controller;

import com.example.auth.model.dto.UserDto;
import com.example.auth.model.entity.User;
import com.example.auth.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    private ResponseEntity<UserDto> saveUser(@RequestBody User user) {
        UserDto myUser = userService.saveUser(user);
        return new ResponseEntity<>(myUser, HttpStatus.CREATED);
    }
}
