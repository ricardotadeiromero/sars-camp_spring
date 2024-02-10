package com.example.sarscamp_spring.services;

import org.springframework.stereotype.Service;
import java.util.List;

import com.example.sarscamp_spring.domain.achados_e_perdidos.AchadosEPerdidos;
import com.example.sarscamp_spring.dtos.CreateAchadosEPerididosDTO;
import com.example.sarscamp_spring.repositories.AchadosEPerdidosRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AchadosEPerdidosService {
    
    private final AchadosEPerdidosRepository repository;

    public List<AchadosEPerdidos> all() {
        return repository.findAll();
    }

    public void save(CreateAchadosEPerididosDTO data) {
        AchadosEPerdidos achadosEPerdidos = new AchadosEPerdidos(data);
        repository.save(achadosEPerdidos);
    }

}
