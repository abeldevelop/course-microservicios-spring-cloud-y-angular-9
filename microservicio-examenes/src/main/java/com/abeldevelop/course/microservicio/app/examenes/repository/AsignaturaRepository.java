package com.abeldevelop.course.microservicio.app.examenes.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abeldevelop.course.microservicio.commons.examenes.model.Asignatura;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {}
