package exercicioTres;

import java.io.*;

public class ExTresIO {
    public static String copiarArquivo() throws IOException {
        File f = new File("recomendacoes.txt");
        String nomeArquivo = f.getName();

        Reader r = new FileReader(nomeArquivo);
        BufferedReader br = new BufferedReader(r);
        String line = br.readLine();

        String nomeArquivoCopia = nomeArquivo.substring(0, nomeArquivo.indexOf(".")).concat("-copy.txt");
        File fCopia = new File(nomeArquivoCopia);
        BufferedWriter bw = new BufferedWriter(new FileWriter(fCopia.getName()));

        do{
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        }while(!(line == null));
        bw.close();
        br.close();
        System.out.printf("Arquivo \"%s\" copiado com sucesso \n", nomeArquivo);

        return fCopia.getName();
    }

    public static void inserirInfoArquivoExistente(String arquivo) throws IOException {
        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recomende 3 livros: ");
        pw.flush();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo, true));

        do{
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }while(!line.equalsIgnoreCase("fim"));
        bw.flush();

        bw.close();
        br.close();

        System.out.printf("Informações anexadas no arquivo \"%s\" com sucesso", arquivo);

    }
}