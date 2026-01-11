package com.example.auth.service;

import com.example.auth.model.dto.LoginRequestDto;
import com.example.auth.model.dto.LoginResponseDto;
import com.example.auth.model.entity.User;
import com.example.auth.util.AuthUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final AuthenticationManager authenticationManager;

    private final AuthUtil authUtil;

    public AuthService(AuthenticationManager authenticationManager, AuthUtil authUtil) {
        this.authenticationManager = authenticationManager;
        this.authUtil = authUtil;
    }

    public LoginResponseDto login(LoginRequestDto requestDto) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(requestDto.getUsername()
                        , requestDto.getPassword()));

        MyUserDetails user = (MyUserDetails) authentication.getPrincipal();
        String jwtToken = authUtil.getJwtToken(user);

        return new LoginResponseDto(requestDto.getUsername(), jwtToken, authUtil.getExpiration(jwtToken));
    }
}
