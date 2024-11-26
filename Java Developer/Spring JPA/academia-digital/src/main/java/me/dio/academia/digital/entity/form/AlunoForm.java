package me.dio.academia.digital.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.br.CPF;

import java.time.LocalDate;

@Data
public class AlunoForm {

  @NotBlank(message = "Preencha o campo corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} carácteres.")
  private String nome;

  @NotBlank(message = "Preencha o campo corretamente")
  @CPF(message = "'${validatedValue}' é inválido")
  private String cpf;

  @NotBlank(message = "Preencha o campo corretamente")
  @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} carácteres.")
  private String bairro;

  @NotNull(message = "Preencha o campo corretamente.")
  @Past(message = "Data '${validatedValue}' é inválida.")
  private LocalDate dataDeNascimento;
}
