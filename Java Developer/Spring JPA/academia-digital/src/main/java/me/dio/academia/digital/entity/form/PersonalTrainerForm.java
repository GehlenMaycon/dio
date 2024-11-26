package me.dio.academia.digital.entity.form;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonalTrainerForm {
    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} carácteres.")
    private String nome;

    @NotBlank(message = "Preencha o campo corretamente")
    @Size(min = 3, max = 50, message = "'${validatedValue}' precisa estar entre {min} e {max} carácteres.")
    private String sobrenome;

    @NotBlank(message = "Preencha o campo corretamente.")
    private Boolean contratadoDaAcademia;

    @NotBlank(message = "Preencha o campo corretamente.")
    private Character sexo;

    @NotNull(message = "Preencha o campo corretamente.")
    @Past(message = "Data '${validatedValue}' é inválida.")
    private LocalDate dataDeNascimento;

}
