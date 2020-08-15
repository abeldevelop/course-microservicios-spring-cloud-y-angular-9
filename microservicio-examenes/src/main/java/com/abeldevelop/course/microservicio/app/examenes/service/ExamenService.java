package com.abeldevelop.course.microservicio.app.examenes.service;

import java.util.List;

import com.abeldevelop.course.microservicio.common.service.CommonService;
import com.abeldevelop.course.microservicio.commons.examenes.model.Asignatura;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;

public interface ExamenService extends CommonService<Examen> {

  List<Examen> findByNombre(String nombre);

  List<Asignatura> findAllAsignaturas();
}
