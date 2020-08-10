package com.abeldevelop.course.microservicio.common.service;

import java.util.List;
import java.util.Optional;

public interface CommonService<E> {
    
    List<E> findAll();
    Optional<E> findById(Long id);
    E save(E alumno);
    void deleteById(Long id);
    
}
