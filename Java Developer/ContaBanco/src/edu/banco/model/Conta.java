package edu.banco.model;

import edu.banco.IConta;

public abstract class Conta implements IConta {

    private static final Integer AGENCIA_PADRAO = Integer.valueOf(1);
    private static Integer SEQUENCIAL = Integer.valueOf(1);

    protected Integer agencia;
    protected Integer numero;
    protected Float saldo = Float.valueOf(0);
    protected Cliente cliente;

    public Conta(Cliente cliente) {
        this.agencia = AGENCIA_PADRAO;
        this.numero = SEQUENCIAL++;
        this.cliente = cliente;
    }

    @Override
    public void sacar(Float valor) {
        saldo -= valor;
    }

    @Override
    public void depositar(Float valor) {
        saldo += valor;
    }

    @Override
    public void transferir(Float valor, IConta contaDestino) {
        this.sacar(valor);
        contaDestino.depositar(valor);
    }

    public Integer getAgencia() {
        return agencia;
    }

    public Integer getNumero() {
        return numero;
    }

    public Float getSaldo() {
        return saldo;
    }

    public Cliente getCliente(){return cliente;}

    protected void imprimirInfosComuns() {
        System.out.println(String.format("Titular: %s", this.cliente.getNome()));
        System.out.println(String.format("Agencia: %d", this.agencia));
        System.out.println(String.format("Numero: %d", this.numero));
        System.out.println(String.format("Saldo: %.2f", this.saldo));
    }
}