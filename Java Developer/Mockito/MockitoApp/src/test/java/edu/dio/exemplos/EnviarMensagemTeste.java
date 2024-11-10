package edu.dio.exemplos;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoDaClasse(){
        Mockito.verifyNoInteractions(enviarMensagem);

        enviarMensagem.adicionarMensagem(new Mensagem("Olá mundo"));

        Mockito.verify(enviarMensagem).adicionarMensagem(new Mensagem("Olá mundo"));

        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}
