package com.example.inicial1.repositories;

import com.example.inicial1.entities.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Long> {
    // Aquí puedes agregar métodos personalizados si es necesario
}