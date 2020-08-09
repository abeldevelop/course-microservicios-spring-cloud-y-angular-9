package com.abeldevelop.course.microservicio.app.usuarios.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AlumnoController {

    private final AlumnoService alumnoService;
    
    @GetMapping
    public ResponseEntity<?> listar() {
	return ResponseEntity.ok().body(alumnoService.findAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> ver(@PathVariable Long id) {
	Optional<Alumno> alumno = alumnoService.findById(id);
	
	if(!alumno.isPresent()) {
	    return ResponseEntity.notFound().build();
	}
	
	return ResponseEntity.ok().body(alumno.get());
    }
    
    @PostMapping
    public ResponseEntity<?> crear(@RequestBody Alumno alumno) {
	return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumno));
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Alumno alumno) {
	Optional<Alumno> alumnoInDb = alumnoService.findById(id);
	if(!alumnoInDb.isPresent()) {
	    return ResponseEntity.notFound().build();
	}
	
	alumnoInDb.get().setNombre(alumno.getNombre());
	alumnoInDb.get().setApellido(alumno.getApellido());
	alumnoInDb.get().setEmail(alumno.getEmail());
	
	return ResponseEntity.status(HttpStatus.CREATED).body(alumnoService.save(alumnoInDb.get()));
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminar(@PathVariable Long id) {
	alumnoService.deleteById(id);
	return ResponseEntity.noContent().build();
    }
    
}
