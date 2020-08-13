package com.abeldevelop.course.microservicio.app.usuarios.service;

import java.util.List;

import com.abeldevelop.course.microservicio.common.service.CommonService;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;

public interface AlumnoService extends CommonService<Alumno> {

  List<Alumno> findByNombreOrApellido(String termino);
}
