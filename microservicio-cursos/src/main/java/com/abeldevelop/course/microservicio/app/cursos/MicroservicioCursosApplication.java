package com.abeldevelop.course.microservicio.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EntityScan({
  "com.abeldevelop.course.microservicio.commons.alumnos.model",
  "com.abeldevelop.course.microservicio.app.cursos.model"
})
@SpringBootApplication
public class MicroservicioCursosApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioCursosApplication.class, args);
  }
}
