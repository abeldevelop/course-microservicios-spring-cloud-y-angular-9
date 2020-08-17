package com.abeldevelop.course.microservicio.app.respuestas.service;

import java.util.List;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;

public interface RespuestaService {

  List<Respuesta> saveAll(List<Respuesta> respuestas);

  List<Respuesta> findRespuestaByAlumnoAndExamen(Long alumnoId, Long examenId);

  List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
