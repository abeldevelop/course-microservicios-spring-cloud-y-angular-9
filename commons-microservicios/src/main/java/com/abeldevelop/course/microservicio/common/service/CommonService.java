package com.abeldevelop.course.microservicio.common.service;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CommonService<E> {

  Page<E> findAll(Pageable pageable);

  List<E> findAll();

  Optional<E> findById(Long id);

  E save(E alumno);

  void deleteById(Long id);
}
