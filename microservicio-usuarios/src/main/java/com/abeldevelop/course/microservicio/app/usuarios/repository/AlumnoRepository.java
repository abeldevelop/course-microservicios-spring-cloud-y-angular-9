package com.abeldevelop.course.microservicio.app.usuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

  @Query("SELECT a FROM Alumno a WHERE a.nombre like %:termino% OR a.apellido like %:termino%")
  public List<Alumno> findByNombreOrApellido(@Param("termino") String termino);
}
