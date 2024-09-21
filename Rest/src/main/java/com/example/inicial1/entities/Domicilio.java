package com.example.inicial1.entities;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.engine.internal.Cascade;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="domicilio")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class Domicilio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String calle;
    private int numero;

    @Builder.Default
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "fk_domicilio")
    private List<Localidad> localidades = new ArrayList<>();
}