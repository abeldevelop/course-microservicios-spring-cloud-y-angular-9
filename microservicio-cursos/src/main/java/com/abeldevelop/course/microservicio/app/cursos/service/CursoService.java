package com.abeldevelop.course.microservicio.app.cursos.service;

import java.util.List;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.common.service.CommonService;

public interface CursoService extends CommonService<Curso> {

  Curso findCursoByAlumnoId(Long alumnoId);

  List<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);
}
