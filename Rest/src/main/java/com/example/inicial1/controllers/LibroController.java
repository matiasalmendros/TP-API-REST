package com.example.inicial1.controllers;

import com.example.inicial1.entities.Libro;
import com.example.inicial1.services.LibroServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/libros")
public class LibroController {

    private LibroServices libroServices;

    public LibroController(LibroServices libroServices) {
        this.libroServices = libroServices;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(libroServices.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(libroServices.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Libro entity) {
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Titulo: " + entity.getTitulo());

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(libroServices.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Libro entity) {
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("ID: " + entity.getId());
        System.out.println("Titulo: " + entity.getTitulo());

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(libroServices.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(libroServices.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
