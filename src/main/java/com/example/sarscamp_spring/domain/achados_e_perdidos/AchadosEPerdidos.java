package com.example.sarscamp_spring.domain.achados_e_perdidos;

import java.time.LocalDateTime;

import com.example.sarscamp_spring.dtos.CreateAchadosEPerididosDTO;

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

@Table(name = "achadios_perdidos")
@Entity(name = "achadios_perdidos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class AchadosEPerdidos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String material;
    private String local;
    private int campus;
    private LocalDateTime data;

    public AchadosEPerdidos(CreateAchadosEPerididosDTO data) {
        this.material = data.material();
        this.local = data.local();
        this.campus = data.campus();
        this.data = LocalDateTime.now();
    }
}
