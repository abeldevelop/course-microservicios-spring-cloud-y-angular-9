package com.abeldevelop.course.microservicio.app.usuarios.repository;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AlumnoRepository extends JpaRepository<Alumno, Long> {

  @Query(
      "SELECT a FROM Alumno a WHERE UPPER(a.nombre) like UPPER(CONCAT('%', :termino, '%')) OR UPPER(a.apellido) like UPPER(CONCAT('%', :termino, '%'))")
  public List<Alumno> findByNombreOrApellido(@Param("termino") String termino);
}
