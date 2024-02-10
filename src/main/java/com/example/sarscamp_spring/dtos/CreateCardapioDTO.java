package com.example.sarscamp_spring.dtos;
import java.time.LocalDateTime;

public record CreateCardapioDTO(String principal, String guarnicao, String salada, String sobremesa, String suco, int vegetariano, int periodo, LocalDateTime data) {
    
}
