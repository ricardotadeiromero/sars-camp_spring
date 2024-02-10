package com.example.sarscamp_spring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sarscamp_spring.dtos.LoginUserDTO;
import com.example.sarscamp_spring.dtos.RegisterUserDTO;
import com.example.sarscamp_spring.dtos.ResponseLoginDTO;
import com.example.sarscamp_spring.services.TokenService;
import com.example.sarscamp_spring.services.UserService;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("")
@RequiredArgsConstructor
public class AuthenticationController {

    private final UserService service;
    private final TokenService tokenService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterUserDTO data) {
        service.register(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Validated LoginUserDTO data, HttpServletResponse response)
            throws Exception {
        String token = service.login(data);
        Cookie cookie = new Cookie("token", token);
        cookie.isHttpOnly();
        cookie.setPath("/");
        cookie.setMaxAge((int) tokenService.getExpirationDate().getEpochSecond());
        response.addCookie(cookie);
        return ResponseEntity.ok(new ResponseLoginDTO(token));
    }
}
