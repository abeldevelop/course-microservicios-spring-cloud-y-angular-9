package com.abeldevelop.course.microservicio.app.cursos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import com.abeldevelop.course.microservicio.app.cursos.service.CursoService;
import com.abeldevelop.course.microservicio.common.controller.CommonController;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CursoController extends CommonController<Curso, CursoService> {

  @PutMapping("/{id}")
  public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Curso curso) {
    Optional<Curso> cursoInDb = service.findById(id);
    if (!cursoInDb.isPresent()) {
      return ResponseEntity.notFound().build();
    }

    cursoInDb.get().setNombre(curso.getNombre());

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoInDb.get()));
  }

  @PutMapping("/{id}/asignar-alumnos")
  public ResponseEntity<?> asignarAlumnos(
      @PathVariable Long id, @RequestBody List<Alumno> alumnos) {
    Optional<Curso> cursoInDb = service.findById(id);
    if (!cursoInDb.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    alumnos.forEach(a -> cursoInDb.get().addAlumno(a));
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoInDb.get()));
  }

  @PutMapping("/{id}/eliminar-alumno")
  public ResponseEntity<?> eliminarAlumno(@PathVariable Long id, @RequestBody Alumno alumno) {
    Optional<Curso> cursoInDb = service.findById(id);
    if (!cursoInDb.isPresent()) {
      return ResponseEntity.notFound().build();
    }
    cursoInDb.get().removeAlumno(alumno);
    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(cursoInDb.get()));
  }

  @GetMapping("/alumno/{id}")
  public ResponseEntity<?> buscarPorAlumno(@PathVariable Long id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.findCursoByAlumnoId(id));
  }
}
