package edu.dio.exemplos;

import java.util.UUID;

public class Mensagem {

    private String id;

    private String mensagem;

    public Mensagem(String mensagem) {
        this.id = UUID.randomUUID().toString();
        this.mensagem = mensagem;
    }

    public String getId() {
        return id;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
