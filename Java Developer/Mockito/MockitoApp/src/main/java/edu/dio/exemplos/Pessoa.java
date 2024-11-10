package edu.dio.exemplos;

import java.time.LocalDate;

public class Pessoa {
    private String nome;

    private String documento;

    private LocalDate nascimento;

    private DadosLocalizacao localizacao;

    public Pessoa() {
    }

    public Pessoa(String nome, String documento, LocalDate nascimento) {
        this.nome = nome;
        this.documento = documento;
        this.nascimento = nascimento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public DadosLocalizacao getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(DadosLocalizacao localizacao) {
        this.localizacao = localizacao;
    }
}
