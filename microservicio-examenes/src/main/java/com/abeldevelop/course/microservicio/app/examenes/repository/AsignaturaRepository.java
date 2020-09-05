package com.abeldevelop.course.microservicio.app.examenes.repository;

import com.abeldevelop.course.microservicio.commons.examenes.model.Asignatura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AsignaturaRepository extends JpaRepository<Asignatura, Long> {}
