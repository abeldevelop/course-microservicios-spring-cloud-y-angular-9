package com.abeldevelop.course.microservicio.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@EnableDiscoveryClient
@EntityScan({"com.abeldevelop.course.microservicio.commons.alumnos.model"})
@SpringBootApplication
public class MicroservicioUsuariosApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioUsuariosApplication.class, args);
  }
}
