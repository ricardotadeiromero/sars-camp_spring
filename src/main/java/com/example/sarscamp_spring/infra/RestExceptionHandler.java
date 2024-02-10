package com.example.sarscamp_spring.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.sarscamp_spring.exceptions.ExistCardapioException;

@ControllerAdvice
public class RestExceptionHandler {

    @ExceptionHandler(ExistCardapioException.class)
    private ResponseEntity<String> existsCardapioException(ExistCardapioException ex) {
        return ResponseEntity.status(409).body(ex.getMessage());
    }
}
