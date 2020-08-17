package com.abeldevelop.course.microservicio.app.cursos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EntityScan({
  "com.abeldevelop.course.microservicio.commons.alumnos.model",
  "com.abeldevelop.course.microservicio.app.cursos.model",
  "com.abeldevelop.course.microservicio.commons.examenes.model"
})
@SpringBootApplication
public class MicroservicioCursosApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioCursosApplication.class, args);
  }
}
