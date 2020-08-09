package com.abeldevelop.course.microservicio.app.usuarios.service;

import java.util.List;
import java.util.Optional;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;

public interface AlumnoService {
    
    List<Alumno> findAll();
    Optional<Alumno> findById(Long id);
    Alumno save(Alumno alumno);
    void deleteById(Long id);
    
}
