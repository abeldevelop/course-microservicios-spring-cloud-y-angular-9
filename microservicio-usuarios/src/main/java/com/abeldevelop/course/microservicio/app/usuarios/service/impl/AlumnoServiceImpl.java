package com.abeldevelop.course.microservicio.app.usuarios.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.course.microservicio.app.usuarios.repository.AlumnoRepository;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>
    implements AlumnoService {

  @Transactional(readOnly = true)
  @Override
  public List<Alumno> findByNombreOrApellido(String termino) {
    return repository.findByNombreOrApellido(termino);
  }
}
