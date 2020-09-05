package com.abeldevelop.course.microservicio.app.respuestas.service.impl;

import com.abeldevelop.course.microservicio.app.respuestas.client.FeignExamenClient;
import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;
import com.abeldevelop.course.microservicio.app.respuestas.repository.RespuestaRepository;
import com.abeldevelop.course.microservicio.app.respuestas.service.RespuestaService;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RespuestaServiceImpl implements RespuestaService {

  @Autowired private RespuestaRepository respuestaRepository;

  @Autowired private FeignExamenClient feignExamenClient;

  @Transactional
  @Override
  public List<Respuesta> saveAll(List<Respuesta> respuestas) {
    return respuestaRepository.saveAll(respuestas);
  }

  @Override
  public List<Respuesta> findRespuestaByAlumnoAndExamen(Long alumnoId, Long examenId) {
    Examen examen = feignExamenClient.obtenerExamenPorId(examenId);
    List<Long> preguntaIds =
        examen.getPreguntas().stream().map(p -> p.getId()).collect(Collectors.toList());

    List<Respuesta> respuestas =
        respuestaRepository.findRespuestaByAlumnoIdAndPreguntaIds(alumnoId, preguntaIds);
    respuestas =
        respuestas
            .stream()
            .map(
                r -> {
                  examen
                      .getPreguntas()
                      .forEach(
                          p -> {
                            if (p.getId().longValue() == r.getPreguntaId().longValue()) {
                              r.setPregunta(p);
                            }
                          });
                  return r;
                })
            .collect(Collectors.toList());
    return respuestas;
  }

  @Transactional(readOnly = true)
  @Override
  public List<Long> findExamenesIdsConRespuestasByAlumno(Long alumnoId) {
    return respuestaRepository.findExamenesIdsConRespuestasByAlumno(alumnoId);
  }
}
