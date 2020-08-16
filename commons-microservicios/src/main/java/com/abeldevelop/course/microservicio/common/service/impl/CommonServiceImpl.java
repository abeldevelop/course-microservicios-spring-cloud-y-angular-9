package com.abeldevelop.course.microservicio.common.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import com.abeldevelop.course.microservicio.common.service.CommonService;

public class CommonServiceImpl<E, R extends JpaRepository<E, Long>> implements CommonService<E> {

  @Autowired protected R repository;

  @Transactional(readOnly = true)
  @Override
  public Page<E> findAll(Pageable pageable) {
    return repository.findAll(pageable);
  }

  @Transactional(readOnly = true)
  @Override
  public List<E> findAll() {
    return repository.findAll();
  }

  @Transactional(readOnly = true)
  @Override
  public Optional<E> findById(Long id) {
    return repository.findById(id);
  }

  @Transactional
  @Override
  public E save(E entity) {
    return repository.save(entity);
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    repository.deleteById(id);
  }
}
