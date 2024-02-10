package com.example.sarscamp_spring.services;

import java.time.LocalDateTime;
import java.util.ArrayList;

import java.util.List; // Import the correct List class
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.sarscamp_spring.domain.cardapio.Cardapio;
import com.example.sarscamp_spring.dtos.CreateCardapioDTO;
import com.example.sarscamp_spring.exceptions.ExistCardapioException;
import com.example.sarscamp_spring.repositories.CardapioRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CardapioService {

    private final CardapioRepository repository;

    public List<List<Cardapio>> addToInterval(List<Cardapio> cardapios) {
        Map<Integer, List<Cardapio>> weekMap = cardapios.stream().collect(Collectors.groupingBy(c -> c.getData().getDayOfMonth()));
        List<List<Cardapio>> weekAgroupList = new ArrayList<>(weekMap.values());
        return weekAgroupList;
    }

    public List<List<Cardapio>> week() {
        List<Cardapio> week = repository.findWeek();
        return addToInterval(week);
    }

    public List<List<Cardapio>> month() {
        List<Cardapio> month = repository.findMonth();
        return addToInterval(month);
    }

    public List<List<Cardapio>> year() {
        List<Cardapio> year = repository.findYear();
        return addToInterval(year);
    }

    public List<List<Cardapio>> today() {
        List<Cardapio> today = repository.findToday();
        return addToInterval(today);
    }

    public List<List<Cardapio>> week(int week) {
        List<Cardapio> weekList = repository.findByWeek(week);
        return addToInterval(weekList);
    }

    public List<List<Cardapio>> month(int month) {
        List<Cardapio> monthList = repository.findByMonth(month);
        return addToInterval(monthList);
    }

    public List<List<Cardapio>> year(int year) {
        List<Cardapio> yearList = repository.findByYear(year);
        return addToInterval(yearList);
    }

    public List<List<Cardapio>> date(LocalDateTime day) {
        List<Cardapio> todayList = repository.findByData(day);
        return addToInterval(todayList);
    }

    public List<Cardapio> all() {
        return repository.findAll();
    }
    
    public Cardapio save(CreateCardapioDTO cardapio) throws Exception {
        if(repository.existsByDataAndPeriodoAndVegetariano(cardapio.data(), cardapio.periodo(),cardapio.vegetariano())) {
            throw new ExistCardapioException();
        }
        Cardapio cardapioObj = new Cardapio(cardapio);
        return repository.save(cardapioObj);
    }


}
