package com.abeldevelop.course.microservicio.app.cursos.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.app.cursos.repository.CursoRepository;
import com.abeldevelop.course.microservicio.app.cursos.service.CursoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;

@Service
public class CursoServiceImpl extends CommonServiceImpl<Curso, CursoRepository>
    implements CursoService {

  @Transactional(readOnly = true)
  @Override
  public Curso findCursoByAlumnoId(Long alumnoId) {
    return repository.findCursoByAlumnoId(alumnoId);
  }
}
