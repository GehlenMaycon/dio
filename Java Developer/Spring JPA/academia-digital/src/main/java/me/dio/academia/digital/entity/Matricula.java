package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_matricula")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Matricula {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_aluno")
  private Aluno aluno;

  private LocalDateTime dataDaMatricula = LocalDateTime.now();

  @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
  @JsonIgnore
  private List<PersonalTrainer> personalTrainer = new ArrayList<>();
}
