package com.example.inicial1.services;

import java.util.List;

public interface BaseService <E> {
    public List<E> findAll() throws Exception;
    public E findById(Long id) throws Exception;
    public E save(E entity) throws Exception;
    public E update(Long id, E entity) throws Exception;
    public Boolean delete(Long id) throws Exception;

}

