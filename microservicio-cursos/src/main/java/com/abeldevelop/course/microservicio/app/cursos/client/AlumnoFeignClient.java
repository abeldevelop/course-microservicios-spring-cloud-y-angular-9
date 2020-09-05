package com.abeldevelop.course.microservicio.app.cursos.client;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "microservicio-usuarios")
public interface AlumnoFeignClient {

  @GetMapping("/alumnos-por-curso")
  List<Alumno> obtenerAlumnosPorCurso(@RequestParam List<Long> ids);
}
