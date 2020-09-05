package com.abeldevelop.course.microservicio.app.respuestas.service.impl;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;
import com.abeldevelop.course.microservicio.app.respuestas.repository.RespuestaRepository;
import com.abeldevelop.course.microservicio.app.respuestas.service.RespuestaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespuestaServiceImpl implements RespuestaService {

  @Autowired private RespuestaRepository respuestaRepository;

  @Transactional
  @Override
  public List<Respuesta> saveAll(List<Respuesta> respuestas) {
    return respuestaRepository.saveAll(respuestas);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Respuesta> findRespuestaByAlumnoAndExamen(Long alumnoId, Long examenId) {
    return respuestaRepository.findRespuestaByAlumnoAndExamen(alumnoId, examenId);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
    return respuestaRepository.findExamenesIdsConRespuestasByAlumno(alumnoId);
  }
}
