package com.abeldevelop.course.microservicio.app.respuestas.entity;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import com.abeldevelop.course.microservicio.commons.examenes.model.Pregunta;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Document(collection = "respuestas")
public class Respuesta {

  @EqualsAndHashCode.Include @Id private String id;

  private String texto;

  @Transient private Alumno alumno;

  private Long alumnoId;

  @Transient private Pregunta pregunta;

  private Long preguntaId;
}
