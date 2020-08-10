package com.abeldevelop.course.microservicio.app.usuarios.controller;

import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.controller.CommonController;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class AlumnoController extends CommonController<Alumno, AlumnoService>{

    @PutMapping("/{id}")
    public ResponseEntity<?> editar(@PathVariable Long id, @RequestBody Alumno alumno) {
	Optional<Alumno> alumnoInDb = service.findById(id);
	if(!alumnoInDb.isPresent()) {
	    return ResponseEntity.notFound().build();
	}
	
	alumnoInDb.get().setNombre(alumno.getNombre());
	alumnoInDb.get().setApellido(alumno.getApellido());
	alumnoInDb.get().setEmail(alumno.getEmail());
	
	return ResponseEntity.status(HttpStatus.CREATED).body(service.save(alumnoInDb.get()));
    }
    
}
