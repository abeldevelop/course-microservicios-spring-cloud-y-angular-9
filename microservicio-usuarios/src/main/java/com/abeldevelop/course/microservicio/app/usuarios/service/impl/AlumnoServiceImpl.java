package com.abeldevelop.course.microservicio.app.usuarios.service.impl;

import com.abeldevelop.course.microservicio.app.usuarios.client.CursoFeignClient;
import com.abeldevelop.course.microservicio.app.usuarios.repository.AlumnoRepository;
import com.abeldevelop.course.microservicio.app.usuarios.service.AlumnoService;
import com.abeldevelop.course.microservicio.common.service.impl.CommonServiceImpl;
import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class AlumnoServiceImpl extends CommonServiceImpl<Alumno, AlumnoRepository>
    implements AlumnoService {

  private final CursoFeignClient cursoFeignClient;

  @Transactional(readOnly = true)
  @Override
  public List<Alumno> findByNombreOrApellido(String termino) {
    return repository.findByNombreOrApellido(termino);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Alumno> findAllById(List<Long> ids) {
    return repository.findAllById(ids);
  }

  @Override
  public void eliminarCursoAlumnoPorId(Long id) {
    cursoFeignClient.eliminarCursoAlumnoPorId(id);
  }

  @Transactional
  @Override
  public void deleteById(Long id) {
    super.deleteById(id);
    eliminarCursoAlumnoPorId(id);
  }

  @Transactional(readOnly = true)
  @Override
  public Page<Alumno> findAll(Pageable pageable) {
    return repository.findAllByOrderByIdAsc(pageable);
  }

  @Transactional(readOnly = true)
  @Override
  public List<Alumno> findAll() {
    return repository.findAllByOrderByIdAsc();
  }
}
