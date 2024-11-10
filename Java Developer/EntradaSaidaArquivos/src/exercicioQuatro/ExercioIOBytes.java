package exercicioQuatro;

import java.io.*;

public class ExercioIOBytes {
    public static void copiarArquivo() throws IOException {
        File file = new File("recomendacoes-copy.txt");
        String nomeArquivo = file.getName();

        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nomeArquivo));

        String nomeArquivoCopy = nomeArquivo.substring(0, nomeArquivo.indexOf("-")).concat("copyBytes.txt");
        File fileCopia = new File(nomeArquivoCopy);

        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nomeArquivoCopy));

        int line = 0;
        while((line = bis.read()) != -1){
            bos.write(line);
            bos.flush();
        }

        bis.close();
        bos.close();

        System.out.printf("Arquivo \"%s\" gerado com sucesso!", nomeArquivoCopy);

    }
}
