package com.example.sarscamp_spring.controllers;

import java.util.List;

import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.sarscamp_spring.domain.cardapio.Cardapio;
import com.example.sarscamp_spring.dtos.CreateCardapioDTO;
import com.example.sarscamp_spring.services.CardapioService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/cardapio")
@RequiredArgsConstructor
public class CardapioController {

    private final CardapioService service;

    @PostMapping
    public Cardapio save(@RequestBody @Validated CreateCardapioDTO cardapio) throws Exception {
        System.out.println(cardapio);
        return service.save(cardapio);
    }

    @Secured({ "ADMIN", "MASTER" })
    @GetMapping
    public List<Cardapio> all() {
        return service.all();
    }

    @GetMapping("/week")
    public List<List<Cardapio>> week() {
        return service.week();
    }

    @GetMapping("/by/week/{week}")
    public List<List<Cardapio>> week(@PathVariable("week") int week) {
        return service.week(week);
    }
}
