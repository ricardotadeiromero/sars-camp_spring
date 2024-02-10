package com.example.sarscamp_spring.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.example.sarscamp_spring.domain.user.User;

@Service
public class TokenService {

    @Value("${jwt.secret}")
    private String SECRET;

    public String genereToken(User user) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String token = JWT.create()
                    .withIssuer("sars-camp")
                    .withSubject(user.getUsername())
                    .withExpiresAt(getExpirationDate())
                    .sign(algorithm);
            return token;
        } catch (JWTCreationException exception) {
            throw new RuntimeException("Error while generating token", exception);
        }
    }

    public String recoverToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(SECRET);
            String username = JWT.require(algorithm).build().verify(token).getSubject();
            return username;
        } catch (JWTDecodeException exception) {
            throw new RuntimeException("Error while decoding token", exception);
        }
    }

    public Instant getExpirationDate() {
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
