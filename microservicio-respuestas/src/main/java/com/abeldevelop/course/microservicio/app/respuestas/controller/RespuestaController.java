package com.abeldevelop.course.microservicio.app.respuestas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.course.microservicio.app.respuestas.entity.Respuesta;
import com.abeldevelop.course.microservicio.app.respuestas.service.RespuestaService;

@RestController
public class RespuestaController {

  @Autowired private RespuestaService respuestaService;

  @PostMapping
  public ResponseEntity<?> crear(@RequestBody List<Respuesta> respuestas) {
    return ResponseEntity.status(HttpStatus.CREATED).body(respuestaService.saveAll(respuestas));
  }

  @GetMapping("/alumno/{alumnoId}/examen/{examenId}")
  public ResponseEntity<?> obtenerRespuestaPorAlumnoAndExamen(
      @PathVariable Long alumnoId, @PathVariable Long examenId) {
    return ResponseEntity.ok()
        .body(respuestaService.findRespuestaByAlumnoAndExamen(alumnoId, examenId));
  }

  @GetMapping("/alumno/{alumnoId}/examenes-respondidos")
  public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Long alumnoId) {
    return ResponseEntity.ok()
        .body(respuestaService.findExamenesIdsConRespuestasByAlumno(alumnoId));
  }
}
