package com.abeldevelop.course.microservicio.app.respuestas.repository;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface RespuestaRepository extends MongoRepository<Respuesta, String> {

  @Query("{'alumnoId': :alumnoId'. 'preguntaId': {$in: :preguntaIds}}")
  List<Respuesta> findRespuestaByAlumnoIdAndPreguntaIds(Long alumnoId, List<Long> preguntaIds);

  List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId);
}
