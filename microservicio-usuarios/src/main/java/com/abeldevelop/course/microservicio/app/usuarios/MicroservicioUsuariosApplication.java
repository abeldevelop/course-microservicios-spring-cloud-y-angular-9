package com.abeldevelop.course.microservicio.app.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class MicroservicioUsuariosApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioUsuariosApplication.class, args);
  }
}
