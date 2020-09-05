package com.abeldevelop.course.microservicio.app.examenes.repository;

import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ExamenRepository extends JpaRepository<Examen, Long> {

  @Query("SELECT e FROM Examen e WHERE e.nombre like %:nombre%")
  List<Examen> findByNombre(@Param("nombre") String nombre);
}
