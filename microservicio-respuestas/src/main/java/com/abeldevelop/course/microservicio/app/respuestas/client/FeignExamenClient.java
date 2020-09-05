package com.abeldevelop.course.microservicio.app.respuestas.client;

import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "microservicio-examenes")
public interface FeignExamenClient {

  @GetMapping("/{id}")
  Examen obtenerExamenPorId(@PathVariable Long id);
}
