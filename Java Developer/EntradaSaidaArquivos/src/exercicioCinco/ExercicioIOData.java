package exercicioCinco;

import java.io.*;
import java.util.Scanner;

public class ExercicioIOData {
    public static File CriarArquivoIncluirProduto() throws IOException {
        File file = new File("IODataOutput/peca-de-roupa.bin");

        PrintStream ps = new PrintStream(System.out);
        ps.flush();

        DataOutputStream dos = new DataOutputStream(new FileOutputStream(file.getPath()));

        Scanner scan = new Scanner(System.in);

        ps.println("Nome da peça: ");
        String nomePeca = scan.nextLine();
        dos.writeUTF(nomePeca);

        ps.println("Tamanho da peça (P/M/G/U): ");
        char tamanho = (char) System.in.read();
        dos.writeChar(tamanho);

        ps.println("Quantidade: ");
        int qtd = scan.nextInt();
        dos.writeInt(qtd);

        ps.println("Preço unitário: ");
        Double preco = scan.nextDouble();
        dos.writeDouble(preco);

        ps.printf("O arquivo %s foi criado com sucesso", file.getName());

        dos.close();
        scan.close();

        return file;
    }

    public static void lerProduto(File arquivo) throws IOException {
        DataInputStream dis = new DataInputStream(new FileInputStream(arquivo.getPath()));

        String nome = dis.readUTF();
        char tamanho = dis.readChar();
        int quantidade = dis.readInt();
        Double preco = dis.readDouble();

        System.out.printf("\nNome................: %s", nome);
        System.out.printf("\nTamanho.............: %s", tamanho);
        System.out.printf("\nQuantidade..........: %d", quantidade);
        System.out.printf("\nPreço...............: %f", preco);
        System.out.printf("\nValor Total.........: %f", quantidade * preco);

        dis.close();
    }
}
