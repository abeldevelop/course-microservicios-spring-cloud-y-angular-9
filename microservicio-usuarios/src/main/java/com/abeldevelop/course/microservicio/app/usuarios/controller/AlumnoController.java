package com.abeldevelop.course.microservicio.app.usuarios.controller;

import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.controller.CommonController;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@AllArgsConstructor
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService> {

  @GetMapping("/alumnos-por-curso")
  public ResponseEntity<?> obtenerAlumnosPorCurso(@RequestParam List<Long> ids) {
    return ResponseEntity.ok(service.findAllById(ids));
  }

  @GetMapping("/uploads/img/{id}")
  public ResponseEntity<?> verFoto(@PathVariable Long id) {
    Optional<Alumno> alumnoInDb = service.findById(id);
    if (!alumnoInDb.isPresent() || alumnoInDb.get().getFoto() == null) {
      return ResponseEntity.notFound().build();
    }

    Resource imagen = new ByteArrayResource(alumnoInDb.get().getFoto());

    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(imagen);
  }

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

  @PostMapping("/crear-con-foto")
  public ResponseEntity<?> crearConFoto(
      @Valid Alumno alumno, BindingResult result, @RequestParam MultipartFile archivo)
      throws IOException {
    if (!archivo.isEmpty()) {
      alumno.setFoto(archivo.getBytes());
    }
    return super.crear(alumno, result);
  }

  @PutMapping("/editar-con-foto/{id}")
  public ResponseEntity<?> editarConFoto(
      @PathVariable Long id,
      @Valid Alumno alumno,
      BindingResult result,
      @RequestParam MultipartFile archivo)
      throws IOException {
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

    if (!archivo.isEmpty()) {
      alumnoInDb.get().setFoto(archivo.getBytes());
    }

    return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoInDb.get()));
  }
}
