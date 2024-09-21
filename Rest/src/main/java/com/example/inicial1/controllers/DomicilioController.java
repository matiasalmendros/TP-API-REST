package com.example.inicial1.controllers;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.services.DomicilioServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/domicilios")
public class DomicilioController {

    private DomicilioServices domicilioServices;

    public DomicilioController(DomicilioServices domicilioServices) {
        this.domicilioServices = domicilioServices;
    }

    @GetMapping("")
    public ResponseEntity<?> getAll() {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(domicilioServices.findAll());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getOne(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(domicilioServices.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PostMapping("")
    public ResponseEntity<?> save(@RequestBody Domicilio entity) {
        System.out.println("Estos datos los tomo del cuerpo del Formulario");
        System.out.println("Calle: " + entity.getCalle());

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(domicilioServices.save(entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@PathVariable Long id, @RequestBody Domicilio entity) {
        System.out.println("EL ID LO TOMO DE LA URL");
        System.out.println("ID: " + entity.getId());
        System.out.println("Calle: " + entity.getCalle());

        try {
            return ResponseEntity.status(HttpStatus.OK)
                    .body(domicilioServices.update(id, entity));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.NO_CONTENT)
                    .body(domicilioServices.delete(id));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("{\"error\":\"Error, por favor intente más tarde\"}");
        }
    }
}
