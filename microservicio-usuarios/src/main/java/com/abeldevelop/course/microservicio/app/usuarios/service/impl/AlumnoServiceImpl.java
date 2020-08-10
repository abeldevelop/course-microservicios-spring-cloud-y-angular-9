package com.abeldevelop.course.microservicio.app.usuarios.service.impl;

import org.springframework.stereotype.Service;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;
import com.abeldevelop.course.microservicio.app.usuarios.repository.AlumnoRepository;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>
    implements AlumnoService {}
