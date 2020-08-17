package com.abeldevelop.course.microservicio.app.cursos.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.course.microservicio.app.cursos.client.RespuestaFeignClient;
import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.app.cursos.repository.CursoRepository;
import com.abeldevelop.course.microservicio.app.cursos.service.CursoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository>
    implements CursoService {

  @Autowired private RespuestaFeignClient respuestaFeignClient;

  @Transactional(readOnly = true)
  @Override
  public Curso findCursoByAlumnoId(Long alumnoId) {
    return repository.findCursoByAlumnoId(alumnoId);
  }

  @Override
  public List<Long> obtenerExamenesIdsConRespuestasAlumno(Long alumnoId) {
    return respuestaFeignClient.obtenerExamenesIdsConRespuestasAlumno(alumnoId);
  }
}
