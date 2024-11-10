package edu.banco.services;

import edu.banco.model.Cliente;
import edu.banco.model.Conta;
import edu.banco.model.ContaCorrente;
import edu.banco.model.ContaPoupanca;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ServicesBanco {

    public static Conta criarConta(String tipo) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe seu nome:");
        String nome = input.next();
        Cliente cliente = new Cliente();
        cliente.setNome(nome);

        if(tipo.equals("Poupanca")) {
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
            return contaPoupanca;
        } else if (tipo.equals("Corrente")) {
            ContaCorrente contaCorrente = new ContaCorrente(cliente);
            return contaCorrente;
        }else{
            throw new Exception("Tipo de conta inválida");
        }
    }

    public static Conta getContaPorAgenciaENroConta(List<Conta> contas) throws Exception {
        Scanner input = new Scanner(System.in);
        System.out.println("Informe a agencia:");
        String agencia = input.next();
        System.out.println("Informe o número da conta:");
        String nroConta = input.next();


        Iterator<Conta> contaIterator = contas.iterator();
        while (contaIterator.hasNext()){
            Conta conta = contaIterator.next();
            if ((Integer.valueOf(agencia).equals(conta.getAgencia())) && (Integer.valueOf(nroConta).equals(conta.getNumero()))) {
                return conta;
            }
        }
        input.close();
        throw new Exception("Conta não encontrada");
    }

    public static void depositar(Conta conta){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o valor do depósito:");
        float valor = input.nextFloat();
        conta.depositar(Float.valueOf(valor));
    }

    public static void transferir(Conta contaOrig, Conta contaDest){
        Scanner input = new Scanner(System.in);
        System.out.println("Informe o valor da transferência");
        float valor = input.nextFloat();
        if(contaOrig.getSaldo() < valor){
            System.out.println("Saldo insuficiente!");
            return;
        }
        contaOrig.transferir(Float.valueOf(valor), contaDest);
    }

    public static void imprimirExtrato(Conta conta){
        conta.imprimirExtrato();
    }

    public static void imprimirContas(List<Conta> contas){
        for (Conta conta : contas) {
            System.out.println("============================");
            System.out.println(String.format("Nome: %s", conta.getCliente().getNome()));
            System.out.println(String.format("Agência: %d", conta.getAgencia()));
            System.out.println(String.format("Conta: %d", conta.getNumero()));
            System.out.println("============================");
        }

    }

}
