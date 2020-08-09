package com.abeldevelop.course.microservicio.app.usuarios.service.impl;

import java.util.List;
import java.util.Optional;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;
import com.abeldevelop.course.microservicio.app.usuarios.repository.AlumnoRepository;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlumnoServiceImpl implements AlumnoService {
    
    private final AlumnoRepository alumnoRepository;
    
    @Transactional(readOnly = true)
    @Override
    public List<Alumno> findAll() {
	return alumnoRepository.findAll();
    }
    
    @Transactional(readOnly = true)
    @Override
    public Optional<Alumno> findById(Long id) {
	return alumnoRepository.findById(id);
    }
    
    @Transactional
    @Override
    public Alumno save(Alumno alumno) {
	return alumnoRepository.save(alumno);
    }
    
    @Transactional
    @Override
    public void deleteById(Long id) {
	alumnoRepository.deleteById(id);
    }
    
}
