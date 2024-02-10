package com.example.sarscamp_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.sarscamp_spring.domain.user.User;

public interface UserRepository extends JpaRepository<User, Long>{
    
    UserDetails findByUsername(String username);
}
