package com.example.sarscamp_spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sarscamp_spring.domain.achados_e_perdidos.AchadosEPerdidos;

public interface AchadosEPerdidosRepository extends JpaRepository<AchadosEPerdidos, Long>{
    
}
