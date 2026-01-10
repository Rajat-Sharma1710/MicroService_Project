package com.example.auth.service;

import com.example.auth.model.dto.UserDto;
import com.example.auth.model.entity.User;
import com.example.auth.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserDto saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        User myUser = userRepository.save(user);
        return new UserDto(myUser.getId(), myUser.getUsername(), myUser.getRoles());
    }
}
