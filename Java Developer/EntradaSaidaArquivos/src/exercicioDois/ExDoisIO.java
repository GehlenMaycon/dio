package exercicioDois;

import java.io.*;
import java.util.Scanner;

public class ExDoisIO {
    public static void lerEntradaEscreverDoc() throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Digite 3 recomendações de filmes: ");
        pw.flush();

        Scanner scan = new Scanner(System.in);
        String line = scan.nextLine();

        File f = new File("recomendacoes.txt");

        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        do{
            bw.write(line);
            bw.newLine();
            line = scan.nextLine();
        }while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        pw.printf("Arquivo \"%s\" foi criado com sucesso!", f.getName());
        pw.flush();
        pw.close();
        scan.close();
        bw.close();
    }
}
