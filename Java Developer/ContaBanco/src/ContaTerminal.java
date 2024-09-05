import java.util.Scanner;

public class ContaTerminal {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Digite o número de sua conta: ");
        int numero = sc.nextInt();
        System.out.println("Digite sua agência: ");
        String agencia = sc.next();
        System.out.println("Qual o seu nome?");
        String nomeCliente = sc.next();
        System.out.println("Digite seu saldo: ");
        Double saldo = sc.nextDouble();

        System.out.printf("Olá %s, obrigado por criar uma conta em nosso banco, " +
                "sua agência é %s, conta %d e seu saldo %.2f já está disponível para saque", nomeCliente, agencia, numero, saldo);


    }

}

