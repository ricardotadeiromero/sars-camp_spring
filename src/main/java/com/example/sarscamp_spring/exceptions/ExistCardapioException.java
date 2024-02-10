package com.example.sarscamp_spring.exceptions;

public class ExistCardapioException extends RuntimeException {

    public ExistCardapioException(String message) {
        super(message);
    }

    public ExistCardapioException() {
        super("Cardapio already exists");
    }
}
