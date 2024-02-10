package com.example.sarscamp_spring.domain.cardapio;

import java.time.LocalDateTime;

import com.example.sarscamp_spring.dtos.CreateCardapioDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "cardapio")
@Entity(name = "cardapio")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "codigo")
public class Cardapio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String principal;
    private String guarnicao;
    private String salada;
    private String sobremesa;
    private int periodo;
    private int vegetariano;
    private String suco;
    private LocalDateTime data;


    public Cardapio(CreateCardapioDTO data){
        this.principal = data.principal();
        this.guarnicao = data.guarnicao();
        this.salada = data.salada();
        this.sobremesa = data.sobremesa();
        this.periodo = data.periodo();
        this.vegetariano = data.vegetariano();
        this.suco = data.suco();
        this.data = data.data();
    }
}
