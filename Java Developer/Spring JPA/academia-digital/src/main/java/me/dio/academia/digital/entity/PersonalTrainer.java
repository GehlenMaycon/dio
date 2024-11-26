package me.dio.academia.digital.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_personaltrainer")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PersonalTrainer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String sobrenome;

    private Boolean contratadoDaAcademia;

    private LocalDate dataDeNascimento;

    private Character sexo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_matricula")
    private Matricula aluno;
}
