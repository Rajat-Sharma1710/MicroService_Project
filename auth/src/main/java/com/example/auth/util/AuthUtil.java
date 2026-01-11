package com.example.auth.util;

import com.example.auth.service.MyUserDetails;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class AuthUtil {

    @Value("${jwt.secret}")
    private String key;

    private SecretKey getSecretKey() {
        return Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8));
    }

    public String getJwtToken(MyUserDetails user) {
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("userId", user.getId())
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 5))
                .signWith(getSecretKey())
                .compact();
    }

    private Claims getClaims(String token) {
        return Jwts.parser().verifyWith(getSecretKey())
                .build().parseSignedClaims(token)
                .getPayload();
    }

    public Date getExpiration(String token) {
        return getClaims(token).getExpiration();
    }
}
