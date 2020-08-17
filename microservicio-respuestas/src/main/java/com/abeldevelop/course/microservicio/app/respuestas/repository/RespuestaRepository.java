package com.abeldevelop.course.microservicio.app.respuestas.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;

public interface RespuestaRepository extends JpaRepository<Respuesta, Long> {

  @Query(
      "SELECT r FROM Respuesta r JOIN FETCH r.alumno a JOIN FETCH r.pregunta p JOIN FETCH p.examen e WHERE a.id = :alumnoId AND e.id = :examenId")
  List<Respuesta> findRespuestaByAlumnoAndExamen(Long alumnoId, Long examenId);

  @Query(
      "SELECT e.id FROM Respuesta r JOIN r.alumno a JOIN r.pregunta p JOIN p.examen e WHERE a.id = :alumnoId GROUP BY e.id")
  List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
