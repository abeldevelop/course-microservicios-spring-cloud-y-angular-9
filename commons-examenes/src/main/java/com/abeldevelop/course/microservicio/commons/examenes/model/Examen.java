package com.abeldevelop.course.microservicio.commons.examenes.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AccessLevel;
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
@Table(name = "examenes")
public class Examen {

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

  @Setter(AccessLevel.NONE)
  @JsonIgnoreProperties(
      value = {"examen"},
      allowSetters = true)
  @OneToMany(
      mappedBy = "examen",
      fetch = FetchType.LAZY,
      cascade = CascadeType.ALL,
      orphanRemoval = true)
  private List<Pregunta> preguntas;

  @NotNull
  @ManyToOne(fetch = FetchType.LAZY)
  private Asignatura asignatura;

  @PrePersist
  public void prePersist() {
    this.createAt = new Date();
  }

  public Examen() {
    this.preguntas = new ArrayList<>();
  }

  public void addPregunta(Pregunta pregunta) {
    pregunta.setExamen(this);
    this.preguntas.add(pregunta);
  }

  public void removePregunta(Pregunta pregunta) {
    pregunta.setExamen(null);
    this.preguntas.remove(pregunta);
  }

  public void setPreguntas(List<Pregunta> preguntas) {
    this.preguntas.clear();
    preguntas.forEach(this::addPregunta);
  }
}
