package com.example.inicial1.services;

import com.example.inicial1.entities.Domicilio;
import com.example.inicial1.repositories.DomicilioRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DomicilioServices implements BaseService<Domicilio> {

    private DomicilioRepository domicilioRepository;

    public DomicilioServices(DomicilioRepository domicilioRepository) {
        this.domicilioRepository= domicilioRepository;
    }

    @Override
    @Transactional
    public List<Domicilio> findAll() throws Exception {
        try {
            List<Domicilio> entities = domicilioRepository.findAll();
            return entities;

        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
    }

    @Override
    @Transactional

    public Domicilio findById(Long id) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            return entityOptional.get();
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional

    public Domicilio save(Domicilio entity) throws Exception {
        try {
            entity = domicilioRepository.save(entity);
            return entity;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional

    public Domicilio update(Long id, Domicilio entity) throws Exception {
        try {
            Optional<Domicilio> entityOptional = domicilioRepository.findById(id);
            Domicilio domicilio = entityOptional.get();
            domicilio = domicilioRepository.save(entity);
            return domicilio;
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    @Override
    @Transactional

    public Boolean delete(Long id) throws Exception {
        try {
            if (domicilioRepository.existsById(id)){
                domicilioRepository.deleteById(id);
                return true;
            }else{
                throw new Exception();
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }
}
