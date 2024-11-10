package edu.banco;

public interface IConta {

	void sacar(Float valor);
	
	void depositar(Float valor);
	
	void transferir(Float valor, IConta contaDestino);
	
	void imprimirExtrato();
}
