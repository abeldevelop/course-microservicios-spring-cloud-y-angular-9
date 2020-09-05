package com.abeldevelop.course.microservicio.app.examenes.controller;

import com.abeldevelop.course.microservicio.app.examenes.service.ExamenService;
import com.abeldevelop.course.microservicio.common.controller.CommonController;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import java.util.Optional;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExamenController extends CommonController<Examen, ExamenService> {

  @PutMapping("/{id}")
  public ResponseEntity<?> editar(
      @PathVariable Long id, @Valid @RequestBody Examen examen, BindingResult result) {
    if (result.hasErrors()) {
      return validar(result);
    }
    Optional<Examen> examenInDb = service.findById(id);
    if (!examenInDb.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    examenInDb.get().setNombre(examen.getNombre());

    examenInDb.get().getPreguntas().stream()
        .filter(p -> (!examen.getPreguntas().contains(p)))
        .forEach(examenInDb.get()::removePregunta);

    examenInDb.get().setPreguntas(examen.getPreguntas());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(examenInDb.get()));
  }

  @GetMapping("/filtrar/{nombre}")
  public ResponseEntity<?> filtrar(@PathVariable String nombre) {
    return ResponseEntity.ok(service.findByNombre(nombre));
  }

  @GetMapping("/asignaturas")
  public ResponseEntity<?> listarAsignaturas() {
    return ResponseEntity.ok(service.findAllAsignaturas());
  }
}
