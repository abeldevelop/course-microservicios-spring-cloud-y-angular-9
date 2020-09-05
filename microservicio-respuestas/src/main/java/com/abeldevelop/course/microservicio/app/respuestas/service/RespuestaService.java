package com.abeldevelop.course.microservicio.app.respuestas.service;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;
import java.util.List;

public interface RespuestaService {

  List<Respuesta> saveAll(List<Respuesta> respuestas);

  List<Respuesta> findRespuestaByAlumnoAndExamen(Long alumnoId, Long examenId);

  List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
