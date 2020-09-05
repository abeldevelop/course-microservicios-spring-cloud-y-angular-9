package com.abeldevelop.course.microservicio.app.respuestas.entity;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import com.abeldevelop.course.microservicio.commons.examenes.model.Pregunta;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "respuestas")
public class Respuesta {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "texto")
  private String texto;

  @Transient private Alumno alumno;

  @Column(name = "alumno_id")
  private Long alumnoId;

  @OneToOne(fetch = FetchType.LAZY)
  private Pregunta pregunta;
}
