package edu.dio.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiDosCorreios apiDosCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosDeCadastro(){
        DadosLocalizacao dadosLocalizacao = new DadosLocalizacao("PR", "Cascavel", "Av Brasil", "Avenida", "Centro");
        Mockito.when(apiDosCorreios.buscaDadosComBaseNoCep("85814-555")).thenReturn(dadosLocalizacao);
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Maycon", "123456", LocalDate.now(), "85814-555");

        Assertions.assertEquals("Maycon", pessoa.getNome());
        Assertions.assertEquals("123456", pessoa.getDocumento());
        Assertions.assertEquals("PR", pessoa.getLocalizacao().getUf());
        Assertions.assertEquals("Avenida", pessoa.getLocalizacao().getComplemento());
    }
}
