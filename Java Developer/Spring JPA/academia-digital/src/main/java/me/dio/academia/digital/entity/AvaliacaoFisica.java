package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_avaliacoes")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class AvaliacaoFisica {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_aluno")
  private Aluno aluno;

  private LocalDateTime dataDaAvaliacao = LocalDateTime.now();

  private double peso;

  private double altura;

}
