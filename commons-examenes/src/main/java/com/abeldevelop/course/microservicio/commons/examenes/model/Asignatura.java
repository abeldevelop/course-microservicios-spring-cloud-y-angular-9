package com.abeldevelop.course.microservicio.commons.examenes.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.ArrayList;
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
import javax.persistence.Table;
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
@Table(name = "asignaturas")
public class Asignatura {

  @EqualsAndHashCode.Include
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "nombre")
  private String nombre;

  @JsonIgnoreProperties(value = {"hijos", "handler", "hibernateLazyInitializer"})
  @ManyToOne(fetch = FetchType.LAZY)
  private Asignatura padre;

  @JsonIgnoreProperties(
      value = {"padre", "handler", "hibernateLazyInitializer"},
      allowSetters = true)
  @OneToMany(mappedBy = "padre", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<Asignatura> hijos;

  public Asignatura() {
    this.hijos = new ArrayList<>();
  }
}
