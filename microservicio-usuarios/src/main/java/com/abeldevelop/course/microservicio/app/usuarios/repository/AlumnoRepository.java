package com.abeldevelop.course.microservicio.app.usuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.course.microservicio.app.usuarios.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {}
