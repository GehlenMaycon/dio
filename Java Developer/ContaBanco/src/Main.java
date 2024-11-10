import edu.banco.model.Cliente;
import edu.banco.model.Conta;
import edu.banco.services.ServicesBanco;

import java.security.Provider;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean encerrar = false;
		List<Conta> contas = new ArrayList<>();
		while(!encerrar){
			Scanner input = new Scanner(System.in);
			System.out.println("Informe qual serviço gostaria de acessar: \n" +
					"1 - Abrir Conta Corrente\n" +
					"2 - Abrir Conta Poupança\n" +
					"3 - Depositar\n" +
					"4 - Transferir\n" +
					"5 - Imprimir Extrato\n" +
					"6 - Listar contas\n"+
					"X - Sair da aplicação");
			switch(input.next()){
				case "1":
                    try {
                        contas.add(ServicesBanco.criarConta("Corrente"));
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
				case "2":
                    try {
                        contas.add(ServicesBanco.criarConta("Poupanca"));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
				case "3":
                    try {
                        Conta contaDeposito = ServicesBanco.getContaPorAgenciaENroConta(contas);
						ServicesBanco.depositar(contaDeposito);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    break;
				case "4":
					try {
						System.out.println("------ Dados da Conta de Origem --------");
						Conta contaOrigem = ServicesBanco.getContaPorAgenciaENroConta(contas);
						System.out.println("------ Dados da Conta de Destino -------");
						Conta contaDest = ServicesBanco.getContaPorAgenciaENroConta(contas);
						ServicesBanco.transferir(contaOrigem, contaDest);
					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "5":
					try {
						Conta conta = ServicesBanco.getContaPorAgenciaENroConta(contas);
						ServicesBanco.imprimirExtrato(conta);
					}catch (Exception e){
						e.printStackTrace();
					}
					break;
				case "6":
					ServicesBanco.imprimirContas(contas);
					break;
				case "X":
					encerrar = true;
					break;
			}
		}

	}

}
