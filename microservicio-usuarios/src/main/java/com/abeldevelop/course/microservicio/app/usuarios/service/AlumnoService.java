package com.abeldevelop.course.microservicio.app.usuarios.service;

import com.abeldevelop.course.microservicio.common.service.CommonService;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;

public interface AlumnoService extends CommonService<Alumno> {

  List<Alumno> findByNombreOrApellido(String termino);

  List<Alumno> findAllById(List<Long> ids);

  void eliminarCursoAlumnoPorId(Long id);
}
