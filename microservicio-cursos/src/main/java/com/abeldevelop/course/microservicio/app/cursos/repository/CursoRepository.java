package com.abeldevelop.course.microservicio.app.cursos.repository;

import com.abeldevelop.course.microservicio.app.cursos.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CursoRepository extends JpaRepository<Curso, Long> {

  @Query("SELECT c FROM Curso c JOIN FETCH c.cursoAlumnos a WHERE a.alumnoId=:alumnoId")
  Curso findCursoByAlumnoId(@Param("alumnoId") Long alumnoId);

  @Modifying
  @Query("DELETE FROM CursoAlumno ca WHERE ca.alumnoId=:id")
  void eliminarCursoAlumnoPorId(@Param("id") Long id);
}
