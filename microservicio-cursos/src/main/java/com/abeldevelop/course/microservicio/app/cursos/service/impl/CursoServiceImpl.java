package com.abeldevelop.course.microservicio.app.cursos.service.impl;

import com.abeldevelop.course.microservicio.app.cursos.client.AlumnoFeignClient;
import com.abeldevelop.course.microservicio.app.cursos.client.RespuestaFeignClient;
import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.app.cursos.repository.CursoRepository;
import com.abeldevelop.course.microservicio.app.cursos.service.CursoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository>
    implements CursoService {

  @Autowired private RespuestaFeignClient respuestaFeignClient;
  @Autowired private AlumnoFeignClient alumnoFeignClient;

  @Transactional(readOnly = true)
  @Override
  public Curso findCursoByAlumnoId(Long alumnoId) {
    return repository.findCursoByAlumnoId(alumnoId);
  }

  @Override
  public List<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
    return respuestaFeignClient.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
  }

  @Override
  public List<Alumno> obtenerAlumnosPorCurso(List<Long> ids) {
    return alumnoFeignClient.obtenerAlumnosPorCurso(ids);
  }

  @Transactional
  @Override
  public void eliminarCursoAlumnoPorId(Long id) {
    repository.eliminarCursoAlumnoPorId(id);
  }
}
