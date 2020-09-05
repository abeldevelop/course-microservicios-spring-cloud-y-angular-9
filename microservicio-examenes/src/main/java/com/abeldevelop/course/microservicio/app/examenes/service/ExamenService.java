package com.abeldevelop.course.microservicio.app.examenes.service;

import com.abeldevelop.course.microservicio.common.service.CommonService;
import com.abeldevelop.course.microservicio.commons.examenes.model.Asignatura;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import java.util.List;

public interface ExamenService extends CommonService<Examen> {

  List<Examen> findByNombre(String nombre);

  List<Asignatura> findAllAsignaturas();
}
