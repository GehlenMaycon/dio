package edu.estruturaDados.classe;

public class NoDuplo<T> {
    private NoDuplo<T> noAnterior;
    private NoDuplo<T> noSeguinte;
    private T conteudo;

    public NoDuplo(T conteudo){
        this.conteudo = conteudo;
    }

    public NoDuplo<T> getNoAnterior() {
        return noAnterior;
    }

    public void setNoAnterior(NoDuplo<T> noAnterior) {
        this.noAnterior = noAnterior;
    }

    public NoDuplo<T> getNoSeguinte() {
        return noSeguinte;
    }

    public void setNoSeguinte(NoDuplo<T> noSeguinte) {
        this.noSeguinte = noSeguinte;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    @Override
    public String toString() {
        return "NoDuplo{" +
                "conteudo=" + conteudo +
                '}';
    }
}
