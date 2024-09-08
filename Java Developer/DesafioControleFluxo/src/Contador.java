import java.util.Scanner;

public class Contador {
    public static void main(String[] args) {
        Scanner terminal = new Scanner(System.in);
        System.out.println("Entre com o valor do primeiro parâmetro: ");
        int parametroUm = terminal.nextInt();
        System.out.println("Entre com o valor do segundo parâmetro: ");
        int parametroDois = terminal.nextInt();

        try {
            contar(parametroUm, parametroDois);
        }catch(ParametrosInvalidosException e){
            System.out.println("O segundo parâmetro deve ser maior que o primeiro!");
        }
    }

    static void contar(int parametroUm, int parametroDois) throws ParametrosInvalidosException {
        if(parametroDois < parametroUm)
            throw new ParametrosInvalidosException();

        int controle = parametroDois - parametroUm;

        for(int x=0; x<=controle; x++){
            System.out.println("Imprimindo o numero "+x);
        }
    }
}
