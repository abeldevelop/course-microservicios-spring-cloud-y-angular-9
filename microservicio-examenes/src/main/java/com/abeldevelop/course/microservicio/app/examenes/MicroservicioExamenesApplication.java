package com.abeldevelop.course.microservicio.app.examenes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@EntityScan({"com.abeldevelop.course.microservicio.commons.examenes.model"})
@SpringBootApplication
public class MicroservicioExamenesApplication {

  public static void main(String[] args) {
    SpringApplication.run(MicroservicioExamenesApplication.class, args);
  }
}
