package exercicioSeis;

import java.io.Serializable;

public class Gato implements Serializable {

    private String nome;
    private String cor;
    private int idade;
    private boolean castrado;


    public Gato() {
    }

    public Gato(String nome, String cor, int idade, boolean castrado) {
        this.nome = nome;
        this.cor = cor;
        this.idade = idade;
        this.castrado = castrado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public boolean isCastrado() {
        return castrado;
    }

    @Override
    public String toString() {
        return "Gato{" +
                "nome='" + nome + '\'' +
                ", cor='" + cor + '\'' +
                ", idade=" + idade +
                ", castrado="+castrado+
                '}';
    }
}
