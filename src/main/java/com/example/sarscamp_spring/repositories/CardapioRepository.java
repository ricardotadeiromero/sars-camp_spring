package com.example.sarscamp_spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.sarscamp_spring.domain.cardapio.Cardapio;

import java.time.LocalDateTime;

public interface CardapioRepository extends JpaRepository<Cardapio, Long> {

        @Query("SELECT c FROM cardapio c " +
                        "WHERE c.data = CURRENT_DATE() " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findToday();

        @Query("SELECT c FROM cardapio c " +
                        "WHERE WEEK(c.data) = WEEK(CURRENT_DATE()) AND YEAR(c.data) = YEAR(CURRENT_DATE()) " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findWeek();

        @Query("SELECT c FROM cardapio c " +
                        "WHERE MONTH(c.data) = MONTH(CURRENT_DATE()) AND YEAR(c.data) = YEAR(CURRENT_DATE()) " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findMonth();

        @Query("SELECT c FROM cardapio c " +
                        "WHERE YEAR(c.data) = YEAR(CURRENT_DATE()) " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findYear();

        List<Cardapio> findByData(LocalDateTime data);

        @Query("SELECT c FROM cardapio c " +
                        "WHERE WEEK(c.data) = ?1 AND YEAR(c.data) = YEAR(CURRENT_DATE()) " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findByWeek(int week);

        @Query("SELECT c FROM cardapio c " +
                        "WHERE MONTH(c.data) = ?1 AND YEAR(c.data) = YEAR(CURRENT_DATE()) " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findByMonth(int month);

        @Query("SELECT c FROM cardapio c " +
                        "WHERE YEAR(c.data) = ?1 " +
                        "ORDER BY c.data ASC")
        List<Cardapio> findByYear(int year);

        boolean existsByDataAndPeriodoAndVegetariano(LocalDateTime data, int periodo, int vegetariano);
}
