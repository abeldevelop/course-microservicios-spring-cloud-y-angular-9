package com.abeldevelop.course.microservicio.app.examenes.service.impl;

import com.abeldevelop.course.microservicio.app.examenes.repository.AsignaturaRepository;
import com.abeldevelop.course.microservicio.app.examenes.repository.ExamenRepository;
import com.abeldevelop.course.microservicio.app.examenes.service.ExamenService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;
import com.abeldevelop.course.microservicio.commons.examenes.model.Asignatura;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ExamenServiceImpl extends CommonServiceImpl<Examen, ExamenRepository>
    implements ExamenService {

  @Autowired private AsignaturaRepository asignaturaRepository;

  @Transactional(readOnly = true)
  @Override
  public List<Examen> findByNombre(String nombre) {
    return repository.findByNombre(nombre);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Asignatura> findAllAsignaturas() {
    return asignaturaRepository.findAll();
  }
}
