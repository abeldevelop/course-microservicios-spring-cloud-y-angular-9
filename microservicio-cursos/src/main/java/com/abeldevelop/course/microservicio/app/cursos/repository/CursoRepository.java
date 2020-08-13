package com.abeldevelop.course.microservicio.app.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {

  @Query("SELECT c FROM Curso c JOIN FETCH c.alumnos a WHERE a.id=:alumnoId")
  public Curso findCursoByAlumnoId(@Param("alumnoId") Long alumnoId);
}
