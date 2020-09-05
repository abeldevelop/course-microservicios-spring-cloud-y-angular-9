package com.abeldevelop.course.microservicio.app.cursos.model;

import com.abeldevelop.course.microservicio.commons.alumnos.model.Alumno;
import com.abeldevelop.course.microservicio.commons.examenes.model.Examen;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@ToString
@Entity
@Table(name = "cursos")
public class Curso {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @NotEmpty
  @Column(name = "nombre")
  private String nombre;

  @Column(name = "create_at")
  @Temporal(TemporalType.TIMESTAMP)
  private Date createAt;

  @JsonIgnoreProperties(
      value = {"curso"},
      allowSetters = true)
  @OneToMany(
      mappedBy = "curso",
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<CursoAlumno> cursoAlumnos;

  @Transient private List<Alumno> alumnos;

  @ManyToMany(fetch = FetchType.LAZY)
  private List<Examen> examenes;

  public Curso() {
    this.alumnos = new ArrayList<>();
    this.examenes = new ArrayList<>();
    this.cursoAlumnos = new ArrayList<>();
  }

  @PrePersist
  public void prePersist() {
    this.createAt = new Date();
  }

  public void addAlumno(Alumno alumno) {
    this.alumnos.add(alumno);
  }

  public void removeAlumno(Alumno alumno) {
    this.alumnos.remove(alumno);
  }

  public void addExamen(Examen examen) {
    this.examenes.add(examen);
  }

  public void removeExamen(Examen examen) {
    this.examenes.remove(examen);
  }

  public void addCursoAlumno(CursoAlumno cursoAlumno) {
    this.cursoAlumnos.add(cursoAlumno);
  }

  public void removeCursoAlumno(CursoAlumno cursoAlumno) {
    this.cursoAlumnos.remove(cursoAlumno);
  }
}
