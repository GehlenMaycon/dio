package edu.estruturaDados.classe;

public class No<T> {

    private T dado;
    private No<T> noRef = null;

    public No(T dado){
        this.dado = dado;
    }

    public No getNoRef() {
        return noRef;
    }

    public void setNoRef(No noRef) {
        this.noRef = noRef;
    }

    public T getDado() {
        return dado;
    }

    public void setDado(T dado) {
        this.dado = dado;
    }

    @Override
    public String toString() {
        return "No{" +
                "dado=" + dado +
                '}';
    }
}
