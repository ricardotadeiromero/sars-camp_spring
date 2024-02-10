package com.example.sarscamp_spring.services;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.sarscamp_spring.domain.user.User;
import com.example.sarscamp_spring.dtos.LoginUserDTO;
import com.example.sarscamp_spring.dtos.RegisterUserDTO;
import com.example.sarscamp_spring.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository repository;
    private final AuthenticationManager authenticationManager;
    private final TokenService tokenService;

    public UserDetails register(RegisterUserDTO data){
        User user = new User(data);
        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        repository.save(user);
        return user;

    }

    public String login(LoginUserDTO data){
        var usernamePassword = new UsernamePasswordAuthenticationToken(data.username(), data.password());
        var authentication = authenticationManager.authenticate(usernamePassword);
        var token = tokenService.genereToken((User) authentication.getPrincipal());
        return token;
    }
}
