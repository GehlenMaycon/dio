package edu.banco;

public enum BancosPadrao {
    BANCO_BRASIL("BB", "Banco do Brasil", "001"),
    SANTANDER("STD", "Santander", "002"),
    BRADESCO("BRD", "Bradesco", "003"),
    CAIXA_ECONOMICA("CX", "Caixa Econômica Federal", "004");

    private String abreviacao;
    private String nome;
    private String agenciaPadrao;

    private BancosPadrao(String abreviacao, String nome, String agenciaPadrao){
        this.abreviacao = abreviacao;
        this.nome = nome;
        this.agenciaPadrao = agenciaPadrao;
    }

    public String getAbreviacao() {
        return abreviacao;
    }

    public String getNome() {
        return nome;
    }

    public String getAgenciaPadrao() {
        return agenciaPadrao;
    }
}
