package exercicioUm;

import java.io.*;

public class IOCaracter {
    public static void receberTecladoImprimirConsole() throws Exception{
        System.out.println("Recomende 3 filmes: ");
        InputStream entrada = System.in;
        InputStreamReader reader = new InputStreamReader(entrada);
        BufferedReader bufferedReader = new BufferedReader(reader);
        /*Padrão decorator
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         */

        try{
            String line = bufferedReader.readLine();

            OutputStream outputStream = System.out;
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            /*Padrão decorator
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
             */

            do {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                line = bufferedReader.readLine();
            } while (!line.isEmpty());
            bufferedWriter.flush();

            bufferedReader.close();
            bufferedWriter.close();

        }catch (IOException e){
            throw new IOException("Houve um erro na leitura da entrada");
        }

    }
}
