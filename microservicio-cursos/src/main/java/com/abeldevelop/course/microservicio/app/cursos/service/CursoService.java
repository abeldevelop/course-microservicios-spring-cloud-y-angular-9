package com.abeldevelop.course.microservicio.app.cursos.service;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.common.service.CommonService;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;

public interface CursoService extends CommonService<Curso> {

  Curso findCursoByAlumnoId(Long alumnoId);

  List<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId);

  List<Alumno> obtenerAlumnosPorCurso(List<Long> ids);

  void eliminarCursoAlumnoPorId(Long id);
}
