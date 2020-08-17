package com.abeldevelop.course.microservicio.app.respuestas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EntityScan({
  "com.abeldevelop.course.microservicio.app.respuestas.entity",
  "com.abeldevelop.course.microservicio.commons.alumnos.model",
  "com.abeldevelop.course.microservicio.commons.examenes.model"
})
@SpringBootApplication
public class MicroservicioRespuestasApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioRespuestasApplication.class, args);
  }
}
