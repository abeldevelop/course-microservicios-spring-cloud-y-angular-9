package com.abeldevelop.course.microservicio.app.usuarios.controller;

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

import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.controller.CommonController;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

  @PutMapping("/{id}")
  public ResponseEntity<?> editar(
      @PathVariable Long id, @Valid @RequestBody Alumno alumno, BindingResult result) {
    if (result.hasErrors()) {
      return validar(result);
    }
    Optional<Alumno> alumnoInDb = service.findById(id);
    if (!alumnoInDb.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    alumnoInDb.get().setNombre(alumno.getNombre());
    alumnoInDb.get().setApellido(alumno.getApellido());
    alumnoInDb.get().setEmail(alumno.getEmail());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoInDb.get()));
  }

  @GetMapping("/filtrar/{termino}")
  public ResponseEntity<?> filtrar(@PathVariable String termino) {
    return ResponseEntity.status(HttpStatus.OK).body(service.findByNombreOrApellido(termino));
  }
}
